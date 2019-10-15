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

public class frm_add_edit_category extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLCategoryIndex = new JLabel("Category Index:");
	JLabel JLCategoryName = new JLabel("Category Name:");
                    JLabel JLDescription = new JLabel("Description:");
	

	JTextField JTFCategoryIndex = new JTextField();
                    JTextField JTFCategoryName = new JTextField();
                    JTextField JTFDescription= new JTextField();
               
	

	Connection cnAEW;
	Statement stAEW;
	ResultSet rsAEW;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_edit_category(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEW = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAEW = cnAEW.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Category");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Category");
			JBUpdate.setText("Save");
			try{
				rsAEW = stAEW.executeQuery(srcSQL);
				rsAEW.next();
					JTFCategoryIndex.setText("" + rsAEW.getString("CategoryIndex"));
					JTFCategoryName.setText("" + rsAEW.getString("CategoryName"));
                                                                                                           JTFDescription .setText("" + rsAEW.getString("Description"));
                                                                                                           
                                                                                                            
                                                                                                            
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
                
                               JLCategoryIndex .setBounds(5,50,105,20);
                                JLCategoryName.setBounds(5,72,105,20);
                                JLDescription.setBounds(5,94,105,20);
                                
                                
                                
                                
		
		JLCategoryIndex.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFCategoryName.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                               JTFDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                           
                                           

		JTFCategoryIndex.setBounds(110,50,200,20);
                                           JTFCategoryName .setBounds(110,72,200,20);
                                            JTFDescription.setBounds(110,94,200,20);
                                         
		
		JPContainer.add(JLCategoryIndex);
		JPContainer.add(JTFCategoryIndex);
                JPContainer.add(JLDescription);
		JPContainer.add(JTFDescription);
                JPContainer.add(JLCategoryName);
		JPContainer.add(JTFCategoryName);
                JPContainer.add(JLCategoryIndex);
		JPContainer.add(JTFCategoryIndex);
          
		
	
		//******************** End adding of input field
                                           JBUpdate.setBounds(5,138,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(112,138,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(212,138,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);
		
		getContentPane().add(JPContainer);
		setSize(325,208);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-208)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFCategoryIndex.getText().equals("") || JTFDescription.getText().equals("") || JTFCategoryName.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated  Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFCategoryIndex.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
                                            JTFDescription.setText("");
                                            JTFCategoryIndex.setText("");
                                            JTFCategoryName.setText("");
                                           
		
        }
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAEW.executeUpdate("INSERT INTO Category(CategoryIndex,CategoryName,Description) " +
		   							   	        "VALUES ('" +
                                                                                                                                                                                                                                JTFCategoryIndex.getText() + "', '" +
                                                                                                                                                                                                                                JTFCategoryName.getText() + "', '" +
		   							   	        JTFDescription.getText() +
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM Category ORDER BY CategoryIndex ASC",cnAEW,"ItemNo");
		   					if(total != 0){
		   						FrmCategory.reloadRecord("SELECT * FROM Category WHERE CategoryIndex = " + total + " ORDER BY Description ASC");
		   					}else{
		   						FrmCategory.reloadRecord("SELECT * FROM Category ORDER BY Description ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
							if(PromptResult==0){
								clearFields();
								JTFCategoryIndex.requestFocus(true);
							}else{
								dispose();
							}
		   				}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}else{
						try{
							String RowIndex;
							RowIndex = rsAEW.getString("CategoryIndex");
							stAEW.executeUpdate("UPDATE Category SET CategoryIndex= '" +
		   							   	       
                                                                                                                                                                                                                                JTFCategoryIndex.getText() + "', CategoryName'" +
                                                                                                                                                                                                                                JTFCategoryName.getText() + "', Description'" +
		   							   	        JTFDescription.getText() +
		   							   	        "' WHERE CategoryIndex = " + RowIndex);
		   					FrmCategory.reloadRecord("SELECT * FROM Category WHERE CategoryIndex = " + RowIndex + " ORDER BY Description ASC");
							JOptionPane.showMessageDialog(null,"Changes in the record has been successfully save.","Automated  Inventory System",JOptionPane.INFORMATION_MESSAGE);
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