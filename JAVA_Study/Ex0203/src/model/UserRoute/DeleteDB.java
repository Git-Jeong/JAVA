package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberDAO;
import model.MemberDTO;

public class DeleteDB { 
    public static boolean deleteDB(MemberDTO member) {
        boolean result = false;
        Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기

        if (conn == null) {
            System.out.println("DB 연결 실패!");
            return false;
        }

		String sql = "DELETE FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getId()); //VARCHAR 50으로 만들어둠
            pstmt.setString(2, member.getPw()); //VARCHAR 50으로 만들어둠
            
            try (ResultSet rs = pstmt.executeQuery()) {
    			if (rs.next()) {
    				System.out.println("삭제 성공!");
    				result = true;
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
