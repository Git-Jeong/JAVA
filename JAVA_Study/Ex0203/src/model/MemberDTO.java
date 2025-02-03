package model;

public class MemberDTO {

	// DTO
	// Data Transfer Object -> 단순 데이터 이동 -> 1. 필드 2. 생성자 메소드 3. getter/setter

	// 1. 필드 -> 아이디, 비밀번호, 이름, 나이, 점수
	private String id;
	private String pw;
	private String name;
	private int age;
	private int point;

	// 2. 생성자 메소드 -> 오버로딩
	// -> 모든 필드 사용한 생성자, (아이디,비밀번호,이름,나이) 생성자

	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw; 
	}


	public MemberDTO(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}  
	
	public MemberDTO(String id, String pw, String name, int age, int point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.point = point;
	} 

	// 3. 모든 필드의 getter, setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
