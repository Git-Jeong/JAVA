package ex_01_if;

import java.util.Scanner;

public class Ex_03_if_3 {
	public static void main(String[] args) {
		//사용자가 입력한 점수를 기준으로 합격/불합격을 통지해주는 코드
		
		Scanner scan = new Scanner(System.in);
		
		int grade;	//사용자가 입력할 점수
		
		System.out.print("점수를 입력하세요 : ");
		grade = scan.nextInt();
		scan.close();

		//조건에 따른 처리문
		if(grade >= 60) {
			System.out.println("합격입니다. ");
		}
		else {
			System.out.println("불합격입니다. ");
		}
		
		
	}
}
 	 	