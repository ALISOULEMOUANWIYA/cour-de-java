package convertion;

import java.util.Scanner;

public class FrancEnEuro {

	public static void main(String[] args) {
		double F, E =0.0;
		double T = 6.55957;
		F=E;
		String choix;
		int valeur=0;
		Scanner clavier = new Scanner(System.in);
		System.out.println("choisissez votre choix de convertion");
		System.out.println(" E(euro) en F(franc) ou F(franc) en E()euro : ");
		choix = clavier.next();
		do {
			if(choix.equals("F") || choix.equals("f")) {
				valeur = 1;
				System.out.print("Combien de Franc voulez-vous convertir : ");
				E = clavier.nextDouble();
				F = E * T;
			}else if(choix.equals("E") || choix.equals("e")) {
				valeur = 1;
				System.out.print("Combien d'Euro voulez-vous convertir : ");
					F = clavier.nextDouble();
					E = F/ T;
			}else {
				valeur = 0;
				System.out.println(" eurreur mauvaise choix :( ");
			}
		}while(valeur == 0);

		if(choix.equals("F") || choix.equals("f")) {
			System.out.println("convertion E/F : "+T);
			System.out.println("Nombre de Franc : "+F);
		}
		else if(choix.equals("E") || choix.equals("e")) {
			System.out.println("convertion F/E : "+T);
			System.out.println("Nombre d'euro : "+E);
		}
	}

}
