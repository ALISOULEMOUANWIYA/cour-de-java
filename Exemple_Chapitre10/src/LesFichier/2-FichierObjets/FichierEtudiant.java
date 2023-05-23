package LesFichier.FichierObjets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FichierEtudiant {
	
	private ObjectOutputStream fWo;
	private ObjectInputStream fRo;
	private char modeAcces;
	private String nomDuFichier = "Cursuss.txt";
	
	// ouvrire le fichier 
		public void ouvrir(String mode)throws IOException {
			modeAcces = (mode.toUpperCase().charAt(0));
			if(modeAcces == 'R' || modeAcces == 'L') {
				fRo = new ObjectInputStream(new FileInputStream(nomDuFichier));
			}else if(modeAcces == 'W' || modeAcces == 'E') {
				fWo = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
			}
		}
	
	// fermer le fichier
		public void fermer() throws IOException{
			if(modeAcces == 'R' || modeAcces == 'L') {
				fRo.close();
			}else if(modeAcces == 'W' || modeAcces == 'R') {
				fWo.close();
			}
		}
	
	// lire le fichier
		public Cursus lire() throws IOException, ClassNotFoundException{
			Cursus tmp = (Cursus) fRo.readObject();
			return tmp;
		}
		
   // ecrire dans le fichier
		public void ecrire(Cursus tmp) throws IOException{
			if(tmp != null) {
				fWo.writeObject(tmp);
			}
		}
}
