package ligneComande;

import java.util.Scanner;

public class Calculatrice {

	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a,b;
		char operateur;
		double calcule;
		
		if(args.length > 0) {
			a = Integer.parseInt(args[0]);
			operateur = args[1].charAt(0);
			b = Integer.parseInt(args[2]);
			System.out.println("a = "+a+", b= "+b+" et operateur = "+operateur);
		}
		else {
			operateur = menu();
			
			System.out.println("ENtrez la premier valeur ");
			a = clavier.nextInt();
			
			System.out.println("Entrez la second valeur ");
			b = clavier.nextInt();
		}
		
		calcule = calcul(a, b, operateur);
		afficher(a,b,operateur,calcule);
	}
	
	private static double calcul(int x, int y, char O) {
		double resultat = 0;
		switch(O) {
			case '+' :
				resultat = x + y;
			break;
			case '-' :
				resultat = x - y;
			break;
			case '*' :
				resultat = x * y;
			break;
			case '/' :
				if(y > 0) {
					resultat = x + y;
				}else {
					System.out.println("desole, operation impossible ");
				}
			break;
		}
		return resultat;
	}
	public static void afficher(int x, int y, char o, double r) {
		System.out.println(x+" "+o+" "+y+" = "+r);
	}
	 public static char menu() {
		  char opération ;
		  Scanner lectureClavier = new Scanner(System.in);
		  System.out.println("Entrer en premier l'opération choisie : ");
		  System.out.print(" (+, -, *, /)  ? : ");
		  opération = lectureClavier.next().charAt(0);
		  return opération ;
		 }

}
