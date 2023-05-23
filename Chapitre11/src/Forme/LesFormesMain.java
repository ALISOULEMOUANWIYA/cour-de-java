package Forme;

import java.io.IOException;
import java.util.Scanner;

public class LesFormesMain {

	private static Scanner clavier = new Scanner(System.in);
	// la methode main
		public static void main(String[] args) throws IOException {
			
			byte choix = 0;
			boolean preuve;
			DesFormes lis = new DesFormes();
			fichier fich = new fichier();
			
			if(fich.ouvrir("LesFormes.txt", "Lecture")){
			    lis.lireLIsteFormes(fich);
			    lis.dessinerLesFormes();
			    preuve = fich.fermer();
			   // System.out.println(preuve);
		    }
			
			do {
				choix = menuPrincipale();
				switch(choix) {
	    		case 1: 
	    			lis.ajouterForme('C');
	    		break;
	    		case 2: 
	    			lis.ajouterForme('T');
	    		break;
	    		case 3: 
	    			lis.ajouterForme('R');
	    		break;
	    		case 4: 
	    			lis.ajouterForme('K');
	    		break;
	    		case 5: 
	    			lis.afficher();;
	    		break;
	    		case 6 : 
	    			fich.ouvrir("LesFormes.txt", "Ecriture");
	    			lis.enrigistrer(fich);
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

