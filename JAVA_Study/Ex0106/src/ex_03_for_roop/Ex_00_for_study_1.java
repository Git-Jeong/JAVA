package ex_03_for_roop;

public class Ex_00_for_study_1 {
	public static void main(String[] args) {
		final int START = 96;
		final int MAX = 73;
		
		System.out.printf("%d부터 %d까지 출력\n", START, MAX);
		for(int i = START; i >= MAX; i--) {
			System.out.printf("%d ", i);
		}

		System.out.printf("\n\n%d부터 %d까지 홀수만 출력\n", START, MAX);
		for(int i = START; i >= MAX; i--) {
			if(i%2 == 1) {
				System.out.printf("%d ", i);
			}
		}
		
		System.out.printf("\n\n%d부터 %d까지 짝수만 출력\n", START, MAX);
		for(int i = START; i >= MAX; i--) {
			if(i%2 == 0) {
				System.out.printf("%d ", i);
			}
		}
		
	}
}
