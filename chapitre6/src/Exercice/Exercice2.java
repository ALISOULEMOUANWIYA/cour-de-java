package Exercice;

import java.util.Scanner;

public class Exercice2{
	
	public static double resultat;
	public static char operation;
	public static void main(String[] args) {
		// Declaration des variables
		   int a,b;
		   Scanner cla = new Scanner(System.in);
		   menu();
		   
		   System.out.print("Entrez la premier valeur ");
		   a = cla.nextInt();
		   
		   System.out.print("Entrez la premier valeur ");
		   b = cla.nextInt();
		   
		   calculer(a,b);
		   afficher(a,b);
	}
	
	public static void  calculer(int a, int b) {
		
		switch(operation) {
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
			   resultat = a * b;
			   break;
		}
		
	}
	public static void afficher(int a, int b) {
		System.out.println(a+" "+operation+" "+b+" = "+resultat);
	}
	
	public static void menu() {
		Scanner lectureClavier = new Scanner(System.in);
		  System.out.println("Je sais compter, entrez l'operation choisie") ;
		  System.out.println(" + pour additionner ") ;
		  System.out.println(" - pour soustraire ") ;
		  System.out.println(" * pour pultiplier ") ;
		  System.out.println(" / pour diviser ") ;
		  System.out.print(" (+, -, *, /)  ? : ") ;
		  operation = lectureClavier.next().charAt(0);
	}
}
