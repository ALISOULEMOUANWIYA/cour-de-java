package SapinNoel2;

import java.awt.Color;

import javax.swing.JFrame;

public class fenetreSapin {
	
	public final static int Ht = 500; 
	public final static int Lg = 500; 
	
	private final static int x = 150;
	private final static int y = 200;
	
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		
		Dessin page = new Dessin();
		
		fr.setTitle("Un sapin de Noel ");
		
		fr.setBackground(Color.black);
		fr.setBounds(x, y, Ht, Lg);
		
		fr.addWindowListener(new GestionFenetre());
		
		fr.add(page, "Center");
	    fr.add(new DesBoutons(page, fr), "South");
		
		//fr.getContentPane().add(page, "Center");
		//fr.getContentPane().add(new DesBoutons(page , fr), "South");
		
		fr.setVisible(true);
	}

}
