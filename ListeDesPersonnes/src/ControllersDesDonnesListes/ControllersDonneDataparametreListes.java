package ControllersDesDonnesListes;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ControllersDonneDataparametreListes {
	
	private final StringProperty fFosition;
	private final IntegerProperty IdFonction;
	private InputStream photoParametre;

	public ControllersDonneDataparametreListes(int ValeurId , String valeur ,Blob IconsPhoto) throws SQLException {
		this.IdFonction = new SimpleIntegerProperty(ValeurId);
		this.fFosition = new SimpleStringProperty(valeur);
		this.photoParametre = IconsPhoto.getBinaryStream();
	}

	public StringProperty getfFonsition() {
		return fFosition;
	}
	public IntegerProperty getIdFonction() {
		return IdFonction;
	}
	public InputStream getPhotoParametre() {
		return photoParametre;
	}
}
