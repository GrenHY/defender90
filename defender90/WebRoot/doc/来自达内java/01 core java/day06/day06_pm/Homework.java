package day06;
//��ҵ����
public class Homework {
	public static void main(String[] args) {
		/*
		//����:һ���жϲ��ܵó����ս��
		//����:����(���һ���жϲ��ܵó����ս��������)
		
		//���س�ʼΪtrue
		//ֻҪ��һ��ȡ��Ϊ0���͸�Ϊfalse---��������
		//������if�ж϶���Ϊ0ʱ��flag����true--������
		int num = 5;
		boolean flag = true; //����������
		//for(int i=2;i<num;i++){
		//for(int i=2;i<num/2;i++){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				flag = false; //����������
				break;
			}
		}
		//if(!flag) //�൱��if(flag == false)
		if(flag){ //�൱��if(flag == true)
			System.out.println(num+"������");
		}else{
			System.out.println(num+"��������");
		}
		*/
		
		int count = 0;  //������
		for(int num=2;num<=100;num++){
			boolean flag = true;
			for(int i=2;i<=Math.sqrt(num);i++){
				if(num%i==0){
					flag = false;
					break;
				}
			}
			if(flag){
				count++; //����������1
				System.out.print(num+"  ");
				if(count%10==0){
					System.out.println();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * num=9
		 *  i=2
		 *  i=3----Ϊ0
		 */
	
	}
}
