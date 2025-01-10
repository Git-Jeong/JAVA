package ex_01_instance_method;

public class Ex_04_method {
	public static void main(String[] args) {

		// 메소드 오버로딩을 실습하는 코드

		// num1 + num2를 출력하는 add 메소드를 만들어라
		int num1 = 10;
		int num2 = 30;
		add(num1, num2);

		// 실수형 num3 + 실수형 num4를 출력하는 add 메소드
		float num3 = 3.14f;
		float num4 = 3.29f;
		add(num3, num4);

		// double형 num5 + double형 num6를 출력하는 add 메소드
		double num5 = 5.778f;
		double num6 = 7.777f;
		add(num5, num6);

		// String형 str1 + String형 str2을 출력하는 add 메소드
		String str1 = "Asia";
		String str2 = "Korea";
		add(str1, str2);
 

	}

	// 메소드 오버로딩 
	
	private static void add(int i, int j) {
		System.out.printf("%d + %d = %d\n", i, j, i + j);
	} 

	private static void add(float i, float j) {
		System.out.printf("%f + %f = %f\n", i, j, i + j);
	}

	private static void add(double i, double j) {
		System.out.printf("%f + %f = %f\n", i, j, i + j);
	}

	private static void add(String i, String j) {
		System.out.printf("%s + %s = %s\n", i, j, i + j);
	} 
}
