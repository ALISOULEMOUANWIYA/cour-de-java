package DessinSapin2;

import java.awt.Color;
import java.awt.Frame;

public class FentreSapin {
	
	public final static int Ht = 300;
	public final static int Lg = 300;
	
	public static void main(String[] args) {
		Frame fr = new Frame();
		fr.setTitle("Un triangle ");// le titre du fetre
		fr.setSize(Ht, Lg); // la taille de la fenetre
		fr.setBackground(Color.gray);
		fr.add(new Dessin(), "Center");
		fr.setVisible(true);// afficher la fenetre
	}

}
