package exercice;

import java.util.Scanner;

public class Exercice1 {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		// Declaration des variable
		  int a, b, r; 
		   Scanner cla = new Scanner(System.in);
		   System.out.println("Entrez un entier : ");
		    a = cla.nextInt();
		   
		   System.out.println("Entrez un entier : ");
		    b = cla.nextInt();
		   
		   do {
			   r = a % b;
			   System.out.println(r+" = "+a+"%"+b);
			   a = b;
			   System.out.println(a+" = a ");
			   b = r;   
			   System.out.println(b+" = b ");
			   System.out.println("------------------------");
		   }while(r != 0);
		   System.out.println("apres le resultat est "+a);
	}

}
