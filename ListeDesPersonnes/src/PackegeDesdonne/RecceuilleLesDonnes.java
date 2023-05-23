package PackegeDesdonne;


public class RecceuilleLesDonnes {
	
	private String codeMatriculeUtilisateur;
	
	public RecceuilleLesDonnes() {
	}
	
	
	public String CreerMatriculeUtilisateur(String valeur1, String valeur2, String valeur3, String valeur4, String valeur5, int valeur6, int valeur7) {
		String finIsbn;
		finIsbn = "Mat";
		codeMatriculeUtilisateur = ""+valeur1.substring(0, 2)+""+ 
				                      valeur2.substring(0, 2)+""+
				                      Integer.toString((int)(Math.random()+ 12))+""+
				                      valeur3.substring(0, 2)+""+
				                      valeur4.substring(0, 2)+""+
				                      Integer.toString((int)(Math.random()+ 23))+""+
				                      valeur5.subSequence(0, 2)+""+ 
				                      valeur6+""+ 
				                      Integer.toString((int)(Math.random()+ 34))+""+
				                      valeur7+""+
				                      finIsbn ;
		codeMatriculeUtilisateur.toUpperCase(); 
			
			return codeMatriculeUtilisateur;
	}

}
