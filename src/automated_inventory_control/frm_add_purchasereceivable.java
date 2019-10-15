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

public class frm_add_purchasereceivable extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLPRNo = new JLabel("PRNo:");
	JLabel JLSupplierID = new JLabel("SupplierID:");
                    JLabel JLItemNo = new JLabel("ItemNo:");
                    JLabel JLDescription = new JLabel("Description:");
                     JLabel JLQtyRecieve = new JLabel("QtyReceive");
                      JLabel JLUnitCost = new JLabel("UnitCost");
                       JLabel JLPONo = new JLabel("PONo:");
                        JLabel JLDateReceive = new JLabel("DateRecieve");
                         JLabel JLTotalamount = new JLabel("Totalamount");
                          JLabel JLApprovedBy = new JLabel("ApprovedBy");
	

	JTextField JTFPRNo= new JTextField();
                    JTextField JTFSupplierID = new JTextField();
                    JTextField JTFItemNo= new JTextField();
                    JTextField JTFDescription= new JTextField();
                    JTextField  JTFQtyReceive= new JTextField();
                    JTextField JTFUnitCost= new JTextField();
                    JTextField JTFPONo= new JTextField();
                    JTextField JTFDateReceive= new JTextField();
                    JTextField JTFTotalamount= new JTextField();
                    JTextField JTFApprovedBy= new JTextField();
               
	

	Connection cnAEW;
	Statement stAEW;
	ResultSet rsAEW;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_purchasereceivable(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEW = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAEW = cnAEW.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Purchasereceivable");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Category");
			JBUpdate.setText("Save");
			try{
				rsAEW = stAEW.executeQuery(srcSQL);
				rsAEW.next();
					JTFPRNo.setText("" + rsAEW.getString("PRNo"));
					JTFSupplierID.setText("" + rsAEW.getString("SupplierID"));
                                                                                                           JTFItemNo .setText("" + rsAEW.getString("ItemNo"));
                                                                                                            JTFDescription .setText("" + rsAEW.getString("Description"));
                                                                                                             JTFQtyReceive.setText("" + rsAEW.getString("IQtyRecieve"));
                                                                                                              JTFUnitCost.setText("" + rsAEW.getString("Unitcost"));
                                                                                                               JTFPONo.setText("" + rsAEW.getString("PONo"));
                                                                                                                JTFDateReceive.setText("" + rsAEW.getString("DateRecieve"));
                                                                                                                 JTFTotalamount .setText("" + rsAEW.getString("Totalamount"));
                                                                                                                  JTFApprovedBy.setText("" + rsAEW.getString("ApprovedBy"));
                                                                                                           
                                                                                                           
                                                                                                            
                                                                                                            
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
                
                  JLPRNo.setBounds(5,50,105,20);               
                JLSupplierID.setBounds(5,80,105,20);
                                JLItemNo.setBounds(5,110,105,20);
                                JLDescription.setBounds(5,140,105,20);
                                  JLQtyRecieve.setBounds(5,170,105,20);
                                    JLUnitCost.setBounds(5,200,105,20);
                                      JLPONo.setBounds(5,230,105,20);
                                        JLDateReceive.setBounds(455,50,105,20);
                                           JLTotalamount.setBounds(455,80,105,20);
                                            JLApprovedBy.setBounds(455,110,105,20);
                                            
                                
                                
                                
                                
		
		JLPRNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFPRNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLItemNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFItemNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                               JTFDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                               JLQtyRecieve.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFQtyReceive.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLUnitCost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFUnitCost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLPONo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFPONo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDateReceive.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFDateReceive.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLTotalamount.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFTotalamount.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLApprovedBy.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFApprovedBy.setFont(new Font("Dialog",Font.PLAIN,12));
                                           
                                           
                                            JTFPRNo.setBounds(110,50,200,20);
                                            JTFSupplierID.setBounds(110,80,200,20);
                                           JTFItemNo.setBounds(110,110,200,20);
                                            JTFDescription.setBounds(110,140,200,20);
                                            JTFQtyReceive.setBounds(110,170,200,20);
                                            JTFUnitCost.setBounds(110,200,200,20);
                                            JTFPONo.setBounds(110,230,200,20);
                                            JTFDateReceive.setBounds(560,50,200,20);
                                            JTFTotalamount.setBounds(560,80,200,20);
                                            JTFApprovedBy.setBounds(560,110,200,20);
                                         
		
		JPContainer.add(JLPRNo);
		JPContainer.add(JTFPRNo);
                JPContainer.add(JLSupplierID);
		JPContainer.add(JTFSupplierID);
                JPContainer.add(JLItemNo);
		JPContainer.add(JTFItemNo);
                JPContainer.add(JLDescription);
		JPContainer.add(JTFDescription);
                JPContainer.add(JLQtyRecieve);
		JPContainer.add(JTFQtyReceive);
                JPContainer.add(JLUnitCost);
		JPContainer.add(JTFUnitCost);
                JPContainer.add(JLPONo);
		JPContainer.add(JTFPONo);
                JPContainer.add(JLDateReceive);
		JPContainer.add(JTFDateReceive);
                JPContainer.add(JLTotalamount);
		JPContainer.add(JTFTotalamount);
                JPContainer.add(JLApprovedBy);
		JPContainer.add(JTFApprovedBy);
          
		
	
		//******************** End adding of input field
                                           JBUpdate.setBounds(180,330,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(290,330,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(430,330,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);
		
		getContentPane().add(JPContainer);
		setSize(800,400);
		setResizable(false);
		setLocation((screen.width - 800)/2,((screen.height-400)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFPRNo.getText().equals("") || JTFDescription.getText().equals("") || JTFItemNo.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated  Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFPRNo.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
                                           JTFPRNo.setText("");
					JTFSupplierID.setText("") ;
                                                                                                           JTFItemNo .setText("" );
                                                                                                            JTFDescription .setText("" );
                                                                                                             JTFQtyReceive.setText("" );
                                                                                                              JTFUnitCost.setText("" );
                                                                                                               JTFPONo.setText("" );
                                                                                                                JTFDateReceive.setText("" );
                                                                                                                 JTFTotalamount .setText("" );
                                                                                                                  JTFApprovedBy.setText("" );
                                           
		
        }
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAEW.executeUpdate("INSERT INTO PR(PRNo,SupplierID,ItemNo,Description,QtyRecieve,UnitCost,PONo,DateRecieve,Totalamount,ApprovedBy) " +
		   							   	        "VALUES ('" +
                                                                                                                                                                                                                                 JTFPRNo.getText() + "', '" +
                                                                                                                                                                                                                                JTFSupplierID.getText() + "', '" +
                                                                                                                                                                                                                                JTFItemNo.getText() + "', '" +
		   							   	        JTFDescription.getText() +"','"+
                                                                                                                                                                                                                             JTFQtyReceive.getText() + "', '" +
                                                                                                                                                                                                                                      JTFUnitCost.getText() + "', '" +
                                                                                                                                                                                                                                               JTFPONo.getText() + "', '" +
                                                                                                                                                                                                                                                        JTFDateReceive.getText() + "', '" +
                                                                                                                                                                                                                                                                 JTFTotalamount.getText() + "', '" +
                                                                                                                                                                                                                                                                          JTFApprovedBy.getText() + 
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM PR ORDER BY PRNo ASC",cnAEW,"ItemNo");
		   					if(total != 0){
		   						FrmPurchaseReceivable.reloadRecord("SELECT * FROM PR WHERE PRNo = " + total + " ORDER BY DateRecieve ASC");
		   					}else{
		   						FrmPurchaseReceivable.reloadRecord("SELECT * FROM PR ORDER BY DateRecieve ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
							if(PromptResult==0){
								clearFields();
								JTFPRNo.requestFocus(true);
							}else{
								dispose();
							}
		   				}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}else{
						try{
							String RowIndex;
							RowIndex = rsAEW.getString("PRNo");
							stAEW.executeUpdate("UPDATE PR SET PRNo= '" +
		   							   	        JTFPRNo.getText() + "', SupplierID'" +
                                                                                                                                                                                                                                JTFSupplierID.getText() + "',ItemNo '" +
                                                                                                                                                                                                                                JTFItemNo.getText() + "', Description'" +
		   							   	        JTFDescription.getText() +"',QtyRecieve'"+
                                                                                                                                                                                                                             JTFQtyReceive.getText() + "', UnitCost'" +
                                                                                                                                                                                                                                      JTFUnitCost.getText() + "', PONo'" +
                                                                                                                                                                                                                                               JTFPONo.getText() + "', DateRecieve'" +
                                                                                                                                                                                                                                                        JTFDateReceive.getText() + "',Totalamount '" +
                                                                                                                                                                                                                                                                 JTFTotalamount.getText() + "',ApprovedBy'" +
                                                                                                                                                                                                                                                                          JTFApprovedBy.getText() + 
		   							   	        "' WHERE PRNo = " + RowIndex);
		   					FrmCategory.reloadRecord("SELECT * FROM PR WHERE PRNo = " + RowIndex + " ORDER BY DateRecieve ASC");
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