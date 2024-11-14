import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);
        add(label);

        JLabel text = new JLabel("AUTOMATED TALLER MACHINE");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200,40,600,55);
        add(text);


        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardno.setBounds(150,130,400,55);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,145,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);


        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,25));
        pin.setBounds(150,180,400,55);
        add(pin);

        pinTextField = new JPasswordField( );
        pinTextField.setBounds(300,195,250,30);
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(300,250,100,33);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(450,250,100,33);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(350,300,150,33);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

       getContentPane().setBackground(Color.lightGray);

        setTitle("AUTOMATED TALLER MACHINE");
        setSize(800,400);
        setVisible(true);
        setLocation(250,150);
    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardno = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ac.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if(ac.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
