package Model;

import Utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static Connection getConnection() throws SQLException {
        return ConnectDB.initDB();  // DB 연결 메서드 반환
    }

    /* DB 내 유저 데이터 조회 */
    private static UserDTO selectUserResultSet(ResultSet resultSet) throws SQLException {
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
    public static boolean insertUser(UserDTO user) throws SQLException {
        String sql = "INSERT INTO java_swing_register_member(user_id, user_pwd, address, gender, phone, birth) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getBirth());
            return pstmt.executeUpdate() > 0;
        }
    }

    /* DB 내 유저 데이터 삭제 */
    public static boolean deleteUser(String userId) throws SQLException {
        // sql user_id 의 ? 부분을 동적으로 대체
        String sql = "DELETE FROM java_swing_register_member WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Test: 전체 유저 조회
    public static List<UserDTO> selectAllUserList() {
        List<UserDTO> users = new ArrayList<>();
        // 데이터 베이스
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.out.println("데이터베이스 연결에 실패했습니다.");
                return users;
            }

            String sql = "SELECT * FROM java_swing_register_member";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    // 읽어온 값을 사용하여 UserDTO 객체를 생성하고 배열에 삽입
                    UserDTO user = selectUserResultSet(resultSet);
                    users.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println("오류 발생.");
            e.getStackTrace();
        }
        return users;
    }

    /* 주어진 userId에 해당하는 사용자 조회 */
    public static UserDTO findUserByName(String userId) throws SQLException {
        String sql = "SELECT * FROM java_swing_register_member WHERE user_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Test OK");
                    return selectUserResultSet(resultSet);
                }
            }
        }
        System.out.println("Test Fail");
        return null;  // 사용자가 존재하지 않는 경우
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(UserDAO.findUserByName("testUser"));
    }
}