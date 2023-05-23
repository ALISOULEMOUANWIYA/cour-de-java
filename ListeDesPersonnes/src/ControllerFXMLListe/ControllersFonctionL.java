package ControllerFXMLListe;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDialogueFonction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllersFonctionL implements Initializable{
	
    @FXML
    private AnchorPane anchorPane_parent;

    @FXML
    private JFXTextField nouvelleFonction;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<ControllersDonneDialogueFonction> tableFonction;

    @FXML
    private TableColumn<ControllersDonneDialogueFonction, String> culomeFonction;

    @FXML
    private Button closeBtn;
	
    private String SaisieIfoFonctionUtilisateur;
    private String listeFonction;
    private String fonctionUtilisateur ;
    
    
    private DataAccessObject dao ;

    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new DataAccessObject();
		
		btnSave.setOnAction(e -> {
			insertNewPosition();
			System.out.println(getfonctionUtilisateur()+" 53 ");
		});
		RefrechireTable();
		
	}
	
	private void insertNewPosition() {
		
		fonctionUtilisateur ="Je suis : "+nouvelleFonction.getText();
		SaisieIfoFonctionUtilisateur = "INSERT INTO fonction_utilisateur VALUES(null, '"+nouvelleFonction.getText()+"')";
		dao.saveData(SaisieIfoFonctionUtilisateur);
		nouvelleFonction.setText("");
		RefrechireTable();
		
	}
	
	private void initTable() {
		culomeFonction.setCellValueFactory(Cell -> Cell.getValue().getfFonsition());
	}
	
	private void RefrechireTable() {
		initTable();
		listeFonction = "SELECT fonctionUtilisateur FROM fonction_utilisateur";
		tableFonction.setItems(dao.getFonctionDataListe(listeFonction));
	}
	
    @FXML
    void CloseDialogueFonction(MouseEvent event) {
    	Button btn = (Button)  event.getSource();
    	Stage stag = (Stage) btn.getScene().getWindow();
    	stag.close();
    }
	
    
    public String getfonctionUtilisateur() {
		return fonctionUtilisateur;
	}
   
//fx:controller="ControllerFXML.ControllersFonctionL"

    
}
