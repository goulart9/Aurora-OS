package aurora;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class LockScreen extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	JLabel title, passlabel;
	JPasswordField passfield;
	JPanel lockpanel;
	String password = "aurora";
	Color red = new Color(225, 70, 62);
	
	public LockScreen() {
		title = new JLabel("aurora");
		title.setFont(new Font("Default", Font.BOLD, 100));
		title.setBounds(d.width/2 - 160, d.height/2 - 120, 320, 150);
		title.setForeground(Color.WHITE);
		
		passlabel = new JLabel("password:");
		passlabel.setFont(new Font("Default", Font.BOLD, 30));
		passlabel.setBounds(d.width/2 - 80, d.height/2 + 30, 160, 35);
		passlabel.setForeground(Color.WHITE);
		
		passfield = new JPasswordField();
		passfield.addKeyListener(this);
		passfield.setBounds(d.width/2 - 80, d.height/2 + 80, 150, 30);
		
		lockpanel = new JPanel();
		lockpanel.setLayout(null);
		lockpanel.setBackground(red);
		lockpanel.add(title);
		lockpanel.add(passlabel);
		lockpanel.add(passfield);
		
		addKeyListener(this);
		setSize(d);
		setFocusable(true);
		requestFocusInWindow();
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
	    getContentPane().add(lockpanel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				passfield.requestFocusInWindow();
			}
		});
	}
	
	public void desktop() {
		dispose();
		Desktop osd = new Desktop();
		osd.setVisible(true);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_ENTER) {
			
			if (Arrays.equals(password.toCharArray(), passfield.getPassword()))
				desktop();
			
			else if (!passfield.getPassword().equals(password)) {
				JOptionPane.showMessageDialog(null, "Invalid password entered.\nPlease enter correct password.", "ERROR", JOptionPane.ERROR_MESSAGE);
				passfield.setText("");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Error! Please try again later.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}

public class Run {
	
	public static void main(String[] args) {
		LockScreen ls = new LockScreen();
		ls.setVisible(true);
	}
}