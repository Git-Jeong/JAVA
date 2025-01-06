package ex_01_switch;

import java.util.Scanner;

public class Ex_03_Switch_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input_num;
		
		System.out.printf("몇 월 인가요? : ");
		input_num = scan.nextInt();
		
		System.out.printf("%2d월은 ", input_num);
		switch(input_num) {
			case 12, 1, 2 -> System.out.println("겨울입니다. "); 
			case 3, 4, 5 -> System.out.println("봄입니다. "); 
			case 6, 7, 8  -> System.out.println("여름입니다. "); 
			case 9, 10, 11  -> System.out.println("가을입니다. "); 
			default -> System.out.println("에러입니다. "); 
		} 
	}
}
