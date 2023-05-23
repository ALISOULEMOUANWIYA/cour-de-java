package ListesDesFormesGeometrique_ArrayList;

 

public class Rectangle extends Formes{
	
	private int largeur, hauteur;
	private int[] XPoints = new int[4];
	private int[] YPoints = new int[4];
	
	// le constructeur par defaut 
		public Rectangle() {
			XPoints[0] = CoordonneX;
			YPoints[0] = CoordonneY;
			for(int i = 1; i < XPoints.length; i++) {
				XPoints[i] = verifier(" Position N�["+i+"] en X ", 0, getLargeurEcran());
				YPoints[i] = verifier(" Position N�["+i+"] en Y ", 0, getHauteurEcran());
			}
			largeur = verifier("Largeur = ", 0, getLargeurEcran());
			hauteur = verifier("Hauteur = ", 0, getHauteurEcran());
		}
		
	 // surcharge du constructeur
		public Rectangle(int xx0, int yy0, int xx1, int yy1, int xx2, int yy2, int xx3, int yy3, int ll, int hh, int cc) {
			super(xx0, yy0, cc);
			XPoints[0] = CoordonneX;
			YPoints[0] = CoordonneY;
			XPoints[1] = verifier(xx1, 0, getLargeurEcran());
			YPoints[1] = verifier(yy1, 0, getHauteurEcran());
			XPoints[2] = verifier(xx2, 0, getLargeurEcran());
			YPoints[2] = verifier(yy2, 0, getHauteurEcran());
			XPoints[3] = verifier(xx3, 0, getLargeurEcran());
			YPoints[3] = verifier(yy3, 0, getHauteurEcran());
			largeur = verifier(ll, 0, getLargeurEcran());
			hauteur = verifier(hh, 0, getHauteurEcran());
		}
		
	// la methode deplacer le triangle
		public void deplacer(int nx, int ny) {
			super.deplacerForme(nx, ny);
			XPoints[0] = CoordonneX;
			YPoints[0] = CoordonneY;
			for(int i = 0; i < XPoints.length; i++) {
				XPoints[i] = verifier(nx, 0, getLargeurEcran());
				YPoints[i] = verifier(ny, 0, getHauteurEcran());
			}
		}
		
	// la methode afficher le Rectangle 
		public void afficher() {
			System.out.println("\n------------- Rectangle ----------------");
			super.afficher();
			 for(int i = 1;  i < XPoints.length; i++) {
			   System.out.println("Position en "+XPoints[i]+", "+YPoints[i]);
			 }
			System.out.println("Largeur = "+largeur);
			System.out.println("Hauteur = "+hauteur);
		}
		
	// la methode obtenire information
		public String getInfo() {
			String tmp = super.getInfo();
			return "Rectangle; "+tmp+"; "+XPoints[1]+"; "+YPoints[1]+"; "+XPoints[2]+"; "+YPoints[2]+XPoints[3]+"; "+YPoints[3];
		}
}
