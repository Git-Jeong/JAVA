package ex_03_for_roop;

public class Ex_01_for_2 {
	public static void main(String[] args) {
		// 구구단을 원하는 만큼만 출력하는 코드
		
		final int START_1 = 2;
		final int START_2 = 1;
		final int MAX_1 = 2;
		final int MAX_2 = 9;
		
		for(int i = START_1; i <= MAX_1; i++) {
			for(int j = START_2; j <= MAX_2; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i*j));
			}
		}
	}
}
