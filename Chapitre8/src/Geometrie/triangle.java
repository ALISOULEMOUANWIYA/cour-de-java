package Geometrie;

public class triangle extends Forme{
	
	private int xB, yB, xC, yC;
	
	public triangle(int nxa, int nya, int nxb, int nyb, int nxc, int nyc, int nc) {
		super(nxa, nya, nc);
		xB = verifier(nxb, 0, largeurEcran);
		yB = verifier(nyb, 0, largeurEcran);
		xC = verifier(nxc, 0, largeurEcran);
		yC = verifier(nyc, 0, largeurEcran);
	}
	
	public triangle() {
		xB = verifier("seconde sommet en X : ", 0, largeurEcran);
		yB = verifier("seconde sommet en Y : ", 0, largeurEcran);
		xC = verifier("troisieme sommet en X : ", 0, largeurEcran);
		yC = verifier("troisieme sommet en Y : ", 0, largeurEcran);
	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Position en "+xB+", "+yB);
		System.out.println("Position en "+xC+", "+yC);
	}
	
	public void deplacer(int nx, int ny) {
		super.deplacer(nx, ny);
		xB = verifier(xB + nx, 0, largeurEcran);
		xB = verifier(yB + ny, 0, largeurEcran);
		xC = verifier(xC + nx, 0, largeurEcran);
		yC = verifier(yC + ny, 0, largeurEcran);
	}
}
