package ex_03_for_roop;

public class Ex_03_for_3 {
	
	public static void main(String[] args) {
		final int MAX_NUM = 77;
		int first_num = MAX_NUM; 
		int sum = 0;

		for(int second_num = 1; second_num <= MAX_NUM; second_num++) {
			sum += first_num * second_num;
			first_num--; 
		} 
		
		System.out.printf("%d", sum);
	}
}
	 	