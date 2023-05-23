package Exercices;

import java.util.Scanner;

public class Exercice3 {
	
	
	public static void main(String[] args) {
		//Declaration des variables
		  int valeur ;
		  valeur = verifier();
		  System.out.println("valeur : "+valeur);
		  valeur = verifierAvecBornes(10,20);
		  System.out.println("valeur : "+valeur);
	}
	// fonction de verification
		@SuppressWarnings("resource")
		public static int verifier() {
			int resultat;
			Scanner cla = new Scanner(System.in);
			do {
				System.out.print("Entrez un entier : ");
				resultat = cla.nextInt();
			}while( resultat < 0 || resultat > 100);
			return resultat;
		}
	
	// fonctionde verification des bornes 
		@SuppressWarnings("resource")
	   public static int verifierAvecBornes(int a, int b) {
		   int resultat;
		   Scanner cla = new Scanner(System.in);
		   do {
				System.out.print("Entrez un entier : ");
				resultat = cla.nextInt();
			}while( resultat < a || resultat > b);
			return resultat;
	   }

}
