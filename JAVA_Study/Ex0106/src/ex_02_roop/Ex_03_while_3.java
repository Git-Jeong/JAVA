package ex_02_roop;

import java.util.Scanner;

public class Ex_03_while_3 {
	public static void main(String[] args) {
		//사용자가 입력한 숫자를 계속 누적해가는 프로그램
		//사용자가 '-1'을 입력하면 프로그램 종료 
		
		Scanner scan = new Scanner(System.in);
		int total_num = 0;
        
		while (true) {
            System.out.print("정수 입력 : ");
            String input = scan.nextLine();

            try {
                int number = Integer.parseInt(input); // 문자열을 정수로 변환
                if (number == -1) {
                    break; 
                }
                else {
                	total_num += number;
            		System.out.printf("누적 결과 : %d\n", total_num);
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하세요."); // 숫자가 아닌 입력 처리
            }
        }
		System.out.println("종료되었습니다. ");
	}
}
