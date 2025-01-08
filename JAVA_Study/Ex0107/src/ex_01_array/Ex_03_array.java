package ex_01_array;

import java.util.Arrays;
import java.util.Random;

public class Ex_03_array {
	public static void main(String[] args) {
		//임의의 숫자들을 5개 생성한 이후, 가장 큰 숫자를 나타내는 코드

		Random rd = new Random();
		final int MAX_ARRAY_INDEX = 5;	
		final int MAX_RANDOM_NUMBER = 10;
		
		int rd_array[] = new int[MAX_ARRAY_INDEX];
		
		for(int i = 0; i< MAX_ARRAY_INDEX; i++) {
			rd_array[i] = rd.nextInt(MAX_RANDOM_NUMBER) + 1; 
		}
		
		//오름차순 정렬 전
		System.out.printf("정렬 전 : %s \n", Arrays.toString(rd_array));
		
		//오름차순 정렬
		Arrays.sort(rd_array); // 각 티켓 번호를 오름차순 정렬
		 
		//오름차순 정렬 후
		System.out.printf("정렬 후 : %s \n", Arrays.toString(rd_array));
		System.out.printf("가장 큰 수는 : %d\n", rd_array[MAX_ARRAY_INDEX - 1]);
	}
}
