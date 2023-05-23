package Exemple;
import java.util.Scanner;

public class Cercle {

	public static void main(String[] args) {
		// declaration des variables
		   double resultat;
		   int valeur;
		   Scanner clavier = new Scanner(System.in);
		   
		   System.out.print("entre la valeur du rayon : ");
		   valeur = clavier.nextInt();
		   
		   resultat = perimetre(valeur);
		   
		   System.out.println("rayon = "+valeur +"\nperimetre = "+resultat);
		   
	}
	public static double perimetre(int r) {
		double p;
		p = 2 * Math.PI * r;
		return p;
	}
}
