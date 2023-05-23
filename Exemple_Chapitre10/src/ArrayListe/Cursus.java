package ArrayListe;

import java.util.ArrayList;


public class Cursus {
	
	private ArrayList<Etudiant>liste;
	
	// le constructuer par defaut
	public Cursus() {
		liste = new ArrayList<Etudiant>();
	}
	
	// la methode ajouter un etudiant 
	public void ajouterEtudiant() {
		liste.add(new Etudiant());
	}
	
	// la methode afficher un etudiant 
	public void afficherLesEtudiants() {
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0) {
			for(Etudiant etud : liste) {
				etud.afficher();
			}
		}else {
			System.out.println("Il n'y a pas d'etudiant dans cette liste ");
		}
	}
	
	// la methode rechercher un etudiant par son nom et son prenenom
	public void recherche(String NomEtud, String Prenometud) 
	{
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0) 
		{
			for(Etudiant etud : liste)
			{
				if(etud.getNom().equalsIgnoreCase(NomEtud) &&  etud.getPrenom().equalsIgnoreCase(Prenometud))
				{
					System.out.println("Les notes de "+etud.getPrenom()+" "+etud.getNom()+" sont : ");
					for(double not : etud.getNote()) 
					{
						System.out.print("  "+not);
					}
					System.out.println("avec une  de Moyenne = "+etud.getMoyenne());
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
	
	// la methode rechercher un etudiant par son nom et son prenom et sa classe 
	public void rechercheClasse(String ClasseEtud,String NomEtud, String Prenometud) 
	{
		int nbEtudiant = liste.size();
		if(nbEtudiant > 0) 
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNom().equalsIgnoreCase(ClasseEtud) ) 
				{
					if(etud.getNom().equalsIgnoreCase(NomEtud) &&  etud.getPrenom().equalsIgnoreCase(Prenometud)) 
					{
						System.out.println("Les notes de "+etud.getPrenom()+" "+etud.getNom()+" sont : ");
						for(double not : etud.getNote()) 
						{
							System.out.print("  "+not);
						}
						System.out.println("avec une  de Moyenne = "+etud.getMoyenne());
					}
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
	
	
	// suprimer un etudiant en le cherchant par son nom et son prenom
	public void Suprimer(String NomEtud, String Prenometud)  
	{
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNom().equalsIgnoreCase(NomEtud) &&  etud.getPrenom().equalsIgnoreCase(Prenometud)) 
				{
					System.out.println("\nSupression d'un etudiant :");
					
					System.out.println("Les notes de "+etud.getPrenom()+" "+etud.getNom()+" sont : ");
					for(double not : etud.getNote()) 
					{
						System.out.print("  "+not);
					}
					System.out.println("Dont sa est Moyenne = "+etud.getMoyenne());
					
					
					System.out.println("\n Supression reussit !\n");
					liste.remove(etud);
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
	
	
	// modifier les notes de l'etudiant uniquement en le cherchant par son nom et son prenom
	public void ModifierNotes(String NomEtud, String Prenometud)  
	{
		int nbEtudiant = liste.size();
		int nombreNotes = 0;
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNom().equalsIgnoreCase(NomEtud) &&  etud.getPrenom().equalsIgnoreCase(Prenometud)) 
				{
					System.out.println("\n Modificationion de l'etudiant :");
					
					System.out.println(etud.getPrenom()+" "+etud.getNom()+" qui a les notes : ");
					
					for(double not : etud.getNote()) 
					{
						System.out.print("  "+not);
						nombreNotes++;
						
					}
					
					System.out.println("\n Dont sa est Moyenne = "+etud.getMoyenne());
					System.out.println(" debut de Modification");
					
					liste.remove(etud);
					liste.add(new Etudiant(NomEtud, Prenometud, nombreNotes));
					
					System.out.println("\n Modification reussit !\n");
					
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
	// modifier les données de l'etudiant en le cherchant par son nom et son prenom
	public void ModifierEntier(String NomEtud, String Prenometud)  
	{
		int nbEtudiant = liste.size();
		int nombreNotes = 0;
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNom().equalsIgnoreCase(NomEtud) &&  etud.getPrenom().equalsIgnoreCase(Prenometud)) 
				{
					System.out.println("\n Modificationion de l'etudiant :");
					
					System.out.println(etud.getPrenom()+" "+etud.getNom()+" qui a les notes : ");
					
					for(double not : etud.getNote()) 
					{
						System.out.print("  "+not);
						nombreNotes++;
					}
					
					System.out.println("Dont sa est Moyenne = "+etud.getMoyenne());
					System.out.println(" debut de Modification");
					
					liste.remove(etud);
					liste.add(new Etudiant(nombreNotes));
					
					System.out.println("\n Modification reussit !\n");
					
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
}
