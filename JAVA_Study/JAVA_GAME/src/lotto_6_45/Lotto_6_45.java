package lotto_6_45;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto_6_45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ticketCount; // 로또 구매 장수
        int[] lottoNumbers = new int[6]; // 로또 번호 배열

        System.out.print("구매할 로또 장수를 입력해 주세요: ");

        // 사용자 입력 값이 양의 정수인지 확인
        while (true) {
            try {
                ticketCount = Integer.parseInt(scanner.nextLine());
                if (ticketCount > 0) {
                    break;
                } else {
                    System.out.print("1 이상의 정수를 입력하세요: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("유효한 정수를 입력하세요: ");
            }
        }

        // 입력한 장수만큼 로또 번호 생성 및 출력
        for (int i = 0; i < ticketCount; i++) {
            generateLottoNumbers(lottoNumbers);	//임의로 값을 생성하는 함수
            Arrays.sort(lottoNumbers); // 배열을 오름차순 정렬 <- import java.util.Arrays;를 통해 활용가능
            printLottoNumbers(lottoNumbers);
        }
        scanner.close();
    }
    
    

    // 로또 번호 생성 함수
    private static void generateLottoNumbers(int[] lottoNumbers) {
        for (int i = 0; i < 6; i++) {
            while (true) {
                int randomNumber = (int) (Math.random() * 45) + 1; // 1부터 45까지의 랜덤 번호 생성
                boolean isDuplicate = false;

                // 중복 검사
                for (int j = 0; j < i; j++) {
                    if (lottoNumbers[j] == randomNumber) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                // 중복이 없으면 배열에 저장
                if (!isDuplicate) {
                    lottoNumbers[i] = randomNumber;
                    break;  
                }
                //중복이 있으면 숫자르 다시 발급
                else {
                	i--;
                }
                
            }
        }
    }


    // 로또 번호 출력 함수
    private static void printLottoNumbers(int[] lottoNumbers) {
        for (int i=0; i < lottoNumbers.length; i++) {
            System.out.printf("%2d ", lottoNumbers[i]);
        }
        System.out.println();
    }
}
