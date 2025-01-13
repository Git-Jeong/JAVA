package ex_01;

import java.util.Scanner;

public class Ex_05_1_MainCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex_05_2_subCalculator calculator;
		int num1;
		int num2;

		System.out.printf("첫 번째 정수 : ");
		num1 = inputNumber(scan);
		System.out.printf("두 번째 정수 : ");
		num2 = inputNumber(scan);
		calculator = new Ex_05_2_subCalculator(num1, num2);

		System.out.printf("  초기 설정값 \n");
		System.out.printf("\t num1 : %d\n", calculator.getNum1());
		System.out.printf("\t num2 : %d\n", calculator.getNum2());
		System.out.println();

		System.out.printf("  값 수정 : \n");
		System.out.printf("\t첫 번째 정수 : ");
		calculator.setNum1(inputNumber(scan));
		System.out.printf("\t두 번째 정수 : ");
		calculator.setNum2(inputNumber(scan));
		System.out.println();

		System.out.println("더한 값 : " + calculator.sum());
		System.out.println("뺀 값 : " + calculator.sub());
		System.out.println("곱한 값 : " + calculator.mul());
		System.out.println("나눈 값 : " + calculator.div());

		scan.close();
		calculator = null;
	}

	private static int inputNumber(Scanner scan) {
		int result = 0;
		while (true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				break;
			} catch (Exception e) {
				System.out.printf("재입력 : ");
			}
		}
		return result;
	}
}
