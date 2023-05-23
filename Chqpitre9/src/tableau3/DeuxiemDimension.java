package tableau3;

public class DeuxiemDimension {

	public static void main(String[] args) {
		
		int [][] etoile = new int[8][8];
		
		System.out.println(etoile[0].length+"\n\n");
		// Initialisation du tableau
			for(int i = 0; i < etoile.length; i++) {
				for(int j = 0; j < etoile[0].length; j++) {
				
					//etoile[i][j] = 0;
					//etoile[3][j] = 1;
					//etoile[i][3] = 1;
					//etoile[i][6 - j] = 1;
					
					
			// les different cas � connaitre sur les axes des tableaux		
					
			   /*	
					if(i == j) {
						etoile[i][j] = 1;
					}
				*/
					
					
					if((i + j)+1 == etoile.length) {
						etoile[i][j] = 1;
					}
					
					
				/*
					
					if((i + j)+1 < etoile.length) {
						etoile[i][j] = 1;
					}
				
				*/	
					
						
				/*
					
					if((i + j)+1 > etoile.length) {
						etoile[i][j] = 1;
					}
				
				*/
				
					
				/*
					
					if(i > j) {
						etoile[i][j] = 1;
					}
				
				*/
					
				/*
					
					if(i < j) {
						etoile[i][j] = 1;
					}
				
				*/
							
				}
			}
			
			// affichage du tableau
			for(int i = 0; i < etoile.length; i++) {
				for(int j = 0; j < etoile[0].length; j++) {
					if(etoile[i][j] == 0) {
						//System.out.print(etoile[i][j]+" ");
						System.out.print(". ");
					}else {
						System.out.print(etoile[i][j]+" ");
					}
				}
				System.out.println();
			}
	}

}
