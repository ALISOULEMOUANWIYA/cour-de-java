package DessinSapin5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Dessin extends JPanel{
	
	private Color couleur = Color.cyan;
	public final static Color couleurFond = Color.white;
	private Arbre A;
	
	public Dessin() {
		setBackground(couleurFond);
		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		A = new Arbre(8, Color.yellow);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		A.dessine(g);
	}
	
	public void nouveau() {
		A= new Arbre(8, Color.red);
		repaint();
	}
}
