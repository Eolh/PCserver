package server;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class board extends JFrame{
	JButton btn1;
	JLabel label;
	JTextField text1;
	
	void board(){
		label  = new JLabel();
		label.setSize(1000,1000);
		btn1 =  new JButton();
		text1 = new JTextField();
		this.add(label);
		this.setVisible(true);
	}
	
}
