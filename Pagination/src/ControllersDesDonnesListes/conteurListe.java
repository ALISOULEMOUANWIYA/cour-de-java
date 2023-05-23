package ControllersDesDonnesListes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class conteurListe {
	
	private final IntegerProperty conteur;
	
	public conteurListe(int valeur) {
		this.conteur = new SimpleIntegerProperty(valeur);
	}
	
	public IntegerProperty getfFonsition() {
		return conteur;
	}
}
