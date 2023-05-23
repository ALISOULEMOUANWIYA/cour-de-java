package Exercices;

public class Exercice1_les_fonctions {

	public static void main(String[] args) {
		// declaration des variables
		  int r, max = f(0);
		  for(int x = -5; x <= 5; x++)
		  {
			  r = f(x);
			  System.out.println(r);
			  if(r > max) {
				  max = r;
			  }
		  }
		  System.out.println("le max est : "+max);
	}
	public static int f(int x) {
		int resultat;
		resultat = - x * x + 3 * x + 2;
		return resultat;
	}

}
