package interface_Default;

public class Forme  implements Interface{
   protected int x, y, couleur;
   @SuppressWarnings("unused")
private int r;
   
   public Forme(int nx, int ny) {
	   x = nx;
	   y = ny;
	   couleur = 0;
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
