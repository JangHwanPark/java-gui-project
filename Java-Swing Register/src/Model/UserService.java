package Model;

public class UserService {
    private UserDAO userDAO;

    // 생성자를 통한 의존성 주입
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // 회원가입 유효성 검사

    // 사용자 등록(회원가입)
    public boolean registerUser(UserDTO userDTO) {
        try {
            return UserDAO.insertUser(userDTO);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.getStackTrace();
            return false;
        }
    }

    // 사용자 삭제(회원 탈퇴)
    public boolean deleteUser(UserDTO userDTO) {
        try {
            return UserDAO.deleteUser(userDTO);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.getStackTrace();
            return false;
        }
    }
}