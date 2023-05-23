package heritage;

import java.util.Scanner;

public class Compte {
	
	private String typeCpte;
	protected double val_couante;
	private String numeroCpte;
	private LigneComptable ligne;
	private int nbLigneReel;
	
	
	
	@SuppressWarnings("resource")
	public Compte() {
		Scanner clavier = new Scanner(System.in);
		
		typeCpte = controleType();
		
		System.out.println(" Numero du compte : ");
		numeroCpte = clavier.next();
		
		val_couante = controleValinit();
		nbLigneReel = 0;
	}
	
	@SuppressWarnings("resource")
	public Compte(String type) {
		Scanner clavier = new Scanner(System.in);
		
		if(type.equalsIgnoreCase("Epargne")) {
			System.out.println(" Numero du compte : ");
			numeroCpte = clavier.next();
			
			val_couante = controleValinit();
			nbLigneReel = 0;
		}
	}
	
	@SuppressWarnings("resource")
	private String controleType() {
		Scanner clavier = new Scanner(System.in);
		char tmpc;
		String tmps = "";
		 
		 do { 
			  System.out.println("Type du compte [ Type possible de compte ] : ");
			  System.out.println("            C(courant), J(jointe) : ");
			  tmpc = clavier.next().charAt(0);
			  if(tmpc == 'c') {
				  tmpc = 'C';
			  }else if(tmpc == 'j') {
				  tmpc = 'J';
			  }
		 }while(tmpc != 'C' && tmpc != 'J');
		 
		 switch(tmpc){
		 	  case 'C' :  
		 		  tmps = "Courant";
		 	  break;
		 	 case 'J' :  
		 		  tmps = "Joint";
		 	  break;
		 }
		 return tmps;
	}
	
	@SuppressWarnings("resource")
	private double controleValinit() {
		Scanner clavier = new Scanner(System.in);
		
		double tmpval;
		do {
			System.out.println("Valeur initiale du compte : ");
			tmpval = clavier.nextDouble();
		}while(tmpval <= 0);
		return tmpval;
	}
	
	public void creerLigne() {
		ligne = new LigneComptable();
		nbLigneReel = 1;
		val_couante = val_couante + ligne.getValeur();
	}
	
	public void affichercpte() {
		System.out.println("Le compte N° : "+numeroCpte);
		System.out.println(" est un compte "+typeCpte);
		 
		 if(nbLigneReel > 0) {
			 ligne.afficherLigne();
		 }
		 if(val_couante < 0) {
			 System.out.println(" Attention compte debiteur ....!!!");
		 }else {
			 System.out.println("valeur courante : "+val_couante);
		 }
	}
	
	public String getTypeCpte() {
		return typeCpte;
	}
	
	public double getValCourante() {
		return val_couante;
	}
	
	public String getNumeroCpte() {
		return numeroCpte;
	}
	
	
	
	
}
