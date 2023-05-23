package trier;

import java.util.Scanner;

public class Etudiant {
	
	private static Scanner clavier = new Scanner(System.in);
	
	private String nom, prenom;
	private double [] notes;
	private double moyennes;
	private int nombre;
	
	public Etudiant() {
		System.out.print("Entrez le nom de l'etudiant : ");
		nom = clavier.next();
		
		System.out.print("Entrez le nom de l'etudiant : ");
		prenom = clavier.next();
		
		System.out.print(" combient de note pour l'etudiant "+prenom+" "+nom+" : ");
		nombre = clavier.nextInt();
		notes = new double[nombre];
		
		for(int i = 0; i < notes.length; i ++) {
			System.out.println("Entrez la notes numero  numero "+(i+1)+" : ");
			notes[i] =clavier.nextDouble();
		}
		moyennes = calculeMoyenne();
	}
	
	public void afficheUnEtidiant() {
		System.out.println("Les notes de "+prenom+" "+nom+" sont : ");
		for(double valeur : notes) {
			System.out.println(" "+valeur);
		}
		System.out.println();
		System.out.println("Sa moyenne vaut "+moyennes);
	}
	
	private double calculeMoyenne() {
		double somme = 0.0;
		for(double valeur : notes) {
			somme = somme + valeur;
		}
		return somme/notes.length ;
	}
	
	// Un commitateur
	   public double getMoyenne() {
		   return moyennes;
	   }
	
}
