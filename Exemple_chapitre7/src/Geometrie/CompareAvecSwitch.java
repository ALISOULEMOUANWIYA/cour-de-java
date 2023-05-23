package Geometrie;

import java.util.Scanner;

public class CompareAvecSwitch {

	public static void main(String[] args) {
		String quelleCouleur = "";
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Quelle couleur chosissez-vous ");
		System.out.println("Rouge, vert, Orange, Bleu, Violet, Jaune  : ");
		
		quelleCouleur = clavier.next();
		quelleCouleur = quelleCouleur.toLowerCase();
		
		switch(quelleCouleur) {
			  case "vert" :
				  System.out.println("Vous devez melanger du bleu avec du rouge");
			  break;
			  
			  case "violet" :
				  System.out.println("Vous devez melanger du bleu avec du jaune");
			  break;
			  
			  case "orange" :
				  System.out.println("Vous devez melanger du rouge avec du jaune");
			  break;
			  default:
				  if( quelleCouleur.equalsIgnoreCase("rouge") ||
					  quelleCouleur.equalsIgnoreCase("jaune") || 
					  quelleCouleur.equalsIgnoreCase("bleu"))   {
					  System.out.println("c'est une couleur primaire");
				  }else {
					  System.out.println("valeur non prise en charge ");
				  }
				  
		}
		
	}
}
