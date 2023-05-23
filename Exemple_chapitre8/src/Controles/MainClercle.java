package Controles;

import java.util.Scanner;

public class MainClercle {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		
		cercle a = new cercle();
		
		a.creer();
		a.afficher();
		
		System.out.println("Entrez une valeur d'agrandissement : ");
		int plus = clavier.nextInt();
		
		System.out.println("Apres agrandissement : ");
		a.agrandire(plus);
		a.afficher();
	}

}
