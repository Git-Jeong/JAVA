package ex_02_while_roop;

import java.util.Random;
import java.util.Scanner;

public class Ex_09_do_while_3 {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		int range = 100;
		int answer = (rd.nextInt(range) + 1);

		System.out.printf("==== 1부터 %d까지의 숫자를 맞추는 게임! ====\n", range);
		do {
			int input;
			while (true) {
				System.out.printf("1부터 %d까지의 정수를 입력하세요 >>> ", range);
				try { 
					input = Integer.parseInt(scan.nextLine()); // 문자열을 정수로 변환
					if (input > 0 && input < range) {
						break;
					}
					else {
						continue;
					}
				} catch (Exception e) {
					System.out.print("숫자만 입력해 주세요 : ");
				}
			}

			if (input == answer) {
				System.out.printf("'%d' 정답입니다!!!\n", answer);
				break;
			} else if (input < answer) {
				System.out.println("더 큰 수로 다시 시도 해보세요.");
			} else if (input > answer) {
				System.out.println("더 작은 수로 다시 시도 해보세요.");
			} else {
				System.out.println("시스템 에러입니다. ");
			}
		} while (true);

	}
}
