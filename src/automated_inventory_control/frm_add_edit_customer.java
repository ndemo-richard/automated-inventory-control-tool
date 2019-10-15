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
import java.math.*;
import java.util.*;

public class frm_add_edit_customer extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	
	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");
	
	JLabel JLId = new JLabel("Customer ID:");
	JLabel JLName = new JLabel("Customer Name:");
	JLabel JLContName = new JLabel("Contact Name:");
	JLabel JLContTitle = new JLabel("Contact Title:");
	
	JLabel JLCity = new JLabel("City/Town:");
	JLabel JLCounty = new JLabel("County:");
	JLabel JLPobox= new JLabel("P.O. box:");
	JLabel JLCountry = new JLabel("Country:");
	JLabel JLPhone = new JLabel("Phone:");
	JLabel JLEmail = new JLabel("Email:");
	
	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFContName = new JTextField();
	JTextField JTFContTitle = new JTextField();
	
	JTextField JTFCity = new JTextField();
	JTextField JTFCounty = new JTextField();
	JTextField JTFPobox = new JTextField();
	JComboBox  JCBCountry;
	JTextField JTFPhone = new JTextField();
	JTextField JTFEmail = new JTextField();
	
	Connection cnAEC;
	Statement stAEC;
	ResultSet rsAEC;
		
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	
	boolean ADDING_STATE;
	private static String JTFid="CMR" + new Random(System.currentTimeMillis()).nextInt();
	public frm_add_edit_customer(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEC = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAEC = cnAEC.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){
			System.out.println("\nERROR IN frm_add_edit_customer(frm_add_edit_customer):" + sqlEx + "\n");
		}
		
		JCBCountry = clsPublicMethods.fillCombo("SELECT * FROM Country",cnAEC,"Name");
		
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Customer");
			JBUpdate.setText("Update");
			
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Customer");
			JBUpdate.setText("Save");
			try{
				rsAEC = stAEC.executeQuery(srcSQL);
				rsAEC.next();					
					JTFId.setText("" + rsAEC.getString("CustomerID"));
					JTFName.setText("" + rsAEC.getString("CompanyName"));
					JTFContName.setText("" + rsAEC.getString("ContactName"));
					JTFContTitle.setText("" + rsAEC.getString("ContactTitle"));
					JTFEmail.setText("" + rsAEC.getString("Email"));
					JTFCity.setText("" + rsAEC.getString("CityTown"));
					JTFCounty.setText("" + rsAEC.getString("county"));
					JTFPobox.setText("" + rsAEC.getString("boxno"));
					//searchInComboPos
					JCBCountry.setSelectedItem("" + rsAEC.getString("Country"));
					JTFPhone.setText("" + rsAEC.getString("Phone"));
					
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
		JLId.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFId.setBounds(110,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLId);
		JPContainer.add(JTFId);
		
		//-- Add Name Input Field
		JLName.setBounds(5,72,105,20);
		JLName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFName.setBounds(110,72,200,20);
		JTFName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLName);
		JPContainer.add(JTFName);
		//-- Add Contact Name Input Field
		JLContName.setBounds(5,94,105,20);
		JLContName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFContName.setBounds(110,94,200,20);
		JTFContName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLContName);
		JPContainer.add(JTFContName);
		
		//-- Add Contact Title Input Field
		JLContTitle.setBounds(5,116,105,20);
		JLContTitle.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFContTitle.setBounds(110,116,200,20);
		JTFContTitle.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLContTitle);
		JPContainer.add(JTFContTitle);
		
		//-- Add Address Input Field
		JLEmail.setBounds(5,138,105,20);
		JLEmail.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFEmail.setBounds(110,138,200,20);
		JTFEmail.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLEmail);
		JPContainer.add(JTFEmail);
		
		//-- Add City Input Field
		JLCity.setBounds(5,160,105,20);
		JLCity.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFCity.setBounds(110,160,200,20);
		JTFCity.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLCity);
		JPContainer.add(JTFCity);
		
		//-- Add State/Province Input Field
		JLCounty.setBounds(5,182,105,20);
		JLCounty.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFCounty.setBounds(110,182,200,20);
		JTFCounty.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLCounty);
		JPContainer.add(JTFCounty);
		
		//-- Add box Code Input Field
		JLPobox.setBounds(5,204,105,20);
		JLPobox.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFPobox.setBounds(110,204,200,20);
		JTFPobox.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLPobox);
		JPContainer.add(JTFPobox);
		
		//-- Add Country Input Field
		JLCountry.setBounds(5,226,105,20);
		JLCountry.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JCBCountry.setBounds(110,226,200,20);
		JCBCountry.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLCountry);
		JPContainer.add(JCBCountry);
		
		//-- Add Phone Input Field
		JLPhone.setBounds(5,248,105,20);
		JLPhone.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFPhone.setBounds(110,248,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLPhone);
		JPContainer.add(JTFPhone);
		
		
		
		//******************** End adding of input field
		
		//-- Add the JBUpdate
		JBUpdate.setBounds(5,318,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(112,318,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(212,318,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);
		
		getContentPane().add(JPContainer);
		setSize(325,383);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-383)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFName.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated  Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFId.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
		JTFId.setText("");
		JTFName.setText("");
		JTFContName.setText("");
		JTFContTitle.setText("");
		JTFEmail.setText("");
		JTFCity.setText("");
		JTFCounty.setText("");
		JTFPobox.setText("");
		JCBCountry.setSelectedIndex(0);
		JTFPhone.setText("");
	
	}
	
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{
							
							stAEC.executeUpdate("INSERT INTO Customer(CustomerID,CompanyName,ContactName,ContactTitle,Email,CityTown,county,boxno,Country,Phone) " +
		   							   	        "VALUES ('" + 		   							   	        
		   							   	        JTFId.getText() + "', '" +
		   							   	        JTFName.getText() + "', '" +
		   							   	        JTFContName.getText() + "', '" +
		   							   	        JTFContTitle.getText() + "', '" +
		   							   	        JTFEmail.getText() + "', '" +
		   							   	        JTFCity.getText() + "', '" +
		   							   	        JTFCounty.getText() + "', '" +
		   							   	        JTFPobox.getText() + "', '" +
		   							   	        JCBCountry.getSelectedItem().toString() + "', '" +
		   							   	        JTFPhone.getText() + 
		   							   	        
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM Customer ORDER BY CustomerID ASC",cnAEC,"CustomerID");
		   					if(total != 0){
		   						FrmCustomer.reloadRecord("SELECT * FROM Customer WHERE CustomerID = " + total + " ORDER BY CompanyName ASC");	
		   					}else{
		   						FrmCustomer.reloadRecord("SELECT * FROM Customer ORDER BY CompanyName ASC");	
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
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
							RowIndex = rsAEC.getString("CustomerID");	        
							stAEC.executeUpdate("UPDATE Customer SET CustomerID = '" +
		   							   	        JTFId.getText() + "', CompanyName = '" +
		   							   	        JTFName.getText() + "', ContactName = '" +
		   							   	        JTFContName.getText() + "', ContactTitle = '" +
		   							   	        JTFContTitle.getText() + "', Email = '" +
		   							   	        JTFEmail.getText() + "', CityTown = '" +
		   							   	        JTFCity.getText() + "', county = '" +
		   							   	        JTFCounty.getText() + "',  boxno = '" +
		   							   	        JTFPobox.getText() + "', Country = '" +
		   							   	        JCBCountry.getSelectedItem().toString() + "', Phone = '" +
		   							   	        JTFPhone.getText() +
		   							   	        
		   							   	        "' WHERE CustomerID = " + RowIndex);
		   					FrmCustomer.reloadRecord("SELECT * FROM Customer WHERE CustomerID = " + RowIndex + " ORDER BY CompanyName ASC");	
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
