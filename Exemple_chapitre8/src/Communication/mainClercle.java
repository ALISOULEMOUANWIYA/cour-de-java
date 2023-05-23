package Communication;

public class mainClercle {

	@SuppressWarnings( "static-access" )
	public static void main(String[] args) {
		Cercle a = new Cercle();
		Cercle b = new Cercle();
		
		System.out.println("-------------- Pour le cercle A--------------------");
		a.creer();
		System.out.println("Nombre de cercle(s) : "+a.nombre);
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimtre());
		
		System.out.println("---------------Apres deplacement---------------");
		a.deplacer(a.x*2, a.y*2);
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimtre());
		
		System.out.println("------------------Apres agrandissement-------------------");
		a.agrandire(a.r*2);
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimtre());
		
		
		
		System.out.println("\n\n-------------- Pour le cercle B--------------------");
		b.creer();
		System.out.println("Nombre de cercle(s) : "+b.nombre);
		b.afficher();
		System.out.println("perimetre du cercle : "+b.perimtre());
		
		System.out.println("-----------------Apres deplacement---------------");
		b.deplacer(b.x*2, b.y*2);
		b.afficher();
		System.out.println("perimetre du cercle : "+b.perimtre());
		
		System.out.println("-----------------Apres agrandissement---------------");
		b.agrandire(b.r*2);
		b.afficher();
		System.out.println("perimetre du cercle : "+b.perimtre());
		
		System.out.println("*****************************Apres echange**********************");
		b.echangeAvec(a);
		
		System.out.println("\n\n-------------- Pour le cercle A--------------------");
		a.afficher();
		System.out.println("perimetre du cercle : "+a.perimtre());
		
		System.out.println("------------------------Apres deplacement---------------------");
		a.deplacer(a.x*2, a.y*2);
		a.afficher();
		
		System.out.println("---------------------Apres agrandissement----------------");
		a.agrandire(a.r*2);
		a.afficher();
		
		System.out.println("\n\n-------------- Pour le cercle B--------------------");
		b.afficher();
		System.out.println("perimetre du cercle : "+b.perimtre());
		
		System.out.println("-----------------Apres deplacement---------------");
		b.deplacer(b.x*2, b.y*2);
		b.afficher();
		
		System.out.println("---------------------Apres agrandissement----------------");
		b.agrandire(b.r*2);
		b.afficher();
		
	}
	
}
