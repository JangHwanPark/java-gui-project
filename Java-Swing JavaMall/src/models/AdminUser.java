package models;

public class AdminUser extends User {
    // 관리자 권한을 나타내는 필드
    private String role; // 예를 들어, "superadmin", "editor" 등의 역할

    // 생성자
    public AdminUser(int userNo, String userId, String password, String address, String gender, String role) {
        super(userNo, userId, password, address, gender);
        this.role = role;
    }

    // 권한에 접근하기 위한 게터와 세터
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // 관리자 권한
    public void manageUsers() {
        System.out.println("사용자 권한: " + role);
    }

    // toString 메소드 오버라이드
    @Override
    public String toString() {
        // 부모 클래스의 toString 메소드를 확장
        return super.toString() + ", role='" + role + '\'';
    }
}