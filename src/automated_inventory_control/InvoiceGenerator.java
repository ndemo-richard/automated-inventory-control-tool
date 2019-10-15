package automated_inventory_control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JDialog;


public class InvoiceGenerator   extends JDialog{
	MysqlConnect  db = new MysqlConnect ();
	//Function To Generate AlphaNumeric Random Strings that will be used as unique Invoice ID.
	public String InvoiceIDGenerator(){
		long decimalNumber=System.nanoTime();
		String strBaseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String InvoiceID = "";
		int mod = 0;
		while(decimalNumber!= 0){
            mod=(int) (decimalNumber % 36);
            InvoiceID=strBaseDigits.substring(mod,mod+1)+InvoiceID;
            decimalNumber=decimalNumber/36;
        }
		return InvoiceID;

	}
	
	public void writeToFile(String invID){
		String separator = System.getProperty("line.separator");
		//variable declarations for storing the data from the database.
		String Client=new String();
                String InvoiceDate=new String();
                                        String DueDate=new String();
                                        String PartialDepo=new String();
                                        String Poid=new String();
                                        String Discount=new String();
                                        String Item=new String();
                                        String Description=new String();
                                        String Unitcost=new String();
                                        String Quantity=new String();
                                        String Linetotal=new String();
                                        String Subtotal=new String();
                                        String Paidtodate=new String();
                                        String Balancedue=new String();
                                           
		
		String compName = new String();
		String compAddr = new String();
		String compPAN = new String();
		String compDD = new String();
		
		try{
			//Connection con = db.createConnection();
			//Connection con2 = db.createConnection();
                        Connection conn= MysqlConnect .ConnectDB();
                        Connection conn2= MysqlConnect .ConnectDB();
			String retrieveStatement = "select * from Invoices where InvoiceID=?";
			String retrieveCompanyInfo = "select * from company";
			PreparedStatement ps = conn.prepareStatement(retrieveStatement);
			Statement st = conn2.createStatement();
			ps.setString(1, invID);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = st.executeQuery(retrieveCompanyInfo);
			while(rs.next()){
				Client= rs.getString(2);
                                                                                     DueDate=rs.getString(3); 
                                                                                     InvoiceDate=rs.getString(4);
                                                                                     PartialDepo= rs.getString(5);
                                                                                      Poid= rs.getString(6);
                                                                                      Discount= rs.getString(7);
                                                                                      Item= rs.getString(8);
                                                                                      Description= rs.getString(9);
                                                                                      Unitcost= rs.getString(10);
                                                                                       Quantity= rs.getString(11);
                                                                                         Linetotal= rs.getString(12);
                                                                                          Subtotal= rs.getString(13);
                                                                                          Paidtodate=rs.getString(14);
                                                                                            Balancedue= rs.getString(15);
                                                                                                                                                                                            
                                                                                                                                                    
                                                                                                                                                    
                                                                                                    
				
			}
			while(rs2.next()){
				compName = rs2.getString(1);
				compAddr = rs2.getString(2);
				compPAN = rs2.getString(3);
				compDD = rs2.getString(4);
			}
                                                            String RecordToPrint = "";
                                                            java.util.Date CurrentDate = new java.util.Date();
		SimpleDateFormat SDFDateFormatter = new SimpleDateFormat("MMM. dd, yyyy",Locale.getDefault());
			File file = new File("temp.txt");
			Writer writer = new BufferedWriter(new FileWriter(file));
                                                        RecordToPrint += "                              " + SDFDateFormatter.format(CurrentDate).toString() + "\n\n\n";
			writer.write(separator+" Invoice ID:            "+invID);
			writer.write(separator+" Company Name:  "+compName);
                                                                writer.write(separator+"");
			writer.write(separator+" Customer:              "+Client);
			writer.write(separator+"---------------------------------------------------------------------------------------------------------------------------------");
			writer.write(separator+" Invoice Date.:        "+InvoiceDate);
                                                                writer.write(separator+"---------------------------------------------------------------------------------------------------------------------------------");
                                                                writer.write(separator+" Due Date.:             "+DueDate);
			writer.write(separator+" Item:                      "+Item);
                                                                 writer.write(separator+"Description :        "+Description);
			writer.write(separator+" PO. ID.:                  "+Poid+"                                Partial Depo:    "+PartialDepo                                      );
			writer.write(separator+"Quantity:               "+Quantity);
                                                                writer.write(separator+" Unit Cost:              "+Unitcost+"                           Line total:         "+Linetotal);
		
			writer.write(separator+"------------------------------------------------------------------------------------------------------------------------------------");
                                                                writer.write(separator+"");
			writer.write(separator+" SubTotal:                "+Subtotal+"                                                    Paid To Date: "+Paidtodate);
			writer.write(separator+"                                                                                                                                                    ");
                                                                writer.write(separator+" Balance Due          "+Balancedue);
	                                                                                                                     
			writer.write(separator+"-------------------------------------------------------------------------------------------------------------------------------------");
			
			
			
		
			
			
			writer.flush();
			conn.close();
			conn2.close();
			Invoice i = new Invoice();
			i.setVisible(true);
                                                                
			
		}catch(Exception ee){
			ee.printStackTrace();
		}
		
				
	}	
}
