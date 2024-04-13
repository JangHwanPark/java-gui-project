package Model;

import Utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Connection 객체의 참조값 반환하는 함수 (com.mysql.cj.jdbc.ConnectionImpl@37ceb1df / 참조값은 언제나 변경가능함)
    private static Connection getConnection() throws SQLException {
        System.out.println("Connection Reference Value: " + ConnectDB.initDB());
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
        // 실행할 쿼리문 sql 변수에 저장
        String sql = "INSERT INTO java_swing_register_member(user_id, user_pwd, address, gender, phone, birth) VALUES (?, ?, ?, ?, ?, ?)";

        // Connection 및 PreparedStatement 객체의 참조값 얻어오기
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {    //
            // getter 로 필드값을 가져와서 쿼리문(? 부분에 순차적으로)에 삽입
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getBirth());

            /*
             * sql 문 실행 (executeUpdate: DB 내 데이터 변경 쿼리 실행)
             * 하나 이상의 행이 추가, 수정 또는 삭제되었다면, executeUpdate()는 0보다 큰 값을 반환
             * INSERT 문 실행: 삽입된 행의 수를 반환
             */
            System.out.println("삽입 작업이 완료되었습니다. 연결이 종료되었습니다.");
            return pstmt.executeUpdate() > 0;   // 6 > 0 = true
        } catch (SQLException e) {
            System.err.println("회원가입에 실패했습니다.: " + e.getMessage());
            throw new SQLException("회원가입중 오류가 발생했습니다.", e);
        }
    }

    /* DB 내 유저 데이터 삭제 */
    public static boolean deleteUser(UserDTO userDTO) throws SQLException {
        // sql user_id 의 ? 부분을 동적으로 대체
        String sql = "DELETE FROM java_swing_register_member WHERE user_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // sql 변수의 WHERE 절의 ? 에 필요한값 바인딩하기
            pstmt.setString(1, userDTO.getUserId());

            // DELETE 문 실행: 삭제된 행의 수를 반환
            System.out.println("삭제 작업이 완료되었습니다. 연결이 종료되었습니다.");
            return pstmt.executeUpdate() > 0;
        }
    }

    // Test: 전체 유저 조회
    public static List<UserDTO> selectAllUserList() {
        List<UserDTO> users = new ArrayList<>();
        // 데이터 베이스
        try (Connection conn = getConnection()) {
            // 실행할 쿼리문 sql 변수에 저장
            String sql = "SELECT * FROM java_swing_register_member";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    users.add(selectUserResultSet(resultSet));
                }
            }
            System.out.println("전체 유저 조회 작업이 완료되었습니다. 연결이 종료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return users;
    }

    /* 주어진 userId에 해당하는 사용자 조회 */
    public static UserDTO findUserByName(String userId) throws SQLException {
        // 실행할 쿼리문 sql 변수에 저장
        String sql = "SELECT * FROM java_swing_register_member WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) return selectUserResultSet(resultSet);
            }
            System.out.println("검색 작업이 완료되었습니다. 연결이 종료되었습니다.");
        }
        return null;  // 사용자가 존재하지 않는 경우
    }

    /* userId 에 해당하는 사용자의 정보를 수정 */
    public static boolean updateUser(UserDTO userDTO) throws SQLException {
        // 어떤 정보도 null일 수 없다고 가정
        if (userDTO == null) {
            throw new IllegalArgumentException("모든 정보를 제공해야 합니다.");
        }

        // 실행할 쿼리문 sql 변수에 저장
        String sql = "UPDATE java_swing_register_member SET user_pwd = ?, address = ?, phone = ? WHERE " +
                "user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userDTO.getPassword());
            pstmt.setString(2, userDTO.getAddress());
            pstmt.setString(3, userDTO.getPhone());
            pstmt.setString(4, userDTO.getUserId());

            // UPDATE 문 실행: 업데이트된 행의 수를 반환
            System.out.println("수정 작업이 완료되었습니다. 연결이 종료되었습니다.");
            return pstmt.executeUpdate() > 0;
        }
    }
}