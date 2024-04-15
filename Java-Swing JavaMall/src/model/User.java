package model;

public abstract class User {
    // Admin, Normal 사용자 공통 필드 정의
    protected int userNo;
    protected String userId;
    protected String password;
    protected String address;
    protected String gender;

    // 생성자
    public User(int userNo, String userId, String password, String address, String gender) {
        this.userNo = userNo;
        this.userId = userId;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    // 필드 접근을 위한 게터 세터
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User {" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}