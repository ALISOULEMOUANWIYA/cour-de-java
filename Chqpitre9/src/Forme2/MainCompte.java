package Forme2;

import java.util.Scanner;

public class MainCompte {
	
	private static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		byte  choix = 0;
		char car;
		
		String numeroLu = "", vide = "";
		
		Compte c = new Compte(vide);
		do {
			choix = menuPrincipal();
			
			switch(choix) {
				case 1:
					System.out.println("compte Epargne (o/n)");
					car = clavier.next().charAt(0);
					if(car == 'o' || car == 'O') {
						c = new cpteEpargne();
					}else if(car == 'n' || car == 'N') {
						c = new Compte();
					}
				break;
				case 2:
					System.out.print("Quel compte souhaitez vous afficher : ");
					numeroLu = clavier.next();
					if(numeroLu.equalsIgnoreCase(c.getNumeroCompte())) {
						c.afficherCpte();
					}else {
						System.out.println("Desole ce compte ne fais pas partie des compte nerigistrer");
					}
				break;
				case 3:
					System.out.print("Quel compte souhaitez vous creer une ligne comptable : ");
					numeroLu = clavier.next();
					if(numeroLu.equalsIgnoreCase(c.getNumeroCompte())) {
						c.creerLigne();;
					}else {
						System.out.println("Desole ce compte ne fais pas partie des compte nerigistrer");
					}
				break;
				case 4 :	
                    sortir();    
                break;
			     case 5 :	
			           alAide();
			     break;
			     default :	
	                    System.out.println("Cette option n'existe pas ");
			}
		}while(choix != 4);
		
	}
	
	public static byte menuPrincipal() {
	 	byte tmp;
	        Scanner lectureClavier = new Scanner(System.in);
	 	System.out.println("1. Creation d'un compte");
	 	System.out.println("2. Affichage d'un compte");
	 	System.out.println("3. Ecrire une ligne comptable");
	 	System.out.println("4. Sortir");
	 	System.out.println("5. De l'aide");
	 	System.out.println();
	 	System.out.print("Votre choix : ");
	 	tmp  = lectureClavier.nextByte();
	 	return tmp;
	 }
	 public static void sortir( ) {
		System.out.println("Au revoir et a bientot");
		System.exit(0) ; 
	 }
	 public static void alAide( ) {
	  System.out.println("Option 1. Pour creer un compte Courant entrer C ");
	  System.out.println("          Pour creer un compte Joint entrer J ");
	  System.out.println("          Pour creer un compte Epargne entrer E");
	  System.out.print("            Puis, entrer le numero du compte, et"); 
	  System.out.println(" sa premiere valeur creditee ");
	  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
	  System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
	  System.out.println("Option 3. Ecrire une ligne comptable");
	  System.out.println("Option 4. Pour quitter le programme");
	  System.out.println("Option 5. Pour afficher de l'aide");
	 } 
}
