package Forme;

import java.awt.Graphics;

public class Rectangle extends lesFormes{
	
	private int largeur;
	private int longueur;
	
	public Rectangle() {
		largeur = verifier("Largeur = ", 0, getLargeurEcran());
		longueur = verifier("Longueur = ", 0, getlongueurEcran());
	}
	
	public Rectangle(int abcsisse , int ordonne, int ll, int hh, int couleur) {
		super(abcsisse , ordonne, couleur);
		largeur = verifier(ll, 0, getLargeurEcran());
		longueur = verifier(hh, 0, getlongueurEcran());
	}
	
	public void dessiner(Graphics g) {
		super.dessiner(g);
		g.fillRect(coordonneX, coordonneY, longueur, largeur);
	}
	
	public void afficher() {
		System.out.println("\n------------- Rectangle ----------------");
		super.afficher();
			System.out.println("Largeur = "+getLargeur()+"  = ,  Longueur = "+getLongueur());
	}
	
	// les commitateur
	  public int getLargeur() {
		  return largeur;
	  }
	  
	  public int getLongueur() {
		  return longueur;
	  }
	  
	// les accesseur 
	  public void setLargeur(int valeur) {
		  this.largeur = valeur;
	  }
	  public void setLongueur(int valeur) {
		  this.longueur = valeur;
	  }
	
	public String getInfo() {
		return "Rectangle;"+super.getInfo()+";"+getLargeur()+";"+getLongueur();
	}
}
