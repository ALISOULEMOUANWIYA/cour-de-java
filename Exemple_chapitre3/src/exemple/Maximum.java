package exemple;

import java.util.Scanner;

public class Maximum {

	public static void main(String[] args) {
		int premier, deuxieme, laPlusGrande;
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Entrez une premier valeur :");
		premier = clavier.nextInt();
		System.out.println("Entrez une deuxieme valeur :");
		deuxieme = clavier.nextInt();
		
		if(premier > deuxieme) {
			System.out.println(premier+" > "+deuxieme);
			laPlusGrande = premier;
			System.out.println(" La plus grande est : "+laPlusGrande);
		}else {
			if(premier < deuxieme) {
				System.out.println(premier+" <  "+deuxieme);
				laPlusGrande = deuxieme;
				System.out.println(" La plus grande est : "+laPlusGrande);
			}
			else {
				System.out.println(" La plus grande sont identique ");
			}
		}
	}

}
