package ListesDesFormesGeometrique_ArrayList;

public class Cercle extends Formes{
	
	private int rayon ;
	 
	// le constructeur par defaut
		public Cercle() {
			rayon = verifier(" Rayon = ",0, getHauteurEcran());
		}
	
	// surcharge du construteur 
		public Cercle(int abscisse, int ordonne, int couleur, int rayonclercle) {
			super(abscisse, ordonne, couleur);
			rayon = verifier(rayonclercle, 0, getHauteurEcran());
		}
		
	// afficher le cercle
		public void afficher() {
			System.out.println("\n------------- Cercle ----------------");
			super.afficher();
			System.out.println("Rayon = "+getRayonCercle());
		}
		
	// les commitateur
		public int getRayonCercle() {
			return rayon;
		}
		public String getInfo() {
			String tmp = super.getInfo();
			return "C;"+tmp+";"+rayon;
		}
	
}
