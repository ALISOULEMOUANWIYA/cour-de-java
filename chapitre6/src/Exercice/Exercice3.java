package Exercice;

import java.util.Scanner;

public class Exercice3{
	
	
	
	
	public static void main(String[] args) {
		// Declaration des variables
		   int a,b;
		   
		   char operateur;
		   
		   double calcul = 0;
		   Scanner cla = new Scanner(System.in);
		   operateur = menu();
		   
		   System.out.print("Entrez la premier valeur ");
		   a = cla.nextInt();
		   
		   System.out.print("Entrez la premier valeur ");
		   b = cla.nextInt();
		   
		   calcul = calculer(a,b,operateur);
		   afficher(a,b,operateur,calcul);
	}
	
	public static double  calculer(int a, int b, char operateur) {
		double resultat =0 ;
		switch(operateur) {
		   case '+':
			   resultat = a + b;
			   break;
		   case '-':
			   resultat = a - b;
			   break;
		   case '/':
			   resultat = a / b;
			   break;
		   case '*':
			   resultat  = a * b;
			   break;
		}
		return resultat; 
	}
	public static void afficher(int x, int y, char operateur, double resultat) {
		System.out.println(x+" "+operateur+" "+y+" = "+resultat);
	}
	
	public static char menu() {
		char operateur;
		Scanner Clavier = new Scanner(System.in);
		  System.out.println("Je sais compter, entrez l'operation choisie") ;
		  System.out.println(" + pour additionner ") ;
		  System.out.println(" - pour soustraire ") ;
		  System.out.println(" * pour pultiplier ") ;
		  System.out.println(" / pour diviser ") ;
		  System.out.print(" (+, -, *, /)  ? : ") ;
		  operateur = Clavier.next().charAt(0);
		  return operateur;
	}
}
