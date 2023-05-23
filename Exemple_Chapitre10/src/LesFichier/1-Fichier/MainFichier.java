package LesFichier.Fichier1;

import java.io.IOException;
import java.util.Scanner;

public class MainFichier {
	
	private static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args)throws IOException {
		
		fichier fich = new fichier();
		System.out.println("Entrez le nom du fichier : ");
		String nomfichier = clavier.next();
		
		fich.ouvrir(nomfichier, "Ecriture");
		for(int i = 0; i < 1; i++) {
		  fich.Ecrire(i);
	    }
		fich.fermer();
		
		fich.ouvrir(nomfichier,"Lecture");
		String chaine ="";
		do {
			chaine = fich.lire();
			if (chaine != null) System.out.println(chaine);
		} while (chaine != null);
		fich.fermer();
	}

}
