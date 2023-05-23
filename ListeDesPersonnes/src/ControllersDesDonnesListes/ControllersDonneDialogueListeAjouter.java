package ControllersDesDonnesListes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException; 

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ControllersDonneDialogueListeAjouter {
	
	private final StringProperty prenomUtilsateur;
	private final StringProperty nomUtilsateur;
	private final StringProperty MatriculeUtilisateur;
	private InputStream photoUtilisateur;
	
	public ControllersDonneDialogueListeAjouter(String valeurPrenomUtilsateur, String valeurNomUtilsateur,
			Blob photot, String matriculeStringUtil) throws SQLException {
		this.prenomUtilsateur = new SimpleStringProperty(valeurPrenomUtilsateur);
		this.nomUtilsateur = new SimpleStringProperty(valeurNomUtilsateur);
		this.photoUtilisateur = photot.getBinaryStream();
		this.MatriculeUtilisateur = new SimpleStringProperty(matriculeStringUtil);
		
	}
	
	public StringProperty getPrenomUtilsateur() {
		return prenomUtilsateur;
	}
	public StringProperty getNomUtilsateur() {
		return nomUtilsateur;
	}
	
	public InputStream getPhotoUtilisateur() {
		return photoUtilisateur;
	}
	public void setPhotoUtilisateur(FileInputStream photoUtilisateur) {
		this.photoUtilisateur = photoUtilisateur;
	}
	
	public StringProperty getMatriculeUtilisateur() {
		return MatriculeUtilisateur;
	}

}

