package Constructeur;

import java.util.Scanner;

public class Cercle {
	
	private int x, y, r;
	public final static int tailleEcran = 600;
	
	
	// le constructeur par defaut
		@SuppressWarnings("resource")
		public Cercle() {
			Scanner clavier = new Scanner(System.in);
			
			System.out.println("Position en X = ");
			x = clavier.nextInt();
			System.out.println("Position en Y = ");
			y = clavier.nextInt();
			r = rayonVerifier();
		}
	
	// surcharge du constructeur Cerlce des parametre x et y
		public Cercle(int centrex, int centrey) {
			x = centrex;
			y = centrey;
		}
	
	// surcharge du constructeur Cerlce des parametre x , y et r
		public Cercle(int centrex, int centrey, int rayon) {
			this(centrex,centrey);
			r = rayonVerifier(rayon);
		}
		
	// encapsulation de la methode rayonVerifier et en le surchargeant 
		private int rayonVerifier(int tmp) {
			if(tmp < 0) {
				return 0;
			}else if(tmp > tailleEcran) {
				return tailleEcran;
			}else {
				return tmp;
			}	
		}
		
	// encapsulation de la methode rayonVerifier
		@SuppressWarnings("resource")
		private int rayonVerifier() {
			int tmp;
			Scanner clavier = new Scanner(System.in);
			do {
				System.out.println("Rayon  R =  ");
				tmp = clavier.nextInt();
				if(tmp < 0) {
					System.out.println("Desolé valeur saisie est plus petit que 0 ");
				}else {
					if(tmp > tailleEcran) {
						System.out.println("Desolé cette valeur est plus grande que la taille de l'ecran ");
						
					}else {
							System.out.println("Valeur non pris en charge ");
					}
				}
			}while( tmp < 0 || tmp > tailleEcran) ;
			return tmp;
		}
		
	// echange de deux cercle
		public void echange(Cercle autre) {
			int tmp;
			
			tmp = x;
			x = autre.x;
			autre.x = tmp;
			
			tmp = y;
			y = autre.y;
			autre.y = tmp;
		}
		
	// agrandire le cercle
		public void agrandir(int nr) {
			r = rayonVerifier(r + nr);
		}
		
	// afficher le cercle
		public void afficher() {
			System.out.println(" Centre en "+x+", "+y);
			System.out.println("Rayon r = "+r);
		}
		
	// le perimtre du cercle
		public double perimetre(){
			return 2*Math.PI*r;
		}
		
	// deplacer le clercle
		public void deplacer(int nx, int ny) {
			x = nx;
			y = ny;
		}
		
}
