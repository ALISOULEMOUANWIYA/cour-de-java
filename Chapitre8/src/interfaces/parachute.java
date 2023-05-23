package interfaces;

public class parachute extends MoyenDeTransfport{
	
	public parachute(int xx, int yy) {
		super(xx, yy);
		vitesse += limitation(50, 300);
		System.out.println("je suis un helicopter ");
		System.out.println("Vitesse = "+vitesse);
	}
	
	// une fusee se deplace sur l'axe des x
	public void deplacementEnX() {
		x += vitesse;
		System.out.println("x : "+x);
	}
	
   // une fusee se deplace sur l'axe des y
	   public void deplacementEnY() {
		   y += vitesse;
		   System.out.println("y : "+y);
	   }
}
