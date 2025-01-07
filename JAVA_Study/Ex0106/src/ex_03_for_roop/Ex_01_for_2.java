package ex_03_for_roop;

import java.util.Scanner;

public class Ex_01_for_2 {
	public static void main(String[] args) {
		// 구구단을 원하는 만큼만 출력하는 코드 
		
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.print("단을 입력해 주세요 : ");
		while(true) {
			try {
				input = Integer.parseInt(scan.nextLine());
				break;
			}catch (Exception e) {
				System.out.print("옳바른 숫자를 다시 입력해 주세요 : ");
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n", input, i, (input*i));
		}
		
		scan.close(); 
	}
}
