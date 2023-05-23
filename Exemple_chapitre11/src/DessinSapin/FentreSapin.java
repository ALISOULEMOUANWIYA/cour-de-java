package DessinSapin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class FentreSapin {
	
	public final static int Ht = 300;
	public final static int Lg = 300;
	
	public static void main(String[] args) {
		Frame fr = new Frame();
		fr.setTitle("Un sapin de noel ");// le titre du fetre
		fr.setSize(Ht, Lg);
		fr.setBackground(Color.darkGray);
		fr.add(new Dissin(), "Center");
		fr.add(new Button("Quitter"), "South");
		fr.add(new Button("Nouveau"), "South");
		fr.setVisible(true);// afficher la fenetre
	}

}
