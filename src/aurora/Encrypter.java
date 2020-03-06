package aurora;

import java.awt.event.*;
import javax.swing.*;

public class Encrypter {
	
	static JFrame f = new JFrame("Aurora Encrypter");
	static JPanel p = new JPanel();
	static JLabel ui = new JLabel(), result = new JLabel();
	static JTextField input = new JTextField();
	static JButton encryptButton = new JButton(), decryptButton = new JButton();
	static String msg, key = "VIGENERECIPHER";
	static ImageIcon icon = new ImageIcon("lock.png");
	
	public static String encrypt(String text, final String key) {
		
		String res = "";
		text = text.toUpperCase();
		
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if (c < 'A' || c > 'Z') continue;
			
			res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}
	
	public static String decrypt(String text, final String key) {
		
		String res = "";
		text = text.toUpperCase();
		
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if (c < 'A' || c > 'Z') continue;
			
			res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}
	
	public static void window() {
		
		input.setBounds(100, 50, 200, 30);

		encryptButton.setBounds(90, 150, 100, 50);
		encryptButton.setContentAreaFilled(false);
		encryptButton.setBorderPainted(false);
		encryptButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				msg = input.getText();
				String encryptedMsg = encrypt(msg, key);
				result.setText(encryptedMsg);
			}
		});

		decryptButton.setBounds(210, 150, 100, 50);
		decryptButton.setContentAreaFilled(false);
		decryptButton.setBorderPainted(false);
		decryptButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				msg = input.getText();
				String encryptedMsg = encrypt(msg, key);
				String decryptedMsg = decrypt(encryptedMsg, key);
				result.setText(decryptedMsg);
			}
		});

		result.setBounds(50, 250, 300, 125);
		result.setHorizontalAlignment(JLabel.CENTER);
		result.setVerticalAlignment(JLabel.CENTER);
		
		ui.setIcon(new ImageIcon("screen.png"));
		ui.setBounds(0, 0, 418, 447);
		
		p.add(input);
		p.add(encryptButton);
		p.add(decryptButton);
		p.add(result);
		p.add(ui);
		p.setLayout(null);
		
		f.add(p);
		f.setIconImage(icon.getImage());
		f.setSize(418, 447);
		f.setFocusable(true);
		f.requestFocusInWindow();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				input.requestFocusInWindow();
			}
		});
	}
}