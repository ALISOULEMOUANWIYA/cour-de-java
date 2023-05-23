package Forme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class fichier {
	
	private BufferedWriter fW;
	private BufferedReader fR;
	
	private char modeAcces;
	
	public boolean ouvrir(String nomFichier, String mode) throws IOException {
		modeAcces = (mode.toUpperCase().charAt(0));
		//File fichier = new File(nomFichier);
		try
		{
			if(modeAcces == 'R' || modeAcces == 'L') {
				fR = new BufferedReader(new FileReader(nomFichier));
			}else if(modeAcces == 'W' || modeAcces == 'E') {
				fW = new BufferedWriter(new FileWriter(nomFichier));
			}
			return true;
		} 
		catch(IOException e)
		{
			return false; 
		}
	}
	
	public boolean fermer() throws IOException{
		try {
			if(modeAcces == 'L' || modeAcces == 'R') {
				fR.close();
			}else if(modeAcces == 'W' || modeAcces == 'E') {
				fW.close();
			}
			return true;
		}catch(IOException ex) {
			return false;
		}
	}
	
	public String [] lire() throws IOException{
		String ligne;
		int i = 0;
		ligne = fR.readLine();
			
		if(ligne != null) {
		  StringTokenizer st = new StringTokenizer(ligne, ";");
		  String mot[] = new String[st.countTokens()];
		  while(st.hasMoreTokens()) {
			 mot[i] = st.nextToken();
			 i++;
		  }
			return mot;
		}
		return null;
	 }
	
	
	// la methode ecrire dans le fichier
	  public void ecrire(String chaine) throws IOException{
		  System.out.println("Figure = "+chaine);
		  
		  fW.write(chaine, 0, chaine.length());
		  fW.newLine();
	  }
}
