/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

import java.sql.Connection;

/**
 *
 * @author ndemo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.PrintJob;
import java.util.*;
import java.text.*;

public class FrmCategory extends JInternalFrame{

	/************************ Variable declaration start **********************/

	//Start form variables
	public static JScrollPane PrdTableJSP = new JScrollPane();

	public static JPanel JPContainer = new JPanel();

	public static JTable JTPrdTable;

	JLabel JLPicture1 = new JLabel(new ImageIcon("images/helper.png"));
	JLabel JLHelpText = new JLabel("To display a certain  \n record click the 'search button' and look for the record that you want.");

	JFrame JFParentFrame;

	JButton JBAddNew = new JButton("Add New",new ImageIcon("images/new.png"));
	JButton JBModify = new JButton("Modify",new ImageIcon("images/modify.png"));
	JButton JBSearch = new JButton("Search",new ImageIcon("images/search.png"));
	JButton JBPrint = new JButton("Print",new ImageIcon("images/print.png"));
	JButton JBDelete = new JButton("Delete",new ImageIcon("images/delete.png"));
	JButton JBReload = new JButton("Reload",new ImageIcon("images/reload.png"));

	Connection cnPrd;

	public static Statement stPrd;

	public static ResultSet rsPrd;

	public static String strSQL;
	public static String Content[][];

	public static int rowNum = 0;
	public static int total = 0;

	boolean goEOF;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	//End form variables

	/********************** End variable declaration start ********************/

	/********************* Start FrmWarehouse constructor
     * @param srcCN
     * @param getParentFrame
     * @throws java.sql.SQLException **********************/
	public FrmCategory(Connection srcCN,JFrame getParentFrame) throws SQLException{
		//Set the form caption and some properties start
		super("Category Records",false,true,false,true);
		//End set the form caption and some properties

		//Start initialize variables
		JPContainer.setLayout(null);

		JFParentFrame = getParentFrame;

		cnPrd = srcCN;
		stPrd = cnPrd.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		strSQL = "SELECT * FROM Category  ORDER BY Description ASC";

		//-- Add the JLPicture1
		JLPicture1.setBounds(5,5,48,48);
		JPContainer.add(JLPicture1);

		//-- Add the JLHelpText
		JLHelpText.setBounds(55,5,570,48);
		JLHelpText.setFont(new Font("Dialog", Font.PLAIN, 12));
		JPContainer.add(JLHelpText);

		//-- Add the WrhTable
		JTPrdTable=CreateTable();
		PrdTableJSP.getViewport().add(JTPrdTable);
		PrdTableJSP.setBounds(5,55,727,320);
		JPContainer.add(PrdTableJSP);

		//-- Add the JBAddNew
		JBAddNew.setBounds(5,382,105,25);
		JBAddNew.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBAddNew.setMnemonic(KeyEvent.VK_A);
		JBAddNew.addActionListener(JBActionListener);
		JBAddNew.setActionCommand("add");
		JPContainer.add(JBAddNew);

		//-- Add the JBModify
		JBModify.setBounds(112,382,99,25);
		JBModify.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBModify.setMnemonic(KeyEvent.VK_M);
		JBModify.addActionListener(JBActionListener);
		JBModify.setActionCommand("modify");
		JPContainer.add(JBModify);

		//-- Add the JBSearch
		JBSearch.setBounds(212,382,99,25);
		JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBSearch.setMnemonic(KeyEvent.VK_S);
		JBSearch.addActionListener(JBActionListener);
		JBSearch.setActionCommand("search");
		JPContainer.add(JBSearch);

		//-- Add the JBPrint
		JBPrint.setBounds(312,382,99,25);
		JBPrint.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBPrint.setMnemonic(KeyEvent.VK_P);
		JBPrint.addActionListener(JBActionListener);
		JBPrint.setActionCommand("print");
		JPContainer.add(JBPrint);

		//-- Add the JBDelete
		JBDelete.setBounds(413,382,105,25);
		JBDelete.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBDelete.setMnemonic(KeyEvent.VK_D);
		JBDelete.addActionListener(JBActionListener);
		JBDelete.setActionCommand("delete");
		JPContainer.add(JBDelete);

		//-- Add the JBReload
		JBReload.setBounds(627,382,105,25);
		JBReload.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReload.setMnemonic(KeyEvent.VK_R);
		JBReload.addActionListener(JBActionListener);
		JBReload.setActionCommand("reload");
		JPContainer.add(JBReload);

		//End initialize variables

		//Start set the form properties
		getContentPane().add(JPContainer);
		setSize(747,450);
		setLocation((screen.width - 747)/2,((screen.height-450)/2)-45);
		setFrameIcon(new ImageIcon("images/Warehouse.png"));
		//End set the form properties

	}
	/********************** FrmWarehouse constructor end ***********************/

	/************************** Start event handling **************************/

	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			//Add Record
			if(srcObj=="add"){
				JDialog JDAdd = new frm_add_edit_category(true,JFParentFrame,cnPrd,"");
				JDAdd.show();
			//Modify Record
			}else if(srcObj=="modify"){
				if(total != 0){
					try{
							if(JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),JTPrdTable.getSelectedColumn()) != null){
								JDialog JDEdit = new frm_add_edit_category(false,JFParentFrame,cnPrd,"SELECT * FROM Category  WHERE CategoryIndex= " + JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),0));
								JDEdit.show();

							}
					}catch(Exception sqlE){
						if(sqlE.getMessage() != null){
							System.out.println(sqlE.getMessage());
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to modify.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}

					}
				}
			//Search Record
			}else if(srcObj=="search"){
				JDialog JDSearchRec = new FrmSearchCategory(JFParentFrame);
				JDSearchRec.show(true);
			//Print Record
			}else if(srcObj=="print"){
				if(total != 0){
					try{
							if(JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),JTPrdTable.getSelectedColumn()) != null){
								clsPublicMethods PrintingClass = new clsPublicMethods();
								ResultSet rsPrint = stPrd .executeQuery("SELECT * FROM Category WHERE CategoryIndex = " + JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),0));
								if(rsPrint.next()==true){
									String RecordToPrint = "";
									java.util.Date CurrentDate = new java.util.Date();
									SimpleDateFormat SDFDateFormatter = new SimpleDateFormat("MMM. dd, yyyy",Locale.getDefault());

									RecordToPrint += "                       CATEGORY   R E C O R D\n";
									RecordToPrint += "                              " + SDFDateFormatter.format(CurrentDate).toString() + "\n\n\n";


									RecordToPrint += "___________________________________________________________________________________\n\n\n";

									RecordToPrint += " Category  Index: " + rsPrint.getString("CategoryIndex") + "                 Category Name: " + rsPrint.getString("CategoryName") + "\n";
									RecordToPrint += "___________________________________________________________________________________\n";
									RecordToPrint += "___________________________________________________________________________________\n\n";


									RecordToPrint += " Category Index: " + rsPrint.getString("CategoryIndex") + "\n";
									RecordToPrint += " Category Name: " + rsPrint.getString("CategoryName") + "\n";
									RecordToPrint += " Description: " + rsPrint.getString("Description") + "\n";
									

									RecordToPrint += "___________________________________________________________________________________\n\n";

									PrintingClass.printRecord(RecordToPrint,JFParentFrame);

									CurrentDate=null;
									SDFDateFormatter=null;
									RecordToPrint=null;

								}else{
									JOptionPane.showMessageDialog(null,"The selected record has been change since last modified. Please click the 'Reload' button and try again!","No record to print",JOptionPane.WARNING_MESSAGE);
								}
								//Dispose the variable
								rsPrint=null;

							}
					}catch(Exception sqlE){
						if(sqlE.getMessage() != null){
							System.out.println(sqlE.getMessage());
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to print.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			//Delete Record
			}else if(srcObj=="delete"){
				if(total != 0){
					try{
						if(JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),JTPrdTable.getSelectedColumn()) != null){
							String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete the selected record?","Delete Record",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,ObjButtons,ObjButtons[1]);
							if(PromptResult==0){
								stPrd.execute("DELETE * FROM Category WHERE CategoryIndex = " + JTPrdTable.getValueAt(JTPrdTable.getSelectedRow(),0));
								reloadRecord();
								JOptionPane.showMessageDialog(null,"Record has been successfully deleted.","Comfirm Delete",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}catch(Exception sqlE){
						if(sqlE.getMessage()!=null){
							JOptionPane.showMessageDialog(null,"You cannot delete this Category because it already have an invoice transaction.\nIn order to delete this Warehouse, delete its invoice first.","Comfirm Delete",JOptionPane.WARNING_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to deleted.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			//Reload Record
			}else if(srcObj=="reload"){
				reloadRecord();
			//Close the Form
			}
		}
	};
	/*************************** End event handling ***************************/

	/************************** Start Custom class ***************************/

	public static  JTable CreateTable(){
		String ColumnHeaderName[] = {
			"Category Index","Category Name","Description"
		};
		try{
			rsPrd = stPrd.executeQuery(strSQL);
			total = 0;
			//Move to the last record
			rsPrd.afterLast();
			//Get the current record position
			if(rsPrd.previous())total = rsPrd.getRow();
			//Move back to the first record;
			rsPrd.beforeFirst();
			if(total != 0){
				Content = new String[total][4];
				while(rsPrd.next()){
					Content[rowNum][0] = "" + rsPrd.getString("CategoryIndex");
					Content[rowNum][1] = "" + rsPrd.getString("CategoryName");
					Content[rowNum][2] = "" + rsPrd.getString("Description");
					rowNum++;
				}
			}else{
				Content = new String[0][4];
				Content[0][0] = " ";
				Content[0][1] = " ";
				Content[0][2] = " ";
		
			}
		}catch(Exception eE){
		}
		JTable NewTable = new JTable (Content,ColumnHeaderName){
			public boolean isCellEditable (int iRows, int iCols) {
				return false;
			}
		};

		NewTable.setPreferredScrollableViewportSize(new Dimension(727, 320));
		NewTable.setBackground(Color.white);

		//Start resize the table column
		NewTable.getColumnModel().getColumn(0).setMaxWidth(0);
		NewTable.getColumnModel().getColumn(0).setMinWidth(0);
		NewTable.getColumnModel().getColumn(0).setWidth(0);
		NewTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		NewTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		NewTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		//End resize the table column

		//Disposed variables
		ColumnHeaderName=null;
		Content=null;

		rowNum = 0;

		return NewTable;
	}

	/**************************** End Custom class ****************************/

	/************************** Start Custom method ***************************/

	public static void reloadRecord(String srcSQL){
				strSQL = srcSQL;
				PrdTableJSP.getViewport().remove(JTPrdTable);
				JTPrdTable=CreateTable();
				PrdTableJSP.getViewport().add(JTPrdTable);
				JPContainer.repaint();
	}

	public static void reloadRecord(){
				PrdTableJSP.getViewport().remove(JTPrdTable);
				JTPrdTable=CreateTable();
				PrdTableJSP.getViewport().add(JTPrdTable);
				JPContainer.repaint();
	}

	/*************************** End Custom method ****************************/

}