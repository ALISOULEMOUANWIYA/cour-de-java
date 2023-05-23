package DessinSapin3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;


public class Dessin extends Canvas{
	

	private static final long serialVersionUID = 1L;
	
	// les variables de class 
	private Color couleur = Color.blue;
	public final static Color couleurFond = Color.blue;
	
	// appel de la classe Arbre
	private Arbre A;
	
	// le constructeur par defaut 
	public Dessin() {
		setBackground(couleurFond);
		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		A = new Arbre(8, Color.yellow);
	}
	
	// apple de la methode de creation des objets graphique
	public void paint(Graphics g) {
		A.dessine(g);
	}
	
	// la methode recreer les objets graphique
	public void nouveau() {
		A = new Arbre(8, Color.red);
		repaint();
	}
}
