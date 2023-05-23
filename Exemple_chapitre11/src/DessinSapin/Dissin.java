package DessinSapin;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;

public class Dissin extends Canvas{
	
	private static final long serialVersionUID = 1L;

	private Color couleur = Color.green;
	
	public final static Color couleurFond = Color.white;
	
	public Dissin() {
		setBackground(couleurFond);
		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
}
