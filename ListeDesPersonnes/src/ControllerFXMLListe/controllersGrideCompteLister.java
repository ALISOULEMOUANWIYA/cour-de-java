package ControllerFXMLListe;

import java.io.IOException;
import java.io.InputStream;

import PackegeDesdonne.DescriptionDataCompte;
import PackegeDesdonne.DescriptionDataCompteLister;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class controllersGrideCompteLister {
	
	
	    @FXML
	    private AnchorPane anchorpaneDescription;


	    @FXML
	    private Button GenreUtilisateurCompte;
	    @FXML
	    private Button NaissanceUtilisateurCompte;
	    @FXML
	    private Button AddressUtilisateurCompte;
	    @FXML
	    private Button FonctionUtilisateurCompte;
	    @FXML
	    private Button NationailterUtilisateurCompte;
	    @FXML
	    private Button InscriptionUtilisateurCompte;
	    @FXML
	    private Button AgeUtilisateurCompte;
	    @FXML
	    private Button IdentiterUtilisateurCompte;
	    @FXML
	    private Label NomPrenomUtilisateurCompte;
	    
	    @FXML
	    private Circle CirclePhototProfile;
	    @FXML
	    private Circle CirclePhototcouverture;

	    private DescriptionDataCompteLister compteDescription;

		private void ProfilePhoto(InputStream couverturPhtot) throws IOException {
			//debut photo de profile utilisateur-----------------------------------------------------------------------------
				CirclePhototProfile.setStroke(Color.SEAGREEN);
		        Image im = new Image(couverturPhtot);
		        System.out.println(""+couverturPhtot);
		        CirclePhototProfile.setFill(new ImagePattern(im));
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
	
	public  void setDateLister(DescriptionDataCompteLister descriptionUtilisateur) throws IOException {
		this.compteDescription = descriptionUtilisateur;
		
		
		//ID
		NomPrenomUtilisateurCompte.setText(descriptionUtilisateur.getNomUtilDescription()+" "+descriptionUtilisateur.getPrenomUtilDescription());
		GenreUtilisateurCompte.setText(""+descriptionUtilisateur.getGenreUtilDescription());
		AddressUtilisateurCompte.setText(""+descriptionUtilisateur.getAddressUtilDescription());
        //*******************************************************************************
		  ProfilePhoto(descriptionUtilisateur.getPhotoUtilDescription());
        //fin****************************************************************************
		FonctionUtilisateurCompte.setText(""+descriptionUtilisateur.getFonctionDescription());
		NationailterUtilisateurCompte.setText(""+descriptionUtilisateur.getNationalUtDescription());
		NaissanceUtilisateurCompte.setText(""+descriptionUtilisateur.getAnneUtilNaissance());
		IdentiterUtilisateurCompte.setText(descriptionUtilisateur.getMatricleUtilDescription());
		InscriptionUtilisateurCompte.setText(""+descriptionUtilisateur.getDateInscription());
		AgeUtilisateurCompte.setText(""+descriptionUtilisateur.getAgeutilisateur());
        //*******************************************************************************
          CouvertureLogo(descriptionUtilisateur.getPhotoUtilDescription());
        //fin****************************************************************************
		descriptionUtilisateur.getPhotoUtilDescription().reset();
	}

}
