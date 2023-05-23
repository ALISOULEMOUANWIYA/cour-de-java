package Exemple;

public class ParValeur {

	public static void main(String[] args) {
			// initialisation des variables
			int valeur = 2;
			System.out.println("valeur = "+valeur+" avant modefier() ");
			modifier(valeur);
			System.out.println("valeur = "+valeur+" apres modifier()");		
	}
	public static void modifier(int valeur) {
		System.out.println("valeur = "+valeur+" avant modefier() ");
		valeur = 3 * valeur;
		System.out.println("valeur = "+valeur+" apres modefier() ");
	}
}
