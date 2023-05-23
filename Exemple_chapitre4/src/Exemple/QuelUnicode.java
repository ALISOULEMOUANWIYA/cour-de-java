package Exemple;

import java.util.Scanner;

public class QuelUnicode {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int i;
		char recherche, atrouver;
		Scanner clavier = new Scanner(System.in);
		
		System.out.print("Quel caracteter recherchez-vous : ");
		recherche = clavier.next().charAt(0);
		
		for(i = 0; i <= 127; i++) {
			atrouver = (char)i;
			if(atrouver == recherche) {
				System.out.println("le code Unicode de "+atrouver);
				System.out.println(" est \\u00"+Integer.toString(i,16));
			}
		}
	}

}
