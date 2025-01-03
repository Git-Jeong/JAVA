package ex_02_if_else;

import java.util.Scanner;

public class Ex_01_if_else_1 {
	public static void main(String[] args) {
		//사용자의 점수에 따라 학점을 구분해 주는 코드
		Scanner scan = new Scanner(System.in);
		
		//사용자가 입력할 점수
		int total_score;

		System.out.print("점수를 입력해 주세요 : ");
		total_score = scan.nextInt(); 
		scan.close();

		//점수에 따라 학점을 부여
		if( total_score >= 90 ) {
			System.out.println("A학점 입니다!");
		}
		else if( total_score >= 80 ) {
			System.out.println("B학점 입니다!");
		}
		else if( total_score >= 70 ) {
			System.out.println("C학점 입니다!");
		} 
		else {
			System.out.println("D학점 입니다!");
		}

	}	
	
}
