package ex_03_for_roop;

import java.util.Scanner;

public class Ex_02_for_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input_num = 0;
		
		System.out.print("정수 입력 : ");
		while(true) {
			try { 
				input_num = Integer.parseInt(scan.nextLine());	
				break;
			}catch(NumberFormatException e) {
				System.out.print("옳바른 숫자를 입력헤 주세요 : ");
			}
		}
		
		for(int i = 1; i <= input_num; i++) {
			if(input_num % i == 0) {
				System.out.printf("%d ", i);
			} 
		}
	}

}
