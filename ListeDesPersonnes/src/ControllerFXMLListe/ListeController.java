package ControllerFXMLListe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import ControllersBDConnection.DBConnection;
import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDataListes;
import ControllersDesDonnesListes.ControllersDonneDataparametreListes;
import ControllersDesDonnesListes.ControllersDonneDialogueFonction;
import ControllersDesDonnesListes.ControllersFonctionaire;
import ControllersDesDonnesListes.ControllersListeDialogueBox;
import ControllersDesDonnesListes.conteurListe;
import ControllersDesDonnesListes.conteurListeParametre;
import Lister.MisActualisation;
import PackegeDesdonne.DescriptionDataCompte;
import PackegeDesdonne.DescriptionDataCompteLister;
import PackegeDesdonne.ModifierUtil;
import PackegeDesdonne.ReportTache;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

public class ListeController implements Initializable{
	
    @FXML
    private AnchorPane AnchorPaneFenetre;

	@FXML
	private MenuItem refresheTableau;
    @FXML
    private MenuBar fileItembar;
    
    /****/
    
  
    
   
    @FXML
    private Button ButtonparourirFichier;//pour fenetre devellopeur-- 
    @FXML
    private Button buttonAjouterJasportRaport;//pour fenetre devellopeur--
    @FXML
    private Button MenuBouton;//boutton Menu navigation**
    @FXML
    private Button ButtonLister;//boutton Menu navigation**
    @FXML
    private Button buttonListerBox;//boutton Menu navigation**
    @FXML
    private Button buttonParametre;//boutton Menu navigation**
    @FXML
    private Button buttonAide;//boutton Menu navigation** 


    @FXML
    private Button SuprimerSelection;//pour fenetre liste
    @FXML
    private Button buttonmisajourEnBox;//---pour fenetre liste box
    @FXML
    private Button ButtonMisajourEnListe;//---pour fenetre liste box
    @FXML
    private Button buttonmisajourEnBoxRetourMisajour;//---pour fenetre liste box
    @FXML
    private Button ButtonMisajourEnListeretourMisajour;//---pour fenetre liste box    



    @FXML
    private Label RapelleAction;//pour fenetre devellopeur--
    @FXML
    private Label IndicationFichier;//pour fenetre devellopeur--
    @FXML
    private Label NomUtilisateur;// pour pane Boxe liste
    @FXML
    private Label PrenomUtilisateur;// pour pane Boxe liste

    
    
 
    @FXML
    private Pane MinInfoUtilsateur;//pour fenetre liste 
    @FXML
    private Pane PaneAcceuille;
    @FXML
    private Pane paneAide;
    @FXML
    private Pane paneBox;
    @FXML
    private Pane paneParametre;
    @FXML
    private Pane paneLister;//pour fenetre liste
    @FXML
    private Pane VerticaleBarre2;
    @FXML
    private Pane paneprofilephoto;// info compte profile
    @FXML
    private Pane VerticaleBarre1;
    @FXML
    private Pane HorrizontaleBarre1;
    @FXML
    private Pane HorrizontaleBarre2;




    @FXML
    private JFXTextField rechercheBarre;//pour fenetre liste 
    
    //*************************************** Debut Anchorpane des tache *************************************** 
	    @FXML
	    private AnchorPane AnchorpaneOuvertureChoixTache;
    //*************************************** fin Anchorpane des tache *************************************** 
    
    //*************************************** Debut Action login *************************************** 
	    @FXML
	    private AnchorPane anchorPaneLogine;//pour la fenetre Logine 
	    
	
	    // Debut Slider Pane #################################################################
	    @FXML
	    private Pane paneLogin;//pour fenetre Logine
	    @FXML
	    private Circle CircleFacebook; 
	    @FXML
	    private Circle CircleTweeter; 
	    @FXML
	    private Circle CircleGoogle; 
	    @FXML
	    private Label revenireLogin;//pour  fenetre login
	    @FXML Separator barreSeparator;//pour fenetre Logine
	    @FXML
	    private Label labeleLogineInformation;//pour  fenetre login
	    @FXML
	    private Button inscriptionLogin;//pour la fenetre Logine
	    @FXML
	    private Button SeConnecterLogin;//pour la fenetre Logine
	    @FXML Separator barreSeparator2;//pour fenetre Logine
	    @FXML
	    private Circle CircleAnimation;
	    // fin Slider Pane ###################################################################
	
	    // debut Connection Utilisateur #####################################################################
	    @FXML
	    private Label nombreDeConnexionLogin;//pour  fenetre login
	    @FXML
	    private Label PersonneLogin;//pour  fenetre login 
	    @FXML
	    private Label labeleConnectionVousLogin;//pour  fenetre login
	    @FXML
	    private Circle ConnectionRessantCircle;//pour fenetre login
	    @FXML
	    private MenuButton MenuButtonConnectionRecante;
	    @FXML
	    private Button buttoneyeConnection;
	    @FXML
	    private Button buttoneyeSleshConnection;
	    @FXML
	    private JFXTextField texteSaisieLogin;//pour fenetre login
	    @FXML
	    private Circle CircleUser;
	    @FXML
	    private JFXPasswordField texteSaisieLoginPassword;//pour fenetre login 
	    @FXML
	    private JFXTextField  texteSaisiePassword;
	    @FXML
	    private Circle CircleSaisiePassword;
	    @FXML
	    private Label labeleLoginVerification;//pour  fenetre login 
	    @FXML
	    private Label labeleLoginMotDePasseOublier;//pour  fenetre login 
	    @FXML
	    private Circle CircleEmogieIndicatif;
	    @FXML
	    private JFXCheckBox  checkBoxAccepterLesCondition;
	    @FXML
	    private Button ConnectionLogine;//pour la fenetre Logine 
	    @FXML
	    private Circle CircleConnection;
	    @FXML
	    private Circle CircleChargement;
	    @FXML
	    private Label LabeleModeDePasseOublier;//pour  fenetre login
	    @FXML
	    private Label LabeleCreerCompte;//pour  fenetre login
	    // fin Connection Utilisateur #####################################################################
	
	    // debut Inscription #######################################################################
		    @FXML
		    private Circle   circleAvatarCreationCompte;
		    @FXML
		    private Label   labeltexteRappelleTache;
		    @FXML
		    private JFXTextField   texteFildeNomUtilsateur;
		    @FXML
		    private Circle   CircleNomUtilisateur;
		    @FXML
		    private JFXTextField   textFildePrenomUtilsateur;
		    @FXML
		    private Circle   circlePrenomUtilasteur;
		    @FXML
		    private JFXTextField   texteFildeAdressEmailUtilsateur;
		    @FXML
		    private Circle   CircleAdresseUtilsateur;
		    @FXML
		    private JFXPasswordField   PassWordeIdentification;
		    @FXML
		    private JFXTextField textFildePassWorde;
		    @FXML
		    private Circle   CirclePassWorde;
		    @FXML
		    private JFXPasswordField  CodeIdentifiactionMatriculeUtilisateur;
		    @FXML
		    private JFXTextField   textFildeCodeIdentificationUtilisateur;
		    @FXML
		    private Circle   CirclePassWordeUtilsateur;
		    @FXML
		    private Button ButtonAfficherPassWorde;
		    @FXML
		    private Button   ButtonMasquerPassWorde;
		    @FXML
		    private JFXComboBox<ControllersDonneDialogueFonction>  ComboxListeFonction;
		    @FXML
		    private Circle  CircleFonctionUtilisateur;
		    @FXML
		    private JFXDatePicker  dateNaissanceUtilsateur;
		    @FXML
		    private Circle  CircleGenreutilateur;
		    @FXML
		    private Label  LabelleHomme;
		    @FXML
		    private JFXToggleButton  TogglGenreUtilisateur;
		    @FXML
		    private JFXTextField  textFildeLocalisationUtilisateur;
		    @FXML
		    private Circle  CircleLocalisateurUtilisateur;
		    @FXML
		    private Button  buttonEnrigistrerUtilisateur; 
		    @FXML
		    private Circle  CirclechargementUtilisateur;
		    @FXML
		    private Label  labeleEnrigistrementEnAttente;
	    // fin Inscription  #############################################################################
  //*************************************** fin Action login ********************************************
	    
  /* @FXML
    private ImageView photoUtilisateur;//pour fenetre liste */
    @FXML
    private ImageView alertManqueFichier;//pour fenetre devellopeur--
    @FXML
    private ImageView alertBonneFichier;//pour fenetre devellopeur--
    @FXML
    private ImageView alertBonneFichierExtensier;//pour fenetre devellopeur--

    @FXML
    private Circle ReduireFentre;// pour la Fenetre de la fenetre 
    
    /*---------------------------------------- Debut Variable FXML Fenetre barre des iconnes horizontale -------------------------------------*/
    @FXML
    private Circle CliquerButtonChangeMenuHirizontalBarre;// pour la barre des iconnes horizontale
    @FXML
    private Circle CliquerButtonChangeMenuVerticaleBarre;// pour la barre des iconnes horizontale
    /*---------------------------------------- Debut Variable FXML Fenetre barre des iconnes horizontale -------------------------------------*/
    
    
    /*---------------------------------------- Debut Variable FXML Fenetre Acceuille -------------------------------------*/
	    @FXML
	    private Pagination paginationListdataBase;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Pagination paginationListParametre;//pour la fenetre Acceuille pagination Parametre liste paginationListAide
	    @FXML
	    private Pagination paginationListAide;//pour la fenetre Acceuille pagination Aide liste 
	    @FXML
	    private Label FonctionFonctionnaire;//pour la fenetre Acceuille pagination Aide liste
	    @FXML
	    private Label NomUtilisateurP;//pour la fenetre Acceuille pagination Aide liste
	    @FXML
	    private Label PrenomUtilisateurP;//pour la fenetre Acceuille pagination Aide liste
	    @FXML
	    private Label AgeUtilisateurP;//pour la fenetre Acceuille pagination Aide liste
	    @FXML
	    private Button databaseA;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Button databaseB;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Button databaseC;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Button databaseD;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Button databaseE;//pour la fenetre Acceuille pagination data base liste
	    @FXML
	    private Button databasePA;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Button databasePB;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Button databasePC;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Button databasePD;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Button databasePE;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Button databasePF;//pour la fenetre Acceuille pagination Parametre liste
	    @FXML
	    private Circle CircleparametreA;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CircleparametreB;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CircleparametreC;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CircleparametreD;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CircleparametreE;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CircleparametreF;//pour la fenetre Acceuille pagination Parametre  liste
	    @FXML
	    private Circle CerclePhotoProfile;//pour la fenetre Acceuille Le profile du fonctionnaire 
	    @FXML
	    private Circle CirclePhtotoDefinissantFonctionnaire;//pour la fenetre Acceuille Le profile du fonctionnaire 
	    @FXML
	    private Pane PaneBoxe;//pour la fenetre Acceuille pagination data base liste PaneBoxeParametre
	    @FXML
	    private Pane PaneBoxeParametre;//pour la fenetre Acceuille pagination data base liste
	    
	    
	    @FXML
	    private Circle PanePhoto;//pour fenetre liste 
	    @FXML
	    private Circle compteprofilePhoto;//pour fenetre liste
	    
	    
 
