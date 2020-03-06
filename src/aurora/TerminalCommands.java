package aurora;

import java.awt.*;
import java.io.*;
import javax.swing.filechooser.*;

public class TerminalCommands extends Setup {
	
	private static final long serialVersionUID = 1L;
	static TerminalStrings stringclass = new TerminalStrings();
	
	public static String getInput() {
		str = textfield.getText();
		textfield.setText("");
		return str;
	}
	
	public static void getCommands() {
		str = getInput();
		if (str.equalsIgnoreCase("help")) {
			textarea.append(str + "\n" + stringclass.help + "\n");
		}
		
		else if (str.equalsIgnoreCase("diskinfo")) {
			textarea.append(str + "\n");
			File[] paths;
			FileSystemView fsv = FileSystemView.getFileSystemView();
			paths = File.listRoots();
			
			for (File path : paths)
				textarea.append("Drive Name: " + fsv.getSystemDisplayName(path) + "\n" +
								"Description: " + fsv.getSystemTypeDescription(path) + "\n\n");
		}
		
		else if(str.equals("1")) {
			fg = Color.green;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equals("2")) {
			fg = Color.yellow;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equals("3")) {
			fg = Color.pink;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equals("4")) {
			fg = Color.white;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equals("5")) {
			fg = Color.red;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equals("6")) {
			fg = Color.blue;
			startup.setForeground(fg);
			nextline.setForeground(fg);
			admin.setForeground(fg);
			textarea.setForeground(fg);
			textfield.setForeground(fg);
			textarea.append(str + "\n\n");
		}
		
		else if(str.equalsIgnoreCase("clear"))
			textarea.setText("");
		
		else if(str.equalsIgnoreCase("shutdown"))
			System.exit(0);
		
		else
			textarea.append(str + "\nUnknown command\n\n");
	}
}