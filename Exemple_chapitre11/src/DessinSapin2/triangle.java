package DessinSapin2;

import java.awt.Color;
import java.awt.Graphics;

public class triangle {
	
	private int px = FentreSapin.Lg/2 - 50;
	private int py = FentreSapin.Ht/2 - 50;
	
	private int [] xPoints = {0, 10, -10};
	private int [] yPoints = {-10, 10, 10};
	private int nPoints = 3;
	
	public triangle(int col, int lig, Graphics g, Color c) {
		for(int j = 0; j < nPoints; j++) {
			xPoints[j] = xPoints[j] + (5*lig) + px;
			yPoints[j] = yPoints[j] + (15*col) + py;
		}
		g.setColor(c);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}
