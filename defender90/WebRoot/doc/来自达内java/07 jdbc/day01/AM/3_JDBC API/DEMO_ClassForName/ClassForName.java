package com.tarena.jdbc;

public class ClassForName {

	public static void main(String[] args) throws Exception {
		// 通常使用类：
		/*IA a = new AImpl();
		a.fun();*/
		
		// 客户希望不改变代码，就可以更换类的实现？
		IA a = (IA)Class
				.forName("com.tarena.jdbc."+args[0])
				.newInstance(); //需要异常处理！！！
		a.fun();
		//右键-->run as-->run configurations,设置类名为参数
	}
}
interface IA{
	void fun();
}
class AImpl implements IA {
	//静态块：类一装载到内存，创建对象前就执行的语句
	static{
		System.out.println("Load AImpl...");
	}
	//构造函数：创建对象时执行的语句
	AImpl(){System.out.println("New AImpl...");}
	//普通方法：对象调用时才执行的语句
	public void fun(){System.out.println("Call AImpl's fun()...");}
}
class BImpl implements IA{
	static{
		System.out.println("Load BImpl...");
	}
	BImpl(){System.out.println("New BImpl...");}
	public void fun() {
		System.out.println("Call BImpl's fun()...");		
	}	
}
