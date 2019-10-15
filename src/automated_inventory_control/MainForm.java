
package automated_inventory_control;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.beans.*;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

public class MainForm extends JFrame implements WindowListener {
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    JPanel Panel1,Panel2,Panel3,Panel4,Panel5;
    JPanel content1,content2,content3,content4;
    JPanel header1;
    JDesktopPane Desk1 = new JDesktopPane();

    JLabel StatusLabel = new JLabel("", JLabel.CENTER);
    JLabel BusinessTitleLabel = new JLabel();
     JLabel piclabel;
    // variables for button
    JButton Customer_details,Suppliers_details,Sales_rep,Warehouse,Products,Categories,Stock_adjustment
            ,Invoices,Purchase_order,Expenses,Purchase_receipt;

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    String StrBusinesTitle;

    //--Start variable the contains forms
    FrmCustomer FormCustomer;
    FrmSupplier FormSupplier;
    FrmSalesRep FormSalesRep;
    FrmWarehouse FormWarehouse;
    FrmProduct FormProduct;
   FrmInvoice FormInvoice;
    FrmCategory FormCategory;
    FrmExpenses FormExpenses;
    FrmPurchaseOrder FormPurchaseOrder;
    FrmPurchaseReceivable FormPurchaseRequest;
    FrmSplash FormSplash = new FrmSplash();
    //--End variable that contains forms

    Thread ThFormSplash = new Thread(FormSplash);
    //End the form container variable
    // * ******************** End variable declaration start *******************
    
