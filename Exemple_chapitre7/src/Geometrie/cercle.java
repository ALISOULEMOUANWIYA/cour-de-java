package Geometrie;

public class cercle {
	
	public int x,y ;
	public int r;
	
	// afficher le cercle
	public void affiche() {
		System.out.println("centrez en "+x+", "+y);
		System.out.println("Rayon : "+r);
	}
	
	// return le perimetre
	public double perimetre() {
		return 2*Math.PI;
	}
	
	// deplecer le cercle
	public void deplacer(int nx, int ny) {
		x = nx;
		y = ny; 
	}
	
	// agrandire le cercle
	public void  agrandire(int nr) {
		r = r + nr;
	}
	
	public void echanger(cercle autre) {
		int tmp;
		
		tmp = x;
		x = autre.x;
		autre.x = tmp;
		
		tmp = y;
		y = autre.y;
		autre.y = tmp;
	}
	
}
