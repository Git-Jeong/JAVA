package ex_01_if;

import java.util.Scanner;

public class Ex_02_if_2 {

	public static void main(String[] args) {
		//사용자가 적은 숫자가 3과 5의 공배수인지 확인하는 코드
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.print("정수를 입력하세요 : ");
		input = scan.nextInt();
		scan.close();
		
		if((input % 3 == 0) && (input % 5 == 0)) {
			System.out.printf("입력한 숫자 %d는 3과 5의 공배수 입니다. ", input);
		}
		else {
			System.out.printf("입력한 숫자 %d는 3과 5의 공배수가 아닙니다. ", input);
		}
	}
}