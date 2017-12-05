import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JButton exitButton;
    public static JFrame loginFR = new JFrame("Login Screen");

    public LOGIN() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"NOT COMPLETED");
            }
        });
    }

    public static void main(String[] args) {
        loginFR.setContentPane(new LOGIN().panel1);
        loginFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFR.pack();
        loginFR.setVisible(true);
    }
}
