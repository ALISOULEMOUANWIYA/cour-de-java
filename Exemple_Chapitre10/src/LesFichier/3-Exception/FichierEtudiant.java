package LesFichier.Exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FichierEtudiant {
	
	private String nomDuFichier = "Cursuss.stk";
	private ObjectOutputStream fWo;
	private ObjectInputStream fRo;
	private char modeAcces;
	
	// ouvrire le fichier 
	public boolean ouvrir(String mode) {
	   try {
			modeAcces = (mode.toUpperCase().charAt(0));
			if(modeAcces == 'L' || modeAcces == 'R') {
			  fRo = new ObjectInputStream(new FileInputStream(nomDuFichier));
			}else if(modeAcces == 'W' || modeAcces == 'E') {
				  fWo = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
			}
			
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	// lire le fichier 
	public Cursus lire() {
		Cursus tmp;
		try {
			tmp = (Cursus) fRo.readObject();
			return tmp;
		} catch (ClassNotFoundException e) {
			System.out.println(nomDuFichier+"Erreur de lecture ");
		} catch (IOException e) {
			System.out.println(nomDuFichier+"n'est pas du bon format");
		}
		return null;
	}
	
	// fermer le fichier
	public void fermer() throws IOException{
		if(modeAcces == 'R' || modeAcces == 'L') {
			fRo.close();
		}else if(modeAcces == 'W' || modeAcces == 'E') {
			fWo.close();
		}
	}
	
	// Ecrire dans le fichier
	public void ecrire(Cursus tmp) throws IOException{
		if(tmp != null) {
			fWo.writeObject(tmp);
		}
	}
}
