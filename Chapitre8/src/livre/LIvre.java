package livre;

import java.util.Scanner;

public class LIvre {
	// les instance sont privées
	   private String titre;
	   private String categorie;
	   private String isbn;
	   private String nomAuteur;
	   private String prenom;
	   private String code;
	   
	// definition des methodes d'access en ecriture 
	   // methode des setter  
	   
	      // methode titre
	      public void setTitre(String valeur) {
	    	  this.titre = valeur;
	      }
	      // methode categorie
	      public void setCategorie(String valeur) {
	    	  this.categorie = valeur;
	      }
	      // methode Numero ISBN
	      public void setIsbn(String valeur) {
	    	  this.isbn = valeur;
	      }
	      // methode NomAuteur
	      public void setNomAuteur(String valeur) {
	    	  this.nomAuteur = valeur;
	      }
	      // methode prenom
	      public void setPrenom(String valeur) {
	    	  this.prenom = valeur;
	      }
	      // methode code ( cette methode est invisible (metier))
	      @SuppressWarnings("unused")
		private String setCode() {
	    	  String debutNom;
	    	  String debutPrenom;
	    	  String debutCategorie;
	    	  int longueurIsbn;
	    	  String FinIsbn;
	    	  
	    	  debutNom = nomAuteur.substring(1, 3);
	    	  debutPrenom = prenom.substring(1, 3);
	    	  debutCategorie = categorie.substring(0, 3);
	    	  longueurIsbn = isbn.length();
	    	  
	    	  FinIsbn = isbn.substring((longueurIsbn - 3), longueurIsbn);
	    	  
	    	  
	    	  return debutNom + debutPrenom + debutCategorie  + FinIsbn;
	      }
	 
	// definition des methodes d'access en ecriture 
	   // methode des setter 
	      
	     // methode titre
	      public String getTitre() {
	    	  return titre ;
	      }
	      // methode categorie
	      public String getCategorie() {
	    	  return categorie ;
	      }
	      // methode Numero ISBN
	      public String getIsbn() {
	    	  return isbn ;
	      }
	      // methode NomAuteur
	      public String getNomAuteur() {
	    	  return nomAuteur ;
	      }
	      // methode prenom
	      public String getPrenom() {
	    	  return prenom ;
	      }
	      // methode code
	      public String getCode() {
	    	  code = setCode();
	    	  return code ;
	      }
	      
	  // definition du constructeur par defaut
	      @SuppressWarnings("resource")
		public LIvre() {
	    	  
	    	  Scanner clavier = new Scanner(System.in);
	    	  
	    	  /*System.out.println("Entrez le titre : ");
	    	  setTitre(clavier.next());
	    	  
	    	  System.out.println("Entrez la categorie du livre : ");
	    	  setCategorie(clavier.next());
	    	  
	    	  System.out.println("Entrez le nom de l'auteur : ");
	    	  setNomAuteur(clavier.next());
	    	  
	    	  System.out.println("Entrez le prenom de l'auteur : ");
	    	  setPrenom(clavier.next());
	    	  
	    	  System.out.println("Entrez le numero ISBN : ");
	    	  setIsbn(clavier.next());*/
	      }
	      
	  // surcharger de constructeur
	      public LIvre(String t, String c, String na, String pa, String ib) {
	    	  setTitre(t);
	    	  setCategorie(c);
	    	  setNomAuteur(na);
	    	  setPrenom(pa);
	    	  setIsbn(ib);
	      }
	      
	  // Definition des comportements
	      public void afficherUnlivre() {
	    	  System.out.println("Titre : "+titre);
	    	  System.out.println("Auteur : "+nomAuteur+" , "+prenom);
	    	  System.out.println("Categorie : "+categorie);
	    	  System.out.println("ISBN : "+isbn);
	    	  
	    	  // appel de la methode invisible
	    	    System.out.println("Code : "+getCode());
	      }
}
