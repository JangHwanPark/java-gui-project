package test;

import model.AdminUser;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAdminUser {
    @Test
    public void testAdminUserCreation() {
        // AdminUser 객체 생성
        AdminUser admin = new AdminUser(1, "admin01", "password123", "1234 Admin St", "Male", "superadmin");

        // 객체 생성 검증
        assertNotNull("AdminUser 객체는 null이 아니어야 합니다.", admin);
        assertEquals("사용자 번호가 생성자 입력과 일치해야 합니다.", 1, admin.getUserNo());
        assertEquals("사용자 ID가 생성자 입력과 일치해야 합니다.", "admin01", admin.getUserId());
        assertEquals("비밀번호가 생성자 입력과 일치해야 합니다.", "password123", admin.getPassword());
        assertEquals("주소가 생성자 입력과 일치해야 합니다.", "1234 Admin St", admin.getAddress());
        assertEquals("성별이 생성자 입력과 일치해야 합니다.", "Male", admin.getGender());
        assertEquals("역할이 생성자 입력과 일치해야 합니다.", "superadmin", admin.getRole());
    }

    @Test
    public void testManageUsersMethod() {
        // AdminUser 객체 생성
        AdminUser admin = new AdminUser(2, "admin02", "password234", "2345 Admin Rd", "Female", "admin");

        // 관리자 권한 메소드 호출을 위한 적절한 설정이 필요할 수 있음
        // 예를 들어, manageUsers 메소드가 실제로 작동하는지 콘솔 출력 등으로 검증 가능
        admin.manageUsers();
    }
}