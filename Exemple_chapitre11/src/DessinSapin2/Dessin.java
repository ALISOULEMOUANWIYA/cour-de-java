package DessinSapin2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

public class Dessin extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private Color couleur = Color.green;
	public final static Color couleurFond = Color.white;
	private Arbre A;
	
	public Dessin() {
		setBackground(couleurFond);
		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		A = new Arbre(8, Color.yellow);
	}
	
	public void paint(Graphics g) {
		A.dessine(g);
	}
}
