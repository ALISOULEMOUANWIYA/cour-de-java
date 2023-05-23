package SapinNoel2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesBoutons extends JPanel{
	
	private static String bouton1 = "Nouveau";
	private static String bouton2 = "Quitter";
	private static String bouton3 = "Modele";
	
	public DesBoutons(Dessin d, JFrame j) {
		setBackground(Color.lightGray);
		
		// les bouton 
		 JButton bPaindre = new JButton(bouton1);
		 bPaindre.addActionListener(new GestionAction(1, d, j));
		 this.add(bPaindre);
		 
		 JButton bQuitter = new JButton(bouton2);
		 bQuitter.addActionListener(new GestionAction(2, d, j));
		 this.add(bQuitter);
		 
		 JButton bModele = new JButton(bouton3);
		 bModele.addActionListener(new GestionAction(3, d, j));
		 this.add(bModele);
	}
}
