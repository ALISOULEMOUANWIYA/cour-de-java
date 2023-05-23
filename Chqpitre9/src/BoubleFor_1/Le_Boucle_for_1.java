package BoubleFor_1;

public class Le_Boucle_for_1 {

	public static void main(String[] args) {
		int i;
		int [] valeur = new int[6];
		
		valeur [0] = 1;
		System.out.println(valeur.length+"\n\n");
		for(i = 1; i < valeur.length; i++) {
			 System.out.println(i+"\n");
			valeur[i] = valeur[i-1]+ 1 ;
		}
		for(i = 0; i < valeur.length; i++) {
			 System.out.println("Valeur ["+i+"] = "+valeur[i]);
		}
		for(int v : valeur) {
		   System.out.println("Valeur = "+v);
		}
	}

}
