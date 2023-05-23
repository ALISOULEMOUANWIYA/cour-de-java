package Forme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class lesFormes {
	
	protected final static int longueurEcran = 800;
	protected final static int largeurEcran  = 600;
	
	public final static Color [] couleurDessin = {Color.green, Color.red, Color.blue, Color.pink, Color.orange, Color.gray};
	
	public final static int couleurMa = couleurDessin.length;
	
	private static Scanner clavier = new Scanner(System.in);
	
	protected int coordonneX, coordonneY, couleurC;
	
	// le constructeur par defaut
	   public lesFormes() {
		   coordonneX = verifier("Position en X = ", 0, largeurEcran);
		   coordonneY = verifier("Position en Y = ", 0, longueurEcran);
		   couleurC = verifier(" (la couleur de la figure) , couleur = ", 0, couleurMa);
	   }
	   
	// surcharge du constructeur par defaut
	   public lesFormes(int abcsisse , int ordonne, int couleur) {
		   coordonneX = verifier(abcsisse, 0, largeurEcran);
		   coordonneY = verifier(ordonne, 0, longueurEcran);
		   couleurC = verifier(couleur, 0, couleurMa);
	   }
	
    // -------------------------------la methode Changer la couleur de la forme--------------
	   public void ChangercouleurForme(int couleurCol) {
		   couleurC = verifier(couleurCol, 0, couleurMa);
	   }
	   
	//-----------------------Dessinner la forme------------------------
	   public void dessiner(Graphics g) {
		   g.setColor(couleurDessin[couleurC]);
	   }
	   
	// la methode afficher la forme
		public void afficher() {
			System.out.println("Couleur : "+couleurC);
			System.out.println("Position en "+coordonneX+" , "+coordonneY);
		}	 
	   
	// encapsulation de la methode verifier
		protected int verifier(int coordonner, int debut, int fin){
		   if(coordonner < debut) {
			   return debut;
		   }else if(coordonner > fin) {
			   return fin;
		   }else {
			   return coordonner;
		   }
	   }
	   
	   protected int verifier(String indication, int debut, int fin){
		   int tmp;
		   do {
			   System.out.print(indication+" ");
			   tmp = clavier.nextInt();
		   }while(tmp < debut || tmp > fin);
		   return tmp;
	   }
	   
  // la methode deplacer 
	   public void deplacer(int abcsisse , int ordonne) {
		   coordonneX = verifier(coordonneX+abcsisse, 0, largeurEcran);
		   coordonneY = verifier(coordonneY+ordonne, 0, longueurEcran);
	   }
	   
  //-----------------------------la methode changer la couleur de la forme------------------- 
	   public void changerCouleurForme(int changeCouleur) {
		   couleurC = verifier(changeCouleur, 0, couleurMa);
	   }

  //------------------------------ trouver l'abscisse minimal--------------------
	   public int trouverLeXmin() {
		   return coordonneX;
	   }
	// les commitateur ;
		
		public int getLargeurEcran() {
			return largeurEcran;
		}
		public int getlongueurEcran() {
			return longueurEcran;
		}
		public int getAbscisse() {
			return coordonneX;
		}
		public int getOrdonner() {
			return coordonneY;
		}
		public int getCouleurForm() {
			return couleurC;
		}
		public String getInfo() {
			return couleurC+";"+coordonneX+";"+coordonneY;
		}
		
	// les accesseurs
		public void setAbscisse(int valeur) {
			this.coordonneX = valeur;
		}
		public void setOrdonner(int valeur) {
			this.coordonneY = valeur;
		}
		public void setCouleurForm(int valeur) {
			this.couleurC = valeur;
		}
}
