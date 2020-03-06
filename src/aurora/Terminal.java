package aurora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Setup extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	protected static Dimension d = new Dimension(1500, 770);
	protected static Font dos = new Font("Perfect DOS VGA 437", Font.BOLD, 30);
	protected static JTextField textfield;
	protected static JTextArea textarea;
	protected static JScrollPane scroll;
	protected static JLabel startup, nextline, admin;
	protected static JPanel terminal;
	protected static Color bg = Color.black, fg = Color.green;
	protected static String str, cmd, title = "Aurora Terminal";
	protected static ImageIcon icon = new ImageIcon("terminal.png");
	
	public Setup() {
		startup = new JLabel("Aurora OS [Version 5.0.12.018]");
		nextline = new JLabel("(C) 2017. All rights reserved. Type 'help' to get started.");
		admin = new JLabel("C:\\Aurora\\Admin>");
		textfield = new JTextField();
		textarea = new JTextArea(1, 50);
		scroll = new JScrollPane(textarea);
		terminal = new JPanel();
		
		startup.setFont(dos);
		startup.setBounds(10, 10, d.width, 30);
		startup.setForeground(fg);
		
		nextline.setFont(dos);
		nextline.setBounds(10, 45, d.width, 35);
		nextline.setForeground(fg);
		
		admin.setFont(dos);
		admin.setBounds(10, d.height - 100, 310, 50);
		admin.setForeground(fg);
		
		textarea.setFont(dos);
		textarea.setBackground(bg);
		textarea.setForeground(fg);
		textarea.setEditable(false);
		
		scroll.setSize(new Dimension(1500, 570));
		scroll.setLocation(10, 90);
		scroll.setBorder(null);
		
		textfield.setBounds(320, d.height - 100, 800, 50);
		textfield.setFont(dos);
		textfield.setBorder(null);
		textfield.setCaretColor(fg);
		textfield.setBackground(bg);
		textfield.setForeground(fg);
		textfield.addKeyListener(this);
		
		terminal.setLayout(null);
		terminal.setBackground(bg);
		terminal.add(startup);
		terminal.add(nextline);
		terminal.add(admin);
		terminal.add(scroll);
		terminal.add(textfield);
		
		setTitle(title);
		setIconImage(icon.getImage());
		getContentPane().add(terminal);
		setSize(d);
		setLocationRelativeTo(null);
		setResizable(false);
		addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				textfield.requestFocusInWindow();
			}
		});
	}
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			e.consume();
			TerminalCommands.getCommands();
		}
	}
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}

public class Terminal {
	public static void window() {
		Setup set = new Setup();
		set.setVisible(true);
	}
}