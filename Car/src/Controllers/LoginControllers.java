package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import BDConnection.DBHabdler;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration; 


public class LoginControllers implements Initializable {
	
	@FXML
    private Label rabessement;

    @FXML
    private ImageView nonCompte;

    @FXML
    private ImageView zenCompte;

    @FXML
    private Label compliment;
    
    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField passWord;

    @FXML
    private JFXButton connexionUser;

    @FXML
    private JFXCheckBox conditionUtil;

    @FXML
    private JFXButton motdepassOUblier;

    @FXML
    private ImageView chargementConnxion;

    @FXML
    private JFXButton creercompte;
    @FXML
    private JFXButton laisse;
    
    private String EmailUtilisateur = null;
    private int tailleEmail = 0;
    private double xOffset = 0;
    private double yOffset = 0;
    private String retablire = "";
    private Connection connection;
    private DBHabdler handler;
    private java.sql.PreparedStatement pst ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        chargementConnxion.setVisible(false);
        rabessement.setVisible(false);
        nonCompte.setVisible(false);
        zenCompte.setVisible(false);
        compliment.setVisible(false);
        connexionUser.setDisable(true);
        userName.setStyle("-fx-text-inner-color: #FFFFFF;");
        passWord.setStyle("-fx-text-inner-color: #FFFFFF;");
        
        handler = new DBHabdler();
    }    
    
    
    @FXML
    public void loginAction(ActionEvent event) throws IOException{
        chargementConnxion.setVisible(true);
        
        // se connectr à la base de donné conditionnel
        connection = handler.getConnection();
           
          String  eml = "SELECT * FROM utilisateur WHERE Email=? and password=?";
           String  cnt = "SELECT * FROM utilisateur WHERE nom=? and password=?";
          try {
        	  
        	  tailleEmail = (userName.getText()).length();
        	  if(tailleEmail > 10) {
        		  EmailUtilisateur = (userName.getText()).substring(tailleEmail-10, tailleEmail);
            	  System.out.println(EmailUtilisateur);
        	  }
        	  
        	  
        	  if(EmailUtilisateur.equalsIgnoreCase("@gmail.com")){
        		 
	        		  pst = connection.prepareStatement(eml);
	        		  pst.setString(1, userName.getText());
	        		  pst.setString(2, passWord.getText());
        		 
        	  }else {
        		  System.out.println("ok entrez");
        		  
        		      
	        		  pst = connection.prepareStatement(cnt);
	        		  pst.setString(1, userName.getText());
	            	  pst.setString(2, passWord.getText());
	            	  
	               
        	  }
        	  ResultSet rs = pst.executeQuery();
        	  
        	  int count = 0;
        	  
        	  while(rs.next()) {
        		  count = count + 1;
        	  }
        	  if(count == 1) {
        		  chargementConnxion.setVisible(true);
        		  rabessement.setVisible(false);
                  nonCompte.setVisible(false);
        	      zenCompte.setVisible(true);
        	      compliment.setVisible(true);
        	      System.out.println(" compte prouver");
        	      PauseTransition pt = new PauseTransition();
        	      pt.setDuration(Duration.seconds(3));
        	      pt.setOnFinished(ev ->{
        	      });      
        	      pt.play();
        	      connexionUser.getScene().getWindow().hide();
    	          
    	          Stage crercompte = new Stage();
    	          crercompte.initStyle(StageStyle.TRANSPARENT);
    	          Parent root = FXMLLoader.load(getClass().getResource("/FXML/FXMMaJourner.fxml"));
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
    	              	crercompte.setX(event.getScreenX() - xOffset );
    	              	crercompte.setY(event.getScreenY() - yOffset );
    	              }
    	          });
    	          Scene scene = new Scene(root);
    	          scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
    	          crercompte.setScene(scene);
    	          crercompte.show();
    	          crercompte.setResizable(false);
        	             
        	  }
        	  else {
        		  chargementConnxion.setVisible(false);
      	        	rabessement.setVisible(true);
                    nonCompte.setVisible(true);
                    
      	             passWord.setText(retablire);
      	        	System.out.println(" nom ou mot de passe est incorecte ");
        		  
        	  } 
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
          finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        
    }

    @FXML
    public void creercompte(ActionEvent event) throws IOException {
    	creercompte.getScene().getWindow().hide();
         
        Stage crercompte = new Stage();
        crercompte.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Inscription.fxml"));
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
            	crercompte.setX(event.getScreenX() - xOffset );
            	crercompte.setY(event.getScreenY() - yOffset );
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        crercompte.setScene(scene);
        crercompte.show();
        crercompte.setResizable(false);
    }

    @FXML
    private void laisseAction(ActionEvent event) throws IOException {
        laisse.getScene().getWindow().hide();
         
        Stage revenir = new Stage();
        revenir.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/FXMMaJourner.fxml"));
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
                revenir.setX(event.getScreenX() - xOffset );
                revenir.setY(event.getScreenY() - yOffset );
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        revenir.setScene(scene);
        revenir.show();
        revenir.setResizable(false);
    }
 
    
    public void checkAction(ActionEvent event) {
    	int genr =0;
    	if(conditionUtil.isSelected()) {
    		genr = 1;
    		connexionUser.setDisable(false);
    		System.out.println("vrai");
    	}else {
    		genr = 0;
    		connexionUser.setDisable(true);
    		System.out.println("faux");
    	}
    	
    }
    
}
