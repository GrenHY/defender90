package day06;
import java.util.Scanner;
//����ĸ��Ϸ
public class GuessGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //��������
		for(int i=0;i<chs.length;i++){
			System.out.println(chs[i]);
		}
		int count = 0;  //���εļ�����
		while(true){
			System.out.println("�°�!");
			String str = scan.next().trim().toUpperCase();
			if("EXIT".equals(str)){ //�ж��ַ����Ƿ����
				System.out.println("�´�������!");
				break;
			}
			char[] input = str.toCharArray();//�û�����
			int[] result = check(chs,input);
			if(result[1]==chs.length){ //λ�ö�Ϊ5
				int score = chs.length*100-count*10;
				System.out.println("���ˣ��÷�Ϊ:"+score);
				break;
			}else{
				System.out.println("�ַ���:"+result[0]+"����λ�ö�:"+result[1]+"��");
				count++; //��1�μ�1
			}
		}
	}
	
	/** �������5���ַ� */
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

	/** ���������û����������Ա� */
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2];
		for(int i=0;i<chs.length;i++){
			for(int j=0;j<input.length;j++){
				if(chs[i] == input[j]){ //�ַ���
					result[0]++;
					if(i==j){  //λ�ö�
						result[1]++;
					}
					break;
				}
			}
		}
		return result;
	}

}








