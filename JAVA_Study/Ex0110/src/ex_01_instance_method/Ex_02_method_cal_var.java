package ex_01_instance_method;

import java.util.ArrayList;
import java.util.Scanner;


public class Ex_02_method_cal_var {
	public static void main(String[] args) {
		// 사용자가 입력한 정수 2개와, 연산자를 활용한 계산기 코드 
		
		ArrayList<Cal> cal_list = new ArrayList<>(); // 게산을 가변 배열
		//이렇게도 되나??
		
		Scanner scan = new Scanner(System.in);
		int input_num1 = 0;
		int input_num2 = 0;
		String op;
		boolean cal_service_loop = true;
		
		do{  
			System.out.printf("첫 번재 정수를 입력 : ");
			input_num1 = input_num(scan);

			System.out.printf("연산자를 입력 : ");
			op = input_op(scan);
			
			System.out.printf("두 번째 정수를 입력 : ");
			input_num2 = input_num(scan);
 

			cal_list.add(new Cal(input_num1, input_num2, op));
			
			int index = cal_list.size() - 1;
			calPrintOneLine(cal_list, index);
			 
			
			//재시작여부 판단
			while(true) {
				System.out.println();
				System.out.printf("재시작 : 'Any Key', 종료 : 'N', 과거기록 'H' >>> ");
				String temp = scan.nextLine(); 
				if(temp.equalsIgnoreCase("N")) {
					cal_service_loop = false;
					break;
				}
				else if(temp.equalsIgnoreCase("H")) {
					//사용자가 과거 기록을 보게 하는 코드
					calPrintAllLine(cal_list); 
				}
				else {
					break;
				}
			}
		} while(cal_service_loop);
		
		//시스템이 종료된 후
		if(!cal_service_loop) {
			System.out.println("시스템이 정상적으로 종료되었습니다. ");
		}else {
			System.out.println("시스템에 에러가 발생했습니다. ");
		} 
		
		scan.close(); 
	}
	 
	
	public static void calPrintAllLine(ArrayList<Cal> cal_list) {
		//사용자가 지정한 index값의 결과값을 출력하는 함수

		for(int index = 0; index < cal_list.size(); index++) {
			int ouptup_num_1 = cal_list.get(index).num_1;
			int ouptup_num_2 = cal_list.get(index).num_2;
			String ouptup_op = cal_list.get(index).op;
			int ouptup_result = cal_list.get(index).result; 
			//입력값 출력  
			System.err.printf("[%3d] : ", index+1);
			System.out.printf("%d %s %d = %d\n", ouptup_num_1, ouptup_op, ouptup_num_2, ouptup_result);
		} 
	}
	
	public static void calPrintOneLine(ArrayList<Cal> cal_list, int index) {
		//사용자가 지정한 index값의 결과값을 출력하는 함수
		int ouptup_num_1 = cal_list.get(index).num_1;
		int ouptup_num_2 = cal_list.get(index).num_2;
		String ouptup_op = cal_list.get(index).op;
		int ouptup_result = cal_list.get(index).result; 
		//입력값 출력  
		System.out.printf("%d %s %d = %d\n", ouptup_num_1, ouptup_op, ouptup_num_2, ouptup_result);
	}
	

	static class Cal { 
		int num_1;
		int num_2;
		String op;
		int result;

		Cal(int num_1, int num_2, String op) {
			this.num_1 = num_1;
			this.num_2 = num_2;
			this.op = op;
			this.result = cal_1();
			// 검증된 데이터가 들어가 있으므로 연산을 해도 됨.
		}

		private int cal_1() {
			int result = 0; // 결과를 초기화
			switch (op) {
			case "+":
				result = num_1 + num_2;
				break;
			case "-":
				result = num_1 - num_2;
				break;
			case "*":
				result = num_1 * num_2;
				break;
			case "/":
				if (num_2 != 0) {
					result = num_1 / num_2;
				} else {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				break;
			case "%":
				if (num_2 != 0) {
					result = num_1 % num_2;
				} else {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				break;
			default:
				System.out.println("입력한 연산자가 유효하지 않습니다.");
				break;
			}
			return result; // 결과 반환
		}
	}

	public static int input_num(Scanner scan) {
		// 사용자의 숫자 입력을 위한 함수
		int result = 0;
		while (true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print("정수만 입력해 주세요 : ");
			}
		}
		return result;
	}

	public static String input_op(Scanner scan) {
		// 사용자의 연산자를 입력하도록 하는 함수

		String op_check_list[] = { "+", "-", "/", "*", "%" };
		// 옳바른 연산자가 들어왔는지 체크하기 위한 배열

		String result;

		while (true) {
			result = scan.nextLine();

			for (String op : op_check_list) {
				if (result.equals(op)) {
					return result;
				}
			}

			System.out.printf("유효한 연산자를 입력해 주세요 : ");
		}
	}
}
