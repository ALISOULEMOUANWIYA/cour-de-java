package PackegeDesdonne;

import java.io.InputStream;
import java.sql.Timestamp;


public class DescriptionDataCompte {
	
	
	private  int ID_UtilDescription;
	private String prenomUtilDescription;
	private String NomUtilDescription;
	private String AddressUtilDescription;
	private String AnneUtilNaissance;
	private String genreUtilDescription;
	private String MatricleUtilDescription;
	private String NationalUtilDescription;
	private int NationaDescription;
	private String fonctionDescription;
	private int fonctionDescriptionutil;
	private Timestamp dateInscription;
	private int ageutilisateur;
	private InputStream photoUtilDescription;
	
	public DescriptionDataCompte() {
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
	
	
	public  String getAnneUtilNaissance() {
		return AnneUtilNaissance;
	}
	public void setAnneUtilNaissance(String valeurAnne) {
		this.AnneUtilNaissance = valeurAnne;
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
	public String getNationalUtDescription() {
		return NationalUtilDescription;
	}
	public void setNationalUtDescription(String valeurNat) {
		this.NationalUtilDescription = valeurNat;
	}
	
	public int getNationaDescription() {
		return NationaDescription;
	}
	public void setNationaDescription(int valeurnationaDescription) {
		this.NationaDescription = valeurnationaDescription;
	}
	
	public String getFonctionDescription() {
		return fonctionDescription;
	}
	public void setFonctionDescription(String valeurfonct) {
		this.fonctionDescription = valeurfonct;
	}
	
	public int getFonctionDescriptionutil() {
		return fonctionDescriptionutil;
	}
	public void setFonctionDescriptionutil(int valeurfonctionDescriptionutil) {
		this.fonctionDescriptionutil = valeurfonctionDescriptionutil;
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
