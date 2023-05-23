package ControllerFXMLListe;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controlelerBoxDialogue implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    private void CloseDialogue(MouseEvent event) {
		Button btn = (Button)  event.getSource();
		
		Stage stage = (Stage) btn.getScene().getWindow();
		stage.close();
    }
	
	//onMouseClicked="#CloseDialogue"
}
