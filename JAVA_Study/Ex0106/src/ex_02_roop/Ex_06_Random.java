package ex_02_roop;

import java.util.Random;

public class Ex_06_Random {
	public static void main(String[] args) {
		// JAVA에서 random으로 숫자를 하나 만들어내기
		
		// ctri + shift + o 를 통해 import문을 자동으로 입력 가능하다!
		Random rd = new Random();
		
		// 랜덤 수 생성하고 확인해보기
		System.out.println("범위를 지정하지 않은 랜덤의 수 : " + rd.nextInt());
		
		// 랜덤 수의 범위를 지정하기
		int range = 10;
		//함수에 n을 넣었으면, 0부터 n-1까지 생성이 된다.
		System.out.println( range + " 미만의 수를 생성해보기 : " + rd.nextInt(range));
		
		System.out.println( range + " 이하의 수를 생성해보기(0은 생략) : " + (rd.nextInt(range) + 1));
			
	}
}
