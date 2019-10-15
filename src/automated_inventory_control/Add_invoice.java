
package automated_inventory_control;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JInternalFrame;

public class Add_invoice   extends JDialog{
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	MysqlConnect  db2  = new MysqlConnect ();
	InvoiceGenerator inv = new InvoiceGenerator();
	Double rateOfCar = 0.0;
	int sku;

	private JDialog frmInvoiceGenerator;
	private JTextField JTFDiscount;
	private JTextField JTFPartialdepo;
        private JTextField JTFSKU;
	private JTextField JTFUnitCost;
	private JTextField JTFQuantity;
	private JTextField JTFLineTotal;
	private JTextField JTFSubTotal;
	private JTextField JTFBalanceDue;
	private JComboBox JPOID;
	private JComboBox JItem;
	private JComboBox JClient;
	private JButton btnGenerateInvoice;
	private static Add_invoice window;
         private JTextField InvoiceDate;
         private JTextField DueDate;
         private JTextField PaidToDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Add_invoice();
					window.frmInvoiceGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_invoice() {
		initialize();
	}

	/**
	 * initialism the contents of the frame.
	 */
	private void initialize() {
			 
		frmInvoiceGenerator = new JDialog();
		//frmCabInvoiceGenerator.setVisible(true);
		frmInvoiceGenerator.setResizable(false);
		frmInvoiceGenerator.setTitle(" AIS");
		frmInvoiceGenerator.setBounds(100, 100, 800, 453);
		//frmInvoiceGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvoiceGenerator.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 800, 54);
		frmInvoiceGenerator.getContentPane().add(panel_1);
		
		JLabel lblCabInvoiceGenerator = new JLabel("Create Invoice");
		lblCabInvoiceGenerator.setFont(new Font("Tahoma", Font.BOLD, 28));
		panel_1.add(lblCabInvoiceGenerator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(0, 65, 800, 318);
		frmInvoiceGenerator.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(10, 11, 70, 14);
		lblCustomer.setAlignmentY(0.0f);
		lblCustomer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblCustomer.setVerticalAlignment(SwingConstants.TOP);
		lblCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustomer);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(10, 35, 58, 14);
		panel_2.add(lblItem);
	    Date dnow =new Date();
            SimpleDateFormat ft = new SimpleDateFormat("YYYY.mm.dd");
		
		JItem = new JComboBox();
		JItem.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
                            String Itemselected = JItem.getSelectedItem().toString();
				try{
					Connection con  = db2.ConnectDB();
                             
					PreparedStatement statement = con.prepareStatement("select * from Item where Description=?");
					statement.setString(1,Itemselected);
					ResultSet rs = statement.executeQuery();
					while(rs.next()){
					 sku = rs.getInt(3);
						JTFSKU.setText(Integer.toString(sku));
						
					}
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(JItem, e.getMessage());
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		JItem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try{
					Connection con = db2.ConnectDB();
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery("select Description from Item");
					JItem.removeAllItems();			//remove previous list of items before updating the list with new items.
					while(rs.next()){
						JItem.addItem(rs.getString("Description"));
                                                                                                                             
					}
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(JItem,e.getMessage());
				}
			}
		});
		JItem.setBounds(120, 32, 145, 20);
		panel_2.add(JItem);
		
		JLabel lblpoid = new JLabel("POID");
		lblpoid.setBounds(10, 60, 70, 14);
		panel_2.add(lblpoid);
                JPOID = new JComboBox();
		JPOID.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				String selectedCarNumber = JPOID.getSelectedItem().toString();
				try{
					Connection con = db2.ConnectDB();
					PreparedStatement statement = con.prepareStatement("select * from PO where PONo=?");
					statement.setString(1,selectedCarNumber);
					ResultSet rs = statement.executeQuery();
					while(rs.next()){
						
						
					}
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(JPOID, e.getMessage());
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		JPOID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try{
					 Connection con= db2.ConnectDB();
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery("select PONo from PO");
					JPOID.removeAllItems();			//remove previous list of items before updating the list with new items.
					while(rs.next()){
						JPOID.addItem(rs.getString("PONo"));;						
					}
					con.close();					
				}catch(Exception ee){
					JOptionPane.showMessageDialog(JClient,ee.getMessage());
				}
			}
		});
            
                JPOID.setBounds(120, 55, 145, 20);
		panel_2.add(JPOID);
		
		JClient = new JComboBox();
		JClient.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				String selectedCarNumber = JClient.getSelectedItem().toString();
				try{
					Connection con = db2.ConnectDB();
					PreparedStatement statement = con.prepareStatement("select * from Customer where CompanyName=?");
					statement.setString(1,selectedCarNumber);
					ResultSet rs = statement.executeQuery();
					while(rs.next()){
						
						
					}
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(JClient, e.getMessage());
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		JClient.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try{
					 Connection con= db2.ConnectDB();
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery("select CompanyName from Customer");
					JClient.removeAllItems();			//remove previous list of items before updating the list with new items.
					while(rs.next()){
						JClient.addItem(rs.getString("CompanyName"));;						
					}
					con.close();					
				}catch(Exception ee){
					JOptionPane.showMessageDialog(JClient,ee.getMessage());
				}
			}
		});
		JClient.setBounds(120, 8, 145, 20);
		panel_2.add(JClient);
                                            
                                            InvoiceDate = new JFormattedTextField();
                                            InvoiceDate.setEditable(false);
                                            InvoiceDate.setText(ft.format(dnow));
		//tfCarModel.setEditable(false);
		InvoiceDate.setBounds(450, 30, 132, 20);
		panel_2.add(InvoiceDate);
		
		
		JLabel lblInvoiceDate = new JLabel("Invoice Date: ");
		lblInvoiceDate.setBounds(340, 30, 100, 14);
		panel_2.add(lblInvoiceDate);
                
		
		JTFDiscount = new JTextField();
		//tfCarModel.setEditable(false);
		JTFDiscount.setBounds(450, 57, 132, 20);
		panel_2.add(JTFDiscount);
		JTFDiscount.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount: ");
		lblDiscount.setBounds(340, 60, 100, 14);
		panel_2.add(lblDiscount);
		
		JLabel lblPartialDepo = new JLabel("Partial Depo:");
		lblPartialDepo.setBounds(10, 85, 100, 20);
		panel_2.add(lblPartialDepo);
		
		JTFPartialdepo = new JTextField();
		JTFPartialdepo.setBounds(120, 82, 120, 20);
		panel_2.add(JTFPartialdepo);
		JTFPartialdepo.setColumns(10);
		
		JLabel lblDescription = new JLabel("SKU:");
		lblDescription.setBounds(340, 85, 100,20);
		panel_2.add(lblDescription);
		
		JTFSKU= new JTextField();
		JTFSKU.setBounds(450, 82, 132, 20);
                                            JTFSKU.setEditable(false);
                                                    
		panel_2.add(JTFSKU);
                
		JTFSKU.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 110, 100, 20);
		panel_2.add(lblQuantity);
		
		JTFQuantity = new JTextField();
		JTFQuantity.setBounds(120, 107, 120, 20);
		panel_2.add(JTFQuantity);
		JTFQuantity.setColumns(10);
		
		JLabel lblUnitCost = new JLabel("Unit Cost:");
		lblUnitCost.setBounds(340, 110, 100, 20);
		panel_2.add(lblUnitCost);
		
		JTFUnitCost = new JTextField();
		JTFUnitCost.setBounds(450, 107, 132, 20);
		panel_2.add(JTFUnitCost);
		JTFUnitCost.setColumns(10);
		
		JLabel lblLinetotal = new JLabel("Line_Total");
		lblLinetotal.setBounds(10, 135, 100, 20);
		panel_2.add(lblLinetotal);
		
		JTFLineTotal = new JTextField();
		JTFLineTotal.setBounds(120, 132, 120, 20);
		panel_2.add(JTFLineTotal);
		JTFLineTotal.setColumns(10);
		
	
		
		JLabel lblpaidtodate = new JLabel("Paid To Date");
		lblpaidtodate.setBounds(340, 135, 100, 20);
		panel_2.add(lblpaidtodate);
                                            
                                            PaidToDate= new JFormattedTextField();
                                            PaidToDate.setEditable(false);
                                             PaidToDate.setText(ft.format(dnow));
                                            PaidToDate.setBounds(450, 132, 132, 20);
		panel_2.add(PaidToDate);
		
		
		JLabel lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setBounds(10, 160, 100, 20);
		panel_2.add(lblSubtotal);
		
		JTFSubTotal= new JTextField();
                JTFSubTotal.setBounds(120, 157, 120, 20);
		panel_2.add(JTFSubTotal);
		JTFSubTotal.setColumns(10);
                
                                        JLabel lblbalancedue = new JLabel("Balance Due:");
		lblbalancedue.setBounds(340, 157, 100, 20);
		panel_2.add(lblbalancedue);
		
		JTFBalanceDue= new JTextField();
                                            JTFBalanceDue.setBounds(450, 157, 132, 20);
		panel_2.add(JTFBalanceDue);
		JTFBalanceDue.setColumns(10);
                
                
                                          JLabel lblDuedate = new JLabel("Due Date:");
		lblDuedate.setBounds(340, 182, 100, 20);
		panel_2.add(lblDuedate);
		
		DueDate= new JFormattedTextField();
                DueDate.setEditable(false);
                 DueDate.setText(ft.format(dnow));
                                            DueDate.setBounds(450, 182, 132, 20);
		panel_2.add(DueDate);
		
		
		btnGenerateInvoice = new JButton("Generate Invoice");
                                            btnGenerateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(JTFPartialdepo.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFDiscount.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFSKU.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFUnitCost.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFQuantity.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFSubTotal.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFLineTotal.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else if(JTFBalanceDue.getText().isEmpty()){
					JOptionPane.showMessageDialog(btnGenerateInvoice, "Please Fill All the details!");
				}
				else{
					try{
						Connection con = db2.ConnectDB();
					
					
					
					String InvoiceID = inv.InvoiceIDGenerator();
					
						
						String ins = "insert into Invoices values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement st = con.prepareStatement(ins);
                                                                                                                                st.setString(1, InvoiceID);			//returns the unique 9-digit alphanumeric code to be used as Invoice ID
                                                                                                                                st.setString(2, JClient.getSelectedItem().toString());
                                                                                                                                st.setString(3, InvoiceDate.getText());
                                                                                                                                st.setString(4, DueDate.getText());
                                                                                                                                st.setString(5,JTFPartialdepo.getText());
                                                                                                                                st.setString(6,JPOID.getSelectedItem().toString());
                                                                                                                                st.setString(7,JTFDiscount.getText());
                                                                                                                                st.setString(8, JItem.getSelectedItem().toString());
                                                                                                                                st.setString(9, JTFSKU.getText());
                                                                                                                                st.setString(10, JTFUnitCost.getText());
                                                                                                                                st.setString(11, JTFQuantity.getText());
                                                                                                                                st.setString(12, JTFLineTotal.getText());
                                                                                                                                st.setString(13, JTFSubTotal.getText());
                                                                                                                                st.setString(14, PaidToDate.getText());
                                                                                                                                st.setString(15, JTFBalanceDue.getText());
						
						int status = st.executeUpdate();
						if(status>0){
							JOptionPane.showMessageDialog(btnGenerateInvoice, "Invoice Generated. View/Print Invoice");
							inv.writeToFile(InvoiceID);
						}
						else
							JOptionPane.showMessageDialog(btnGenerateInvoice, "Error");
						con.close();
						
					}catch(Exception e){
						JOptionPane.showMessageDialog(btnGenerateInvoice, e.getMessage()+"Exception Outer Method");
					}
					
				}
			}
		});
                                            btnGenerateInvoice.setBounds(150, 240, 170, 23);
		panel_2.add(btnGenerateInvoice);
		
		JButton btnResetInformation = new JButton("Reset Info");
		btnResetInformation.setBounds(347, 240, 120, 23);
		panel_2.add(btnResetInformation);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmInvoiceGenerator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewInvoice = new JMenuItem("New Invoice");
		mnFile.add(mntmNewInvoice);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.frmInvoiceGenerator.dispose();
			}
		});
	}
}
