package test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import Model.UserDAO;
import Model.UserDTO;
import java.util.List;
import static org.junit.Assert.*;

@DisplayName("UserService 테스트")
public class TestUserService {
    @Test
    @DisplayName("입력값의 타입이 일치할 경우 회원가입이 성공해야 함")
    public void testValidateInputTypeMatchesExpected() {

    }

    // TC 하나 이상의 입력이 누락되었을 때 회원가입이 거부되어야 함
    
    // TC [Verification] 아이디는 이메일 형식이어야하며, 유요한 이메일이 아닌 경우 회원가입이 거부되어야 함
    
    // TC [Verification] 비밀번호 길이가 5 ~ 15 미만을 충족하지 않을때 회원가입이 거부되어야 함
    
    // TC [Verification] 비밀번호에 숫자 + 대소문자 + 1개 이상의 특수문자가 포함되어야 함
    
    // TC [Verification] 사용자 이름이 중복된다면 회원가입이 거부되어야 함

    // TC [Boundary Value Analysis] 비밀번호 최소길이, 최대길이를 입력했을때 회원가입이 성공해야 함

    // TC [System Error] 데이터 베이스 연결 실패시, 에러 메세지가 출력되어야 함
    
    // TC [System Error] 회원가입 도중, 프로그램 종료, 네트워크 문제등 예외가 발생했을때 에러 메세지가 출력되어야 함

    // TC [Security] 회원가입 입력창에 SQL 인젝션 공격이 차단되어야 함
}