import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atmm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,850,850);
        add(Image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(315,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        Image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(275,377,130,25);
        deposit.addActionListener(this);
        Image.add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(445,377,130,25);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(275,407,130,25);
        fastcash.addActionListener(this);
        Image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(445,407,130,25);
        ministatement.addActionListener(this);
        Image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(275,437,130,25);
        pinchange.addActionListener(this);
        Image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(445,437,130,25);
        balanceenquiry.addActionListener(this);
        Image.add(balanceenquiry);

        exit = new JButton("Exit");
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
            System.exit(0);
        }

        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }

    }


    public static void main(String[] args) {
        new Transactions("");
    }
}
