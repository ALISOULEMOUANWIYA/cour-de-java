package PackegeDesdonne;

import java.io.InputStream;
import java.sql.Timestamp;

public class DataApresEchangeMisAjoure {

	private  int ID_UtilDescription;
	private String prenomUtilDescription;
	private String NomUtilDescription;
	private String AddressUtilDescription;
	private String AnneUtilDescription;
	private String genreUtilDescription;
	private String MatricleUtilDescription;
	private int NationalUtilDescription;
	private int fonctionDescription;
	private Timestamp dateInscription;
	private int ageutilisateur;
	private InputStream photoUtilDescription;
	
	public DataApresEchangeMisAjoure() {
	}
	
	/**********************************/
	public int getID_UtilDescription() {
		return ID_UtilDescription;
	}
	public void setID_UtilDescription(int valeurID) {
		this.ID_UtilDescription = valeurID;
	}
	public String getPrenomUtilDescription() {
		return prenomUtilDescription;
	}
	public void setPrenomUtilDescription(String valeurPre) {
		this.prenomUtilDescription = valeurPre;
	}
	
	public String getNomUtilDescription() {
		return NomUtilDescription;
	}
	public void setNomUtilDescription(String valeurNom) {
		this.NomUtilDescription = valeurNom;
	}
	
	public  String getAddressUtilDescription() {
		return AddressUtilDescription;
	}
	public void setAddressUtilDescription(String valeurAddr) {
		this.AddressUtilDescription = valeurAddr;
	}
	
	
	public  String getAnneUtilDescription() {
		return AnneUtilDescription;
	}
	public void setAnneUtilDescription(String valeurAnne) {
		this.AnneUtilDescription = valeurAnne;
	}

	public String getGenreUtilDescription() {
		return genreUtilDescription;
	}
	public void setGenreUtilDescription(String valeurGenr) {
		this.genreUtilDescription = valeurGenr;
	}
	
	public String getMatricleUtilDescription() {
		return MatricleUtilDescription;
	}
	public void setMatricleUtilDescription(String valeurMat) {
		this.MatricleUtilDescription = valeurMat;
	}
	public int getNationalUtDescription() {
		return NationalUtilDescription;
	}
	public void setNationalUtDescription(int valeurNat) {
		this.NationalUtilDescription = valeurNat;
	}

	public  int getFonctionDescription() {
		return fonctionDescription;
	}
	public void setFonctionDescription(int valeurfonct) {
		this.fonctionDescription = valeurfonct;
	}
	
	public Timestamp getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Timestamp valeurdate) {
		this.dateInscription = valeurdate;
	}
	
	public int getAgeutilisateur() {
		return ageutilisateur;
	}
	public void setAgeutilisateur(int valeurage) {
		this.ageutilisateur = valeurage;
	}
	
	public InputStream getPhotoUtilDescription() {
		return photoUtilDescription;
	}
	public void setPhotoUtilDescription(InputStream valeurPhot) {
		this.photoUtilDescription = valeurPhot;
	}
	
	
}
