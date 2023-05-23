package LesFichier.FichierObjets;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


public class Cursus implements Serializable{
	
private static Scanner clavier = new Scanner(System.in);
	
	private HashMap<String, Etudiant>  listeClasse;
	
	public Cursus() {
		listeClasse = new HashMap<String, Etudiant>();
	}

	private String CreerUnecle(Etudiant etud) {
		String tmp = etud.getNomEtud() + (etud.getPrenomEtud().charAt(0)) ;
		tmp.toUpperCase();
		return tmp;
	}
	
	private String CreerUnecle( String nomEtud, String prenomEtud) {
		String tmp = nomEtud + prenomEtud.charAt(0) ;
		tmp.toUpperCase();
		return tmp;
	}
	public void ajouterUnetudiant() {
		Etudiant nouveau = new Etudiant();
		String cle = CreerUnecle(nouveau);
		System.out.println("\n\n"+cle+"\n\n");
		if(listeClasse.get(cle) == null) {
			listeClasse.put(cle, nouveau);
		}else {
			System.out.println("Cet Etudiant existe deja ");
		}
	}
	
	public void rechercheUnEtudiant( String nomEtud, String prenomEtud) {
		String cle = CreerUnecle(nomEtud, prenomEtud);
		Etudiant eClasse = (Etudiant) listeClasse.get(cle);
		System.out.println("\n\n"+eClasse+"\n\n");
		if(eClasse != null) {
			eClasse.afficherUnEtudiant();
		}else {
			System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
		}
		
	}
	
	public void SuprimerUnEtudiant( String nomEtud, String prenomEtud)  {
		String cle =CreerUnecle(nomEtud, prenomEtud);
		Etudiant eClasse = (Etudiant) listeClasse.get(cle);
		
		if(eClasse != null) {
			listeClasse.remove(cle);
			System.out.println(prenomEtud+" "+nomEtud+" vient d'etre suprimer à l'instant !");
		}else {
			System.out.println(prenomEtud+" "+nomEtud+" est innconnu !");
		}
		
	}
	
	public void ModifierEntier( String nomEtud, String prenomEtud) {
		char choix;
		Etudiant verification ;
		String clee = CreerUnecle(nomEtud, prenomEtud);
		Etudiant eClasses = (Etudiant) listeClasse.get(clee);
		
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
				verification = listeClasse.remove(clee);
				if(verification != null) {
					/********************************/
					Etudiant nouveau = new Etudiant();
					String cler = CreerUnecle(nouveau);
					
					if(listeClasse.get(cler) == null) {
						listeClasse.put(cler, nouveau);
					}else {
						System.out.println("Cet Etudiant n'existe deja ");
					}
				  /***********************************************/
				}
			}
		}else if(choix == 'n' || choix == 'N') {
			choix = 'N';
			System.out.println("Ok, l'etudiant reste toujour dans la base des données ");
		}else {
			System.out.println(" Valeur non prise en charge ");
		}
	  }while(choix != 'O' && choix != 'N');
	}
	
	public void ModifierNotes( String nomEtud, String prenomEtud) {
		char choix;
		Etudiant verification ;
		String clee = CreerUnecle(nomEtud, prenomEtud);
		Etudiant eClasses = (Etudiant) listeClasse.get(clee);
		
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
			
			if(eClasses != null) {
				verification = listeClasse.remove(clee);
				if(verification != null) {
					/************************************************************/
						Etudiant nouveau = new Etudiant(nomEtud, prenomEtud);
						String cler = CreerUnecle(nouveau);
						
						if(listeClasse.get(cler) == null) {
							listeClasse.put(cler, nouveau);
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
	
	public void afficherLesEtudiant() {
		if(listeClasse.size() != 0) {
			Collection<Etudiant> c = listeClasse.values();
			for(Etudiant etud : c) {
				etud.afficherUnEtudiant();
			}
		}else {
			System.out.println("Il n'y a pas d'etudiant dans cette liste");
		}
	}
}
