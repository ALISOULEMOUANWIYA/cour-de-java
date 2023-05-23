package ListesDesFormesGeometrique_ArrayList;

import java.io.IOException;
import java.util.Scanner;

public class MainFormes {

	private static Scanner clavier = new Scanner(System.in);
	// la methode main
		public static void main(String[] args) throws IOException {
			
			byte choix = 0;
			boolean preuve;
			ListesDesForme lis = new ListesDesForme();
			Fichier fich = new Fichier();
			
			if(fich.ouvrir("Formes.txt", "Lecture")){
			    lis.lireListeFormes(fich);
			    preuve = fich.fermer();
			   // System.out.println(preuve);
		    }
			
			do {
				choix = menuPrincipale();
				switch(choix) {
	    		case 1: 
	    			lis.ajouterUneFormes('C');
	    		break;
	    		case 2: 
	    			lis.ajouterUneFormes('T');
	    		break;
	    		case 3: 
	    			lis.ajouterUneFormes('R');
	    		break;
	    		case 4: 
	    			lis.ajouterUneFormes('K');
	    		break;
	    		case 5: 
	    			lis.afficherLesFormes();
	    		break;
	    		case 6 : 
	    			fich.ouvrir("Formes.txt", "Ecriture");
	    			lis.enrigistrerLesFormes(fich);
	    			preuve = fich.fermer();
	    			if(preuve == true) {
	    				System.out.println("le fichier a ete fermé !");
	    				System.exit(0);
	    			}else {
	    				System.out.println("Fichier interompu !");
	    			} 
	            break;
	    		default : System.out.println("Cette option n'existe pas");
	    	}
			}while(choix != 6);
		}
	
	//la methode menu principale
		public static byte menuPrincipale() {
			byte tmp;
			System.out.println("\n\n");
			System.out.println("1. Ajouter un Cercle");
	    	System.out.println("2. Ajouter un Triangle");
	    	System.out.println("3. Ajouter un Rectangle");
	    	System.out.println("4. Ajouter un Carre");
	    	System.out.println("5. Afficher la liste");
	    	System.out.println("6. Pour sortir");
	    	System.out.print("Votre choix : ");
			tmp  = clavier.nextByte();
			System.out.println("\n\n");
			return tmp;
		}

}
