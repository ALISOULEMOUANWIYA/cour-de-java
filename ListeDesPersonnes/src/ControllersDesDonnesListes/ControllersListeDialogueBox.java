package ControllersDesDonnesListes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class ControllersListeDialogueBox {
	
	private StringProperty SercherPersonne;
	
	private CheckBox checkBox;
	private InputStream photoUtilisateur;
	private Timestamp dateInscriptionutilisateur;
	
	private final IntegerProperty Id_Utilisateur;
	private final StringProperty NomUtilisateur;
	private final StringProperty PrenomUtilisateur;
	private final StringProperty FonctionUtilisateur;
	private final IntegerProperty Id_FonctionUt;
	private final StringProperty GenreUtilisateur;
	private final StringProperty AgeUtilisateur;
	private final StringProperty NationaliteUtilisateur;
	private final IntegerProperty Id_NationaliteUt;
	private final StringProperty AdressUtilisateur; 
	private final StringProperty MatriculeUtilisateur;
	private IntegerProperty ageUtilasteur;
	
	
	public ControllersListeDialogueBox(int ID_util,String PrenomUtil, String NomUtil, String GenreUtil, String AnneUtil,
			String AdressUtil, String NationaliteUtil, int ID_Nationalite, String FonctionUtil, int ID_Fonction ,
			Blob photot ,String matriculeStringUtil ,Timestamp inscriptionUtil, int AgeUtil) throws FileNotFoundException, SQLException {
		
		this.Id_Utilisateur = new SimpleIntegerProperty(ID_util);
		this.PrenomUtilisateur = new SimpleStringProperty(PrenomUtil);
		this.NomUtilisateur = new SimpleStringProperty(NomUtil);
		this.GenreUtilisateur = new SimpleStringProperty(GenreUtil);
		this.AgeUtilisateur = new SimpleStringProperty(AnneUtil);
		this.AdressUtilisateur = new SimpleStringProperty(AdressUtil);
		this.NationaliteUtilisateur = new SimpleStringProperty(NationaliteUtil);
		this.Id_NationaliteUt = new SimpleIntegerProperty(ID_Nationalite);
		this.FonctionUtilisateur = new SimpleStringProperty(FonctionUtil);
		this.Id_FonctionUt = new SimpleIntegerProperty(ID_Fonction);
		this.photoUtilisateur = photot.getBinaryStream();
		this.MatriculeUtilisateur = new SimpleStringProperty(matriculeStringUtil);
		this.dateInscriptionutilisateur = inscriptionUtil;
		this.ageUtilasteur = new SimpleIntegerProperty(AgeUtil);
		this.checkBox = new CheckBox();
		
		
	}
	
	
	public void afficherButton() {
		if(getCheckBox().isSelected()) {
			System.out.println("Button : "+checkBox);
		}
	}
	
	private void rechercheCompte( String RechercheUtil) {
		this.SercherPersonne = new SimpleStringProperty(RechercheUtil);
	}
	
	public IntegerProperty getId_Utilisateur() {
		return Id_Utilisateur;
	}
	
	public InputStream getPhotoUtilisateur() {
		return photoUtilisateur;
	}
	public void setPhotoUtilisateur(FileInputStream photoUtilisateur) {
		this.photoUtilisateur = photoUtilisateur;
	}
	
	public StringProperty getSercherPersonne() {
		return SercherPersonne;
	}
	
	public StringProperty getNomUtilisateur() {
		return NomUtilisateur;
	}
	
	public StringProperty getPrenomUtilisateur() {
		return PrenomUtilisateur;
	}
	public StringProperty getFonctionUtilisateur() {
		return FonctionUtilisateur;
	}
	public IntegerProperty getId_FonctionUt() {
		return Id_FonctionUt;
	}
	
	public StringProperty getGenreUtilisateur() {
		return GenreUtilisateur;
	}
	
	public StringProperty getNationaliteUtilisateur() {
		return NationaliteUtilisateur;
	}
	public IntegerProperty getId_NationaliteUt() {
		return Id_NationaliteUt;
	}
	
	public StringProperty getAdressUtilisateur() {
		return AdressUtilisateur;
	}
	
	public StringProperty getMatriculeUtilisateur() {
		return MatriculeUtilisateur;
	}

	

	public StringProperty getRechercheCompte() {
		return SercherPersonne;
	}
	
	public StringProperty getAgeUtilisateur() {
		return AgeUtilisateur;
	}
	
	public void  setRechercheCompte(StringProperty valeurRech) {
		this.SercherPersonne = valeurRech;
	}
	
	public Timestamp getDateInscriptionutilisateur() {
		return dateInscriptionutilisateur;
	}
	public void setDateInscriptionutilisateur(Timestamp valeurDate) {
		this.dateInscriptionutilisateur = valeurDate;
	}
	public IntegerProperty getAgeUtilasteur() {
		return ageUtilasteur;
	}
	public void setAgeUtilasteur(IntegerProperty valeurage) {
		this.ageUtilasteur = valeurage;
	}
	
	public CheckBox getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
}
