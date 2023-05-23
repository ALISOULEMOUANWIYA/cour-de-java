package Forme;

import java.awt.Graphics;

public class Cercle extends lesFormes{
	
	private int rayon;
	
	// le constructeur par defaut
		public Cercle() {
			rayon = verifier("Rayon ", 0, getlongueurEcran());
		}
	
	// surcharge du constructeur
		public Cercle(int abcsisse , int ordonne, int couleur, int rayonCercle) {
			super(abcsisse ,  ordonne, couleur);
			rayon = verifier(rayonCercle, 0, getLargeurEcran());
		}
		
	// la methode dessiner
	   public void dessiner(Graphics g) {
		   super.dessiner(g);
		   g.fillOval(coordonneX, coordonneY, rayon, rayon);
	   }
		
	// La methode afficher le cercle
		public void afficher() {
			System.out.println("--------------------Cercle-------------------");
			super.afficher();
			System.out.println("Rayon = "+getRayon());
		}
	
	// les commitateur
		public int getRayon() {
			return rayon;
		}
	
	// obtenir l'inforamtion du cercle
		@Override
		public String getInfo() {
			String tmp;
			tmp = super.getInfo();
			
			return "Cercle;"+tmp+";"+getRayon();
		}
	
	// les accesseur 
	public void setRayon(int valeur) {
		this.rayon = valeur;
	}
}
