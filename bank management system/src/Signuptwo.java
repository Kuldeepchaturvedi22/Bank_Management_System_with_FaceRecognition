
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signuptwo extends JFrame implements ActionListener {
    JTextField addressTextField, cityTextField;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion,education,category,occupation,income;
    JLabel aadharno,panno,state,pincode;

    String formno;

    Signuptwo(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM -- PAGE 2");

        JLabel additionalDetails = new JLabel("PAGE 2: Additional Details");
        additionalDetails.setFont(new Font("Arial",Font.BOLD,20));
        additionalDetails.setBounds(255,60,600,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(100,110,100,30);
        add(name);


        String valReligion[] = {"Select","Hindu","Muslim","Christion","Sikh","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(350,115,300,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(100,160,200,30);
        add(fname);

        String valCategory[] = {"Select","General","OBC","SC","ST","Others"};
        category = new JComboBox(valCategory);
        category.setBounds(350,165,300,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(100,210,200,30);
        add(dob);

        String valIncome[] = {"Select","Nill","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(350,215,300,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);



        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(100,300,200,30);
        add(email);


        String valEducation[] = {"Select","Non Graduate","Graduate","Post Graduate","Doctorate","Others"};
        education = new JComboBox(valEducation);
        education.setBounds(350,290,300,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(100,360,200,30);
        add(marital);


        String valOccupation[] = {"Select","Salaried","Self-Employed","Businesses","Student","Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(350,365,300,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        panno = new JLabel("Pan no. :");
        panno.setFont(new Font("Arial",Font.BOLD,20));
        panno.setBounds(100,410,200,30);
        add(panno);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(350,415,300,30);
        add(addressTextField);

        aadharno = new JLabel("Aadhar no. :");
        aadharno.setFont(new Font("Arial",Font.BOLD,20));
        aadharno.setBounds(100,460,200,30);
        add(aadharno);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(350,465,300,30);
        add(cityTextField);

        state = new JLabel("Senior citizen :");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(100,510,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(350,510,100,30);
        syes.setFont(new Font("Arial",Font.BOLD,14));
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,510,110,30);
        sno.setFont(new Font("Arial",Font.BOLD,14));
        sno.setBackground(Color.WHITE);
        add(sno);


        ButtonGroup msgroup = new ButtonGroup();
        msgroup.add(syes);
        msgroup.add(sno);

        pincode = new JLabel("Existing Account :");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(100,560,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(350,560,100,30);
        eyes.setFont(new Font("Arial",Font.BOLD,14));
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,560,110,30);
        eno.setFont(new Font("Arial",Font.BOLD,14));
        eno.setBackground(Color.WHITE);
        add(eno);


        ButtonGroup esgroup = new ButtonGroup();
        esgroup.add(eyes);
        esgroup.add(eno);


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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String)  category.getSelectedItem();
        String sincome =   (String)  income.getSelectedItem();
        String seducation =   (String)  education.getSelectedItem();
        String soccupation =   (String)  occupation.getSelectedItem();
        String seniorcitizen = null;

        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }

        String exsisting = null;
        if(eyes.isSelected()){
            exsisting = "Yes";
        }
        else if(eno.isSelected()){
            exsisting = "No";
        }

        String span = panno.getText();
        String saadhar = aadharno.getText();

        try{

                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"','"+exsisting+"')";
                c.s.executeUpdate(query);

                //signupthree object

            setVisible(false);
            new Signupthree(formno).setVisible(true);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new Signuptwo("");
    }
}
