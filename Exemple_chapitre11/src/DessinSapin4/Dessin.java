package DessinSapin4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dessin extends JPanel{
	
	private Color couleur = Color.white;
	private final static Color couleurFond = Color.white;
	
	private Arbre A;
	
	public Dessin() {
		setBackground(couleur);
		setForeground(couleurFond);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		A = new Arbre(8, Color.yellow);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		A.dessine(g);
	}
	
	public void nouveau() {
		A = new Arbre(8, Color.red);
		repaint();
				
	}
}
