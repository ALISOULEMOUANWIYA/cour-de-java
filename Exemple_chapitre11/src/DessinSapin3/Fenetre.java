package DessinSapin3;

import java.awt.Color;
import java.awt.Frame;

public class Fenetre {
	
	public final static int Ht = 300;
	public final static int Lg = 300;
	
	public static void main(String[] args) {
		Frame fr = new Frame();
		Dessin page = new Dessin();
		
		fr.setTitle("un sapin de noel");
		fr.setSize(Ht, Lg);
		fr.setBackground(Color.darkGray);
		fr.addWindowListener(new GestionFenetre());
		fr.add(page, "Center");
		fr.add(new DesBoutons(page), "South");
		fr.setVisible(true);
	}

}
