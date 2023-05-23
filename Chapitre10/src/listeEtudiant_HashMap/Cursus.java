package listeEtudiant_HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


public class Cursus {
	
	private static Scanner clavier = new Scanner(System.in);
	private HashMap<String, Etudiant> listeEtudiant;
	
	// le constructeur par defaut 
		public Cursus() {
			listeEtudiant = new HashMap<String, Etudiant>();
		}
	
	// la methede creer un cle unique surcharer indicatife de la classe pointé en parametre  
		public String creerCle(Etudiant etud) {
			String tmp;
			tmp = (etud.getPreNomEtudiant().charAt(0))+ etud.getNomEtudiant();
			tmp.toUpperCase();
			return tmp;
		}
	
	// la methede creer un cle unique surcharer par des parametre de la classe   
		public String creerCle(String nom, String prenom) {
			String tmp;
			tmp = (prenom.charAt(0))+ nom;
			tmp.toUpperCase();
			return tmp;
		}
	
	// la methode ajouter un etudiant 
		public void ajouterUnEtudiant() {
			Etudiant nouveau = new Etudiant();
			String cle = creerCle(nouveau);
			if(listeEtudiant.get(cle) == null) {
				listeEtudiant.put(cle, nouveau);
			}else {
				System.out.println("Cet etudiant a deja ete saisie ");
			}
		}
	
	// La methode Suprimer un etudiant
		public void SuprimerUnEtudiant( String nomEtud, String prenomEtud)  {
			String cle =creerCle(nomEtud, prenomEtud);
			Etudiant eClasse = (Etudiant) listeEtudiant.get(cle);
			
			if(eClasse != null) {
				listeEtudiant.remove(cle);
				System.out.println(prenomEtud+" "+nomEtud+" vient d'etre suprimer à l'instant !");
			}else {
				System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
			}
			
		}
		
	// la methode recherche un etudiant 
		public void rechercheUnEtudiant( String nomEtud, String prenomEtud) {
			String cle = creerCle(nomEtud, prenomEtud);
			Etudiant eClasse = (Etudiant) listeEtudiant.get(cle);
			System.out.println("\n\n"+eClasse+"\n\n");
			if(eClasse != null) {
				eClasse.afficherUnEtudiant();
			}else {
				System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
			}
			
		}
		
	// la methode modifier les données de l'etudiantentierement
		public void ModifierEntier( String nomEtud, String prenomEtud) {
			char choix;
			Etudiant verification ;
			String clee = creerCle(nomEtud, prenomEtud);
			Etudiant eClasses = (Etudiant) listeEtudiant.get(clee);
			
			if(eClasses != null) {
				eClasses.afficherUnEtudiant();;
				
			}else {
				System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
			}
			
			
		  do {
			  System.out.println(" Etes vous sur de vouloir finalisé ces modification (o/n) ? : ");
			  choix = clavier.next().charAt(0);
			if(choix == 'O' || choix == 'o') 
			{
				choix = 'O';
				if(eClasses != null) {
					verification = listeEtudiant.remove(clee);
					if(verification != null) {
						 /***********************************************************/
							Etudiant nouveau = new Etudiant();
							String cler = creerCle(nouveau);
							
							if(listeEtudiant.get(cler) == null) {
								listeEtudiant.put(cler, nouveau);
							}else {
								System.out.println("Cet Etudiant n'a pas pu etre creer ");
							}
						 /**********************************************************/
					}
				}else {
					System.out.println("Cet Etudiant n'existe pas ");
				}
				
			}else if(choix == 'n' || choix == 'N') {
				choix = 'N';
				System.out.println("Ok, l'etudiant reste toujour dans la base des données ");
			}else {
				System.out.println(" Valeur non prise en charge ");
			}
		  }while(choix != 'O' && choix != 'N');
		}
		
	
	// la methode modifier les données de l'etudiant par ces notes
		public void ModifierNotes( String nomEtud, String prenomEtud,String ClasseEt, int semestreEt) {
			char choix;
			Etudiant verification ;
			String clee = creerCle(nomEtud, prenomEtud);
			Etudiant eClasses = (Etudiant) listeEtudiant.get(clee);
			
			if(eClasses != null) {
				eClasses.afficherUnEtudiant();
				
			}else {
				System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
			}
			
			
		  do {
			  System.out.println(" Etes vous sur de vouloir finalisé ces modification (o/n) ? : ");
			  choix = clavier.next().charAt(0);
			if(choix == 'O' || choix == 'o') 
			{
				
				if(eClasses != null) {
					verification = listeEtudiant.remove(clee);
					if(verification != null) {
						/************************************************************/
							Etudiant nouveau = new Etudiant(nomEtud, prenomEtud, ClasseEt, semestreEt);
							String cler = creerCle(nouveau);
							
							if(listeEtudiant.get(cler) == null) {
								listeEtudiant.put(cler, nouveau);
							}else {
								System.out.println("Cet Etudiant n'existe deja ");
							}
					   /**************************************************************/
					}
				}
			}else if(choix == 'n' || choix == 'N') {
				System.out.println("Ok, l'etudiant reste toujour dans la base des données ");
			}else {
				System.out.println(" Valeur non prise en charge ");
			}
		  }while(choix != 'O' && choix != 'N');
		}
		
	// la methode de l'afficher les données de l'etudiant
		public void afficherLesEtudiant() {
			if(listeEtudiant.size() != 0) {
				Collection<Etudiant> c = listeEtudiant.values();
				for(Etudiant etud : c) {
					etud.afficherUnEtudiant();
				}
			}else {
				System.out.println("Il n'y a pas d'etudiant dans cette liste");
			}
		}
}
