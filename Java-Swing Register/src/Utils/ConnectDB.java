package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public ConnectDB() {}

    public static Connection initDB() {
        // Connection 객체의 참조값(주소값)을 담을 필드 선언
        Connection conn;

        try {
            // 데이터베이스 드라이버 등록 (MySQL JDBC Driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB 연결 객체의 참조값 얻어와서 필드에 담기
            conn = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS")
            );

            if (conn != null) {                 // Success: 연결 성공(Connection 객체를 리턴)
                System.out.println("데이터베이스에 성공적으로 연결되었습니다.");
                return conn;
            }
        } catch (ClassNotFoundException e) {    // Fail: 데이터 베이스 드라이버가 없는 경우
            System.out.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
            e.getStackTrace();
        } catch (SQLException e) {              // Fail: 데이터 베이스 연결에 실패한 경우
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.getStackTrace();
        }

        return null;
    }
}