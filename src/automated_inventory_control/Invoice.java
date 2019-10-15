package automated_inventory_control;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.print.Printer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class Invoice extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File file;
	private JEditorPane editorPane;
	private JScrollPane scrollPane;
        private JButton JPrint;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public Invoice() throws MalformedURLException, IOException {
		clsPublicMethods PrintingClass = new clsPublicMethods();
		setResizable(false);
		setTitle("Invoice");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(00, 0, 600, 400);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
	
		file = new File("temp.txt");
		editorPane.setPage(file.toURI().toURL());	
		
		 JPrint = new JButton("Print");
                                            JPrint.setBounds(250, 400, 100, 20);
                                            JPrint.addActionListener(this);
                                                 
		contentPane.add(JPrint);
	}
        public void actionPerformed(ActionEvent ae){
            Object source =ae.getSource();
            if (source==JPrint){
            Toolkit tkp =editorPane.getToolkit();
            PrintJob pjp =tkp.getPrintJob(this,null,null);
            Graphics g =pjp.getGraphics();
            editorPane.print(g);
            g.dispose();
            pjp.end();
            
            }else
				{
					
				}
        }
}
