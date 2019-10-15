/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

/**
 *
 * @author ndemo
 */
import javax.swing.*;
import java.awt.*;

public class FrmSplash extends JWindow implements Runnable{
	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon("images/splash.png"));
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(490,300);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		show();
	}
}
