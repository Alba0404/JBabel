package fr.alba0404.jbabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

@SuppressWarnings("serial")
public class JLanguageMenu extends JMenu implements ActionListener {
	
	private JFrame parentFrame;
	
	public JLanguageMenu(JFrame parentFrame) {
		super("Language");
		this.parentFrame = parentFrame;
		
		ButtonGroup languageGroup = new ButtonGroup();
		File folder = new File(JBabel.getLanguageFolder());
		for(String fileName : folder.list()) {
			
			if(fileName.endsWith(".properties")) {								// Only properties file are interesting.
				
				fileName = fileName.substring(0, fileName.length()-11);			// Remove .properties suffix.
				JRadioButtonMenuItem item = new JRadioButtonMenuItem(fileName);	// Create a new item with the language name.
				item.addActionListener(this);									// Attach the listener to the item.
				languageGroup.add(item);										// Add the button to the group so only 1 selected.
				if(fileName.equals(JBabel.language)) item.setSelected(true);	// Set the button selected if it's the language one.
				this.add(item);
				
			}
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		JBabel.reload(source);
		// Reload parentFrame here
		//parentFrame.getContentPane().removeAll();
		parentFrame.repaint();
	}

}
