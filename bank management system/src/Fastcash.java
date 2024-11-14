import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;

    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atmm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,850,850);
        add(Image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(315,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        Image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(275,377,130,25);
        deposit.addActionListener(this);
        Image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(445,377,130,25);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(275,407,130,25);
        fastcash.addActionListener(this);
        Image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(445,407,130,25);
        ministatement.addActionListener(this);
        Image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(275,437,130,25);
        pinchange.addActionListener(this);
        Image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(445,437,130,25);
        balanceenquiry.addActionListener(this);
        Image.add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(445,467,130,25);
        exit.addActionListener(this);
        Image.add(exit);


        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }


    public static void main(String[] args) {
        new Fastcash("");
    }
}
