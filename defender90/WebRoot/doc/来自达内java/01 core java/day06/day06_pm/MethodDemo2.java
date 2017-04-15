package day06;

//方法演示
public class MethodDemo2 {
	//方法可以嵌套调用，但不能嵌套定义(5要素)
	public static void main(String[] args) {
		a();
	}
	public static void a(){
		System.out.println(111);
		b(); //a()方法中调用b()
		System.out.println(333);
	}
	public static void b(){
		System.out.println(222);
	}

	public static void c(){
		//return;:结束方法
		return;
	}
	public static int plus(int num1,int num2){
		//return 值;:结束方法并返回结果
		return num1+num2;
	}
	
}
