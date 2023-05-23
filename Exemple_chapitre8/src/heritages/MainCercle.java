package heritages;

public class MainCercle {

	
	public static void main(String[] args) {
		
		Cercle a = new Cercle(5,5);
		a.afficher();
		
		double p = a.perimetre();
		System.out.println("Votre cercle a pour perimetre : "+p);
		
		  a.deplacer(5, 10);
		  System.out.println("Apres déplacement : ");
		  a.afficher();
		  a.agrandire(10);
		  
		  System.out.println("Apres agrandissement : ");
		  a.afficher();
		  
		  Forme F = new Forme (10, 10);
		  F.echanger(a);
		  a.afficher();
		  
		  F.afficher();
		  a.echanger(F);
		  
		  a.afficher();
		  F.afficher();
	}

}
