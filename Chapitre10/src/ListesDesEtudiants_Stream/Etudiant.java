package ListesDesEtudiants_Stream;

import java.util.Scanner;

public class Etudiant {
	
private static Scanner clavier = new Scanner(System.in);
	
	private String nom, prenom , matriculeEtud, classeEtud;
	private double [] notes;
	private int nombreNotes;
	private int somestre;
	private double moyenne;
	
	// le constructeur par defaut
		public Etudiant() {
			System.out.print("Entrez la classe de l'etudiant : ");
			classeEtud = clavier.next();
			
			do {
				System.out.print("Entrez son niveau de semestre de l'etudiant : ");
				somestre = clavier.nextInt();
				if(somestre < 0 ||  somestre >  11) {
					System.out.println("desole, un sommestre appartient à une interval de [1 , 10]");
				}
			}while(somestre < 0 ||  somestre >  11);
			
			
			System.out.print("Entrez le nom de l'etudiant : ");
			nom = clavier.next();
			
			System.out.print("Entrez le prenom de l'etudiant : ");
			prenom = clavier.next();
			matriculeEtud = CreerMatriculeEtud();
			   System.out.print("Combien de note voulez-vous attribue "+prenom+" "+nom+" : ");
				nombreNotes = clavier.nextInt();
				notes = new double[nombreNotes];
				for(int i = 0; i < notes.length; i++) {
					System.out.print("notes N(°"+(i+1)+") : ");
					notes[i] = clavier.nextDouble();
				
				moyenne = calculeMoyenne();
				
		   }
			
		}
		
	// Surchage du constructeur 
		public Etudiant(String nomEtud, String prenomEtud, String etudClasse, String matriEtud) {
			nom = nomEtud;
			prenom = prenomEtud;
			classeEtud = etudClasse;
			matriculeEtud = matriEtud ;
			System.out.println("Combien de note voulez-vous attribue à "+prenom+" "+nom+" de la classe "+etudClasse+"  : ");
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
			System.out.println("Les notes de "+prenom+" "+nom+" est de la classe :"+classeEtud+" de la semestre "+somestre);
			System.out.println("Dont ces notes sont : ");
			for(double tmp : notes) {
				System.out.print(" "+tmp);
			}
			System.out.println("\n Sa moyenne = "+moyenne);
			System.out.println("Son matricule est : "+matriculeEtud);
		}
		
		private String CreerMatriculeEtud() {
			String tmp = getNomEtud() + (getPrenomEtud().charAt(0)) + (getClasseEtud().charAt(2)) + (getSemestre());
			tmp.toUpperCase();
			return tmp;
		}
		
		
	// les accesseur 
	   public void setClasseEtud(String valeur) {
		   this.classeEtud = valeur;
	   }
	   public void setNomEtud(String valeur) {
		   this.nom = valeur;
	   }
	   public void setPrenomEtud(String valeur) {
		   this.prenom = valeur;
	   }
	   public void setMatriculeEtud(String valeur) {
		   this.matriculeEtud = valeur;
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
	   public void setSomestre(int valeur) {
		   this.somestre = valeur;
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
	   public int getMoyenne() {
		   return (int) moyenne;
	   }
	   public String getMatriculeEtud() {
		   return matriculeEtud;
	   }
	   public String getClasseEtud() {
		   return classeEtud;
	   }
	   public int getSemestre() {
		   return somestre;
	   }
}
