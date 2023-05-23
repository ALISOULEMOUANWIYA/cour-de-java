package ControllersDesDonnesListes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class conteurListeParametre {
	
	private final IntegerProperty conteur;
	
	public conteurListeParametre(int valeur) {
		this.conteur = new SimpleIntegerProperty(valeur);
	}
	
	public IntegerProperty getfFonsition() {
		return conteur;
	}
}
