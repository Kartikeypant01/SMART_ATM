
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(185,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raelway",Font.BOLD,16));
        image.add(text);
        
        
         deposit=new JButton("Deposit");
        deposit.setBounds(150,355,135,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
          withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(315,355,135,30);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastcash=new JButton("Fast Cash");
        fastcash.setBounds(150,390,135,30);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement=new JButton("Mini Statement");
        ministatement.setBounds(315,390,135,30);
         ministatement.addActionListener(this);
        image.add(ministatement);
        
          pinchange=new JButton("Pin Change");
        pinchange.setBounds(150,425,135,30);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(315,425,135,30);
         balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit=new JButton("Exit");
        exit.setBounds(315,460,135,30);
         exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
            setVisible(false);
        }else if(ae.getSource()==deposit){
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
    }else if(ae.getSource()==pinchange){
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
    }else if(ae.getSource()==balanceenquiry){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
        
    }else if(ae.getSource()==ministatement){
        
        new MiniStatement(pinnumber).setVisible(true);
        
    }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
