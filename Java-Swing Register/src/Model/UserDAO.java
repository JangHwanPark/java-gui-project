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
                // Test: Query
                String sql = "SELECT * FROM java_swing_register_member";

                // Test: Create Statement Obj
                Statement statement = conn.createStatement();

                // Test: Query Start
                ResultSet resultSet = statement.executeQuery(sql);
                System.out.println("data: " + resultSet);

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