package ex_01_switch;

import java.util.Scanner;

public class Ex_00_Struct_Snack {

    static class SnackList {
        String name;
        int price;
 
        SnackList(String name, int price) {
            this.name = name;
            this.price = price;
        } 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int output_price=0;

        SnackList[] snackList = {
            new SnackList("아우터", 700),
            new SnackList("이구동성", 1000),
            new SnackList("애그몽", 500)
        };
 
        System.out.print("보유중인 금액을 입력하세요 : ");
        int input_price = scan.nextInt();

        // 데이터셋에 있는 과자의 리스트를 출력 
        for (int i = 0; i < snackList.length; i++) {
            System.out.printf("[%d] : %s : %d원\t", i+1, snackList[i].name, snackList[i].price);
            if((snackList.length  == (i+1)) || ((i+1) % 4 == 0)) {
            	System.out.println();
            } 
        }
        System.out.print("구매할 과자의 번호를 누르세요 : ");
        int selet_snack_num = (scan.nextInt() - 1);
        
        System.out.println();
        if(input_price >= snackList[selet_snack_num].price) {
        	output_price = input_price - snackList[selet_snack_num].price; 
        }
        else {
        	System.out.println("금액이 부족하여 구매할 수 없습니다. ");
        	output_price = input_price;
        }
    	System.out.printf("잔돈은 %d원 \n", output_price);
		int output_1000 = output_price / 1000;
		int output_500 = (output_price % 1000) / 500;
		int output_100 = (output_price % 500) / 100;
		if(output_1000 != 0) {
			System.out.printf("천원 : %d장 \t", output_1000);
		}
		if(output_500 != 0) {
			System.out.printf("오백원 : %d개 \t", output_500);
		}
		if(output_100 != 0) {
			System.out.printf("백원 : %d개 \t", output_100);
		}
		System.out.println();
        

        scan.close();
    }
}
