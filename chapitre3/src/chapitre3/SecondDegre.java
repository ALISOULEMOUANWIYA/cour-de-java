package chapitre3;

import java.util.Scanner;

public class SecondDegre {

	public static void main(String[] args) {
		double a, b, c, delta;
		double x, x1, x2;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez une valeur pour a : ");
		a = clavier.nextDouble();
		System.out.println("Entrez une valeur pour a : ");
		b = clavier.nextDouble();
		System.out.println("Entrez une valeur pour a : ");
		c = clavier.nextDouble();
		
		if(a == 0) {
			if(b==0) {
				if(c==0) {
					System.out.println("tout reel est solution ");
				}else {
					System.out.println("Il n'y a pas de solution ");
				}
			}else {
				if(c==0) {
					x = c/b;
					System.out.println("la solution est "+x);
				}else {
					x = -c/b;
					System.out.println("la solution est "+x);	
				}

			}
		}else {
			delta = b*b - 4*a*c;
			if(delta < 0) {
				System.out.println("il n'y a pas de solution dans les reels ");
			}else {
				x1 = (-b + Math.sqrt(delta))/(2*a);
				x2 = (-b - Math.sqrt(delta))/(2*a);
				System.out.println("il y deux solution egales a "+x1+" et "+x2);
			}
		}
	}

}
