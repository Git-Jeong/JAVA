package ex_01_if;

import java.util.Scanner;

public class Ex_04_if_4 {
	public static void main(String[] args) {
		//사용자의 연령에 따른 입장료 계산
		Scanner scan = new Scanner(System.in);
		
		//JAVA에선 전처리기가 없나? 
		final int PRICE = 5000;	//단위는 won
		final int SALE_RATE = 10; //100=100%, 1=1%
		
		//사용자가 입력할 나이와, 사람의 수
		int input_peple, input_age;
		//사용자가 지불해야 되는 비용
		int total_price;
		
		System.out.println("==== 에버랜드에 오신 것을 환영합니다. ====");
		System.out.print("나이를 입력하세요 : ");
		input_age = scan.nextInt(); 
		System.out.print("인원수를 입력하세요 : ");
		input_peple = scan.nextInt();
		
		scan.close();
		
		//나이에 따른 조건문 
		if (input_age < 20) {
		    // 미성년자의 경유 할인이 존재함. 할인 비율은 SALE_RATE에 
		    total_price = PRICE * (100-SALE_RATE) / 100 * input_peple;
		} else {
		    // 성인은 별도의 할인이 없음. 이경우 가격을 PRICE
			total_price = input_peple * PRICE; 
		}
		
		//사용자가 최종적으로 지불해야 되는 비용을 출력
	    System.out.printf("총 비용은 %8d원 입니다. ", total_price);
		
	}
	
}
