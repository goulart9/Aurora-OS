package aurora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint {
	
	static JFrame f = new JFrame("Aurora Paint");;
	static JMenuBar jmb = new JMenuBar();
	static JMenu optionsJM = new JMenu("Options"), subJM = new JMenu("Colors");
	static JMenuItem clearJMI = new JMenuItem("Clear"),
						blueJMI = new JMenuItem("Blue"), redJMI = new JMenuItem("Red"), greenJMI = new JMenuItem("Green"),
						pinkJMI = new JMenuItem("Pink"), yellowJMI = new JMenuItem("Yellow"), blackJMI = new JMenuItem("Black");
	
	static Container content = f.getContentPane();
	static Painter draw = new Painter();
	static ImageIcon icon = new ImageIcon("palette.png");
	
	public static void window() {
		
		content.setLayout(new BorderLayout());
		content.add(draw, BorderLayout.CENTER);
		
		clearJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.clear();
			}
		});
		
		blueJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.blue();
			}
		});
		
		redJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.red();
			}
		});
		
		greenJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.green();
			}
		});
		
		pinkJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.pink();
			}
		});
		
		yellowJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.yellow();
			}
		});
		
		blackJMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.black();
			}
		});
		
		subJM.add(blueJMI);
		subJM.add(redJMI);
		subJM.add(greenJMI);
		subJM.add(pinkJMI);
		subJM.add(yellowJMI);
		subJM.add(blackJMI);
		
		optionsJM.add(subJM);
		optionsJM.add(clearJMI);
		
		jmb.add(optionsJM);
		
		f.setSize(800, 600);
		f.setIconImage(icon.getImage());
		f.setFocusable(true);
		f.setJMenuBar(jmb);
		f.requestFocusInWindow();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				draw.requestFocusInWindow();
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				draw.clear();
			}
		});
	}
}

class Painter extends JComponent {
	
	private static final long serialVersionUID = 1L;
	Image img;
	Graphics2D g2d;
	int currentX, currentY, oldX, oldY;
	
	public Painter() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
				if (g2d != null)
					g2d.drawLine(oldX, oldY, currentX, currentY);
				
				repaint();
				oldX = currentX;
				oldY = currentY;
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		if (img == null) {
			img = createImage(getSize().width, getSize().height);
			g2d = (Graphics2D)img.getGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		g.drawImage(img, 0, 0, null);
	}
	
	public void clear() {
		g2d.setPaint(Color.white);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		g2d.setPaint(Color.black);
		repaint();
	}
	
	public void blue() {
		g2d.setPaint(Color.blue);
		repaint();
	}
	
	public void red() {
		g2d.setPaint(Color.red);
		repaint();
	}
	
	public void green() {
		g2d.setPaint(Color.green);
		repaint();
	}
	
	public void pink() {
		g2d.setPaint(Color.pink);
		repaint();
	}
	
	public void yellow() {
		g2d.setPaint(Color.yellow);
		repaint();
	}
	
	public void black() {
		g2d.setPaint(Color.black);
		repaint();
	}
}