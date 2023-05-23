package Exemple;

public class MemeNom {
	
	static int valeur;
	
	public static void main(String[] args) {
		// initialisation des variables
		valeur = 2;
		System.out.println("valeur = "+valeur+" avant modefier() ");
		modifier();
		System.out.println("valeur = "+valeur+" apres modifier()");	
	}
	public static void modifier() {
		System.out.println("valeur = "+valeur+" avant modefier() ");
		int valeur;
		valeur = 3;
		System.out.println("valeur = "+valeur+" apres modefier() ");

	}
}
