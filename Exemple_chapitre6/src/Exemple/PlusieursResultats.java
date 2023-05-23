package Exemple;

import java.util.Scanner;

public class PlusieursResultats {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrez une valeur pour a : ");
		int a = sc.nextInt();
		
		System.out.print("Entrez une valeur pour b : ");
		int b = sc.nextInt();
		
		System.out.println(" a = "+a+" b = "+b);
		
		
		System.out.println(" APRES ECHANGE  ");
		echange(a,b);
	}
	public static void echange(int x, int y) {
		int tmp = x;
		x = y ;
		y = tmp;
		System.out.print(" a = "+x+" b = "+y);
	}

}
