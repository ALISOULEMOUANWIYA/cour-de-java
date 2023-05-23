package fichierDesLivres_HashMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;




public class ListesDesLivres implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private static Scanner clavier = new Scanner(System.in);
	private HashMap<String, Livre> listes;
	
	// le constructeur par defaut
		public ListesDesLivres() {
			listes = new  HashMap<String, Livre>();
		}
	
	// la methode ajouter un livre
		public void ajouterLivre() {
			Livre nouveauLivre = new Livre();
			String CodeLivre = nouveauLivre.getCode();
			if(listes.get(CodeLivre) == null) {
				listes.put(CodeLivre, nouveauLivre);
			}else {
				System.out.println("Ce livre est deja saisie ");
			}
		}
	
	 // La methode Suprimer un livre
		public void SuprimerUnLivre( String CodeLivre)  {
			Livre eClasse = (Livre) listes.get(CodeLivre);
			if
			(eClasse != null) {
				eClasse.afficherLivre(); 
				listes.remove(CodeLivre);
				System.out.println(" vient d'etre suprimer à l'instant !");
			}else {
				System.out.println(eClasse+" est innconnu !");
			}	
		}
		
	// la methode recherche un etudiant 
		public void rechercheUnLivre( String CodeLivre) {
			Livre eClasse = (Livre) listes.get(CodeLivre);
			//System.out.println("\n\n"+eClasse+"\n\n");
			if(eClasse != null) {
				eClasse.afficherLivre();;
			}else {
				System.out.println(eClasse+" est innconnu !");
			}
		}
		
	// la methode modifier les données de l'etudiant entierement
		public void ModifierEntierLivre( String CodeLivre) {
			char choix;
			Livre verification ;
			Livre eClasses = (Livre) listes.get(CodeLivre);
					
			if(eClasses != null) {
					eClasses.afficherLivre();
						
			}else {
						System.out.println(eClasses+" est innconnu !");
			}
							
			do {
				 System.out.println(" Etes vous sur de vouloir finalisé ces modification (o/n) ? : ");
				 choix = clavier.next().charAt(0);
				if(choix == 'O' || choix == 'o') 
				{
					choix = 'O';
					if(eClasses != null) {
						verification = listes.remove(CodeLivre);
						if(verification != null) {
							/***********************************************************/
								Livre nouveau = new Livre();
								String cler = nouveau.getCode();
									
								if(listes.get(cler) == null) {
								  	listes.put(cler, nouveau);
								}else {
									System.out.println("Cet Etudiant n'a pas pu etre creer ");
								}
							/**********************************************************/
						}
						}else {
							System.out.println("Ce livre n'existe pas ");
						}
						
			   }else if(choix == 'n' || choix == 'N') {
						choix = 'N';
						System.out.println("Ok, ce livre reste toujour dans la base des données ");
			   }else {
						System.out.println(" Valeur non prise en charge ");
				}
			 }while(choix != 'O' && choix != 'N');
		}
		
		
		// la methode de l'afficher les données de livre
			public void afficherLesLivres() {
				if(listes.size() != 0) {
					Collection<Livre> c = listes.values();
					for(Livre etud : c) {
						etud.afficherLivre();
					}
				}else {
					System.out.println("Il n'y aucune livre dans cette liste");
				}
			}	
	
	  // la methode enrigistrer les livres
			public void enrigistrerLesLivres(FichierNumerique fich) throws IOException{
				int nbFormes = listes.size();
				if(nbFormes > 0) {
					Collection<Livre> c = listes.values();
					String chaine = "";
					for(Livre tmp : c) {
						tmp.afficherLivre();;
						chaine = tmp.getInfo();
						if(chaine != null) {
							fich.ecrire(chaine);
						}
					}
				}else {
					System.out.println(" Il n'y a rien dans la liste pour enregistrer ");
				}
			}

}
