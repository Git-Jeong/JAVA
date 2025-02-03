package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberDAO;
import model.MemberDTO;

public class LoginDB {
    public static boolean loginDB(MemberDTO member) {
        boolean result = false;
        Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기

        if (conn == null) {
            System.out.println("DB 연결 실패!");
            return false;
        }

		String sql = "SELECT ID, PW FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getId()); //VARCHAR 50으로 만들어둠
            pstmt.setString(2, member.getPw()); //VARCHAR 50으로 만들어둠
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    result = true; // 로그인 성공
                }
            } 
        } catch (SQLException e) {
            System.out.println("SQL 실행 오류: " + e.getMessage());
        } finally {
            try {
                conn.close(); // 연결 해제
            } catch (SQLException e) {
                System.out.println("DB 연결 해제 오류: " + e.getMessage());
            }
        }

        return result;
    }
}
