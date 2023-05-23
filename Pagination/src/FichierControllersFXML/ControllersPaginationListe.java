package FichierControllersFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDataListes;
import ControllersDesDonnesListes.conteurListe;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllersPaginationListe implements Initializable{
	
    @FXML
    private Pagination PaginationListe;

    @FXML
    private TableView<ControllersDonneDataListes> tableauListes;
    
    @FXML
    private TableColumn<ControllersDonneDataListes, Integer> tableauId;
    @FXML
    private TableColumn<ControllersDonneDataListes, String> tableauFonctions;
    
    private String listeFonction; 
    private String fonctionUtilisateur ;
    private DataAccessObject dao ;
	private int from = 0 , to = 0, itemPrePage =4;
	private int laListeConter = 0;
	private List<conteurListe> conteurTrouver ;
	private List<conteurListe> listeur = new ArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new DataAccessObject();
		RefrechireTable();
		listeur.addAll(getConteurTrouver());
		for(int i = 0; i < listeur.size() ; i++ ) 
		{
			laListeConter = conteurTrouver.get(i).getfFonsition().getValue();
		}
		
		int pageCount = ( laListeConter / itemPrePage) + 1;
		System.out.println("Conteur data "+pageCount);
		PaginationListe.setPageCount(pageCount);
		PaginationListe.setPageFactory(this::createPage);

	}
	private void initTable() {
		tableauFonctions.setCellValueFactory(Cell -> Cell.getValue().getfFonsition());
		tableauId.setCellValueFactory(Cell -> Cell.getValue().getIdFonction().asObject());
	}
	
	private void RefrechireTable() {
		listeFonction = "SELECT count(*) FROM tachaide.fonction_utilisateur";
		conteurTrouver = dao.getFonctionDataListeConteur(listeFonction);
		initTable(); 
	}
	
	private Node createPage(int pageIndex) {
		from = pageIndex * itemPrePage;
		to = itemPrePage;
		System.out.println("Page numero  "+pageIndex);
		System.out.println("il commence de  "+(from-3)+" Et il termine à "+to);
		if(from == 0) {
			listeFonction = "SELECT * FROM tachaide.fonction_utilisateur limit "+ from + " , "+ to;
		}else if(from > 0){
			listeFonction = "SELECT * FROM tachaide.fonction_utilisateur limit "+ (from-2) + " , "+ to;
		}
		tableauListes.setItems(FXCollections.observableArrayList(dao.getFonctionDataListe(listeFonction)));
		return tableauListes;
	}
	   public String getfonctionUtilisateur() {
			return fonctionUtilisateur;
		}
	   public List<conteurListe> getConteurTrouver() {
		return conteurTrouver;
	}
}
