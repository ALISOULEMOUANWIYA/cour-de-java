/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import BDConnection.DBHabdler;

public class SingUPController implements Initializable {
    
    @FXML
    private JFXTextField Email;

    @FXML
    private JFXTextField NomUtilisateur;

    @FXML
    private JFXPasswordField MotDepasse;

    @FXML
    private JFXRadioButton checkHomme;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXRadioButton checkfemme;

    @FXML
    private JFXTextField localisationUtilisateur;

    @FXML
    private JFXButton Inscription;

    @FXML
    private ImageView loadeApres;

    @FXML
    private JFXButton connexionUtilisateur;

    @FXML
    private ImageView connexionGoogle;

    @FXML
    private ImageView connexionTweet;

    @FXML
    private ImageView connexionFacebook;
    
    @FXML
    private ImageView chargementApres;
    
    private Connection connection;
    private DBHabdler handler;
    private PreparedStatement pst;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargementApres.setVisible(false);
        loadeApres.setVisible(true);
        Email.setStyle("-fx-text-inner-color: #FFFFFF;");
        NomUtilisateur.setStyle("-fx-text-inner-color: #FFFFFF;");
        MotDepasse.setStyle("-fx-text-inner-color: #FFFFFF;");
        localisationUtilisateur.setStyle("-fx-text-inner-color: #FFFFFF;");
        
        handler = new DBHabdler();
    }    

    @FXML
    public void singUpAction(ActionEvent event) {
        loadeApres.setVisible(false);
        chargementApres.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
            
        });
        
        pt.play();
        
        // sauvagarde à la base de donner
          String insert = "INSERT INTO utilisateur(nom,genre,adresse,password,Email)"
        		  + "VALUES(?,?,?,?,?)";
          
          connection = handler.getConnection();
          try {
			pst = connection.prepareStatement(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        try {
			pst.setString(1, NomUtilisateur.getText());
			pst.setString(2, getGender());
			pst.setString(3, localisationUtilisateur.getText());
			pst.setString(4, MotDepasse.getText());
			pst.setString(5, Email.getText());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void loginAction(ActionEvent event) throws IOException {
        connexionUtilisateur.getScene().getWindow().hide();
         
        Stage creercompte = new Stage();
        creercompte.initStyle(StageStyle.TRANSPARENT);
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
                creercompte.setX(event.getScreenX() - xOffset );
                creercompte.setY(event.getScreenY() - yOffset );
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        creercompte.setScene(scene);
        creercompte.show();
        creercompte.setResizable(false);
        
     
        
    }
    
    public String getGender() {
    	String genr ="";
    	if(checkHomme.isSelected()) {
    		genr = "Homme";
    	}else if(checkfemme.isSelected()) {
    		genr = "Femme";
    	}
		return genr;
    	
    }
    
}
