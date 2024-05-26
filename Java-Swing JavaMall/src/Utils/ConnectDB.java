package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JDBC";
    private static final String USER = "root";
    private static final String PASSWORD = "qwer1124";

    public static Connection initDB() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "qwer1124");
    }
}
