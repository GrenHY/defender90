package day06;
//作业讲解
public class Homework {
	public static void main(String[] args) {
		/*
		//质数:一次判断不能得出最终结果
		//补充:开关(解决一次判断不能得出最终结果的问题)
		
		//开关初始为true
		//只要有一个取余为0，就改为false---不是质数
		//当所有if判断都不为0时，flag还是true--是质数
		int num = 5;
		boolean flag = true; //假设是质数
		//for(int i=2;i<num;i++){
		//for(int i=2;i<num/2;i++){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				flag = false; //代表不是质数
				break;
			}
		}
		//if(!flag) //相当于if(flag == false)
		if(flag){ //相当于if(flag == true)
			System.out.println(num+"是质数");
		}else{
			System.out.println(num+"不是质数");
		}
		*/
		
		int count = 0;  //计数器
		for(int num=2;num<=100;num++){
			boolean flag = true;
			for(int i=2;i<=Math.sqrt(num);i++){
				if(num%i==0){
					flag = false;
					break;
				}
			}
			if(flag){
				count++; //质数个数加1
				System.out.print(num+"  ");
				if(count%10==0){
					System.out.println();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * num=9
		 *  i=2
		 *  i=3----为0
		 */
	
	}
}
