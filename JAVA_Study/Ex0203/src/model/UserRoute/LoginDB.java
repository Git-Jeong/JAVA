package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberDAO;
import model.MemberDTO;

public class LoginDB {
	public static MemberDTO loginDB(MemberDTO member) {
		MemberDTO loginUser = new MemberDTO(null, null); // 새로운 MemberDTO 객체 생성
		Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기

		if (conn == null) {
			System.out.println("DB 연결 실패!");
		} else {
			String sql = "SELECT ID, NAME, POINT, AGE FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, member.getId()); // VARCHAR 50으로 만들어둠
				pstmt.setString(2, member.getPw()); // VARCHAR 50으로 만들어둠

				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						try { 
							String name = rs.getString("NAME"); // ResultSet에서 커서 이름 가져오기
							String id = rs.getString("ID");
							int point = rs.getInt("POINT");
							int age = rs.getInt("AGE");
							loginUser.setName(name); // name 설정
							loginUser.setId(id); // id 설정
							loginUser.setPoint(point); // point 설정
							loginUser.setAge(age); // age 설정
						} catch (Exception e) {
							System.out.println("유저정보를 받아오는 도중에 문제가 생겼습니다.");
						}
					}
				}
			} catch (SQLException e) {
				System.out.println("SQL 실행 오류: " + e.getMessage());
			} finally {
				MemberDAO.closeDB(conn);
			}
		}
		return loginUser;
	}
}
