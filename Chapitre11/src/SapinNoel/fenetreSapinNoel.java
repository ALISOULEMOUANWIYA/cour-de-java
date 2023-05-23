package SapinNoel;

import java.awt.Color;
import javax.swing.JFrame;

public class fenetreSapinNoel {
	
	public final static int Ht = 500;
	public final static int Lg = 500;
	
	public final static int x = 150;
	public final static int y = 200;
	
	public static void main(String [] args) {
		
		JFrame fr = new JFrame();
		Dessin page = new Dessin();
		
		fr.setBounds(x, y, Ht, Lg);
		fr.setBackground(Color.darkGray);
		
		fr.addWindowListener(new GestionFenetre());
		
		fr.getContentPane().add(page , "Center");
		fr.getContentPane().add(new DesBoutons(page, fr), "South");
		
		fr.setVisible(true);
		
	}
}
