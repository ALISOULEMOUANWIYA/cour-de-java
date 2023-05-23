package trier;

import java.util.Scanner;

public class Cursus {
	
	public static Scanner clavier = new Scanner(System.in);
	
	// tableau à une dimension
	private Etudiant [] liste;
	
	// le constructeur par defaut
	   @SuppressWarnings("unused")
	  public Cursus() {
		   System.out.print("Nombre d'etudiant : ");
		   int nbEtudiant = clavier.nextInt();
		   
		   liste = new Etudiant[nbEtudiant];
		   for(int j = 0; j < liste.length; j++) {
			   liste[j] = new Etudiant();
		   }
	   }
	 
	// la methode afficher
	   public void afficher() {
		   for(int i = 0; i < liste.length; i++) {
			   liste[i].afficheUnEtidiant();
		   }
	   }
	  
	   
	   
/******************************* Methode de triage 1 ***************************************/
	 // encapsulation du methode 
	   private int ouEstLePlusPetit(int debut) {
		   int i = debut;
		   for(int j = 0; j < liste.length; j++) {
			   
			   // du plus grand au plus petit moyenne
			   if(liste[j].getMoyenne() < liste[i].getMoyenne()) {
				   i = j;
			   }
			   
			   /*
			      // du plus petit au plus grand moyenne 
					   if(liste[j].getMoyenne() > liste[i].getMoyenne()) {
						   i = j;
					   }
			   */
		   } 
		   return i;
	   }
	   
	 // la methode classer les mayenne
	   public void classerParMoyenne() {
		   int i;
		   Etudiant tmp;
		   for(int j = 0; j < liste.length; j++) {
			   i = ouEstLePlusPetit(j);
			   
			   tmp = liste[j];
			   liste[j] = liste[i];
			   liste[i] = tmp;
		   }
	   }
/******************************* Methode de triage 2 du plus grand au plus petit moyenne ***************************************/
	   public void triageMoyenne() {
		   Etudiant tmp;
		   
		   for(int i = 0; i < liste.length - 1; i++) 
		   {
			   for(int j = i+1; j < liste.length; j++) 
			   {
				   // du plus petit au plus grand moyenne 
					   if(liste[i].getMoyenne() >= liste[j].getMoyenne()) {
						   tmp =  liste[i];
						   liste[i] = liste[j];
						   liste[j] = tmp;
					   }
				  /*
				    // du plus grand au plus petit moyenne
				   	   if(liste[i].getMoyenne() < liste[j].getMoyenne()) {
						   tmp =  liste[i];
						   liste[i] = liste[j];
						   liste[j] = tmp;
					   }
				  */
				  
			   }
		   }
	   }
}
