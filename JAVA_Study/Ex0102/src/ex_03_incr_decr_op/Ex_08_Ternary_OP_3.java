package ex_03_incr_decr_op;

import java.util.Scanner;

public class Ex_08_Ternary_OP_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input; 
		
		System.out.print("농구공의 개수를 입력하세요 : ");
		input = scan.nextInt();
		scan.close();
		 
		System.out.println("필요한 상자의 수 : " + (input % 5 == 0 ? input / 5 : input / 5 + 1 ) );
	}
}
