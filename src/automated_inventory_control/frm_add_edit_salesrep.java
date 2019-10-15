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

public class frm_add_edit_salesrep extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLId = new JLabel("EmployeeID:");
                    JLabel JLTitle=new JLabel("Title");
	JLabel JLFName = new JLabel("First Name:");
                      JLabel JLLName= new JLabel("Last Name:");
	JLabel JLEmail = new JLabel("Email:");
	JLabel JLPhone = new JLabel("Phone:");
	JLabel JLEmployeeIDNO = new JLabel("Employee ID NO.::");
	JLabel JLGender = new JLabel("Gender:");
	JLabel JLDOB = new JLabel("Date of Birth:");
	

	JTextField JTFId = new JTextField();
	JTextField JTFTitle = new JTextField();
	JTextField JTFFName = new JTextField();
	JTextField JTFLName= new JTextField();
	JTextField JTFEmail = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFEmployeeidno = new JTextField();
	JTextField JTFGender= new JTextField();
                    JTextField JTFDOB=new JTextField();
                    

	Connection cnAES;
	Statement stAES;
	ResultSet rsAES;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_edit_salesrep(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAES = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAES = cnAES.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Employee");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Employee ");
			JBUpdate.setText("Save");
			try{
				rsAES = stAES.executeQuery(srcSQL);
				rsAES.next();
					JTFId.setText("" + rsAES.getString("EmployeeID"));
					JTFTitle.setText("" + rsAES.getString("Title"));
                                                                                                           JTFFName.setText("" + rsAES.getString("First_name"));
                                                                                                           JTFLName.setText("" + rsAES.getString("Last_name"));
					JTFEmail.setText("" + rsAES.getString("Email"));
					JTFPhone.setText("" + rsAES.getString("Phone"));
					JTFEmployeeidno.setText("" + rsAES.getString("Employee_ID_no"));
					JTFGender.setText("" + rsAES.getString("Gender"));
					JTFDOB.setText("" + rsAES.getString("DOB"));
					
					
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
                                            JLLName.setBounds(5,116,105,20);
                                            JLEmail.setBounds(5,138,105,20);
                                            JLPhone.setBounds(5,160,105,20);
                                            JLEmployeeIDNO.setBounds(5,182,105,20);
                                            JLGender.setBounds(5,204,105,20);
                                            JLDOB.setBounds(5,226,105,20);
		

		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFTitle.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFFName.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFLName.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFEmail.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFEmployeeidno.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFGender.setFont(new Font("Dialog",Font.PLAIN,12));
                JTFDOB.setFont(new Font("Dialog",Font.PLAIN,12));
                JLId.setFont(new Font("Dialog",Font.PLAIN,12));
                JLTitle.setFont(new Font("Dialog",Font.PLAIN,12));
                JLFName.setFont(new Font("Dialog",Font.PLAIN,12));
                JLLName.setFont(new Font("Dialog",Font.PLAIN,12));
                JLEmail.setFont(new Font("Dialog",Font.PLAIN,12));
                JLPhone.setFont(new Font("Dialog",Font.PLAIN,12));
                JLEmployeeIDNO.setFont(new Font("Dialog",Font.PLAIN,12));
                JLGender.setFont(new Font("Dialog",Font.PLAIN,12));
                JLDOB.setFont(new Font("Dialog",Font.PLAIN,12));
              
                
                
              

                                            JTFId.setBounds(110,50,200,20);
                                            JTFTitle.setBounds(110,72,200,20);
                                            JTFFName.setBounds(110,94,200,20);
                                            JTFLName.setBounds(110,116,200,20);
                                            JTFEmail.setBounds(110,138,200,20);
                                            JTFPhone.setBounds(110,160,200,20);
                                            JTFEmployeeidno.setBounds(110,182,200,20);
                                            JTFGender.setBounds(110,204,200,20);
                                            JTFDOB.setBounds(110,226,200,20);
                
		JPContainer.add(JLId);
		JPContainer.add(JTFId);
                                            JPContainer.add(JLTitle);
		JPContainer.add(JTFTitle);
                JPContainer.add(JLFName);
		JPContainer.add(JTFFName);
                JPContainer.add(JLLName);
		JPContainer.add(JTFLName);
                JPContainer.add(JLEmail);
		JPContainer.add(JTFEmail);
                JPContainer.add(JLPhone);
		JPContainer.add(JTFPhone);
                JPContainer.add(JLEmployeeIDNO);
		JPContainer.add(JTFEmployeeidno);
                JPContainer.add(JLGender);
		JPContainer.add(JTFGender);
                JPContainer.add(JLDOB);
		JPContainer.add(JTFDOB);

		

		//-- Add the JBUpdate
		JBUpdate.setBounds(5,270,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);

		//-- Add the JBReset
		JBReset.setBounds(112,270,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBCancel
		JBCancel.setBounds(212,270,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(325,335);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-335)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFFName.getText().equals("") || JTFEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFId.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
		JTFId.setText("");
                                            JTFTitle.setText("");
		JTFFName.setText("");
		JTFEmail.setText("");
		JTFPhone.setText("");
		JTFEmployeeidno.setText("");
		JTFGender.setText("");
		JTFDOB.setText("");
		
	}

	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

					stAES.executeUpdate("INSERT INTO Employee (EmployeeID,Title,First_name,Last_name,Email,Phone,Employee_ID_no,Gender,DOB) " +
		   							   	        "VALUES ('" +
		   							   	        JTFId.getText() + "', '" +
                                                                                                                                                                                                                              JTFTitle.getText() + "','" +
		   							   	        JTFFName.getText() + "', '" +
		   							   	        JTFLName.getText() + "', '" +
		   							   	        JTFEmail.getText() + "', '" +
		   							   	        JTFPhone.getText() + "', '" +
		   							   	        JTFEmployeeidno.getText() + "', '" +
		   							   	        JTFGender.getText() + "', '" +
		   							   	        JTFDOB.getText() + 
		   							   
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM Employee ORDER BY EmployeeID ASC",cnAES,"EmployeeID");
		   					if(total != 0){
		   						FrmSalesRep.reloadRecord("SELECT * FROM Employee WHERE EmployeeID= " + total + " ORDER BY First_name ASC");
		   					}else{
		   						FrmSalesRep.reloadRecord("SELECT * FROM Employee ORDER BY First_name ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated  Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated  Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
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
							RowIndex = rsAES.getString("EmployeeID");
							stAES.executeUpdate("UPDATE Employee SET EmployeeID = '" +
		   							   	        JTFId.getText() + "', Title = '" +
                                                                                                                                                                                                                            JTFTitle.getText()+"',First_name='"+
		   							   	        JTFFName.getText() + "', Last_name= '" +
                                                                                                                                                                                                                              JTFLName.getText() + "',Email='" +
		   							   	        JTFEmail.getText()  + "', Phone= '" +
		   							   	        JTFPhone.getText()  + "', Employee_ID_no= '" +
		   							   	        JTFEmployeeidno.getText()   + "', Gender= '" +
		   							   	        JTFGender.getText()   + "', DOB= '" +
		   							   	        JTFDOB.getText()   +
		   							   	        
		   							   	      
		   							   	        "' WHERE EmployeeID = " + RowIndex);
		   					FrmSalesRep.reloadRecord("SELECT * FROM Employee WHERE EmployeeID= " + RowIndex +" ORDER BY First_name ASC");
							JOptionPane.showMessageDialog(null,"Changes in the record has been successfully save.","Automated  Inventory System",JOptionPane.INFORMATION_MESSAGE);
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

}