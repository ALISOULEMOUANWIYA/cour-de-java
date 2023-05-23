package ControllersDesDonnesListes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ControllersDonneDataListes {
	
	private final StringProperty fFosition;
	private final IntegerProperty IdFonction;
	
	public ControllersDonneDataListes(int ValeurId ,String valeur)  {
		this.fFosition = new SimpleStringProperty(valeur);
		this.IdFonction = new SimpleIntegerProperty(ValeurId);
	}
	
	public StringProperty getfFonsition() {
		return fFosition;
	}
	public IntegerProperty getIdFonction() {
		return IdFonction;
	}
}
