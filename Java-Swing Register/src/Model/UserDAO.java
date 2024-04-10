package Model;

import Utils.ConnectDB;
import java.sql.*;

public class UserDAO {
    public void selectUser() {
        // DB 유틸함수 호출
        Connection conn = ConnectDB.initDB();
        System.out.println(ConnectDB.initDB());

        try {
            if (conn != null) {
                String sql = "SELECT * FROM java_swing_register_member"; // Test: Query
                Statement statement = conn.createStatement(); // Test: Create Statement Obj
                ResultSet resultSet = statement.executeQuery(sql); // Test: Query Start

                while (resultSet.next()) {
                    // ResultSet에서 각 컬럼의 값을 읽어옴
                    int userNumber = resultSet.getInt("user_no");
                    String userId = resultSet.getString("user_id");
                    String password = resultSet.getString("user_pwd");
                    String address = resultSet.getString("address");
                    String gender = resultSet.getString("gender");
                    String phone = resultSet.getString("phone");
                    String birth = resultSet.getString("birth");

                    // 읽어온 값을 사용하여 UserDTO 객체를 생성
                    UserDTO user = new UserDTO(userNumber, userId, password, address, gender, phone, birth);

                    // Test: UserDTO 객체의 toString 메서드를 호출하여 사용자 정보를 출력
                    System.out.println(user.toString());
                }

                resultSet.close();  // 쿼리 결과를 담고 있는 ResultSet 종료
                statement.close();  // SQL 실행을 위한 Statement 객체 종료
                conn.close();       // 데이터베이스 연결 종료
            } else {
                System.out.println("데이터베이스 연결에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("오류 발생");
            e.getStackTrace();
        }
    }

    // Test
    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        u.selectUser();
    }
}