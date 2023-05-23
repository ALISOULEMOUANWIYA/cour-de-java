package exemple;

import java.io.IOException;

public class Encodage {

	public static void main(String[] args)  throws IOException{
		String encodage = System.getProperty("file.encoding");
		System.out.println("Encodage par defaut : "+encodage);
		
		String proverbe = "qui s\u00E8me le vent, r\u00E9colte la temp\u00EAte";
		
		String proverbeEncode = new String(proverbe.getBytes(),encodage);
		System.out.println("Proverbe : "+proverbeEncode);
	
	}

}
