package ex_02_op;

import java.util.*;

public class Ex_lotto_6_45 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int input_num; 
        
        while (true) {
            try {
                System.out.print("구매할 장수를 입력해 주세요 : ");
                input_num = scan.nextInt();
                if (input_num <= 0) {
                    System.out.println("err. Enter a positive number.");
                    continue;
                }
                scan.close();
                break; // 올바른 입력 시 루프 종료
            } catch (java.util.InputMismatchException e) {
                System.out.println("err. Enter your number_1");
                scan.nextLine(); // 입력 버퍼 비우기
            }
        }

        for (int i = 0; i < input_num; i++) {
            List<Integer> lottoList = new ArrayList<>();
            Random random = new Random();

            while (lottoList.size() < 6) {
                int num = random.nextInt(45) + 1; // 1~45 사이 랜덤 숫자 생성
                if (!lottoList.contains(num)) {
                    lottoList.add(num); // 중복이 아니면 추가
                }
            }

            Collections.sort(lottoList); // 정렬
            System.out.println("로또 번호 " + (i + 1) + " : " + lottoList);
            
            if (((i + 1) % 5) == 0) {
                System.out.println();
            }
        }
    }
}
