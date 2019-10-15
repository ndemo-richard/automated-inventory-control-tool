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

public class frm_add_edit_product extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLItemNo = new JLabel("ItemNo:");
	JLabel JLDescription = new JLabel("Description:");
                    JLabel JLSKU = new JLabel("SKU:");
	JLabel JLCategoryIndex = new JLabel("Category:");
	JLabel JLSupplierID = new JLabel("Supplier:");
	JLabel JLQuantityPerUnit= new JLabel("Quantity per unit:");
	JLabel JLUnitMeasure = new JLabel("Unit measure:");
	JLabel JLUnitCost = new JLabel("Unit Cost:");
	JLabel JLSalesPrice = new JLabel("Sales Price:");
	JLabel JLQtyOnHand = new JLabel("Qty on Hand:");
	JLabel JLQtyOnOrder = new JLabel("Qty on Order:");
                    JLabel JLReOrderLevel = new JLabel("ReOrder Level:");
                    JLabel JLWarehouseId = new JLabel("Warehouse:");
                    JLabel JLLocation = new JLabel("Location:");
                    JLabel JLActive = new JLabel("Active:");

	JTextField JTFItemNo = new JTextField();
                    JTextField JTFDescription = new JTextField();
                    JTextField JTFSKU= new JTextField();
                    JComboBox JCategoryname= new JComboBox();
                    JComboBox JSupplierID=new JComboBox();
                    JTextField JTFQuantityPerUnit = new JTextField();
                    JTextField JTFUnitMeasure = new JTextField();
                    JTextField JTFUnitCost = new JTextField();
                    JTextField JTFSalesPrice = new JTextField();
                    JTextField JTFQtyOnHand = new JTextField();
                    JTextField JTFQtyOnOrder = new JTextField();
                    JTextField JTFReOrderLevel = new JTextField();
              
                    JComboBox JWarehouseid=new JComboBox();
                    JTextField JTFLocation = new JTextField();
                    JTextField JTFActive = new JTextField();
	

	Connection cnAEW;
	Statement stAEW;
	ResultSet rsAEW;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_edit_product(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEW = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAEW = cnAEW.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){
                           
		}
                 JWarehouseid= clsPublicMethods.fillCombo("SELECT * FROM Warehouse",cnAEW,"WarehouseName");
                 JSupplierID= clsPublicMethods.fillCombo("SELECT * FROM Supplier",cnAEW,"Company_name");
                 JCategoryname= clsPublicMethods.fillCombo("SELECT * FROM Category",cnAEW,"CategoryName");
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Product");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Product");
			JBUpdate.setText("Save");
			try{
				rsAEW = stAEW.executeQuery(srcSQL);
				rsAEW.next();
					JTFItemNo.setText("" + rsAEW.getString("ItemNo"));
					JTFDescription.setText("" + rsAEW.getString("Description"));
                                                                                                           JTFSKU .setText("" + rsAEW.getString("SKU"));
                                                                                                           JCategoryname .setSelectedItem("" + rsAEW.getString("CategoryIndex"));
                                                                                                       
                                                                                                            JSupplierID.setSelectedItem("" + rsAEW.getString("SupplierID"));
                                                                                                            JTFQuantityPerUnit.setText("" + rsAEW.getString("QuantityPerUnit"));
                                                                                                            JTFUnitMeasure.setText("" + rsAEW.getString("UnitMeasure"));
                                                                                                            JTFUnitCost.setText("" + rsAEW.getString("UnitCost"));
                                                                                                            JTFSalesPrice.setText("" + rsAEW.getString("SalesPrice"));
                                                                                                            JTFQtyOnHand.setText("" + rsAEW.getString("QtyOnHand"));
                                                                                                            JTFQtyOnOrder.setText("" + rsAEW.getString("QtyOnOrder"));
                                                                                                            JTFReOrderLevel.setText("" + rsAEW.getString("ReOrderLevel"));
                                                                                                          
                                                                                                            JWarehouseid.setSelectedItem("" + rsAEW.getString("Warehouse"));
                                                                                                            JTFLocation.setText("" + rsAEW.getString("Location"));
                                                                                                            JTFActive.setText("" + rsAEW.getString("Active"));
                                                                                                            
                                                                                                            
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
                
                               JLItemNo .setBounds(5,50,105,20);
                                JLDescription.setBounds(5,72,105,20);
                                JLSKU.setBounds(5,94,105,20);
                                JLCategoryIndex.setBounds(5,116,105,20);
                                JLSupplierID.setBounds(5,138,105,20);
                                JLQuantityPerUnit.setBounds(5,160,105,20);
                                JLUnitMeasure.setBounds(5,180,105,20);
                                JLUnitCost.setBounds(5,204,105,20);
                                JLSalesPrice.setBounds(5,226,105,20);
                                JLQtyOnHand.setBounds(5,248,105,20);
                                JLQtyOnOrder.setBounds(5,270,105,20);
                                JLReOrderLevel.setBounds(5,292,105,20);
                                JLWarehouseId.setBounds(5,314,105,20);
                                JLLocation.setBounds(5,336,105,20);
                                JLActive.setBounds(5,358,105,20);
                                
                                
                                
		
		JLItemNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFItemNo.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFDescription.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLSKU.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFSKU.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLCategoryIndex.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JCategoryname.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JSupplierID.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLQuantityPerUnit.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFQuantityPerUnit.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLUnitMeasure.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFUnitMeasure.setFont(new Font("Dialog",Font.PLAIN,12));
                                          JLUnitCost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFUnitCost.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLSalesPrice.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFSalesPrice.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLQtyOnHand.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFQtyOnHand.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLReOrderLevel.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFReOrderLevel.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLWarehouseId.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JWarehouseid.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLLocation.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFLocation.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JLActive.setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFActive.setFont(new Font("Dialog",Font.PLAIN,12));
                                          JLQtyOnOrder .setFont(new Font("Dialog",Font.PLAIN,12));
                                           JTFQtyOnOrder.setFont(new Font("Dialog",Font.PLAIN,12));
                                           

		JTFItemNo.setBounds(110,50,200,20);
                                           JTFDescription .setBounds(110,72,200,20);
                                            JTFSKU.setBounds(110,94,200,20);
                                            JCategoryname.setBounds(110,116,200,20);
                                            JSupplierID.setBounds(110,138,200,20);
                                            JTFQuantityPerUnit.setBounds(110,160,200,20);
                                            JTFUnitMeasure.setBounds(110,180,200,20);
                                            JTFUnitCost.setBounds(110,204,200,20);
                                            JTFSalesPrice.setBounds(110,226,200,20);
                                            JTFQtyOnHand.setBounds(110,248,200,20);
                                           JTFQtyOnOrder.setBounds(110,270,200,20);
                                            JTFReOrderLevel.setBounds(110,292,200,20);
                                            JWarehouseid.setBounds(110,314,200,20);
                                            JTFLocation.setBounds(110,336,200,20);
                                            JTFActive.setBounds(110,358,200,20);
		
		JPContainer.add(JLItemNo);
		JPContainer.add(JTFItemNo);
                JPContainer.add(JLDescription);
		JPContainer.add(JTFDescription);
                JPContainer.add(JLSKU);
		JPContainer.add(JTFSKU);
                JPContainer.add(JLCategoryIndex);
		JPContainer.add(JCategoryname);
                JPContainer.add(JLSupplierID);
		JPContainer.add(JSupplierID);
                JPContainer.add(JLQuantityPerUnit);
		JPContainer.add(JTFQuantityPerUnit);
                JPContainer.add(JLUnitMeasure);
		JPContainer.add(JTFUnitMeasure);
                JPContainer.add(JLUnitCost);
		JPContainer.add(JTFUnitCost);
                JPContainer.add(JLSalesPrice);
		JPContainer.add(JTFSalesPrice);
                JPContainer.add(JLQtyOnHand);
		JPContainer.add(JTFQtyOnHand);
                JPContainer.add(JLQtyOnOrder);
		JPContainer.add(JTFQtyOnOrder);
                JPContainer.add(JLReOrderLevel);
		JPContainer.add(JTFReOrderLevel);
                JPContainer.add(JLWarehouseId);
		JPContainer.add(JWarehouseid);
                JPContainer.add(JLLocation);
		JPContainer.add(JTFLocation);
                JPContainer.add(JLActive);
		JPContainer.add(JTFActive);
		
	
		//******************** End adding of input field
                                           JBUpdate.setBounds(5,400,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(112,400,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(212,400,99,25);
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
		if(JTFItemNo.getText().equals("") || JTFDescription.getText().equals("") || JTFSKU.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Automated  Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFItemNo.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
		JTFItemNo.setText("");
                                            JTFDescription.setText("");
                                            JTFSKU.setText("");
                                            JCategoryname.setSelectedIndex(0);
                                            JSupplierID.setSelectedIndex(0);
                                            JTFQuantityPerUnit.setText("");
                                            JTFUnitMeasure.setText("");
                                            JTFUnitCost.setText("");
                                            JTFSalesPrice.setText("");
                                            JTFQtyOnHand.setText("");
                                            JTFQtyOnOrder.setText("");
                                            JTFReOrderLevel.setText("");
                                          JWarehouseid.setSelectedIndex(0);
                                            JTFLocation.setText("");
                                            JTFActive.setText("");
		
        }
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAEW.executeUpdate("INSERT INTO Item(ItemNo,Description,SKU,CategoryIndex,SupplierID,QuantityPerUnit,UnitMeasure,UnitCost,SalesPrice,QtyOnHand,QtyOnOrder,ReOrderLevel,WarehouseId,Location,Active) " +
		   							   	        "VALUES ('" +
		   							   	        JTFItemNo.getText() + "', '" +
		   							   	         JTFDescription.getText() + "', '" +
                                                                                                                                                                                                                                  JTFSKU.getText() + "', '" +
                                                                                                                                                                                                                                JCategoryname.getSelectedItem().toString()+ "', '" +
                                                                                                                                                                                                                             JSupplierID.getSelectedItem().toString() + "', '" +
                                                                                                                                                                                                                                JTFQuantityPerUnit.getText() + "', '" +
                                                                                                                                                                                                                                JTFUnitMeasure.getText() + "', '" +
                                                                                                                                                                                                                                JTFUnitCost.getText() + "', '" +
                                                                                                                                                                                                                                JTFSalesPrice.getText() + "', '" +
                                                                                                                                                                                                                                JTFQtyOnHand.getText() + "', '" +
                                                                                                                                                                                                                                JTFQtyOnOrder.getText() + "', '" +
                                                                                                                                                                                                                                JTFReOrderLevel.getText() + "', '" +
                                                                                                                                                                                                                               JWarehouseid.getSelectedItem().toString() + "', '" +
                                                                                                                                                                                                                                JTFLocation.getText() + "', '" +
		   							   	        JTFActive.getText() +
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM Item ORDER BY ItemNo ASC",cnAEW,"ItemNo");
		   					if(total != 0){
		   						FrmProduct.reloadRecord("SELECT * FROM Item WHERE ItemNo = " + total + " ORDER BY Description ASC");
		   					}else{
		   						FrmProduct.reloadRecord("SELECT * FROM Item ORDER BY Description ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Automated Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Automated Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
							if(PromptResult==0){
								clearFields();
								JTFItemNo.requestFocus(true);
							}else{
								dispose();
							}
		   				}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}else{
						try{
							String RowIndex;
							RowIndex = rsAEW.getString("ItemNo");
							stAEW.executeUpdate("UPDATE Product SET ItemNo = '" +
		   							   	        JTFItemNo.getText() + "',Description= '" +
		   							   	         JTFDescription.getText() + "', SKU'" +
                                                                                                                                                                                                                                  JTFSKU.getText() + "', CategoryIndex'" +
                                                                                                                                                                                                                                JCategoryname.getSelectedItem().toString() + "', SupplierID'" +
                                                                                                                                                                                                                              JSupplierID.getSelectedItem().toString() + "', QuantityPerUnit'" +
                                                                                                                                                                                                                                JTFQuantityPerUnit.getText() + "', UnitMeasure'" +
                                                                                                                                                                                                                                JTFUnitMeasure.getText() + "', UnitCost'" +
                                                                                                                                                                                                                                JTFUnitCost.getText() + "', SalesPrice'" +
                                                                                                                                                                                                                                JTFSalesPrice.getText() + "', QtyOnHand'" +
                                                                                                                                                                                                                                JTFQtyOnHand.getText() + "', QtyOnOrder'" +
                                                                                                                                                                                                                                JTFQtyOnOrder.getText() + "', ReOrderLevel'" +
                                                                                                                                                                                                                                JTFReOrderLevel.getText() + "', WarehouseId'" +
                                                                                                                                                                                                                                JWarehouseid.getSelectedItem().toString() + "',Location '" +
                                                                                                                                                                                                                                JTFLocation.getText() + "', Active'" +
		   							   	        JTFActive.getText() +
		   							   	        "' WHERE ItemNo = " + RowIndex);
		   					FrmWarehouse.reloadRecord("SELECT * FROM Item WHERE ItemNo = " + RowIndex + " ORDER BY Description ASC");
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