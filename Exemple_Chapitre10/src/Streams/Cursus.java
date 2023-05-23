package Streams;

import java.util.*;


public class Cursus {
	
	private ArrayList<Etudiant>  liste;
	
	public Cursus() {
		liste = new ArrayList<Etudiant>();
	}
	
	public void ajouterUnetudiant() {
		System.out.println("ok\n\n");
		liste.add(new Etudiant());
	}

	
	/*private String CreerUnecle(String nometud, String prenoEtud, String ClasseEtud, int someEtud) {
		String tmp = nometud + (prenoEtud.charAt(0)) + (ClasseEtud.charAt(2)) + someEtud;
		tmp.toUpperCase();
		return tmp;
	}*/
	
	public void afficherLesEtudiant() {
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0) {
			for(Etudiant etud : liste) {
				etud.afficherUnEtudiant();
			}
		}
	}
	
	public void rechercheUnEtudiant(String MatriculeEtud) {
		for(Etudiant MonCle : liste) {
			if(MonCle.getMatriculeEtud().equalsIgnoreCase(MatriculeEtud)) {
				// creation d'un flux de traitement
				  liste.stream() // pour chaque element du flux, recherche ceux commen�ant par "MatriculeEtud"
				  .filter(e -> e.getMatriculeEtud().startsWith(MatriculeEtud))
				  .forEach(e -> e.afficherUnEtudiant());// Pour element commen�ant par "A"
			}
		}	
	}
	
	public void SuprimerUnEtudiant(String NomEtud, String Prenometud, String matriculeEtud)  
	{
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNomEtud().equalsIgnoreCase(NomEtud) &&  etud.getPrenomEtud().equalsIgnoreCase(Prenometud) && etud.getMatriculeEtud().equalsIgnoreCase(matriculeEtud)) 
				{
					System.out.println("\nSupression d'un etudiant :");
					
					System.out.println(etud.getPrenomEtud()+" "+etud.getNomEtud()+" de la classe "+etud.getClasseEtud()+" qui a les notes : ");
					for(double not : etud.getNotes()) 
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
	
	public void ModifierNotes(String NomEtud, String Prenometud, String matriculeEtud)  
	{
		int nbEtudiant = liste.size();
		String etudClasse = " ";
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNomEtud().equalsIgnoreCase(NomEtud) &&  etud.getPrenomEtud().equalsIgnoreCase(Prenometud) && etud.getMatriculeEtud().equalsIgnoreCase(matriculeEtud)) 
				{
					System.out.println("\n Modificationion de l'etudiant :");
					
					System.out.println(etud.getPrenomEtud()+" "+etud.getNomEtud()+" de la classe "+etud.getClasseEtud()+" qui a les notes : ");
					etudClasse = etud.getClasseEtud();
					
					for(double not : etud.getNotes()) 
					{
						System.out.print("  "+not);
					}
					
					System.out.println("\n Dont sa est Moyenne = "+etud.getMoyenne());
					System.out.println(" debut de Modification");
					
					liste.remove(etud);
					liste.add(new Etudiant(NomEtud, Prenometud, etudClasse, matriculeEtud));
					
					System.out.println("\n Modification reussit !\n");
					
				}else {
					System.out.println(" Cette etudiant n'est pas dans cette liste ");
				}
			}
		}else {
			System.out.println(" Desole, pour l'instant la liste est vide");
		}
	}
	
	public void ModifierEntier(String NomEtud, String Prenometud, String matriculeEtud)  
	{
		int nbEtudiant = liste.size();
		
		if(nbEtudiant > 0)
		{
			for(Etudiant etud : liste) 
			{
				if(etud.getNomEtud().equalsIgnoreCase(NomEtud) &&  etud.getPrenomEtud().equalsIgnoreCase(Prenometud)) 
				{
					System.out.println("\n Modificationion de l'etudiant :");
					
					System.out.println(etud.getPrenomEtud()+" "+etud.getNomEtud()+" qui a les notes : ");
					
					for(double not : etud.getNotes()) 
					{
						System.out.print("  "+not);
					}
					
					System.out.println("Dont sa est Moyenne = "+etud.getMoyenne());
					System.out.println(" debut de Modification");
					
					liste.remove(etud);
					liste.add(new Etudiant());
					
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
