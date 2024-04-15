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

        // 데이터 베이스 연결 실패시 예외 처리
        try (Connection conn = ConnectDB.initDB()) {
            if (conn == null) {
                System.out.println("데이터베이스 연결에 실패했습니다.");
                return categories;
            }

            // 카테고리 테이블에서 모든 데이터 출력
            String sql = "SELECT * FROM Category";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 // 준비된 커리를 실행할 PreparedStatement의 객체를 생성
                 ResultSet resultSet = pstmt.executeQuery()) {

                while (resultSet.next()) {
                    // ResultSet에서 카테고리 정보를 읽어와서 CategoryDTO 객체를 생성하여 리스트에 추가
                    // 카테고리 테이블의 행 category_id,category_name 를 가져와 해당 변수에 저장
                    int categoryId = resultSet.getInt("category_id");
                    String categoryName = resultSet.getString("category_name");
                    // DTO 객체 생성 categoryId, categoryName를 파라미터 값으로 설정
                    CategoryDTO category = new CategoryDTO(categoryId, categoryName);
                    categories.add(category); // 생성된 category 객체를 카테고리 List 에 추가
                }
            }
        } catch (SQLException e) { // SQL에 대한 예외가 발생할 경우 메세지 출
            System.out.println("오류 발생: " + e.getMessage());
        }

        return categories;
    }

}
