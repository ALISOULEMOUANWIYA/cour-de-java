package Exemple;

public class Resultat {

	public static void main(String[] args) {
		// Declaration des variables 
		int valeur = 2;
		   System.out.println("valeur = "+valeur+" avant modifier()");
		   valeur = modifier(valeur);
		   System.out.println("valeur = "+valeur+" apres modifier()");
	}
	public static int modifier(int v) {
		System.out.println("valeur = "+v+" dans modifier()");
		int resultat = 3*v;
		System.out.println("Resultat = "+resultat+" dans modifer()");
		
		return resultat;
	}

}
