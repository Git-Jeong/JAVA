package view.User;

import model.MemberDTO;
import model.UserRoute.LoginDB;
import model.UserRoute.UpdateDB;

public class Update {
	public static void updateService() {  
		
		// 사용자 정보 검증
		System.out.println("--본인확인 절차--");
		System.out.print("id : ");
		String input_id = Input.inputStrig();
		System.out.print("pw : ");
		String input_pw = Input.inputStrig(); 
		MemberDTO member = new MemberDTO(input_id, input_pw); 
		boolean user_check = LoginDB.loginDB(member);
		
		if (user_check) { 
			System.out.println("--정보 변경--"); 
			System.out.print("pw : ");
			String new_pw1 = Input.inputStrig();
			System.out.print("pw check : ");
			String new_pw2 = Input.inputStrig(); 
			System.out.print("name : "); 
			String new_name = Input.inputStrig(); 
			System.out.print("age : ");
			int new_age = Input.inputNumber();
			
			if(new_pw1.equals(new_pw2)) {  
				member.setPw(new_pw1);
				member.setName(new_name);
				member.setAge(new_age);
				boolean update_check = UpdateDB.updateDB(member);
				 

				if (update_check) {
					System.out.println("변경에 성공했습니다!"); 
				} else { 
					System.out.println("변경에 실패했습니다!"); 
				} 
			} 

			else {
				System.out.println("비밀번호가 서로 일치하지 않습니다.");
			}
			
		} else { 
			System.out.println("본인 확인에 실패했습니다."); 
		}		 
		
		
		
	}
}
