package fr.alba0404.jbabel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import fr.alba0404.jbabel.JBabel;

@SuppressWarnings("serial")
public class LanguageJMenu extends JMenu implements ActionListener {
	
	
	private JFrame parentFrame;
	
	public LanguageJMenu(JFrame parentFrame) {
		super("Language");
		this.parentFrame = parentFrame;
		
		ButtonGroup languageGroup = new ButtonGroup();
		File folder = new File(JBabel.getLanguageFolder());
		for(String fileName : folder.list()) {
			
			if(fileName.endsWith(".properties")) {								// Only properties file are interesting.
				
				fileName = fileName.substring(0, fileName.length()-11);			// Remove .properties suffix.
				System.out.println(fileName);									// Just for information to remove before production.
				JRadioButtonMenuItem item = new JRadioButtonMenuItem(fileName);	// Create a new item with the language name.
				item.addActionListener(this);									// Attach the listener to the item.
				languageGroup.add(item);										// Add the button to the group so only 1 selected
				//item.addActionListener(new LanguageJMenuListener());			// Attach the listener to the item.
				this.add(item);
				
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		JBabel.reload(source);
		parentFrame.revalidate();
		parentFrame.repaint();
	}
	
	

}
