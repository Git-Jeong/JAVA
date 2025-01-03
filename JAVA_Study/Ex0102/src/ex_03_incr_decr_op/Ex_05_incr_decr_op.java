package ex_03_incr_decr_op;

public class Ex_05_incr_decr_op {
	public static void main(String[] args) {
		int num_1 = 5;
		int num_2 = 10;
		
		//전위 연산자 확인
		System.out.println("num_1의 원래 값 : " + num_1);
		System.out.println("++num_1 = " + (++num_1)); 
		System.out.println();
		
		//후위 연산자의 경우
		System.out.println("num_2의 원래 값 : " + num_2);
		num_2 ++;
		System.out.println("num_2 ++; = " + num_2);
		
		
		
	}
}
