package ex_02_op;
import java.util.Scanner;

public class Ex_04_Time {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//사용자가 입력할 데이터
		int input; 
		//변환된 시간 변수
		int time_h, time_m, time_s;
		
		//사용자에게 정수값 입력을 요구
		System.out.print("초 입력 : ");
		input = scan.nextInt();
		scan.close();

		//사용자가 입력한 값을 각각의 시간단위로 변환
		time_h = input / 3600; 
		time_m = (input % 3600) / 60;
		time_s = (input % 3600) % 60; 
		
		//변환된 데이터를 출력
		System.out.println(time_h + "시간 " + time_m + "분 " + time_s + "초");
		 
	}
}
