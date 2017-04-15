package day06;
//方法演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi();//编译错误，未传参数
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		
		int num = plus();
		System.out.println("num=" + num);
		
		int n = sum(5,6);//int num1=5,int num2=6
		System.out.println("n=" + n);
	}
	
	//有返回值有参数
	public static int sum(int num1,int num2){
		int num = num1+num2;
		return num;
	}
	
	//有返回值无参数
	public static int plus(){
		//return 5.5;//编译错误，类型不区配
		return 5; //return结束方法并返回结果
	}
	
	//无返回值有参数
	public static void sayHi(String name){
		System.out.println("大家好，我叫"+name);
	}
	
	//无返回值无参数
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
	
	
	
}






