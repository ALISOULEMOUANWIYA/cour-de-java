package tableau3;

import java.util.Scanner;

public class collection {

	public static void main(String[] args) {
		int i,j, n = 5;
		char c;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un caractere : ");
		c = clavier.next().charAt(0);
		
		for( i = 0; i < n; i++) 
		{
			for( j = 0; j < n; j++)
			{
				if(i < j) {
					System.out.print(j);
					//System.out.print(c);
				}
			}
			System.out.println();
		}
	}

}