/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ndemo
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class frm_add_edit_supplier extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	
	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");
	
	JLabel JLId = new JLabel("Supplier ID:");
	JLabel JLFName = new JLabel("First Name:");
                      JLabel JLMName=new JLabel("Middle Name");
	JLabel JLLName = new JLabel("Last Name:");
	JLabel JLTitle = new JLabel(" Title:");
	JLabel JLDisplay_name = new JLabel("Display Name:");
	JLabel JLWebsite = new JLabel("website:");
                      JLabel JLCompany_name=new JLabel("Company Name:");
                    JLabel  JLBusiness_ID_no=new JLabel("Business ID no:");
	JLabel JLCounty = new JLabel("county:");
	JLabel JLEmail= new JLabel("Email:");
	JLabel JLCountry = new JLabel("Country:");
	JLabel JLPhone = new JLabel("Phone:");
	
	
	JTextField JTFId = new JTextField();
	JTextField JTFFName = new JTextField();
                     JTextField JTFMName = new JTextField();
	JTextField JTFLName = new JTextField();
	JTextField JTFTitle = new JTextField();
	JTextField JTFEmail = new JTextField();
                    JTextField JTFCompany_name=new JTextField();
	JTextField JTFDisplay_name = new JTextField();
	JTextField JTFCounty = new JTextField();
	JTextField JTFBusiness_id_no = new JTextField();
	JComboBox  JCBCountry;
                     JTextField JTFWebsite = new JTextField();
	JTextField JTFPhone = new JTextField();
	
	
	Connection cnAES;
	Statement stAES;
	ResultSet rsAES;
		
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	
	boolean ADDING_STATE;
	
	public frm_add_edit_supplier(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
        this.JBActionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String srcObj = e.getActionCommand();
                if(srcObj=="update"){
                    if(RequiredFieldEmpty()==false){
                        if(ADDING_STATE == true){
                            try{
                                
                                stAES.executeUpdate("INSERT INTO Supplier(SupplierID,Title,First_name,Middle_name,Last_name,Display_name_as,Phone,Company_name,Busines_ID_no,Email,County,Country,website )" +
                                        "VALUES ('" +
                                        JTFId.getText() + "', '" +
                                        JTFTitle.getText() +"','"+
                                        JTFFName.getText() + "', '" +
                                        JTFMName.getText() + "', '" +
                                        JTFLName.getText() + "', '" +
                                        JTFDisplay_name.getText() +"','"+
                                        JTFPhone.getText() +"','"+
                                        JTFCompany_name.getText() +"','"+
                                        JTFBusiness_id_no.getText() +"','"+
                                        JTFEmail.getText() + "', '" +
                                        JTFCounty.getText() + "', '" +
                                        JCBCountry.getSelectedItem().toString() + "', '" +
                                        JTFWebsite.getText() +
                                        
                                        "')");
                                // Start Display the new record
                                int total =0;
                                total = clsPublicMethods.getMaxNum("SELECT * FROM Supplier ORDER BY SupplierID ASC",cnAES,"SupplierID");
                                if(total != 0){
                                    FrmSupplier.reloadRecord("SELECT * FROM Supplier WHERE SupplierID = " + total + " ORDER BY Company_name ASC");
                                }else{
                                    FrmSupplier.reloadRecord("SELECT * FROM Supplier ORDER BY Company_name ASC");
                                }
                                total =0;
                                // End Display the new record
                                JOptionPane.showMessageDialog(null,"New record has been successfully added.","AIS",JOptionPane.INFORMATION_MESSAGE);
                                String ObjButtons[] = {"Yes","No"};
                                int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","AIS",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
                                if(PromptResult==0){
                                    clearFields();
                                    JTFId.requestFocus(true);
                                }else{
                                    dispose();
                                }
                            }catch(SQLException sqlEx){
                                System.out.println(sqlEx.getMessage());
                            }
                        }else{
                            try{
                                String RowIndex;
                                RowIndex = rsAES.getString("SupplierID");
                                stAES.executeUpdate("UPDATE Supplier SET SupplierID = '" +
                                        JTFId.getText() + "', Company_name = '" +
                                        JTFCompany_name.getText() + "', First_name = '" +
                                        JTFFName.getText() + "', Middle_name= '" +
                                        JTFMName.getText()+ "',Last_name='"+
                                        JTFLName.getText()+"',Display_name_as='"+
                                        JTFDisplay_name.getText()+"',Busines_ID_no='"+
                                        JTFBusiness_id_no.getText()+"'.Email="+
                                        JTFEmail.getText() + "', Title = '" +
                                        JTFTitle.getText() + "', county = '" +
                                        JTFCounty.getText() + "', Phone = '" +
                                        JTFPhone.getText() + "', Country = '" +
                                        JCBCountry.getSelectedItem().toString() + "', website = '" +
                                        JTFWebsite.getText() +
                                        
                                        "' WHERE SupplierID = " + RowIndex);
                                FrmSupplier.reloadRecord("SELECT * FROM Supplier WHERE SupplierID= " + RowIndex + " ORDER BY CompanyName ASC");
                                JOptionPane.showMessageDialog(null,"Changes in the record has been successfully save.","AIS",JOptionPane.INFORMATION_MESSAGE);
                                RowIndex="";
                                dispose();
                            }catch(SQLException sqlEx){
                                System.out.println(sqlEx.getMessage());
                            }
                        }
                    }
                }else if(srcObj=="reset"){
                    clearFields();
                }else if(srcObj=="cancel"){
                    dispose();
                }
            }
        };
		cnAES = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAES = cnAES.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){
			System.out.println("\nERROR IN frm_add_edit_supplier(frm_add_edit_supplier):" + sqlEx + "\n");
		}
		
		JCBCountry = clsPublicMethods.fillCombo("SELECT * FROM Country",cnAES,"Name");
		
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Supplier");
			JBUpdate.setText("Update");
			
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Supplier");
			JBUpdate.setText("Save");
			try{
				rsAES = stAES.executeQuery(srcSQL);
				rsAES.next();					
					JTFId.setText("" + rsAES.getString("SupplierID"));
                                                                                                           JTFTitle.setText("" + rsAES.getString("Title"));
					JTFFName.setText("" + rsAES.getString("First_name"));
					JTFMName.setText("" + rsAES.getString("Middle_name"));
					JTFLName.setText("" + rsAES.getString("Last_name"));
					JTFEmail.setText("" + rsAES.getString("Email"));
					JTFDisplay_name.setText("" + rsAES.getString("Display_name_as"));
					JTFCounty.setText("" + rsAES.getString("county"));
                                                                                                            JTFCompany_name.setText(""+ rsAES.getString("Company_name"));
					JTFBusiness_id_no.setText("" + rsAES.getString("Busines_ID_no"));
					//searchInComboPos
					JCBCountry.setSelectedItem("" + rsAES.getString("Country"));
					JTFPhone.setText("" + rsAES.getString("Phone"));
                                                                                                            JTFWebsite.setText("" + rsAES.getString("website"));
					
			}catch(SQLException sqlEx){
				System.out.println(sqlEx.getMessage());
			}
		}
		JPanel JPContainer = new JPanel();
		JPContainer.setLayout(null);
		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPContainer.add(JLPic1);
		
		//-- Add the JLBanner
		JLBanner.setBounds(55,5,268,48);
		JLBanner.setFont(new Font("Dialog",Font.PLAIN,12));
		JPContainer.add(JLBanner);
		
		//******************** Start adding of input field
		//-- Add Id Input Field
                
                
                
		JLId.setBounds(5,50,105,20);
                                             JLTitle.setBounds(5,72,105,20);
                                           JLFName.setBounds(5,94,105,20);
                                           JLMName.setBounds(5,116,105,20);
                                          JLLName.setBounds(5,138,105,20);
                                          JLDisplay_name.setBounds(5,160,105,20);
                                              JLPhone.setBounds(5,182,105,20);
                                              JLCompany_name.setBounds(5,226,105,20);
                                              JLBusiness_ID_no.setBounds(5,248,105,20);
                                           JLEmail.setBounds(5,270,105,20);
                                           JLCounty.setBounds(5,292,105,20);
                                           JLCountry.setBounds(5,314,105,20);
                                           JLWebsite.setBounds(5,336,105,20);
                                       
                                          
                                           
                                           
                                        
		JLId.setFont(new Font("Dialog",Font.PLAIN,12));
		JLFName.setFont(new Font("Dialog",Font.PLAIN,12));
                                            JTFFName.setFont(new Font("Dialog",Font.PLAIN,12));
                                            JTFMName.setFont(new Font("Dialog",Font.PLAIN,12));
                                            JLMName.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFId.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLTitle.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFTitle.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLEmail.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFEmail.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLLName.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFLName.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLCounty.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFCounty.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLCountry.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JCBCountry.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLPhone.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFCompany_name.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLCompany_name.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLBusiness_ID_no.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFBusiness_id_no.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLWebsite.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFWebsite.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JTFDisplay_name.setFont(new Font("Dialog",Font.PLAIN,12));
                                             JLDisplay_name.setFont(new Font("Dialog",Font.PLAIN,12));
                
                
		JTFId.setBounds(110,50,200,20);
                                            JTFTitle.setBounds(110,72,200,20); 
		 JTFFName.setBounds(110,94,200,20);
                                           JTFMName.setBounds(110,116,200,20);
                                           JTFLName.setBounds(110,138,200,20);
                                           JTFDisplay_name.setBounds(110,160,200,20);
                                            JTFPhone.setBounds(110,182,200,20);
                                            JTFCompany_name.setBounds(110,226,200,20);
                                            JTFBusiness_id_no.setBounds(110,248,200,20);
                                          JTFEmail.setBounds(110,270,200,20);   
                                          JTFCounty.setBounds(110,292,200,20);
                                          JCBCountry.setBounds(110,314,200,20);
                                          JTFWebsite.setBounds(110,336,200,20);
                                         
                                           
                                           
		JPContainer.add(JLId);
		JPContainer.add(JTFId);
		JPContainer.add(JLFName);
		JPContainer.add(JTFFName);
		JPContainer.add(JLMName);
		JPContainer.add(JTFMName);
		JPContainer.add(JLTitle);
		JPContainer.add(JTFTitle);
		JPContainer.add(JLEmail);
		JPContainer.add(JTFEmail);
		JPContainer.add(JLLName);
		JPContainer.add(JTFLName);
		JPContainer.add(JLCounty);
		JPContainer.add(JTFCounty);
		JPContainer.add(JLCountry);
		JPContainer.add(JCBCountry);
		JPContainer.add(JLPhone);
                                            JPContainer.add(JTFPhone);
		JPContainer.add(JTFDisplay_name);
                                            JPContainer.add(JLDisplay_name);
                                            JPContainer.add(JLCompany_name);
                                            JPContainer.add(JTFCompany_name);
                                            JPContainer.add(JTFBusiness_id_no);
                                            JPContainer.add(JLBusiness_ID_no);
                                            JPContainer.add(JLWebsite);
                                            JPContainer.add(JTFWebsite);
		
		
		//******************** End adding of input field
		
		//-- Add the JBUpdate
		JBUpdate.setBounds(5,380,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(112,380,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(212,380,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);
		
		getContentPane().add(JPContainer);
		setSize(325,470);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-470)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFFName.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","AIS",JOptionPane.WARNING_MESSAGE);
			JTFId.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
		JTFId.setText("");
		JTFFName.setText("");
		JTFMName.setText("");
		JTFTitle.setText("");
		JTFEmail.setText("");
		JTFLName.setText("");
		JTFCounty.setText("");
		JTFEmail.setText("");
                                            JTFBusiness_id_no.setText("");
                                             JTFWebsite.setText("");
                                             JTFDisplay_name.setText("");
		JCBCountry.setSelectedIndex(0);
		JTFPhone.setText("");
		
	}
	
	ActionListener JBActionListener;
	
}