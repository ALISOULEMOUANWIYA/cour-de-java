package Connection1;

import java.sql.*;

public class Connecter {

	public static void main(String[] args) {
		Connection connct = connecterBD();
	}
	
	public static Connection connecterBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver oki");
			String url = "jdbc:mysql://localhost:3306/webstore";
			String user = "root";
			String password = "";
			
			Connection cnx = DriverManager.getConnection(url, user, password);
			System.out.println("Connection etablie");
			return cnx;
		}catch(Exception ex) {
			return null;	
		}
	}
}
