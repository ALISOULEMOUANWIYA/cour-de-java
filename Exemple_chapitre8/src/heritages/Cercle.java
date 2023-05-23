package heritages;

import java.util.Scanner;

public class Cercle extends Forme{
	
	public final static int  tailleEcran = 600;
	private int r;
	
	// surcharger le constructeur Cercle
		public Cercle(int xx, int yy) {
			super(xx, yy);
			couleur = 10;
			r = rayonVerifier();
		}
	// la methode afficher
		public void afficher() {
			super.afficher();
			System.out.println("rayon : "+r);
		}
		
	// encapsuler la methode rayonVerifier
		@SuppressWarnings("resource")
		private int rayonVerifier() {
			Scanner clavier = new Scanner(System.in);
			int tmp;
			
			do {
				System.out.println("rayon : ");
				tmp = clavier.nextInt();
			}while ( tmp < 0 || tmp > tailleEcran);
			return tmp;
		}
		
	// surcharger l'encapsuler la methode rayonVerifier
		private int rayonVerfier(int tmp) {
			if(tmp < 0) {
				return 0;
			}else if(tmp > tailleEcran) {
				return tailleEcran;
			}else {
				return tmp;
			}
		}
		
	// la methode perimetre
		public double perimetre() {
			return 2*Math.PI*r;
		}
		
	// la methode agrandire
		public void agrandire(int nr) {
			r = rayonVerfier(r + nr);
		}
	
}
