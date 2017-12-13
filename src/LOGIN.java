import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnect.*;


public class LOGIN {
    private JPanel panel1;
    private JTextField userField;
    private JPasswordField pwField;
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
                String username=userField.getText();
                String pw=String.valueOf(pwField.getPassword());
                loginCheck(username,pw);
            }
        });
    }

    public static void main(String[] args) {
        loginFR.setContentPane(new LOGIN().panel1);
        loginFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFR.pack();
        loginFR.setVisible(true);
    }//

    private void loginCheck(String frusername,String frPW)
    {
        String inusername=null;
        String inpw=null;
        dbConnect dbConn=new dbConnect();
        Statement stml=null;
        try {
            String query = "SELECT * FROM userdetails where UserName='"+frusername+"'";
            stml =dbConn.Conn2DB();
            ResultSet RS =stml.executeQuery(query);
            RS.first();
            inusername=frusername;
            inpw=RS.getString("Password");

        }
        catch (SQLException SE)
        {
            SE.printStackTrace();
        }


        if(frusername.equals(inusername)&&frPW.equals(inpw)) {
            JOptionPane.showMessageDialog(null, "Username and Password correct");
            loginFR.setVisible(false);
            new UseDetails(frusername);
        }else JOptionPane.showMessageDialog(null,"Incorrect");
    }
}
