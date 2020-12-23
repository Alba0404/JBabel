package fr.alba0404.jbabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageJMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		
		JBabel.reload(source);
		
	}

}
