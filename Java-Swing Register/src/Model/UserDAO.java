package Model;

import Utils.ConnectDB;

import java.sql.*;

public class UserDAO {
    private static Connection getConnection() throws SQLException {
        return ConnectDB.initDB();  // DB 연결 메서드 반환
    }

    /* DB 내 유저 데이터 조회 */
    private UserDTO selectUserResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet 에서 각 컬럼의 값을 읽어옴
        int userNumber = resultSet.getInt("user_no");
        String userId = resultSet.getString("user_id");
        String password = resultSet.getString("user_pwd");
        String address = resultSet.getString("address");
        String gender = resultSet.getString("gender");
        String phone = resultSet.getString("phone");
        String birth = resultSet.getString("birth");

        return new UserDTO(userNumber, userId, password, address, gender, phone, birth);
    }

    /* DB 에 유저 데이터 삽입 */
    private static boolean insertUser(Connection conn, String userId, String password, String address, String gender, String phone, String birth) throws SQLException {
        String sql = "INSERT INTO java_swing_register_member(user_id, user_pwd, address, gender, phone, birth) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            pstmt.setString(3, address);
            pstmt.setString(4, gender);
            pstmt.setString(5, phone);
            pstmt.setString(6, birth);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("회원가입이 완료되었습니다.");
                return true;
            } else {
                System.out.println("회원가입에 실패했습니다.");
                return false;
            }
        }
    }

    // Test: 전체 유저 조회
    public void selectAllUserList() {
        // 데이터 베이스
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.out.println("데이터베이스 연결에 실패했습니다.");
                return;
            }

            String sql = "SELECT * FROM java_swing_register_member";
            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);) {

                while (resultSet.next()) {
                    // 읽어온 값을 사용하여 UserDTO 객체를 생성
                    UserDTO user = selectUserResultSet(resultSet);

                    // Test: UserDTO 객체의 toString 메서드를 호출하여 사용자 정보를 출력
                    System.out.println(user.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("오류 발생.");
            e.getStackTrace();
        }
    }

    /* 사용자 등록(회원가입) */
    public static boolean registerUser(String userId, String password, String address, String gender, String phone, String birth) {
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.out.println("데이터베이스 연결에 실패했습니다.");
                return false;
            }
            return insertUser(conn, userId, password, address, gender, phone, birth);
        } catch (Exception e) {
            System.out.println("오류 발생.");
            e.getStackTrace();
            return false;
        }
    }
}