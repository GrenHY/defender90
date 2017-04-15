package day06;
import java.util.Scanner;
//猜字母游戏
public class GuessGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //藏起来的
		for(int i=0;i<chs.length;i++){
			System.out.println(chs[i]);
		}
		int count = 0;  //错几次的计数器
		while(true){
			System.out.println("猜吧!");
			String str = scan.next().trim().toUpperCase();
			if("EXIT".equals(str)){ //判断字符串是否相等
				System.out.println("下次再来吧!");
				break;
			}
			char[] input = str.toCharArray();//用户输入
			int[] result = check(chs,input);
			if(result[1]==chs.length){ //位置对为5
				int score = chs.length*100-count*10;
				System.out.println("对了，得分为:"+score);
				break;
			}else{
				System.out.println("字符对:"+result[0]+"个，位置对:"+result[1]+"个");
				count++; //错1次加1
			}
		}
	}
	
	/** 随机生成5个字符 */
	public static char[] generate(){
		char[] chs = new char[5];
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];
		for(int i=0;i<chs.length;i++){
			int index;
			do{
				index = (int)(Math.random()*letters.length);
			}while(flags[index]);
			
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}

	/** 随机数组和用户输入的数组对比 */
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2];
		for(int i=0;i<chs.length;i++){
			for(int j=0;j<input.length;j++){
				if(chs[i] == input[j]){ //字符对
					result[0]++;
					if(i==j){  //位置对
						result[1]++;
					}
					break;
				}
			}
		}
		return result;
	}

}








