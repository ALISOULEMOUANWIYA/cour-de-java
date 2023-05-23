package FichierControllersFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDataListes;
import ControllersDesDonnesListes.conteurListe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.Pane;

public class ControllersPaginationDataBaseListe implements Initializable{
	
    @FXML
    private Pagination paginationListdataBase;
    
    @FXML
    private Pane PaneBoxe;
    @FXML
    private Button databaseA;
    @FXML
    private Button databaseB;
    @FXML
    private Button databaseC;
    @FXML
    private Button databaseD;
    
    private String listeFonction; 
    private String fonctionUtilisateur ;
    private DataAccessObject dao ;
	private int from = 0 , to = 0, itemPrePage =5;
	private int laListeConter = 0;
	private List<conteurListe> conteurTrouver ;
	private List<ControllersDonneDataListes> ListeDataBase ;
	private List<conteurListe> listeur = new ArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new DataAccessObject();
		RefrechireListeDataBaseListers();
		
		calculeNombreDePages();
		
	}
	

	private void calculeNombreDePages() {
		listeur.addAll(getConteurTrouver());
		for(int i = 0; i < listeur.size() ; i++ ) 
		{
			laListeConter = getConteurTrouver().get(i).getfFonsition().getValue();
		}
		
		int pageCount = ( laListeConter / itemPrePage) + 1;
		System.out.println("Conteur data "+pageCount);
		paginationListdataBase.setPageCount(pageCount);
		paginationListdataBase.setPageFactory(this::createPage);
	}
	private void RefrechireListeDataBaseListers() {
		listeFonction = "SELECT count(*) FROM tachaide.listedatabase5 ";
		conteurTrouver = dao.getFonctionDataListeConteur(listeFonction); 
	}
	
	private Node createPage(int pageIndex) {
		from = pageIndex * itemPrePage;
		to = itemPrePage;
		System.out.println("Page numero  "+pageIndex);
		System.out.println("il commence de  "+(from-3)+" Et il termine à "+to);
		if(from == 0) {
			listeFonction = "SELECT * FROM tachaide.listedatabase5 limit "+ from + " , "+ to;
		}else if(from > 0){
			listeFonction = "SELECT * FROM tachaide.listedatabase5 limit "+ (from-2) + " , "+ to;
		}
		//PaneBoxe;
		ListeDataBase = dao.getFonctionDataListe(listeFonction);
		System.out.println("Liste data "+ListeDataBase.size());
		for(int i = 0; i < ListeDataBase.size() ; i++ ) 
		{
			if(i == 0) {
				databaseA.setText(getListeDataBase().get(i).getfFonsition().getValue());
			}else if(i == 1) {
				databaseB.setText(getListeDataBase().get(i).getfFonsition().getValue());
			}else {
				if(i == 2) {
					databaseC.setText(getListeDataBase().get(i).getfFonsition().getValue());
				}else if(i == 3) {
					databaseD.setText(getListeDataBase().get(i).getfFonsition().getValue());
				}
			}
		}
		return PaneBoxe;
	}
	
	public String getfonctionUtilisateur() {
			return fonctionUtilisateur;
	}
	
	public List<conteurListe> getConteurTrouver() {
		return conteurTrouver;
	}
	public List<ControllersDonneDataListes> getListeDataBase() {
		return ListeDataBase;
	}
}
