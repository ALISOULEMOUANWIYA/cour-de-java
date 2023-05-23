package Forme2;

import java.util.*;

public class Compte {
	
	private static Scanner clavier = new Scanner(System.in);
	
	private int nbLigneReel ;
	private int nbcelulle = 0;
	protected double val_courante;
	private String numeroCpte;
	private String typeCpte;
	
    public static  int NBligne = 0;
    public static final int limite = 10;
	
	private LigneComptable [] ligne;
	
	// constructeur par defaut
		public Compte() {
			NBligne++;
			typeCpte = controleType();
			
			System.out.print("numero du compte : ");
			numeroCpte = clavier.next();
			
			val_courante = controleValinit();
			ligne = new LigneComptable[limite];
			
			nbLigneReel = -1;
		}

	// surcharge du constructeur 
		public Compte(String type) {
			if(type.equalsIgnoreCase("Epargne")) {
				typeCpte = type;
				
				System.out.println("Numero du compte : ");
				numeroCpte = clavier.next();
				
				val_courante = controleValinit();
				ligne = new LigneComptable[limite];
				
				nbLigneReel = -1;
			}
			
		}
	
	// encapsulationde la methode controler le type de compte 
		private String controleType() {
			char tmpc;
			String tmps = "";
			
			do {
				System.out.print("type du compte [type possible  C(ourante), J(ointe) ]  : ");
				tmpc = clavier.next().charAt(0);
				if(tmpc == 'c') {
					tmpc = 'C';
				}else if(tmpc == 'j') {
					tmpc = 'J';
				}else {
					if(tmpc == 'C' || tmpc == 'J') {
						System.out.print("Ok, Entrez le ");
					}else {
						System.out.println("valeur non prise en charge ");
					}
					
				}
			}while(tmpc != 'C' && tmpc != 'J');
			
			switch(tmpc) {
				case 'C' :
					tmps = "Courante";
				break;
				case 'J':
					tmps = "Jointe";
				break;
			}
			return tmps;
		}

	// encapsulation de la methode controller la valeur initiale 
		private double controleValinit() {
			double tmpval;
			
			do {
				 System.out.println("Valeur initiale du compte  : ");
				 tmpval = clavier.nextDouble();
			}while(tmpval <= 0);
			
			return tmpval;
		}
	
	// la methode creer une ligne compteble
		public void creerLigne() {
			nbLigneReel++;
			if(nbLigneReel <= limite) {
				ligne[nbLigneReel] = new LigneComptable();
			}else {
				nbLigneReel--;
				decalerLesLigne();
				ligne[nbLigneReel] = new LigneComptable();
				
			}
		}
		
	// la methode decaler les ligne compteble
		public void decalerLesLigne() {
			for(int i = 1; i < limite
					; i++ ) {
				ligne[i - 1] = ligne[i];
			}
		}
		
	// la methode afficher une compteble
		public void afficherCpte() {
			System.out.println("Le compte N° : "+numeroCpte);
			System.out.println("est un compte "+typeCpte);
			System.out.println("nombre de cellule = "+nbcelulle);
			if(nbLigneReel  >= 0) {
				for(int i = 0; i < nbLigneReel ; i++) {
					ligne[i].afficherLigne();
				}
			} 
			if(val_courante > 0) {
				System.out.println("Valeur courante : "+val_courante);
			}else {
				System.out.println("Attention compte debiteur .... !!!!");
			}
		}
		
	// les accesseurs 
		public String getTypeCompte() {
			return typeCpte;
		}
		public String getNumeroCompte() {
			return numeroCpte;
		}
		public double getValeurCourante() {
			return val_courante;
		}
	
}
