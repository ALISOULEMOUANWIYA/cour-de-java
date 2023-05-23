package ControllerFXMLListe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Lister.MisActualisation;
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

public class ControllersScrollerGrideCompte implements Initializable{
	
    @FXML
    private ScrollPane ScrollePane;

    @FXML
    private AnchorPane anchorpanegride;

    @FXML
    private GridPane gride;
	/************************************/
	    private int ajouterSiVraia = 0;
	/***********************************/
	    private MisActualisation reproduirFigureAjour;
	    
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
			System.out.println("Scroller Nombre de Description = "+ModifierUtil.descriptionScroller.size());
			System.out.println("Scroller Nombre de box = "+getAjouterSiVraia());
			System.out.println("Scroller Nombre de Description - "+" Description Ajouter = "+(ModifierUtil.descriptionScroller.size()-getAjouterSiVraia()));
			TailleTableau = (ModifierUtil.descriptionScroller.size()-getAjouterSiVraia());
			System.out.println("Scroller TAille du tableau = "+TailleTableau);
			System.out.println("\n\n같같같같같같같같같같같같같같같같같같같같같같같�\n");
			System.out.println("VIDE\n");
			System.out.println("\n\n같같같같같같같같같같같같같같같같같같같같같같같�\n");
		try {
			if(ModifierUtil.descriptionScrollerLister.size() > getAjouterSiVraia()) {
				 for(int i = 0; i < ModifierUtil.descriptionScroller.size() ; i++ ) 
				  {
					  FXMLLoader fxmlLaoder = new FXMLLoader();
					  fxmlLaoder.setLocation(getClass().getResource("/fxmlListe/DescriptionTotaleUtilisateur.fxml"));
					  AnchorPane anchorPane = fxmlLaoder.load();
								
								
					  controllersGrideCompte controllerCompte = fxmlLaoder.getController();
					  controllerCompte.setDate(ModifierUtil.descriptionScroller.get(i), reproduirFigureAjour);
								
					  if(Column == 3) {
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
								
					  GridPane.setMargin(anchorPane, new Insets(10));
								
					  ajouterSiVraia++; 
					  //ModifierUtil.descriptionScrollerLister.get(i).getPhotoUtilDescription().reset();
				}
				 anchorpanegride.setPrefHeight(anchorpanegride.getPrefHeight()+(50*getAjouterSiVraia()));	
		    }
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
    public int getAjouterSiVraia() {
		return ajouterSiVraia;
	}
    public void setAjouterSiVraia(int ajouterSiVraia) {
		this.ajouterSiVraia = ajouterSiVraia;
	}
}
