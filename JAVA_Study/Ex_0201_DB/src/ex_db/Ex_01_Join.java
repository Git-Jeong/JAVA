package ex_db;

import java.sql.*;
import java.util.Scanner;

public class Ex_01_Join {
	public static void main(String[] args) {
		//회원가입을 위한 시스템
		
		Scanner scan = new Scanner(System.in);

		System.out.println("회원가입 서비스 : ");
		while (true) {
			System.out.print("id : ");
			String input_id = inputString(scan);
			System.out.print("pw : ");
			String input_pw = inputString(scan);
			System.out.print("name : ");
			String input_name = inputString(scan);
			System.out.print("age : ");
			int input_age = inputInt(scan);

			//사용자가 입력한 값으로 회원가입을 진행
			boolean register_check = registerUser(input_id, input_pw, input_name, input_age);
			
			if ( register_check ) {
				System.out.println("회원가입 성공!");
				break; // 회원가입이 성공하면 루프 종료
			} else {
				System.out.println("회원가입 실패... 다시 시도해주세요.");
			}
		}

		scan.close();
	}

	private static boolean registerUser(String id, String pw, String name, int age) {
		Connection conn = null;
		PreparedStatement psant = null;
		boolean success = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // 수동 커밋 모드

			String sql_insert = "INSERT INTO BIGDATA_MEMBER (ID, PW, NAME, AGE) VALUES (?, ?, ?, ?)";
			psant = conn.prepareStatement(sql_insert);

			psant.setString(1, id);
			psant.setString(2, pw);
			psant.setString(3, name);
			psant.setInt(4, age);

			int result = psant.executeUpdate();
			if (result > 0) {
				conn.commit();
				success = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력하세요.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psant != null)
					psant.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	private static int inputInt(Scanner scan) {
		int result;
		while (true) {
			try {
				result = Integer.parseInt(scan.next());
				if (result > 0) {
					return result;
				}
			} catch (Exception e) {
				System.out.print("0 이상의 숫자만 입력 : ");
			}
		}
	}

	private static String inputString(Scanner scan) {
		while (true) {
			try {
				return scan.next();
			} catch (Exception e) {
				System.out.print("에러... 재입력 : ");
			}
		}
	}
}
