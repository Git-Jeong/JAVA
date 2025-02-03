package view.User;
 
import model.MemberDTO;
import model.UserRoute.AuthDB;
import model.UserRoute.DeleteDB;

public class Delete {
	public static boolean deleteService(MemberDTO member ) {
		boolean result = false; 
		System.out.print("삭제할 유저의 PW : ");
		String input_pw = Input.inputStrig();
		member.setPw(input_pw);
		boolean authUser = AuthDB.authDB(member);
		if(authUser) {			
			result = DeleteDB.deleteDB(member);
		}
		else { 
			System.out.println("본인 확인에 실패했습니다."); 
		}	
		
		if(result) {
			//삭제 성공
			System.out.println("회원 삭제에 성공했습니다!");
		}
		else {
			//삭제 실패
			System.out.println("회원 삭제에 실패했습니다.");
		}
		
		return result;
	}
}
