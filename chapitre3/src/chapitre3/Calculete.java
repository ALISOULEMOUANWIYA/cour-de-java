package chapitre3;

import java.util.Scanner;

public class Calculete {

	public static void main(String[] args) {
		int a, b;
		String operateur;
		double calcul = 0.0;
		boolean ok = true;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez la premier valeur : ");
		a = clavier.nextInt();
		System.out.println("Entrez la second valeur : ");
		b = clavier.nextInt();
		
		System.out.println("Type d'oparation  (+, -, *, /) : ");
		operateur = clavier.next();
		
		switch(operateur) {
		   case "+" :
			  calcul = a+b;
			  break;
		   case "-" :
				  calcul = a-b;
				  break;
		   case "/" :
			   if(b!=0)
				  calcul = a/b;
			   else 
				   ok = false;
			   break;
		   case "*" :
				  calcul = a*b;
				  break;
		   default : ok = false;
		}
		if(ok) {
			System.out.println("cette operateur a pour resultat : ");
			System.out.println(a+" "+operateur+" "+b+" = "+calcul);
		}else {
			System.out.println("Operateur non conforme ");
		}
			
		
	}

}
