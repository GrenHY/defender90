package com.defender.common;

public class ddd {
	public static void main(String[] args) {
		int c = 0;
		for (int i = 0;i<10;i++) {
				c++;
				if (c==5) {
					
					break;
				} if (c==9) {
					System.out.println("c="+25);
					break;
				}
		}
		
		System.out.println("c="+20);
		
	}

}
