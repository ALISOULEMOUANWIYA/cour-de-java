package trier;

public class MainTrie {

	public static void main(String[] args) {
		Cursus c = new Cursus();
		
		System.out.println("------------  Recapitulatif  --------------");
		c.afficher();
		// classement par moyenne methode 1
			 //c.classerParMoyenne();
		// classement par moyenne methode 2
			c.triageMoyenne();
		System.out.println("--------------  Classement du plus grand au plus petit  ---------------");
		c.afficher();
	
	}

}
