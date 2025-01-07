package ex_02_roop;

import java.util.Scanner; 

public class Ex_05_do_while_1 {

	public static void main(String[] args) {    
		//사용자의 현재 몸무게와 목표 몸무게를 입력받아 주차별 감/가산을 해가는 프로그램
		Scanner scan = new Scanner(System.in);
		
		int week = 1; //첫주차 몸무게 변수
		int now_weight;	//현재 몸무게
		int target_weight; 	//목표 몸무게
		int minus_weight;	//주차별 감량하는 몸무게
		int total_minus_plus_weight;	//목표 몸무게랑 현재 몸무게의 차이를 파악해 가는 변수

		now_weight = input_now_weight(); 	//현재 사용자의 몸무게를 받아옴
		target_weight = input_target_weight();	//사용자의 목표 뭄무게를 받아옴
		total_minus_plus_weight = now_weight - target_weight;	//몸무게를 줄이는게 목표인지, 늘리는게 목표인지 판단
		
		if(total_minus_plus_weight == 0) {
			//목표랑 현재값의 입력이 같았던 경우
			System.out.println("현재 몸무게랑 목표 몸무게가 같습니다. "); 
		}
		else if(total_minus_plus_weight > 0) {
			//다이어트가 목표인 경우
			do {
				minus_weight = input_minus_plus_weight(week, true);
				total_minus_plus_weight -= minus_weight;
				week++;
			}while(total_minus_plus_weight > 0);
			System.out.printf("%dkg의 목표 달성을 축하합니다!\t", target_weight); 
		} 
		else if(total_minus_plus_weight < 0) {
			//체중을 늘리는 것이 목표인 경우
		    do {
		        minus_weight = input_minus_plus_weight(week, false);
		        total_minus_plus_weight += minus_weight;
		        week++;
		    } while(total_minus_plus_weight < 0); // 수정된 조건
		    System.out.printf("%dkg의 목표 달성을 축하합니다!\t", target_weight); 
		}  
		else {
			//불가능해 보이는 에러가 발생한 경우
			System.out.println("시스템 에러 발생");
		}
		scan.close();
	}
	
	private static int input_now_weight() {
		//사용자의 현재 몸무게를 입력받는 method(c에서의 함수)
		Scanner scan = new Scanner(System.in);
		int now_weight;
		String input;
		do {
			System.out.printf("현재 몸무게를 적으십시오(kg) : ");
			input = scan.nextLine();   //사용자가 입력한 것을 받아오는 변수
			try {
				now_weight = Integer.parseInt(input); // 문자열을 정수로 변환  
				break; // 조건에 맞으면 반복문을 종료 
			} 
			catch (NumberFormatException e) { 
				System.out.println("재입력 : "); // 숫자가 아닌 입력 처리
			}  
		} while (true); // 여기 세미콜론 추가
		return now_weight;
	}
	
	private static int input_target_weight() {
		//사용자의 목표 몸무게를 입력받는 method(c에서의 함수)
		Scanner scan = new Scanner(System.in);
		int target_weight;
		String input;
		do {
			System.out.printf("목표 몸무게를 적으십시오(kg) : ");
			input = scan.nextLine();   //사용자가 입력한 것을 받아오는 변수
			try {
				target_weight = Integer.parseInt(input); // 문자열을 정수로 변환  
				break; // 조건에 맞으면 반복문을 종료 
			} 
			catch (NumberFormatException e) { 
				System.out.println("재입력 : "); // 숫자가 아닌 입력 처리
			}  
		} while (true); // 여기 세미콜론 추가
		return target_weight;
	}
	

	private static int input_minus_plus_weight(int week, boolean mode) {
		//사용자의 주차별 몸무게 변화를 파악하는 method(c에서의 함수)
		//mode가 true인 경우 : 다이어트가 목표, false인 경우 : 몸무게 증가가 목표 
		Scanner scan = new Scanner(System.in);
		int week_weight;
		String input;
		do {
			if(mode) {
				System.out.printf("%d주차 감량한 몸무게(kg) : ", week);
			}
			else {
				System.out.printf("%d주차 증가한 몸무게(kg) : ", week);
			} 
			input = scan.nextLine();   //사용자가 입력한 것을 받아오는 변수
			try {
				week_weight = Integer.parseInt(input); // 문자열을 정수로 변환  
				break; // 조건에 맞으면 반복문을 종료 
			} 
			catch (NumberFormatException e) { 
				System.out.println("재입력 : "); // 숫자가 아닌 입력 처리
			}  
		} while (true); // 여기 세미콜론 추가 
		return week_weight;
	}
}
