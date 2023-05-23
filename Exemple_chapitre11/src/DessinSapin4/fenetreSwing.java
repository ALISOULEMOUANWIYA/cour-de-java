package DessinSapin4;

import javax.swing.JFrame;

public class fenetreSwing {
	
	public final static int Ht = 300;
	public final static int Lg = 300;
	
	public static void main(String[] args) {
		JFrame fr = new JFrame("fenetre");
		
		fr.setSize(Ht, Lg);
		fr.setVisible(true);
	}

}
