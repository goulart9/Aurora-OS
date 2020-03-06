package aurora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad{
	
	static JFrame f = new Text();
	static JMenuBar jmb = new JMenuBar();
	static JMenu optionsJM = new JMenu("Options"), subJM = new JMenu("Font Size");
	static JMenuItem fdefault = new JMenuItem("Default"), f25 = new JMenuItem("25pt"), f50 = new JMenuItem("50pt"), f75 = new JMenuItem("75pt"), f100 = new JMenuItem("100pt");
	static ImageIcon icon = new ImageIcon("notepad.png");
	
	public static void window() {
		
		fdefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Text) f).fdefault();
			}
		});
		
		f25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Text) f).f25();
			}
		});
		
		f50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Text) f).f50();
			}
		});
		
		f75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Text) f).f75();
			}
		});
		
		f100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Text) f).f100();
			}
		});
		
		subJM.add(fdefault);
		subJM.add(f25);
		subJM.add(f50);
		subJM.add(f75);
		subJM.add(f100);
		
		optionsJM.add(subJM);
		
		jmb.add(optionsJM);
		
		f.setTitle("Aurora Notepad");
		f.setIconImage(icon.getImage());
		f.setSize(800, 600);
		f.setFocusable(true);
		f.setJMenuBar(jmb);
		f.requestFocusInWindow();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				((Text) f).textArea.requestFocusInWindow();
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				((Text) f).textArea.setText("");
			}
		});
	}
}

class Text extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final JTextArea textArea;
	final JScrollPane scroll;
	Font font = new Font("Arial", Font.PLAIN, 10);
	
	Text() {
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scroll = new JScrollPane(textArea);
		scroll.setSize(800,600);
		scroll.setLocation(0, 0);
		scroll.setBorder(null);
		getContentPane().add(scroll);
	}
	
	void fdefault() {
		font = new Font("Arial", Font.PLAIN, 10);
		textArea.setFont(font);
	}
	
	void f25() {
		font = new Font("Arial", Font.PLAIN, 25);
		textArea.setFont(font);
	}
	
	void f50() {
		font = new Font("Arial", Font.PLAIN, 50);
		textArea.setFont(font);
	}
	
	void f75() {
		font = new Font("Arial", Font.PLAIN, 75);
		textArea.setFont(font);
	}
	
	void f100() {
		font = new Font("Arial", Font.PLAIN, 100);
		textArea.setFont(font);
	}
}