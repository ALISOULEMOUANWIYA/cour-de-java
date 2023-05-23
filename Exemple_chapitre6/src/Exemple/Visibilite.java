package Exemple;

public class Visibilite {
	public static void main(String[] args) {
		// declaration des variables
		int valeur = 2;
		System.out.println("valeur = "+valeur+" avant modifier()");
		modifier();
		System.out.println("valeur = "+valeur+" apres modifier()");
	}
	public static void modifier() {
		// declaration des variables
		int valeur = 3;
		System.out.println("valeur = "+valeur+" dans modifier()");
	}
}
