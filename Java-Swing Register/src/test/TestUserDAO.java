package test;

import Model.UserDAO;
import Model.UserDTO;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@DisplayName("UserDAO 테스트")
public class TestUserDAO {
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();    // 데이터베이스 연결 및 초기화
    }

    @Test
    @DisplayName("가입된 모든 사용자를 불러와야 함")
    public void testSelectAllUser() {
        // When: DB 내 유저 데이터 조회
        List<UserDTO> users = UserDAO.selectAllUserList();

        // Then: 반환된 사용자목록 확인
        assertNotNull("사용자 목록이 null이면 안됩니다.", users);
        assertFalse("사용자 목록이 비어있으면 안됩니다.", users.isEmpty());
    }

    @Test
    @DisplayName("유효한 데이터로 회원가입시 DB에 데이터가 저장되어야 함")
    public void testInsertUser() throws SQLException {
        // Given: 동일한 아이디(테스트계정)가 존재한다면 삭제하는 테스트 로직 추가
        UserDAO.deleteUser("testUser");

        // When: 회원가입 진행
        UserDTO newUser = new UserDTO("testUser", "password", "address", "M", "phone", "birth");
        boolean isSaveUser = UserDAO.insertUser(newUser);
        assertTrue("새 사용자가 저장되어야 함", isSaveUser);

        // Then: 삽입된 유저정보 확인
        UserDTO savedUser = UserDAO.findUserByName("testUser");
        System.out.println(savedUser.getUserId());

        // savedUser가 null이 아닐 때만 getUserId() 호출
        assertEquals("사용자 이름이 일치해야 함", "testUser", savedUser.getUserId());
    }

    @Test
    @DisplayName("회원 탈퇴, 삭제시 데이터베이스 내 데이터가 삭제되어야 함")
    public void testDeleteUser() throws SQLException {
        // Given: 계정 삭제를 위한 테스트 계정 생성
        UserDTO userToDelete = new UserDTO("testUser1", "password", "address", "F", "phone", "birth");
        UserDAO.insertUser(userToDelete);

        // When: 회원탈퇴 진행
        boolean isDeleted = UserDAO.deleteUser("testUser1");
        assertTrue("사용자가 삭제되어야 함", isDeleted);

        // Then: 회원탈퇴 결과 확인
        UserDTO deletedUser = UserDAO.findUserByName("testUser1");
        assertNull("삭제된 사용자는 불러올 수 없어야 함", deletedUser);
    }
}