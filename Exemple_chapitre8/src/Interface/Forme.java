package Interface;

public class Forme implements CalculeGeometrique{
	
	protected int x, y, couleur;
	
	public Forme(int nx, int ny) {
		x = nx;
		y = ny;
		couleur = 0;
	}
	
	public double surface() {
		return -1;
	}
	
	public double perimetre() {
		return -1;
	}
	
	public void afficher() {
		System.out.println("Position en "+x+", "+y);
		System.out.println("Couleur : "+couleur);
	}
	
	public void echanger(Forme autre) {
		int tmp;
		
		tmp = x;
		x = autre.x;
		autre.x = tmp;
		
		tmp = y;
		y = autre.y;
		autre.y = tmp;
	}
	
	public void deplacer(int nx, int ny) {
		x = nx;
		y = ny;
	}
	
}
