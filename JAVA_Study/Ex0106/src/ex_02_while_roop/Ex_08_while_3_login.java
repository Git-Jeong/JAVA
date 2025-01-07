package ex_02_while_roop;

import java.util.*;

public class Ex_08_while_3_login { 
	/*
	 * jwt, gui, bcrypt 없이 간단하게 터미널에서 해보는 로그인 코드
	 * 
	 * */ 
	
	private static List<UserList> users = new ArrayList<>(); // 사용자 목록 저장

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== 메인 메뉴 =====");
			System.out.printf("1. 로그인, \t2. 회원가입, \t3. 모든 유저의 정보 \t0. 나가기\n");
			System.out.print("옵션을 선택하세요: ");

			try {
				int input = Integer.parseInt(scan.nextLine()); // 문자열을 정수로 변환
				if (input == 1) {
					String user_token = tryLogin(scan);
					if (user_token != null) {
						// 로그인 성공 시 정보 메뉴로 이동
						handleUserMenu(scan, user_token);
					}
				} 
				else if (input == 2) {
					boolean check = trySign(scan);
					if (check) {
						System.out.println("회원가입이 완료되었습니다.");
					}
				} 
				else if (input == 3) {
					getAllUserInfo();
				} 
				else if (input == 0) {
					System.out.println("프로그램을 종료합니다.");
					break; // 프로그램 종료
				} 
				else {
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
		scan.close();
	}

	private static void handleUserMenu(Scanner scan, String user_token) { 
		while (true) {
			System.out.println();
			System.out.println("\n=== 사용자 메뉴 ===");
			System.out.printf("1. Token, \t2. ID, \t3. 로그아웃\n");
			System.out.print("옵션을 선택하세요: ");

			try {
				int input = Integer.parseInt(scan.nextLine()); // 문자열을 정수로 변환
				if (input == 1) {
					System.out.println("유저 Token: " + user_token);
				} 
				else if (input == 2) {
					String get_user_id = findUserId(user_token);
					if (get_user_id != null) {
						System.out.println("유저 ID: " + get_user_id);
					} else {
						System.out.println("ID를 찾을 수 없습니다.");
					}
				} 
				else if (input == 3) {
					System.out.println("로그아웃되었습니다. 메인 메뉴로 돌아갑니다.");
					break; // 사용자 메뉴 종료 후 메인 메뉴로 복귀
				} 
				else {
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
	}

	private static String tryLogin(Scanner scan) { 
		//사용자의 로그인을 위한 메소드
		final int MAX_LOGIN_FAIL = 3;
		int login_fail = 0;

		System.out.println();
		System.out.println("===로그인 서비스===");
		while (login_fail < MAX_LOGIN_FAIL) {
			System.out.print("ID : ");
			String id = scan.nextLine();
			System.out.print("PW : ");
			String pw = scan.nextLine();

			for (UserList user : users) {
				if (user.id.equals(id) && user.pw.equals(pw)) {
					System.out.println("로그인 성공!");
					return user.token; // 로그인 성공 시 토큰 반환
				}
			}

			login_fail++;
			System.out.println("로그인 실패! 남은 시도 횟수: " + (MAX_LOGIN_FAIL - login_fail));
		}

		System.out.println("로그인 실패 횟수가 초과되었습니다.");
		return null; // 로그인 실패
	}

	private static boolean trySign(Scanner scan) {
		//회원가입을 시도하는 메소드 
		System.out.println();
		System.out.println("===회원가입 서비스===");
		
		System.out.print("ID : ");
		String id = scan.nextLine();
		System.out.print("PW : ");
		String pw = scan.nextLine();

		for (UserList user : users) {
			if (user.id.equals(id)) {
				System.out.println("이 ID는 이미 존재합니다.");
				return false;
			}
		}

		users.add(new UserList(id, pw));
		return true;
	}

	private static String findUserId(String token) {
		//유저 토큰을 활용하여 사용자의 id를 찾아오는 메소드
		for (UserList user : users) {
			if (user.token.equals(token)) {
				return user.id;
			}
		}
		return null;
	}

	private static class UserList {
		//유저정보의 구조체(?)
		String id;
		String pw;
		String token;

		UserList(String id, String pw) {
			this.id = id;
			this.pw = pw;
			this.token = generateUniqueToken();
		}

		private String generateUniqueToken() {
			return UUID.randomUUID().toString();
		}
	}

	private static void getAllUserInfo() {
		//모든 유저의 정보를 출력하는 메소드
		System.out.println();
		System.out.println("===모든 유저의 정보를 얻어오는 옵션===");  
		for (UserList user : users) { 
			//모든 유저 정보를 출력
			System.out.printf("ID = %s\n", user.id);
			System.out.printf("PW = %s\n", user.pw);
			System.out.printf("TOKEN = %s\n", user.token);
			System.out.println();
		}  
	}
}
