package lotto_6_45;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Make_Lotto_6_45 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int ticketCount; // 로또 구매 장수
			
			System.out.println("====프로그램 시작====");
			System.out.print("구매할 로또 장수를 입력해 주세요: ");

			// 사용자 입력 값이 양의 정수인지 확인
			while (true) {
				try {
					ticketCount = Integer.parseInt(scanner.nextLine());
					if ((ticketCount > 0) && (ticketCount <= 9000000)) {
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
				Arrays.sort(lottoTicket); // 각 티켓 번호를 오름차순 정렬
			}

			try (FileWriter writer = new FileWriter("lotto_numbers.txt")) {
				for (int i = 0; i < lottoNumbers.length; i++) {
					/*
					 * if ((i + 1) % 5 == 1) { System.out.print11ln(); }
					 * System.out.printf("[%3d] : ", i + 1);
					 */
					writer.write(String.format("[%3d] : ", i + 1));
					printLottoNumbers(lottoNumbers[i], writer);
				}
				System.out.println();
			} catch (IOException e) {
				System.err.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
			}

			System.out.println("번호 생성이 완료되었습니다. ");

			Check_Lotto_6_45 lotto_num_check = new Check_Lotto_6_45();
			lotto_num_check.num_check(); // 로또 당첨내역 조회
			System.out.printf("\n\n");
		}
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
			}
		}
	}

	// 로또 번호 출력 및 파일 쓰기 함수
	private static void printLottoNumbers(int[] lottoNumbers, FileWriter writer) throws IOException {
		for (int i = 0; i < lottoNumbers.length; i++) {
			// System.out.printf("%2d ", lottoNumbers[i]);
			writer.write(String.format("%2d ", lottoNumbers[i]));

		}

		// System.out.println();
		writer.write("\n");
	}
}
