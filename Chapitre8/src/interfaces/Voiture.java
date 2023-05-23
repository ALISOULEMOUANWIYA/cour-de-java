package interfaces;

public class Voiture extends MoyenDeTransfport{
	
	public Voiture(int xx, int yy) {
		// appel du constructeur MoyenDeTransfport()
			super(xx, yy);
					
		// verifier que la classe de la fusée ne depasse pas 200
			vitesse = limitation(10,100);
		    System.out.println("je suis une voiture !");
			System.out.println("Vitesse : "+vitesse);
	}
	
	// une fusee se deplace sur l'axe des X
	   public void deplacementEnX() {
		   x += vitesse;
		   System.out.println("x : "+x);
	   }
	   
	
}
