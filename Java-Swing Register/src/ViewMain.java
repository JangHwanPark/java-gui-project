import Model.UserDAO;
import javax.swing.*;

public class ViewMain extends JFrame {
    private JPanel panel;

    public ViewMain() {
        setTitle("Java-Swing Register Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);

        // 프레임 생성 및 프레임에 패널 추가
        panel = new JPanel();
        add(panel);
        placeComponents(panel);
        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JButton registerButton = new JButton("회원가입");
        registerButton.setBounds(10, 80, 80, 25);
        panel.add(registerButton);

        // 버튼 액션 리스너 추가 (예시)
        registerButton.addActionListener(e -> {
            System.out.println("회원가입 버튼 클릭");
        });
    }

    public static void main(String[] args) {
        // Test
        UserDAO u = new UserDAO();
        u.selectAllUserList();

        //SwingUtilities.invokeLater(ViewMain::new);
    }
}