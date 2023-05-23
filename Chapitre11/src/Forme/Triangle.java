package Forme;

import java.awt.Graphics;

public class Triangle extends lesFormes{
	
	private int [] xPoints = {0, 10, -10};
	private int [] yPoints = {-10, 10, 10};
	
	public Triangle() {
		xPoints[0] = coordonneX;
		yPoints[0] = coordonneY;
		System.out.println("Position en X0 = "+xPoints[0]+", Position en Y0 = "+yPoints[0]);
		for(int i = 1; i < xPoints.length; i++) {
			xPoints[i] = verifier("Position en X"+i+" = ", 0, getLargeurEcran());
			yPoints[i] = verifier("Position en Y"+i+" = ", 0, getlongueurEcran());
		}
	}
	
	public Triangle(int abcsisse , int ordonne, int nxb, int nyb, int nxc, int nyc, int couleur) {
		super(abcsisse , ordonne, couleur);
		xPoints[0] = coordonneX;
		yPoints[0] = coordonneY;
		xPoints[1] = verifier(nxb, 0, getLargeurEcran());
		yPoints[1] = verifier(nyb, 0, getlongueurEcran());
		xPoints[2] = verifier(nxc, 0, getLargeurEcran());
		yPoints[2] = verifier(nyc, 0, getlongueurEcran());
	}
	
	public void dessiner(Graphics g) {
		super.dessiner(g);
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public void depplacer(int abcsisse , int ordonne) {
		super.deplacer(abcsisse, ordonne);
		for(int i = 1; i < xPoints.length; i++) {
			xPoints[i] = verifier(abcsisse + xPoints[i], 0, getLargeurEcran());
			yPoints[i] = verifier(ordonne + yPoints[i], 0, getlongueurEcran());
		}
	}
	
	public void afficher() {
		System.out.println("\n------------- Triangle ----------------");
		super.afficher();
		for(int i = 1; i < xPoints.length; i++) {
			System.out.println("Position en X"+i+"  = "+xPoints[i]+", Position en Y"+i+" = "+yPoints[i]);
		}
	}
	
	public String getInfo() {
		return "Triangle;"+super.getInfo()+";"+xPoints[1]+";"+yPoints[1]+";"+xPoints[2]+";"+yPoints[2];
	}
	
    public int trouverLeXMin() {
    	int min = super.trouverLeXmin();
    	for(int i = 1; i < xPoints.length; i++) {
    		if(xPoints[i] < min) {
    			min = xPoints[i];
    		}
    	}
    	return min;
    }
}
