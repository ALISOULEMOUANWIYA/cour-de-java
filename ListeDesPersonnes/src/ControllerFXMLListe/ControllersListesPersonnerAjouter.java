package ControllerFXMLListe;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.lowagie.text.Cell;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDialogueListeAjouter;
import ControllersDesDonnesListes.ControllersListeDialogueBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControllersListesPersonnerAjouter implements Initializable{
	
    @FXML
    private AnchorPane anchorPane_parent;



    @FXML
    private TableView<ControllersDonneDialogueListeAjouter> tableListeAjouter;


    @FXML
    private TableColumn<ControllersDonneDialogueListeAjouter, String> culomePrenom;
    @FXML
    private TableColumn<ControllersDonneDialogueListeAjouter, String>  culomeNom;



    @FXML
    private Circle CercleProfillePhotot;

    @FXML
    private Label LabelleMatricule;
    
    @FXML
    private Button closeBtn;
	
    private String ListeUtilisateur ;
    
    
    private DataAccessObject dao ;
    private InputStream profilephoto;
    private String MatriculeUtilisateurCompte;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		dao = new DataAccessObject();
		tableListeAjouter.setOnMouseClicked(e -> {
			try {
				LigneSelectionner();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		RefrechireTable();
		
	}
	
	private void initTable() {
		culomePrenom.setCellValueFactory(Cell -> Cell.getValue().getPrenomUtilsateur());
		culomeNom.setCellValueFactory(Cell -> Cell.getValue().getNomUtilsateur());
	}
	
	private void RefrechireTable() {
		initTable();
		ListeUtilisateur = "SELECT Prenom, Nom, PhotoUtilisateur ,MatriculeUtilisateur "
							+ "FROM tachaide.compte_utilisateur ";
		tableListeAjouter.setItems(dao.getFonctionDataListeAjouter(ListeUtilisateur));
	}
	private void UtilisateurSelectionne() {
		ControllersDonneDialogueListeAjouter selected = tableListeAjouter.getSelectionModel().getSelectedItem();
		     setProfilephoto(selected.getPhotoUtilisateur());
		     setMatriculeUtilisateurCompte(selected.getMatriculeUtilisateur().get());
		     
	}
	private void descriptionMoinDetailler() {
		String permetion = "java.io.ByteArrayInputStream@";

		     LabelleMatricule.setText(getMatriculeUtilisateurCompte());

		     setProfilephoto(getProfilephoto());
		     if(permetion.equals(getProfilephoto().toString().substring(0, 29))) {
    		     System.out.println("nom photo : "+getProfilephoto());
    		     CercleProfillePhotot.setStroke(Color.SEAGREEN); 
     			Image im = new Image(getProfilephoto());
     			CercleProfillePhotot.setFill(new ImagePattern(im));
     			CercleProfillePhotot.setEffect(new DropShadow(+25d, 0d, 52d, Color.DARKSEAGREEN));
		     }else {
	    		Image im = new Image("/Icons/account.png");
	    		CercleProfillePhotot.setFill(new ImagePattern(im));
	    		CercleProfillePhotot.setEffect(new DropShadow(+25d, 0d, 52d, Color.DARKSEAGREEN));
		     }

		
	}
	private void LigneSelectionner() throws IOException {
		ControllersDonneDialogueListeAjouter selected = tableListeAjouter.getSelectionModel().getSelectedItem(); 
		if(selected == null) {
			CercleProfillePhotot.setVisible(false);
			LabelleMatricule.setVisible(false);
		}else {
			CercleProfillePhotot.setVisible(true);
			LabelleMatricule.setVisible(true);
			UtilisateurSelectionne();
			descriptionMoinDetailler();
    		selected.getPhotoUtilisateur().reset();
    	}
	}
	
	
	
	
	/*******************************************************/
    @FXML
    void CloseDialogueFonction(MouseEvent event) {
    	Button btn = (Button)  event.getSource();
    	Stage stag = (Stage) btn.getScene().getWindow();
    	stag.close();
    }

    public InputStream getProfilephoto() {
		return profilephoto;
	}
    public void setProfilephoto(InputStream valeurprofilephoto) {
		this.profilephoto = valeurprofilephoto;
	}
    public String getMatriculeUtilisateurCompte() {
		return MatriculeUtilisateurCompte;
	}
    public void setMatriculeUtilisateurCompte(String valeurmatriculeUtilisateurCompte) {
		this.MatriculeUtilisateurCompte = valeurmatriculeUtilisateurCompte;
	}
//fx:controller="ControllerFXML.ControllersFonctionL"

    
}
