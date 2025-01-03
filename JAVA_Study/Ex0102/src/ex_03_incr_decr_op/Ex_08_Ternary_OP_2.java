package ex_03_incr_decr_op;
import java.util.Scanner;

public class Ex_08_Ternary_OP_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input_1, input_2;

		System.out.print("첫 번째 정수를 입력 : ");
		input_1 = scan.nextInt();
		System.out.print("두 번째 정수를 입력 : ");
		input_2 = scan.nextInt(); 
		scan.close();

        System.out.print("두 수의 차이는 " + ((input_1 > input_2) ? 
        		input_1 - input_2 : input_2 - input_1)); 
        
	}
	
}
