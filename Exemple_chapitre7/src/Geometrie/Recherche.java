package Geometrie;

import java.util.Scanner;

public class Recherche {

	public static void main(String[] args) {
		
		String phrase  = "Mieux vaut tard que jamais";
		String soumo ="";
		int place;
		
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Vous avez dit : "+phrase);
		soumo = phrase.substring(11,15);
		
		System.out.println("De 11 à 15, la sous chaine est : "+soumo);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("en "+i+", il y a : "+phrase.charAt(i));
		}
		
		System.out.println("Entrez un mot : ");
		soumo = clavier.next();
		
		if(phrase.endsWith(soumo)) { // la fin d'une phrase
			System.out.println("La phrase se termine avec : "+soumo);
		}else {
			System.out.println("la phrase ne finit pas avec : "+soumo);
		}
		
		place = phrase.indexOf(soumo);// position
		if(place == -1) {
			System.out.println("ce mot n'existe pas dans : "+phrase);
		}else {
			System.out.println(soumo+" est à la position : "+place);
		}
		
	}
}
