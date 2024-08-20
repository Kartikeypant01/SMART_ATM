
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {
    
   
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton accExists,notExists,isSenior,notSenior;
    
    JComboBox religion,categoryType,incomeType,occupationType,educationType;
    String formno;
   SignupTwo(String formno){
       this.formno=formno;
       setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
       
       JLabel additionalDetails=new JLabel("Page 2: Additional Details ");
       additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
       additionalDetails.setBounds(280,80,400,30);
       add(additionalDetails);
       
       JLabel name=new JLabel("Religion: ");
       name.setFont(new Font("Raleway",Font.BOLD,18));
       name.setBounds(80,140,100,30);
       add(name);
       
       String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
       religion.setBounds(300,140,400,30);
       religion.setBackground(Color.WHITE);
        add(religion);
       
      
        
       JLabel category=new JLabel("Category: ");
       category.setFont(new Font("Raleway",Font.BOLD,18));
       category.setBounds(80,190,200,30);
       add(category);
       
       String valCategory[]={"General","OBC","SC","ST","EWS"};
        categoryType = new JComboBox(valCategory);
       categoryType.setBounds(300,190,400,30);
        add(categoryType);
       
       
       
       JLabel income=new JLabel("Income: ");
       income.setFont(new Font("Raleway",Font.BOLD,18));
       income.setBounds(80,240,200,30);
       add(income);
       
       String incomeCategory[]={"NULL","<150000","<250000","<500000",">=1000000"};
        incomeType = new JComboBox(incomeCategory);
       incomeType.setBounds(300,240,400,30);
        add(incomeType);
       
       
       
        
       
       JLabel educational=new JLabel("Educational ");
       educational.setFont(new Font("Raleway",Font.BOLD,18));
       educational.setBounds(80,290,200,30);
       add(educational);
       
      JLabel qualification=new JLabel("Qualification: ");
       qualification.setFont(new Font("Raleway",Font.BOLD,18));
       qualification.setBounds(80,315,200,30);
       add(qualification);
       
       String educationValues[]={"Non Graduate","Graduate","Post Graduate","Others"};
        educationType = new JComboBox(educationValues);
       educationType.setBounds(300,315,400,30);
        add(educationType);
       
       
       
       JLabel occupation=new JLabel("Occupation: ");
       occupation.setFont(new Font("Raleway",Font.BOLD,18));
       occupation.setBounds(80,390,200,30);
       add(occupation);
       
       String[] occupationValues={"Salaried","Self Employed","Student","Others"};
        occupationType = new JComboBox(occupationValues);
       occupationType.setBounds(300,390,400,30);
        add(occupationType);
       
        
       
       JLabel panNo=new JLabel("Pan No: ");
       panNo.setFont(new Font("Raleway",Font.BOLD,18));
       panNo.setBounds(80,440,200,30);
       add(panNo);
       
        panTextField=new JTextField();
       panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
       
        JLabel aadharNo=new JLabel("Aadhar No: ");
       aadharNo.setFont(new Font("Raleway",Font.BOLD,18));
       aadharNo.setBounds(80,490,200,30);
       add(aadharNo);
       
        aadharTextField=new JTextField();
       aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
       
       JLabel isSeniorCitizen=new JLabel("Senior Citizen: ");
       isSeniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
       isSeniorCitizen.setBounds(80,540,200,30);
       add(isSeniorCitizen);
       
       isSenior=new JRadioButton("Yes");
       isSenior.setBounds(300,540,100,30);
       isSenior.setBackground(Color.WHITE);
       add(isSenior);
       
        notSenior=new JRadioButton("NO");
       notSenior.setBounds(450,540,100,30);
       notSenior.setBackground(Color.WHITE);
       add(notSenior);
       
       ButtonGroup senior=new ButtonGroup();
       senior.add(isSenior);
       senior.add(notSenior);
       
         
       
       
       JLabel existingAccount=new JLabel("Existing Account: ");
       existingAccount.setFont(new Font("Raleway",Font.BOLD,18));
       existingAccount.setBounds(80,590,200,30);
       add(existingAccount);
       
       accExists=new JRadioButton("Yes");
        accExists.setBounds(300,590,100,30);
       accExists.setBackground(Color.WHITE);
       add(accExists);
       
        notExists=new JRadioButton("NO");
       notExists.setBounds(450,590,100,30);
       notExists.setBackground(Color.WHITE);
       add(notExists);
       
       ButtonGroup exists=new ButtonGroup();
       exists.add(accExists);
       exists.add(notExists);
        
        
        
         next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);
        
       
       
       
       getContentPane().setBackground(Color.WHITE);
       setSize(800,750);
       setLocation(150,10);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       
       String sreligion=(String) religion.getSelectedItem();
       String scategory=(String) categoryType.getSelectedItem();
      String sincome=(String) incomeType.getSelectedItem();
      String seducation=(String) educationType.getSelectedItem();
      String soccupation=(String) occupationType.getSelectedItem();
      
       String isseniorCitizen =null;
       if(isSenior.isSelected()){
           isseniorCitizen="Yes";
           
       } else if(notSenior.isSelected()){
           isseniorCitizen="No";
       }
       
       
       String existingAccount=null;
       if(accExists.isSelected()){
           existingAccount="Yes";
       }else if(notExists.isSelected()){
           existingAccount="No";
       }
       
       String panNo=panTextField.getText();
       String aadharNo=aadharTextField.getText();
       
       
       try{
          
               Conn c=new Conn();
               String query="insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+aadharNo+"','"+panNo+"','"+isseniorCitizen+"','"+existingAccount+"')";
               c.s.executeUpdate(query);
               
               //signup3 object
               
               setVisible(false);
               new SignupThree(formno).setVisible(true);
               
               
               
           }catch(Exception e){
           System.out.println(e);
       }
       
   }
    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}
