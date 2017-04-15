package com.christmas.util.sound;

import java.util.LinkedList;

/**
 * �Զ����̳߳��࣬������������
 * @author ��ʫ������
 */
public class ThreadPool extends ThreadGroup {
	/**�Ƿ���ı�־*/
	private boolean isAlive;
	private static int threadPoolID;// �̳߳صı��
	private int threadId;//�̳߳����̵߳ı��
	public LinkedList<SoundPlayer> taskQueue;// �������

	public ThreadPool(int numThreads) {
		super("ThreadPool-" + (threadPoolID++));
		// ���ø��߳����е��߳�ȫ�Ǻ�̨�߳�
		setDaemon(true);
		isAlive = true;
		// ��ʼ���������
		taskQueue = new LinkedList<SoundPlayer>();
		/**
		 * �����̳߳ص�������ʼ�������߳�,�������߳�
		 */
		for (int i = 0; i < numThreads; i++) {
			new PooledThread().start();
		}

	}

	/**
	 * ����һ���µ��������С�����ִ����һ�����õ������ThreadPool�����̡߳�
	 * 
	 * @param task
	 */
	public synchronized void runTask(SoundPlayer task) {
		// ���ִ�������ʱ���߳��Ѿ��ر��׳��쳣
		if (!isAlive) {
			throw new IllegalStateException();
		}
		if (task != null) {
			// ��ӵ��ȴ�����
			taskQueue.add(task);
			// �����ڴ˶���������ϵȴ��ĵ����̡߳�
			notify();
		}
	}

	/**
	 * �õ���ǰ����ִ�е�����
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	protected synchronized Runnable getTask() throws InterruptedException {
		// �����ǰ�������Ϊ��
		while (taskQueue.size() == 0) {
			// ����̳߳��Ѿ��ر�
			if (!isAlive) {
				// ���ؿ�
				return null;
			}
			// ����ȴ�
			wait();
		}
		// �Ƴ������ش��б�ĵ�һ������
		return taskQueue.removeFirst();
	}

	/**
	 * �رյ�ǰ�̳߳�
	 */
	public synchronized void close() {
		
		if (isAlive) {
			isAlive = false;
			// �������ȴ�����
			taskQueue.clear();
			// �жϴ��߳����е������̡߳�
			interrupt();
		}
	}

	/**
	 * �����ThreadPool���ȴ������������е��߳�����ɡ��κεȴ������ִ�С�
	 */
	public void join() {
		synchronized (this) {
			isAlive = false;
			// ����ȫ���߳�
			notifyAll();
		}
		// �ȴ������߳�ִ����
		// activeCount()���ش��߳����л�̵߳Ĺ�����
		Thread[] threads = new Thread[activeCount()];
		// ����ǰ�̳߳������еĻ�̸߳��Ƶ�threads������
		int count = enumerate(threads);
		for (int i = 0; i < count; i++) {
			try {
				// �ȴ��߳���ֹ
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * �÷���Ĭ����û���κ�ҵ������Ӧ����д�÷��������κ��ض��߳������ֹͣ
	 */
	protected void threadStopped() {

	}
	/**
	 * �Զ����߳��࣬ȥʵ���̵߳�����
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
				//��ȡһ������������
				Runnable task = null;
				try {
					task = getTask();
				} catch (InterruptedException e) {
					//�������Ͻ������߳�
					break;
				}
				//���û������
				if(task==null){
					//ֹͣѭ��
					break;
				}
				//�������� �����׳��κβ��񵽵��쳣
				try {
					task.run();
				} catch (Throwable t ) {
					uncaughtException(this, t);
				}
			}
			//�����߳�
			threadStopped();
		}
		
	}

}
