package heritage;

import java.util.Scanner;

public class CpteEpargne extends Compte{
	
	private double taux;
	
	public CpteEpargne() {
		super("Epargne");
		taux = controleTaux();
	}
	
	@SuppressWarnings("resource")
	private double controleTaux() {
		double tmp;
		Scanner clavier = new Scanner(System.in);
		do {
			System.out.println("Taux de placement : ");
			tmp = clavier.nextDouble();
		}while(tmp < 0);
		return tmp;
	}
	
	public void afficherCpte() {
		super.affichercpte();
		System.out.println("Taux d'epargne du compte : "+taux);
	}
	public double getTaux() {
		return taux;
	}
}
