package Forme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DessinFormes extends JPanel{
	
	private ArrayList<lesFormes> listeFormes;
	private Color couleur = Color.green;
	public final static Color couleurFond = Color.white;
	
	public DessinFormes(ArrayList<lesFormes> LesListes) {
		setBackground(couleurFond);
		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		listeFormes = LesListes;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int nbFormes = listeFormes.size();
		//System.out.println(nbFormes);
		if(nbFormes > 0) {
			for(lesFormes tmp: listeFormes) {
				tmp.dessiner(g);
			}
		}
	}
	
	public int trouverLeXMin() {
		int nbFormes = listeFormes.size();
		int min = lesFormes.largeurEcran;
		if(nbFormes > 0) {
			for(lesFormes tmp : listeFormes) {
				if(tmp.coordonneX < min) {
					min = tmp.coordonneX;
				}
				if(tmp instanceof Triangle) {
					tmp = (Triangle) tmp;
					int minT = tmp.trouverLeXmin();
					if(minT < min) {
						min = minT;
					}
				}
			}
		}
		return min;
	}
	
	public void deplacer(int Xref) {
		int nbFormes = listeFormes.size();
		if(nbFormes > 0) {
			for(lesFormes tmp : listeFormes) {
				if(tmp instanceof Triangle) {
					tmp = (Triangle) tmp;
					int decalageEnX = tmp.trouverLeXmin();
					tmp.deplacer(Xref - decalageEnX, 0);
				}else {
					tmp.deplacer(Xref - tmp.coordonneX, 0);
				}
			}
		} 
	}
	
	public void deplacerGaucheScene() {
		deplacer(0);
		repaint();
	}
	
	public void deplacerGaucheFormes() {
		int Xmin = trouverLeXMin();
		deplacer(Xmin);
		repaint();
	}
}
