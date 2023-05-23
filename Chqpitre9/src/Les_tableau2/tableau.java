package Les_tableau2;

public class tableau {
	
	public static void main(String [] argument) {
		
		int laPlusGrand, laSomme = 0, iMax = 0, nbMoy = 0;
		double laMoyenne;
		
		if(argument.length  >= 0) {
			int [] valeur = new int [argument.length];
			for(int i = 0; i < argument.length; i++) {
				valeur[i] = Integer.parseInt(argument[i]);
			}
			
			laPlusGrand = valeur[0];
			
			for(int i = 0; i < valeur.length; i++) {
				if(laPlusGrand < valeur[i]) {
					// recherche la plsu grand des valeur
						laPlusGrand = valeur[i];
					// determiner la position de la plus grand des valeur
						iMax = i;
				}
				// calcule la somme de ces valeurs
					laSomme = laSomme + valeur[i];
			}
			
			// calcule la moyenne de ces valeurs
			   laMoyenne = (float) laSomme / valeur.length;
			   for(int i = 0; i < valeur.length; i++) {
				   // calcule le nombre de valeur superieur à la moyenne
				      if(valeur[i] >= laMoyenne) {
				    	  nbMoy++;
				      }
			   }
			    System.out.println("La plus grande valeur est : " + laPlusGrand) ;
				System.out.println("A l'indice : " + iMax + " du tableau ") ;
				System.out.println("La moyenne de ces valeurs : " + laMoyenne) ;
				System.out.println("Nombre de valeurs > a la moyenne : " + nbMoy) ;
		}else {
			System.out.println("Commande : java Exercice2 listeDesValeursEntières ");
		}
	}
	
	
}
