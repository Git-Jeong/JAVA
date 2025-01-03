package ex_03_incr_decr_op;

import java.util.Scanner;

public class Ex_07_Ternary_OP_1 {

	public static void main(String[] args) {
		//정수를 입력받아 이게 홀수인지, 짝수인지 삼항 연상을 통해 출력을 하는 코드
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.print("정수를 입력하세요 : ");
		input = scan.nextInt();
		scan.close();
		
		System.out.print(input + "는(은) ");
		System.out.println((input % 2) == 0 ? "짝수입니다." : "홀수입니다.");
	}
}
