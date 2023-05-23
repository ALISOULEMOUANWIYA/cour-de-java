package Exercices;

public class Fonction {

	public static void main(String[] args) {
		// Declaration des variables
		  int a, compteur;
		  for(compteur =0; compteur <= 5; compteur++) {
			  a = calcule(compteur);
			  System.out.println(a+" a ");
		  }
	}
	public static int calcule(int x) {
		int y;
		y = x * x;
		return y;
	}

}