    /*---------------------------------------- fin Variable FXML Fenetre Acceuille -------------------------------------*/

    
	/*---------------------------------------- debut Variable FXML Fenetre Lite Tableau  -------------------------------------*/
	    @FXML
	    private ComboBox<ControllersDonneDialogueFonction> comboFichierJasper;//pour fenetre liste 
	    @FXML
	    private TableView<ControllersListeDialogueBox> tblView;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> SelectionCheckBox;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, Integer> ID_Utilisateur;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnPrenom;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnNom;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnGenre;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnAge;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnAdress;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnNationalite;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, Integer> column_ID_Nationalite;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnFonction;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, Integer> column_ID_Fonction;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnMatricule;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, String> columnPhoto;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, FileInputStream> photoProfileUtilisateur;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, Timestamp> dateInscriptionUtilisateur;//pour fenetre liste
	    @FXML
	    private TableColumn<ControllersListeDialogueBox, Integer> ageUtilisateur;
	    @FXML
	    private JFXCheckBox ActiverSelection;//pour fenetre liste 
	    @FXML
	    private JFXCheckBox ActiverSelectionDevellopeur;//pour fenetre liste 
	    @FXML
	    private JFXCheckBox checkBoxSauvegarderScession;//pour fenetre liste 
	    
	 
	    @FXML
	    private Label AgeUtilisateur;//pour  fenetre liste 
	    @FXML
	    private Label FonctionUtilisateur;//pour fenetre liste
	    @FXML
	    private Label NoMDufichier;//pour fenetre liste
	    @FXML
	    private Label infoUtilisateurA;//pour fenetre liste
	    @FXML
	    private Label infoUtilisateurB;//pour fenetre liste
	    @FXML
	    private Label infoUtilisateurC;//pour fenetre liste
	    
	    @FXML
	    private Button boutonReduitreFichierJasport;//pour  fenetre liste
		@FXML
	    private JFXButton AjouterPersonne;//pour  fenetre liste
	    @FXML
	    private JFXButton PreView;//pour  fenetre liste
	    @FXML
	    private JFXButton ExporterTable;//pour  fenetre liste
	    @FXML
	    private JFXButton ModifierPersonne;//pour  fenetre liste
	    @FXML
	    private JFXButton SuprimerPersonne;//pour  fenetre liste
	    @FXML
	    private Button buttonRecherche;//pour  fenetre liste
    /*---------------------------------------- fin Variable FXML Fenetre Liste Tableau  -------------------------------------*/
    

	/*---------------------------------------- debut Variable FXML Fenetre Liste Parametre  -------------------------------------*/
	    @FXML
	    private Button ButtonHistorique;
	    @FXML
	    private Button ButtonConfidentialite;
	    @FXML
	    private Button ButtonConfidentialite1;
	    @FXML
	    private Button ButtonConfidentialite11;
	    @FXML
	    private Button ButtonConfidentialite111;
	    @FXML
	    private Button ButtonConfidentialite1111;
	    @FXML
	    private Button ButtonHistorique1;
	    @FXML
	    private Button ButtonConfidentialite2;
	    @FXML
	    private Button ButtonConfidentialite12;
	    @FXML
	    private Button ButtonConfidentialite112;
	    @FXML
	    private Button ButtonConfidentialite1112;
	    @FXML
	    private Button ButtonConfidentialite11111;
	    @FXML
	    private Button ButtonHistorique11;
	    @FXML
	    private Button ButtonConfidentialite21;
	    @FXML
	    private Button ButtonConfidentialite121;
    /*---------------------------------------- fin Variable FXML Fenetre Liste Parametre  -------------------------------------*/
    
	/*---------------------------------------- Debut Variable FXML Fenetre Box Liste  -------------------------------------*/
	    @FXML
	    private BorderPane borderpan;
	    @FXML
	    private ScrollPane ScrollePane;
	    @FXML
	    private AnchorPane anchorpaneBox;
	    @FXML
	    private GridPane gride;
    /*---------------------------------------- fiin Variable FXML Fenetre Box Liste  -------------------------------------*/
    
    /********/
    private FXMLLoader loader;
	private String refrechirListe;
	
	
    private DataAccessObject dao;
    private Connection connect;
    private DBConnection database;
    private MisActualisation reproduirFigureAjour;
    private Map<String, Object>map;
    
    private boolean moficationDebut = true;
    private boolean veriterRefrechire = false;
    private boolean cacher = true, ouverte = false;
    private boolean cacherHorizontale = true, ouverteHorizontale = false;
    
    private FileChooser fileChooser = new FileChooser(); 
    private String obbtenireIage = null;
    private String NomFichier = null;
    private String JaspertListe = null;
    private String ExtensionJasperraport = null;
    private int tailleNomFicheir = 0;
    private int ajouterSiVraia = 0;
    private int augmenter = 0;
    private int TableauIdeDemarage [];
    private int taillTableau =0;
    private InputStream profilephoto = null;
    private String nomUtilisateurcompte = null;
    private String prenomUtilisateurcompte = null;
    private String fonctionUtilisateurcompte = null;
    private int AgeUtilisateurCompte = 0;
    
    /******/
    private List<DescriptionDataCompte> description = new ArrayList<>();
    private List<DescriptionDataCompte> descriptionLister = new ArrayList<>();
    private FileInputStream fichierJapertraport = null;
    
   /*############################## Les variables de la listes data base #########################################*/
	    private String listeFonction; 
	    private String fonctionUtilisateur ;
		private int from = 0 , to = 0, itemPrePage =5, itemPrePageParametre = 6;
		private int laListeConter = 0;
		private List<conteurListe> conteurTrouver ;
		private List<ControllersDonneDataListes> ListeDataBase ;
		private List<conteurListeParametre> conteurTrouverParametre ;
		private List<ControllersDonneDataparametreListes> ListeParametre ;
		private List<conteurListe> listeur = new ArrayList();
		private List<conteurListeParametre> listeurParametre = new ArrayList();
		private List<ControllersDonneDataListes> listeurPardefaut = new ArrayList();
   /*############################## fin Les variables de la listes data base ##########################################*/
		
  /*############################## Les variables Login ##########################################*/		
	    private String EmailUtilisateur = "";
	    private int tailleEmail = 0;
	    private String retablire = "";
		private double position1 = 0;
	    private double position2 = 428;
	    private double position3 = 660;
	    private double positionAnchorpaneChoixDesTache = 905;
        private List<ControllersDonneDataparametreListes> ListeDataBaseIcons;
        private List<ControllersFonctionaire> ListeFonctionnaire;
        private String nomFonctionnaire = "" , EmailFonctionnaire = "" , PassWordFonnctionnaire = "" ;
  /*############################## fin variables Login ##########################################*/
         public ListeController() {
         }
      
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			/************************************ Affichage par defaut *******************************************/
			dao = new DataAccessObject();
			refrechireTable();
			AffichagePardefautl();
			VisibliterAction();
			visibiliterpaneLogien(true, false, true);
			visibiliterpaneLogienPardefaut(false);
			afficherCompteDescription();
			NombreIDE();
			RefrechireListeDataBaseListers();
			RefrechireListeParametreListers();
				  reproduirFigureAjour = new MisActualisation() {
					@Override
					public void SuprimerCompte(DescriptionDataCompte suprim) {
						System.out.println("Compte ID "+suprim.getID_UtilDescription());
					}
	
					/*@Override
					public void Modifier(DescriptionDataCompte decriptionModifer) throws IOException {
						//editAcount(decriptionModifer);
					}*/
				 };
			
			/************************************ Button controller ***********************************************/
				 /*----------------------------------- debut controllers  Button login ----------------------------------------------*/
					inscriptionLogin.setOnAction( e ->{
						SliderPaneInscriptionLogin();
					});
					SeConnecterLogin.setOnAction( e ->{ 
						SliderPaneInscriptionLoginRigth();
					});
					ConnectionLogine.setOnAction( e ->{ 
						VerificationDonnerAccerConnection();
					});
					buttoneyeConnection.setOnAction( e ->{ 
						texteSaisieLoginPassword.setVisible(false);
						buttoneyeConnection.setVisible(false);
						texteSaisiePassword.setVisible(true);
						buttoneyeSleshConnection.setVisible(true);
						buttonVoirCode();
					});
					buttoneyeSleshConnection.setOnAction( e ->{ 
						texteSaisieLoginPassword.setVisible(true);
						buttoneyeConnection.setVisible(true);
						texteSaisiePassword.setVisible(false);
						buttoneyeSleshConnection.setVisible(false);
						buttonMasquerCode();
					});
				 /*----------------------------------- fin controllers Button login ----------------------------------------------*/
						
				 


					
			ButtonparourirFichier.setOnAction( e ->{
				VisibliterAction();
				parcourirFichierJaporraport();
			});
			
