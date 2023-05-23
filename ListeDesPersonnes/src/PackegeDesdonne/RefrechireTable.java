package PackegeDesdonne;

import ControllerFXMLListe.ControllersDialogueInscription;

public class RefrechireTable {
	
	private ControllersDialogueInscription aporterBoolean;
	
	private boolean refrechirProuver ;
	
	public RefrechireTable() {
		aporterBoolean = new ControllersDialogueInscription();
		setRefrechirListeProuver(aporterBoolean.getFinit());
		System.out.println(" veriter "+getRefrechirListeProuver());
	}
	
	public boolean getRefrechirListeProuver() {
		return refrechirProuver;
	}
	
	public void setRefrechirListeProuver(boolean veleur) {
		this.refrechirProuver = veleur;
	}
}
