package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserView extends JFrame {
    private JTextField userIdField, passwordField, addressField, phoneField, birthField;
    private JComboBox<String> genderComboBox;
    private JButton submitButton;

    public UserView() {
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10)); // JFrame에 패딩 추가

        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        add(new JLabel("아이디:"));
        userIdField = new JTextField(20);
        add(userIdField);

        add(new JLabel("비밀번호:"));
        passwordField = new JTextField(20);
        add(passwordField);

        add(new JLabel("주소:"));
        addressField = new JTextField(20);
        add(addressField);

        add(new JLabel("성별:"));
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        add(genderComboBox);

        add(new JLabel("휴대폰 번호:"));
        phoneField = new JTextField(20);
        add(phoneField);

        add(new JLabel("생년월일 (YYYY-MM-DD):"));
        birthField = new JTextField(20);
        add(birthField);

        submitButton = new JButton("회원가입");
        add(submitButton);
    }

    public JTextField getUserIdField() {
        return userIdField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getBirthField() {
        return birthField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}