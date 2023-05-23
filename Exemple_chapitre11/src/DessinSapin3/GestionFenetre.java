package DessinSapin3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestionFenetre  extends WindowAdapter{
	public void windowsClosing(WindowEvent e) {
		System.exit(0);
	}
}
