package view;

import model.MemberDTO;
import view.User.Delete;
import view.User.GetAllUser;
import view.User.Login;
import view.User.Signup;
import view.User.Update;
import view.User.UserInfo;
import view.util.*;

public class Main {

	final static int LOGIN_SUCCESS_RETURN_CODE = 200;
	final static int EXIT_RETURN_CODE = 999;
	final static int LOGOUT_RETURN_CODE = 888;
	static MemberDTO loginUser;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// 디자인 패턴 : 반복적으로 발생하는 문제를 해결하고자 프로그래밍을 할 떄 형식이나 규칙을 정해두는 것
		// 오늘 하는건 MVC 패턴. <- 전체적인 프로그램의 구조를 정한 패턴
		// model : 데이터를 저장하거나, 데이터베이스에 접근하는 코드의 모음
		// view : 사용자에게 보여지는 화면, 혹은 사용자에게 입력받는 코드
		// contriller : 사용자의 요청을 받아 model과 view를 연결

		System.out.println("==== 회원 관리 프로그램 ====");
		boolean isLogin = false;

		while (true) {
			if (!isLogin) {
				// 로그인이 되지 않았다면
				int serviceOption = nonLoginService();
				if (serviceOption == LOGIN_SUCCESS_RETURN_CODE) {
					isLogin = true;
				} else if (serviceOption == EXIT_RETURN_CODE) {
					break;
				}
			} else if (isLogin) {
				// 로그인이 되었다면
				System.out.println();
				int serviceOption = loginService();
				if (serviceOption == LOGOUT_RETURN_CODE) {
					isLogin = false;
				}
			}
			System.out.println();
		}

		System.out.println("시스템이 종료되었습니다.");
		ScannerUtil.closeScanner();
	}

	private static int loginService() {
		final int SEARCH_USER_CODE = 1;
		final int SEARCH_ALL_USER_CODE = 2;
		final int EDIT_CODE = 3;
		final int LOGOUT_CODE = 4;
		final int DELETE_CODE = 5;
		System.out.printf("[%d]정보조회, [%d]전체회원 조회, [%d]정보수정, [%d]로그아웃, [%d]탈퇴\n", 
				SEARCH_USER_CODE, SEARCH_ALL_USER_CODE, EDIT_CODE, LOGOUT_CODE,
				DELETE_CODE);
		System.out.print("숫자를 입력 : ");
		String inputOption = Input.inputStrig();
		if (inputOption.equals(String.valueOf(DELETE_CODE))) {
			// 회원탈퇴 코드 실행
			boolean deleteResult = Delete.deleteService(loginUser);
			if (deleteResult) {
				// 삭제 성공
				loginUser = null;
				return LOGOUT_RETURN_CODE;
			}
		} else if (inputOption.equals(String.valueOf(SEARCH_USER_CODE))) {
			// 회원 정보 조회 코드 실행
			UserInfo.userInfo(loginUser);
		} else if (inputOption.equals(String.valueOf(SEARCH_ALL_USER_CODE))) {
			// 모든 회원 정보 조회 코드 실행 
			GetAllUser.getAllUser();
		} else if (inputOption.equals(String.valueOf(EDIT_CODE))) {
			// 회원정보 수정 코드 실행
			Update.updateService(loginUser);
		} else if (inputOption.equals(String.valueOf(LOGOUT_CODE))) {
			// 로그아웃 코드 실행
			loginUser = null;
			return LOGOUT_RETURN_CODE;
		}
		return 0;
	}

	private static int nonLoginService() {

		final int SIGNUP_CODE = 1;
		final int LOGIN_CODE = 2;
		while (true) {

			System.out.printf("[%d]회원가입, [%d]로그인 \n", SIGNUP_CODE, LOGIN_CODE);
			System.out.print("숫자를 입력 : ");
			String inputOption = Input.inputStrig();

			if (inputOption.equals(String.valueOf(SIGNUP_CODE))) {
				// 회원가입 코드 실행
				System.out.println("회원가입 시작");
				Signup.signupService();
			} else if (inputOption.equals(String.valueOf(LOGIN_CODE))) {
				// 로그인 코드 실행
				loginUser = Login.loginService();
				if (loginUser.getName() != null) {
					return LOGIN_SUCCESS_RETURN_CODE;
				}
			} else {
				// 시스템 종료 코드
				System.out.println("시스템을 종료하겠습니까??   Yes : 'Y' >>>> ");
				String inputExit = Input.inputStrig();
				if (inputExit.equalsIgnoreCase("Y")) {
					return EXIT_RETURN_CODE;
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}
