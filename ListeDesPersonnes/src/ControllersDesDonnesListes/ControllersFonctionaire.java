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

public class ControllersFonctionaire {
	
	private StringProperty SercherPersonne;
	
	private CheckBox checkBox;

	
	private final IntegerProperty ID_Fonctionnaire;
	private final StringProperty Prenom_Fonctionnaire;
	private final StringProperty Nom_Fonctionnaire;
	private final StringProperty Address_Email_Fonctionnaire;
	private final StringProperty PassWord_Fonctionnaire;
	private final StringProperty CodeIdentiction_Fonctionnaire;
	private final IntegerProperty Numero_Telephone_Fonctionnaire;
	private final StringProperty Genre_Fonctionnaire;
	private final StringProperty DATE_naissance_Fonctionnaire_Fonctionnaire;
	private final StringProperty AdressLocalisation_Fonctionnaire;
	private final IntegerProperty Id_Nationalite_Fonctionnaire;
	private final StringProperty Nationalite_Fonctionnaire;
	private final IntegerProperty Id_Fonction_Fonctionnaire;
	private final StringProperty Fonction_Fonctionnaire;
	private InputStream photo_Fonctionnaire;
    private final StringProperty Matricule_Fonctionnaire;
	private Timestamp dateInscriptionF_Fonctionnaire;
	private IntegerProperty age_Fonctionnaire;
	
	public ControllersFonctionaire(int ID_fonct,String Prenomfonct,String Nomfonct, String AddressEmailfonct , String PassWordfonct ,
			String CodeIdentfonct ,  int Numerofonct ,String Genrefonct, String DateNaissancefonct,
			String AddressLocalisatinFont, int ID_Nationalitefont,  String Nationalitefont ,int ID_Fonction_Font ,String Fonction_font,
			Blob phototfont ,String matriculefont ,Timestamp inscriptionfont, int Agefont) throws FileNotFoundException, SQLException {
		
		this.ID_Fonctionnaire = new SimpleIntegerProperty(ID_fonct);
		this.Prenom_Fonctionnaire = new SimpleStringProperty(Prenomfonct);
		this.Nom_Fonctionnaire = new SimpleStringProperty(Nomfonct);
		this.Address_Email_Fonctionnaire = new SimpleStringProperty(AddressEmailfonct);
		this.PassWord_Fonctionnaire = new SimpleStringProperty(PassWordfonct);
		this.CodeIdentiction_Fonctionnaire = new SimpleStringProperty(CodeIdentfonct);
		this.Numero_Telephone_Fonctionnaire = new SimpleIntegerProperty(Numerofonct);
		this.Genre_Fonctionnaire = new SimpleStringProperty(Genrefonct);
		this.DATE_naissance_Fonctionnaire_Fonctionnaire = new SimpleStringProperty(DateNaissancefonct);
		this.AdressLocalisation_Fonctionnaire = new SimpleStringProperty(AddressLocalisatinFont);
		this.Id_Nationalite_Fonctionnaire = new SimpleIntegerProperty(ID_Nationalitefont);
		this.Nationalite_Fonctionnaire = new SimpleStringProperty(Nationalitefont);
		this.Id_Fonction_Fonctionnaire = new SimpleIntegerProperty(ID_Fonction_Font);
		this.Fonction_Fonctionnaire = new SimpleStringProperty(Fonction_font);
		this.photo_Fonctionnaire = phototfont.getBinaryStream();
		this.Matricule_Fonctionnaire = new SimpleStringProperty(matriculefont);
		this.dateInscriptionF_Fonctionnaire = inscriptionfont;
		this.age_Fonctionnaire = new SimpleIntegerProperty(Agefont);
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
	/*----------------------------------------------------- Les conecteur et les Commitateru-----------------------------------------------*/	
	public IntegerProperty getID_Fonctionnaire() {
		return ID_Fonctionnaire;
	}
	public StringProperty getPrenom_Fonctionnaire() {
		return Prenom_Fonctionnaire;
	}
	public StringProperty getNom_Fonctionnaire() {
		return Nom_Fonctionnaire;
	}
	public StringProperty getAddress_Email_Fonctionnaire() {
		return Address_Email_Fonctionnaire;
	}
	public StringProperty getPassWord_Fonctionnaire() {
		return PassWord_Fonctionnaire;
	}
	public StringProperty getCodeIdentiction_Fonctionnaire() {
		return CodeIdentiction_Fonctionnaire;
	}
	public IntegerProperty getNumero_Telephone_Fonctionnaire() {
		return Numero_Telephone_Fonctionnaire;
	}
	public StringProperty getGenre_Fonctionnaire() {
		return Genre_Fonctionnaire;
	}
	public StringProperty getDATE_naissance_Fonctionnaire_Fonctionnaire() {
		return DATE_naissance_Fonctionnaire_Fonctionnaire;
	}
	public StringProperty getAdressLocalisation_Fonctionnaire() {
		return AdressLocalisation_Fonctionnaire;
	}
	public IntegerProperty getId_Nationalite_Fonctionnaire() {
		return Id_Nationalite_Fonctionnaire;
	}
	public StringProperty getNationalite_Fonctionnaire() {
		return Nationalite_Fonctionnaire;
	}
	public IntegerProperty getId_Fonction_Fonctionnaire() {
		return Id_Fonction_Fonctionnaire;
	}
	public StringProperty getFonction_Fonctionnaire() {
		return Fonction_Fonctionnaire;
	}
	public InputStream getphoto_Fonctionnaire() {
		return photo_Fonctionnaire;
	}
	public void setphoto_Fonctionnaire(FileInputStream valeurphoto_Fonctionnaire) {
		this.photo_Fonctionnaire = valeurphoto_Fonctionnaire;
	}
	public StringProperty getMatricule_Fonctionnaire() {
		return Matricule_Fonctionnaire;
	}
	public Timestamp getDateInscriptionF_Fonctionnaire() {
		return dateInscriptionF_Fonctionnaire;
	}
	public void setDateInscriptionF_Fonctionnaire(Timestamp valeurDate) {
		this.dateInscriptionF_Fonctionnaire = valeurDate;
	}
	public IntegerProperty getAge_Fonctionnaire() {
		return age_Fonctionnaire;
	}
	public void setAge_Fonctionnaire(IntegerProperty valeurage) {
		this.age_Fonctionnaire = valeurage;
	}

	

	public StringProperty getRechercheCompte() {
		return SercherPersonne;
	}
	public void  setRechercheCompte(StringProperty valeurRech) {
		this.SercherPersonne = valeurRech;
	}
	
	public StringProperty getSercherPersonne() {
		return SercherPersonne;
	}
	
	public CheckBox getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
}
