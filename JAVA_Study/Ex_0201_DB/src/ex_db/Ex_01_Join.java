package ex_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex_01_Join {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psant = null;
		Scanner scan = new Scanner(System.in);

		System.out.print("id : ");
		String input_id = inputString(scan);
		System.out.print("pw : ");
		String input_pw = inputString(scan);
		System.out.print("name : ");
		String input_name = inputString(scan);
		System.out.print("age : ");
		int input_age = inputInt(scan);
		
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

			// 3. 올바른 INSERT 문 (?, ?, ?, ? 사용)
			String sql_insert = "INSERT INTO BIGDATA_MEMBER (ID, PW, NAME, AGE) VALUES (?, ?, ?, ?)";

			// 4. PreparedStatement 생성 및 값 바인딩
			psant = conn.prepareStatement(sql_insert);
			psant.setString(1, input_id); // ID (String)
			psant.setString(2, input_pw); // PW (String)
			psant.setString(3, input_name); // NAME (String)
			psant.setInt(4, input_age); // AGE (Integer)

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
		
		scan.close();

	}
	
	private static int inputInt(Scanner scan) {
		// 0이상의 정수를 입력받는 함수
		int result = 0;
		while(true) {
			try {
				result = Integer.parseInt(scan.next());
				if(result > 0) {					
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				System.out.print("0이상의 숫자만 입력 : ");
			}
		}
		return result;
	}
	
	private static String inputString(Scanner scan) {
		// 문자열을 입력받는 함수
		String result = null;
		while(true) {
			try {
				result = scan.next();
				break;
			} catch (Exception e) {
				System.out.print("에러... 재입력 : ");
			}
		}
		return result;
	}
}
