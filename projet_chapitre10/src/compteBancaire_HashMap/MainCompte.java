package compteBancaire_HashMap;

import java.io.IOException;
import java.util.Scanner;


public class MainCompte {
	
	private static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		
		
		
		byte choix = 0;
		boolean preuve, prouver;
		String numero, type ;
		
		FichierCompte fichies = new FichierCompte();
		FichierNumeriqueCompte fich = new FichierNumeriqueCompte();
		
		Compte c = new Compte();
		
		if(fichies.ouvrir("L")) {
			c = fichies.lire();
			fichies.fermer();
			System.out.println(c);
		}
		
		do {
			choix = menuPrincipale();
			switch (choix) {
				case 1 :		
					c.ajouterUnCompte();
				break;
				case 2 :
					type = " ";
					numero = " ";
					System.out.print("Entrez le type du compte : ");
					type = clavier.next();
					System.out.print("Entrez le numero de compte : ");
					numero = clavier.next();
					c.ModifierEntier(type, numero);
				break;
				case 3 :
					type = " ";
					numero = " ";
					System.out.print("Entrez le type du compte : ");
					type = clavier.next();
					System.out.print("Entrez le numero de compte : ");
					numero = clavier.next();
					c.rechercheUnCompte(type, numero);
				break;
				case 4 :
					type = " ";
					numero = " ";
					System.out.print("Entrez le type du compte : ");
					type = clavier.next();
					System.out.print("Entrez le numero de compte : ");
					numero = clavier.next();
					c.SuprimerUnEtudiant(type, numero);
				break;
				case 5 :
					c.afficherLesComptes(); 
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
					
					fich.ouvrir("Fichier Compte numerique.txt", "Ecriture");
	    			c.enrigistrerLesComptes(fich);
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
		System.out.println("1. Ajoute un Compte");
		System.out.println("2. Modifier un Compte");
		System.out.println("3. recherche d'un Compte");
		System.out.println("4. Suprimer un Compte");
		System.out.println("5. Affiche la liste des Compte");
		System.out.println("6. Pour sortir");
		System.out.print("Votre choix : ");
		tmp  = clavier.nextByte();
		System.out.println("\n\n");
		return tmp;
	}
}
