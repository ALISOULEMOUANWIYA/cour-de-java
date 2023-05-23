package interfaces;

// definition de l'inteface Deplacement
interface Deplacement {
	
	// Definition du comportement seDeplacer
	   public void seDeplacer();
	   
	// D�finition du comportement deplacementEnX()
    // Par d�faut il n'y a pas de d�placement en X
	   default public void deplacementEnX() {
		   
	   }
	
	// D�finition du comportement deplacementEnX()
	// Par d�faut il n'y a pas de d�placement en X
		default public void deplacementEnY() {
			   
		}
}
