package com.tarena.test;

public class Demo {
	public static void main(String[] args) {
		System.out.println(
				s(5)); 
	}
	public static int s(int n){
		int sum = 0;
		int i;
		for(
			i=0; 
			i<n; 
			i++){
			sum+=i;
		}
		System.out.println(i); 
		return sum;
	}

}
