package ex_02_while_roop; 

import java.util.Scanner;

public class Ex_02_while_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("정수 10 이상을 입력해야 멈추는 코드");
        while (true) {
            System.out.print("정수 입력 : ");
            input = scan.nextLine();

            try {
                int number = Integer.parseInt(input); // 문자열을 정수로 변환
                if (number >= 10) {
                    break; // 10 이상이면 루프 종료
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하세요."); // 숫자가 아닌 입력 처리
            }
        }
        System.out.println("코드가 종료되었습니다.");
        scan.close();
    }
}
