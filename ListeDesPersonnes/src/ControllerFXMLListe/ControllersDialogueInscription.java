package ControllerFXMLListe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import ControllersBDConnection.DataAccessObject;
import ControllersDesDonnesListes.ControllersDonneDialogueFonction;
import PackegeDesdonne.ModifierUtil;
import PackegeDesdonne.RecceuilleLesDonnes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ControllersDialogueInscription  implements Initializable {
	    
		@FXML
	    private Label alertNom;
	    @FXML
	    private Label alertPrenom;
	    @FXML
	    private Label alertGenre;
	    @FXML
	    private Label alerteDate;
	    @FXML
	    private Label alertAdress;
	    @FXML
	    private Label alertNationaliter;
	    @FXML
	    private Label AlertpHOTO;
	    @FXML
	    private Label alertFonction;
	    @FXML
	    private Label labeleInfoPhoto;
	    @FXML
	    private Label labeleInfochamp;
	    @FXML
	    private HBox vbBoxDialogue;
	    


	    @FXML
	    private JFXTextField nomUtillisateur;
	    @FXML
	    private JFXTextField PrenomUtilisateur;
	    @FXML
	    private JFXTextField addresseUtilisateur;
	    
	    
	    @FXML
	    private ImageView photoUtilisateur;
	    
	    @FXML
	    private JFXDatePicker combo_age ;
	    
	    @FXML
	    private JFXComboBox<String> combo_genre;
	    @FXML
	    private JFXComboBox<ControllersDonneDialogueFonction> combo_nationnalite ;
	    @FXML
	    private JFXComboBox<ControllersDonneDialogueFonction> combo_fontion;

	    
	    @FXML
	    private Button ajouterPhotoUtilisateur;
	    @FXML
	    private Button ValiderDonnerutilisateur;
	    @FXML
	    private Button btn_ListePosition;
	    @FXML
	    private Button btn_ListesPersonnerAjouter;
	    @FXML
	    private Button sauvegarderDonnerutilisateur;
	    
	    
	    
	    
	    // liste du genre utiliste
	    private String agander[] = {"Homme", "Femme", "Autre"};
	    
	    private String listeFonction = null, prenomUtil = null, nomUtil = null, genreUtil = null, addressUtil = null, matriculeUtil = null;
		private String ageUtil = null;
		
	    private FileInputStream photoUtile = null;

		private int nationaliteUtil = 0, fonctionUtil = 0, UtilisateurAge = 0;



	    private Timestamp dateTiemIncscripionUtilisateur ; 
		private LocalDateTime now = LocalDateTime.now();
		private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        private String formatDateTimeCourant = now.format(format);
        
	    private FXMLLoader loader;
	    
	    private RecceuilleLesDonnes donnerMatricul;	
	    private FileChooser fileChooser = new FileChooser(); 
	    private String obbtenireIage = null;
	    private boolean finit = false;
	    
	    private DataAccessObject dao;
	    
         private Timestamp formatDateTime = new Timestamp(System.currentTimeMillis());
	
         
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		donnerMatricul = new RecceuilleLesDonnes();
		dao = new DataAccessObject();
		initGender();
		visibiliterLabel();
		verificationTache();
		
		
		
		btn_ListePosition.setOnAction( e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
			showPosition();
		});
		btn_ListesPersonnerAjouter.setOnAction( e -> {
			showListesPersonnerAjouter();
		});
		combo_fontion.setOnMouseClicked(e -> {
			visibiliterLabel();
			initPosition();
		});
		
		nomUtillisateur.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		PrenomUtilisateur.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		addresseUtilisateur.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		combo_genre.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
			
		});
		
		ajouterPhotoUtilisateur.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		photoUtilisateur.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		combo_age.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
		});
		
		combo_nationnalite.setOnMouseClicked(e -> {
			sauvegarderDonnerutilisateur.setVisible(true);
			visibiliterLabel();
			initNationnalite();
		});
		sauvegarderDonnerutilisateur.setOnAction(e -> {
			SaveDonnerSurBase();
		});
		ValiderDonnerutilisateur.setOnAction(e -> {
			SaveDonnerSurBase();
		});
	}
	private void saisieChamp() {

    	if((PrenomUtilisateur.getText()).equalsIgnoreCase("")) {
        	prenomUtil = null;
    	}else {
    		prenomUtil = PrenomUtilisateur.getText();
    		System.out.println("Prenom : "+prenomUtil);
    	}
    	
    	if((nomUtillisateur.getText()).equalsIgnoreCase("")) {
    		nomUtil = null;
    	}else {
    		nomUtil = nomUtillisateur.getText();
    		System.out.println("nom : "+nomUtil);
    	}
    	
    	if(combo_genre.getSelectionModel().getSelectedItem() != null) {
        	genreUtil = combo_genre.getSelectionModel().getSelectedItem();
        	System.out.println("genre : "+genreUtil);
    	}else {
    		genreUtil = null;
    	}
    	
    	if(combo_age.getValue() == null) {
    		ageUtil = null;
    		System.out.println(" Age : " +ageUtil);
    	}else {
    		ageUtil = combo_age.getValue().toString();
    		
    		String captureString1 = ageUtil.substring(0, 4);
    		System.out.println(formatDateTimeCourant+" la date courant");
    		String captureString2 = (String) formatDateTimeCourant.subSequence(6, 10);
    		int captureInt1 = Integer.parseInt(captureString1);
    		int captureInt2 = Integer.parseInt(captureString2);
    		
    		UtilisateurAge = captureInt2 - captureInt1;
    		System.out.println("captureString1 : "+captureString1+" et captureString2 :"+captureString2);
    		System.out.println("age : "+UtilisateurAge);
    	}
    	
    	if((addresseUtilisateur.getText()).equalsIgnoreCase("")) {
    		addressUtil = null;
    	}else {
    		addressUtil = addresseUtilisateur.getText();
    		System.out.println("address : "+addressUtil);
    	}
    	
    	if(Integer.parseInt(combo_nationnalite.getSelectionModel().getSelectedIndex()+1+"") >= 1) {
    		nationaliteUtil = Integer.parseInt(combo_nationnalite.getSelectionModel().getSelectedIndex()+1+"");
    		System.out.println("nationalite : "+nationaliteUtil);
    	}else {
    		nationaliteUtil = 0;
    	}
    	
    	if(Integer.parseInt(combo_nationnalite.getSelectionModel().getSelectedIndex()+1+"") >= 1) {
    		fonctionUtil = Integer.parseInt(combo_fontion.getSelectionModel().getSelectedIndex()+1+"");
    		System.out.println("fonction : "+fonctionUtil);
    	}else {
    		fonctionUtil = 0;
    	}

    	
    	if(prenomUtil != null && nomUtil != null && genreUtil != null && ageUtil != null && addressUtil != null && nationaliteUtil >= 1 && fonctionUtil >= 1) {
    		matriculeUtil = donnerMatricul.CreerMatriculeUtilisateur(prenomUtil, nomUtil, genreUtil, ageUtil, addressUtil, nationaliteUtil, fonctionUtil);
    		dateTiemIncscripionUtilisateur = formatDateTime;
    		System.out.println("matricule  : "+matriculeUtil);
    		System.out.println("date  : "+dateTiemIncscripionUtilisateur);
    	}else {
    		setMatriculeUtil(null);  
    		setDateTiemIncscripionUtilisateur(null); 
    	}	
	}
	
	
	   private void verificationTache() {
		   if(ModifierUtil.getModifierUtilisateur() == true) {
			    PrenomUtilisateur.setText(ModifierUtil.getPrenomUtil());
			    nomUtillisateur.setText(ModifierUtil.getNomUtil());
			    addresseUtilisateur.setText(ModifierUtil.getAddressUtil());
		    	combo_genre.getSelectionModel().select(ModifierUtil.getGenreUtil());
		    	combo_age.setPromptText(ModifierUtil.getAnneUtil());
		    	combo_nationnalite.getSelectionModel().select(ModifierUtil.getNationalUt());
		    	combo_fontion.getSelectionModel().select(ModifierUtil.getFonction());
		    	matriculeUtil = null;
		    	//dateTiemIncscripionUtilisateur.setTime(0);
		    	//photoUtilisateur.setImage(ModifierUtil.getPhotoUtil());
		    	
		    }else if(ModifierUtil.getModifierUtilisateur() == false) {
		    	
		    }
	   }

	
	private void visibiliterLabel() {
		 alertPrenom.setVisible(false);
		 alertNom.setVisible(false);
	     alertGenre.setVisible(false);
	     alerteDate.setVisible(false);
	     alertAdress.setVisible(false);
	     alertNationaliter.setVisible(false);
	     AlertpHOTO.setVisible(false);
	     alertFonction.setVisible(false);
	     labeleInfoPhoto.setVisible(false);
	     labeleInfochamp.setVisible(false);
	    if(ModifierUtil.getModifierUtilisateur() == true) {
		    ValiderDonnerutilisateur.setVisible(true);
		    sauvegarderDonnerutilisateur.setVisible(false);
	    }else if(ModifierUtil.getModifierUtilisateur() == false) {
		    sauvegarderDonnerutilisateur.setVisible(true);
		    ValiderDonnerutilisateur.setVisible(false);
	    }
	}
    @FXML
    void ClosedBoxe(MouseEvent event) {
    	Button btn = (Button)  event.getSource();
    	Stage stag = (Stage) btn.getScene().getWindow();
    	stag.close();

    }

    @FXML
    void OpenBox(ActionEvent event){
    	visibiliterLabel() ;
    	
    	/*
    	 Window stage = vbBoxDialogue.getScene().getWindow();
    	fileChooser.setTitle("Save Dialogue");
    	fileChooser.setInitialFileName("MySave");
    	    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt", "*.docx", "*.doc"),
    			new FileChooser.ExtensionFilter("PDF", "*.pdf"),
    			new FileChooser.ExtensionFilter("image", "*.png", "*.jpg", "*.gif"));

    	
    	try {
    		File file = fileChooser.showSaveDialog(stage);
    		fileChooser.setInitialDirectory(file.getParentFile());
    	}catch(Exception ex) {
    		
    	}
    	
    	*/
    	
    	Window stage = vbBoxDialogue.getScene().getWindow();
    	fileChooser.setTitle("Dialogue de recherche d'une photo de profil");
    	fileChooser.setInitialFileName("MySave");
    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image", "*.png", "*.jpg", "*.gif"));
    	
    	try {
    		File file = fileChooser.showOpenDialog(stage); // selection un fichier 
    		//List<File> files =  fileChooser.showOpenMultipleDialog(stage); // selection plusieur ficher
    		
    		fileChooser.setInitialDirectory(file.getParentFile());
    		
    		obbtenireIage = file.toURI().toString();
    		
    		Image phtotoImage = new Image(obbtenireIage);
    		
    		
    		if(phtotoImage != null) {
    			photoUtilisateur.setImage(phtotoImage);
    			FileInputStream fichier = new FileInputStream(file);
    			//photoUtile = fichier;
    			setphotoUtileUtil(fichier);
    		}
    	}catch(Exception ex) {
    		
    	}
    	if(obbtenireIage == null) {
			labeleInfoPhoto.setVisible(true);
			 AlertpHOTO.setVisible(true);
		}
    	
    }
    
    private void initialisationChamps() {
    	Image phtotoImage = new Image("/Icons/account.png");
    	PrenomUtilisateur.setText("");
    	nomUtillisateur.setText("");
    	combo_genre.getSelectionModel().select(0);
    	combo_age.setPromptText("");
    	addresseUtilisateur.setText("");
    	combo_nationnalite.getSelectionModel().select(0);
    	combo_fontion.getSelectionModel().select(0);
    	matriculeUtil = null;
    	setDateTiemIncscripionUtilisateur(null);
    	photoUtilisateur.setImage(phtotoImage);
    }
    

	private void afficherAjout() {
        System.out.println("\n 1 :Prenom : "+getPrenomUtil()
					        +"\n 2 Nom : "+getNomUtil()
					        +"\n 3 Genre : "+getgenreUtil()
					        +"\n 4 Date naissance : "+getAgeUtil()
					        +"\n 5 address : "+getAddressUtil()
					        +"\n 6 Nationalite : "+getNationaliteUtil()
					        +"\n 7 Fonction : "+getFonction()
					        +"\n 8 PHOTO "+getphotoUtileUtil()
					        +"\n 9 Matricule : "+getMatriculeUtil()
					        +"\n 10 Date inscription "+getDateTiemIncscripionUtilisateur()
					        +"\n 11 age "+getUtilisateurAge());
    }

    private void SaveDonnerSurBase() {
		saisieChamp();
		afficherAjout();
         if(getPrenomUtil() != null && getNomUtil() != null && getgenreUtil() != null && getAgeUtil() != null && getAddressUtil() != null && getNationaliteUtil() >= 1 && getFonction() >= 1 && getphotoUtileUtil() != null) {             
	     	    if(ModifierUtil.getModifierUtilisateur() == true) {
	     	    	 ModifierAccount();
	     	    	 afficherAjout();
	     	    	 
		  	          initialisationChamps(); 
		  	          finit = true;
	    	    }else if(ModifierUtil.getModifierUtilisateur() == false) {
	    	    	inserNewAccount();
	    	    	afficherAjout();
	    	    	
	  	          initialisationChamps(); 
	  	          finit = true;
	    	    }
          }else {
        	  if(getPrenomUtil() == null && getNomUtil() == null && getgenreUtil() == null && getAgeUtil() == null && getAddressUtil() == null && getNationaliteUtil() < 1 && getFonction() < 1 && getphotoUtileUtil() == null) {             
        		  
        		     alertPrenom.setVisible(true);
        		     alertNom.setVisible(true);
        		     alertGenre.setVisible(true);
        		     alerteDate.setVisible(true);
        		     alertAdress.setVisible(true);
        		     alertNationaliter.setVisible(true);
        		     AlertpHOTO.setVisible(true);
        		     alertFonction.setVisible(true);
        		     sauvegarderDonnerutilisateur.setVisible(false);
        		     ValiderDonnerutilisateur.setVisible(false);
        		     labeleInfochamp.setVisible(true);
              }else {
            	  if(getPrenomUtil() == null) {
            		  alertPrenom.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getNomUtil() == null) {
            		  alertNom.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getgenreUtil() == null) {
            		  alertGenre.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getAgeUtil() == null) {
            		  alerteDate.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getAddressUtil() == null) {
            		  alertAdress.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if( getNationaliteUtil() <  1) {
            		  alertNationaliter.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getFonction() < 1) {
            		  alertFonction.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
            	  if(getphotoUtileUtil()  == null) {
            		  AlertpHOTO.setVisible(true);
            		  labeleInfochamp.setVisible(true);
            		  sauvegarderDonnerutilisateur.setVisible(false);
            		  ValiderDonnerutilisateur.setVisible(false);
            		  labeleInfochamp.setVisible(true);
            	  }
              }

           }

    	}

//fx:Controller="ControllerFXMLListe.ControllersDialogueInscription"
    
    private void inserNewAccount() {
          String insert = "INSERT INTO tachaide.compte_utilisateur(Prenom, Nom, Genre, DATE_naissance, Address, Nationnalite_ID, Fonction_ID, PhotoUtilisateur, MatriculeUtilisateur, Date_inscription, AgeUtilisateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
         try {
        	
			dao.SaveMasseData(insert, getPrenomUtil(), getNomUtil(), getgenreUtil(), getAgeUtil(), getAddressUtil(), getNationaliteUtil(), getFonction(), getphotoUtileUtil(), getMatriculeUtil(), getDateTiemIncscripionUtilisateur(), getUtilisateurAge());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    private void ModifierAccount() {
    	String insert = "UPDATE  tachaide.compte_utilisateur SET Prenom =?, Nom = ?, Genre = ?, DATE_naissance = ?, Address = ?, Nationnalite_ID = ?, Fonction_ID = ?, PhotoUtilisateur = ?, MatriculeUtilisateur = ?, Date_inscription = ? , AgeUtilisateur = ? WHERE compte_ID ="+ModifierUtil.getID_Util()+"";
         try {
        	
			dao.SaveMasseData(insert, getPrenomUtil(), getNomUtil(), getgenreUtil(), getAgeUtil(), getAddressUtil(), getNationaliteUtil(), getFonction(), getphotoUtileUtil(), getMatriculeUtil(), getDateTiemIncscripionUtilisateur(), getUtilisateurAge());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
	private void initGender() {
		List<String> liste = new ArrayList<String>();
		
		// ajouter la liste genre dans la liste ArrayListe
		for(String content : agander) {
			liste.add(content);
		}
		//
		ObservableList objetListe = FXCollections.observableArrayList(liste);
		combo_genre.setItems(objetListe);
	}
	
	private void initPosition() {
		combo_fontion.getSelectionModel().clearSelection();
		listeFonction = "SELECT fonctionUtilisateur FROM tachaide.fonction_utilisateur";
		combo_fontion.setItems(dao.getFonctionDataListeCombox(listeFonction));
	}
	
	private void initNationnalite() {
		combo_nationnalite.getSelectionModel().clearSelection();
		listeFonction = "SELECT NationnaliteUtilisateur FROM tachaide.nationnalite_utilisateur";
		combo_nationnalite.setItems(dao.getFonctionDataListeCombox(listeFonction));
	}
	
	private void showPosition() {
		try {
			loader = new FXMLLoader();
			
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			
			loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxFonction.fxml"));
			ControllersFonctionL controller = new ControllersFonctionL();
			loader.setController(controller);
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
	private void showListesPersonnerAjouter() {
		try {
			loader = new FXMLLoader();
			
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			
			loader.setLocation(getClass().getResource("/fxmlListe/DialogueBoxListesParsonneAjouter.fxml"));
			ControllersListesPersonnerAjouter controller = new ControllersListesPersonnerAjouter();
			loader.setController(controller);
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
	
	
	public String getPrenomUtil() {
		return prenomUtil;
	}
	public void setPrenomUtilisateur(JFXTextField valeur) {
		this.PrenomUtilisateur = valeur;
	}
	
	public String getNomUtil() {
		return nomUtil;
	}
	public void setNomUtillisateur(JFXTextField valeur) {
		this.nomUtillisateur = valeur;
	}
	
	public int getNationaliteUtil() {
		return nationaliteUtil;
	}
	public void setNationaliteUtil(int valeurnationaliteUtil) {
		this.nationaliteUtil = valeurnationaliteUtil;
	}
	public void setCombo_nationnalite(JFXComboBox<ControllersDonneDialogueFonction> valeur) {
		this.combo_nationnalite = valeur;
	}
	
	public String getAddressUtil() {
		return addressUtil;
	}
	public void setAddressUtil(String valeuraddressUtil) {
		this.addressUtil = valeuraddressUtil;
	}
	public void setAddresseUtilisateur(JFXTextField valeur) {
		this.addresseUtilisateur = valeur;
	}
	
	public String getgenreUtil() {
		return genreUtil;
	}
	public void getgenreUtil(String valeurgenreUtil) {
		this.genreUtil = valeurgenreUtil;
	}
	public void  setCombo_genre(JFXComboBox<String> valeur) {
		this.combo_genre = valeur;
	}
	
	public String getAgeUtil() {
		return ageUtil;
	}
	public void setAgeUtil(String valeurageUtil) {
		this.ageUtil = valeurageUtil;
	}
	public void setCombo_age(JFXDatePicker valeur) {
		this.combo_age = valeur;
	}
	
	public FileInputStream getphotoUtileUtil() {
		return photoUtile;
	}
	public void setphotoUtileUtil(FileInputStream photoImage) {
		this.photoUtile = photoImage;
	}
	public ImageView getPhotoUtilisateur() {
		return photoUtilisateur;
	}
	public void setPhotoUtilisateur(ImageView valeurphotoUtilisateur) {
		this.photoUtilisateur = valeurphotoUtilisateur;
	}
	
	
	
	public int getFonction() {
		return fonctionUtil;
	}
	public void setFonctionUtil(int fonctionUtil) {
		this.fonctionUtil = fonctionUtil;
	}
	
	public void SetCombo_fontion(JFXComboBox<ControllersDonneDialogueFonction> valeur) {
		this.combo_fontion = valeur;
	}
	
	public String getMatriculeUtil() {
		return matriculeUtil;
	}
	public void setMatriculeUtil(String matriculeUtil) {
		this.matriculeUtil = matriculeUtil;
	}
	
	public int getUtilisateurAge() {
		return UtilisateurAge;
	}
	public void setUtilisateurAge(int valeurUtilisateurAge){
		this.UtilisateurAge = valeurUtilisateurAge;
	}
	
	public Timestamp getDateTiemIncscripionUtilisateur() {
		return dateTiemIncscripionUtilisateur;
	}
    public void setDateTiemIncscripionUtilisateur(Timestamp valeurdateTiemIncscripionUtilisateur) {
    	this.dateTiemIncscripionUtilisateur = valeurdateTiemIncscripionUtilisateur;
	}
    
	public boolean getFinit(){
		return finit;
	}
	


	
}
