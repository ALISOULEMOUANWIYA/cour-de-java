package projet;

import java.util.Scanner;

public class projet4 {

	@SuppressWarnings({"resource","unused"})
	public static void main(String[] args) {
		// Declaration des variables
		  byte choix;
		  char typecpt = '\0';
		  double val_courant = 0.0, taux = 0.0;
		  long numeroCpte = 0, numeroLu = 0;
		  
		  Scanner cla = new Scanner(System.in);
		  
		  do {
			    System.out.println("1. Création d'un compte");
			    System.out.println("2. Affichage d'un compte");
			    System.out.println("3. Ecrire une ligne comptable");
			    System.out.println("4. Sortir");
			    System.out.println("5. De l'aide");
			    System.out.println();
			    System.out.print("Votre choix : ");
			    choix = cla.nextByte();
			    switch(choix) {
			       case 1:
			    	   do {
			    		   System.out.println("choisisez le type de votre compte  ");
			    		   System.out.println("C(courant) , J(joint) , E(epargne) : ");
			    		   typecpt = cla.next().charAt(0);
			    	   }while(typecpt != 'C' && typecpt != 'J' && typecpt != 'E');
			    	   System.out.println("Numero du compte : ");
			    	   numeroCpte = cla.nextLong();
			    	   System.out.println("Premier valeur creditee : ");
			    	   val_courant = cla.nextDouble();
			    	   if(typecpt == 'E') {
			    		   System.out.println("taux de placement : ");
			    		   taux = cla.nextDouble();
			    	   }
			    	   break;
			       case 2:
			    	   System.out.println("quel compte souhaitez vous afficher ? ");
			    	   numeroLu = cla.nextLong();
			    	   // verifier que le numero du compte existe
			    	   if(numeroLu == numeroCpte) {
			    		   System.out.println("Le compte n° : "+numeroCpte+"est un compte ");
			    		   if(typecpt == 'C' ) {
			    			   System.out.println("courent");
			    		   }else if(typecpt == 'J') {
			    			   System.out.println("jointe");
			    		   }else if(typecpt == 'E') {
			    			   System.out.println("epaargner dont le taux est : "+taux);
			    			   System.out.println("valeur initiale : "+val_courant);
			    		   }
			    	   }else {
			    		   System.out.println("Le systeme ne connais pas le compte : "+numeroLu);
			    	   }
			    	   break;
			       case 3:
			    	   // option 3 , le progrmme affiche "option non programmée"
			    	     System.out.println("option non programmée");
			    	   break;
			       case 4:
			    	   // option 4 , le progrmme termine son execution
			    	     System.out.println("aurevoir ");
			    	   break;
			       case 5:
			    	   System.out.println("Option 1. Pour creer un compte Courant entrer C ");
			    	      System.out.println("          Pour creer un compte Joint entrer J ");
			    	      System.out.println("          Pour creer un compte Epargne entrer E");
			    	      System.out.print("          Puis, entrer le numero du compte, et"); 
			    	      System.out.println(" sa premiere valeur creditee ");
			    	      System.out.println("           Dans le cas d'un compte epargne, entrer le taux ");
			    	      System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
			    	      System.out.println("Option 3. Ecrire une ligne comptable");
			    	      System.out.println("Option 4. Pour quitter le programme");
			    	      System.out.println("Option 5. Pour afficher de l'aide");
			    	   break;
			    	   default : 
			    		   System.out.println(" cette option n'existe pas ");
			    	   			    	   
			    }
		  }while(choix != 4);
		  

	}
	

}
