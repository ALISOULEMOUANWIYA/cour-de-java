package controle;

import java.util.Scanner;

public class Compte {
	
	private String typeCpte;
	private double val_courante, taux;
	private String numeroCpte;
	private LigneComptable ligne;
	private int nbLigneReel;
	
	// le constructeur par defaut
		 public Compte() {
			 Scanner clavier= new Scanner(System.in);
			 
			 typeCpte = controleType();
			 
			 System.out.println("Numero du compte : ");
			 numeroCpte = clavier.next();
			 if(typeCpte.equalsIgnoreCase("Epargne")) {
				 System.out.println("Taux de placment : ");
				 taux = clavier.nextDouble();
			 }
			 
			 val_courante = controleValeurInit();
			 nbLigneReel = 0;
		 }
		 
	// surcharge du constructeur
		 public Compte(String num) {
			 numeroCpte = num;
			 nbLigneReel = 0;
		 }
		 
	// returner les valeur declarer à private
		 public String quelTypeDeCompte() {
			 return typeCpte;
		 }
	
    // returner les valeur declarer à private
		 public String quelNumeroCompte() {
			 return numeroCpte;
		 }
		 
	// returner les valeur declarer à private
		 public double quelValeurCourant() {
			 return val_courante;
		 }
	
    // returner les valeur declarer à private
		 public double quelTaux() {
			 return taux;
		 }
	
    // controller le type de compte
		 private String controleType() {
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
			 return tmps;
		 }
		 
	 // controller la valeur initiale saisie par l'utilisateur
		 private double controleValeurInit() {
			 double tmpval;
			 Scanner clavier = new Scanner(System.in);
			 do {
				  System.out.println(" Valeur initiale du compte : ");
				  tmpval = clavier.nextDouble();
			 }while(tmpval <= 0);
			 return tmpval;
		 }
		 
	// la methode creer compte 
		 public void creerCpt() {
			 Scanner clavier = new Scanner(System.in);
			 
			 typeCpte = controleType();
			 System.out.print("Numero du compre :  ");
			 
			 if(typeCpte.equalsIgnoreCase("Epargne")) {
				 System.out.println("Taux de deplacement : ");
				 taux = clavier.nextDouble();
			 }
			 
			 val_courante = controleValeurInit();
			 
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
