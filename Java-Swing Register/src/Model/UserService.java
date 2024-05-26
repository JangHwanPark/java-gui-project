package Model;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserService {
    // 디폴트 생성자
    public UserService() {}

    // 사용자 등록(회원가입)
    public boolean registerUser(UserDTO userDTO) throws SQLException {
        if (!validateInput(userDTO)) {
            System.out.println("필수 입력 필드가 누락되었습니다.");
            return false;
        }
        
        if (!validateUserId(userDTO.getUserId())) {
            System.out.println("사용자 ID가 형식에 맞지 않습니다.");
            return false;
        }
        
        if (!validatePassword(userDTO.getPassword())) {
            System.out.println("비밀번호 조건을 만족하지 못했습니다.");
            return false;
        }
        
        if (UserDAO.selectUserExists(userDTO.getUserId())) {
            System.out.println("이미 존재하는 사용자 ID입니다.");
            return false;
        }
        try {
            return UserDAO.insertUser(userDTO);
        } catch (Exception e) {
            System.out.println("회원가입 중 오류 발생: " + e.getMessage());
            return false;
        }
    }

    // 입력값 검증: 필수 입력 필드가 비어있는지 확인
    private boolean isFieldEmpty(String field) {
        return field == null || field.trim().isEmpty();
    }

    private boolean validateInput(UserDTO userDTO) {
        return !(isFieldEmpty(userDTO.getUserId()) ||
                isFieldEmpty(userDTO.getPassword()) ||
                isFieldEmpty(userDTO.getAddress()) ||
                isFieldEmpty(userDTO.getPhone()) ||
                isFieldEmpty(userDTO.getBirth()) ||
                isFieldEmpty(userDTO.getGender()));
    }

    // 사용자 ID 유효성 검증
    private boolean validateUserId(String userId) {
        String userIdRegex = "^[a-zA-Z0-9_]{5,15}$"; // 5자 이상 15자 이하, 알파벳과 숫자만 허용
        return Pattern.matches(userIdRegex, userId);
    }

    // 비밀번호 유효성 검증
    private boolean validatePassword(String password) {
        // 조정된 조건
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        return Pattern.matches(passwordPattern, password);
    }

    // 사용자 삭제(회원 탈퇴)
    public boolean deleteUser(UserDTO userDTO) {
        try {
            return UserDAO.deleteUser(userDTO);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            return false;
        }
    }
}