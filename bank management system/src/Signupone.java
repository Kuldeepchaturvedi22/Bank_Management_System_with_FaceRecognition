import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,others;
    JButton next;

    Signupone(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Arial",Font.BOLD,30));
        formno.setBounds(165,20,600,30);
        add(formno);

        JLabel personDetails = new JLabel("PAGE 1: Personal Details");
        personDetails.setFont(new Font("Arial",Font.BOLD,20));
        personDetails.setBounds(255,60,600,30);
        add(personDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(100,110,100,30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(350,115,300,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's name :");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(100,160,200,30);
        add(fname);

         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTextField.setBounds(350,165,300,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(100,210,200,30);
        add(dob);

         dateChooser = new JDateChooser();
        dateChooser.setBounds(350,215,300,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(100,260,200,30);
        add(gender);

         male = new JRadioButton("MALE");
        male.setBounds(350,265,100,30);
        male.setFont(new Font("Arial",Font.BOLD,15));
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("FEMALE");
        female.setBounds(560,265,100,30);
        female.setFont(new Font("Arial",Font.BOLD,15));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(100,310,200,30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(350,315,300,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(100,360,200,30);
        add(marital);

         married = new JRadioButton("MARRIED");
        married.setBounds(350,365,100,30);
        married.setFont(new Font("Arial",Font.BOLD,14));
        married.setBackground(Color.WHITE);
        add(married);

         unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,365,110,30);
        unmarried.setFont(new Font("Arial",Font.BOLD,14));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

         others = new JRadioButton("OTHERS");
        others.setBounds(565,365,100,30);
        others.setFont(new Font("Arial",Font.BOLD,14));
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup msgroup = new ButtonGroup();
        msgroup.add(married);
        msgroup.add(unmarried);
        msgroup.add(others);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(100,410,200,30);
        add(address);

         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(350,415,300,30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(100,460,200,30);
        add(city);

         cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(350,465,300,30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(100,510,200,30);
        add(state);

         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(350,515,300,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(100,560,200,30);
        add(pincode);

         pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(350,565,300,30);
        add(pinTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.setBounds(500,630,150,33);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);


        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String formno = ""+random; // long
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob =  ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(others.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new Signupone();
    }
}

