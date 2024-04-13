package test;

import Model.UserDAO;
import Model.UserDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@DisplayName("UserDAO 테스트")
public class TestUserDAO {
    private UserDTO testUser;

    @Before
    public void setup() throws SQLException {
        // 테스트 데이터 셋업
        testUser = new UserDTO("testUpdateUser", "securePassword", "123 Test St", "M", "1234567890", "2000-01-01");
        UserDAO.insertUser(testUser);
        testUser = UserDAO.findUserByName("testUpdateUser"); // 최신 데이터와 ID를 가져옴
    }

    @After
    public void cleanup() throws SQLException {
        // 테스트 종료 후 모든 테스트 데이터를 정리
        UserDTO testUser = UserDAO.findUserByName("testUser");
        if (testUser != null) {
            UserDAO.deleteUser(testUser);
        }

        UserDTO testUser1 = UserDAO.findUserByName("testUser1");
        if (testUser1 != null) {
            UserDAO.deleteUser(testUser1);
        }

        UserDTO findTestUser = UserDAO.findUserByName("FindTestUser");
        if (findTestUser != null) {
            UserDAO.deleteUser(findTestUser);
        }

        if (testUser != null) {
            UserDAO.deleteUser(testUser);
        }
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
        // Given
        UserDTO testUser = new UserDTO("testUser", "password", "address", "M", "phone", "birth");

        // When
        boolean isSaveUser = UserDAO.insertUser(testUser);
        assertTrue("새 사용자가 저장되어야 함", isSaveUser);

        // Then: 삽입된 유저정보 확인
        UserDTO savedUser = UserDAO.findUserByName("testUser");

        // savedUser가 null이 아닐 때만 getUserId() 호출
        assertEquals("사용자 이름이 일치해야 함", "testUser", Objects.requireNonNull(savedUser).getUserId());
    }

    @Test
    @DisplayName("회원 탈퇴, 삭제시 데이터베이스 내 데이터가 삭제되어야 함")
    public void testDeleteUser() throws SQLException {
        // Given: 계정 삭제를 위한 테스트 계정 생성
        UserDTO userToDelete = new UserDTO("testUser1", "password", "address", "F", "phone", "birth");
        UserDAO.insertUser(userToDelete);

        // 삽입된 사용자 정보를 다시 조회하여 UserNumber를 얻음
        userToDelete = UserDAO.findUserByName("testUser1");
        assertNotNull("삽입 후 사용자 정보를 가져오는데 실패했습니다.", userToDelete);

        // When: 회원탈퇴 진행
        boolean isDeleted = UserDAO.deleteUser(userToDelete);
        assertTrue("사용자가 삭제되어야 함", isDeleted);

        // Then: 회원탈퇴 결과 확인
        UserDTO deletedUser = UserDAO.findUserByName("testUser1");
        assertNull("삭제된 사용자는 불러올 수 없어야 함", deletedUser);
    }

    @Test
    @DisplayName("유효한 데이터로 사용자 검색 시, 사용자 데이터가 검색되어야 함")
    public void testFindUserByName() throws SQLException {
        // Given: 검색을 위한 테스트 계정 생성
        UserDTO newUser = new UserDTO("FindTestUser", "password", "address", "M", "phone", "birth");
        UserDAO.insertUser(newUser);

        // When: 생성된 사용자 정보 조회
        UserDTO foundUser  = UserDAO.findUserByName("FindTestUser");

        // Then: 조회된 유저 정보 확인
        assertNotNull("조회된 사용자가 null이면 안됩니다.", foundUser);
        assertEquals("사용자 이름이 일치해야 함", "FindTestUser", foundUser.getUserId());
    }

    @Test
    @DisplayName("사용자 정보 업데이트 테스트")
    public void testUpdateUser() throws SQLException {
        // Given: 업데이트할 정보
        testUser.setPassword("newPassword123");
        testUser.setAddress("new 456 Test Dr");
        testUser.setPhone("0987654321");

        // When: 사용자 정보 업데이트 실행
        boolean updateResult = UserDAO.updateUser(testUser);

        // Then: 업데이트 결과 검증
        assertTrue("업데이트는 성공해야 합니다.", updateResult);

        // 업데이트된 정보를 검증하기 위해 사용자 정보 재조회
        UserDTO updatedUser = UserDAO.findUserByName("testUpdateUser");

        // 업데이트된 정보를 검증하기 위해 사용자 정보 재조회
        Assert.assertNotNull("업데이트된 사용자 정보는 null이 아니어야 합니다.", updatedUser);
        Assert.assertEquals("비밀번호가 업데이트되어야 합니다.", "newPassword123", updatedUser.getPassword());
        Assert.assertEquals("주소가 업데이트되어야 합니다.", "new 456 Test Dr", updatedUser.getAddress());
        Assert.assertEquals("전화번호가 업데이트되어야 합니다.", "0987654321", updatedUser.getPhone());
    }
}