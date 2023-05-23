package compteBancaire_HashMap;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LigneComptable implements Serializable{

	private static final long serialVersionUID = 1L;

private static Scanner clavier = new Scanner(System.in);
	
	private double valeur;
	private String date;
	private String motif;
	private String mode;
	
	public LigneComptable() {
		char car;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);
		
		
		System.out.println("<::::::::::::::::::::::::::: Vous voulez ::::::::::::::::::::::::::>");
		System.out.print(" [C]rediter (+) ou [D]ebiter(-)  ( D ou C )  : ");
		car = clavier.next().charAt(0);
		do {
			if(car != 'd') {
				car = 'D';
			}else {
				if(car != 'c') {
					car = 'C';
				}else {
					car = 'a';
					System.out.println("Désole cette valeur n'est pas prise en charge \n");
				}
			}
		}while(car != 'D' || car != 'C');
		
		if(car == 'D') {
			System.out.print("_n Entrez la valeur à Debiter (-) : ");
			valeur = clavier.nextDouble();
			if(valeur > 0) {
				valeur *= (-1);
			}
		}else if(car == 'C') {
			System.out.print("\n Entrez la valeur à Crediter (+) : ");
			valeur = clavier.nextDouble();
			if(valeur < 0) {
				valeur *= (-1);
			}
		}
		
		 System.out.println(" Date de l'operation : "+formatDateTime);
		  date = formatDateTime;
		  
		  motif = controleMotif();
		  mode = controleMode();
	}
	
	private String controleMotif() {
		String tmps = "";
		char tmpc;
		do {
			System.out.println("Motif [S(alaire), L(oyer), A(limentation), D(ivers) ] : ");
			tmpc = clavier.next().charAt(0);
		}while(tmpc != 'S' &&  tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
		
		switch(tmpc) {
			case 'S':
				tmps = "SALAIRE";
			break;
			case 'L':
				tmps = "LOYER";
			break;
			case 'A':
				tmps = "ALIMENTATION";
			break;
			case 'd':
				tmps = "DIVERS";
			break;
		}
		return tmps;
	 }
	
	private String controleMode() {
		String tmps = "";
		char tmpc;
		do {
			System.out.println("Mode [C(B), n(° Cheque), V(irement) ] : ");
			tmpc = clavier.next().charAt(0);
		}while(tmpc != 'C' &&  tmpc != 'N' && tmpc != 'V');
		
		switch(tmpc) {
			case 'C':
				tmps = "CB";
			break;
			case 'N':
				tmps = "Cheque";
			break;
			case 'V':
				tmps = "Virement";
			break;
		}
		return tmps;
	}
	
	
	public void afficherLigne() {
		if(valeur < 0) {
			System.out.println("debiter : "+valeur);
		}else {
			System.out.println("Crediter : "+valeur);
		}
		
		System.out.println("Le : "+date+", motif : "+motif+", mode : "+mode);
	}
	
	public double getValeur() {
		return valeur;
	}
	
	public String getMotif() {
		return motif;
	}
	
	public String getmode() {
		return mode;
	}
	
	public String getDate() {
		return date;
	}
}
