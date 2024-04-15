package Model;

import Utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    // 모든 카테고리 출력 메서드
    public static List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Category");
             // 준비된 커리를 실행할 PreparedStatement 의 객체를 생성
             ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_no");
                String categoryName = resultSet.getString("category_name");
                CategoryDTO category = new CategoryDTO(categoryId, categoryName);
                // DTO 객체 생성 categoryId, categoryName를 파라미터 값으로 설정

                categories.add(category); // 생성된 category 객체를 카테고리 List 에 추가
            }
        } catch (SQLException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }

        return categories;
    }

    // 카테고리 생성 메서드
    public static boolean createCategory(CategoryDTO category) {
        boolean success = false;

        try (Connection conn = getConnection();
             // 카테고리의 이름을 SQL 에 설정 : 카테고리의 no은 자동으로 1씩 증가하게 AUTO 를 넣은 상황임
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Category (category_name) VALUES (?)")) {

            pstmt.setString(1, category.getCategoryName());
            int rowsAffected = pstmt.executeUpdate();

            // 생성되는 카테고리의 no가 0보다 클 경우 생 -> 생성에 성공 후 success = true
            if (rowsAffected > 0) {
                System.out.println("카테고리가 성공적으로 생성되었습니다.");
                success = true;
            }
        } catch (SQLException e) { // 예외 상생 발생시 콘솔에 에러 나올 수 있게 설정
            System.out.println("카테고리 생성 중 오류 발생: " + e.getMessage());
        }

        return success;
    }

    // 데이터베이스 연결 메서드
    private static Connection getConnection() throws SQLException {
        return ConnectDB.initDB();
    }
}
