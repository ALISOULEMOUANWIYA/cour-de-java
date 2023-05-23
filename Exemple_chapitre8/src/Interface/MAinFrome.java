package Interface;

public class MAinFrome {

	public static void main(String[] args) {
		Cercle a = new Cercle(5,5);
		
		a.afficher();
		if(a.perimetre() >=0) {
			System.out.println("le perimetre du cercle A : "+a.perimetre());
		}else {
			System.out.println("Calcule imposible ");
		}
		
        Forme b = new Forme(10,10);
		
		b.afficher();
		if(b.perimetre() >=0) {
			System.out.println("le perimetre du cercle A : "+b.perimetre());
		}else {
			System.out.println("Calcule imposible ");
		}
	}

}
