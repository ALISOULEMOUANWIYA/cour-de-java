
package BDConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHabdler  extends Configures{
    
    Connection dbConnection;
    
    public Connection getConnection(){
        
        String connectionString;
        connectionString = "jdbc:mysql://"
			                +Configures.dbhost+":"
			                +Configures.dbport
			        		+"/"+Configures.dbname
			        		+"?autoReconnect-trueBuseSS-false";
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			dbConnection = DriverManager.getConnection(connectionString,Configures.dbuser,Configures.dbpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dbConnection;
    }
}
