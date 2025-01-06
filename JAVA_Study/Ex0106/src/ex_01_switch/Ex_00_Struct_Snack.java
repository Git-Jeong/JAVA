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

        SnackList[] snackList = {
            new SnackList("아우터", 700),
            new SnackList("이구동성", 1000),
            new SnackList("애그몽", 500)
        };
 
        System.out.print("금액을 입력하세요 : ");
        int input_price = scan.nextInt();

        // 입력한 가격 이하의 간식을 출력 
        for (int i = 0; i < snackList.length; i++) {
            System.out.printf("[%d] : %s : %d원%n", i+1, snackList[i].name, snackList[i].price);
        }
        System.out.println("구매할 과자의 번호를 누르세요 : ");
        int selet_snack_num = (scan.nextInt() - 1);
        
        if(input_price >= snackList[selet_snack_num].price) {
        	int output_price = input_price - snackList[selet_snack_num].price;
        	System.out.printf("잔돈은 %d원 입니다. ", output_price);
        }
        else {
        	System.out.printf("금액이 부족하여 구매할 수 없습니다. ");
        }
        

        scan.close();
    }
}
