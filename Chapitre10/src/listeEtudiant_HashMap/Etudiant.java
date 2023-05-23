package listeEtudiant_HashMap;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant {
	
	private String nom, prenom, classeEtudiant;
	private int semestre;
	private int nombreNotes;
	private double moyenne;
	private ArrayList<Double> note;
	
	private static Scanner clavier = new Scanner(System.in);
	
	// le construteur par defaut 
		@SuppressWarnings("deprecation")
		public Etudiant() {
			System.out.println(" Inscription d'un Etudiant \n");
			
			System.out.print("Entrez sa classe : ");
			classeEtudiant = clavier.next();
			
			System.out.print("Entrez le semestre d'inscription : ");
			semestre = clavier.nextInt();
			
			System.out.print("Entrez le nom de l'etudiant : ");
			nom = clavier.next();
			
			System.out.print("Entrez le prenom de l'etudiant : ");
			prenom = clavier.next();
			
			System.out.println("Entrez le nombre de note de l'etudiant "+prenom+" "+nom+" : ");
			nombreNotes = clavier.nextInt();
			note = new ArrayList<Double>();
			for(int i = 0; i < nombreNotes; i++) {
				System.out.print("Entrez la notes N°"+(i+1)+" : ");
				note.add( new Double(clavier.nextDouble()));
			}
			
			moyenne = calculeMoyenne();
		}
	
	// Surchage du constructeur 
		@SuppressWarnings("deprecation")
		public Etudiant(String nomEtud, String prenomEtud, String classeEt, int semestreEt) {
			nom = nomEtud;
			prenom = prenomEtud;
			System.out.println("Combien de note voulez-vous attribue "+prenom+" "+nom+" : ");
			nombreNotes = clavier.nextInt();
			note = new ArrayList<Double>();
			for(int i = 0; i < nombreNotes; i++)  {
				System.out.print("notes N(°"+(i+1)+") : ");
				note.add( new Double(clavier.nextDouble()));
			}
			
			moyenne = calculeMoyenne();
		}
    // la methode calculer la moyenne de l'etudiant
		private int calculeMoyenne() {
			double tmp = 0.0;
			int longueurCellule = note.size();
			for(double val : note) {
				tmp = tmp + val;
			}
			return (int) tmp/longueurCellule;
		}
	// le methode afficher l'etudiant
		public void afficherUnEtudiant() {
			int i = 0;
			int longueurCellule = note.size();
			System.out.println(longueurCellule+"\n");
			System.out.println("L'Etudiant "+prenom+" "+nom);
			System.out.print("A : ");
			for(double val : note) {
				if(i == 0) {
					System.out.print(" "+val);
				}else if(i > 0) {
					System.out.print(" , "+val);
				}
				i++;
			}
			System.out.println(" Et sa moyenne = "+moyenne);
		}
	
	// les accesseur 
		public String getNomEtudiant() {
			return nom ;
		}
		public String getPreNomEtudiant() {
			return prenom;
		}
		public int getNombreNotesEtudiant() {
			return nombreNotes;
		}
		public ArrayList<Double> getNotesEtudiant() {
			return note;
		}
		public double getMoyenneEtudiant() {
			return moyenne;
		}
		public int getSemestre() {
			return semestre;
		}
		public String getClasse() {
			return classeEtudiant;
		}
	
	// les commitateur 
		public void setNomEtudiant(String valeur) {
			this.nom = valeur;
		}
		public void setPreNomEtudiant(String valeur) {
			this.prenom = valeur;
		}
		public void setNombreNotesEtudiant(int valeur) {
			this.nombreNotes = valeur;
		}
		public void setNotesEtudiant(ArrayList<Double> valeur) {
			this.note = valeur;
		}
		public void setMoyenneEtudiant(int valeur) {
			this.moyenne = valeur;
		}
}
