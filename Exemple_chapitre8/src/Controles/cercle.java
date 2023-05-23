package Controles;

import java.util.Scanner;

public class cercle {
	
	private int x,y,r;
	
	@SuppressWarnings("resource")
	public void creer() {
		Scanner clavier = new Scanner(System.in);
		
		System.out.print("Position en x = ");
		x = clavier.nextInt();
		
		System.out.print("Position en y = ");
		y = clavier.nextInt();
		
		do {
			System.out.print("Rayon : ");
			r = clavier.nextInt();
		}while(r  < 0 || r >  600);
		
	}
	
	public void afficher() {
		System.out.println("Centre en "+x+", "+y);
		System.out.println("Rayon : "+r);
	}
	
	public void agrandire(int nr) {
		if(r + nr < 0) {
			r = 0;
		}else if(r + nr > 600) {
			r = 600;
		}else {
			r = r + nr;
		}
	}
}
