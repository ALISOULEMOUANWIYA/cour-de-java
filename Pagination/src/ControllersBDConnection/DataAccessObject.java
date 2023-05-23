package ControllersBDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ControllersDesDonnesListes.ControllersDonneDataListes;
import ControllersDesDonnesListes.conteurListe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataAccessObject{
	
	private DBConnection dataBase = new DBConnection();
	
	
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection connect;
	private int conteur ;
	
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
	
	public List<ControllersDonneDataListes> getFonctionDataListe(String utilisateurFonction){
		
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
		}
		return list;
		
	}
	
	
	public int getConteur() {
		return conteur;
	}
	public void setConteur(int conteur) {
		this.conteur = conteur;
	}

}
