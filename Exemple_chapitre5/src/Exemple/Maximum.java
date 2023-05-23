package Exemple;

import java.util.Scanner;

public class Maximum {

	public static void main(String[] args) {
		// declaration des variables
		  int v1, v2, sup;
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.print("Entrez valeur N°1 : ");
		  v1 = sc.nextInt();
		  
		  System.out.print("Entrez valeur n°2 : ");
		  v2 = sc.nextInt();
		  
		  sup = max(v1,v2);
		  System.out.println("le max de "+v1+" et de "+v2+" est "+sup);		  
	}
	
	public static int max(int a, int b) {
		int m = a;
		if(b > m) {
			m = b;
		}
		return m;
	}
}
