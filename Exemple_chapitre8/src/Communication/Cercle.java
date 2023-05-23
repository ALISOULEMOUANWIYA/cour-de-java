package Communication;

import java.util.Scanner;

public class Cercle {
	
	public int x, y, r;
	public static int nombre;
	
	
	// creation du cercle
	@SuppressWarnings("resource")
	public void creer() {
		Scanner clavier = new Scanner(System.in);
		
		System.out.print(" Position de X = ");
		x = clavier.nextInt();
		
		System.out.print(" Position de Y = ");
		y = clavier.nextInt();
		
		System.out.print(" Rayon de R = ");
		r = clavier.nextInt();
		
		nombre++;// incrementer le nombre de cercle creer
	}
	
	// echange des cordonnees de deux cercles
	public void echangeAvec(Cercle autre) {
		int tmp;
		
		tmp = x;
		x = autre.x;
		autre.x = tmp;
		
		tmp = y;
		y = autre.y;
		autre.y = tmp;
	}
	
	// afficher le ou les cercle(s)
	public void afficher() {
		System.out.println("Centre en "+x+", "+y);
		System.out.println("Rayon = "+r);
	}
	
	// perimetre du cercle
	public double perimtre() {
		return 2*Math.PI*r;
	}
	
	// deplacer le cercle
	public void deplacer(int nx, int ny) {
		x = nx;
		y = ny;
	}
	
	// agrandire le cercle
	public void agrandire(int nr) {
		r = r + nr;
	}
}
