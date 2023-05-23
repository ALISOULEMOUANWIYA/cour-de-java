package exercice;

import java.util.Scanner;

public class Exercice3 {
	
	@SuppressWarnings({"resource","unused"})
	public static void main(String[] args) {
		// Declaration des variables
		  int valeur , laplusgrande , laplusPetite, lasomme = 0, leNombre = 0;
		  double lamoyenne;
		  
		  Scanner cla = new Scanner(System.in);
		  
		  System.out.println("Entrez une valeur : ");
		  valeur = cla.nextInt();
		  
		  laplusgrande = valeur;
		  laplusPetite = valeur;
		  
		  do {
			  if(laplusgrande < valeur) 
			  {
				  laplusgrande = valeur;
			  }
			  if(laplusPetite > valeur) 
			  {
				  laplusPetite = valeur;
			  }
			  
			  lasomme = lasomme + valeur;
			  leNombre = leNombre + 1;
			  
			  System.out.println("Entrez une valeur (0 pour sortir) : ");
			  valeur = cla.nextInt();
			  
		  }while(valeur != 0);
		  System.out.println("la plus grande valeur est : "+laplusgrande);
		  System.out.println("la plus petite valeur est : "+laplusPetite);
		  
		  lamoyenne = (float) lasomme/ leNombre;
		  System.out.println("la moyenne de ces valeur est : "+lamoyenne);
	}

}
