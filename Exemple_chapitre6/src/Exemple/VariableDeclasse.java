package Exemple;

public class VariableDeclasse {
	
	static int valeur;
	

	public static void main(String[] args) {
		valeur = 2;
		System.out.println("valeur = "+valeur+" avant modifier()");
		modifier();
		System.out.println("valeur = "+valeur+" apres modifier()");
	}
	public static void modifier() {
		valeur = 3;
		System.out.println("valeur = "+valeur+" dans modifier()");
	}

}
