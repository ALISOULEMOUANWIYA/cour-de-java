package Geometrie;

public class Rectangle extends Forme{
	
	private int largeur, hauteur;
	
	Rectangle(int nx, int ny, int nl, int nh, int nc) {
		super(nx, ny, nc);
		largeur = verifier(nl, 0, largeurEcran);
		hauteur = verifier(nh, 0, hauteurEcran);
	}
	
	public Rectangle() {
		largeur = verifier("largeur ",0, largeurEcran);
		hauteur = verifier("hauteur ",0,hauteurEcran);
	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Largeur du rectangle : "+largeur);
		System.out.println("Hauteur du rectangle :"+hauteur);
	}
}
