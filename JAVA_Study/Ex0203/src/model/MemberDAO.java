package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDAO {
	
    private static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "hr";
            String password = "hr";

            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패: " + e.getMessage());
        }
        return conn; // 연결 객체 반환
    }
	

    private static void closeDBConnection(Connection conn) {  
        try {
            conn.close(); // 연결 해제
        } catch (SQLException e) {
            System.out.println("DB 연결 해제 오류: " + e.getMessage());
        } 
    }
    
    
    // DB 연결 메서드
    public static Connection getConnection() {
    	return getDBConnection();
    }
    
    public static void closeDB(Connection conn) {  
    	closeDBConnection(conn); 
    }
    
}
