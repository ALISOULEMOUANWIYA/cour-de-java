package Interface;

import java.util.Scanner;

public class Cercle extends Forme{
	
	public final static int tailleEcran = 600;
	private int r;
	
	public Cercle(int xx, int yy) {
		super(xx, yy);
		couleur =  10;
		r = rayonVerifier();
	}
	
	@SuppressWarnings("resource")
	private int rayonVerifier() {
		Scanner clavier = new Scanner(System.in);
		
		int tmp;
		do {
			System.out.println("rayon : ");
			tmp = clavier.nextInt();
		}while ( tmp < 0 || tmp > tailleEcran);
		return tmp;
	}
	
	private int rayonVerifier(int tmp) {
		if (tmp < 0) { 
			return 0;
		}
		else if ( tmp > tailleEcran) { 
			return tailleEcran ; 
		}
		else {
			return tmp;
		}
	}
	
	public double perimetre() {
		return 2*Math.PI*r;
	}
	
	public double surface() {
		return Math.PI*r*r;
	}
	
	public void agrandire(int nr) {
		r = rayonVerifier(r + nr);
	}
	
}
