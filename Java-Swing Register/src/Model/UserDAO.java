package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        // Debuglog
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        try {
            // 데이터베이스 드라이버 클래스 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스에 연결
            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn != null) { // Success: 연결 성공
                System.out.println("데이터베이스에 성공적으로 연결되었습니다.");
                conn.close(); // 데이터베이스 연결 종료
            }
        } catch (ClassNotFoundException e) { // Fail: 연결 실패
            System.out.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.printStackTrace();
        }
    }
}