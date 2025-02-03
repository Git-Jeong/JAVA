package view.User;
 
import model.MemberDTO;
import model.UserRoute.LoginDB; 

public class Login {
	public static MemberDTO loginService(){  
		// 로그인 서비스 로직
		System.out.println(" ----- 로그인 서비스 ----- ");
		System.out.print("id : ");
		String input_id = Input.inputStrig();
		System.out.print("pw : ");
		String input_pw = Input.inputStrig(); 
		// 사용자 정보 검증
		
		MemberDTO member = new MemberDTO(input_id, input_pw);
		
		MemberDTO loginUser = LoginDB.loginDB(member); 
		
		try { 
			if (loginUser.getName() != null) {
				System.out.println("로그인에 성공했습니다!"); 
			} else { 
				System.out.println("로그인에 실패했습니다!"); 
			}
		} catch (Exception e) {
			System.out.println("로그인 실패...");
			loginUser.setName(null);;
		} 

		return loginUser;
	}
}
