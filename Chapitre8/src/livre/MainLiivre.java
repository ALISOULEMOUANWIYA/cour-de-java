package livre;

import java.util.Scanner;

public class MainLiivre {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		
		// appel du constructeur par defaut
		  LIvre lv = new LIvre();
		  
		// Modifier la propriet� d'un livre depuis une autre classe
		// Les instructions de saisie des propri�t�s sont � supprimer 
		// � partir de l'exercice 
		  
		    System.out.print("Entrez le titre : ");
			lv.setTitre(clavier.next());
			
			System.out.print("Entrez la categorie : ");
			lv.setCategorie(clavier.next());
			
			System.out.print("Entrez le nom de l'auteur : ");
			lv.setNomAuteur(clavier.next());
			
			System.out.print("Entrez le prenom de l'auteur : ");
			lv.setPrenom(clavier.next());	
			
			System.out.print("Entrez le numero ISBN : ");
			lv.setIsbn(clavier.next());
			
			// 8.3 Afficher une propri�t� d'un livre
			System.out.println("\n\n-------------------------Afficher une propri�t� d'un livre-------------------------------");
			System.out.print("Code du livre " + lv.getTitre()+ " : ");
			System.out.println(lv.getCode());
			System.out.println("--------------------------fin Afficher une propri�t� d'un livre----------------------------\n\n");
			
			// Afficher toutes les propri�t�s
			lv.afficherUnlivre();
			System.out.println("\n\n-----------------------------------------------------------");
			
			// 8.5.d Appel du constructeur param�tr�
			LIvre unPolar = new LIvre("Le myst�re de la chambre jaune","Leroux", "Gaston", "Policier", "2253005495");
			unPolar.afficherUnlivre();
	}

}
