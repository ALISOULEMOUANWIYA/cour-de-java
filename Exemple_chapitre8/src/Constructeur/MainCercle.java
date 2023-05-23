package Constructeur;



public class MainCercle {

	public static void main(String[] args) {
		Cercle a = new Cercle();
		
		System.out.println("-------------- Pour le cercle A--------------------");
		
		
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimetre());
		
		System.out.println("---------------Apres deplacement---------------");
		a.deplacer(12, 11);
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimetre());
		
		System.out.println("------------------Apres agrandissement-------------------");
		a.agrandir(20);
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimetre());
	
	}

}
