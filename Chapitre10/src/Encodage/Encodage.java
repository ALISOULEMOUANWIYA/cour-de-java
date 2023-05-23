package Encodage;

import java.io.UnsupportedEncodingException;

public class Encodage {
	
	public static void main(String [] args) {
		
		String encodage = System.getProperty("file.encoding");
		
		System.out.println("Encodage par defaut : "+encodage);
		String proverbe  = " < > Qui s\u00E8me le vent , r\u00E9colte la tem\u00EAte donne la fleche \u0029 \u00FA \u00F7 \u00BB \u203A \u0192 \u8592";
		
		try {
			String proverbeEncode = new String (proverbe.getBytes(), encodage);
			System.out.println("Proverbe encode "+proverbeEncode); 
		} catch (UnsupportedEncodingException e) {
			System.out.println("L'encodage " + encodage + " n'est pas supporte par l'interpreteur Java");
		}
	}
}
