package view.User;
 
import model.MemberDTO;
import model.UserRoute.DeleteDB;

public class Delete {
	public static boolean deleteService() {
		boolean result = false;
		System.out.print("삭제할 유저의 ID : ");
		String input_id = Input.inputStrig();
		System.out.print("삭제할 유저의 PW : ");
		String input_pw = Input.inputStrig();
		
		MemberDTO member = new MemberDTO(input_id, input_pw);
		result = DeleteDB.deleteDB(member);
		
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
