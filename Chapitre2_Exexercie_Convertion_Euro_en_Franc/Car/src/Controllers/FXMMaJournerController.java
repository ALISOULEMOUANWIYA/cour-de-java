/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pc
 */
public class FXMMaJournerController implements Initializable {

    @FXML
    private JFXButton seConnecterEnLing;
    
    @FXML
    private JFXButton seDeconnecterEnLing1;

    @FXML
    private JFXHamburger icon;

    @FXML
    private JFXDrawer slider;
    
    @FXML
    private ImageView demotrativeSense;
    
    @FXML
    private AnchorPane BarMainAccuile;

    @FXML
    private AnchorPane MainAccuile1;
    
    
    private double xOffset = 0;
    private double yOffset = 0;
    private double position1 = -1010;
    private double position2 = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	seDeconnecterEnLing1.setVisible(false);
    	try {
    		
    		//demotrativeSense.setRotate(180);
    		AnchorPane v = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
    		 
    	     slider.setLayoutX(position1);
    	     slider.setStyle("-fx-background-radius: 5em;");
            slider.setSidePane(v);
            

            HamburgerBasicCloseTransition hbct = new HamburgerBasicCloseTransition(icon);
            hbct.setRate(-1);
            icon.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
                                                System.out.println("cliquer");
                hbct.setRate(hbct.getRate()*-1);
                hbct.play();
                
            if(slider.isOpened()){
            	
	                slider.close();
	                BarMainAccuile.setVisible(true);
	        		MainAccuile1.setVisible(true);
	        		
	                slider.setLayoutX(position1);
	               // demotrativeSense.setRotate(180);
                }else{
                	
                	BarMainAccuile.setVisible(false);
            		MainAccuile1.setVisible(false);
            		
	                slider.open();
	                slider.setLayoutX(position2);
	                //demotrativeSense.setRotate(0);
                }   
                

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
