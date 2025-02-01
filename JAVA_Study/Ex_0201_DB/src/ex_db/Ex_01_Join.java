package ex_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex_01_Join {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psant = null;

		try {
			// 1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결 정보 설정
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

			// 3. 올바른 INSERT 문 (플레이스홀더 사용)
			String sql_insert = "INSERT INTO BIGDATA_MEMBER (ID, PW, NAME, AGE) VALUES (?, ?, ?, ?)";

			// 4. PreparedStatement 생성 및 값 바인딩
			psant = conn.prepareStatement(sql_insert);
			psant.setString(1, "smhrd"); // ID
			psant.setString(2, "smhrd"); // PW
			psant.setString(3, "JeongJIn"); // NAME
			psant.setInt(4, 10); // AGE (정수 타입)

			// 5. 실행 및 결과 확인
			int result = psant.executeUpdate();

			if (result > 0) {
				System.out.println("회원가입 성공!");
				conn.commit();
			} else {
				System.out.println("회원가입 실패...");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 뮤조건 마지막에 방문하는 구문
			// 6. 리소스 해제
			try {
				if (psant != null)
					psant.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
