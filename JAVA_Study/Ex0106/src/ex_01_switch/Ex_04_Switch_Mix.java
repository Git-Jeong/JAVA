package ex_01_switch;

import java.util.Scanner;

public class Ex_04_Switch_Mix {
	public static void main(String[] args) {
		//사용자가 입력한 액수에 맞는 잔돈을 반환해 주는 프로그램
		//배열을 사용하지 않은 버전
		Scanner scan = new Scanner(System.in);
		int input_price;
		int input_snack_num;
		int output_coin=0;
		
		String snack_name_1 = "아우터";
		String snack_name_2 = "이구동성";
		String snack_name_3 = "에그몽";
		
		int snack_price_1 = 700;
		int snack_price_2 = 1000;
		int snack_price_3 = 500;
		
		System.out.print("가지고 있는 금액을 입력 : ");
		input_price = scan.nextInt();

		//배열에 넣고 반복문으로 돌리면 간단해 보이느데 이걸 돌려서 쓰니까 이상해지네 ㅋㅋ
		System.out.println(); 
		System.out.printf("1. %s(%d원)\t 2. %s(%d원)\t 3. %s(%d원)\n", 
				snack_name_1, snack_price_1, 
				snack_name_3, snack_price_2,
				snack_name_3, snack_price_3);
		
		System.out.print("구매할 과자의 번호를 입력해 주세요 : ");
		input_snack_num = scan.nextInt();
		
		System.out.println();
		switch(input_snack_num) {
		case 1 -> output_coin = input_price - snack_price_1; 
		case 2 -> output_coin = input_price - snack_price_2; 
		case 3 -> output_coin = input_price - snack_price_3; 
		default -> System.out.println("입력 에러입니다. "); 
		}
		if(output_coin < 0) {
			output_coin = input_price;
			System.out.print("돈이 부족합니다. ");
		}
		else {
			System.out.print("구매에 성공했습니다. ");  
		}

		System.out.printf("잔돈 : %d원\n", output_coin );
		int output_1000 = output_coin / 1000;
		int output_500 = (output_coin % 1000) / 500;
		int output_100 = (output_coin % 500) / 100;
		if(output_1000 != 0) {
			System.out.printf("천원 : %d장 \t", output_1000);
		}
		if(output_500 != 0) {
			System.out.printf("오백원 : %d개 \t", output_500);
		}
		if(output_100 != 0) {
			System.out.printf("백원 : %d개 \t", output_100);
		}
		
		scan.close();
	}
}
