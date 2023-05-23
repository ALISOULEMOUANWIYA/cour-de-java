package SapinNoel2;

import java.awt.Color;
import java.awt.Graphics;

public class triangle {
	
	private int [] xPoints = {0, 10, -10}; 
	private int [] yPoints = {-10, 10, 10};
	
	private int px = fenetreSapin.Ht / 2 - 50;
	private int py = fenetreSapin.Lg  / 2 - 50;
	
	private int nPoints = 3;
	
	public triangle(int col, int lig, Graphics g, Color c) {
		
		for(int i = 0; i < nPoints; i++) {
			xPoints[i] = xPoints[i] + (5*lig) + px;
			yPoints[i] = yPoints[i] + (15*col) + py;
		}
		
		g.setColor(c);

		
		g.fillPolygon(xPoints, yPoints, nPoints);
		
	}
}
