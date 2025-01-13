package ex_01;

public class Ex_07_02_person {
	private String name;
	//학생 이름
	private int age;
	//나이
	
	Ex_07_02_person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
