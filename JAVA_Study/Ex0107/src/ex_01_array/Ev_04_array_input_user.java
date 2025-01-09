package ex_01_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ev_04_array_input_user {
	public static void main(String[] args) {
		//사용자가 입력한 점수의 총합과 평균을 구하기
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> input_variable_array = new ArrayList<>();   
		int sum_var = 0; 
		boolean check = true;
		
		while(check) {
			System.out.printf("%d번째 입력(종료 : 'N') >> : ", input_variable_array.size() + 1);
			while (true) {
				try {
					String str_temp = scan.nextLine();
					
					//사용자가 즁료를 원하는지 파악
					if(str_temp.equalsIgnoreCase("N")) {
						check = false;
						break;
					}
					
					//사용자가 숫자를 입력했는지 확인
					int temp = Integer.parseInt(str_temp);
					//입력을 가변배열에 추가
					input_variable_array.add(temp);
					break;
					
				} catch (NumberFormatException e) {
					System.out.print("숫자만 입력해 주세요 : ");
				}
			}
		}
		System.out.println(); 

		
		//-------------사용자의 입력에 다른 총합, 평균을 출력하는 출력문 
		if(input_variable_array.size() != 0) {		
			//사용자가 입력을 했을 시
			System.out.print("입력한 정수 : ");
			
			//가변배열의 값을 하나씩 나눠서 출력
			for(int temp : input_variable_array) {
				System.out.printf("%d ", temp);
				sum_var += temp;
			}	
			System.out.println(); 
			
			//추가 정보를 출력 
			System.out.printf("입력한 횟수 : %d회 \n", input_variable_array.size());
			System.out.printf("총합 : %d \n", sum_var);
			System.out.printf("평균 : %.1f \n", ((float) sum_var / input_variable_array.size()));
		}
		else {
			//사용자가 입력한 숫자가 없을 시
			System.out.println("입력한 숫자가 없습니다. ");
		}
		
		scan.close();
	}
}
