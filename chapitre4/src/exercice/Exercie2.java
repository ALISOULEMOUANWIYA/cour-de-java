package exercice;

import java.util.Scanner;

public class Exercie2 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Declaration des variables
		  int valeur;
		  Scanner cla = new Scanner(System.in);
		  do {
			  System.out.println("Entrez un entier : ");
			  valeur = cla.nextInt();
		  }while( valeur < 0 || valeur > 100);
		  
		  System.out.println("vous avez saisie : "+valeur);
	}

}
