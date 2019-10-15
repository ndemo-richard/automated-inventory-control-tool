/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author ndemo
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.DateUtil;
import com.toedter.calendar.*;
import com.toedter.calendar.JDateChooser;

public class frm_add_purchaseorder extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
        JDateChooser DateChooser = new JDateChooser();
       

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLPONo = new JLabel("PO NO.:");
	JLabel JLDate = new JLabel("Date:");
                    JLabel JLSupplierID = new JLabel("Supplier ID:");
                    JLabel JLShipFromAddress = new JLabel("Shipping Adress:");
                    JLabel JLShipFromCounty = new JLabel("Shipping From County:");
                    JLabel JLShipViaCarrierName = new JLabel("Shipping Carrier:");
                    JLabel JLShippingFee= new JLabel("Shipping fee:");
                    JLabel JLOthers = new JLabel("Others:");
                    JLabel JLAprrovedby=new JLabel("Approved By:");
                    JLabel JLItemno = new JLabel("Item No:");
                    JLabel JLDescription = new JLabel("Description:");
                    JLabel JLQtyPurchased = new JLabel("QtyPurchased:");
                    JLabel JLUnitcost= new JLabel("Unitcost:");
                    JLabel JLDiscount = new JLabel("Discount:");
                    
                    
	

	JTextField JTFPONo= new JTextField();
                    JTextField JTFSupplierID= new JTextField();
                     JTextField JTFShippingaddress= new JTextField();
                      JTextField JTFShippingcounty= new JTextField();
                       JTextField JTFShippingcarrier= new JTextField();
                        JTextField JTFShippingFee= new JTextField();
                         JTextField JTFOthers= new JTextField();
                          JTextField JTFApprovedby= new JTextField();
                            JTextField JTFItemno= new JTextField();
                              JTextField JTFDescription= new JTextField();
                              JTextField JTFQtyPurchased= new JTextField();
                                JTextField JTFUnitcost= new JTextField();
                                  JTextField JTFDiscount= new JTextField();
                         
               
	

	Connection cnAEW;
	Statement stAEW;
	ResultSet rsAEW;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_purchaseorder(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEW = srcCN;
		ADDING_STATE = ADD_STATE;
                  DateChooser = new JDateChooser();
                   DateChooser.setDateFormatString(" YYY-MM-dd");

		try{
			stAEW = cnAEW.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New PurchaseOrder");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Category");
			JBUpdate.setText("Save");
			try{
				rsAEW = stAEW.executeQuery(srcSQL);
				rsAEW.next();
					JTFPONo.setText("" + rsAEW.getString("PONo"));
					DateChooser.setDateFormatString(""+rsAEW.getString("Date"));
                                                                                                            JTFSupplierID.setText("" + rsAEW.getString("SupplierID"));
                                                                                                            JTFShippingaddress.setText("" + rsAEW.getString("ShipFromAddress"));
                                                                                                            JTFShippingcounty.setText("" + rsAEW.getString("ShipFromCounty"));
                                                                                                            JTFShippingcarrier.setText("" + rsAEW.getString("ShipViaCarrierName"));
                                                                                                            JTFShippingFee.setText("" + rsAEW.getString("ShippingFee"));
                                                                                                            JTFOthers.setText("" + rsAEW.getString("Others"));
                                                                                                            JTFApprovedby.setText("" + rsAEW.getString("ApprovedBy"));
                                                                                                            JTFItemno.setText("" + rsAEW.getString("ItemNo"));
                                                                                                           JTFDescription .setText("" + rsAEW.getString("Description"));
                                                                                                           JTFQtyPurchased.setText("" + rsAEW.getString("QtyPurchased"));
                                                                                                           JTFUnitcost.setText("" + rsAEW.getString("UnitCost"));
                                                                                                           JTFDiscount.setText("" + rsAEW.getString("Discount"));
                                                                                                         
                                                                                                           
                                                                                                            
                                                                                                            
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
                
               JLPONo.setBounds(5,50,105,20);   
               JLDate.setBounds(5,80,105,20);   
               JLSupplierID.setBounds(5,110,105,20);   
               JLShipFromAddress.setBounds(5,140,105,20);   
               JLShipFromCounty.setBounds(5,170,105,20);   
               JLShipViaCarrierName.setBounds(5,200,105,20);   
                JLShippingFee.setBounds(5,230,105,20);
                JLOthers.setBounds(455,50,105,20);   
                JLAprrovedby.setBounds(455,80,105,20);
                                JLItemno.setBounds(455,110,105,20);
                                JLDescription.setBounds(455,140,105,20);
                                JLQtyPurchased.setBounds(455,170,105,20);   
                                JLUnitcost.setBounds(455,200,105,20);   
                                JLDiscount.setBounds(455,230,105,20);   
                                
                                
                                
                                
		
		JLPONo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFPONo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDate.setFont(new Font("Dialog",Font.PLAIN,12));
                                        //   JTFDate.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLShipFromAddress.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFShippingaddress.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLShipFromCounty.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFShippingcounty.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLShipViaCarrierName.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFShippingcarrier.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLShippingFee.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFShippingFee.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLOthers.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFOthers.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLAprrovedby.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFApprovedby.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLItemno.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFItemno.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLQtyPurchased.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFQtyPurchased.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLUnitcost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFUnitcost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                               JTFDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                               JLDiscount.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFDiscount.setFont(new Font("Dialog",Font.PLAIN,12));
                                           
                                           

		JTFPONo.setBounds(110,50,200,20);
                DateChooser.setBounds(110,80,100,20);
                JTFSupplierID.setBounds(110,110,200,20);
                JTFShippingaddress.setBounds(110,140,200,20);
                JTFShippingcounty.setBounds(110,170,200,20);
                JTFShippingcarrier.setBounds(110,200,200,20);
                JTFShippingFee.setBounds(110,230,200,20);
                JTFOthers.setBounds(560,50,200,20);
                                               JTFApprovedby.setBounds(560,80,200,20);
                                           JTFItemno .setBounds(560,110,200,20);
                                            JTFDescription.setBounds(560,140,200,20);
                                            JTFQtyPurchased.setBounds(560,170,200,20);
                                            JTFUnitcost.setBounds(560,200,200,20);
                                            JTFDiscount.setBounds(560,230,200,20);
                                         
		 JPContainer.add(JLPONo);
		JPContainer.add(JTFPONo);
 JPContainer.add(JLDate);
		JPContainer.add(DateChooser);
 JPContainer.add(JLSupplierID);
		JPContainer.add(JTFSupplierID);
 JPContainer.add(JLShipFromAddress);
		JPContainer.add(JTFShippingaddress);
                 JPContainer.add(JLShipViaCarrierName);
		JPContainer.add(JTFShippingcarrier);

                 JPContainer.add(JLShipFromCounty);
		JPContainer.add(JTFShippingcounty);

                 JPContainer.add(JLShippingFee);
		JPContainer.add(JTFShippingFee);

                 JPContainer.add(JLOthers);
		JPContainer.add(JTFOthers);


		JPContainer.add(  JLAprrovedby);
		JPContainer.add(JTFApprovedby);
                 JPContainer.add(JLItemno);
		JPContainer.add(JTFItemno);
                JPContainer.add(JLDescription);
		JPContainer.add(JTFDescription);
                JPContainer.add(JLQtyPurchased);
		JPContainer.add(JTFQtyPurchased);
                JPContainer.add(JLUnitcost);
		JPContainer.add(JTFUnitcost);
                JPContainer.add(JLDiscount);
		JPContainer.add(JTFDiscount);
          
		
	
		//******************** End adding of input field
                                           JBUpdate.setBounds(470,300,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(580,300,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(680,300,99,25);
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
		if(JTFPONo.getText().equals("") || JTFDescription.getText().equals("") || JTFItemno.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated  Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFPONo.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
                                                                                                          JTFPONo.setText("");
					//JTFDate.set("" );
                                                                                                            JTFSupplierID.setText("" );
                                                                                                            JTFShippingaddress.setText("" );
                                                                                                            JTFShippingcounty.setText("" );
                                                                                                            JTFShippingcarrier.setText("" );
                                                                                                            JTFShippingFee.setText("" );
                                                                                                            JTFOthers.setText("" );
                                                                                                            JTFApprovedby.setText("" );
                                                                                                            JTFItemno.setText("");
                                                                                                           JTFDescription .setText("");
                                                                                                           JTFQtyPurchased.setText("" );
                                                                                                           JTFUnitcost.setText("");
                                                                                                           JTFDiscount.setText("" );
                                                                                                         
                                           
		
        }
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAEW.executeUpdate("INSERT INTO PO (PONo,Date,SupplierID,ShipFromAddress,ShipFromCounty,ShipViaCarrierName,ShippingFee,Others,ApprovedBy,ItemNo,Description,QtyPurchased,UnitCost,Discount) " +
		   							   	        "VALUES ('" +
                                                                                                                                                                                                                         JTFPONo.getText() + "', '" +
                                                                                                                                                                                                                   DateChooser.getDateFormatString()+ "', '" +
                                                                                                                                                                                                                        JTFSupplierID.getText() + "', '" +
                                                                                                                                                                                                                        JTFShippingaddress.getText() + "', '" +
                                                                                                                                                                                                                        JTFShippingcounty.getText() + "', '" +
                                                                                                                                                                                                                        JTFShippingcarrier.getText() + "', '" +
                                                                                                                                                                                                                        JTFShippingFee.getText() + "', '" +
                                                                                                                                                                                                                        JTFOthers.getText() + "', '" +
                                                                                                                                                                                                                        JTFApprovedby.getText() + "','"+
                                                                                                                                                                                                                         JTFItemno.getText() + "', '" +
                                                                                                                                                                                                                        JTFDescription .getText() + "', '" +
                                                                                                                                                                                                                        JTFQtyPurchased.getText() + "', '" +
                                                                                                                                                                                                                        JTFUnitcost.getText() + "', '" +
                                                                                                                                                                                                                        JTFDiscount.getText() + 
                                                                                                                                                                                                            "')");
                                                                                                                                                     
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM PO ORDER BY POno ASC",cnAEW,"PONo");
		   					if(total != 0){
		   						FrmPurchaseOrder.reloadRecord("SELECT * FROM PO WHERE PONo = " + total + " ORDER BY PONo ASC");
		   					}else{
		   						FrmPurchaseOrder.reloadRecord("SELECT * FROM PO ORDER BY PONo ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
							if(PromptResult==0){
								clearFields();
								JTFPONo.requestFocus(true);
							}else{
								dispose();
							}
		   				}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}else{
						try{
							String RowIndex;
							RowIndex = rsAEW.getString("PONo");
							stAEW.executeUpdate("UPDATE PO SET PONo= '" +
		   							   	         JTFPONo.getText() + "', Date'" +
                                                                                                                                                                                                                 DateChooser.getDate() + "', SupplierID'" +
                                                                                                                                                                                                                        JTFSupplierID.getText() + "',ShipFromAddress'" +
                                                                                                                                                                                                                        JTFShippingaddress.getText() + "', ShipFromCounty'" +
                                                                                                                                                                                                                        JTFShippingcounty.getText() + "', ShipViaCarrierName'" +
                                                                                                                                                                                                                        JTFShippingcarrier.getText() + "', ShippingFee'" +
                                                                                                                                                                                                                        JTFShippingFee.getText() + "', Others'" +
                                                                                                                                                                                                                        JTFOthers.getText() + "', ApprovedBy'" +
                                                                                                                                                                                                                        JTFApprovedby.getText() +"',ItemNo'"+ 
                                                                                                                                                                                                                          JTFItemno.getText() + "', Description'" +
                                                                                                                                                                                                                        JTFDescription .getText() + "', QtyPurchased'" +
                                                                                                                                                                                                                        JTFQtyPurchased.getText() + "', UnitCount'" +
                                                                                                                                                                                                                        JTFUnitcost.getText() + "', Discount'" +
                                                                                                                                                                                                                        JTFDiscount.  getText() + 
                                                                                                                                                                                                                               
		   							   	        "' WHERE PONo = " + RowIndex);
		   					FrmPurchaseOrder.reloadRecord("SELECT * FROM PO WHERE PONo= " + RowIndex + " ORDER BY PONo ASC");
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