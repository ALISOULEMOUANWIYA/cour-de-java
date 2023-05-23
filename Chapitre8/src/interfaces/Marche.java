package interfaces;

public class Marche extends MoyenDeTransfport{
	public Marche(int xx, int yy) {
		super(xx, yy);
		vitesse += limitation(5, 50);
		System.out.println("je suis le hero et je marche ");
		System.out.println("Vitesse : "+vitesse);
	}
	
	public void deplacementEnX() {
		x += vitesse;
		System.out.println(" x : "+x);
	}
}
