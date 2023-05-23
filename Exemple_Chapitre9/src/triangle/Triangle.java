package triangle;

import java.util.*;

public class Triangle {

	public static void main(String[] args) {
		int nl, nc;
		int milieu;
		int [][] sapin;
		Scanner clavier = new Scanner(System.in);
		
		System.out.print("Nombre de ligne : ");
		nl = clavier.nextInt();
		
		if(nl <= 0) {
			System.out.println("Le nombre de ligne doit etre superieur à 0");
			System.exit(0);
		}
		nc = 2 * nl - 1;
		sapin = new int[nl][nc];
		milieu = sapin[0].length/2;
		
		System.out.println("::::::::::::::::::::::::::::: "+milieu+" :::::::::::::::::::::::");
		for ( int j = 0 ; j < nl ; j++) 	{
			 for ( int i = -j; i <= j; i++) 		{
					sapin[j][milieu+i] = (int ) (5*Math.random()+1);
			 }
		}
		//System.out.println(sapin);
		afficher(sapin);	
		
	}
	
	public static void afficher(int [][] t)
	{
		for(int j =0; j<=t.length ;j++) {
			for(int i =0; i<= t[0].length ;i++) {
				switch(t[j][i]) {
					case 0:
						System.out.println(" ");
						break;
					case 2: 
						System.out.println("%");
					break;
					default:
						System.out.println(".");
				}
				System.out.println();
			}
		}
	}
	
}
