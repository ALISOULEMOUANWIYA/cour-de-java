package DessinSapin3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.*;

public class DesBoutons extends Panel{

	private static final long serialVersionUID = 1L;
	
	
	public DesBoutons(Dessin d) {
		setBackground(Color.lightGray);
		
		// les buttons
		
		Button bPeindre = new Button("Nouveau");
		bPeindre.addActionListener(new GestionAction(1, d));
		this.add(bPeindre);
		
		Button bQuitter = new Button("Quitter");
		bQuitter.addActionListener(new GestionAction(2, d));
		this.add(bQuitter);
	}
}
