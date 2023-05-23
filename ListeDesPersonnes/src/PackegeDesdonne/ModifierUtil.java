package PackegeDesdonne;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ModifierUtil {

	private static boolean ModifierUtilisateur;
	
	private static int ID_Util;
	private static String prenomUtil;
	private static String NomUtil;
	private static String AddressUtil;
	private static String AnneUtil;
	private static String genreUtil;
	private static int NationalUtil;
	private static int fonction;
	private static InputStream photoUtil;
	
	public static List<DescriptionDataCompte> descriptionScroller = new ArrayList<>();
	public static List<DescriptionDataCompteLister> descriptionScrollerLister = new ArrayList<>();
	private static int TableauIdeDemarage [];
	
	private String Matriculeutil;
	
	public ModifierUtil() {

	}
	
	public static void afficher() {
		System.out.println("ID : "+ID_Util);
		System.out.println("Prenom : "+prenomUtil);
		System.out.println("Nom : "+NomUtil);
		System.out.println("Address : "+AddressUtil);
		System.out.println("Naissance : "+AnneUtil);
		System.out.println("Genre : "+genreUtil);
		System.out.println("Nationalite : "+NationalUtil);
		System.out.println("Fonction : "+fonction);
		System.out.println("Verification : "+ModifierUtilisateur);
	}
	
	public static void afficherDescriptionLister() {
		System.out.println("Scroller lister Size = "+descriptionScrollerLister.size()+"\n");
		for(int i = 0; i < descriptionScrollerLister.size(); i++ ) 
		{
       		System.out.println("ID = "+descriptionScrollerLister.get(i).getID_UtilDescription());
       		System.out.println("Prenom = "+descriptionScrollerLister.get(i).getPrenomUtilDescription());
       		System.out.println("Nom = "+descriptionScrollerLister.get(i).getNomUtilDescription());
       		System.out.println("Genre = "+descriptionScrollerLister.get(i).getGenreUtilDescription());
       		System.out.println("Address = "+descriptionScrollerLister.get(i).getAddressUtilDescription());
       		System.out.println("Naissance = "+descriptionScrollerLister.get(i).getAnneUtilNaissance());
       		System.out.println("ID nationalite = "+descriptionScrollerLister.get(i).getNationalUtDescription());
       		System.out.println("ID Fonction = "+descriptionScrollerLister.get(i).getFonctionDescription());
       		System.out.println("Photo = "+descriptionScrollerLister.get(i).getPhotoUtilDescription());
       		System.out.println("Matricule = "+descriptionScrollerLister.get(i).getMatricleUtilDescription());
       		System.out.println("Date Inscription = "+descriptionScrollerLister.get(i).getDateInscription());
       		System.out.println("Age = "+descriptionScrollerLister.get(i)+"\n\n------------------\n");
		}
	}
	
	public static void afficherDescription() {
		System.out.println("Scroller Size = "+descriptionScroller.size()+"\n");
		for(int i = 0; i < descriptionScroller.size(); i++ ) 
		{
       		System.out.println("ID = "+descriptionScroller.get(i).getID_UtilDescription());
       		System.out.println("Prenom = "+descriptionScroller.get(i).getPrenomUtilDescription());
       		System.out.println("Nom = "+descriptionScroller.get(i).getNomUtilDescription());
       		System.out.println("Genre = "+descriptionScroller.get(i).getGenreUtilDescription());
       		System.out.println("Address = "+descriptionScroller.get(i).getAddressUtilDescription());
       		System.out.println("Naissance = "+descriptionScroller.get(i).getAnneUtilNaissance());
       		System.out.println("ID nationalite = "+descriptionScroller.get(i).getNationalUtDescription());
       		System.out.println("ID Fonction = "+descriptionScroller.get(i).getFonctionDescription());
       		System.out.println("Photo = "+descriptionScroller.get(i).getPhotoUtilDescription());
       		System.out.println("Matricule = "+descriptionScroller.get(i).getMatricleUtilDescription());
       		System.out.println("Date Inscription = "+descriptionScroller.get(i).getDateInscription());
       		System.out.println("Age = "+descriptionScroller.get(i)+"\n\n------------------\n");
		}
	}
	  public List<DescriptionDataCompte> getDescriptionScroller() {
		return descriptionScroller;
	  }
	  public void setDescriptionScroller(List<DescriptionDataCompte> valeurdescription) {
		this.descriptionScroller = valeurdescription;
		
	  }
	  public List<DescriptionDataCompteLister> getDescriptionScrollerLister() {
			return descriptionScrollerLister;
	  }
	  public void setDescriptionScrollerLister(List<DescriptionDataCompteLister> valeurdescriptionLister) {
		this.descriptionScrollerLister = valeurdescriptionLister;
			
	  }
   public static int[] getTableauIdeDemarage() {
	return TableauIdeDemarage;
   }
   public static void setTableauIdeDemarage(int[] tableauIdeDemarage) {
	TableauIdeDemarage = tableauIdeDemarage;
   }
	
	public static void setModifierUtilisateur(boolean valeur) {
		ModifierUtilisateur = valeur;
	}
	
	public static boolean getModifierUtilisateur() {
		return ModifierUtilisateur;
	}
	
	
	/*****/
	public static int getID_Util() {
		return ID_Util;
	}
	public static void setID_Util(int valeurID) {
		ID_Util = valeurID;
	}
	public static String getPrenomUtil() {
		return prenomUtil;
	}
	public static void setPrenomUtil(String valeurPre) {
		prenomUtil = valeurPre;
	}
	
	public static String getNomUtil() {
		return NomUtil;
	}
	public static void setNomUtil(String valeurNom) {
		NomUtil = valeurNom;
	}
	
	public static String getAddressUtil() {
		return AddressUtil;
	}
	public static void setAddressUtil(String valeurAddr) {
		AddressUtil = valeurAddr;
	}
	
	
	public static String getAnneUtil() {
		return AnneUtil;
	}
	public static void setAnneUtil(String valeurAnne) {
		AnneUtil = valeurAnne;
	}

	public static String getGenreUtil() {
		return genreUtil;
	}
	public static void setGenreUtil(String valeurGenr) {
		genreUtil = valeurGenr;
	}
	
	public static int getNationalUt() {
		return NationalUtil;
	}
	public static void setNationalUt(int valeurNat) {
		NationalUtil = valeurNat;
	}

	public static  int getFonction() {
		return fonction;
	}
	public static  void setFonction(int valeurfonct) {
		fonction = valeurfonct;
	}

	public static InputStream getPhotoUtil() {
		return photoUtil;
	}
	public static  void setPhotoUtil(InputStream valeurPhot) {
		photoUtil = valeurPhot;
	}
	
}
