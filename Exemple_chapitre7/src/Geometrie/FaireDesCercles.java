package Geometrie;

import java.util.Scanner;

public class FaireDesCercles {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		cercle a = new cercle();
		
		Scanner clavier = new Scanner(System.in);
		a.affiche();
		
		System.out.println("Entrez la position en x : ");
		a.x = clavier.nextInt();
		
		System.out.println("Entrez la position en y : ");
		a.y = clavier.nextInt();
		
		System.out.println("Entrez le rayon r : ");
		a.r = clavier.nextInt();
		
		a.affiche();
		double p = a.perimetre();
		
		System.out.println("Votre cerlce à pour perimtre : "+p);
		a.deplacer(5, 10);
		
		System.out.println("Apres agrandissement ");
		a.affiche();
		
		cercle b = new cercle();
		b.x = 50;
		b.y = 50;
		b.r = 100;
		
		System.out.println("Le cercle b : ");
		b.affiche();
		b.echanger(a);
		
		System.out.println("Apres echanger le cercle a : ");
		a.affiche();
		
		System.out.println("Apres echanger le cercle b : ");
		b.affiche();
		
	}
}
