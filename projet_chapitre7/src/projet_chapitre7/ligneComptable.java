package projet_chapitre7;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ligneComptable {
	public double valeur;
	public String date ;
	public String motif;
	public String mode;
	
	@SuppressWarnings("resource")
	public void creerLigneComptable() {
		 LocalDateTime now = LocalDateTime.now();
		Scanner clavier = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);  
        
		System.out.println("Entrez la valeur à crediter (+) ou debiter (-) : ");
		valeur = clavier.nextDouble();
		
		System.out.println(" Date de l'operation : "+formatDateTime);
		date = formatDateTime;
		
		System.out.print(" Entrez le motif [S(salaire), L(loyer), A(alimentation)] : ");	
		motif = clavier.next();
		
		System.out.print(" Entrez le mode [C(B), N(°cheque), V(virement)] : ");
		mode = clavier.next();
	}
	
	public void afficherLigne() {
		if(valeur < 0) {
			System.out.println("Debiter : "+valeur);
		}else {
			System.out.println("crediter : "+valeur);
		}
		System.out.println("le : "+date+", motif : "+motif+", mode : "+mode);
	}
}