			buttonAjouterJasportRaport.setOnAction( e ->{ 
				AjouterFichierJaporraport();
			});
			
			CliquerButtonChangeMenuHirizontalBarre.setOnMouseClicked( e ->{
				if(cacherHorizontale == true && ouverteHorizontale == false) {
					BarreHorizontale(!cacherHorizontale, !ouverteHorizontale);
					cacherHorizontale = false;
					ouverteHorizontale = true;
				}else if(cacherHorizontale == false && ouverteHorizontale == true) {
					BarreHorizontale(!cacherHorizontale, !ouverteHorizontale);
					cacherHorizontale = true;
					ouverteHorizontale = false;
				}
			});
			CliquerButtonChangeMenuVerticaleBarre.setOnMouseClicked( e ->{
				if(cacher == true && ouverte == false) {
					BarreVerticale(!cacher, !ouverte);
					cacher = false;
					ouverte = true;
				}else if(cacher == false && ouverte == true) {
					BarreVerticale(!cacher, !ouverte);
					cacher = true;
					ouverte = false;
				}
			});
			
			ButtonLister.setOnAction(e ->{
			    PaneAcceuille.setVisible(false);
			    paneAide.setVisible(false);
			    paneBox.setVisible(false);
			    paneParametre.setVisible(false);
			    paneLister.setVisible(true);
			    visibiliterTache(true, false);
			});			
			buttonParametre.setOnAction(e ->{
			    PaneAcceuille.setVisible(false);
			    paneAide.setVisible(false);
			    paneBox.setVisible(false);
			    paneParametre.setVisible(true);
			    paneLister.setVisible(false);
			    visibiliterTache(false, false);
			});
			buttonAide.setOnAction(e ->{
			    PaneAcceuille.setVisible(false);
			    paneAide.setVisible(true);
			    paneBox.setVisible(false);
			    paneParametre.setVisible(false);
			    paneLister.setVisible(false);
			    visibiliterTache(false, false);
			});
			buttonListerBox.setOnAction(e ->{
			    PaneAcceuille.setVisible(false);
			    paneAide.setVisible(false);
			    paneBox.setVisible(true);
			    paneParametre.setVisible(false);
			    paneLister.setVisible(false);
			    visibiliterTache(false, false);
			    afficherCompteDescription();// afficher la description par box
			});
			MenuBouton.setOnAction(e ->{
			    PaneAcceuille.setVisible(true);
			    paneAide.setVisible(false);
			    paneBox.setVisible(false);
			    paneParametre.setVisible(false);
			    paneLister.setVisible(false);
			    visibiliterTache(false, false);
			});
			
