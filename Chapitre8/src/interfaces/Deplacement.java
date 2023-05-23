package interfaces;

// definition de l'inteface Deplacement
interface Deplacement {
	
	// Definition du comportement seDeplacer
	   public void seDeplacer();
	   
	// Définition du comportement deplacementEnX()
    // Par défaut il n'y a pas de déplacement en X
	   default public void deplacementEnX() {
		   
	   }
	
	// Définition du comportement deplacementEnX()
	// Par défaut il n'y a pas de déplacement en X
		default public void deplacementEnY() {
			   
		}
}
