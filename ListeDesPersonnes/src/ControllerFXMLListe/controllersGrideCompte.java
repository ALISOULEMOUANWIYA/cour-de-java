package ControllerFXMLListe;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersListeDialogueBox;
import Lister.MisActualisation;
import PackegeDesdonne.DescriptionDataCompte;
import PackegeDesdonne.ModifierUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controllersGrideCompte implements Initializable{
	
	
	    @FXML
	    private AnchorPane anchorpaneDescription;

	    @FXML
	    private Pane panephotoCouverture;
	    
	    @FXML
	    private Circle CirclePhotoProfile;
	    @FXML
	    private Circle CirclePhototcouverture;

	    @FXML
	    private Label MAtriculeCompte;
	    @FXML
	    private Label NomCompte;
	    @FXML
	    private Label labelCompteSuprimer;
	    
	    @FXML
	    private Button ModiferiComptePhotoProfile;
	    @FXML
	    private Button modifierComptephotoCOuverture;
	    @FXML
	    private Button ModifierCompte;
	    @FXML
	    private Button AddressCompte;
	    @FXML
	    private Button GenreCompte;
	    @FXML
	    private Button NaissanceCompte;
	    @FXML
	    private Button FonctionCompte;
	    @FXML
	    private Button NationaliteCompte;
	    @FXML
	    private Button InscriptionCompte;
	    @FXML
	    private Button AgeCompte;
	    
	    
	    @FXML
	    private MenuButton menuItemetacheChoix;
	    @FXML
	    private MenuItem ButtonModifer;
	    @FXML
	    private MenuItem buttonSuprimer;


	    
	    
	    private DataAccessObject dao;
	    private DescriptionDataCompte compteDescription;
	    private MisActualisation misActualisation;
	    private String refrechirListe;
	    private boolean moficationDebut = true;
	    private FXMLLoader loader;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			dao = new DataAccessObject();
			ButtonModifer.setOnAction(e ->{
				try {
					editAcount(compteDescription);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		}	
	    @FXML
	    private void SuprimerCompteUtilisateur(ActionEvent event) {
	    	InactifeCompte(compteDescription);
	    }
		private void editAcount(DescriptionDataCompte decriptionModifier) throws IOException {
			modififer(decriptionModifier);
	    	try {
					loader = new FXMLLoader();
					
					Stage stage = new Stage();
					stage.initStyle(StageStyle.TRANSPARENT);
				
					loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxInscription.fxml"));
					loader.load();
				Scene scene = new Scene(loader.getRoot());
				scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
	
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
				
			   
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	private void modififer(DescriptionDataCompte decriptionModifier) {
	    	ModifierUtil.setModifierUtilisateur(moficationDebut);
    		ModifierUtil.setID_Util(decriptionModifier.getID_UtilDescription());
    		ModifierUtil.setPrenomUtil(decriptionModifier.getPrenomUtilDescription());
    		ModifierUtil.setNomUtil(decriptionModifier.getNomUtilDescription());
    		ModifierUtil.setAddressUtil(decriptionModifier.getAddressUtilDescription());
    		ModifierUtil.setAnneUtil(decriptionModifier.getAnneUtilNaissance());
    		ModifierUtil.setGenreUtil(decriptionModifier.getGenreUtilDescription());
    		ModifierUtil.setNationalUt(decriptionModifier.getNationaDescription());
    		ModifierUtil.setFonction(decriptionModifier.getFonctionDescriptionutil());
    		//ModifierUtil.setPhotoUtil(selected.getPhotoUtilisateur().get());
    		ModifierUtil.afficher();
    	}
	    private void InactifeCompte(DescriptionDataCompte Description) {
	    	System.out.println("Compte ID "+Description.getID_UtilDescription());
	    	labelCompteSuprimer.setVisible(true);
	    	NomCompte.setDisable(true);
	    	GenreCompte.setDisable(true);
	    	AddressCompte.setDisable(true);
	    	FonctionCompte.setDisable(true);
			NationaliteCompte.setDisable(true);
			NaissanceCompte.setDisable(true);
			MAtriculeCompte.setDisable(true);
			InscriptionCompte.setDisable(true);
			AgeCompte.setDisable(true);
			CirclePhotoProfile.setDisable(true);
			CirclePhototcouverture.setDisable(true);
			ModiferiComptePhotoProfile.setDisable(true);
			modifierComptephotoCOuverture.setDisable(true);
			menuItemetacheChoix.setDisable(true);
	    	refrechirListe = "DELETE FROM tachaide.compte_utilisateur WHERE compte_ID = "+Description.getID_UtilDescription()+"";
    		dao.saveData(refrechirListe);
	    }
		private void ProfilePhoto(InputStream couverturPhtot) throws IOException {
			//debut photo de profile utilisateur-----------------------------------------------------------------------------
			    CirclePhotoProfile.setStroke(Color.SEAGREEN);
		        Image im = new Image(couverturPhtot);
		        System.out.println(""+couverturPhtot);
		        CirclePhotoProfile.setFill(new ImagePattern(im));
		        couverturPhtot.reset();
	       //fin----------------------------------------------------------------------------
		}
		private void CouvertureLogo(InputStream couverturPhtot) {
	       //debut photo de couverture utilisateur----------------------------------------------------------------------------
		        CirclePhototcouverture.setStroke(Color.BEIGE);
		        Image im = new Image(couverturPhtot);
		        System.out.println(""+couverturPhtot);
		        CirclePhototcouverture.setFill(new ImagePattern(im));
	       //fin----------------------------------------------------------------------------
		}
	
	 public  void setDate(DescriptionDataCompte descriptionUtilisateur, MisActualisation donnerDescriptionDegrider) throws IOException {
		this.compteDescription = descriptionUtilisateur;
		this.misActualisation = donnerDescriptionDegrider;
		
		labelCompteSuprimer.setVisible(false);
		//ID
		NomCompte.setText(descriptionUtilisateur.getNomUtilDescription()+" "+descriptionUtilisateur.getPrenomUtilDescription());
		GenreCompte.setText(""+descriptionUtilisateur.getGenreUtilDescription());
		AddressCompte.setText(""+descriptionUtilisateur.getAddressUtilDescription());
		//-----------------------------------------------------------------------------
		   ProfilePhoto(descriptionUtilisateur.getPhotoUtilDescription());
        //fin----------------------------------------------------------------------------
        //*******************************************************************************
           CouvertureLogo(descriptionUtilisateur.getPhotoUtilDescription());
        //fin****************************************************************************
		FonctionCompte.setText(""+descriptionUtilisateur.getFonctionDescription());
		NationaliteCompte.setText(""+descriptionUtilisateur.getNationalUtDescription());
		NaissanceCompte.setText(""+descriptionUtilisateur.getAnneUtilNaissance());
		MAtriculeCompte.setText(descriptionUtilisateur.getMatricleUtilDescription());
		InscriptionCompte.setText(""+descriptionUtilisateur.getDateInscription());
		AgeCompte.setText(""+descriptionUtilisateur.getAgeutilisateur());
		descriptionUtilisateur.getPhotoUtilDescription().reset();
	}




   
}
