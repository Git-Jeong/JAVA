package ex_02_whlie;

import java.util.Random;
import java.util.Scanner;

public class Ex_07_do_while_2 {
	public static void main(String[] args) {
		/*
		MAX 이하의 임의의 숫자를 2개 생성한다.
		사용자가 정답을 맞추면 계속하고, 틀리면 게임에서 패배한다.
		만약 패배를 한다고 해도, 사용자에게 게임 재시작 여부를 물어봐서 재시작, 혹은 종료 여부를 최종 결정한다.
		*/ 
		
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		final int MAX = 10;		//Random 숫자의 최댓값
		
		int success_count = 0; 
		boolean game_fail = false;	//이게 true가 되면 게임이 종료되는 구조
		
		System.out.println("====== PLus Game ======");
		
		do {
			int n_1  = rd.nextInt(MAX) + 1;
			int n_2 = rd.nextInt(MAX) + 1;
			int answer = n_1 + n_2;
			System.out.printf("%d + %d = ", n_1, n_2);
			int input_num;
			while(true){
				try { 
					input_num = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException e) {
	                System.out.print("숫자만 입력해 주세요 : ");
	            }
			}
			
			if(answer == input_num) {
				success_count++;
				System.out.printf("Success ! ! \n\n");
			}
			else { 
				System.out.println("Fail...");
				System.out.print("계속 하시겠습니까? (네 'Y', 아니요 'N') : ");
				while(true) { 
	                char input_newgame = scan.next().charAt(0); 
	                /*
	                 * 또는 
	                 * String 변수명 scan.next();로 입력을 받은 다음 
	                 * 변수명.equals()로 기호를 확인하거나	(ex : 변수명.equals("Y") )
	                 * 변수명.equalsIgnoreCase() 를 통해 대소문자 구분없이 비교가 가능 (ex : 변수명.equalsIgnoreCase("Y") )
	                 * */
					if( (input_newgame == 'Y') || (input_newgame == 'y')) {
						success_count = 0;
						break;
					}
					else if( (input_newgame == 'N') || (input_newgame == 'n')) { 
						game_fail = true;
						break;
					} 
					else {
						System.out.print("다시 입력해 주세요 : ");
					}
				}
				System.out.println();
				
			}
			
		}while(!game_fail);
		
		System.out.printf("게임을 종료합니다. \n");
		System.out.printf("맞춘 정답의 수 : %d문제\n", success_count);
		
		rd.getClass();
		scan.close();
	} 
}
