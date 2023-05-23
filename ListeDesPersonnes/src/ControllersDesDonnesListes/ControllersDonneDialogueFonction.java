package ControllersDesDonnesListes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ControllersDonneDialogueFonction {
	
	private final StringProperty fFosition;
	
	public ControllersDonneDialogueFonction(String valeur) {
		this.fFosition = new SimpleStringProperty(valeur);	
	}
	
	public StringProperty getfFonsition() {
		return fFosition;
	}
}
