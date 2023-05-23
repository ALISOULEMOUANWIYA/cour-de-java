package Exemple;

import java.io.IOException;

public class LireEntier {

	public static void main(String[] args) throws IOException {
		String tmp = "";
		char c = '\0';
		int valeur ;
		
		System.out.print("Entrez des chiffres et appuyer sur ");
		System.out.println("la touche entree, pour valider la saisie  : ");
		
		while(c != '\n') {
			c = (char)System.in.read();
			if(c != '\r' && c != '\n') {
				tmp = tmp + c;
			}
		}
		
		System.out.println("vous avez entré : "+tmp);
		valeur = Integer.parseInt(tmp);
		System.out.println("C'est a dire : "+valeur+" en entier");
	}

}
