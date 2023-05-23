package Forme2;

import java.util.Scanner;

public class cpteEpargne  extends Compte{
	
	private double taux;
	private static Scanner clavier = new Scanner(System.in);
	
	public cpteEpargne() {
		super("Epargne");
		taux = controleTaux();
	}
	
	private double controleTaux() {
		double tmp;
		do {
			System.out.println("Taux de placement : ");
			tmp = clavier.nextDouble();
		}while(tmp < 0);
		return tmp;
	}
	
	public void afficherCpte() {
		super.afficherCpte();
		System.out.println("taux d'epargne u compte : "+taux);
	}
	
	public double getTaux() {
		return taux;
	}
}
