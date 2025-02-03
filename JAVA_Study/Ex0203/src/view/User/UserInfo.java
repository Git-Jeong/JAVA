package view.User;

import model.MemberDTO;

public class UserInfo {
	public static void userInfo(MemberDTO member) { 
		try {
			String id = member.getId();
			System.out.println("ID : " + id);
		} catch (Exception e) {
			System.out.println("아이디를 불러오는 과정에서 에러가 발생했습니다.");
		}
		try {
			String name = member.getName();
			System.out.println("NAME  : " + name);
		} catch (Exception e) {
			System.out.println("이름 불러오는 과정에서 에러가 발생했습니다.");
		}
		try {
			int age = member.getAge();
			System.out.println("AGE : " + age);
		} catch (Exception e) {
			System.out.println("나이를 불러오는 과정에서 에러가 발생했습니다.");
		}
		try {
			int point = member.getPoint();
			System.out.println("POINT : " + point);
		} catch (Exception e) {
			System.out.println("포인트 불러오는 과정에서 에러가 발생했습니다.");
		}
	}
}
