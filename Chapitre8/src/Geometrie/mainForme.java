package Geometrie;

public class mainForme {

	public static void main(String[] args) {
		Cercle c = new Cercle(105, 105, 20, 10);;
		
		c.afficher();
		c.deplacer(100, 100);
		c.afficher();
		
        Cercle a = new Cercle();;
		
		a.afficher();
		a.deplacer(50, 50);
		a.afficher();
		
		/*
		Rectangle r = new Rectangle(100, 100, 50, 20, 5);
		r.afficher();
		r.deplacer(200, 200);
		r.afficher();
		
		triangle t = new triangle(200, 200, 100, 300, 300, 300, 2);
		t.afficher();
		t.deplacer(300, 300);
		t.afficher();*/
	}

}
