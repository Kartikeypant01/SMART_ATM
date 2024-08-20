
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
       
        
         back=new JButton("Back");
         back.setBounds(315,460,135,30);
         back.addActionListener(this);
         image.add(back);
         
         Conn c=new Conn();
          int balance=0;
           try{
              ResultSet rs=c.s.executeQuery("select * from Bank where Pin= '"+pinnumber+"'");
                      
                      while(rs.next()){
                          if(rs.getString("type").equals("Deposit")){
                              balance +=Integer.parseInt(rs.getString("amount"));
                          }else{
                              balance -=Integer.parseInt(rs.getString("amount"));
                          }
                      }
           }catch(Exception e){
               System.out.println(e);
           }
         
           JLabel text=new JLabel("Your Current Account Balance Is Rs" +balance);
           text.setForeground(Color.WHITE);
           text.setBounds(185,270,400,30);
           image.add(text);
         
          setSize(800,800);
        setLocation(300,0);
       setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
            
        
    }
    
}
