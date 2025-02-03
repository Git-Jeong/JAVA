package ex_db;

import java.sql.*;
import java.util.Scanner;

public class FullService {
	public static void main(String[] args) {
		// 회원가입을 위한 시스템

		Scanner scan = new Scanner(System.in);
		final int LOGIN_CODE = 1;
		final int SIGNUP_CODE = 2;
		
		final int DELETE_CODE = 1;
		final int LOGOUT_CODE = 2;
		
		final int EXIT_CODE = 0;

		boolean login_check = false;

		while (true) {
			if(!login_check) {
				System.out.printf("Login : '%d',   Signup : '%d',   Exit : '%d' >>>> ", LOGIN_CODE, SIGNUP_CODE, EXIT_CODE);
				int mode = inputInt(scan);

				if (mode == LOGIN_CODE) {
					login_check = loginService(scan); 
				} else if (mode == SIGNUP_CODE) {
					signupService(scan);
				} else if (mode == EXIT_CODE) {
					break;
				}
			} 
			
			else if(login_check) {
				System.out.printf("delete : '%d',   Logout : '%d' >>>> ", DELETE_CODE, LOGOUT_CODE );
				int mode = inputInt(scan);
				
				if(mode == DELETE_CODE) {					
					boolean delete_check = deleteService(scan);
					if(delete_check) {						
						login_check = false;
					}
				}
				else if(mode == LOGOUT_CODE) {
					login_check = false;
				}
			}
		}

		scan.close();
	}

	private static boolean deleteService(Scanner scan) { 
		System.out.println(" ----- 회원탈퇴 페이지 ----- ");
		System.out.print("id : ");
		String input_id = inputString(scan);
		System.out.print("pw : ");
		String input_pw = inputString(scan);

		// 사용자 정보 검증
		boolean user_check = deleteUser(input_id, input_pw);

		return user_check;
	}

	private static boolean loginService(Scanner scan) {
		boolean login_result = false;
		// 로그인 서비스 로직
		System.out.println(" ----- 로그인 서비스 ----- ");
		System.out.print("id : ");
		String input_id = inputString(scan);
		System.out.print("pw : ");
		String input_pw = inputString(scan);

		// 사용자 정보 검증
		boolean login_check = authenticateUser(input_id, input_pw);

		if (login_check) {
			System.out.println("로그인 성공!");
			login_result = true;
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			login_result = false;
		}

		return login_result;
	}


	private static boolean deleteUser(String id, String pw) {
		Connection conn = null;
		PreparedStatement psant = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			// 데이터베이스 연결 설정
			conn = getConnection();

			// SQL 쿼리 작성: 입력된 id와 pw를 DB에서 확인
			String sql_delete = "DELETE FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";
			psant = conn.prepareStatement(sql_delete);

			// PreparedStatement에 값 설정
			psant.setString(1, id); // 사용자 ID
			psant.setString(2, pw); // 비밀번호

			// SQL 실행
			rs = psant.executeQuery();

			// 결과가 있으면 삭제 성공
			if (rs.next()) {
				System.out.println("삭제 성공!");
				result = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// 리소스 해제 (PreparedStatement, ResultSet, Connection 닫기)
				if (rs != null)
					rs.close();
				if (psant != null)
					psant.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;  
	}

	
	
	
	private static boolean authenticateUser(String id, String pw) {
		Connection conn = null;
		PreparedStatement psant = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			// 데이터베이스 연결 설정
			conn = getConnection();

			// SQL 쿼리 작성: 입력된 id와 pw를 DB에서 확인
			String sql_select = "SELECT ID, PW FROM BIGDATA_MEMBER WHERE ID = ? AND PW = ?";
			psant = conn.prepareStatement(sql_select);

			// PreparedStatement에 값 설정
			psant.setString(1, id); // 사용자 ID
			psant.setString(2, pw); // 비밀번호

			// SQL 실행
			rs = psant.executeQuery();

			// 결과가 있으면 로그인 성공
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// 리소스 해제 (PreparedStatement, ResultSet, Connection 닫기)
				if (rs != null)
					rs.close();
				if (psant != null)
					psant.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 로그인 성공 여부 반환
	}

	private static void signupService(Scanner scan) {
		System.out.println(" ----- 회원가입 서비스 ----- ");
		/*
		 * final String BACKMODE = "Exit";
		 * System.out.printf(" ----- 뒤로가기 : '%s' ----- ", BACKMODE); String mode =
		 * inputString(scan); if(mode.equalsIgnoreCase(BACKMODE)) { return; }
		 */
		System.out.print("id : ");
		String input_id = inputString(scan);
		System.out.print("pw : ");
		String input_pw = inputString(scan);
		System.out.print("name : ");
		String input_name = inputString(scan);
		System.out.print("age : ");
		int input_age = inputInt(scan);

		// 사용자가 입력한 값으로 회원가입을 진행
		boolean register_check = registerUser(input_id, input_pw, input_name, input_age);

		if (register_check) {
			System.out.println("회원가입 성공!");
		}
	}

	private static boolean registerUser(String id, String pw, String name, int age) {
		Connection conn = null;
		PreparedStatement psant = null;
		boolean result = false;

		try {
			// 데이터베이스 연결 설정
			conn = getConnection();

			// 3. 자동 커밋 비활성화 (트랜잭션 수동 관리)
			conn.setAutoCommit(false);

			// 4. 사용자 정보를 DB에 삽입하는 SQL 문 작성
			String sql_insert = "INSERT INTO BIGDATA_MEMBER (ID, PW, NAME, AGE) VALUES (?, ?, ?, ?)";
			psant = conn.prepareStatement(sql_insert);

			// 5. PreparedStatement에 값 설정
			psant.setString(1, id); // 사용자 ID VARCHAR(50)
			psant.setString(2, pw); // 비밀번호 VARCHAR(50)
			psant.setString(3, name); // 이름 VARCHAR(50)
			psant.setInt(4, age); // 나이 NUMBER

			// 6. SQL 실행 및 결과 확인
			int db_result = psant.executeUpdate();
			if (db_result > 0) {
				// 7. 삽입 성공 시 트랜잭션 커밋
				conn.commit();
				result = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			// 8. ID 중복 시 예외 처리
			System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력하세요.");
		} catch (ClassNotFoundException | SQLException e) {
			// 9. 기타 예외 발생 시 출력
			e.printStackTrace();
		} finally {
			try {
				// 10. 리소스 해제 (PreparedStatement, Connection 닫기)
				if (psant != null)
					// psant에 값이 있다면 close하는 것.
					psant.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 11. 회원가입 성공 여부 반환
	}

	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		// 1. JDBC 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 데이터베이스 연결 설정
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		return DriverManager.getConnection(url, user, password);
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
