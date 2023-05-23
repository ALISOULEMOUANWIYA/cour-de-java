package exercice;

import java.util.*;

public class Devinette { 
	
	@SuppressWarnings("resource")
	public static void main(String [] args) {
		int i, nombrelu = -1, nbboucle = 0;
		Scanner cla = new Scanner(System.in);
		
		i = (int) (10* Math.random());
		
		System.out.println("ceci est un jue tire nombre au hasard");
		System.out.println("entre 0 et 10 , devinez lequel");
		
		while(nombrelu != i) {
			System.out.println("votre choix : ");
			nombrelu = cla.nextInt();
			nbboucle = nbboucle + 1;
		}
		
		System.out.println("bravo !");
		System.out.println("vous avez reuussi en "+nbboucle+" fois ");
	}
}
