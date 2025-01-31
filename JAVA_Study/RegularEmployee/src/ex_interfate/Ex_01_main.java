package ex_interfate; 

public class Ex_01_main {
	public static void main(String[] args) {
		System.out.println("시작");
		new Temp() {
			
			@Override
			public void temp() {
				System.out.println(NUM);
			}
		}.temp();
		//.temp를 적어야 속에있는 temp 메소드를 실행한다!
		 
	}
}
