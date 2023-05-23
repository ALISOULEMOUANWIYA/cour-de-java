package forme1;

import java.util.Scanner;

public class MainForme {
	
	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		int nbCercle ;
		
		System.out.print("Combien de cercle : ");
		 nbCercle = clavier.nextInt();
		
		if(nbCercle < 3) {
			nbCercle = 4;
		}
		ClasseForme [] c = new ClasseForme[nbCercle];
		
		System.out.println("\n--------------------------avant--------------------------------------------");
	    for(int i = 0; i < c.length; i++) {
	    	System.out.println(c[i]);
	    }
	
	
		for(int i = 0; i < c.length; i++) {
			c[i] = new ClasseForme();
		}
	
		
		System.out.println("\n--------------------------recapitulatif--------------------------------------------");
	    for(int i = 0; i < c.length; i++) {
	    	c[i].afficher();
	    	System.out.println(c[i]);
	    }
	    
	 /*  
	    System.out.println("\n--------------------------deplacer le cercle 1 : deplacement en 20, 20-------------");
	     c[1].deplacer(20, 20);
	     c[1].afficher();
	    
	    System.out.println("\n--------------------------cerlce 2 : agrandire de 50 le rayon ---------------------");
	    c[2].agrandire(50);
	    c[2].afficher();
	    
	    System.out.println("\n--------------------------Echange du cercle 0 avec le cercle 3 --------------------");
		c[0].echangerAvec(c[3]);
		c[0].afficher();
		c[3].afficher();
	
	*/
		
	}

}
