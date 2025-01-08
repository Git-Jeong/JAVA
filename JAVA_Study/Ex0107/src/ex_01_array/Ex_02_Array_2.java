package ex_01_array;

import java.util.Random;
import java.util.ArrayList;

public class Ex_02_Array_2 {
	public static void main(String[] args) {
		// 임의의 값(1~100)을 5개 불러오기 
		// 홀수만 가변 배열에 저장
		// 가변 배열의 값을 출력하고, 총 홓수가 몇 개 인지 출력

		Random rd = new Random();
		final int MAX_ARRAY_INDEX = 5;
		final int MAX_RANDOM_NUM = 100;
 
		ArrayList<Integer> oddNumbers = new ArrayList<>(); // 홀수를 담을 가변 배열

		System.out.printf("배열 array에 들어 있는 홀수는 ");
		for (int i = 0; i < MAX_ARRAY_INDEX; i++) {
			int temp = rd.nextInt(MAX_RANDOM_NUM) + 1;
			if (temp % 2 == 1) {
				oddNumbers.add(temp); // 홀수만 추가 
			}
		}
  
		for (int temp : oddNumbers) {
		    System.out.printf("%d ", temp);
		}
		
		System.out.println();
		System.out.printf("총 %d개 입니다. ", oddNumbers.size());
	}
}
