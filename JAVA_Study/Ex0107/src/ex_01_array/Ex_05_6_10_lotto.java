package ex_01_array;
 
import java.util.Arrays;
import java.util.Scanner; 


public class Ex_05_6_10_lotto {
	public static final int MAX_RANDOM_NUM = 10;
	
	public static void main(String[] args) { 
		//사용자가 구매한 만큼 로또를 구매하는 코드
		
		Scanner scanner = new Scanner(System.in); 
		
		int ticketCount; // 로또 구매 장수 
		
		System.out.println("====프로그램 시작====");
		System.out.print("구매할 로또 장수를 입력해 주세요: ");

		// 사용자 입력 값이 양의 정수인지 확인
		while (true) {
			try {
				ticketCount = Integer.parseInt(scanner.nextLine());
				if ((ticketCount > 0) && (ticketCount <= 100000)) {
					break;
				} else {
					System.out.print("유효한 정수를 입력하세요 : ");
				}
			} catch (NumberFormatException e) {
				System.out.print("숫자만 입력해 주세요 : ");
			}
		} 

		// 로또 번호 배열 생성
		int[][] lottoNumbers = new int[ticketCount][6];

		// 입력한 장수만큼 로또 번호 생성 및 출력 
		for (int[] lottoTicket : lottoNumbers) {
			generateLottoNumbers(lottoTicket); // 각 티켓에 로또 번호 생성 
		}
 
		//사용자가 구매한 장수의 자릿수를 저장
		int digits = getDigits(ticketCount - 1);
        
		for (int i = 0; i < lottoNumbers.length; i++) {  
			if ((i + 1) % 5 == 1) { 
				System.out.println();
			}
        	System.out.printf("[%"+digits+"d] :", i); 
			printLottoNumbers(lottoNumbers[i]);
		}
		
		System.out.println();

		System.out.println("번호 생성이 완료되었습니다. ");
		scanner.close();
	}

	//구매한 장수만큼의 자릿수를 구하는 변수
    private static int getDigits(int lottolength) {
        int digits = 0;
        while (lottolength > 0) {
            lottolength /= 10;
            digits++;
        }
        return digits; 
    }
    
	// 로또 번호 생성 함수
	private static void generateLottoNumbers(int[] lottoNumbers) {
		for (int i = 0; i < 6; i++) {
			while (true) {
				int randomNumber = (int) (Math.random() * MAX_RANDOM_NUM) + 1; // 1부터 45까지의 랜덤 번호 생성
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
			} 
		} 
		
		Arrays.sort(lottoNumbers);	//저장한 배열을 오름차순 정렬
	}

	// 로또 번호 출력 및 파일 쓰기 함수
	private static void printLottoNumbers(int[] lottoNumbers) {
		for (int i = 0; i < lottoNumbers.length; i++) {
			System.out.printf("%2d ", lottoNumbers[i]);  
		}
		System.out.println(); 
	}
} 
