package controllersFXML;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;

public class ControllersBoutton implements Initializable{
	
	private double xOffset = 0;
    private double yOffset = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    private void Open(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("/fichierFXML/DialogueBox.fxml"));
    	
    	
    	Dialog dialog = new Dialog();
		dialog.getDialogPane().setContent(root);
		dialog.getDialogPane().setStyle(" -fx-background-color:  #696969");
		dialog.initStyle(StageStyle.TRANSPARENT);
		
		
		
		dialog.show();
		
    }
}
