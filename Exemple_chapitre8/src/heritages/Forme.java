package heritages;

public class Forme {
	
	protected int x, y, couleur;
	
	// surcharger le constructuer Forme
		public Forme(int nx, int ny) {
			x = nx;
			y = ny;
			couleur = 0;
		}
	
	// la methode afficher
		public void afficher() {
			System.out.println("Position en "+x+", "+y);
			System.out.println("Couleur : "+couleur);
		}
		
	// echanger les forme 
		public void echanger(Forme autre)
		{
			int tmp;
			
			tmp = x;
			x = autre.x;
			autre.x = tmp;
			
			tmp = y;
			y = autre.y;
			autre.y = tmp;
		}
		
	// deplacer la forme
		public void deplacer(int nx, int ny) {
			x = nx;
			y = ny;
		}
}
