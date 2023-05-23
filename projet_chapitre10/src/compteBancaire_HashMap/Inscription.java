package compteBancaire_HashMap;

import java.io.Serializable;
import java.util.Scanner;



public class Inscription implements Serializable{
	
	private static final long serialVersionUID = 1L;

private static Scanner clavier = new Scanner(System.in);
	
	private int nbLigneReel;
	
	public static final int limite = 10;
	
	protected double val_courante;
	private String numeroCpte;
	private String typeCpte;
	private String CodeCompte;
	private LigneComptable [] ligne;
	
	
	// Constructeur par defaut 
		public Inscription() {
			typeCpte = controleType();
			System.out.println("Numero du compte : ");
			numeroCpte = clavier.next();
			val_courante = controleValinit();
			ligne = new LigneComptable[limite];
			nbLigneReel=-1;
		}
	
	// surcharge du constructeur
		public Inscription(String type) {
			if(type.equalsIgnoreCase("Epargne"));{
				typeCpte = type;
				System.out.println("Numero du compte : ");
				numeroCpte = clavier.next();
				val_courante = controleValinit();
				ligne = new LigneComptable[limite];
				nbLigneReel=-1;
			}
		}
	
	// encapsulation de la methode controler le type du compte
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
			for(int i = 1; i < limite; i++ ) {
				ligne[i - 1] = ligne[i];
			}
		}
		
	// la methode afficher une compteble
		public void afficherCpte() {
			System.out.println("Le compte N° : "+numeroCpte);
			System.out.println("est un compte "+typeCpte);
			System.out.println("Code du compte : "+CodeCompte);
			//System.out.println("nombre de cellule = "+nbcelulle);
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
		public String getCodeCompte() {
			return CodeCompte;
		}
		public double getValeurCourante() {
			return val_courante;
		}
		public int getNbLigneReel() {
			return nbLigneReel;
		}
		public LigneComptable [] getligne() {
			return ligne;
		}
		public String getInfo() {
			  return " - Le compte N° : "+getNumeroCompte()+";\n"
		             +" - est un compte : "+getTypeCompte()+";\n"
					 +" - Code du compte : "+getCodeCompte()+";\n"
		             +" - Valeur courante : "+getValeurCourante()+"\n";
		 }
		
	// les Commitatuer 
		public void setTypeCompte(String valeur) {
			this.typeCpte = valeur;
		}
		public void setNumeroCompte(String valeur) {
			this.numeroCpte = valeur;
		}
		public void setCodeCompte(String valeur) {
			this.CodeCompte = valeur;
		}
		public void setValeurCourante(double valeur) {
			this.val_courante = valeur;
		}
		public void setNbLigneReel(int valeur) {
			this.nbLigneReel = valeur;
		}
		public void setligne( LigneComptable [] valeur) {
			this.ligne = valeur;
		}
		
}
