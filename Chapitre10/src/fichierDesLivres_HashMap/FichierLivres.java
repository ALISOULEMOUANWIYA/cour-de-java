package fichierDesLivres_HashMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FichierLivres {
	
	private String nomDuFIchier = "Bibliotheque.stk";
	private char modeAcces;
	private ObjectOutputStream fWo;
	private ObjectInputStream fRo;
	
	
	// ouvrire le fichier 
		public boolean ouvrir(String mode) {
		   try {
				modeAcces = (mode.toUpperCase().charAt(0));
				if(modeAcces == 'L' || modeAcces == 'R') {
				  fRo = new ObjectInputStream(new FileInputStream(nomDuFIchier));
				}else if(modeAcces == 'W' || modeAcces == 'E') {
					  fWo = new ObjectOutputStream(new FileOutputStream(nomDuFIchier));
				}
				
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		
		// lire le fichier 
		public ListesDesLivres lire() {
			ListesDesLivres tmp;
			try {
				tmp = (ListesDesLivres) fRo.readObject();
				return tmp;
			} catch (ClassNotFoundException e) {
				System.out.println(nomDuFIchier+"Erreur de lecture ");
			} catch (IOException e) {
				System.out.println(nomDuFIchier+"n'est pas du bon format");
			}
			return null;
		}
		
		// fermer le fichier
		public boolean fermer() throws IOException{
			try {
				if(modeAcces == 'R' || modeAcces == 'L') {
					fRo.close();
				}else if(modeAcces == 'W' || modeAcces == 'E') {
					fWo.close();
				}
				return true;
			}catch(IOException e) {
				return false;
			}
			
		}
		
		// Ecrire dans le fichier
		public void ecrire(ListesDesLivres tmp) throws IOException{
			if(tmp != null) {
				fWo.writeObject(tmp);
			}
		}
}
