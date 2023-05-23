package LesFichier.Fichier1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fichier {
	
	private BufferedWriter fW;
	private BufferedReader fR;
	private char modeAcces;

	public fichier(){
		
	}

// Ouvrire le fichier soit en lecture ou en ecriture
	public void ouvrir(String nomDuFichier, String mode)throws IOException {
		modeAcces = (mode.toUpperCase().charAt(0));
		File fiche = new File(nomDuFichier);
		
		if(modeAcces == 'R' || modeAcces == 'L') {
			fR = new BufferedReader(new FileReader(fiche));
		}else if(modeAcces == 'W' || modeAcces == 'E') {
			fW = new BufferedWriter(new FileWriter(fiche));
		}
	}

// Fermer le fichier soit en lecture ou en ecriture
	public void fermer() throws IOException{
		if(modeAcces == 'R' || modeAcces == 'L') {
			fR.close();
		}else if(modeAcces == 'W' || modeAcces == 'E') {
			fW.close();
		}
	}

// Lire le fichier 
	public String lire() throws IOException {
		String chaine = fR.readLine();
		return chaine;
	 }
	
// Ecrire le fichier soit en lecture ou en ecriture
	public void Ecrire(int tmp) throws IOException{
		System.out.println("Dans ecrire "+tmp);
		String chaine ="";
		chaine = String.valueOf(tmp)+"- ";
		System.out.println("Dans ecrire "+chaine);
		if(chaine != null ) {
			fW.write(chaine, 0, chaine.length());
			fW.newLine();
		}
	}
}
