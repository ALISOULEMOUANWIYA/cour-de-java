import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

public class ShowDescribeTable {
	
	private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		try ( FileInputStream fis = new FileInputStream( "conf.properties" ) ) {
			props.load( fis );
		}
		
		Class.forName( props.getProperty( "jdbc.driver.class" ) );
		
		String url = props.getProperty( "jdbc.url" );
		String dbLogin = props.getProperty( "jdbc.login" );
		String dbPassword = props.getProperty( "jdbc.password" );
		
		try ( Connection connection = DriverManager.getConnection( url, dbLogin, dbPassword ) ) {
			
			DatabaseMetaData dbMetadata = connection.getMetaData();
			
			try ( ResultSet resultSet = dbMetadata.getTables( connection.getCatalog(), null, null, null ) ) {
				while( resultSet.next() ) {
					System.out.print( resultSet.getString( "TABLE_NAME" ) + " - " );/* les nom des tables */
				}
			}
			
			System.out.print( "\n\nEnter the table to view: " );
			String tableName = keyboard.readLine();
			
			String strSql = "SELECT * FROM " + tableName;
			
			try ( Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( strSql ) /* le contenu de la table */ ) {
				 
				ResultSetMetaData rsMetadata = resultSet.getMetaData(); /* recuperation de la table */ 
				int columnCount = rsMetadata.getColumnCount();/* identification le nombre de cellule de la la table et leurs colonnes*/
				
				for( int i=1; i<=columnCount; i++ ) {
					System.out.printf( "%-17s", rsMetadata.getColumnName( i ) );/* Les nom des colonnes de la table */
				}
				
				System.out.println( "\n-------------------------------------------------------------------" );

				while( resultSet.next() ) {
					for( int i=1; i<=columnCount; i++ ) {
						System.out.printf( "%-17s    ", resultSet.getString( i ) );/* les contenue de la table par colonnes */
					}					
					System.out.println();
				}
				
			}
			
		}
		
		System.out.println( "Bye bye" );
	}

}
