package model.UserRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import model.MemberDAO;
import model.MemberDTO;

public class SignupDB {
	public static boolean signupDB(MemberDTO member) {
		boolean result = false;
		Connection conn = MemberDAO.getConnection(); // DB 연결 가져오기

		if (conn == null) {
			System.out.println("DB 연결 실패!");
			return false;
		}

		String sql = "INSERT INTO BIGDATA_MEMBER (ID, PW, NAME, AGE) VALUES (?, ?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 5. PreparedStatement에 값 설정
			pstmt.setString(1, member.getId()); // 사용자 ID VARCHAR(50)
			pstmt.setString(2, member.getPw()); // 비밀번호 VARCHAR(50)
			pstmt.setString(3, member.getName()); // 이름 VARCHAR(50)
 			pstmt.setInt(4, member.getAge()); // 나이 NUMBER

			// 6. SQL 실행 및 결과 확인
			int db_result = pstmt.executeUpdate();
			if (db_result > 0) {
				// 7. 삽입 성공 시 트랜잭션 커밋
				conn.commit();
				result = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			// 8. ID 중복 시 예외 처리
			System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력하세요.");
		} catch (SQLException e) {
			// 9. 기타 예외 발생 시 출력
			e.printStackTrace();
		} finally {
			try {
				// 10. 리소스 해제
				conn.close(); // 연결 해제
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 11. 회원가입 성공 여부 반환
	}
}
