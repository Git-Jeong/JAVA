package view.User;
 
import model.MemberDTO;
import model.UserRoute.LoginDB; 

public class Login {
	public static boolean loginService(){ 
		boolean result = false; 
		// 로그인 서비스 로직
		System.out.println(" ----- 로그인 서비스 ----- ");
		System.out.print("id : ");
		String input_id = Input.inputStrig();
		System.out.print("pw : ");
		String input_pw = Input.inputStrig(); 
		// 사용자 정보 검증
		
		MemberDTO member = new MemberDTO(input_id, input_pw);
		
		boolean login_check = LoginDB.loginDB(member);

		if (login_check) {
			System.out.println("로그인에 성공했습니다!");
			result = true;
		} else { 
			System.out.println("로그인에 실패했습니다!");
			result = false;
		}

		return result;
	}
}
