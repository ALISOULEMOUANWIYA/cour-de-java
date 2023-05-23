package interfaces;

public class Fusee extends MoyenDeTransfport{
	
	public Fusee(int xx, int yy) {
		// appel du constructeur MoyenDeTransfport()
			super(xx, yy);
					
		// verifier que la classe de la fusée ne depasse pas 200
			vitesse = limitation(100,200);
		    System.out.println("je suis une Fusee !");
			System.out.println("Vitesse : "+vitesse);
	}
	
	// une fusee se deplace sur l'axe des X
	   public void deplacementEnX() {
		   x += vitesse;
		   System.out.println("x : "+x);
	   }
	// une fusee se deplace sur l'axe des Y
	   public void deplacementEnY() {
		   y += vitesse;
		   System.out.println("Y : "+y);
	   }
	  
}
