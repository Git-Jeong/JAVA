package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;

public class GetAllUserDB { 
    public static ArrayList<MemberDTO> getAllUserDB() {
    	ArrayList<MemberDTO> userList = new ArrayList<MemberDTO>(); 
        Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기

        if (conn == null) {
            System.out.println("DB 연결 실패!");
            return userList;
        }

		String sql = "SELECT ID, NAME, AGE, POINT FROM BIGDATA_MEMBER";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            
            try (ResultSet rs = pstmt.executeQuery()) {
    			while (rs.next()) {  
    				String id = rs.getString("ID");
    				String name = rs.getString("NAME");
    				int age = rs.getInt("AGE");
    				int point = rs.getInt("POINT");
    				userList.add( new MemberDTO(id, name, age, point) );
    			}
            } 
        } catch (SQLException e) {
            System.out.println("SQL 실행 오류: " + e.getMessage());
        } finally {
        	MemberDAO.closeDB(conn);
        }
 
    	return userList;
    }
}
