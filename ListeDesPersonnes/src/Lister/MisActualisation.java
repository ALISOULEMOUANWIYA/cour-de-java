package Lister;

import PackegeDesdonne.DescriptionDataCompte;

public interface MisActualisation {
	public default void SuprimerCompte(DescriptionDataCompte suprim) {
		System.out.println("ok ID : "+suprim.getID_UtilDescription());
	}
}