			tblView.setOnMouseClicked(e -> {
				try {
					LigneSelectionner();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			comboFichierJasper.setOnMouseClicked(e -> {
				initJaspert();
			});
			
			ModifierPersonne.setOnAction(e ->{
				try {
					editAcount();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			
			SuprimerPersonne.setOnAction(e ->{
				suprimerUtilisateur();
			});
			
			ActiverSelection.setOnAction(e ->{
				try {
					ActivationSelectionCheckBox();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			SuprimerSelection.setOnAction(e ->{
				SuppressionUtilisateurMultiples();
				setAjouterSiVraia(0);
				NombreIDE();
				afficherCompteDescription();
			});
			/***********************************/
				buttonmisajourEnBox.setOnAction(e ->{
					buttontBoxEtLIsteController(false, true);
					changerScrollePaneCompteDescription();
				});
				buttonmisajourEnBoxRetourMisajour.setOnAction(e ->{
					buttontBoxEtLIsteController(true, false);
					changerScrollePaneCompteDescription();
				});
				//--------------------
				ButtonMisajourEnListe.setOnAction(e ->{
					buttontLIsteController(false, true);
					changerScrollePaneCompteDescriptionLister();
				});
				ButtonMisajourEnListeretourMisajour.setOnAction(e ->{
					buttontLIsteController(true, false);
					changerScrollePaneCompteDescriptionLister();
				});
		}
		/********************************************* debut Login *********************************************/
		  
		   private void buttonVoirCode() {
			   texteSaisiePassword.setText(texteSaisieLoginPassword.getText());
		   }
		   private void buttonMasquerCode() {
			   texteSaisieLoginPassword.setText(texteSaisiePassword.getText());
		   }
		    
		   private void VerificationDonnerAccerConnection() {
	            String  eml = "SELECT * FROM tachaide.compte_fonctionnaire WHERE Address_Email_Fonctionnaire=? and PassWord_Fonctionnaire=?";
			    String  cnt = "SELECT * FROM tachaide.compte_fonctionnaire WHERE Prenom_Fonctionnaire=? and PassWord_Fonctionnaire=?";
			    String getComRequette = "SELECT c.ID_Fonctionnaire, c.Prenom_Fonctionnaire, c.Nom_Fonctionnaire, c.Address_Email_Fonctionnaire, "
			    		+ "c.PassWord_Fonctionnaire, c.CodeIdentiction_Fonctionnaire, c.Numero_Telephone_Fonctionnaire, c.Genre_Fonctionnaire, "
			    		+ "c.DATE_naissanceFonctionnaire,  c.Address_De_Localisation_Fonctionnaire, c.ID_Nationnalite_Fonctionnaire, "
			    		+ "n.NationnaliteUtilisateur, c.ID_Fonction_Fonctionnaire ,f.FonctionUtilisateur ,c.Photo_Fonctionnairer ,"
			    		+ "c.Matricule_Fonctionnaire, c.Date_inscription_Fonctionnaire, c.Age_Fonctionnaire "
			    		+ "FROM tachaide.compte_fonctionnaire AS c "
			    		+ "JOIN tachaide.nationnalite_utilisateur AS n ON c.ID_Nationnalite_Fonctionnaire = n.Nationnalite_ID "
			    		+ "JOIN tachaide.fonction_utilisateur AS f ON c.ID_Fonction_Fonctionnaire = f.Fonction_ID  "
			    		+ "ORDER BY c.Prenom_Fonctionnaire";
	          tailleEmail = (texteSaisieLogin.getText()).length();
        	  if(tailleEmail > 10) {
        		  EmailUtilisateur = (texteSaisieLogin.getText()).substring(tailleEmail-10, tailleEmail);
            	  System.out.println(EmailUtilisateur);
        	  }
        	  if(EmailUtilisateur.equalsIgnoreCase("@gmail.com")){
        		  texteSaisiePassword.setText(texteSaisieLoginPassword.getText());
        		  if(!(texteSaisiePassword.getText()).equalsIgnoreCase("")) {
        			  System.out.println("1 mot de passe n'est pas null : "+texteSaisiePassword.getText()); 
        			   setEmailFonctionnaire(texteSaisieLogin.getText());
	        		   setPassWordFonnctionnaire(texteSaisiePassword.getText());
 	        	     dao.ConnectionCompteFonctionnaire(eml, texteSaisieLogin.getText(), texteSaisiePassword.getText());  
 	        	  }
        	  }else {
	    		   System.out.println("ok entrez");
	    		   texteSaisiePassword.setText(texteSaisieLoginPassword.getText());
	        	   if(!(texteSaisiePassword.getText()).equalsIgnoreCase("")) {
	        		   System.out.println("2 mot de passe n'est pas null : "+texteSaisiePassword.getText());
	        		   setNomFonctionnaire(texteSaisieLogin.getText());
	        		   setPassWordFonnctionnaire(texteSaisiePassword.getText());
	        	       dao.ConnectionCompteFonctionnaire(cnt, texteSaisieLogin.getText(), texteSaisiePassword.getText());  
	        	   }
    	      } 
			if(dao.getValeurtrouver() == 1) {
				setListeFonctionnaire(dao.getCompteDataFonctionnaire(getComRequette));
	        	labeleLoginVerification.setVisible(true);
				CircleEmogieIndicatif.setVisible(true);
				labeleLoginMotDePasseOublier.setVisible(false);
        	    System.out.println(" compte prouver");
        	    SliderAnchorPaneInscriptionLogin();
        	  }
        	  else {
        		setPassWordFonnctionnaire("");
        		setEmailFonctionnaire("");
       		    setPassWordFonnctionnaire("");
        		labeleLoginVerification.setVisible(false);
	  			labeleLoginMotDePasseOublier.setVisible(true);
	  			CircleEmogieIndicatif.setVisible(true);
                    
	  			texteSaisieLoginPassword.setText(retablire);
	  			texteSaisiePassword.setText(retablire);
      	        System.out.println(" nom ou mot de passe est incorecte ");
        	  }
			//Sleep(2500);
		  }
			
			/*private void Sleep(int tempsSleep) {
				try {
					Thread.sleep(tempsSleep);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}*/
			private void IconsPhotoFonctionnaire(Circle lecercle, InputStream couverturPhtot) throws IOException {
				   //debut photo de profile utilisateur-----------------------------------------------------------------------------
				        Image im = new Image(couverturPhtot);
				        lecercle.setFill(new ImagePattern(im));
				        couverturPhtot.reset();
			       //fin----------------------------------------------------------------------------
				}
		  private void AfficherCompteFonctionnaire() throws IOException {
			  for(int i = 0; i < getListeFonctionnaire().size() ; i++ ) 
				{
				  System.out.println(" houchou  nom : "+getNomFonctionnaire());
				  System.out.println(" houchou  Email :  "+getEmailFonctionnaire());
				  System.out.println(" houchou PassWord :  "+getPassWordFonnctionnaire());
				  if(getNomFonctionnaire().equals(getListeFonctionnaire().get(i).getPrenom_Fonctionnaire().getValue())  && getPassWordFonnctionnaire().equals(getListeFonctionnaire().get(i).getPassWord_Fonctionnaire().getValue())) {
					  FonctionFonctionnaire.setText(getListeFonctionnaire().get(i).getFonction_Fonctionnaire().getValue());
					  NomUtilisateurP.setText(getListeFonctionnaire().get(i).getNom_Fonctionnaire().getValue());
					  PrenomUtilisateurP.setText(getListeFonctionnaire().get(i).getPrenom_Fonctionnaire().getValue());
					  AgeUtilisateurP.setText(""+(getListeFonctionnaire().get(i).getAge_Fonctionnaire().getValue()));
					  IconsPhotoFonctionnaire(CerclePhotoProfile, getListeFonctionnaire().get(i).getphoto_Fonctionnaire());
				  }else if(getEmailFonctionnaire().equals(getListeFonctionnaire().get(i).getAddress_Email_Fonctionnaire().getValue()) && getPassWordFonnctionnaire().equals(getListeFonctionnaire().get(i).getPassWord_Fonctionnaire().getValue())) {
					  FonctionFonctionnaire.setText(getListeFonctionnaire().get(i).getFonction_Fonctionnaire().getValue());
					  NomUtilisateurP.setText(getListeFonctionnaire().get(i).getNom_Fonctionnaire().getValue());
					  PrenomUtilisateurP.setText(getListeFonctionnaire().get(i).getPrenom_Fonctionnaire().getValue());
					  AgeUtilisateurP.setText(""+(getListeFonctionnaire().get(i).getAge_Fonctionnaire().getValue()));
					  IconsPhotoFonctionnaire(CerclePhotoProfile, getListeFonctionnaire().get(i).getphoto_Fonctionnaire());
				  }
				}
		  }
		  private void SliderPaneInscriptionLogin() {
			  TranslateTransition slid = new  TranslateTransition();
	             
	             slid.setDuration(javafx.util.Duration.seconds(0.4));
	             slid.setNode(paneLogin);
	             
	             slid.setToX(position2);
	             slid.play();
	             
	             paneLogin.setTranslateX(position1);
	             
	             slid.setOnFinished((ActionEvent event) -> {
	            	 visibiliterpaneLogien(false, true, true);
	             });
		  }
		  private void SliderPaneInscriptionLoginRigth() {
			  TranslateTransition slid = new  TranslateTransition();
	             
	             slid.setDuration(javafx.util.Duration.seconds(0.4));
	             slid.setNode(paneLogin);
	             
	             slid.setToX(position1);
	             slid.play();
	             
	             paneLogin.setTranslateX(position2);
	             
	             slid.setOnFinished((ActionEvent event) -> {
	            	 visibiliterpaneLogien(true, false, true);
	             });
		  }
		  private void SliderAnchorPaneInscriptionLogin() {
			     TranslateTransition slid = new  TranslateTransition();
	             slid.setDuration(javafx.util.Duration.seconds(1.2));
	             slid.setNode(anchorPaneLogine);
	             slid.setToY(position3);
	             slid.play();
	             anchorPaneLogine.setTranslateY(position1);
	             
	             slid.setOnFinished((ActionEvent event) -> {
	            	 anchorPaneLogine.setVisible(false);
	            	 SliderAnchorpaneOuvertureChoixTache();
	            	 try {
						AfficherCompteFonctionnaire();
					} catch (IOException e) {
						e.printStackTrace();
					}
	             });
		  }
		  private void SliderAnchorpaneOuvertureChoixTache() {
			     TranslateTransition slidOuvertureChoixTache = new  TranslateTransition();
	             slidOuvertureChoixTache.setDuration(javafx.util.Duration.seconds(0.9));
	             slidOuvertureChoixTache.setNode(AnchorpaneOuvertureChoixTache);
	             slidOuvertureChoixTache.setToX(position1);
	             slidOuvertureChoixTache.play();
	             AnchorpaneOuvertureChoixTache.setTranslateX(positionAnchorpaneChoixDesTache);
	             slidOuvertureChoixTache.setOnFinished((ActionEvent event) -> {
	            	 AnchorpaneOuvertureChoixTache.setVisible(true);
	             });
	             
		  }
		  private void visibiliterpaneLogienPardefaut(boolean valeur2){
			   CircleEmogieIndicatif.setVisible(valeur2);
			   labeleLoginMotDePasseOublier.setVisible(valeur2);
			   labeleLoginVerification.setVisible(valeur2);
			   PersonneLogin.setVisible(valeur2);
			   nombreDeConnexionLogin.setVisible(valeur2);
			   buttoneyeSleshConnection.setVisible(valeur2);
			   CircleChargement.setVisible(!valeur2);
			   ButtonMasquerPassWorde.setVisible(valeur2);
			   MenuButtonConnectionRecante.setVisible(valeur2);
		  }
		  private void visibiliterpaneLogien(boolean valeur1, boolean valeur2, boolean Pardefault){
			    try {
			    	loginPhotoIcons();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   visibiliterpaneLogienPardefaut(!Pardefault);
			   labeleConnectionVousLogin.setVisible(valeur1);
			   inscriptionLogin.setVisible(valeur1);
			   CircleAnimation.setVisible(Pardefault);
			   texteSaisieLogin.setVisible(valeur1);
			   texteSaisieLoginPassword.setVisible(valeur1);
			   texteSaisiePassword.setVisible(valeur1);
			   CircleSaisiePassword.setVisible(valeur1);
			   checkBoxSauvegarderScession.setVisible(valeur1);
			   ConnectionLogine.setVisible(valeur1);
			   LabeleModeDePasseOublier.setVisible(valeur1);
			   LabeleCreerCompte.setVisible(valeur1);
			   CircleUser.setVisible(valeur1);
			   ConnectionRessantCircle.setVisible(valeur1);
			   buttoneyeConnection.setVisible(valeur1);
			   

			   //----------------------------------------
			   barreSeparator2.setVisible(valeur2);
			   barreSeparator.setVisible(valeur2);
			   SeConnecterLogin.setVisible(valeur2);
			   CircleFacebook.setVisible(valeur2); 
			   CircleTweeter.setVisible(valeur2); 
			   CircleGoogle.setVisible(valeur2); 
			   revenireLogin.setVisible(valeur2);
			   labeleLogineInformation.setVisible(valeur2);
			   
			   //--------------------------------------------
			   ButtonAfficherPassWorde.setVisible(valeur2);
			   
			   circleAvatarCreationCompte.setVisible(valeur2);
			   labeltexteRappelleTache.setVisible(valeur2);
			   texteFildeNomUtilsateur.setVisible(valeur2);
			   CircleNomUtilisateur.setVisible(valeur2);
			   textFildePrenomUtilsateur.setVisible(valeur2);
			   circlePrenomUtilasteur.setVisible(valeur2);
			   texteFildeAdressEmailUtilsateur.setVisible(valeur2);
			   CircleAdresseUtilsateur.setVisible(valeur2);
			   PassWordeIdentification.setVisible(valeur2);
			   textFildePassWorde.setVisible(valeur2);
			   CirclePassWorde.setVisible(valeur2);
			   textFildeCodeIdentificationUtilisateur.setVisible(valeur2);
			   CodeIdentifiactionMatriculeUtilisateur.setVisible(valeur2);
			   CirclePassWordeUtilsateur.setVisible(valeur2);
			   ComboxListeFonction.setVisible(valeur2);
			   CircleFonctionUtilisateur.setVisible(valeur2);
			   dateNaissanceUtilsateur.setVisible(valeur2);
			   CircleGenreutilateur.setVisible(valeur2);
			   LabelleHomme.setVisible(valeur2);
			   TogglGenreUtilisateur.setVisible(valeur2);
			   textFildeLocalisationUtilisateur.setVisible(valeur2);
			   CircleLocalisateurUtilisateur.setVisible(valeur2);
			   checkBoxAccepterLesCondition.setVisible(valeur2);
			   buttonEnrigistrerUtilisateur.setVisible(valeur2);
			   CirclechargementUtilisateur.setVisible(valeur2);
			   labeleEnrigistrementEnAttente.setVisible(valeur2);
			   
		  }
			private void IconsPhotologin(Circle lecercle, InputStream couverturPhtot) throws IOException {
			   //debut photo de profile utilisateur-----------------------------------------------------------------------------
			        Image im = new Image(couverturPhtot);
			        lecercle.setFill(new ImagePattern(im));
			        couverturPhtot.reset();
		       //fin----------------------------------------------------------------------------
			}
			
			private void loginPhotoIcons() throws IOException {
				listeFonction = "SELECT * FROM tachaide.iconslogin ";
				//PaneBoxe;
				setListeDataBaseIcons(dao.getFonctionParametreListe(listeFonction));
				for(int i = 0; i < getListeDataBaseIcons().size() ; i++ ) 
				{
					if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 6) {
						IconsPhotologin(ConnectionRessantCircle, getListeDataBaseIcons().get(i).getPhotoParametre());
					}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 22) {
						IconsPhotologin(CircleUser, getListeDataBaseIcons().get(i).getPhotoParametre());
						IconsPhotologin(CircleAdresseUtilsateur, getListeDataBaseIcons().get(i).getPhotoParametre());
					}else {
						if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 8) {
							IconsPhotologin(CircleSaisiePassword, getListeDataBaseIcons().get(i).getPhotoParametre());
							IconsPhotologin(CirclePassWorde, getListeDataBaseIcons().get(i).getPhotoParametre());
						}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 9) {
							IconsPhotologin(CircleEmogieIndicatif, getListeDataBaseIcons().get(i).getPhotoParametre());
						}else {
							if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 16) {
								IconsPhotologin(CircleConnection, getListeDataBaseIcons().get(i).getPhotoParametre());
							}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 11) {
								IconsPhotologin(CircleChargement, getListeDataBaseIcons().get(i).getPhotoParametre());
							}else {
								if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 18) {
									IconsPhotologin(CircleGoogle, getListeDataBaseIcons().get(i).getPhotoParametre());
								}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 19) {
									IconsPhotologin(CircleFacebook, getListeDataBaseIcons().get(i).getPhotoParametre());
								}else {
									if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 20) {
										IconsPhotologin(CircleTweeter, getListeDataBaseIcons().get(i).getPhotoParametre());
									}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 14) {
										IconsPhotologin(CircleAnimation, getListeDataBaseIcons().get(i).getPhotoParametre());
									}else {
										if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 21) {
											IconsPhotologin(circleAvatarCreationCompte, getListeDataBaseIcons().get(i).getPhotoParametre());
										}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 7) {
											IconsPhotologin(CircleNomUtilisateur, getListeDataBaseIcons().get(i).getPhotoParametre());
											IconsPhotologin(circlePrenomUtilasteur, getListeDataBaseIcons().get(i).getPhotoParametre());
										}else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 8) {
											IconsPhotologin(CirclePassWorde, getListeDataBaseIcons().get(i).getPhotoParametre());
										}else {
										     if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 23) {
												IconsPhotologin(CirclePassWordeUtilsateur, getListeDataBaseIcons().get(i).getPhotoParametre());
											 }else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 24) {
												IconsPhotologin(CircleFonctionUtilisateur, getListeDataBaseIcons().get(i).getPhotoParametre());
											 }else {
												 if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 25) {
													IconsPhotologin(CircleGenreutilateur, getListeDataBaseIcons().get(i).getPhotoParametre());
												 }else if((getListeDataBaseIcons().get(i).getIdFonction().getValue()).intValue() == 26) {
													IconsPhotologin(CircleLocalisateurUtilisateur, getListeDataBaseIcons().get(i).getPhotoParametre());
												 }
											}
										}
									}
								}
							}
						}
					}
				}
			}
			public List<ControllersDonneDataparametreListes> getListeDataBaseIcons() {
				return ListeDataBaseIcons;
			}
			public String getNomFonctionnaire() {
				return nomFonctionnaire;
			}
			public void setNomFonctionnaire(String valeurnomFonctionnaire) {
				this.nomFonctionnaire = valeurnomFonctionnaire;
			}
			public String getEmailFonctionnaire() {
				return EmailFonctionnaire;
			}
			public void setEmailFonctionnaire(String valeurEmailFonctionnaire) {
				this.EmailFonctionnaire = valeurEmailFonctionnaire;
			}
			public String getPassWordFonnctionnaire() {
				return PassWordFonnctionnaire;
			}
			public void setPassWordFonnctionnaire(String valeurPassWordFonnctionnaire) {
				this.PassWordFonnctionnaire = valeurPassWordFonnctionnaire;
			}
			public void setListeDataBaseIcons(List<ControllersDonneDataparametreListes> valeurlist) {
				this.ListeDataBaseIcons = valeurlist;
			}
			public List<ControllersFonctionaire> getListeFonctionnaire() {
				return ListeFonctionnaire;
			}
			public void setListeFonctionnaire(List<ControllersFonctionaire> valeurlisteFonctionnaire) {
				this.ListeFonctionnaire = valeurlisteFonctionnaire;
			}
		/********************************************* fin login *********************************************/
		
		/******************************************** visibiliter controllers*********************************************/

			private void VisibliterAction() {
				 alertBonneFichierExtensier.setVisible(false);
	 		     RapelleAction.setVisible(false);
				 alertManqueFichier.setVisible(false);
				 alertBonneFichier.setVisible(false);
				 alertBonneFichierExtensier.setVisible(false);
				 buttonAjouterJasportRaport.setVisible(true);
				 IndicationFichier.setVisible(true);
			}
			
			private void fichierSauvegarder() {
				alertBonneFichier.setVisible(true);
				buttonAjouterJasportRaport.setVisible(true);
				RapelleAction.setVisible(false);
				alertManqueFichier.setVisible(false);
				IndicationFichier.setVisible(false);
				alertBonneFichierExtensier.setVisible(false);
			}
			
			private void bonnefichier() {
				buttonAjouterJasportRaport.setVisible(true);
				alertBonneFichierExtensier.setVisible(true);
				alertBonneFichier.setVisible(false);
				RapelleAction.setVisible(false);
				alertManqueFichier.setVisible(false);
				IndicationFichier.setVisible(false);
			}
			private void BarreVerticale(boolean valeur1, boolean valeur2) {
				VerticaleBarre1.setVisible(valeur1);
				VerticaleBarre2.setVisible(valeur2);
			}
			
			private void BarreHorizontale(boolean valeur1, boolean valeur2) {
				HorrizontaleBarre1.setVisible(valeur1);
				HorrizontaleBarre2.setVisible(valeur2);
			}
			
			private void AffichagePardefautl() {
				PaneAcceuille.setVisible(true);
			    paneAide.setVisible(false);
			    paneBox.setVisible(false);
			    paneParametre.setVisible(false);
			    paneLister.setVisible(false);
			    checkBoxVerification(false);
			    visibiliterTache(false, false);
			    BarreVerticale(true, false);
			    visubiliterPhototPardefaut();
			}
			private void visibiliterTache(boolean verificationVisibilieterA , boolean verificationVisibilieterB) {
				buttonRecherche.setVisible(verificationVisibilieterA);
				MinInfoUtilsateur.setVisible(verificationVisibilieterA);
				rechercheBarre.setVisible(verificationVisibilieterA);
			    ExporterTable.setVisible(verificationVisibilieterB);
			    ModifierPersonne.setVisible(verificationVisibilieterB);
			    SuprimerPersonne.setVisible(verificationVisibilieterB);
			}
			private void buttontBoxEtLIsteController(boolean controller, boolean controller2) {
				buttonmisajourEnBox.setVisible(controller);
			    buttonmisajourEnBoxRetourMisajour.setVisible(controller2);
			}
			private void buttontLIsteController(boolean controller, boolean controller2) {
			    ButtonMisajourEnListe.setVisible(controller);
			    ButtonMisajourEnListeretourMisajour.setVisible(controller2);
			}
	/******************************************** visibiliter controllers*********************************************/
		
		private void afficherDescription() {
			System.out.println("Size = "+tblView.getItems().size()+"\n");
			for(int i = 0; i < tblView.getItems().size(); i++ ) 
    		{
	       		System.out.println("ID = "+tblView.getItems().get(i).getId_Utilisateur().get());
	       		System.out.println("Prenom = "+tblView.getItems().get(i).getPrenomUtilisateur().get());
	       		System.out.println("Nom = "+tblView.getItems().get(i).getNomUtilisateur().get());
	       		System.out.println("Genre = "+tblView.getItems().get(i).getGenreUtilisateur().get());
	       		System.out.println("Address = "+tblView.getItems().get(i).getAdressUtilisateur().get());
	       		System.out.println("Naissance = "+tblView.getItems().get(i).getAgeUtilisateur().get() );
	       		System.out.println("ID nationalite = "+tblView.getItems().get(i).getId_NationaliteUt().get());
	       		System.out.println("ID Fonction = "+tblView.getItems().get(i).getId_FonctionUt().get());
	       		System.out.println("Photo = "+tblView.getItems().get(i).getPhotoUtilisateur());
	       		System.out.println("Matricule = "+tblView.getItems().get(i).getMatriculeUtilisateur().get());
	       		System.out.println("Date Inscription = "+tblView.getItems().get(i).getDateInscriptionutilisateur());
	       		System.out.println("Age = "+tblView.getItems().get(i).getAgeUtilasteur().get()+"\n\n------------------\n");
    		}
		}
		/*************************************************  Data base  liste *****************************************************/
		private void calculeNombreDePages() {
			listeur.addAll(getConteurTrouver());
			for(int i = 0; i < listeur.size() ; i++ ) 
			{
				laListeConter = getConteurTrouver().get(i).getfFonsition().getValue();
			}
			
			int pageCount = ( laListeConter / itemPrePage);
			System.out.println("Conteur data "+pageCount);
			paginationListdataBase.setPageCount(pageCount);
			paginationListdataBase.setPageFactory(this::createPage);
		}
		private void RefrechireListeDataBaseListers() {
			listeFonction = "SELECT count(*) FROM tachaide.listedatabase5 ";
			conteurTrouver = dao.getFonctionDataListeConteur(listeFonction);
			calculeNombreDePages();
		}
		private void VisibiliterListesDataBase() {
			databaseA.setVisible(false);
			databaseB.setVisible(false);
			databaseC.setVisible(false);
			databaseD.setVisible(false);
			databaseE.setVisible(false);
		}
		private Node createPage(int pageIndex) {
			VisibiliterListesDataBase();
			from = pageIndex * itemPrePage;
			to = itemPrePage;
			System.out.println("Page numero  "+pageIndex);
			System.out.println("il commence de  "+(from-0)+" Et il termine à "+to);
			if(from == 0) {
				listeFonction = "SELECT * FROM tachaide.listedatabase5 limit "+ from + " , "+ to;
			}else if(from > 0){
				listeFonction = "SELECT * FROM tachaide.listedatabase5 limit "+ (from-0) + " , "+ to;
			}
			//PaneBoxe;
			ListeDataBase = dao.getFonctionDatabaseListe(listeFonction);
			System.out.println("Liste data "+ListeDataBase.size());
			for(int i = 0; i < ListeDataBase.size() ; i++ ) 
			{
				if(i == 0) {
					databaseA.setVisible(true);
					databaseA.setText(getListeDataBase().get(i).getfFonsition().getValue());
				}else if(i == 1) {
					databaseB.setVisible(true);
					databaseB.setText(getListeDataBase().get(i).getfFonsition().getValue());
				}else {
					if(i == 2) {
						databaseC.setVisible(true);
						databaseC.setText(getListeDataBase().get(i).getfFonsition().getValue());
					}else if(i == 3) {
						databaseD.setVisible(true);
						databaseD.setText(getListeDataBase().get(i).getfFonsition().getValue());
					}else {
						if(i == 4) {
							databaseE.setVisible(true);
							databaseE.setText(getListeDataBase().get(i).getfFonsition().getValue());
						}
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
		public List<ControllersDonneDataListes> getListeurPardefaut() {
			return listeurPardefaut;
		}
		/************************************************* Fin Data base  liste***************************************************/
		/*************************************************  Listes des paramtres *****************************************************/
		private void calculeNombreDePagesParamtre() {
			listeurParametre.addAll(getConteurTrouverParametre());
			for(int i = 0; i < listeur.size() ; i++ ) 
			{
				laListeConter = getConteurTrouverParametre().get(i).getfFonsition().getValue();
			}
			
			int pageCount = ( laListeConter / itemPrePageParametre) + 1;
			System.out.println("Conteur data "+pageCount);
			paginationListParametre.setPageCount(pageCount);
			paginationListParametre.setPageFactory(arg0 -> {
				try {
					return createPageParametre(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			});
		}
		private void RefrechireListeParametreListers() {
			listeFonction = "SELECT count(*) FROM tachaide.listeparametre ";
			conteurTrouverParametre = dao.getFonctionParametreListeConteur(listeFonction);
			calculeNombreDePagesParamtre();
		}
		private void VisibiliterListesParametreButton() {
			databasePA.setVisible(false);
			databasePB.setVisible(false);
			databasePC.setVisible(false);
			databasePD.setVisible(false);
			databasePE.setVisible(false);
			databasePF.setVisible(false);
			VisibiliterListesParametreIcons();
		}
		private void VisibiliterListesParametreIcons() {
			CircleparametreA.setVisible(false);
			CircleparametreB.setVisible(false);
			CircleparametreC.setVisible(false);
			CircleparametreD.setVisible(false);
			CircleparametreE.setVisible(false);
			CircleparametreF.setVisible(false);
		}
		private void IconsPhoto(Circle lecercle, InputStream couverturPhtot) throws IOException {
			//debut photo de profile utilisateur-----------------------------------------------------------------------------
			    lecercle.setStroke(Color.SEAGREEN);
		        Image im = new Image(couverturPhtot);
		        System.out.println(""+couverturPhtot);
		        lecercle.setFill(new ImagePattern(im));
		        couverturPhtot.reset();
	       //fin----------------------------------------------------------------------------
		}
		private Node createPageParametre(int pageIndex) throws IOException {
			VisibiliterListesParametreButton();
			from = pageIndex * itemPrePageParametre;
			to = itemPrePageParametre;
			System.out.println("Page numero  "+pageIndex);
			System.out.println("il commence de  "+(from-0)+" Et il termine à "+to);
			if(from == 0) {
				listeFonction = "SELECT * FROM tachaide.listeparametre limit "+ from + " , "+ to;
			}else if(from > 0){
				listeFonction = "SELECT * FROM tachaide.listeparametre limit "+ (from-0) + " , "+ to;
			}
			//PaneBoxe;
			ListeParametre = dao.getFonctionParametreListe(listeFonction);
			System.out.println(" ListeParametre "+ListeParametre.size());
			for(int i = 0; i < ListeParametre.size() ; i++ ) 
			{
				if(i == 0) {
					databasePA.setVisible(true);
					CircleparametreA.setVisible(true);
					databasePA.setText(getListeParamtre().get(i).getfFonsition().getValue());
					IconsPhoto(CircleparametreA, getListeParamtre().get(i).getPhotoParametre());
				}else if(i == 1) {
					databasePB.setVisible(true);
					CircleparametreB.setVisible(true);
					databasePB.setText(getListeParamtre().get(i).getfFonsition().getValue());
					IconsPhoto(CircleparametreB, getListeParamtre().get(i).getPhotoParametre());
				}else {
					if(i == 2) {
						databasePC.setVisible(true);
						CircleparametreC.setVisible(true);
						databasePC.setText(getListeParamtre().get(i).getfFonsition().getValue());
						IconsPhoto(CircleparametreC, getListeParamtre().get(i).getPhotoParametre());
					}else if(i == 3) {
						databasePD.setVisible(true);
						CircleparametreD.setVisible(true);
						databasePD.setText(getListeParamtre().get(i).getfFonsition().getValue());
						IconsPhoto(CircleparametreD, getListeParamtre().get(i).getPhotoParametre());
					}else {
						if(i == 4) {
							databasePE.setVisible(true);
							CircleparametreE.setVisible(true);
							databasePE.setText(getListeParamtre().get(i).getfFonsition().getValue());
							IconsPhoto(CircleparametreE, getListeParamtre().get(i).getPhotoParametre());
						}else if(i == 5) {
							databasePF.setVisible(true);
							CircleparametreF.setVisible(true);
							databasePF.setText(getListeParamtre().get(i).getfFonsition().getValue());
							IconsPhoto(CircleparametreF, getListeParamtre().get(i).getPhotoParametre());
						}
					}
				}
			}
			return PaneBoxeParametre;
		}
		
		public List<conteurListeParametre> getConteurTrouverParametre() {
			return conteurTrouverParametre;
		}
		public List<ControllersDonneDataparametreListes> getListeParamtre() {
			return ListeParametre;
		}
		/************************************************* Fin***************************************************/
		
		
		private void NombreIDE() {
			taillTableau = tblView.getItems().size();
			TableauIdeDemarage = new int[taillTableau];
			for(int i = 0; i < taillTableau; i++ ) 
    		{
				TableauIdeDemarage[i] = tblView.getItems().get(i).getId_Utilisateur().get();
    		}
			ModifierUtil.getTableauIdeDemarage();
		}
		
		private List<DescriptionDataCompte> getData() {
			List<DescriptionDataCompte> description = new ArrayList<>();
			DescriptionDataCompte compteDescription ;
			afficherDescription();
			
			
			for(int i = 0; i < tblView.getItems().size(); i++ ) 
    		{
				compteDescription = new DescriptionDataCompte();
				
	       		compteDescription.setID_UtilDescription(tblView.getItems().get(i).getId_Utilisateur().get());
	       		compteDescription.setPrenomUtilDescription(tblView.getItems().get(i).getPrenomUtilisateur().get());
	       		compteDescription.setNomUtilDescription(tblView.getItems().get(i).getNomUtilisateur().get());
	       		compteDescription.setGenreUtilDescription(tblView.getItems().get(i).getGenreUtilisateur().get());
	       		compteDescription.setAddressUtilDescription(tblView.getItems().get(i).getAdressUtilisateur().get());
	       		compteDescription.setAnneUtilNaissance(tblView.getItems().get(i).getAgeUtilisateur().get());
	       		compteDescription.setNationalUtDescription(tblView.getItems().get(i).getNationaliteUtilisateur().get());
	       		compteDescription.setNationaDescription(tblView.getItems().get(i).getId_NationaliteUt().get());
	       		compteDescription.setFonctionDescription(tblView.getItems().get(i).getFonctionUtilisateur().get());
	       		compteDescription.setFonctionDescriptionutil(tblView.getItems().get(i).getId_FonctionUt().get());
	       		compteDescription.setPhotoUtilDescription(tblView.getItems().get(i).getPhotoUtilisateur());
	       		compteDescription.setMatricleUtilDescription(tblView.getItems().get(i).getMatriculeUtilisateur().get());
	       		compteDescription.setDateInscription(tblView.getItems().get(i).getDateInscriptionutilisateur());
	       		compteDescription.setAgeutilisateur(tblView.getItems().get(i).getAgeUtilasteur().get());
	       		description.add(compteDescription);
    		}
			return description;
		}
		private List<DescriptionDataCompteLister> getDataListe() {
			List<DescriptionDataCompteLister> descriptionliste = new ArrayList<>();
			DescriptionDataCompteLister compteDescription ;
			afficherDescription();
			for(int i = 0; i < tblView.getItems().size(); i++ ) 
    		{
				compteDescription = new DescriptionDataCompteLister();
				
	       		compteDescription.setID_UtilDescription(tblView.getItems().get(i).getId_Utilisateur().get());
	       		compteDescription.setPrenomUtilDescription(tblView.getItems().get(i).getPrenomUtilisateur().get());
	       		compteDescription.setNomUtilDescription(tblView.getItems().get(i).getNomUtilisateur().get());
	       		compteDescription.setGenreUtilDescription(tblView.getItems().get(i).getGenreUtilisateur().get());
	       		compteDescription.setAddressUtilDescription(tblView.getItems().get(i).getAdressUtilisateur().get());
	       		compteDescription.setAnneUtilNaissance(tblView.getItems().get(i).getAgeUtilisateur().get());
	       		compteDescription.setNationalUtDescription(tblView.getItems().get(i).getNationaliteUtilisateur().get());
	       		compteDescription.setFonctionDescription(tblView.getItems().get(i).getFonctionUtilisateur().get());
	       		compteDescription.setPhotoUtilDescription(tblView.getItems().get(i).getPhotoUtilisateur());
	       		compteDescription.setMatricleUtilDescription(tblView.getItems().get(i).getMatriculeUtilisateur().get());
	       		compteDescription.setDateInscription(tblView.getItems().get(i).getDateInscriptionutilisateur());
	       		compteDescription.setAgeutilisateur(tblView.getItems().get(i).getAgeUtilasteur().get());
	       		descriptionliste.add(compteDescription);
    		}
			return descriptionliste;
		}

		private void changerScrollePaneCompteDescription() {
			try {
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					System.out.println("Nouvelle Scrolle en box \n");
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					ModifierUtil.descriptionScroller.clear();
					ModifierUtil.descriptionScroller.addAll(getData());
					ModifierUtil.afficherDescription();
					ScrollPane root = FXMLLoader.load(getClass().getResource("/fxmlListe/misajourScrollePane.fxml"));
					borderpan.setCenter(root);
			}catch(IOException ex) {
				ex.printStackTrace();
			}

		}
		private void changerScrollePaneCompteDescriptionLister() {
			try {
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					System.out.println("Nouvelle Scrolle lister\n");
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					ModifierUtil.descriptionScrollerLister.clear();
					ModifierUtil.descriptionScrollerLister.addAll(getDataListe());
					ModifierUtil.afficherDescriptionLister();
					ScrollPane root = FXMLLoader.load(getClass().getResource("/fxmlListe/MisAjourScrollePaneLister.fxml"));
					borderpan.setCenter(root);
			}catch(IOException ex) {
				ex.printStackTrace();
			}

		}
		

		
		private void afficherCompteDescription() {
			System.out.println("\n\n***********************************************\n");
			description.clear();
			description.addAll(getData());
			System.out.println("Scroller Nombre de Description = "+ModifierUtil.descriptionScroller.size());
			int Column = 0;
			int Row = 1;
			int TailleTableau = 0;
			try {
				System.out.println("\n\n###########################################################\n");
				System.out.println("Nombre de Description = "+description.size());
				System.out.println("Nombre de box = "+getAjouterSiVraia());
				System.out.println("Nombre de Description - "+" Description Ajouter = "+(description.size()-getAjouterSiVraia()));
				TailleTableau = (description.size()-getAjouterSiVraia());
				System.out.println("TAille du tableau = "+TailleTableau);
				if(getAjouterSiVraia() == 0) 
				{
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					System.out.println("tour  VIDE\n");
					System.out.println("\n\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
					for(int i = 0; i < description.size() ; i++ ) 
		    		{
						FXMLLoader fxmlLaoder = new FXMLLoader();
						fxmlLaoder.setLocation(getClass().getResource("/fxmlListe/DescriptionTotaleUtilisateur.fxml"));
						AnchorPane anchorPane = fxmlLaoder.load();
						
						
						controllersGrideCompte controllerCompte = fxmlLaoder.getController();
						controllerCompte.setDate(description.get(i), reproduirFigureAjour);
						
						if(Column == 3) {
							Column = 0;
							Row ++;
						}
						
						gride.add(anchorPane, Column++, Row);
						// ajustement du Longeur
						gride.setMinWidth(Region.USE_COMPUTED_SIZE);
						gride.setPrefWidth(Region.USE_COMPUTED_SIZE);
						gride.setMaxWidth(Region.USE_PREF_SIZE);
						
						// ajustement du Largeur
						gride.setMinHeight(Region.USE_COMPUTED_SIZE);
						gride.setPrefHeight(Region.USE_COMPUTED_SIZE);
						gride.setMaxHeight(Region.USE_PREF_SIZE);
						
						GridPane.setMargin(anchorPane, new Insets(10));
						
						ajouterSiVraia++;
						description.get(i).getPhotoUtilDescription().reset();
					}
				}
			   anchorpaneBox.setPrefHeight(anchorpaneBox.getPrefHeight()+(50*getAjouterSiVraia()));
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			if(augmenter == TailleTableau) {
				NombreIDE();
			}
			
			
		}
		
		private void visubiliterPhototPardefaut() {
			compteprofilePhoto.setVisible(false);
			PanePhoto.setVisible(true);
		}
		private void descriptionMoinDetaillerVide() {
		     AgeUtilisateur.setText("compte Utilisateur");
		     FonctionUtilisateur.setText("compte Utilisateur");
		     NomUtilisateur.setText("compte Utilisateur");
		     PrenomUtilisateur.setText("compte Utilisateur"); 
    			PanePhoto.setStroke(Color.SEAGREEN);
    			Image im = new Image("/Icons/account.png");
    			PanePhoto.setFill(new ImagePattern(im));
    			PanePhoto.setEffect(new DropShadow(+25d, 0d, 52d, Color.DARKSEAGREEN));
		}
		
		private void descriptionMoinDetailler() {
			String permetion = "java.io.ByteArrayInputStream@";
			 
    		     AgeUtilisateur.setText(""+getAgeUtilisateurCompte());
    		     FonctionUtilisateur.setText(getFonctionUtilisateurcompte());
    		     NomUtilisateur.setText(getNomUtilisateurCompte());
    		     PrenomUtilisateur.setText(getPrenomUtilisateurcompte());

    		     setProfilephoto(getProfilephoto());
    		     if(permetion.equals(getProfilephoto().toString().substring(0, 29))) {
        		     System.out.println("nom photo : "+getProfilephoto());
        		    compteprofilePhoto.setStroke(Color.SEAGREEN);
         			Image im = new Image(getProfilephoto());
         			compteprofilePhoto.setFill(new ImagePattern(im));
         			compteprofilePhoto.setEffect(new DropShadow(+25d, 0d, 52d, Color.DARKSEAGREEN));
    		     }else {
    	    		Image im = new Image("/Icons/account.png");
    	    		compteprofilePhoto.setFill(new ImagePattern(im));
    	    		compteprofilePhoto.setEffect(new DropShadow(+25d, 0d, 52d, Color.DARKSEAGREEN));
    		     }

    		
		}
		private void UtilisateurSelectionne() {
			 ControllersListeDialogueBox selected = tblView.getSelectionModel().getSelectedItem();
  		     setNomUtilisateurCompte(selected.getNomUtilisateur().get());
   		     setPrenomUtilisateurcompte(selected.getPrenomUtilisateur().get());
   		     setFonctionUtilisateurcompte(selected.getFonctionUtilisateur().get());
   		     setAgeUtilisateurCompte(selected.getAgeUtilasteur().get());
   		     setProfilephoto(selected.getPhotoUtilisateur());
   		     
		}
		private void LigneSelectionner() throws IOException {
			ControllersListeDialogueBox selected = tblView.getSelectionModel().getSelectedItem(); 
    		if(selected == null) {
    			visibiliterTache(true, false);
    			compteprofilePhoto.setVisible(false);
    			PanePhoto.setVisible(true);
    			descriptionMoinDetaillerVide();
    		}else {
    			UtilisateurSelectionne();
        		visibiliterTache(true, true);
        		compteprofilePhoto.setVisible(true);
    			PanePhoto.setVisible(false);
        		descriptionMoinDetailler();
        		selected.getPhotoUtilisateur().reset();
        	}
		}
		private void suprimerUtilisateur() {
			int id;
    		ControllersListeDialogueBox selected = tblView.getSelectionModel().getSelectedItem();
    		id = selected.getId_Utilisateur().get();
    		
    		if(id > 0 ) {
        		refrechirListe = "DELETE FROM tachaide.compte_utilisateur WHERE compte_ID = "+id+"";
        		dao.saveData(refrechirListe);
        		refrechireTable();
    		}
		}
		
		private void suprimerUtilisateurBoxGrid(DescriptionDataCompte decriptionSuprimer) {
			int id; 
    		id = (decriptionSuprimer.getID_UtilDescription());
    		
    		if(id > 0 ) {
        		refrechirListe = "DELETE FROM tachaide.compte_utilisateur WHERE compte_ID = "+id+"";
        		dao.saveData(refrechirListe);
        		refrechireTable();
    		}
		}
		
		private void checkBoxVerification(boolean veriter) {
			SelectionCheckBox.setVisible(veriter);
		}
		private void ActivationSelectionCheckBox() throws IOException {
			if(ActiverSelection.isSelected()) {
				checkBoxVerification(true);
				SuprimerPersonne.setVisible(false);
			}else if(!ActiverSelection.isSelected()){
				checkBoxVerification(false);
				LigneSelectionner();
			}
		}
		
		private void SelectionUtilisateurMultiples() {
			int k = 0;
    		for(int i = 0; i < tblView.getItems().size(); i++ ) 
    		{
	       		if(tblView.getItems().get(i).getCheckBox().isSelected())
	       		{
	       			if(k==1) {
	       				ModifierPersonne.setVisible(true);
	       			}else if(k > 1) {
	       				ModifierPersonne.setVisible(false);
	       			}
    			}
	       		k++;
    		}
		}
		
		private void SuppressionUtilisateurMultiples() {
			//System.out.println("Size = "+tblView.getItems().size()+"\n");
			for(int i = 0; i < tblView.getItems().size(); i++ ) 
    		{
				System.out.println("conteur :  "+i);
				System.out.println("checkbox = "+tblView.getItems().get(i).getCheckBox().isSelected());
	       		if(tblView.getItems().get(i).getCheckBox().isSelected())
	       		{
	       			System.out.println("position checkbox = "+i);
	       			System.out.println("ID = "+tblView.getItems().get(i).getId_Utilisateur().get());
	       				acceSupression(i);
	        		
    			}
    		}
			refrechireTable();
		}
		private void acceSupression(int valeur) {
			refrechirListe = "DELETE FROM tachaide.compte_utilisateur WHERE compte_ID = "+tblView.getItems().get(valeur).getId_Utilisateur().get()+"";
    		dao.saveData(refrechirListe);
		}
		

		private void editAcount() throws IOException {
			modififer();
	    	try {
					loader = new FXMLLoader();
					
					Stage stage = new Stage();
					stage.initStyle(StageStyle.TRANSPARENT);
				
					loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxInscription.fxml"));
					loader.load();
				Scene scene = new Scene(loader.getRoot());
				scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
	
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
				
			   
			}catch(Exception e) {
				e.printStackTrace();
			}
	    	refrechireTable();
		}
		
		@SuppressWarnings("unused")
		private void editAcount(DescriptionDataCompte decriptionModifier) throws IOException {
			modififerBox(decriptionModifier);
	    	try {
					loader = new FXMLLoader();
					
					Stage stage = new Stage();
					stage.initStyle(StageStyle.TRANSPARENT);
				
					loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxInscription.fxml"));
					loader.load();
				Scene scene = new Scene(loader.getRoot());
				scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
	
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
				
			   
			}catch(Exception e) {
				e.printStackTrace();
			}
	    	refrechireTable();
		}
		
    	private void modififerBox(DescriptionDataCompte decriptionModifier) {
	    	ModifierUtil.setModifierUtilisateur(moficationDebut);
    		ModifierUtil.setID_Util(decriptionModifier.getID_UtilDescription());
    		ModifierUtil.setPrenomUtil(decriptionModifier.getPrenomUtilDescription());
    		ModifierUtil.setNomUtil(decriptionModifier.getNomUtilDescription());
    		ModifierUtil.setAddressUtil(decriptionModifier.getAddressUtilDescription());
    		ModifierUtil.setAnneUtil(decriptionModifier.getAnneUtilNaissance());
    		ModifierUtil.setGenreUtil(decriptionModifier.getGenreUtilDescription());
    		ModifierUtil.setNationalUt(decriptionModifier.getNationaDescription());
    		ModifierUtil.setFonction(decriptionModifier.getFonctionDescriptionutil());
    		//ModifierUtil.setPhotoUtil(selected.getPhotoUtilisateur().get());
    		ModifierUtil.afficher();
    	}
		
    	private void modififer() {
	    	ModifierUtil.setModifierUtilisateur(moficationDebut);
    		ControllersListeDialogueBox selected = tblView.getSelectionModel().getSelectedItem();
    		ModifierUtil.setID_Util(selected.getId_Utilisateur().get());
    		ModifierUtil.setPrenomUtil(selected.getPrenomUtilisateur().get());
    		ModifierUtil.setNomUtil(selected.getNomUtilisateur().get());
    		ModifierUtil.setAddressUtil(selected.getAdressUtilisateur().get());
    		ModifierUtil.setAnneUtil(selected.getAgeUtilisateur().get());
    		ModifierUtil.setGenreUtil(selected.getGenreUtilisateur().get());
    		ModifierUtil.setNationalUt(selected.getId_NationaliteUt().get());
    		ModifierUtil.setFonction(selected.getId_FonctionUt().get());
    		//ModifierUtil.setPhotoUtil(selected.getPhotoUtilisateur().get());
    		ModifierUtil.afficher();
    	}

		private void initJaspert() {
			comboFichierJasper.getSelectionModel().clearSelection();
			JaspertListe = "SELECT nomFichier FROM tachaide.ReporAdapter";
			comboFichierJasper.setItems(dao.getFonctionDataListeCombox(JaspertListe));
		}
		
	    @FXML
	    void aficherRaport(ActionEvent event)  {
	    	printRaport();
	    }
	    
		private void AjouterFichierJaporraport() {
	    	
	    	 //sauvagarde à la base de donner
	          String insert = "INSERT INTO tachaide.ReporAdapter(nomFichier ,fichierRaport) VALUES(?,?)";
	         dao.saveRaportJaport(insert, getNomFichier() ,getFichierJapertraport());
	         fichierSauvegarder();
	         NoMDufichier.setText("...");
		}

		
	    private void parcourirFichierJaporraport() {
	    	Window stage = AnchorPaneFenetre.getScene().getWindow();
	    	fileChooser.setTitle("Dialogue de recherche d'une fichier JasperSoft");
	    	fileChooser.setInitialFileName("MySave");
	    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JasperSoft", "*.jasper", "*.jrxml"));
	    	
	    	try {
	    		File file = fileChooser.showOpenDialog(stage); // selection un fichier 
	    		//List<File> files =  fileChooser.showOpenMultipleDialog(stage); // selection plusieur ficher
	    		
	    		fileChooser.setInitialDirectory(file.getParentFile());
	    		
	    		obbtenireIage = file.toURI().toString();
	    		
	    		File fichierRaport = new File(obbtenireIage);
	    			    		
	    		if(fichierRaport != null) {
	    			NoMDufichier.setText(""+fichierRaport.getName()+"");
	    			FileInputStream fichier = new FileInputStream(file);
	    			System.out.println(fichierRaport.getName());
	    			
	    			tailleNomFicheir = (fichierRaport.getName()).length();
	    			ExtensionJasperraport = (fichierRaport.getName()).substring(tailleNomFicheir-7, tailleNomFicheir);
	    			
	          	      if(ExtensionJasperraport.equalsIgnoreCase(".jasper")) {
	          	    	  System.out.println(ExtensionJasperraport);
	          	    	  
	          	    	  bonnefichier();
		              	  NomFichier = (fichierRaport.getName()).substring(0, tailleNomFicheir-7);
		              	  fichierJapertraport = fichier;
			          	  
	          	      }else{
		          	      ExtensionJasperraport = (fichierRaport.getName()).substring(tailleNomFicheir-6, tailleNomFicheir);
		          	      System.out.println(ExtensionJasperraport);
		              	  
			              if(ExtensionJasperraport.equalsIgnoreCase(".jrxml")){
			            	  System.out.println(ExtensionJasperraport);
			            	  
			              	  bonnefichier();
			              	  NomFichier = (fichierRaport.getName()).substring(0, tailleNomFicheir-6);
			              	  fichierJapertraport = fichier;
		          	      }
	          	      }
	          	  
	          	  
	    			
	    		}
	    		
	    	}catch(Exception ex) {
	    		
	    	}
	    	if(obbtenireIage == null) {
	    		 RapelleAction.setVisible(true);
				 alertManqueFichier.setVisible(true);
				 buttonAjouterJasportRaport.setVisible(false);
				 IndicationFichier.setVisible(false);
			}
	    }
	    
		private void printRaport() {
			/*
			  database = new DBConnection();
				connect = database.getConnection();
				map = new HashMap<String, Object>();
			
				ReportTache.createReport(connect, map, dao.getRaport("raporTachaide", "Fichier_Raport"));
				ReportTache.showReport();
			
			*/
			
			database = new DBConnection();
			connect = database.getConnection();
			map = new HashMap<String, Object>();
			ReportTache.createReport(connect, map, dao.getRaport());
			ReportTache.showReport();
		}
	    @FXML
	    void tableauRefresh(ActionEvent event) {
	    	refrechireTable();
	    	System.out.println("Actualiser reussit :-)");
	    	
	    }
		
		private void initTable() {
			SelectionCheckBox.setCellValueFactory(
				new PropertyValueFactory<ControllersListeDialogueBox, String>("CheckBox")
			);
		   ID_Utilisateur.setCellValueFactory(cell -> cell.getValue().getId_Utilisateur().asObject());
		   columnPrenom.setCellValueFactory(cell -> cell.getValue().getPrenomUtilisateur());
		   columnNom.setCellValueFactory(cell -> cell.getValue().getNomUtilisateur());
		   columnGenre.setCellValueFactory(cell -> cell.getValue().getGenreUtilisateur());
		   columnAge.setCellValueFactory(cell -> cell.getValue().getAgeUtilisateur());
		   columnAdress.setCellValueFactory(cell -> cell.getValue().getAdressUtilisateur());
		   columnNationalite.setCellValueFactory(cell -> cell.getValue().getNationaliteUtilisateur());
		   column_ID_Nationalite.setCellValueFactory(cell -> cell.getValue().getId_NationaliteUt().asObject());
		   columnFonction.setCellValueFactory(cell -> cell.getValue().getFonctionUtilisateur());
		   column_ID_Fonction.setCellValueFactory(cell -> cell.getValue().getId_FonctionUt().asObject());
		   columnMatricule.setCellValueFactory(cell -> cell.getValue().getMatriculeUtilisateur());
		   
		}
		
		protected void refrechireTable() {
			initTable();
			refrechirListe = "SELECT c.compte_ID,c.Prenom, c.Nom, Genre, c.DATE_naissance, c.Address, n.NationnaliteUtilisateur, c.Nationnalite_ID, f.FonctionUtilisateur, c.Fonction_ID ,c.PhotoUtilisateur ,c.MatriculeUtilisateur, c.Date_inscription, c.AgeUtilisateur FROM tachaide.compte_utilisateur AS c\r\n"
					+ "JOIN tachaide.nationnalite_utilisateur AS n ON c.Nationnalite_ID = n.Nationnalite_ID\r\n"
					+ "JOIN tachaide.fonction_utilisateur AS f ON c.Fonction_ID = f.Fonction_ID      \r\n"
					+ "	  ORDER BY c.Prenom";
			tblView.setItems(dao.getCompteData(refrechirListe));
		}
		
	   @FXML
	    void AjouterPersonne(ActionEvent event)throws IOException {
		   ModifierUtil.setModifierUtilisateur(false);
	    	try {
				loader = new FXMLLoader();
				
				Stage stage = new Stage();
				stage.initStyle(StageStyle.TRANSPARENT);
			
				loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxInscription.fxml"));
				loader.load();
			Scene scene = new Scene(loader.getRoot());
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);

			
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	   

	    @FXML
	    void CloseDialogue(MouseEvent event) {
	    	Button btn = (Button)  event.getSource();
			
			Stage stage = (Stage) btn.getScene().getWindow();
			stage.close();
	    }
	    public InputStream getProfilephoto() {
			return profilephoto;
		}
	    public void setProfilephoto(InputStream valeurprofilephoto) {
			this.profilephoto = valeurprofilephoto;
		}
	    public String getNomUtilisateurCompte() {
			return nomUtilisateurcompte;
		}
	    public void setNomUtilisateurCompte(String valeurnomUtilisateur) {
			this.nomUtilisateurcompte = valeurnomUtilisateur;
		}
	    public String getPrenomUtilisateurcompte() {
			return prenomUtilisateurcompte;
		}
	    public void setPrenomUtilisateurcompte(String valeurprenomUtilisateurcompte) {
			this.prenomUtilisateurcompte = valeurprenomUtilisateurcompte;
		}
	    public String getFonctionUtilisateurcompte() {
			return fonctionUtilisateurcompte;
		}
	    public void setFonctionUtilisateurcompte(String valeurfonctionUtilisateurcompte) {
			this.fonctionUtilisateurcompte = valeurfonctionUtilisateurcompte;
		}
	    public int getAgeUtilisateurCompte() {
			return AgeUtilisateurCompte;
		}
	    public void setAgeUtilisateurCompte(int valeurageUtilisateurCompte) {
			this.AgeUtilisateurCompte = valeurageUtilisateurCompte;
		}
	    
		public FileInputStream getFichierJapertraport() {
			return fichierJapertraport;
		}
		
		public String getNomFichier() {
			return NomFichier;
		}
		
	    public boolean getVeriterRefrechire(){
	    	return veriterRefrechire;
	    }
	    
	    public void setVeriterRefrechire(boolean valeur){
	    	this.veriterRefrechire = valeur;
	    }
	    
	    public int getAjouterSiVraia() {
			return ajouterSiVraia;
		}
	    public void setAjouterSiVraia(int ajouterSiVraia) {
			this.ajouterSiVraia = ajouterSiVraia;
		}
}
