package ex_02_whlie;
import java.util.Scanner;
public class Ex_04_while_4 {
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		int total_num = 0;
		int odd_num_count = 0;
		int even_num_count = 0;
        
		while (true) {
            System.out.print("정수 입력 : ");
            String input = scan.nextLine();

            try {
                int number = Integer.parseInt(input); // 문자열을 정수로 변환
                if (number == -1) {
                    break; 
                }
                else {
                	if(number % 2 == 0) {
                		//짝수라면
                		even_num_count += 1;
                	}
                	else {
                		odd_num_count += 1;
                	}
                	total_num += number;
            		System.out.printf("누적 결과 : %d\t", total_num);
            		System.out.printf("짝수 : %d개\t", even_num_count);
            		System.out.printf("홀수 : %d개\n", odd_num_count);
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하세요."); // 숫자가 아닌 입력 처리
            }
        }
		System.out.println("종료되었습니다. ");
	}
}
