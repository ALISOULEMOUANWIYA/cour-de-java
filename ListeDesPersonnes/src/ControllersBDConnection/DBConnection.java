package ControllersBDConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection extends Configures{
    
    Connection dbConnection;
    
    public Connection getConnection(){
        
        String connectionString;
        connectionString = "jdbc:mysql://"
			                +Configures.dbhost+":"
			                +Configures.dbport
			        		+"/"+Configures.dbname
			        		+"?autoReconnect-trueBuseSS-false";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        try {
			dbConnection = DriverManager.getConnection(connectionString,Configures.dbuser,Configures.dbpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dbConnection;
    }
    
    public void Close(Connection connect, PreparedStatement pstmt, ResultSet rs) {
    	try {
    		if(connect != null) {
    			connect.close();
    		}if(pstmt != null) {
    			pstmt.close();
    		}if(rs != null) {
    			rs.close();
    		}
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    public void Close(Connection connect, PreparedStatement pstmt) {
    	try {
    		Close(connect, pstmt, null);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public void Close(PreparedStatement pstmt) {
    	try {
    		Close(null, pstmt, null);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
