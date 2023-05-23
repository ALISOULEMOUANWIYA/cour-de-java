package Private;

import java.util.Scanner;

public class LigneComptable {
	
	private double valeur;
	private String date;
	private String motif;
	private String mode;
	
	public void creerLigneComptable() {
		Scanner clavier = new Scanner(System.in);
		
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = clavier.nextDouble();
		
		System.out.print("Date de l'opération [jj/mm/an] ");
		date = clavier.next();
		
		System.out.print("Motif de l'operation [S(alaire),");
		System.out.print(" L(oyer), A(limenation), D(ivers)] : ");
		motif = clavier.next();
		
		System.out.print("Entrer le mode [C(B), N(° Cheque), V(irement ) ] : ");
		mode = clavier.next();
	}
	
	public void afficherLigne()	{
		if (valeur < 0) {
			System.out.print("Débiter : "+valeur);
		}else {
			System.out.print("Créditer : "+valeur);
		}
		System.out.println(" le : "+ date +" motif  : " +motif+ " mode : "+mode);
	}
	
	public double getValeur() {
		return valeur ;
	}
	public String getMotif(){
		return motif ;
	}
	public String getMode(){
		return mode ;
	}
	public String getDate(){
		return date ;
	}
}
