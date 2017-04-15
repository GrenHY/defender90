package com.christmas.util.sound;

import java.util.LinkedList;

/**
 * 自定义线程池类，用来运行任务
 * @author 四诗风雅颂
 */
public class ThreadPool extends ThreadGroup {
	/**是否存活的标志*/
	private boolean isAlive;
	private static int threadPoolID;// 线程池的编号
	private int threadId;//线程池中线程的编号
	public LinkedList<SoundPlayer> taskQueue;// 任务队列

	public ThreadPool(int numThreads) {
		super("ThreadPool-" + (threadPoolID++));
		// 设置该线程组中的线程全是后台线程
		setDaemon(true);
		isAlive = true;
		// 初始化任务队列
		taskQueue = new LinkedList<SoundPlayer>();
		/**
		 * 根据线程池的数量初始化所有线程,并启动线程
		 */
		for (int i = 0; i < numThreads; i++) {
			new PooledThread().start();
		}

	}

	/**
	 * 请求一个新的任务运行。任务执行下一个可用的在这个ThreadPool空闲线程。
	 * 
	 * @param task
	 */
	public synchronized void runTask(SoundPlayer task) {
		// 如果执行任务的时候，线程已经关闭抛出异常
		if (!isAlive) {
			throw new IllegalStateException();
		}
		if (task != null) {
			// 添加到等待队列
			taskQueue.add(task);
			// 唤醒在此对象监视器上等待的单个线程。
			notify();
		}
	}

	/**
	 * 得到当前正在执行的任务
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	protected synchronized Runnable getTask() throws InterruptedException {
		// 如果当前任务队列为空
		while (taskQueue.size() == 0) {
			// 如果线程池已经关闭
			if (!isAlive) {
				// 返回空
				return null;
			}
			// 否则等待
			wait();
		}
		// 移除并返回此列表的第一个任务
		return taskQueue.removeFirst();
	}

	/**
	 * 关闭当前线程池
	 */
	public synchronized void close() {
		
		if (isAlive) {
			isAlive = false;
			// 清楚任务等待队列
			taskQueue.clear();
			// 中断此线程组中的所有线程。
			interrupt();
		}
	}

	/**
	 * 闭这个ThreadPool并等待所有正在运行的线程来完成。任何等待任务的执行。
	 */
	public void join() {
		synchronized (this) {
			isAlive = false;
			// 唤醒全部线程
			notifyAll();
		}
		// 等待所有线程执行完
		// activeCount()返回此线程组中活动线程的估计数
		Thread[] threads = new Thread[activeCount()];
		// 将当前线程池中所有的活动线程复制到threads数组中
		int count = enumerate(threads);
		for (int i = 0; i < count; i++) {
			try {
				// 等待线程终止
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * 该方法默认是没有任何业务，子类应该重写该方法用于任何特定线程任务的停止
	 */
	protected void threadStopped() {

	}
	/**
	 * 自定义线程类，去实现线程的运行
	 * @author Administrator
	 *
	 */
	private class PooledThread extends Thread {
		public PooledThread(){
			super(ThreadPool.this,
	                "PooledThread-" + (threadId++));
		}
		public void run(){
			while(!isInterrupted()){
				//获取一个任务并且运行
				Runnable task = null;
				try {
					task = getTask();
				} catch (InterruptedException e) {
					//如果被打断结束该线程
					break;
				}
				//如果没有任务
				if(task==null){
					//停止循环
					break;
				}
				//运行任务 并且抛出任何捕获到的异常
				try {
					task.run();
				} catch (Throwable t ) {
					uncaughtException(this, t);
				}
			}
			//结束线程
			threadStopped();
		}
		
	}

}
