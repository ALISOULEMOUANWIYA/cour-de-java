package chapitre3;

import java.util.Scanner;

public class Racine {

	public static void main(String[] args) {
		double x,r;
		Scanner clavier = new Scanner(System.in);
		System.out.println(" Entrez une chiffre : ");
		x = clavier.nextDouble();
		if(x >= 0) {
			r =Math.sqrt(x);
		}else {
			r =Math.sqrt(-x);
		}
		System.out.println("Pour "+x+" Le resultat est : "+r);		
	}

}
