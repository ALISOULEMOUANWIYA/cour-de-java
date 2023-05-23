package heritage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LigneComptable {
	
	private double valeur;
	private String motif;
	private String mode;
	private String date;
	
	@SuppressWarnings("resource")
	public LigneComptable() {
		
		double valeurChoix = 0.0;
        char car;
        byte rappel = 1;
        
        LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);
        
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("<::::::::::::::::::::::::::: Vous voulez ::::::::::::::::::::::::::>");
		System.out.println("      (C) --> [ crediter(+) ] ou (D) --> [ debiter (-) ] : ");
		do {
			car = clavier.next().charAt(0);
			if(car == 'C' || car == 'c') {
				System.out.println("\t\t Entrez la valeur à  crediter (+) : ");
				valeurChoix = clavier.nextDouble();
				if(valeurChoix < 0) {
					valeurChoix *= (-1);
				}
			}else if(car == 'd' || car == 'D'){
				System.out.println("\t\t Entrez la valeur à D [debiter(-)] : ");
				valeurChoix -= clavier.nextDouble();
			}
				
		}while(rappel != 1);
		  valeur = valeurChoix;
		  
		  System.out.println(" Date de l'operation : "+formatDateTime);
		  date = formatDateTime;
		  
		  motif = controleMotif();
		  mode = controleMode();
	}
	
	@SuppressWarnings("resource")
	private String controleMotif() {
		
		Scanner clavier = new Scanner(System.in);
		String tmps = "";
		char tmpc;
		
		do { 
			  System.out.println("Motif de l'operation [S(salaire),L(loyer), A(alimentation), Divers) : ");
			  tmpc = clavier.next().charAt(0);
			  if(tmpc == 's') {
				  tmpc = 'S';
			  }else if(tmpc == 'l') {
				  tmpc = 'L';
			  }else {
				  if(tmpc == 'a') {
					  tmpc = 'A';
				  }else {
					  if(tmpc == 'd') {
						  tmpc = 'D';
					  }
				  }
			  }
		 }while(tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
		 
		 switch(tmpc){
		 	  case 'S' :  
		 		  tmps = "Salaire";
		 	  break;
		 	 case 'L' :  
		 		  tmps = "Loyer";
		 	  break;
		 	case 'A' :  
		 		  tmps = "Alimentation";
		 	  break;
		 	case 'D' :  
		 		  tmps = "Divers";
		 	  break;
		 }
		 return tmps;
	}
	
	@SuppressWarnings("resource")
	private String controleMode() {
		Scanner clavier = new Scanner(System.in);
		String tmps = "";
		char tmpc;
		do { 
			  System.out.println("Mode [ C(B), N(°cheque), V(virmement) ] : ");
			  tmpc = clavier.next().charAt(0);
			  if(tmpc == 'c') {
				  tmpc = 'C';
			  }else if(tmpc == 'N') {
				  tmpc = 'N';
			  }else {
				  if(tmpc == 'V') {
					  tmpc = 'V';
				  }
			  }
		 }while(tmpc != 'C' && tmpc != 'N' && tmpc != 'V');
		 
		switch (tmpc) {
			case 'C' : tmps = "CB";
			break;
			case 'N' : tmps = "Cheque";
			break;
			case 'V' : tmps = "Virement";
			break;		
		}
		 return tmps; 
	}
	
	public double getValeur() {
		return valeur;
	}
	
	public String getMotif() {
		return motif;
	}
	
	public String getMode() {
		return mode;
	}
	
	public String getDate() {
		return date;
	}
	
	public void afficherLigne() {
		if(valeur < 0) {
			System.out.println("debiter : "+valeur);
		}else {
			System.out.println("Crediter : "+valeur);
		}
		System.out.println("le : "+date+", motif : "+motif+", mode : "+mode);
	}
}
