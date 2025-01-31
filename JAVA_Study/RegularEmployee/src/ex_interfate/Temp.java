package ex_interfate;

public interface Temp {
	//인터페이스란?
	// 클래스들이 공통적으로 구현하는 기능을 강제적으로 미리 정의
	// 여기서 정의되는 모든 변수는 static final로 선언된다 
	public static final int NUM = 9;
	
	public abstract void temp();
	// 추상메소드는 중괄호{}를 가질 수 없다 
	// 인터페이스에선 abstract를 생략할 수 있다. 모든 메소드는 자동으로 abstract로 선언된다
	
	
}
