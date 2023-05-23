package exemple;

import java.util.Scanner;

public class Statistique {

	public static void main(String[] args) {
		
		int nbCB , nbcheque, nbVirement, nbDebit;
		double prctCb, prctCh, prctVi;
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Nombre d'achat par cartes bleues : ");
		nbCB = clavier.nextInt();
		
		System.out.println("Nombre de cheque emis : ");
		nbcheque = clavier.nextInt();		

		System.out.println("Nombre de virement automatique : ");
		nbVirement = clavier.nextInt();	
		
		nbDebit = nbCB + nbcheque + nbVirement;
		prctCb = (double)nbCB / nbDebit*100;
		prctCh = (double)nbcheque / nbCB*100;
		prctVi = (double)nbVirement / nbCB*100;
		
		System.out.println("vous avez emis "+nbDebit+" odres de debit ");
		System.out.println(" dont "+prctCb+ " % par carte bleu ");
		System.out.println("      "+prctCh+ " % par cheque ");
		System.out.println("      "+prctVi+ " % par virement automatiques ");
	}

}
