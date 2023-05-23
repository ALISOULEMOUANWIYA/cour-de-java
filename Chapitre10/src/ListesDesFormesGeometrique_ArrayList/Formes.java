package ListesDesFormesGeometrique_ArrayList;

import java.util.Scanner;

public class Formes {
	
	private static Scanner clavier = new Scanner(System.in);
	
	private final static int largeurEcran = 800;
	private final static int hauteurEcran = 600;
	private final static int couleurMax = 10;
	protected int CoordonneX, CoordonneY, couleurC;
	
	// construceur par defaut
		public Formes() {
			CoordonneX = verifier("Coordonn�e en X : ", 0, largeurEcran);
			CoordonneY = verifier("Coordonn�e en Y : ", 0, hauteurEcran);
			couleurC = verifier("Sa couleur est : ", 0, couleurMax);
		}
	
		
	// surcharge du construteur
		public Formes(int x, int y, int c) {
			CoordonneX = verifier(x, 0, largeurEcran);
			CoordonneY = verifier(y, 0, hauteurEcran);
			couleurC = verifier(c, 0, couleurMax);
		}
	
		
	// la methode afficher la forme
		public void afficher() {
			System.out.println("Couleur : "+couleurC);
			System.out.println("Position en "+CoordonneX+" , "+CoordonneY); 
			 p
		}
		
		
	/* les methode de controle */
	 // encapsulation de la methode verifier sur l'intervalle definit en memoir
		protected int verifier(String indication, int debutIntervalle, int finiIntervalle) {
			int tmp;
			 do {
				 System.out.println(indication);
				 tmp = clavier.nextInt();
			 }while(tmp < debutIntervalle || tmp > finiIntervalle);
			return tmp;
		}
		
	
		protected int verifier(int abscisseEtOrdonne, int debutIntervalle, int finiIntervalle) {
			if(abscisseEtOrdonne < debutIntervalle) {
				return debutIntervalle;
			}else if(abscisseEtOrdonne > finiIntervalle) {
				return finiIntervalle;
			}else {
				return abscisseEtOrdonne;
			}
		}
			0101
	// la methode deplacer la forme 	
		public void deplacerForme(int abscisse, int ordonner) {
			CoordonneX = verifier(abscisse + CoordonneX, 0, largeurEcran);
			CoordonneY = verifier(ordonner + CoordonneY, 0, hauteurEcran);
		}
		
	// la methode changer la couleur de la forme 
		public void CouleurForme(int CouleurFormes) {
			couleurC = verifier(CouleurFormes , 0, couleurMax);
		}
	
	// les commitateur ;
		
		public int getLargeurEcran() {
			return largeurEcran;
		}
		public int getHauteurEcran() {
			return hauteurEcran;
		}
		public int getAbscisse() {
			return CoordonneX;
		}
		public int getOrdonner() {
			return CoordonneY;
		}
		public int getCouleurForm() {
			return couleurC;
		}
		public String getInfo() {
			return couleurC+";"+CoordonneX+";"+CoordonneY;
		}
		
	// les accesseurs
		public void setAbscisse(int valeur) {
			this.CoordonneX = valeur;
		}
		public void setOrdonner(int valeur) {
			this.CoordonneY = valeur;
		}
		public void setCouleurForm(int valeur) {
			this.couleurC = valeur;
		}
		
}
