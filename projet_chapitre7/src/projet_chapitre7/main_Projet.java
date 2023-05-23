package projet_chapitre7;

import java.util.Scanner;

public class main_Projet {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		
		byte choix = 0;
		String numeroLu = "";
		compte cpt = new compte();
		
		Scanner clavier = new Scanner(System.in);
		
		do {
			 choix = menuPrincipal();
			switch(choix) {
				case 1:
					cpt.creerCpte();
				break;
				case 2:
				  // demander à l'utilisateur de saisir le numero du compte à afficher
					System.out.println("Quel compte souhaitez vous afficher ? : ");
					numeroLu = clavier.next();
				  // verifier que le numero du compte existe
					 if(numeroLu.equalsIgnoreCase(cpt.numeroCpte)) {
						 cpt.afficherCpte();
					 }else {
						 System.out.println("Le systeme ne connait pas le compte "+numeroLu);
					 }
				break;
				case 3:
					// option 3, creer une ligne comptable 
					System.out.println("Pour quel compte souhaitez-vous creer une ligne ? : ");
				    numeroLu = clavier.next();
				    if(numeroLu.equalsIgnoreCase(cpt.numeroCpte)) {
				    	cpt.creerLigne();
				    }else {
				    	System.out.println("Le systeme ne connait pas le compte "+numeroLu);
				    }
				break;
				case 4:
					// option 4, le programme termine son execution 
					sortir();
				break;
				case 5:
					alAide();
			    break;
				default:
					System.out.println("cette option n'existe pas ");
			}
		}while(choix != 4);
	}
	// Affiche le menu principal, retourne la valeur de l'option choisie
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
		  System.out.println(" 			sa premiere valeur creditee ");
		  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
		  System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
		  System.out.println("Option 3. Ecrire une ligne comptable");
		  System.out.println("Option 4. Pour quitter le programme");
		  System.out.println("Option 5. Pour afficher de l'aide");
	 } 
}
