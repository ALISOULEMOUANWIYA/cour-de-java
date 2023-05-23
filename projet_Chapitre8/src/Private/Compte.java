package Private;

import java.util.Scanner;

import controle.LigneComptable;

public class Compte {
	private String typeCpte;
	private double val_courante, taux;
	private String numeroCpte;
	private LigneComptable ligne;
	private int nbLigneReel;
	
	
	public String getTypeCpte() {
		return typeCpte;
	}
	public double getValeCourante() {
		return val_courante;
	}
	public double getTaux() {
		return taux;
	}
	public String getnumeroCpte() {
		return numeroCpte;
	}
		
	// la methode creerCpte
			 public void creerCpte() {
				 char tmpc ;
				 String car = "";
				 Scanner clavier = new Scanner(System.in);
				 String tmps = "";
				 
				 do { 
					  System.out.println("Type du compte [ Type possible de compte ] : ");
					  System.out.println("            C(courant), J(jointe), E(pargne) : ");
					  tmpc = clavier.next().charAt(0);
					  if(tmpc == 'c') {
						  tmpc = 'C';
					  }else if(tmpc == 'j') {
						  tmpc = 'J';
					  }else {
						  if(tmpc == 'e') {
							  tmpc = 'E';
						  }
					  }
				 }while(tmpc != 'C' && tmpc != 'J' && tmpc != 'E');
				 
				 switch(tmpc){
				 	  case 'C' :  
				 		  tmps = "Courant";
				 	  break;
				 	 case 'J' :  
				 		  tmps = "Joint";
				 	  break;
				 	case 'E' :  
				 		  tmps = "Epargne";
				 	  break;
				 }
				 
				 System.out.println("Numero du compte : ");
				 numeroCpte = clavier.next();
				 if(typeCpte.equalsIgnoreCase("Epargne")) {
					 System.out.println("Taux de placment : ");
					 taux = clavier.nextDouble();
				 }
				 System.out.println(" Valeur initiale du compte : ");
				 val_courante = clavier.nextDouble();
				 nbLigneReel = 0;
			 }
			 
		// la methode creer ligne comptable
			 public void creerLigne() {
				 ligne = new LigneComptable(); 
				 nbLigneReel = 1;
				 val_courante = val_courante + ligne.quellevaleur();
			 }
			 
		// la methode aficher un compte
			 public void afficherCpte() {
				 System.out.println("Le compte N° : "+numeroCpte);
				 System.out.println(" est un compte "+typeCpte);
				 
				 if(typeCpte.equalsIgnoreCase("Epargne")) {
					 System.out.println("Dont le taux est "+taux);
				 }
				 if(nbLigneReel > 0) {
					 ligne.afficherLigne();
				 }
				 if(val_courante < 0) {
					 System.out.println(" Attention compte debiteur ....!!!");
				 }else {
					 System.out.println("valeur courante : "+val_courante);
				 }
			 }
}
