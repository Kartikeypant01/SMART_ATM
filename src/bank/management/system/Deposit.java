
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount You Want To Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raelway",Font.BOLD,16));
            text.setBounds(145,250,700,35);
            image.add(text);
            
            amount=new JTextField();
            amount.setFont(new Font("Raelway",Font.BOLD,22));
            amount.setBounds(145,300,310,25);
            image.add(amount);
            
             deposit=new JButton("Deposit");
            deposit.setBounds(320,425,130,30);
            deposit.addActionListener(this);
            image.add(deposit);
            
              back=new JButton("Back");
            back.setBounds(320,460,130,30);
             back.addActionListener(this);
            image.add(back);
        
        
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==deposit){
           String number=amount.getText();
           Date Date=new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
           }else{
               try{
               Conn conn=new Conn();
               String query="insert into Bank values('"+pinnumber+"','"+Date+"','Deposit','"+number+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
               
           }catch(Exception e){
                   System.out.println(e);
           }
           }
            
        }else if(ae.getSource()==back){
             setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
