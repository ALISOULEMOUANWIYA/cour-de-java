import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
	
	private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		try ( FileInputStream fis = new FileInputStream( "conf.properties" ) ) {
			props.load( fis );
		}
		
		//Class.forName( props.getProperty( "jdbc.driver.class" ) );
		Class.forName( props.getProperty( "com.mysql.jdbc.Driver" ) );
		
		String url = props.getProperty( "jdbc.url" );
		String dbLogin = props.getProperty( "jdbc.login" );
		String dbPassword = props.getProperty( "jdbc.password" );
		
		try ( Connection connection = DriverManager.getConnection( url, dbLogin, dbPassword ) ) {
			String readedLogin = "";
			System.out.println( "Welcome to WebStore V1.0 - Copyright KooR.fr");
			while( true ) {
				System.out.print( "Login: ");
				String login = keyboard.readLine();
				System.out.print( "Password: ");
				String password = keyboard.readLine();
				
				String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
				try ( Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( strSql ) ) {
					if ( resultSet.next() ) {
						strSql = "UPDATE T_Users SET connectionNumber=connectionNumber+1 WHERE idUser=" + resultSet.getInt( "idUser" );
						try ( Statement stUpdate = connection.createStatement() ) {
							stUpdate.executeUpdate( strSql );
						}
						
						readedLogin = resultSet.getString( "login" );
						break;
					}
					System.out.println( "Wrong password" );
				}
			}
			
			System.out.println( readedLogin + ", you are connected" );
		}
		
	}

}
