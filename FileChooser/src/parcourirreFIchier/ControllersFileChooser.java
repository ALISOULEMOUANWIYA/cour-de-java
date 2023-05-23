package parcourirreFIchier;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ControllersFileChooser implements Initializable{

	
	

    @FXML
    private AnchorPane anchorpane;

    FileChooser fileChooser = new FileChooser(); 
    
    @FXML
    void LookedCliked(ActionEvent event) {

    }

    @FXML
    void SavedCliked(ActionEvent event) {
    	
    	Window stage = anchorpane.getScene().getWindow();
    	fileChooser.setTitle("Save Dialogue");
    	fileChooser.setInitialFileName("MySave");
    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"),
    			new FileChooser.ExtensionFilter("PDF", "*.pdf"));
    	
    	try {
    		File file = fileChooser.showSaveDialog(stage);
    		fileChooser.setInitialDirectory(file.getParentFile());
    	}catch(Exception ex) {
    		
    	}
    }
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	fileChooser.setInitialDirectory(new File("c:\\temp"));
    }
}
