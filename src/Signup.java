import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Signup {
    JFrame f;
    JTextField uN, ps;
    JLabel l1, l2, l3;
    JButton b1;
    String name, pass;

    public Signup() {
        f = new JFrame("Signup!");
        f.setSize(380, 390);
        uN = new JTextField(10);
        uN.setBounds(140, 70, 165, 35);
        ps = new JTextField(10);
        ps.setBounds(140, 110, 165, 35);
        
        b1 = new JButton("SignUp");
        b1.setBounds(200, 170, 100, 25);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    name = uN.getText();
                    pass = ps.getText();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ict", "root", "1234");
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into signup values ('" + name + "','" + pass + "');");
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ve) {
                    ve.printStackTrace();
                }
                uN.setText("");
                ps.setText("");
            }

        });

        l1 = new JLabel("User Name ");
        l1.setBounds(60, 70, 70, 35);
        l2 = new JLabel("Password ");
        l2.setBounds(60, 110, 70, 35);
        l3 = new JLabel("Signup");
        l3.setBounds(170, 30, 70, 35);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(uN);
        f.add(b1);
        f.add(ps);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new Signup();
    }
}
