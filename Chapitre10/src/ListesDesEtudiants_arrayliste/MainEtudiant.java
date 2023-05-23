package ListesDesEtudiants_arrayliste;

import java.util.Scanner;

public class MainEtudiant {
	
private static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		byte choix = 0;
		char car;
		String NomEtud, prenomEtud;
		
		Cursus c = new Cursus();
		do {
			choix = menuPrincipale();
			switch (choix) {
				case 1 :		
					c.ajouterEtudiant();
				break;
				case 2 :
					do {
						System.out.println(" Par classe ou par Nom  ( C ou N ) : ");
						car = clavier.next().charAt(0);
						
						if(car == 'c' || car == 'C') {
							car = 'C';
							//
						}else if(car == 'n' || car == 'N') {
							car = 'N';
							System.out.print("Entrez le nom de l'etudiant : ");
							NomEtud = clavier.next();
							System.out.print("Entrez le prenom de l'etudiant : ");
							prenomEtud = clavier.next();
							
							do 
							{
								System.out.println("Voulez vous modifier tous les données de l'etudiant ou seule ou seulement les notes : ");
								System.out.println(" oui (o) = tous les données , non (n)  = les notes seulement ");
								car = clavier.next().charAt(0);
								if(car == 'o' || car == 'O') {
								  c.ModifierEntier(NomEtud, prenomEtud);
								}else if(car == 'n' || car == 'N'){
									 c.ModifierNotes(NomEtud, prenomEtud);
								}else {
									System.out.println("Desoler valeur non pris en charge ");
								}
							}while(car != 'O' && car != 'N');
						}else {
							System.out.println("Desoler valeur non pris en charge ");
						}	
					}while(car != 'C' && car != 'N');
				break;
				case 3 :
					do {
						System.out.println(" Par classe ou par Nom  ( C ou N ) : ");
						car = clavier.next().charAt(0);
						
						if(car == 'c' || car == 'C') {
							car = 'C';
							//
						}else if(car == 'n' || car == 'N') {
							car = 'N';
							System.out.print("Entrez le nom de l'etudiant : ");
							NomEtud = clavier.next();
							System.out.print("Entrez le prenom de l'etudiant : ");
							prenomEtud = clavier.next();
							c.recherche(NomEtud, prenomEtud);
						}else {
							System.out.println("Desoler valeur non pris en charge ");
						}	
					}while(car != 'C' && car != 'N');
					
				break;
				case 4 :
					do {
						System.out.println(" Par classe ou par Nom  ( C ou N ) : ");
						car = clavier.next().charAt(0);
						
						if(car == 'c' || car == 'C') {
							car = 'C';
							//
						}else if(car == 'n' || car == 'N') {
							car = 'N';
							System.out.print("Entrez le nom de l'etudiant : ");
							NomEtud = clavier.next();
							System.out.print("Entrez le prenom de l'etudiant : ");
							prenomEtud = clavier.next();
							c.Suprimer(NomEtud, prenomEtud);
						}else {
							System.out.println("Desoler valeur non pris en charge ");
						}	
					}while(car != 'C' && car != 'N');
				break;
				case 5 :
					c.afficherLesEtudiants(); 
				break;
				case 6 :
					System.exit(0);
				break;
				default :
					System.out.println("Cette option n'existe pas ");
				
			}
		}while(choix != 6);

	}
	
	public static byte menuPrincipale() {
		byte tmp;
		System.out.println("\n\n");
		System.out.println("1. Ajoute un etudiant");
		System.out.println("2. Modifier un etudiant");
		System.out.println("3. recherche d'un etudiant");
		System.out.println("4. Suprimer un etudiant");
		System.out.println("5. Affiche la liste des etudiants");
		System.out.println("6. Pour sortir");
		System.out.print("Votre choix : ");
		tmp  = clavier.nextByte();
		System.out.println("\n\n");
		return tmp;
	}
}
