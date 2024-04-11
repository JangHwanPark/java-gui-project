package test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import Model.UserDAO;
import Model.UserDTO;
import java.util.List;
import static org.junit.Assert.*;

@DisplayName("UserDAO 테스트")
public class TestUserDAO {
    @Test
    @DisplayName("유효한 데이터로 회원가입 시 성공해야 함")
    public void testRegisterUser() {
        // When: 회원가입 진행
        boolean result = UserDAO.registerUser("testUser", "password", "address", "M", "phone", "birth");
        
        // Then: 회원가입 결과 확인
        assertTrue("회원가입 실패", result);
    }

    @Test
    @DisplayName("가입된 모든 사용자를 불러와야 함")
    public void testSelectAllUser() {
        UserDAO userDAO = new UserDAO();    // Given: UserDAO 객체 생성
        List<UserDTO> users = userDAO.selectAllUserList();        // When: DB 내 유저 데이터 조회

        // Then: 반환된 사용자목록 확인
        assertNotNull("사용자 목록이 null이면 안됩니다.", users);
        assertFalse("사용자 목록이 비어있으면 안됩니다.", users.isEmpty());
    }
}