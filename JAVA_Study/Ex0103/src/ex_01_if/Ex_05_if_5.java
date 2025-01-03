3package ex_01_if;

import java.util.Scanner;

public class Ex_05_if_5 {
	public static void main(String[] args) {
		//사용자가 구매하는 수량만큼 가격과 할인을 적용해 주는 시스템
		
		//콘솔 입력을 받기 위한 Scanner
		Scanner scan = new Scanner(System.in);
		
		final int PRICE = 10000; //단위는 won
		final int SALE_LATE = 10; //100=100%, 1=1%
		final int SALE_OB_MIN_NUM = 10;	//물건을 몇개 이상 구매헤야 할인인지
		
		//사용자가 구매하는 물건의 수량 
		int ob_num;
		//사용자가 지불하는 최종 비용
		int total_price;		
		
		System.out.print("상품의 개수를 입력하세요 : ");
		ob_num = scan.nextInt();
		scan.close();
		
		//구매한 수량에 따른 할인을 적용
		if(ob_num >= SALE_OB_MIN_NUM) {
			total_price = (int) ((PRICE * (100 - SALE_LATE) / 100) * ob_num); 
		}
		else {
			total_price = PRICE * ob_num;
		}
		
		System.out.printf("가격은 %7d입니다. ", total_price);
	}
}
