package view;  
import view.User.Delete;
import view.User.Input;
import view.User.Login;
import view.User.Signup;
import view.User.Update;
import view.util.*;

public class Main {


	final static int LOGIN_SUCCESS_CODE = 200;
	final static int EXIT_CODE = 999;
	final static int LOGOUT_CODE = 888; 
	
	public static void main(String[] args) {  
		
		// TODO Auto-generated method stub
		// 디자인 패턴 : 반복적으로 발생하는 문제를 해결하고자 프로그래밍을 할 떄 형식이나 규칙을 정해두는 것
		// 오늘 하는건 MVC 패턴. <- 전체적인 프로그램의 구조를 정한 패턴
		// model : 데이터를 저장하거나, 데이터베이스에 접근하는 코드의 모음
		// view : 사용자에게 보여지는 화면, 혹은 사용자에게 입력받는 코드
		// contriller : 사용자의 요청을 받아 model과 view를 연결
		
		System.out.println("==== 회원 관리 프로그램 ====");
		boolean LoginCheck = false;
		
		while(true) {
			if(!LoginCheck) {
				//로그인이 되지 않았다면 
				int check = notLogin();
				if(check == LOGIN_SUCCESS_CODE) {
					LoginCheck = true;
				}
				else if(check == LOGOUT_CODE) {
					LoginCheck = false;
				}
				else if(check == EXIT_CODE) {
					break;
				}
			}
 
			
		}
		
		System.out.println("시스템이 종료되었습니다.");
		ScannerUtil.closeScanner();
	} 
	
	private static int notLogin() {
		
		final int SIGNUP_CODE = 1;
		final int LOGIN_CODE = 2;
		final int DELETE_CODE = 3;
		final int SEARCH_USER_CODE = 4;
		final int EDIT_CODE = 5; 
		while(true) {

			System.out.printf("[%d]회원가입, [%d]로그인, [%d]탈퇴, [4]전체조회, [5]정보수정\n", 
					SIGNUP_CODE, LOGIN_CODE, DELETE_CODE, SEARCH_USER_CODE, EDIT_CODE);
			System.out.print("숫자를 입력 : ");
			String inputOption = Input.inputStrig();
			
			if (inputOption.equals(String.valueOf(SIGNUP_CODE))) {
			    // 회원가입 코드 실행
				System.out.println("회원가입 시작"); 
				Signup.signupService(); 
			}
			else if (inputOption.equals(String.valueOf(LOGIN_CODE))) {
			    // 로그인 코드 실행 
				boolean loginResult = Login.loginService(); 
				if(loginResult) {
					return LOGIN_SUCCESS_CODE;
				}
			}
			else if (inputOption.equals(String.valueOf(DELETE_CODE))) {
			    // 회원탈퇴 코드 실행 
				boolean deleteResult = Delete.deleteService();
				if(deleteResult) {			
					//삭제 성공
					return LOGOUT_CODE;
				}
			}
			else if (inputOption.equals(String.valueOf(SEARCH_USER_CODE))) {
			    // 모든 회원 정보 조회 코드 실행 
			}
			else if (inputOption.equals(String.valueOf(EDIT_CODE))) {
			    // 회원정보 수정 코드 실행 
				Update.updateService();
			}
			else {
				//시스템 종료 코드 
				System.out.println("시스템을 종료하겠습니까??   Yes : 'Y' >>>> "); 
				String inputExit = Input.inputStrig();
				if(inputExit.equalsIgnoreCase("Y")){
					return EXIT_CODE;
				} 
			}
			System.out.println();
			System.out.println();
		} 
	}
}
