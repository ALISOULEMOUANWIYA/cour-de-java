package ListesDesFormesGeometrique_ArrayList;

public class Triangle extends Formes{
	
	private final static int tailleEcran = 600;
	private int[] XPoints = new int[3];
	private int[] YPoints = new int[3];
	
	// le constructeur par defaut
		public Triangle() {
			XPoints[0] = CoordonneX;
			YPoints[0] = CoordonneY;
			for(int i = 1; i < XPoints.length; i++) {
				XPoints[i] = verifier(" Position N°["+i+"] en X ", 0, getLargeurEcran());
				YPoints[i] = verifier(" Position N°["+i+"] en Y ", 0, getHauteurEcran());
			}
		}
	
	// surcharge du constructeur
		public Triangle(int nxa, int nya, int nxb, int nyb, int nxc, int nyc, int nc) {
			super(nxa, nya, nc);
			XPoints[0] = CoordonneX;
			YPoints[0] = CoordonneY;
			XPoints[1] = verifier(nxb, 0, getLargeurEcran());
			YPoints[1] = verifier(nyb, 0, getHauteurEcran());
			XPoints[2] = verifier(nxc, 0, getLargeurEcran());
			YPoints[2] = verifier(nyc, 0, getHauteurEcran());
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
	
	// la methode afficher le triangle
		 public void afficher() {
			 System.out.println("\n------------- Triangle ----------------");
			 super.afficher();
			 for(int i = 1;  i < XPoints.length; i++) {
			   System.out.println("Position en "+XPoints[i]+", "+YPoints[i]);
			 }
		 }
		 
	// la methode obtenire information
		public String getInfo() {
			String tmp = super.getInfo();
			return "T;"+tmp+";"+XPoints[1]+";"+YPoints[1]+";"+XPoints[2]+";"+YPoints[2];
		}
}
