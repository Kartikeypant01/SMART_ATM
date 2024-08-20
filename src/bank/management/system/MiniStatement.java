
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank=new JLabel("State Bank Of India");
        bank.setBounds(120,20,200,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
             
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from Login where Pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from Bank where Pin= '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("Amount") +"<br><br><html>");
                 if(rs.getString("type").equals("Deposit")){
                              bal +=Integer.parseInt(rs.getString("amount"));
                          }else{
                              bal -=Integer.parseInt(rs.getString("amount"));
                          }
            }
            balance.setText("Your Current Account Balance is Rs " +bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
