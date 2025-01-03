package ex_01_var;

public class Ex_03_Casting {
	public static void main(String[] args) {
		 
		// 강제 형변환 == 명시적 형 변환 			<- 큰걸 작은 타입의 변수로 바꿀 때 발생
		// 자동 형변환 == 묵시적 형 변환			<- 작은걸 큰 데이터 타입으로 옮기기기
		
		//강제 형변환 <- 데이터 손실이 발생할 수 있다
		double double_int_num1 = 3.14;
		int double_int_num2 = (int) double_int_num1;
		System.out.println("double num1 = " + double_int_num1);
		System.out.println("int num2 = " + double_int_num2);
 		System.out.println();
		 
		//자동 형변환 
 		int int_double_num1 = 11; 
 		double int_double_num2 = (double) int_double_num1;
 		System.out.println("int num1 = " + int_double_num1);
 		System.out.println("double num1 = " + int_double_num2);
 		System.out.println();
		
		//정수와 실수의 형변환
 		//실수가 정수형보다 범위가 크다
 		int i_num1 = 10;
 		float f_num1 = (float) i_num1;
 		System.out.println("int num1 = "+ i_num1);
 		System.out.println("float num1 = "+ f_num1);
 		System.out.println();
 		
 		float f_num2 = 4.12f;
 		int i_num2 = (int) f_num2; 
 		System.out.println("ffloloat num1 = "+ f_num2);
 		System.out.println("int num1 = "+ i_num2);
 		System.out.println();
 		
	}
}
