package ex_02_array_2;

import java.util.Scanner;

public class Ex_02_two_dimensional_array {
	public static final int MAX_INDEX_1 = 4;
	//2차원 배열에서 가로줄이 몇개냐는 index
	public static final int ANSWER_LINE = 0;
	//실제 정답이 들어갈 배열
	public static final int INPUT_LINE = 1;
	//사용자의 입력이 들어갈 배열
	public static final int POINT_LINE = 2;
	//헤당 문제의 배점이 들어갈 배열
	public static final int RESULT_LINE = 3;
	//정답여부를 파악할 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 
		int answer[] = {4, 5, 4, 1, 2};		//실제 정답
		int score[] = {10, 20, 30, 20, 20};	//실제 스코어
		
		int check_answer[][] = new int[MAX_INDEX_1][answer.length];
		//사용자의 점수 검증으로 돌릴 2차원 배열
		int output_score = 0;	//사용자의 총점
		
		check_answer[ANSWER_LINE] = answer; 
		check_answer[POINT_LINE] = score;

		for(int i = 0; i< answer.length; i++) {
			while(true) {
				System.out.printf("%d번 답 : ", i + 1);
				try {
					check_answer[INPUT_LINE][i] = Integer.parseInt(scan.nextLine());
					if( check_answer[INPUT_LINE][i] == check_answer[ANSWER_LINE][i] ) {
						check_answer[RESULT_LINE][i] = check_answer[POINT_LINE][i];
						output_score += check_answer[RESULT_LINE][i];
					}
					break;
				} catch (NumberFormatException e) {
					System.out.printf("정수만 입력해 주세요 : ");
				}
			}
		}
		System.out.println();
		 
		for(int i = 0; i < MAX_INDEX_1; i++ ) {
			if(i == ANSWER_LINE) {
				System.out.printf("정답 : ");
				for(int temp : check_answer[ANSWER_LINE]) {
					System.out.printf("%3d ", temp);
				}
				System.out.println();
			}
			else if(i == INPUT_LINE) {
				System.out.printf("입력 : ");
				for(int temp : check_answer[INPUT_LINE]) {
					System.out.printf("%3d ", temp);
				}
				System.out.println(); 
			}
			else if(i == POINT_LINE) {
				System.out.printf("배점 : ");
				for(int temp : check_answer[POINT_LINE]) {
					System.out.printf("%3d ", temp);
				}
				System.out.println(); 
			}
			else if(i == RESULT_LINE) {
				System.out.printf("결과 : ");
				for(int temp : check_answer[RESULT_LINE]) {
					if(temp == 0) {
						System.out.printf("%3c ", 'X');
					}
					else {
						System.out.printf("%3c ", 'O');
					}
				}
				System.out.println();
			} 
		}
		System.out.println();
		
		System.out.printf("총점 : %d\t\t", output_score);
		System.out.printf("평균 : %.2f", (float) output_score / MAX_INDEX_1);
		
		
		
		scan.close();
	}
}
