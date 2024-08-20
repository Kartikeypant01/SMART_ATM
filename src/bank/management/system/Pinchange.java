
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Pinchange extends JFrame implements ActionListener {
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raelway",Font.BOLD,16));
        text.setBounds(220,200,500,35);
        image.add(text);
        
        JLabel pintext=new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raelway",Font.BOLD,16));
        pintext.setBounds(135,240,180,25);
        image.add(pintext);
        
         pin=new JPasswordField();
        pin.setFont(new Font("Raelway",Font.BOLD,25));
        pin.setBounds(300,240,150,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raelway",Font.BOLD,16));
        repintext.setBounds(135,280,180,25);
        image.add(repintext);
        
         repin=new JPasswordField();
        repin.setFont(new Font("Raelway",Font.BOLD,25));
        repin.setBounds(300,280,150,25);
        image.add(repin);
        
         change=new JButton("CHANGE");
        change.setBounds(325,365,120,30);
        change.addActionListener(this);
        image.add(change);
        
          back=new JButton("BACK");
        back.setBounds(325,405,120,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
       try{
           String npin=pin.getText();
           String rpin=repin.getText();
           
           if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match");
               return;
           }
           if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please Enter New Pin");
               return;
           }
           if(rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
               return;
           }
           
           Conn conn=new Conn();
           String query1="update Bank set Pin= '"+rpin+"' where pin='"+pinnumber+"'";
           String query2="update Login set Pin= '"+rpin+"' where pin='"+pinnumber+"'";
          //String query3="update SignupThree set Pin_Number= '"+rpin+"' where pin='"+pinnumber+"'";
           
           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           //conn.s.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null, "PIN Changed Successfuly");
           setVisible(false);
           new Transactions(rpin).setVisible(true);
           
           
           
       
       }catch(Exception e){
           System.out.println(e);
       }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }
}
