package aurora;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Desktop extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	BufferedImage img;
	ImageIcon ii, ii1, ii2, ii3, ii4, ii5;
	JButton power, terminal, encrypter, notepad, paint;
	JToolBar bar;
	JPanel panel;
	JLabel lab;
	Color gray = new Color(89, 89, 89);
	
	public Desktop() {
		
		createToolBar();
		img = null;
		
		try {
			img = ImageIO.read(new File("aurora.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image wp = img.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
		ii  = new ImageIcon(wp);
		
		lab = new JLabel();
		lab.setBounds(0, 0, d.width, d.height);
		lab.setIcon(ii);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(lab);
		
		setSize(d);
		setFocusable(true);
		requestFocusInWindow();
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getContentPane().add(panel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createToolBar() {
		bar = new JToolBar();
		bar.setBackground(gray);
		
		//Power Button
		ii1 = new ImageIcon("power.png");
		power = new JButton(ii1);
		power.setOpaque(false);
		power.setContentAreaFilled(false);
		power.setBorderPainted(false);
		power.addActionListener((ActionEvent event)-> {
			int warning = JOptionPane.YES_NO_OPTION;
			int diagResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to power down?", "Warning!", warning);
			
			if(diagResult == JOptionPane.YES_OPTION)
				System.exit(0);
		});
		
		//Terminal
		ii2 = new ImageIcon("terminal.png");
		terminal = new JButton(ii2);
		terminal.setOpaque(false);
		terminal.setContentAreaFilled(false);
		terminal.setBorderPainted(false);
		terminal.addActionListener((ActionEvent event)-> {
			Terminal.window();
		});
		
		//Encrypter
		ii3 = new ImageIcon("lock.png");
		encrypter = new JButton(ii3);
		encrypter.setOpaque(false);
		encrypter.setContentAreaFilled(false);
		encrypter.setBorderPainted(false);
		encrypter.addActionListener((ActionEvent event)-> {
			Encrypter.window();
		});
		
		//Notepad
		ii4 = new ImageIcon("notepad.png");
		notepad = new JButton(ii4);
		notepad.setOpaque(false);
		notepad.setContentAreaFilled(false);
		notepad.setBorderPainted(false);
		notepad.addActionListener((ActionEvent event)-> {
			Notepad.window();
		});
		
		//Paint
		ii5 = new ImageIcon("palette.png");
		paint = new JButton(ii5);
		paint.setOpaque(false);
		paint.setContentAreaFilled(false);
		paint.setBorderPainted(false);
		paint.addActionListener((ActionEvent event)-> {
			Paint.window();
		});
		
		bar.add(power);
		bar.add(terminal);
		bar.add(encrypter);
		bar.add(notepad);
		bar.add(paint);
		add(bar, BorderLayout.SOUTH);
	}
}