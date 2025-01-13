package ex_01;

public class Ex_07_01_main_person {
	public static void main(String[] args) {
		Ex_07_02_person person = new Ex_07_02_person("홍길동", 52);
		
		System.out.println("이름 : " + person.getName()); 
		System.out.println("나이 : " + person.getAge());
		
		person.setName("신짱구");
		person.setAge(5);

		System.out.println("이름 : " + person.getName()); 
		System.out.println("나이 : " + person.getAge()); 
		
	}
}
