package ControllersBDConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ControllersDesDonnesListes.ControllersDonneDataListes;
import ControllersDesDonnesListes.ControllersDonneDataparametreListes;
import ControllersDesDonnesListes.ControllersDonneDialogueFonction;
import ControllersDesDonnesListes.ControllersDonneDialogueListeAjouter;
import ControllersDesDonnesListes.ControllersFonctionaire;
import ControllersDesDonnesListes.ControllersListeDialogueBox;
import ControllersDesDonnesListes.conteurListe;
import ControllersDesDonnesListes.conteurListeParametre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataAccessObject{
	
	private DBConnection dataBase = new DBConnection();
	private static int ValeurTrouver = 0;
	
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection connect;
	
	public DataAccessObject() {
	}
	
	public void saveData(String fonctionUtil) {
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(fonctionUtil);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
	}
	
	public void saveRaportJaport(String RaportTacheAide, String nomFichier, FileInputStream fichierJaspert) {
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(RaportTacheAide);
			pstmt.setString(1, nomFichier);
			pstmt.setBinaryStream(2, fichierJaspert, fichierJaspert.available());
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
	}
	
	public ObservableList<ControllersDonneDialogueFonction> getFonctionDataListe(String utilisateurFonction){
		
		ObservableList<ControllersDonneDialogueFonction> list = FXCollections.observableArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ControllersDonneDialogueFonction(rs.getString(1)));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		
		return list;
	}
	public ObservableList<ControllersDonneDialogueListeAjouter> getFonctionDataListeAjouter(String utilisateurAjouter){
		
		ObservableList<ControllersDonneDialogueListeAjouter> listAjouter = FXCollections.observableArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurAjouter);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				listAjouter.add(new ControllersDonneDialogueListeAjouter(rs.getString(1), rs.getString(2), rs.getBlob(3), rs.getString(4)));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		
		return listAjouter;
	}
	

		public ObservableList<ControllersListeDialogueBox> getCompteData(String utilisateurcompte){

			ObservableList list = FXCollections.observableArrayList();
			
			try {
				connect = dataBase.getConnection();
				
				pstmt = connect.prepareStatement(utilisateurcompte);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new ControllersListeDialogueBox(rs.getInt(1),rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
							rs.getString(7), rs.getInt(8) ,rs.getString(9), rs.getInt(10), 
							rs.getBlob(11), rs.getString(12), rs.getTimestamp(13), rs.getInt(14))); 
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				dataBase.Close(connect , pstmt, null);
			}		
			return list;
		}
		
	/*-------------------------------------------- debut Connection Compte Fonctionnaire-------------------------------*/
		public void ConnectionCompteFonctionnaire(String RequetteSql, String Prenom_Ou_Email_Fonctionnaire, String PassWord_Fonctionnaire) {
			int count = 0;
			try {
				connect = dataBase.getConnection();
				pstmt = connect.prepareStatement(RequetteSql);
				pstmt.setString(1, Prenom_Ou_Email_Fonctionnaire);
				pstmt.setString(2, PassWord_Fonctionnaire);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					count = count + 1;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				dataBase.Close(connect , pstmt, null);
			}
			setValeurtrouver(count);
		}
		public List<ControllersFonctionaire> getCompteDataFonctionnaire(String utilisateurcompte){
			List<ControllersFonctionaire> listFonction = new ArrayList();
			
			try {
				connect = dataBase.getConnection();
				
				pstmt = connect.prepareStatement(utilisateurcompte);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					listFonction.add(new ControllersFonctionaire(rs.getInt(1),rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
							rs.getInt(7), rs.getString(8) ,rs.getString(9), rs.getString(10), 
							rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getString(14),
							rs.getBlob(15), rs.getString(16), rs.getTimestamp(17), rs.getInt(18))); 
					
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				dataBase.Close(connect , pstmt, null);
			}
			return listFonction;
		}
		public static int getValeurtrouver() {
			return ValeurTrouver;
		}
		public void setValeurtrouver(int valeurconnect) {
			this.ValeurTrouver = valeurconnect;
		}
	/*-------------------------------------------------- fin Connection Compte Fonctionnaire-----------------------*/
	public ObservableList<ControllersDonneDialogueFonction> getFonctionDataListeCombox(String utilisateurFonction){
		
		ObservableList list = FXCollections.observableArrayList();
		
		try {
			connect = dataBase.getConnection();
			
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		
		return list;
	}


	public void SaveMasseData(String insert, String prenomUtil, String nomUtil, String genreUtil, String ageUtil,
			String addressUtil, int nationaliteUtil, int fonctionUtil, FileInputStream photoUtile , String MatriculeUtil,
			Timestamp DateINscriptionUtilisateur, int UtilisateurAge) throws IOException{
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(insert);
        	pstmt.setString(1, prenomUtil);
			pstmt.setString(2, nomUtil);
			pstmt.setString(3, genreUtil);
			pstmt.setString(4, ageUtil);
			pstmt.setString(5, addressUtil);
			pstmt.setInt(6, nationaliteUtil);
			pstmt.setInt(7, fonctionUtil);
			pstmt.setBinaryStream(8, photoUtile, photoUtile.available());
			pstmt.setString(9, MatriculeUtil);//UtilisateurAge
			pstmt.setTimestamp(10, DateINscriptionUtilisateur);
			pstmt.setInt(11, UtilisateurAge);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
	}
	
	public InputStream getRaport() {
		InputStream input = null;
		String query = "SELECT fichierRaport FROM ReporAdapter WHERE nomFichier = 'RapportTate'";
		try {
			
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				input = rs.getBinaryStream(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return input;
	}
	public List<ControllersDonneDataListes> getFonctionDatabaseListe(String utilisateurFonction){
		
		List<ControllersDonneDataListes> list = new ArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ControllersDonneDataListes(rs.getInt(1), rs.getString(2)));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		
		return list;
	}
	public List<ControllersDonneDataparametreListes> getFonctionParametreListe(String utilisateurFonction){
		
		List<ControllersDonneDataparametreListes> list = new ArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ControllersDonneDataparametreListes(rs.getInt(1), rs.getString(2), rs.getBlob(3)));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		
		return list;
	}
	public List<conteurListe> getFonctionDataListeConteur(String utilisateurFonction){
		List<conteurListe> list = new ArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new conteurListe(rs.getInt(1)));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		return list;
		
	}
	public List<conteurListeParametre> getFonctionParametreListeConteur(String utilisateurFonction){
		List<conteurListeParametre> list = new ArrayList();
		
		try {
			connect = dataBase.getConnection();
			pstmt = connect.prepareStatement(utilisateurFonction);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new conteurListeParametre(rs.getInt(1)));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dataBase.Close(connect , pstmt, null);
		}
		return list;
		
	}
	
}
