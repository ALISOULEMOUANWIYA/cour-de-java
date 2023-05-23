package ArrayListe;

import java.util.Scanner;

public class Etudiant {
	private static Scanner clavier = new Scanner(System.in);
	
	
	private String nom, prenom;
	private double [] notes;
	private double moyenne;
	private int nombre;
	
	public Etudiant() {	
		System.out.print("Entrez le nom de l'etudiant : ");
		nom = clavier.next();
		System.out.print("Entrez le prenom de l'etudiant : ");
		prenom = clavier.next();
		System.out.print("Entrez le nombre de notes de l'etudiant "+nom+" "+prenom+" : ");
		nombre = clavier.nextInt();
		notes = new double[nombre];
		for(int i = 0; i < nombre; i++) {
			System.out.print("Note N° "+(i+1)+" : ");
			notes[i] = clavier.nextDouble();
		}
		moyenne = CalculeMoyenne();
	}
	
	public Etudiant(int nombreNotes) {	
		System.out.print("Entrez le nom de l'etudiant : ");
		nom = clavier.next();
		System.out.print("Entrez le prenom de l'etudiant : ");
		prenom = clavier.next();
		System.out.println("Entrez les notes de l'etudiant "+nom+" "+prenom+" : ");
		notes = new double[nombreNotes];
		for(int i = 0; i < nombreNotes; i++) {
			System.out.print("Note N° "+(i+1)+" : ");
			notes[i] = clavier.nextDouble();
		}
		moyenne = CalculeMoyenne();
	}
	
	public Etudiant(String NomEtud, String PrenomEtud, int nombreNotes) {	
		System.out.print(" modification des notes de l'etudiant "+NomEtud+" "+PrenomEtud+" : \n");
		nom = NomEtud;
		prenom = PrenomEtud;
		notes = new double[nombreNotes];
		for(int i = 0; i < nombreNotes; i++) {
			System.out.print("Note N° "+(i+1)+" : ");
			notes[i] = clavier.nextDouble();
		}
		moyenne = CalculeMoyenne();
	}
	
	private double CalculeMoyenne() {
		double somme = 0.0;
		for(double moye : notes) {
			somme = somme + moye;
		}
		return somme/notes.length;
	}
	
	public void afficher() {
		System.out.println("Les notes de "+prenom+" "+nom+" sont : ");
		for(double not : notes) {
			System.out.print(" "+not);
		}
		System.out.println("  avec une  de Moyenne = "+moyenne);
	}
	
	// les comicateurs
		public String getNom() {
			return nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public double [] getNote() {
			return notes;
		}
		
		public double getMoyenne() {
			return moyenne;
		}
	
	// les accesseurs
		public void setNom(String valeur) {
			this.nom = valeur;
		}
		public void setPrenom(String valeur) {
			this.prenom = valeur;
		}
		public void getNote(double [] valeur) {
			this.notes = valeur;
		}
		
		public void setMoyenne(double valeur) {
			this.moyenne = valeur;
		}
}
