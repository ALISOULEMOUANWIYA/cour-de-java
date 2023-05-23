package compteBancaire_HashMap;

import java.io.Serializable;
import java.util.Scanner;

public class CompteEpargne extends Inscription implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private double taux;
	private static Scanner clavier = new Scanner(System.in);
	
	public CompteEpargne() {
		super("Epargne");
		taux = controleTaux();
	}
	
	private double controleTaux() {
		double tmp;
		do {
			System.out.print("Entrez le taux de deplacement : ");
			tmp = clavier.nextDouble();
		}while(tmp < 0);
		return tmp;
	}
	
	public void afficherCpte() {
		super.afficherCpte();
		System.out.println("taux d'epargne du compte : "+taux);
		System.out.println("\n");
	}
	
	public double getTaux() {
		return taux;
	}
	
	public String getInfo() {
		String tmp;
		tmp = super.getInfo();
		return tmp+" - taux d'epargne du compte : "+getTaux()+"\n";
	}

}
