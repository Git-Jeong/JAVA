package ex_01;

public class Ex_03_2_student {
	String name;
	String number;
	int age; 
	int java_score;
	int web_score;
	int android_score;
	
	public Ex_03_2_student(String name, String number, int age,
				int java_score, int web_score, int android_score) {
		this.name = name;
		this.number = number;
		this.age = age; 
		this.java_score = java_score;
		this.web_score = web_score;
		this.android_score = android_score;
	}
	 
	public void showStudent() {
		System.out.println(name + "님 안녕하세요. ");
		System.out.printf("[ %s, %d살 ]\n", number, age); 
		System.out.println(name + "님의 자바 점수는 : " + java_score + "점 입니다.");
		System.out.println(name + "님의 웹 점수는 : " + web_score + "점 입니다.");
		System.out.println(name + "님의 안등로이드 점수는 : " + android_score + "점 입니다.");
	}
}
