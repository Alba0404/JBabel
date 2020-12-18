package fr.alba0404.jbabel.gui;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

@SuppressWarnings("serial")
public class LanguageJMenu extends JMenu {
	
	
	public LanguageJMenu() {
		super("Language");
		
		File folder = new File("D:\\Billets de train");
		
		for(String fileName : folder.list()) {
			
			if(fileName.endsWith(".properties")) {								// Only properties file are interesting.
				
				fileName = fileName.substring(0, fileName.length()-11);			// Remove .properties suffix.
				System.out.println(fileName);									// Just for information to remove before production.
				JRadioButtonMenuItem item = new JRadioButtonMenuItem(fileName);	// Create a new item with the language name.
				item.addActionListener(new LanguageJMenuListener());			// Attach the listener to the item.
				this.add(item);
				
			}
		}
		
		
		// le listener est en charge de load le fichier
		
	}

}
