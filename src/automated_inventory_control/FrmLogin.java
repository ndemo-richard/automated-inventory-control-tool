package automated_inventory_control;
import java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
public class FrmLogin extends JFrame implements ActionListener{
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    JLabel title,Email,Password,home2;
    JTextField email;
    JPasswordField password;
     JPanel login,hold,home;
     JButton Login,reset;
   Container c;
    public FrmLogin(){
     c = getContentPane();
      c.setBackground(Color.GRAY);
        c.setLayout(null);
       setBounds(200,100,900,650);
       
      home=new JPanel();
       home.setLayout(null);
            home.setBounds(10,150,550,460);
               home.setBackground(Color.LIGHT_GRAY);
               c.add(home);
               
              try{
         BufferedImage mypic2=ImageIO.read(this.getClass().getResource("AUTOMATA.png"));
       home2=new JLabel(new ImageIcon(mypic2));
       home2.setLayout(null);
         home2.setBounds(00,00,550,460);
        home.add(home2);
         
         }catch (IOException ex){
         }
               
       login=new JPanel();
       login.setLayout(null);
            login.setBounds(570,150,300,200);
               login.setBackground(Color.LIGHT_GRAY);
               login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
               c.add(login);
               
               Email = new JLabel("EMAIL :");  
                Email.setForeground(Color.black);
                Email.setFont(new java.awt.Font("Dialog", 1, 12));
                Email.setBorder(javax.swing.BorderFactory.createEtchedBorder());
               Password = new JLabel("PASSWORD :");  
                Password.setForeground(Color.black);
                Password.setFont(new java.awt.Font("Dialog", 1, 12));
                Password.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                  email = new JTextField(); 
	email.setForeground(Color.black); 
	email.setBackground(Color.white);
        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                password = new JPasswordField(); 
	password.setForeground(Color.black);
	password.setBackground(Color.white);
        password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
     //   try{
        //BufferedImage mypic1=ImageIO.read(this.getClass().getResource("add.jpeg"));
        Login=new JButton("LOGIN");
        Login.setBounds(190,150,90,30);
        Login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
       Login.addActionListener(this);
   //     }catch (IOException ex){
   //      }
        reset=new JButton("RESET");
        reset.setBounds(20,150,90,30);
        reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset.addActionListener(this);
                
               Email.setBounds(25,50,100,20);
               Password.setBounds(25,80,100,20);
                email.setBounds(130,50,120,20);
                password.setBounds(130,80,120,20);
                
                login.add(Email);
                login.add(Password);
                login.add(email);
                login.add(password);
                login.add(Login);
                login.add(reset);
               
               
        try{
         BufferedImage mypic=ImageIO.read(this.getClass().getResource("pic1.png"));
         JLabel piclabel=new JLabel(new ImageIcon(mypic));
         piclabel.setLayout(null);
         piclabel.setBounds(200,05,500,140);
        c.add(piclabel);
         
         }catch (IOException ex){
         }
       setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {  
       // String username=username.getText();
        conn=MysqlConnect.ConnectDB();
        String Sql="SELECT * FROM Employee WHERE Email=? and password=?";
        try{conn=MysqlConnect.ConnectDB();
        pst =conn.prepareStatement(Sql);
        pst.setString(1,email.getText());
        pst.setString(2,password.getText());
        rs=pst.executeQuery();
        if(rs.next()){
        MainForm w= new MainForm();
     //   w.name.setText(username.getText());
        w.setVisible(true);
       w.nn();
       this.dispose();
        
        
        }
        else{
              JOptionPane.showMessageDialog(null,"invalid user or password", "access Denied", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}
        
    }                                        
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error Loading Theme:" + e.toString());
            //If Failed to load the liquid them then load my own XPStyleTheme
            MetalTheme myXPStyleTheme = new XPStyleTheme();
            MetalLookAndFeel.setCurrentTheme(myXPStyleTheme);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception err) {
                System.out.println("Error loading myXPStyleTheme:" + err.toString());
            }
        }
                new FrmLogin().setVisible(true);
               
            }
        });
}}
