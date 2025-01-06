package ex_01_switch;

import java.util.Scanner;

public class Ex_02_Switch_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input_Score;
		
		System.out.print("점수를 입력해 주세요(Max : 100) : ");
		input_Score = scan.nextInt();
 
		switch (input_Score / 10)  {
			case 10 : 
			case 9 :
				System.out.println("당신의 학점은 A입니다. ");
				break;
			case 8 :
				System.out.println("당신의 학점은 B입니다. ");
				break; 
			case 7 :
				System.out.println("당신의 학점은 C입니다. ");
				break;  
			default:
				System.out.println("당신의 학점은 D입니다. ");
				break;
		}
		
		scan.close();
	}
}
