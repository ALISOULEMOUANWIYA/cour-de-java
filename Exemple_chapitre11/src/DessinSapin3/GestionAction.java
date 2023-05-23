package DessinSapin3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionAction implements ActionListener{
	
	private int n;
	private Dessin d;
	
	public GestionAction(int n, Dessin d) {
		this.n = n;
		this.d = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(n) {
			case 2: 
				System.exit(0);
			break;
			case 1: 
				d.nouveau();
			break;
		}
	}
}
