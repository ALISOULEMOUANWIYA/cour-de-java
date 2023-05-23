/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author pc
 */
public class FXMMaJournerController implements Initializable {
	

    @FXML
    private BorderPane PageNavigationAvecConnexion;

    @FXML
    private BorderPane PageNavigationSansConnexion;

    @FXML
    private BorderPane sliderPage;

    @FXML
    private AnchorPane AnchorComponante;

    @FXML
    private BorderPane slider;
    
    @FXML
    private Pane buttonMenu1;

    @FXML
    private JFXHamburger iconeMenu;
    
    @FXML
    private Pane buttonMenuConnection;
    
    @FXML
    private JFXHamburger icon;
    
    @FXML
    private ImageView demotrativeSense;
    
    @FXML
    private AnchorPane BarMainAccuile;

    @FXML
    private AnchorPane MainAccuile1;
    
    @FXML
    private JFXButton seConnecterEnLing;
    
    private int verificateur = 0;
    
    private double xOffset = 0;
    private double yOffset = 0;
    private double position1 = -1272;
    private double position2 = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	//seDeconnecterEnLing1.setVisible(false);
    	try {
    		
    		
    		//demotrativeSense.setRotate(180);
    		  AnchorPane root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
	    	slider.setCenter(root);
    		slider.setTranslateX(position1);
    		
            HamburgerBasicCloseTransition hbct = new HamburgerBasicCloseTransition(icon);
            hbct.setRate(-1);
            
            
            icon.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
            	
            	
            	
            	if(verificateur == 0) {
                      
            		  System.out.println("cliquer");
	                  hbct.setRate(hbct.getRate()*-1);
	                  hbct.play();
	                
		             TranslateTransition slid = new  TranslateTransition();
		             
		             slid.setDuration(javafx.util.Duration.seconds(0.4));
		             slid.setNode(slider);
		             
		             slid.setToX(position2);
		             slid.play();
		             
		             slider.setTranslateX(position1);
		             
		             slid.setOnFinished((ActionEvent event) -> {
		            	 MainAccuile1.setVisible(false);
		            	 BarMainAccuile.setVisible(false);
		             });
		             verificateur = 1;
            	}else {
            		 System.out.println("cliquer");
	                  hbct.setRate(hbct.getRate()*-1);
	                  hbct.play();
	                
		             TranslateTransition slid = new  TranslateTransition();
		             
		             slid.setDuration(javafx.util.Duration.seconds(0.4));
		             slid.setNode(slider);
		             
		             slid.setToX(position1);
		             slid.play();
		             
		             slider.setTranslateX(position2);
		             
		             slid.setOnFinished((ActionEvent event) -> {
		            	 MainAccuile1.setVisible(true);
		            	 BarMainAccuile.setVisible(true);
		             });
		             verificateur = 0;
            	}
                System.out.println(verificateur);
            });
                 
            } catch (Exception e) {
            	
            }
    }    

    @FXML
    private void EtreEnLinge(ActionEvent event) throws IOException {
        seConnecterEnLing.getScene().getWindow().hide(); 
        
        Stage enligne = new Stage();
        enligne.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                enligne.setX(event.getScreenX() - xOffset );
                enligne.setY(event.getScreenY() - yOffset );
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        enligne.setScene(scene);
        enligne.show();
        enligne.setResizable(false);
    }
 

    @FXML
    void SortirEnLinge(ActionEvent event) {

    }
    
}
