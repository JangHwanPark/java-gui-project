package Model;

public class UserService {

    /* 사용자 등록(회원가입) */
    public static boolean registerUser(String userId, String password, String address, String gender, String phone, String birth) {
        try {
            return UserDAO.insertUser(new UserDTO(userId, password, address, gender, phone, birth));
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.getStackTrace();
            return false;
        }
    }

    /* 사용자 삭제(회원 탈퇴) */
    public static boolean deleteUser(String userId) {
        try {
            return UserDAO.deleteUser(userId);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.getStackTrace();
            return false;
        }
    }
}