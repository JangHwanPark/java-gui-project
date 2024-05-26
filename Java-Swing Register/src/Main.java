import View.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            UserView userView = new UserView();
        });
    }
}