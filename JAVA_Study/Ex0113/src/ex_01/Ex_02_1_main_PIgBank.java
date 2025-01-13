package ex_01;

import java.util.Scanner;

public class Ex_02_1_main_PIgBank {

	public static void main(String[] args) { 
		//파일(class)를 분리하여 외부의 class에 접근하는 코드
		Scanner scan = new Scanner(System.in);
		Ex_02_2_PigBank pigbank = new Ex_02_2_PigBank();
		
		pigbank.money = 0;  
		int select_option = 0;
		
		while(true) {
			System.out.printf("잔액 : '1',\t 입금 : '2' \n");
			System.out.printf("출금 : '3',\t 종료 : '9' \n");
			System.out.printf("원하시는 번호를 클릭해 주세요 : ");
			
			select_option = input_option(scan);
			
			if(select_option == 1) {
				//잔액 조회
				System.out.println("현재 잔액 : " + pigbank.money);
			}
			else if (select_option == 2) {
				//입금
				System.out.printf("입금할 금액을 입력 : ");
				int temp = input_number(scan);
				pigbank.addMoney(temp);
			}
			else if (select_option == 3) {
				//출금
				System.out.printf("출금할 금액을 입력 : ");
				int temp = input_number(scan);
				if(pigbank.money < temp) {
					//잔약이 부족한 경우
					System.out.println("잔액 부족. 뒤로 돌아갑니다."); 
				}
				else {						
					//잔액이 충분
					pigbank.minusMoney(temp);  
				} 
			}
			else if(select_option == 9) {
				//서비스 종료
				break;
			}
			else {
				//입력의 예외
				System.out.println("시스템에 에러가 발생했습니다. ");
				System.out.println("시스템을 다시 시작합니다. ");
			} 
			System.out.println();
		} 
		scan.close();
	}
	
	
	private static int input_option(Scanner scan) {
		int select_option;
		while(true) {
			try {
				select_option = Integer.parseInt(scan.nextLine());
				if(1 <= select_option && select_option <= 3) {
					break;
				}
			} catch (Exception e) {
				System.out.print("다시 선택해 주세요 : ");
			}
		}
		return select_option;
	}
	
	private static int input_number(Scanner scan) {
		int result;
		while(true) {
			try {
				result = Integer.parseInt(scan.nextLine()); 
				if(result < 0) {
					System.out.printf("양수 입력 : ");
				}
				else {					
					break; 
				}
			} catch (Exception e) {
				System.out.print("다시 선택해 주세요 : ");
			}
		}
		return result;
	}

}
