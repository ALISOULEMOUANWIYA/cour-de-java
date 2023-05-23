package Exercices;


import java.util.Scanner;

public class Exercice2 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Declaration des variables
		int nbCB, nbCheque, nbViremen, nbDebit;
		double resultat;
		
		Scanner cla = new Scanner(System.in);
		
		System.out.println("Nombre d'achat carte bleues : ");
		nbCB = cla.nextInt();
		
		System.out.println("Nombre de cheque emis : ");
		nbCheque = cla.nextInt();
		
		System.out.println("Nombre de virement automatique : ");
		nbViremen = cla.nextInt();
		
		nbDebit = nbCB + nbCheque + nbViremen;
		System.out.println("Vous avez emis "+nbDebit+" debits");
		
		resultat = pourcentage(nbDebit, nbCB);
		System.out.println(" dont "+resultat+" % par carte bleue");
		
		resultat = pourcentage(nbDebit, nbCheque);
		System.out.println(" dont "+resultat+" % par cheque");
		
		resultat = pourcentage(nbDebit, nbViremen);
		System.out.println(" dont "+resultat+" % par Virement automatique");

	}
	
	public static double pourcentage(int t, int nb) {
		double prtc = (double) nb / t*100;
		return prtc;
	}
}
