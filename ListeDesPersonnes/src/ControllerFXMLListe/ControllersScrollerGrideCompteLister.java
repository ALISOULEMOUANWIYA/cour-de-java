package ControllerFXMLListe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.query.criteria.internal.expression.function.SqrtFunction;

import PackegeDesdonne.ModifierUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllersScrollerGrideCompteLister implements Initializable{
	
    @FXML
    private ScrollPane ScrollePane;

    @FXML
    private AnchorPane anchorpanegride;

    @FXML
    private GridPane gride;
	/************************************/
	    private int ajouterSiVraia = 0;
	    private int prouverOgmenter = 0;
	/***********************************/
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Stage enligne = new Stage();
		enligne.initStyle(StageStyle.TRANSPARENT);
			afficherCompteDescription();
	}


	
	private void afficherCompteDescription()  {
		System.out.println("\n\n***********************************************\n");
		ModifierUtil.afficherDescription();
		setAjouterSiVraia(0);
		int Column = 0;
		int Row = 1;
		int TailleTableau = 0;
			System.out.println("\n\n###########################################################\n");
			System.out.println("Scroller Nombre de Description = "+ModifierUtil.descriptionScrollerLister.size());
			System.out.println("Scroller Nombre de box = "+getAjouterSiVraia());
			System.out.println("Scroller Nombre de Description - "+" Description Ajouter = "+(ModifierUtil.descriptionScrollerLister.size()-getAjouterSiVraia()));
			TailleTableau = (ModifierUtil.descriptionScrollerLister.size()-getAjouterSiVraia());
			System.out.println("Scroller TAille du tableau = "+TailleTableau);
			System.out.println("\n\n같같같같같같같같같같같같같같같같같같같같같같같�\n");
			System.out.println("VIDE\n");
			System.out.println("\n\n같같같같같같같같같같같같같같같같같같같같같같같�\n");
		try {
			if(ModifierUtil.descriptionScrollerLister.size() > getAjouterSiVraia()) {
				for(int i = 0; i < ModifierUtil.descriptionScrollerLister.size() ; i++ ) 
				  {
					  FXMLLoader fxmlLaoder = new FXMLLoader();
					  fxmlLaoder.setLocation(getClass().getResource("/fxmlListe/DescriptionTotaleUtilisateurLister.fxml"));
					  AnchorPane anchorPane = fxmlLaoder.load();
								
								
					  controllersGrideCompteLister controllerCompte = fxmlLaoder.getController();
					  controllerCompte.setDateLister(ModifierUtil.descriptionScrollerLister.get(i));
								
					  if(Column == 1) {
						Column = 0;
						Row ++;
					  }
								
					  gride.add(anchorPane, Column++, Row);
					  // ajustement du Longeur
					  gride.setMinWidth(Region.USE_COMPUTED_SIZE);
					  gride.setPrefWidth(Region.USE_COMPUTED_SIZE);
					  gride.setMaxWidth(Region.USE_PREF_SIZE);
								
				      // ajustement du Largeur
					  gride.setMinHeight(Region.USE_COMPUTED_SIZE);
					  gride.setPrefHeight(Region.USE_COMPUTED_SIZE);
					  gride.setMaxHeight(Region.USE_PREF_SIZE);
								
					  GridPane.setMargin(anchorPane, new Insets(5));
								
					  ajouterSiVraia++;
					  //ModifierUtil.descriptionScrollerLister.get(i).getPhotoUtilDescription().reset();
				}
				anchorpanegride.setPrefHeight(anchorpanegride.getPrefHeight()+((80+getAjouterSiVraia())*getAjouterSiVraia()));
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public int getProuverOgmenter() {
		return prouverOgmenter;
	}
	public void setProuverOgmenter(int valeurprouverOgmenter) {
		this.prouverOgmenter = valeurprouverOgmenter;
	}
    public int getAjouterSiVraia() {
		return ajouterSiVraia;
	}
    public void setAjouterSiVraia(int ajouterSiVraia) {
		this.ajouterSiVraia = ajouterSiVraia;
	}
}
