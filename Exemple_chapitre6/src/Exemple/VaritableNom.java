package Exemple;

public class VaritableNom {
	
	static int valeur;
	
	public static void main(String[] args) {
		// declaration des variables
		VaritableNom.valeur = 2;
		System.out.println(VaritableNom.valeur+" avant modifier()");
		modifier();
		System.out.println(VaritableNom.valeur+" apres modifier()");
	}
	public static void modifier() {
		// declaration des variables
		System.out.println("Variable classe : "+VaritableNom.valeur);
		int valeur = 3;
		System.out.println("Variable locale : "+valeur);
		VaritableNom.valeur = 3;
		System.out.println("variable de classe  : "+VaritableNom.valeur);
	}
}
