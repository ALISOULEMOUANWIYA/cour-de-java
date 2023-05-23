package DessinSapin5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestionFenetre extends WindowAdapter{
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
