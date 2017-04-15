package com.tarena.jdbc;

public class ClassForName {

	public static void main(String[] args) throws Exception {
		// ͨ��ʹ���ࣺ
		/*IA a = new AImpl();
		a.fun();*/
		
		// �ͻ�ϣ�����ı���룬�Ϳ��Ը������ʵ�֣�
		IA a = (IA)Class
				.forName("com.tarena.jdbc."+args[0])
				.newInstance(); //��Ҫ�쳣��������
		a.fun();
		//�Ҽ�-->run as-->run configurations,��������Ϊ����
	}
}
interface IA{
	void fun();
}
class AImpl implements IA {
	//��̬�飺��һװ�ص��ڴ棬��������ǰ��ִ�е����
	static{
		System.out.println("Load AImpl...");
	}
	//���캯������������ʱִ�е����
	AImpl(){System.out.println("New AImpl...");}
	//��ͨ�������������ʱ��ִ�е����
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
