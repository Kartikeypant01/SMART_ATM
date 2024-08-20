
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
Login(){
    setLayout(null);
setTitle("AUTOMATED TELLR MACHINE");
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(70,10,100,100);
add(label);

JLabel text=new JLabel("Welcome to ATM");
text.setFont(new Font("Osward",Font.BOLD,38));
text.setBounds(200,40,400,40);
add(text);

JLabel pin=new JLabel("PIN:");
pin.setFont(new Font("Raleway",Font.BOLD,28));
pin.setBounds(200,220,400,30);
add(pin);

 pinTextField=new JPasswordField();
pinTextField.setBounds(350, 220, 230, 30);
pinTextField.setFont(new Font("Arial",Font.BOLD,14));
add(pinTextField);

JLabel CardNo=new JLabel("Card No:");
CardNo.setFont(new Font("Raleway",Font.BOLD,28));
CardNo.setBounds(200,150,400,30);
add(CardNo);

cardTextField=new JTextField();
cardTextField.setBounds(350, 150, 230, 30);
cardTextField.setFont(new Font("Arial",Font.BOLD,14));
add(cardTextField);

 login=new JButton("SIGN IN");
login.setBounds(350,300,100,30);
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
login.addActionListener(this);
add(login);

 clear=new JButton("Clear");
clear.setBounds(480,300,100,30);
clear.setBackground(Color.BLACK);
clear.setForeground(Color.WHITE);
clear.addActionListener(this);
add(clear);

signUp=new JButton("SIGN UP");
signUp.setBounds(350,350,230,30);
signUp.setBackground(Color.BLACK);
signUp.setForeground(Color.WHITE);
signUp.addActionListener(this);
add(signUp);

getContentPane().setBackground(Color.WHITE);
setSize(800,480);
setVisible(true);
setLocation(350,200);
    
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==clear){
        cardTextField.setText("");
        pinTextField.setText("");
        
    }
    else if(ae.getSource()==login){
        
        Conn conn=new Conn();
        String cardnumber= cardTextField.getText();
        String pinnumber=pinTextField.getText();
        String query="select * from Login where Card_Number='"+cardnumber+"' and Pin='"+pinnumber+"'";
        try{
            
            ResultSet rs=conn.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    else if(ae.getSource()==signUp){
        
        setVisible(false);
        new SignupOne().setVisible(true);
        
    }
}

    public static void main(String[] args) {
        new Login();
    }
    
}
