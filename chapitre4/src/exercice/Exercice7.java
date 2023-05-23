package exercice;

import java.util.*;

public class Exercice7 {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Deaclaration des varables 
		  long i ,b = 1;
		  int a;
		  Scanner cla = new Scanner(System.in);
		  System.out.print("Entrez un entier : ");
		  a = cla.nextInt();
		  
		  for(i = 2; i <= a; i++) {
			  b = b * i;
			  System.out.println("le resultat vaut : "+b);
		  }

	}

}
