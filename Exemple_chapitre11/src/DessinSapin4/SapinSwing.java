package DessinSapin4;

import javax.swing.JFrame;

public class SapinSwing {
	
	public final static int Ht = 300;
	public final static int Lg = 300;
	
	
	private final static int x = 150;
	private final static int y = 200;
	public static void main(String[] args) {
		
		JFrame fr = new JFrame("Une fenetre Swing ");
		Dessin page = new Dessin();
		
		//fr.setSize(Ht, Lg);
		fr.setBounds(x, y, Ht, Lg);
		
		
		fr.addWindowListener(new GestiondFenetre());
		
		//fr.getContentPane().add(new Dessin());
		fr.getContentPane().add(page, "Center");
		
		
		//fr.getContentPane().add(new DesBoutons(new Dessin(), fr), "South");
		  fr.getContentPane().add(new DesBoutons(page, fr), "South");
		
		fr.setVisible(true);
	}

}
