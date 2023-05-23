package DessinSapin4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestiondFenetre  extends WindowAdapter{
	public void windowClosing(WindowEvent ev) {
		System.exit(0);
	}
}
