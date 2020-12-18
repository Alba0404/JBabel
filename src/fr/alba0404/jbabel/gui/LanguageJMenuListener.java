package fr.alba0404.jbabel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.alba0404.jbabel.JBabel;

public class LanguageJMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		
		JBabel.reload(source);
		
	}

}
