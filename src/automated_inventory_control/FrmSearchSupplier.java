/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ndemo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmSearchSupplier extends JDialog{
	//Start create variables
	JButton JBSearch = new JButton("Search",new ImageIcon("images/search.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bSearch.png"));
	JLabel JLBanner = new JLabel("Enter text and select where to locate.");
	JPanel JPDialogContainer = new JPanel();

	JLabel JLSearchFor = new JLabel("Search For:");
	JLabel JLSearchIn = new JLabel("Look In:");

	JTextField JTFSearchFor = new JTextField();

	JComboBox JCSearchIn;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	//End create variables

	public FrmSearchSupplier(JFrame OwnerForm){
		super(OwnerForm,true);
	    setTitle("Search Supplier");

		//Start Initalize variables
		String StrListItem[]={"Supplier ID","Company Name","First Name"};
		JCSearchIn = new JComboBox(StrListItem);
		StrListItem = null;

		JPDialogContainer.setLayout(null);

		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPDialogContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner.setBounds(55,5,280,48);
		JLBanner.setFont(new Font("Dialog",Font.PLAIN,12));
		JPDialogContainer.add(JLBanner);
		//End initialize variables

		//******************** Start adding of input field
		//-- Add Id Input Field
		JLSearchFor.setBounds(5,50,105,20);
		JLSearchFor.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFSearchFor.setBounds(110,50,225,20);
		JTFSearchFor.setFont(new Font("Dialog",Font.PLAIN,12));

		JPDialogContainer.add(JLSearchFor);
		JPDialogContainer.add(JTFSearchFor);

		//-- Add Name Input Field
		JLSearchIn.setBounds(5,72,105,20);
		JLSearchIn.setFont(new Font("Dialog",Font.PLAIN,12));

		JCSearchIn.setBounds(110,72,225,20);
		JCSearchIn.setFont(new Font("Dialog",Font.PLAIN,12));

		JPDialogContainer.add(JLSearchIn);
		JPDialogContainer.add(JCSearchIn);
		//******************** End adding of input field

		//-- Add the JBSearch
		JBSearch.setBounds(137,100,99,25);
		JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBSearch.setMnemonic(KeyEvent.VK_S);
		JBSearch.addActionListener(JBActionListener);
		JBSearch.setActionCommand("search");
		JPDialogContainer.add(JBSearch);

		//-- Add the JBCancel
		JBCancel.setBounds(237,100,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPDialogContainer.add(JBCancel);

		getContentPane().add(JPDialogContainer);
		setSize(350,165);
		setResizable(false);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));

	}
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="search"){
				if(JTFSearchFor.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter a text to search.","Automated inventory control system",JOptionPane.WARNING_MESSAGE);
					JTFSearchFor.requestFocus();
				}else{
					FrmSupplier.reloadRecord("SELECT * FROM Supplier WHERE " + JCSearchIn.getSelectedItem().toString().replaceAll(" ", "") + " LIKE '%" + JTFSearchFor.getText() + "%' ORDER BY CompanyName ASC");
					dispose();
				}

			}else{
				dispose();
			}
		}
	};
}
