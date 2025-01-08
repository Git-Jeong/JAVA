package ex_01_array;

import java.util.Arrays;

public class Ex_01_array {
	public static void main(String[] args) {
		int array_1[] = { 10, 20, 30, 40, 50, 60, 70 };
		int sum=0; 

		for(int temp : array_1) {
			System.out.printf("%d ", temp);
			sum += temp;
		}
		
		//합 구하기
		System.out.println();
		System.out.printf("모든 수의 합 : %d", sum);
		
		//평균 구하기
		System.out.println();
		System.out.printf("평균 : %.1f \n\n", (float) (sum / array_1.length));
		
		
		
		/*----------------------문자열 배열----------------------*/
		String arr_2[] = {"A", "B", "C", "D"};
		 
		System.out.println(Arrays.toString(arr_2)); 
		//배열 출력 방법 1
		
		for(String temp : arr_2) {
			System.out.printf("%s ", temp);
		}

		
		
		/*----------------------배열의 주소 관리----------------------*/
		System.out.printf("\n\n\n");
		
		int arr_4[] = array_1;

		System.out.println("변경 전의 array_1[0] : " + array_1[0]);
		arr_4[0] = 500;
		System.out.println("변경 후의 array_1[0] : " + array_1[0]); 
		
	}
}

// 으ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