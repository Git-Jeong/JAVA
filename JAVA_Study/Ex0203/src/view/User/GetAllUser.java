package view.User;
 
import java.util.ArrayList;

import model.MemberDTO;
import model.UserRoute.GetAllUserDB;

public class GetAllUser {
	public static void getAllUser() {
		//어드민의 경우 모든 유저의 정보를 볼 수 있다.
		ArrayList<MemberDTO> member =  GetAllUserDB.getAllUserDB();
		for(int i = 0; i < member.size(); i++) {
			System.out.println();
			System.out.println("ID : " + member.get(i).getId());
			System.out.println("NAME : " + member.get(i).getName());
			System.out.println("AGE : " + member.get(i).getAge());
			System.out.println("POINT : " + member.get(i).getPoint());
		}
	}
}
