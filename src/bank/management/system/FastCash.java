
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    
    JButton amt1,amt2,amt4,amt5,amt3,amt6,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(185,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raelway",Font.BOLD,16));
        image.add(text);
        
        
         amt1=new JButton("Rs 100");
        amt1.setBounds(150,355,135,30);
        amt1.addActionListener(this);
        image.add(amt1);
        
          amt2=new JButton("Rs 500");
        amt2.setBounds(315,355,135,30);
         amt2.addActionListener(this);
        image.add(amt2);
        
          amt3=new JButton("Rs 1000");
        amt3.setBounds(150,390,135,30);
         amt3.addActionListener(this);
        image.add(amt3);
        
         amt4=new JButton("Rs 2000");
        amt4.setBounds(315,390,135,30);
         amt4.addActionListener(this);
        image.add(amt4);
        
          amt5=new JButton("Rs 5000");
        amt5.setBounds(150,425,135,30);
         amt5.addActionListener(this);
        image.add(amt5);
        
         amt6=new JButton("Rs 10000");
        amt6.setBounds(315,425,135,30);
         amt6.addActionListener(this);
        image.add(amt6);
        
         back=new JButton("Back");
        back.setBounds(315,460,135,30);
         back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
           String amount=((JButton)ae.getSource()).getText().substring(3);
           Conn c=new Conn();
           try{
              ResultSet rs=c.s.executeQuery("select * from Bank where Pin= '"+pinnumber+"'");
                       int balance=0;
                      while(rs.next()){
                          if(rs.getString("type").equals("Deposit")){
                              balance +=Integer.parseInt(rs.getString("amount"));
                          }else{
                              balance -=Integer.parseInt(rs.getString("amount"));
                          }
                      }
                      
                      if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficiant Balance");
                        return;
                      }
                      Date Date=new Date();
                       String query="Insert into Bank values('"+pinnumber+"','"+Date+"','Withdrawl','"+amount+"')";
                       c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null, "Rs "+amount+ "Debited Successfully" );
                       
                       setVisible(false);
                       new Transactions(pinnumber).setVisible(true);
                          
                      
                      
               
           }catch(Exception e){
               System.out.println(e);
           }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}


