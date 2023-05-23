package Forme;

import java.awt.Graphics;

public class Carre extends lesFormes{
	
	private int largeur;
	
	// le constructeur par defaut
		public Carre() {
			largeur = verifier("Largeur = ", 0, getLargeurEcran());
		}
	
	// surchage du constructeur
		public Carre(int abcsisse , int ordonne, int ll,  int couleur) {
			super(abcsisse , ordonne, couleur);
			largeur = verifier(ll, 0, getLargeurEcran());
		}
	
	public void dessiner(Graphics g) {
		super.dessiner(g);
		g.fillRect(coordonneX, coordonneY, largeur, largeur);
	}
		
	// la methode afficher
		public void afficher() {
			System.out.println("\n------------- Carre ----------------");
			super.afficher();
				System.out.println("Cote = "+getLargeur());
		}
	
	// les commitateur
	  public int getLargeur() {
		  return largeur;
	  }
	  
	  
	// les accesseur 
	  public void setLargeur(int valeur) {
		  this.largeur = valeur;
	  }
	
	// obtenire les info du carre
	public String getInfo() {
		return "Carre;"+super.getInfo()+";"+getLargeur();
	}
}

