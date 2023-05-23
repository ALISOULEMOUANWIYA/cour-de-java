package exemple;

import java.util.Scanner;

public class SwitchString {

	public static void main(String[] args) {
		
		String choix ;
		Scanner clavier = new Scanner(System.in);
		
		System.out.println(" fait votre choix (oui / non) ?");
		choix = clavier.nextLine();
				
		switch(choix) {
		     case "oui" :
		    	 System.out.println(" vous avez saisie oui ");
		    	 break;
		     case "non" :
		    	 System.out.println(" vous avez saisie non ");
		    	 break;
		     default :
		    	 System.out.println(" ni oui  ni non  ");
		}

	}

}
