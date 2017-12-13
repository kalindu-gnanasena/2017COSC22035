import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import DBConnect.*;

public class UseDetails extends JFrame{
    private JPanel panel1;
    private JTextField txtUserName;
    private JTextField txtconno;
    private JTextField txtGpa;
    private JButton LOGOUTButton;
    private JButton COURSESButton;
    private JTextField txtemail;

    public UseDetails(String username) {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        txtUserName.setText(username);
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

public void fillDetails(String frUsername)
{

    String username=frUsername;
    dbConnect dbconn=new dbConnect();
    Statement stl=null;
    try {
        String query = "SELECT * FROM userdetails where UserName='"+username+"'";
        stl =dbconn.Conn2DB();
        ResultSet RS =stl.executeQuery(query);

        RS.first();

}
}
