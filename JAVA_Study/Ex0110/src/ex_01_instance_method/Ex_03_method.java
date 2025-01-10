package ex_01_instance_method;

import java.util.Random;
import java.util.Scanner;

public class Ex_03_method {
	private static String check_list[] = {"가위", "바위", "보"};
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.println("==== 가위바위보 게임 ====");
		int fail_count = 5;
		
		while(true) {
			System.out.print("사용자 : "); 
			String user = play_user(scan);
			
			String pc = play_pc(rd);
			System.out.printf("컴퓨터 : %s", pc); 
			
			int result = play_check(user, pc);
			if(result == 1) {
				//사용자가 이겼다면
				System.out.println();
				System.out.println("== 승리 ==");
			}
			else if(result == -1){
				//사용자의 패배
				fail_count--;
				System.out.println();
				System.out.println("== 패배 ==");
				System.out.printf("== 남은 목숨 : %d ==\n", fail_count);
			}
			else {
				//무승부
				System.out.println();
				System.out.println("== 무승부 ==");
			}
			
			if(fail_count == 0) {
				break;
			}
		}
		
		if(fail_count == 0) {
			System.out.println("목숨이 없어 게임이 종료됩니다. ");
		}else {
			System.out.println("시스템 에러");
		}
		
		scan.close();
	}

	private static int play_check(String user, String pc) { 
		//승 = 1, 무 = 0, 페 = -1
		int result = 0;
		if(user.equals("가위")) {
			//사용자가 낸게 가위
			if(pc.equals("바위")) {
				//컴퓨터는 바위
				result = -1;
			}
			else if(pc.equals("보")) {
				result = 1;
			}
			else {
				result = 0;
			}  
		}
		else if(user.equals("바위")) {
			if(pc.equals("보")) {
				//컴퓨터는 바위
				result = -1;
				//패배
			}
			else if(pc.equals("가위")) {
				result = 1;
				//승
			}
			else {
				result = 0;
			}  
		}
		else {
			//사용자가 보
			if(pc.equals("가위")) {
				//컴퓨터는 가위
				result = -1;
				//패배
			}
			else if(pc.equals("바위")) {
				result = 1;
				//승
			}
			else {
				result = 0;
			}  
		} 
		return result;
	}
	
	private static String play_user(Scanner scan) { 
		String result = null; 
		 
		while(true) {
			result = scan.nextLine();
			for(int i=0; i < check_list.length; i++) {
				if(result.equals(check_list[i])) {					
					return result; 
				}
			}
			System.out.printf("다시 입력 : ");
		} 
	}
		
	private static String play_pc(Random rd) { 
		int temp = rd.nextInt(3) + 1;
		String result = null;
		switch(temp){
		case 1: 
			result = "가위";
			break;
		case 2:
			result = "바위";
			break;
		case 3:
			result = "보";
			break;
		default:
			System.out.println("시스템 에러");
			result = "err";
			break;
		}
		return result;
	}
}
