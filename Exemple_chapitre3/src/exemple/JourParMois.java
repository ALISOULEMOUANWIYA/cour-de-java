package exemple;

import java.util.Scanner;

public class JourParMois {

	public static void main(String[] args) {
		
		byte mois, nbjours = 0;
		short anne;
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("De quel mois s'agit-il ? : ");
		mois = clavier.nextByte();
		
		System.out.println("De quelle anné s'agit-il ? : ");
		anne = clavier.nextShort();
		
		switch(mois) {
			  case 1: case 3:
			  case 5 : case 7: // pour les mois à 31 jours
			  case 8 : case 10 :
			  case 12 :
				  nbjours = 31;
				  break;
			  case 4 : case 6 : // pour les mois à 30
			  case 9 : case 11 :
				  nbjours = 30;
				  break;
			  case 2 : // pour le cas particulier du mois de fevrier
				  if(anne % 4 == 0 && anne % 100 != 0 || anne % 400 == 0) {
					  nbjours = 29;
				  }else {
					  nbjours = 28;
				  }
				  break;
			 default : // en cas d'erreur defrappe
				 System.out.println("Impossible, ce mois n'existe pas ");
				 System.exit(0);
		 
		}
		
		System.out.println("En "+anne+", le mois n° "+mois);
		System.out.println(" a "+nbjours+" jours ");;
	}

}
