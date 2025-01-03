package ex_03_incr_decr_op;

public class Ex_06_relational_op {

	public static void main(String[] args) {
		//비교연산자 '<', '=='를 확인하는 코드
		int num_1 = 1;
		int num_2 = 2;
		
		System.out.println(num_1 + "과 " + num_2 + "이 같나? : " + (num_1 == num_2));
		System.out.println(num_1 + "과 " + num_2 + "이 같지 않나? : " + !(num_1 == num_2));
		System.out.println(num_1 + "이 " + num_2 + "보다 작나? : " + (num_1 < num_2));
		System.out.println(num_1 + "이 " + num_2 + "보다 크나? : " + (num_1 > num_2));
	}
}
