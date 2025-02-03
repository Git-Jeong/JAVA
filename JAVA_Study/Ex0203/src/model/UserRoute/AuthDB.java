package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

import model.MemberDAO;
import model.MemberDTO;

public class AuthDB {
	public static boolean authDB(MemberDTO member) {
		boolean authCheck = false;
		MemberDTO loginUser = new MemberDTO(null, null); // 새로운 MemberDTO 객체 생성
		Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기
 
		if (conn == null) {
			System.out.println("DB 연결 실패!");
		} else {
			String sql = "SELECT ID FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, member.getId()); // VARCHAR 50으로 만들어둠
				pstmt.setString(2, member.getPw()); // VARCHAR 50으로 만들어둠 
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						try {  
							String id = rs.getString("ID"); 
							if(member.getId().equals(id)) {
								authCheck = true;
							}
						} catch (Exception e) {
							System.out.println("유저정보를 받아오는 도중에 문제가 생겼습니다.");
						}
					}
				}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
				MemberDAO.closeDB(conn);
			}
		}
		return authCheck;
	}
}
