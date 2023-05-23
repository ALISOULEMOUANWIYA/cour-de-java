package fichierDesLivres_HashMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


@SuppressWarnings("serial")
public class MainLivre implements Serializable{
	
	private static Scanner clavier = new Scanner(System.in);
	
	
	// la Methode maine
	public static void main(String[] args) throws IOException{
		
		byte choix = 0;
		boolean preuve, prouver;
		String CodeLivres ;
		
		FichierLivres fichies = new FichierLivres();
		FichierNumerique fich = new FichierNumerique();
		
		ListesDesLivres c = new ListesDesLivres();
		
		if(fichies.ouvrir("L")) {
			c = fichies.lire();
			fichies.fermer();
			System.out.println(c);
		}
		
		do {
			choix = menuPrincipale();
			switch (choix) {
				case 1 :		
					c.ajouterLivre();
				break;
				case 2 :
					CodeLivres = " ";
					System.out.print("Entrez le code du livre : ");
					CodeLivres = clavier.next();
					c.ModifierEntierLivre(CodeLivres);
				break;
				case 3 :
					CodeLivres = " ";
					System.out.print("Entrez le code du livre : ");
					CodeLivres = clavier.next();
					c.rechercheUnLivre(CodeLivres);
				break;
				case 4 :
					CodeLivres = " ";
					System.out.print("Entrez le code du livre : ");
					CodeLivres = clavier.next();
					c.SuprimerUnLivre(CodeLivres);;
				break;
				case 5 :
					c.afficherLesLivres(); 
				break;
				case 6 :
					fichies.ouvrir("Ecrire");
					fichies.ecrire(c);
					prouver = fichies.fermer();;
					if(prouver == true) {
	    				System.out.println("le fichier a ete fermé !");
	    			}else {
	    				System.out.println("Fichier interompu !");
	    			}
					
					fich.ouvrir("Livre.txt", "Ecriture");
	    			c.enrigistrerLesLivres(fich);
	    			preuve = fich.fermer();
	    			if(preuve == true) {
	    				System.out.println("le fichier a ete fermé !");
	    				System.exit(0);
	    			}else {
	    				System.out.println("Fichier interompu !");
	    			}
				break;
				default :
					System.out.println("Cette option n'existe pas ");
				
			}
		}while(choix != 6);
	}
	
	// la methode menue principale
	public static byte menuPrincipale() {
		byte tmp;
		System.out.println("\n\n");
		System.out.println("1. Ajoute un livre");
		System.out.println("2. Modifier un livre");
		System.out.println("3. recherche d'un livre");
		System.out.println("4. Suprimer un livre");
		System.out.println("5. Affiche la liste des livres");
		System.out.println("6. Pour sortir");
		System.out.print("Votre choix : ");
		tmp  = clavier.nextByte();
		System.out.println("\n\n");
		return tmp;
	}
}
