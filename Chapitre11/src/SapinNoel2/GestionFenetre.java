package SapinNoel2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestionFenetre extends WindowAdapter{
	public void windowClosing(WindowEvent ev) {
		System.exit(0);
	}
}
