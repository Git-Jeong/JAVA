package ex_01_array;

import java.util.Random;

public class Ex_02_Array_2 {
	public static void main(String[] args) {
		// 정수형 데이터 5개를 저장할 수 있는 배열 array를 하나 선언
		// 배열 안의 모든 데이터를 임의의 값으로 초기화(1~100)
		// 배열 안의 데이터 중 홀수의 값만 출력하고, 총 홓수가 몇 개 인지 출력
		
		Random rd = new Random();
		final int MAX_ARRAY_INDEX = 5;
		final int MAX_RANDOM_NUM = 100;
		
		int rd_array[] = new int[MAX_ARRAY_INDEX];
		int count = 0;
		
		System.out.printf("배열 array에 들어 있는 홀수는 ");
		for(int i=0; i < MAX_ARRAY_INDEX; i++) {
			rd_array[i] = rd.nextInt(MAX_RANDOM_NUM) + 1; 
			if(rd_array[i] % 2 == 1) {
				System.out.printf("%d ", rd_array[i]);
				count++;
			}
		}
		
		System.out.println("이며, ");
		System.out.printf("총 %d개 입니다. ", count);

	}
}
