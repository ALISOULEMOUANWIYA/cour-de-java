package interfaces;

public class MoyenDeTransfport implements Deplacement{
	
	// variable static
	public final static int vitesseInitial = 10;
	
	// variable d'instance
	protected int x, y;
	protected int vitesse;
	
	// le constructeur MoyenDeTransfport
	public MoyenDeTransfport(int nx, int ny) {
		x = nx;
		y = ny;
	}
	
	
	// protection de la methode limitiation des vitesse qui est en relation
	// avec d'autre classe par l'acc�es EXTENDS 
	   protected int limitation(int tmp, int max) {
		   tmp = vitesseInitial * tmp;
		   if(tmp < 0) {
			   return 0;
		   }else if(tmp > max) {
			   return max;
		   }else {
			   return tmp;
		   }
	   }
	   
	 // definition de la methode afficher()
	   public void afficher() {
		   System.out.println("Position en "+x+", "+y);
	   }
	   
	 // c. Un moyen de transport se d�place en X et en Y 
	 // selon les m�thode d�finies par l'interface Deplacement
	   public void seDeplacer() {
		   deplacementEnX();
		   deplacementEnY();
	   }
}
