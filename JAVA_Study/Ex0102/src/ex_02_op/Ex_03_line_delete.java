package ex_02_op;
import java.util.Scanner;

public class Ex_03_line_delete {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//사용자가 입력할 변수 num_imput
		//결과값를 출력할 변수 num_result
		int num_input, num_result; 
		
		System.out.print("정수 입력 : ");
		num_input = scan.nextInt();
		
		scan.close();
		
		num_result = num_input - (num_input % 100);
		
		System.out.println("결과 값 : " + num_result);
		 
	}
}
