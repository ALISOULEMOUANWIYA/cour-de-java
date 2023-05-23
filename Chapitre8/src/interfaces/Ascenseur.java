package interfaces;

public class Ascenseur extends MoyenDeTransfport{
	
	
	// Le constructeur ascenseur
		public Ascenseur(int xx, int yy) {
			// appel du constructeur MoyenDeTransfport()
			super(xx, yy);
			
			// verifier que la classe de la fusée ne depasse pas 20
			vitesse = limitation(5,20);
			System.out.println("je suis un ascenseur !");
			System.out.println("Vitesse : "+vitesse);
		}
	
	//  Un ascenceur se déplace sur l'axe des Y
	    public void deplacementY() {
	    	y += vitesse;
	    	System.out.println(" y : "+y);
	    }
}
