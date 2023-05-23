package Exemple;

import java.util.Scanner;

public class CompteurMonnaie {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int nbPiece5C = 0, nbPiece10C = 0, nbPiece20C = 0, piece;
		int totalRecu = 0;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Pour obtenire un cafer , entrez au moins 45 cents");
		System.out.println("Je rend la monnais");
		 do {
			 System.out.print("Valeur de la piece entree ");
			 piece = clavier.nextInt();
			 switch(piece) {
			    case  5: 
			    	  nbPiece5C = nbPiece5C + 1;
			    	break;
			    case  10: 
			    	  nbPiece10C = nbPiece10C + 1;
			    	break;
			    case  20: 
			    	  nbPiece20C = nbPiece20C + 1;
			    	break;
			    default : 
			    	piece = 0;
			    	  System.out.println(piece+"piece impossible pour prendre une tasse de café");
			 }
			 
			 totalRecu = totalRecu + piece;
			 
			   System.out.println("Vous avez entre : ");
			   System.out.println("    " + nbPiece5C + " piece(s) de 5 cents"); 
			   System.out.println("    " + nbPiece10C + " piece(s) de 10 cents");
			   System.out.println("    " + nbPiece20C + " piece(s) de 20 cents");
			   System.out.println("Soit au total :  " + totalRecu + " cents");
		 
		 }while(totalRecu < 45);
		 
		 System.out.println("je vous verse 1  café ");
		 if (totalRecu > 45) {
			   System.out.println("et vous rends : " + (totalRecu-45) + " cents ");
		  }
	}

}
