package LesFichier.FichierObjets;

import java.io.Serializable;
import java.util.*;

public class Etudiant implements Serializable{
	
private static Scanner clavier = new Scanner(System.in);
	
	private String nom, prenom;
	private double [] notes;
	private int nombreNotes;
	private double moyenne;
	
	// le constructeur par defaut
		public Etudiant() {
			System.out.println("Entrez le nom de l'etudiant : ");
			nom = clavier.next();
			
			System.out.println("Entrez le prenom de l'etudiant : ");
			prenom = clavier.next();
			
			System.out.println("Combien de note voulez-vous attribue "+prenom+" "+nom+" : ");
			nombreNotes = clavier.nextInt();
			notes = new double[nombreNotes];
			for(int i = 0; i < notes.length; i++) {
				System.out.print("notes N(°"+(i+1)+") : ");
				notes[i] = clavier.nextDouble();
			}
			
			moyenne = calculeMoyenne();
		}
		
	// Surchage du constructeur 
		public Etudiant(String nomEtud, String prenomEtud) {
			nom = nomEtud;
			prenom = prenomEtud;
			System.out.println("Combien de note voulez-vous attribue "+prenom+" "+nom+" : ");
			nombreNotes = clavier.nextInt();
			notes = new double[nombreNotes];
			for(int i = 0; i < notes.length; i++) {
				System.out.print("notes N(°"+(i+1)+") : ");
				notes[i] = clavier.nextDouble();
			}
			
			moyenne = calculeMoyenne();
		}
	
	// encapsulation de la methode caluler les moyennes
		private double calculeMoyenne() {
			double somme = 0.0;
			for(int i = 0; i < notes.length; i++) {
				somme  = somme + notes[i];
			}
			
			return somme/notes.length;
		}
	
    //la methode afficher un etudiant
		public void afficherUnEtudiant() {
			System.out.println("Les notes de "+prenom+" "+nom+" sont : ");
			for(double tmp : notes) {
				System.out.print(" "+tmp);
			}
			System.out.println("\n Sa moyenne = "+moyenne);
		}
		
		
	// les accesseur 
	   public void setNomEtud(String valeur) {
		   this.nom = valeur;
	   }
	   public void setPrenomEtud(String valeur) {
		   this.prenom = valeur;
	   }
	   public void setNombreNotes(int valeur) {
		   this.nombreNotes = valeur;
	   }
	   public void setNotes(double [] valeur) {
		   this.notes = valeur;
	   }
	   public void setMoyenne(double valeur) {
		   this.moyenne = valeur;
	   }
	// les commitateur
	   public String getNomEtud() {
		   return nom;
	   }
	   public String  getPrenomEtud() {
		   return prenom;
	   }
	   public int getNombreNotes() {
		   return nombreNotes;
	   }
	   public double [] getNotes() {
		   return notes;
	   }
	   public double getMoyenne() {
		   return moyenne;
	   }
}
