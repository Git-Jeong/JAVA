package lotto_6_45;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Check_Lotto_6_45 { 
    public static void num_check() {
        // 동적으로 파일 크기 맞추기 위해 파일 크기 체크
        byte[] loto_num;
        boolean readTheFile = false;
        try {
            // 사용자의 파일을 불러오기
            System.out.printf("\n로또번호 불러오기 시작\n");
            FileInputStream input = new FileInputStream("lotto_numbers.txt");
            loto_num = input.readAllBytes(); // 파일의 모든 내용을 배열에 읽음
            readTheFile = true;
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
            return;
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 에러가 발생했습니다.");
            return;
        }
        
        if (readTheFile) {
            // 파일에서 로또 번호 읽기 및 2차원 배열에 저장
            int[][] lottoNumbers = openFileTokenize(loto_num);
            int digits = getDigits(lottoNumbers.length);
            int first = 0;	//1등 카운트
            int second = 0;	//2등 카운트
            int third = 0; //3등 카운트
            int fourth = 0; //4등 카운트
            
            
            System.out.println();
            int[] temp_answer = { 1, 9, 10, 13, 35, 44 };
            // 각 번호에 대해 일치하는 숫자의 개수를 세어 비교
            for (int i = 0; i < lottoNumbers.length; i++) {
                int matchCount = 0; // 일치하는 숫자 개수

                // 각 요소 비교
                for (int j = 0; j < 6; j++) {
                    if (lottoNumbers[i][j] == temp_answer[j] ) {
                        matchCount++;
                    }
                }

                // 결과 출력
                if (matchCount == 6) {
                	System.out.printf("[%"+digits+"d] : 1등 당첨 !!!! \n", (i + 1)); 
                	first++;
                } 
                else if (matchCount == 5) {
                	System.out.printf("[%"+digits+"d] : 2등 당첨 ! \n", (i + 1)); 
                	second++;
                }  
                else if (matchCount == 4) {
                	third++;
                }
                else if (matchCount == 3) {
                	fourth++;
                }
            }
            

            // 라인 수 출력
            System.out.printf("1등 : %6d장\n", first);
            System.out.printf("2등 : %6d장\n", second);
            System.out.printf("3등 : %6d장\n", third);
            System.out.printf("4등 : %6d장\n", fourth);
            System.out.println("프로그램 종료.");
        }
    }
    
    private static int[][] openFileTokenize(byte[] loto_num) {
        // byte 배열을 문자열로 변환 (기본적으로 UTF-8로 변환)
        String data = new String(loto_num).trim();
        
        // 라인별로 분리
        String[] lines = data.split("\n");
        
        // 2차원 배열 선언 (각 줄에 최대 6개의 번호가 있다고 가정)
        int[][] lottoNumbers = new int[lines.length][6];
        
        for (int i = 0; i < lines.length; i++) {
            // 각 줄에서 ':' 뒤의 숫자들을 공백으로 구분하여 추출
            String[] parts = lines[i].split(":");
            if (parts.length > 1) {
                // ':' 뒤의 숫자들만 취하고, 공백과 숫자 외의 문자 모두 필터링
                String[] numbers = parts[1].trim().split("\\s+"); // 연속된 공백을 기준으로 분리
                // 숫자가 6개일 때만 배열에 저장
                if (numbers.length == 6) {
                    for (int j = 0; j < numbers.length; j++) {
                        try {
                            lottoNumbers[i][j] = Integer.parseInt(numbers[j]);
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 숫자 형식: " + numbers[j]);
                        }
                    }
                } else {
                    System.out.println("회차 " + (i + 1) + " 의 번호가 잘못된 형식입니다: " + parts[1]);
                }
            }
        }
        
        return lottoNumbers;
    }
    
    private static int[] getCrawLottoAnswer(int[] answer) {
    	//여기에 웹페이지에서 크롤링 해오는 코드가 필요
 
    }
    
    private static int getDigits(int lottolength) {
        int digits = 0;
        while (lottolength > 0) {
            lottolength /= 10;
            digits++;
        }
        return digits; 
    }
}
