package forme1;

import java.util.Scanner;

public class ClasseForme {
	private static Scanner clavier = new Scanner(System.in);
	
	private static int tailleEcran = 600;
	private static int x, y, r;
	private static int  nbClercle;
	
	// le constructeur par defaut
	   public ClasseForme() {
		   
		   System.out.println("Position en X : ");
		   x = clavier.nextInt();
		   
		   System.out.println("Position en Y : ");
		   y = clavier.nextInt();
		   
		   r = rayonVerifier();
		   System.out.println("\n");
	   }
	   
	// surcharger le contructeur 
	   public ClasseForme(int centrex, int centrey) {
		    x = centrex;
		    y = centrey;
	   }
	   
	// surcharger le contructeur
	   public ClasseForme(int centrex, int centrey, int rayon) {
		   this(centrex,centrey);
		   r = rayonVerifier(rayon); 
	   }
	
	// la methode agrandire
	   public void agrandire(int nr) {
		   r = rayonVerifier(r + nr);
	   }
	   
	// la methode rayonVerifier
	   private int rayonVerifier() {
		   int tmp;
		   do {
			   System.out.print("Rayon  : ");
			   tmp = clavier.nextInt();
		   }while(tmp < 0 || tmp > tailleEcran);
		 return tmp;
	   }
	   
	 //surcharger la methode rayonVerifier
	   private int rayonVerifier(int tmp) {
		   do {
			   if(tmp < 0) {
				   return 0;
			   }else if(tmp > tailleEcran) {
				   return tailleEcran;
			   }else {
				   return tmp;
			   }
		   }while(tmp < 0 || tmp > tailleEcran);
	   } 
	   
	 // la methode afficher
	   public void afficher() {
		   System.out.println("Centre en "+x+", "+y);
		   System.out.println("Rayon : "+r);
	   }
	   
	 // la methode echanger 
	   @SuppressWarnings("static-access")
	public void echangerAvec(ClasseForme autre) {
		   int tmp;
		   
		   tmp = x;
		   x = autre.x;
		   autre.x = tmp;
		   
		   tmp = y;
		   y = autre.y;
		   autre.y = tmp;
	   }
	   
	 // la methode perimetre
	   public double perimetre() {
		   return 2*Math.PI*r;
	   }
	 
	// la methode deplacer
	   public void deplacer(int nx, int ny) {
		   x = nx;
		   y = ny;
	   }
	   
}
