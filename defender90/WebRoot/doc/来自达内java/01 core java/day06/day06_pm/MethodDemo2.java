package day06;

//������ʾ
public class MethodDemo2 {
	//��������Ƕ�׵��ã�������Ƕ�׶���(5Ҫ��)
	public static void main(String[] args) {
		a();
	}
	public static void a(){
		System.out.println(111);
		b(); //a()�����е���b()
		System.out.println(333);
	}
	public static void b(){
		System.out.println(222);
	}

	public static void c(){
		//return;:��������
		return;
	}
	public static int plus(int num1,int num2){
		//return ֵ;:�������������ؽ��
		return num1+num2;
	}
	
}
