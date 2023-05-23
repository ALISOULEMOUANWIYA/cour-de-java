package projet_chapitre7;

import java.util.Scanner;

public class compte {
	
	// les variables caracterisant un compte son declarees comme variables de classe 
	public String typeCpte;
	public double val_courant, taux;
	public String numeroCpte;
	public ligneComptable ligne;
	public int nbLigneReel;
	
	
	
	@SuppressWarnings("resource")
	public void creerCpte() {
		Scanner clavier = new  Scanner(System.in);
		char tmp ;
		
		do {
			System.out.print("type du compte [types Possible : ");
			System.out.println("C (courant), J(joint), E(epargne)] : ");
			tmp = clavier.next().charAt(0);
		}while(tmp != 'C' && tmp != 'J' && tmp != 'E');
		
		switch(tmp) {
		    case 'C' : typeCpte = "Courant";
		    break;
		    case 'J' : typeCpte = "Joint";
		    break;
		    case 'E' : typeCpte = "Epargne";
		    break;
		}
		System.out.print("Numero du compte : ");
		numeroCpte = clavier.next();
		if(typeCpte.equalsIgnoreCase("Epargne")) {
			System.out.println("Taux de placement");
			taux = clavier.nextDouble();
		}
		System.out.print("valeur initiale du compte : ");
		val_courant = clavier.nextDouble();
		nbLigneReel = 0;
	}
	
	public void creerLigne() {
		ligne = new ligneComptable();
		ligne.creerLigneComptable();
		nbLigneReel = 1;
		val_courant = val_courant + ligne.valeur;
	}
	
	public void afficherCpte() {
		System.out.println("le compte n° : "+numeroCpte+" est un compte "+typeCpte);
		if(typeCpte.equalsIgnoreCase("Epargne")) {
			System.out.println("dont le taux est "+taux);
		}
		if(nbLigneReel > 0) {
			ligne.afficherLigne();
		}
		System.out.println("Valeur courant : "+val_courant);
	}

}
