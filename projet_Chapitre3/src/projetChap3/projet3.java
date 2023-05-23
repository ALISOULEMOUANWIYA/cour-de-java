package projetChap3;

import java.util.Scanner;

public class projet3 {

	public static void main(String[] args) {
		byte choix;
		char typeCpte = '\0';
		double val_courante = 0.0, taux = 0.0;
		long numerocpte = 0, numeroLu = 0;
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("1 - creation d'un compte ");
		System.out.println("2 - Affichage d'un compte  ");
		System.out.println("4 - ecrire une ligne comptable ");
		System.out.println("5 - De l'aide ");
		System.out.println();
		System.out.print("Votre choix ");
		choix = clavier.nextByte();
		
		switch(choix) {
		   case 1:
			   System.out.println("type du compte  [Type possible]");
				System.out.println("C(courant) j(joint), E(epargne) :");
				typeCpte = clavier.next().charAt(0);
				System.out.println("Numero du compte : ");
				numerocpte = clavier.nextLong();
				System.out.println("Premier valeur creditee : ");
				val_courante = clavier.nextDouble();
			if(typeCpte == 'E') {
			    System.out.println("taux de placement : ");
			    taux = clavier.nextDouble();
			}
			   break;
		   case 2: 
			   System.out.println("Quel compte souhaitez vous afficher ?  : ");
			    numeroLu = clavier.nextLong();
		      if(numeroLu == numerocpte) {
		    	//si oui affiche le numero du compte, le type , la valeur initiale
		    	    System.out.println("Le compte n° : "+numerocpte+"est compte ");
		 		    if(typeCpte == 'C') {
		 		    	System.out.println("courant ");
		 		    }else if(typeCpte == 'J') {
		 		    	System.out.println("joint ");
		 		    }else if(typeCpte == 'E') {
		 		    	// afficher son taux dans le cas d'un compte epargne
		 		    	System.out.println("epargne dont le taux "+taux);
		 		    }
		 			System.out.println("premie valeur credité : "+val_courante);
		      }else {
		    	// sinon , il affiche un message indiquant que le numero du compte n'est pas valide
				    System.out.println("le systeme ne connait pas le compte "+numerocpte);
		      }
			 break;
		   case 3 :
			   // option 3 , le programme affiche  "option non programmée"
			   System.out.println("Option non programmée");
			   break;
		   case 4 :
			   // option 4 , le programme termine son execution 
			   System.exit(0);
			   break;
		   case 5 :
			   // le programme affiche une ligne d'explication pour chaque option 
			   // du meniu principal 
					   System.out.println("Option 1. Pour créer un compte Courant entrer C ");
					   System.out.println("          Pour créer un compte Joint entrer J ");
					   System.out.println("          Pour créer un compte Epargne entrer E");
					   System.out.print("          Puis, entrer le numéro du compte, et"); 
					   System.out.println(" sa première valeur creditee ");
					   System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
					   System.out.println("Option 2. Le systeme affiche les données du compte choisi ");
					   System.out.println("Option 3. Ecrire une ligne comptable");
					   System.out.println("Option 4. Pour quitter le programme");
					   System.out.println("Option 5. Pour afficher de l'aide");
			   break;
		}
	}

}
