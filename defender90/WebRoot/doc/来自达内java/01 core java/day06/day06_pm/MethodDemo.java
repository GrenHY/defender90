package day06;
//������ʾ
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi();//�������δ������
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		
		int num = plus();
		System.out.println("num=" + num);
		
		int n = sum(5,6);//int num1=5,int num2=6
		System.out.println("n=" + n);
	}
	
	//�з���ֵ�в���
	public static int sum(int num1,int num2){
		int num = num1+num2;
		return num;
	}
	
	//�з���ֵ�޲���
	public static int plus(){
		//return 5.5;//����������Ͳ�����
		return 5; //return�������������ؽ��
	}
	
	//�޷���ֵ�в���
	public static void sayHi(String name){
		System.out.println("��Һã��ҽ�"+name);
	}
	
	//�޷���ֵ�޲���
	public static void say(){
		System.out.println("��Һã��ҽ�WKJ");
	}
	
	
	
}






