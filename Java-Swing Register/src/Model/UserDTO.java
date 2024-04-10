package Model;

public class UserDTO {
    // Filed: user info
    private int userNumber;
    private String userId;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private String birth;

    // constructor
    public UserDTO(int userNumber, String userId, String password, String address, String gender, String phone, String birth) {
        this.userNumber = userNumber;
        this.userId = userId;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.birth = birth;
    }

    // Method: Getter/Setter
    public int getUserNumber() { return userNumber; }
    public void setUserNumber(int userNumber) { this.userNumber = userNumber; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String setPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String setBirth() { return birth; }
    public void setBirth(String birth) { this.birth = birth; }

    // Method(Override): toString - 객체 상태(데이터) 출력, 안쓰면 16진? 출력
    @Override
    public String toString() {
        return "User: {" +
                "\n\tuser_no: " + userNumber +
                "\n\tuser_id: " + userId +
                "\n\tpassword: " + password +
                "\n\taddress: " + address +
                "\n\tgender: " + gender +
                "\n\tphone: " + phone +
                "\n\tbirth: " + birth;
    }
}