     //* ********************** MainForm constructor start *********************
    public MainForm() {
        //Set the main form title
        super("Automated  Inventory System ");
        //End set the main form title
     //  loadSplashScreen();
        //We will dispose now the FormSplash because it is now useless
        FormSplash.dispose();

        //StatusLabel.setBorder(BorderFactory.createTitledBorder(""));
        StatusLabel.setFont(new Font("Dialog", Font.PLAIN, 12));

        StrBusinesTitle = "";

        BusinessTitleLabel.setText(StrBusinesTitle);
        BusinessTitleLabel.setHorizontalAlignment(JLabel.LEFT);
        BusinessTitleLabel.setForeground(new Color(166, 0, 0));

        //Set the main form properties
        addWindowListener(this);

        Desk1.setBackground(Color.gray);
        Desk1.setBorder(BorderFactory.createEmptyBorder());
        //Most fastest drag mode
        Desk1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        Panel1 = new JPanel(new BorderLayout());
        Panel1.setBackground(Color.gray);
        Panel1.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel1.add(new JScrollPane(Desk1), BorderLayout.CENTER);
        
        Panel2 = new JPanel(new BorderLayout());
        Panel2.setBackground(Color.white);
             Panel2.setLayout(null);
        Panel2.setBounds(180,150,1000,500);
        Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Desk1.add(Panel2);
        
        Panel3 = new JPanel();
        Panel3.setBackground(Color.CYAN);
          Panel3.setLayout(null);
        Panel3.setBounds(05,140,170,500);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Desk1.add(Panel3);
        
        Panel4 = new JPanel();
        Panel4.setBackground(Color.cyan);
        Panel4.setLayout(null);
        Panel4.setBounds(1185,140,170,500);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Desk1.add(Panel4);
        
        Panel5 = new JPanel();
        Panel5.setBackground(Color.LIGHT_GRAY);
        Panel5.setLayout(null);
        Panel5.setBounds(05,10,1350,138);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Desk1.add(Panel5);
        
        content1 = new JPanel();
        content1.setBackground(Color.gray);
          content1.setLayout(null);
        content1.setBounds(02,02,166,190);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel3.add(content1);
        
        content2 = new JPanel();
        content2.setBackground(Color.gray);
            content2.setLayout(null);
        content2.setBounds(02,250,166,170);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel3.add(content2);
        
         content3 = new JPanel();
        content3.setBackground(Color.gray);
            content3.setLayout(null);
        content3.setBounds(02,02,166,185);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel4.add(content3);
        
         content4 = new JPanel();
        content4.setBackground(Color.white);
            content4.setLayout(null);
        content4.setBounds(02,200,166,200);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel4.add(content4);
        
        header1= new JPanel();
        header1.setBackground(Color.cyan);
        header1.setLayout(null);
        header1.setBounds(02,02,1346,30);
        //Panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        Panel5.add(header1);
        //load image
        try{
         BufferedImage mypic=ImageIO.read(this.getClass().getResource("Inventoryheader.png"));
         JLabel piclabel=new JLabel(new ImageIcon(mypic));
         piclabel.setLayout(null);
         piclabel.setBounds(370,35,500,40);
        Panel5.add(piclabel);
         
         }catch (IOException ex){
         }
        try{
         BufferedImage mypic1=ImageIO.read(this.getClass().getResource("graphimage.png"));
         JLabel piclabel2=new JLabel(new ImageIcon(mypic1));
         piclabel2.setLayout(null);
         piclabel2.setBounds(200,35,600,400);
        Panel2.add(piclabel2);
         
         }catch (IOException ex){
         }
      try{
         BufferedImage mypic2=ImageIO.read(this.getClass().getResource("stockcontrol.jpg"));
         JLabel piclabel3=new JLabel(new ImageIcon(mypic2));
         piclabel3.setLayout(null);
         piclabel3.setBounds(02,02,150,200);
        content4.add(piclabel3);
         
         }catch (IOException ex){
         }
        
        
        
        
        Customer_details = new JButton("CUSTOMER DETAILS");
        Customer_details.setBackground(Color.CYAN);
         Customer_details.setActionCommand("cd");
          Customer_details.addActionListener(JButtonActionListener);
       Customer_details.setBounds(02,15,163,35);
       content1.add(Customer_details);
       
       Suppliers_details = new JButton("SUPPLIERS DETAILS");
        Suppliers_details.setBackground(Color.CYAN);
       Suppliers_details.setBounds(02,55,163,35);
        Suppliers_details.setActionCommand("sd");
         Suppliers_details.addActionListener(JButtonActionListener);
       content1.add(Suppliers_details);
       
        Sales_rep = new JButton("SALES REP");
        Sales_rep.setBackground(Color.CYAN);
       Sales_rep.setBounds(02,95,163,35);
 Sales_rep.setActionCommand("sr");
          Sales_rep.addActionListener(JButtonActionListener);
       content1.add(Sales_rep);
       
        Warehouse= new JButton("WAREHOUSE");
        Warehouse.setBackground(Color.CYAN);
       Warehouse.setBounds(02,135,163,35);
        Warehouse.setActionCommand("whs");
         Warehouse.addActionListener(JButtonActionListener);
       content1.add(Warehouse);
       ///panel2
        Products = new JButton("PRODUCT DETAILS");
        Products.setBackground(Color.CYAN);
       Products.setBounds(02,15,163,35);
        Products.setActionCommand("pd");
         Products.addActionListener(JButtonActionListener);
       content2.add(Products);
       
       Categories= new JButton("CATEGORIES");
        Categories.setBackground(Color.CYAN);
       Categories.setBounds(02,55,163,35);
       Categories.setActionCommand("cf");
          Categories.addActionListener(JButtonActionListener);
       content2.add(Categories);
       
        Stock_adjustment = new JButton("STOCK ADJUSTMENT");
        Stock_adjustment.setBackground(Color.CYAN);
       Stock_adjustment.setBounds(02,95,163,35);
       Stock_adjustment.setActionCommand("sa");
          Stock_adjustment.addActionListener(JButtonActionListener);
       content2.add(Stock_adjustment);
       
       
       //panel 4
       Invoices = new JButton("INVOICES");
        Invoices.setBackground(Color.CYAN);
       Invoices.setBounds(02,15,163,35);
       Invoices.setActionCommand("is");
          Invoices.addActionListener(JButtonActionListener);
       content3.add(Invoices);
       
       Purchase_order= new JButton("PURCHASE ORDER");
       Purchase_order.setBackground(Color.CYAN);
       Purchase_order.setBounds(02,55,163,35);
       Purchase_order.setActionCommand("po");
          Purchase_order.addActionListener(JButtonActionListener);
       content3.add(Purchase_order);
       
        Purchase_receipt = new JButton("PURCHASE RECIEVABLE");
        Purchase_receipt.setBackground(Color.CYAN);
       Purchase_receipt.setBounds(02,95,163,35);
       Purchase_receipt.setActionCommand("pr");
          Purchase_receipt.addActionListener(JButtonActionListener);
       content3.add(Purchase_receipt);
       
        Expenses= new JButton("EXPENSES");
        Expenses.setBackground(Color.CYAN);
       Expenses.setBounds(02,135,163,35);
       Expenses.setActionCommand("es");
          Expenses.addActionListener(JButtonActionListener);
       //content3.add(Expenses);
       

     
        getContentPane().add(Panel1, BorderLayout.CENTER);
        getContentPane().add(StatusLabel, BorderLayout.PAGE_END);

        setJMenuBar(CreateJMenuBar());
        setExtendedState(this.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //setIconImage(new ImageIcon("images/appicon.png").getImage());
        setLocation(0, 0);
        setSize(screen);
        setResizable(true);

        setVisible(true);
        show();
            conn=MysqlConnect.ConnectDB();
            
            
        //End set the main form properties
    }

    /**
     * ******************** End MainForm constructor start *******************
     */
    /**
     * ********************* Custom class creation start *********************
     * @return 
     */
    
    //Create menu bar
    protected JMenuBar CreateJMenuBar() {
        JMenuBar NewJMenuBar = new JMenuBar();

        //Setup file menu
        JMenu MnuFile = new JMenu("File");
        MnuFile.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuFile.setMnemonic('F');
        MnuFile.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuFile);
        //End setup file menu

        //Set file sub menu
        JMenuItem ItmLockApp = new JMenuItem("lock Application");
        ItmLockApp.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmLockApp.setMnemonic('L');
        ItmLockApp.setIcon(new ImageIcon("images/lockapplication.png"));
        ItmLockApp.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        ItmLockApp.setActionCommand("lockapp");
        ItmLockApp.addActionListener(JMenuActionListener);
        ItmLockApp.setBackground(new Color(255, 255, 255));

        JMenuItem ItmLoggOff = new JMenuItem("Logg Off");
        ItmLoggOff.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmLoggOff.setMnemonic('O');
        ItmLoggOff.setIcon(new ImageIcon("images/logoff.png"));
        ItmLoggOff.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_O, ActionEvent.CTRL_MASK
                )
        );
        ItmLoggOff.setActionCommand("loggoff");
        ItmLoggOff.addActionListener(JMenuActionListener);
        ItmLoggOff.setBackground(new Color(255, 255, 255));

        JMenuItem ItmExit = new JMenuItem("Exit");
        ItmExit.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmExit.setMnemonic('E');
        ItmExit.setIcon(new ImageIcon("images/exit.png"));
        ItmExit.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, ActionEvent.CTRL_MASK
                )
        );
        ItmExit.setActionCommand("exit");
        ItmExit.addActionListener(JMenuActionListener);
        ItmExit.setBackground(new Color(255, 255, 255));

        MnuFile.add(ItmLockApp);
        MnuFile.addSeparator();
        MnuFile.add(ItmLoggOff);
        MnuFile.add(ItmExit);
        //End set file sub menu

        //Setup records menu
        JMenu MnuRec = new JMenu("Records");
        MnuRec.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuRec.setMnemonic('R');
        MnuRec.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuRec);
        //End records menu

        //Set records sub menu
        //-- For Customer
        JMenuItem ItmCustomer = new JMenuItem("Customers");
        ItmCustomer.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmCustomer.setMnemonic('C');
        ItmCustomer.setIcon(new ImageIcon("images/customer.png"));
        ItmCustomer.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_C, ActionEvent.CTRL_MASK
                )
        );
        ItmCustomer.setActionCommand("cus");
        ItmCustomer.addActionListener(JMenuActionListener);
        ItmCustomer.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmCustomer);

        //-- For Supplier
        JMenuItem ItmSupplier = new JMenuItem("Suppliers");
        ItmSupplier.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmSupplier.setMnemonic('S');
        ItmSupplier.setIcon(new ImageIcon("images/ supplier.png"));
        ItmSupplier.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_S, ActionEvent.CTRL_MASK
                )
        );
        ItmSupplier.setActionCommand("sup");
        ItmSupplier.addActionListener(JMenuActionListener);
        ItmSupplier.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmSupplier);

        //-- For SalesRep
        JMenuItem ItmSalesRep = new JMenuItem("SalesRep");
        ItmSalesRep.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmSalesRep.setMnemonic('R');
        ItmSalesRep.setIcon(new ImageIcon("images/SalesRep.png"));
        ItmSalesRep.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_B, ActionEvent.CTRL_MASK
                )
        );
        ItmSalesRep.setActionCommand("salesrep");
        ItmSalesRep.addActionListener(JMenuActionListener);
        ItmSalesRep.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmSalesRep);

        //-- For Warehouse
        JMenuItem ItmWarehouse = new JMenuItem("Warehouse");
        ItmWarehouse.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmWarehouse.setMnemonic('W');
        ItmWarehouse.setIcon(new ImageIcon("images/Warehouse.png"));
        ItmWarehouse.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_B, ActionEvent.CTRL_MASK
                )
        );
        ItmWarehouse.setActionCommand("wareh");
        ItmWarehouse.addActionListener(JMenuActionListener);
        ItmWarehouse.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmWarehouse);
        MnuRec.addSeparator();

        //-- For Products
        JMenuItem ItmProduct = new JMenuItem("Products");
        ItmProduct.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmProduct.setMnemonic('P');
        ItmProduct.setIcon(new ImageIcon("images/product.png"));
        ItmProduct.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_P, ActionEvent.CTRL_MASK
                )
        );
        ItmProduct.setActionCommand("prod");
        ItmProduct.addActionListener(JMenuActionListener);
        ItmProduct.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmProduct);

        //-- For Categories
        JMenuItem ItmCategory = new JMenuItem("Categories");
        ItmCategory.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmCategory.setMnemonic('T');
        ItmCategory.setIcon(new ImageIcon("images/categories.png"));
        ItmCategory.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_T, ActionEvent.CTRL_MASK
                )
        );
        ItmCategory.setActionCommand("cat");
        ItmCategory.addActionListener(JMenuActionListener);
        ItmCategory.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmCategory);

        //-- For Stock Adjustment
        JMenuItem ItmStockAdj = new JMenuItem("Stock Adjustment");
        ItmStockAdj.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmStockAdj.setMnemonic('A');
        ItmStockAdj.setIcon(new ImageIcon("images/adjustment.png"));
        ItmStockAdj.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_A, ActionEvent.CTRL_MASK
                )
        );
        ItmStockAdj.setActionCommand("stockadj");
        ItmStockAdj.addActionListener(JMenuActionListener);
        ItmStockAdj.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmStockAdj);
        MnuRec.addSeparator();

        //-- For Invoices
        JMenuItem ItmInv = new JMenuItem("Invoices");
        ItmInv.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmInv.setMnemonic('I');
        ItmInv.setIcon(new ImageIcon("images/invoice.png"));
        ItmInv.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_I, ActionEvent.CTRL_MASK
                )
        );
        ItmInv.setActionCommand("invoice");
        ItmInv.addActionListener(JMenuActionListener);
        ItmInv.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmInv);

        //-- For Purchase Orders
        JMenuItem ItmPO = new JMenuItem("Purchase Orders");
        ItmPO.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmPO.setMnemonic('O');
        ItmPO.setIcon(new ImageIcon("images/purchaseorder.png"));
        ItmPO.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_O, ActionEvent.CTRL_MASK
                )
        );
        ItmPO.setActionCommand("PO");
        ItmPO.addActionListener(JMenuActionListener);
        ItmPO.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmPO);

        //-- For Purchase Receipt
        JMenuItem ItmRecieve = new JMenuItem("Purchase Receipt");
        ItmRecieve.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmRecieve.setMnemonic('R');
        ItmRecieve.setIcon(new ImageIcon("images/receive.png"));
        ItmRecieve.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_R, ActionEvent.CTRL_MASK
                )
        );
        ItmRecieve.setActionCommand("preceipt");
        ItmRecieve.addActionListener(JMenuActionListener);
        ItmRecieve.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmRecieve);

        //-- For Expenses
        JMenuItem ItmExpense = new JMenuItem("Expenses");
        ItmExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmExpense.setMnemonic('E');
        ItmExpense.setIcon(new ImageIcon("images/ expense.png"));
        ItmExpense.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, ActionEvent.CTRL_MASK
                )
        );
        ItmExpense.setActionCommand("expense");
        ItmExpense.addActionListener(JMenuActionListener);
        ItmExpense.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmExpense);

        //End records sub menu
        //Setup proccess menu
        JMenu MnuProccess = new JMenu("Proccess");
        MnuProccess.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuProccess.setMnemonic('P');
        MnuProccess.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuProccess);
        //End records menu

        //Set proccess sub menu
        //-- For New Invoice
        JMenuItem ItmNewInv = new JMenuItem("New Invoice");
        ItmNewInv.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmNewInv.setMnemonic('I');
        ItmNewInv.setIcon(new ImageIcon("images/newinvoice.png"));
        ItmNewInv.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F1, ActionEvent.CTRL_MASK
                )
        );
        ItmNewInv.setActionCommand("newinv");
        ItmNewInv.addActionListener(JMenuActionListener);
        ItmNewInv.setBackground(new Color(255, 255, 255));

        MnuProccess.add(ItmNewInv);

        //-- For New PO
        JMenuItem ItmNewPO = new JMenuItem("New Purchase Order");
        ItmNewPO.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmNewPO.setMnemonic('P');
        ItmNewPO.setIcon(new ImageIcon("images/newpurchaseorder.png"));
        ItmNewPO.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F2, ActionEvent.CTRL_MASK
                )
        );
        ItmNewPO.setActionCommand("newPO");
        ItmNewPO.addActionListener(JMenuActionListener);
        ItmNewPO.setBackground(new Color(255, 255, 255));

        MnuProccess.add(ItmNewPO);

        //-- For New Purchase Receipt
        JMenuItem ItmNewRecieve = new JMenuItem("New Purchase Receipt");
        ItmNewRecieve.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmNewRecieve.setMnemonic('E');
        ItmNewRecieve.setIcon(new ImageIcon("images/newrecieve.png"));
        ItmNewRecieve.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F4, ActionEvent.CTRL_MASK
                )
        );
        ItmNewRecieve.setActionCommand("newpreceipt");
        ItmNewRecieve.addActionListener(JMenuActionListener);
        ItmNewRecieve.setBackground(new Color(255, 255, 255));

        MnuProccess.add(ItmNewRecieve);

        //-- For New Expenses
        JMenuItem ItmNewExpense = new JMenuItem("New Expense");
        ItmNewExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmNewExpense.setMnemonic('E');
        ItmNewExpense.setIcon(new ImageIcon("images/newexpense.png"));
        ItmNewExpense.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F3, ActionEvent.CTRL_MASK
                )
        );
        ItmNewExpense.setActionCommand("newexpense");
        ItmNewExpense.addActionListener(JMenuActionListener);
        ItmNewExpense.setBackground(new Color(255, 255, 255));

        MnuProccess.add(ItmNewExpense);

        //End proccess sub menu
        //Setup reports menu
        JMenu MnuRpt = new JMenu("Reports");
        MnuRpt.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuRpt.setMnemonic('t');
        MnuRpt.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuRpt);
        //End records menu

        //Setup system menu
        JMenu MnuSys = new JMenu("System");
        MnuSys.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuSys.setMnemonic('S');
        MnuSys.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuSys);
        //End records menu

        //Setup window menu
        JMenu MnuWin = new JMenu("Window");
        MnuWin.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuWin.setMnemonic('W');
        MnuWin.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuWin);
        //End records menu

        //Setup help menu
        JMenu MnuHelp = new JMenu("Help");
        MnuHelp.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuHelp.setMnemonic('H');
        MnuHelp.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuHelp);
        //End records menu

        NewJMenuBar.setBackground(new Color(255, 255, 255));
        return NewJMenuBar;
    }
    //End create menu bar

 
    /**
     * ******************* End custom class creation start *******************
     */
    /**
     * ******************** Method for loading form start ********************
     */
    //Create customer form
    protected void loadCustomerForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Customer Records");
        if (AlreadyLoaded == false) {
            FormCustomer = new FrmCustomer(conn, this);
            Desk1.add(FormCustomer);

            //Load the FormCustomer
            FormCustomer.setVisible(true);
            FormCustomer.show();
            try {
                FormCustomer.setIcon(false);
                FormCustomer.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormCustomer.setIcon(false);
                FormCustomer.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }
    //End create customer from
//Create PR form
    protected void loadPurchaseRequestForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Purchase Request");
        if (AlreadyLoaded == false) {
            FormPurchaseRequest = new FrmPurchaseReceivable(conn, this);
            Desk1.add(FormPurchaseRequest);

            //Load the FormCustomer
            FormPurchaseRequest.setVisible(true);
            FormPurchaseRequest.show();
            try {
                FormPurchaseRequest.setIcon(false);
                FormPurchaseRequest.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormPurchaseRequest.setIcon(false);
                FormPurchaseRequest.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }
    //End create PR from
    //Create customer form
    protected void loadExpensesForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Expenses Records");
        if (AlreadyLoaded == false) {
            FormExpenses = new FrmExpenses(conn, this);
            Desk1.add(FormExpenses);

            //Load the FormExpenses
            FormExpenses.setVisible(true);
            FormExpenses.show();
            try {
                FormExpenses.setIcon(false);
                FormExpenses.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormExpenses
        } else {
            try {
                FormExpenses.setIcon(false);
                FormExpenses.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }
    //End create Expenses from
    //Create supplier form
    protected void loadSupplierForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Supplier Records");
        if (AlreadyLoaded == false) {
            FormSupplier = new FrmSupplier(conn, this);
            Desk1.add(FormSupplier);

            //Load the FormSupplier
            FormSupplier.setVisible(true);
            FormSupplier.show();
            try {
                FormSupplier.setIcon(false);
                FormSupplier.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormSupplier
        } else {
            try {
                FormSupplier.setIcon(false);
                FormSupplier.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create supplier form

    //Create SalesRep form
    protected void loadSalesRepForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("SalesRep Records");
        if (AlreadyLoaded == false) {
            FormSalesRep = new FrmSalesRep(conn, this);
            Desk1.add(FormSalesRep);
            //Load the FormSalesRep
            FormSalesRep.setVisible(true);
            FormSalesRep.show();
            try {
                FormSalesRep.setIcon(false);
                FormSalesRep.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormSalesRep
        } else {
            try {
                FormSalesRep.setIcon(false);
                FormSalesRep.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create SalesRep form

    //Create Warehouse form
    protected void loadWarehouseForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Warehouse Records");
        if (AlreadyLoaded == false) {
            FormWarehouse = new FrmWarehouse(conn, this);
            Desk1.add(FormWarehouse);
            //Load the FormWarehouse
            FormWarehouse.setVisible(true);
            FormWarehouse.show();
            try {
                FormWarehouse.setIcon(false);
                FormWarehouse.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormWarehouse
        } else {
            try {
                FormWarehouse.setIcon(false);
                FormWarehouse.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create Warehouse form

    //Create Product form
    protected void loadProductForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Product List");
        if (AlreadyLoaded == false) {
            FormProduct = new FrmProduct(conn, this);
            Desk1.add(FormProduct);
            //Load the FormProduct
            FormProduct.setVisible(true);
            FormProduct.show();
            try {
                FormProduct.setIcon(false);
                FormProduct.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormWarehouse
        } else {
            try {
                FormProduct.setIcon(false);
                FormProduct.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create Product form

    //End create Invoice form
    protected void loadInvoiceForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Invoice");
        if (AlreadyLoaded == false) {
            FormInvoice = new FrmInvoice(conn,this);
            Desk1.add(FormInvoice);
            //Load the FormWarehouse
            FormInvoice.setVisible(true);
            FormInvoice.show();
            try {
                FormInvoice.setIcon(false);
                FormInvoice.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormWarehouse
        } else {
            try {
                FormInvoice.setIcon(false);
                FormInvoice.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create Invoice form

    //End create Category form
    protected void loadCategoryForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Category");
        if (AlreadyLoaded == false) {
            FormCategory = new FrmCategory(conn,this);
            Desk1.add(FormCategory);
            FormCategory.setVisible(true);
            FormCategory.show();
            try {
                FormCategory.setIcon(false);
                FormCategory.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormWarehouse
        } else {
            try {
                FormCategory.setIcon(false);
                FormCategory.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create Category form

    //start create Purchase form
    protected void loadPurchaseOrderForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Purchaseorder");
        if (AlreadyLoaded == false) {
            FormPurchaseOrder= new FrmPurchaseOrder(conn,this);
            Desk1.add(FormPurchaseOrder);
            FormPurchaseOrder.setVisible(true);
            FormPurchaseOrder.show();
            try {
                FormPurchaseOrder.setIcon(false);
                FormPurchaseOrder.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormWarehouse
        } else {
            try {
                FormPurchaseOrder.setIcon(false);
                FormPurchaseOrder.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
        //End verify if the form is already loaded

    }
    //End create Category form
    protected void loadSplashScreen() {
        //Start the thread
        ThFormSplash.start();
        while (!FormSplash.isShowing()) {
            try {
                //Display the FormSplash for 10 seconds
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * ****************** End method for loading form start ******************
     */
    /**
     * ************************ Event handling start *************************
     */
    //Create action listener for JMenu
    ActionListener JMenuActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String srcObject = e.getActionCommand();
            if (srcObject == "cus") {
                try {
                    loadCustomerForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "sup") {
                try {
                    loadSupplierForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "salesrep") {
                try {
                    loadSalesRepForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "wareh") {
                try {
                    loadWarehouseForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "loggoff") {

            } else if (srcObject == "exit") {
                UnloadWindow();
            }
        }
    };
    //End create action listener for JMenu

    ActionListener JButtonActionListener=new ActionListener(){
    public void actionPerformed(ActionEvent e){
    String  srcObject=e.getActionCommand();
    if(srcObject =="cd"){
        try{
        loadCustomerForm();
        }catch(SQLException sqle){
        }
        } else if (srcObject == "toolProd") {
                try {
                    loadProductForm();
                } catch (SQLException sqle) {
                }
    } else if (srcObject == "cf") {
                try {
                    loadCategoryForm();
                } catch (SQLException sqle) {
                }
    } else if (srcObject == "sd") {
                try {
                    loadSupplierForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "sr") {
                try {
                    loadSalesRepForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "whs") {
                try {
                    loadWarehouseForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "pd") {
                try {
                    loadProductForm();
                } catch (SQLException sqle) {
                }
            }else if (srcObject == "po") {
                try {
                    loadPurchaseOrderForm();
                } catch (SQLException sqle) {
                }
    }else if (srcObject == "pr") {
                try {
                    loadPurchaseRequestForm();
                } catch (SQLException sqle) {
                }
    }else if (srcObject == "es") {
                try {
                    loadExpensesForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "is") {
                try {
                    loadInvoiceForm();
                } catch (SQLException sqle) {
                }}}
    };
    //Create action Listerner for JToolBar Button
    ActionListener JToolBarActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String srcObject = e.getActionCommand();
            if (srcObject == "toolCus") {
                try {
                    loadCustomerForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "toolSup") {
                try {
                    loadSupplierForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "toolSalesrep") {
                try {
                    loadSalesRepForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "toolWareh") {
                try {
                    loadWarehouseForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "toolProd") {
                try {
                    loadProductForm();
                } catch (SQLException sqle) {
                }
            } else if (srcObject == "toolInv") {
                try {
                    loadInvoiceForm();
                } catch (SQLException sqle) {
                }
            }
        }
    };
    //End create action Listerner for JToolBar Button

    //Interface event from WindowListener start
    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        UnloadWindow();
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
    //End interface event from WindowListener start

    /**
     * ********************** End event handling start ***********************
     */
    /**
     * ************************ Custom method start **************************
     */
    protected void UnloadWindow() {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", " AIS", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            System.exit(0);
        }
    }

    protected boolean isLoaded(String FormTitle) {

        JInternalFrame Form[] = Desk1.getAllFrames();
        for (int i = 0; i < Form.length; i++) {
            if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
                Form[i].show();
                try {
                    Form[i].setIcon(false);
                    Form[i].setSelected(true);
                } catch (PropertyVetoException e) {
                }
                return true;
            }
        }
        return false;

    }

    protected void changeTheme(int sSelectedTheme) {
        if (sSelectedTheme == 1) {
            try {
                javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                JFrame.setDefaultLookAndFeelDecorated(true);
            } catch (Exception e) {
            }
        } else if (sSelectedTheme == 2) {
            //If Failed to load the liquid them then load my own XPStyleTheme
            MetalTheme myXPStyleTheme = new XPStyleTheme();
            MetalLookAndFeel.setCurrentTheme(myXPStyleTheme);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception err) {
                System.out.println("Error loading myXPStyleTheme");
                System.out.println(err);
            }
        }
    }

    /**
     * *********************** End custom method end *************************
     */

    /**
     * ************************** Main method start **************************
     */
    public static void nn() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error Loading Theme:" + e.toString());
            //If Failed to load the liquid them then load my own XPStyleTheme
            MetalTheme myXPStyleTheme = new XPStyleTheme();
            MetalLookAndFeel.setCurrentTheme(myXPStyleTheme);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception err) {
                System.out.println("Error loading myXPStyleTheme:" + err.toString());
            }
        }
        new MainForm();
    }

    /**
     * ************************ End main method start ************************
     */
}
