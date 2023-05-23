package fichierDesLivres_HashMap;

import java.io.Serializable;
import java.util.Scanner;

public class Livre implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static Scanner clavier = new Scanner(System.in);
	
	private String titreLivre;
	private String nomHauteur;
	private String prenomHauteur;
	private String categorie;
	private String NumeroIsbn;
	private String code;
	
	public Livre() {
		System.out.print("Entrez le titre du livre : ");
		setTitreLivre(clavier.next());
		
		System.out.print("Entrez la Categorie du livre : ");
		setCategorie(clavier.next());
		
		System.out.print("Entrez le Numero ISBN du livre du livre : ");
		setNumeroIsbn(clavier.next());
		
		System.out.print("Entrez le nom de l'hauteur du livre : ");
		setNomHauteur(clavier.next());
		
		System.out.print("Entrez le prenom de l'hauteur du livre : ");
		setPrenomHauteur(clavier.next());
		
		setCode(nomHauteur, prenomHauteur, categorie, NumeroIsbn, titreLivre);
	}
	
	
	// la methode afficher le livre
	   public void afficherLivre() {
		   System.out.println("Titre du livre : "+getTitreLivre());
		   System.out.println("Categorie du livre : "+getCategorie());
		   System.out.println("Auteur : "+getNomHauteur()+" "+getPrenomHauteur());
		   System.out.println(" numero ISBN : "+getNumeroIsbn());
		   System.out.println("Code du livre : "+getCode());
		   System.out.println("\n");
	   }
	
	// les comitetateur
		public void setNomHauteur(String valeur) {
			this.nomHauteur = valeur;
		}
		public void setPrenomHauteur(String valeur) {
			this.prenomHauteur = valeur;
		}
		public void setNumeroIsbn(String valeur) {
			this.NumeroIsbn = valeur;
		}
		public void setCategorie(String valeur) {
			this.categorie = valeur;
		}
		public void setCode(String valeur1, String valeur2, String valeur3, String valeur4, String valeur5) {
			int longueurIsbn;
			String finIsbn;
			
			longueurIsbn = valeur4.length();
			finIsbn = valeur4.substring((longueurIsbn - 2), longueurIsbn);
			
			
			this.code = valeur1.substring(0, 2) + valeur2.substring(0, 2) + valeur3.substring(0, 2)+ valeur5.subSequence(0, 2) + finIsbn ;
		}
		public void setTitreLivre(String valeur) {
			this.titreLivre = valeur;
		}
		  
		  
	// les accesseur 
		public String getNomHauteur() {
			return nomHauteur;
		}
		public String getPrenomHauteur() {
			return prenomHauteur;
		}
		public String getNumeroIsbn() {
			return NumeroIsbn;
		}
		public String getCategorie() {
			return categorie;
		}
		public String getCode() {
			return code;
		}
		public String getTitreLivre() {
			return titreLivre;
		}
		public String getInfo() {
			  return getTitreLivre()+";"+getCategorie()+";"+getNomHauteur()+";"+getPrenomHauteur()+";"+getNumeroIsbn()+";"+getCode();
		 }
}
