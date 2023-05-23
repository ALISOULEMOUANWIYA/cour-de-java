package compteBancaire_HashMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;






public class Compte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static Scanner clavier = new Scanner(System.in);  
	
	private HashMap<String , Inscription> listeCompte;
	
	public Compte() {
		listeCompte = new HashMap<String , Inscription>();
	}

	// la methede creer un cle unique surcharer indicatife de la classe pointé en parametre  
	public String creerCle(Inscription Ins) {
		String tmp;
		int longueurTypeCompte;
		String finaliter;
		
		longueurTypeCompte = Ins.getTypeCompte().length();
		finaliter = Ins.getTypeCompte().substring((longueurTypeCompte - 2), longueurTypeCompte);
		
		tmp = "com"+(Ins.getTypeCompte().charAt(0))+ Ins.getNumeroCompte()+finaliter;
		tmp.toUpperCase();
		return tmp;
	}
	
	// la methede creer un cle unique surcharer par des parametre de la classe   
	public String creerCle(String type, String numero) {
		String tmp;
		int longueurTypeCompte;
		String finaliter;
		
		longueurTypeCompte = type.length();
		finaliter = type.substring((longueurTypeCompte - 2), longueurTypeCompte);
		
		tmp = "com"+(type.charAt(0))+ numero+finaliter;
		tmp.toUpperCase();
		return tmp;
	}

   // la methode ajouter un etudiant 
	public void ajouterUnCompte() {
		char car;
		
		System.out.println("compte Epargne (o/n)");
		car = clavier.next().charAt(0);
		if(car == 'o' || car == 'O') {
			CompteEpargne nouveau = new CompteEpargne();
			nouveau.setCodeCompte(creerCle(nouveau));
			
			System.out.println("\n"+nouveau.getCodeCompte()+"\n");
			
			if(listeCompte.get(nouveau.getCodeCompte()) == null) {
				listeCompte.put(nouveau.getCodeCompte(), nouveau);
			}else {
				System.out.println("Cet Compte a étè déjà ete saisie ");
			}
		}else if(car == 'n' || car == 'N') {
			Inscription nouveau = new Inscription();
			 nouveau.setCodeCompte(creerCle(nouveau));
			
			System.out.println("\n"+nouveau.getCodeCompte()+"\n");
			
			if(listeCompte.get(nouveau.getCodeCompte()) == null) {
				listeCompte.put(nouveau.getCodeCompte(), nouveau);
			}else {
				System.out.println("Cet Compte a étè déjà ete saisie ");
			}
		}	
	}
	
	// La methode Suprimer un etudiant
			public void SuprimerUnEtudiant(String type, String numero)   {
				String cle =creerCle(type, numero) ;
				Inscription eClasse = (Inscription) listeCompte.get(cle);
				
				if(eClasse != null) {
					listeCompte.remove(cle);
					System.out.println(" ce compte : "+numero+" vient d'etre suprimer à l'instant !");
				}else {
					System.out.println(" ce compte : "+numero+" est innconnu !");
				}
				
			}
			
		// la methode recherche un etudiant 
			public void rechercheUnCompte(String type, String numero) {
				String cle = creerCle(type, numero);
				Inscription eClasse = (Inscription) listeCompte.get(cle);
				//System.out.println("\n\n"+eClasse+"\n\n");
				if(eClasse != null) {
					eClasse.afficherCpte();
				}else {
					System.out.println(" ce compte : "+numero+" est innconnu !");
				}
				
			}
			
		// la methode modifier les données de l'etudiantentierement
			public void ModifierEntier(String type, String numero) {
				char choix, car;
				Inscription verification ;
				String clee = creerCle(type, numero);
				Inscription eClasses = (Inscription) listeCompte.get(clee);
				
				if(eClasses != null) {
					eClasses.afficherCpte();
					
				}else {
					System.out.println(" ce compte : "+numero+" est innconnu !");
				}
				
				
			  do {
				  System.out.println(" Etes vous sur de vouloir finalisé ces modification (o/n) ? : ");
				  choix = clavier.next().charAt(0);
				if(choix == 'O' || choix == 'o') 
				{
					choix = 'O';
					if(eClasses != null) {
						verification = listeCompte.remove(clee);
						if(verification != null) {
						  /***********************************************************/
								System.out.println("compte Epargne (o/n)");
								car = clavier.next().charAt(0);
								if(car == 'o' || car == 'O') {
									CompteEpargne nouveau = new CompteEpargne();
									nouveau.setCodeCompte(creerCle(nouveau));
									
									System.out.println("\n"+nouveau.getCodeCompte()+"\n");
									
									if(listeCompte.get(nouveau.getCodeCompte()) == null) {
										listeCompte.put(nouveau.getCodeCompte(), nouveau);
									}else {
										System.out.println("Cet Compte a étè déjà ete saisie ");
									}
								}else if(car == 'n' || car == 'N') {
									Inscription nouveau = new Inscription();
									 nouveau.setCodeCompte(creerCle(nouveau));
									
									System.out.println("\n"+nouveau.getCodeCompte()+"\n");
									
									if(listeCompte.get(nouveau.getCodeCompte()) == null) {
										listeCompte.put(nouveau.getCodeCompte(), nouveau);
									}else {
										System.out.println("Cet Compte a étè déjà ete saisie ");
									}
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
			
		// la methode de l'afficher les données de l'etudiant
			public void afficherLesComptes() {
				if(listeCompte.size() != 0) {
					Collection<Inscription> c = listeCompte.values();
					for(Inscription etud : c) {
						etud.afficherCpte();
					}
				}else {
					System.out.println("Il n'y a pas de compte dans cette liste");
				}
			}
			
	  // la methode enrigistrer les livres
	     public void enrigistrerLesComptes(FichierNumeriqueCompte fich) throws IOException{
			int nbFormes = listeCompte.size();
			  if(nbFormes > 0) {
				Collection<Inscription> c = listeCompte.values();
				String chaine = "";
				for(Inscription tmp : c) {
					System.out.println("***************************************************** COMPTE******************************************* \n");
				   tmp.afficherCpte();
				   System.out.println("\n");
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
