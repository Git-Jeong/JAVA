package ex_01_if;

import java.util.Scanner;

public class Ex_01_if_1 {
	public static void main(String[] args) {
		//사용자가 입력한 나이에 따라 성인인지 아닌지 파악하는 코드
		Scanner scan = new Scanner(System.in); 
		int age;

		System.out.print("나이를 입ㄺ하세요 : ");
		age = scan.nextInt();
		
		if( age >= 20) {
			System.out.println("당신은 성인입니다. ");
		}  
		else {
			System.out.println("당신은 미성년자입니다. ");
		}
 
	}	
}