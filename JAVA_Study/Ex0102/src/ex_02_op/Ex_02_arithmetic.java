package ex_02_op;
import java.util.Scanner; 

public class Ex_02_arithmetic extends Ex_01_Scanner {

	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		int num_1, num_2;

		System.out.print("펏 번째 정수 입력 : ");
		num_1 = scan.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		num_2 = scan.nextInt(); 
		
		System.out.println(num_1 + " + " + num_2 + " = " + (num_1 + num_2));
		System.out.println(num_1 + " - " + num_2 + " = " + (num_1 - num_2));
		System.out.println(num_1 + " * " + num_2 + " = " + (num_1 * num_2)); 
		System.out.println(num_1 + " / " + num_2 + " = " + ((double) num_1 / num_2));  

		scan.close();
	}
}