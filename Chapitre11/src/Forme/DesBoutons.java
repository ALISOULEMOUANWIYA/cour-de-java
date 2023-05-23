package Forme;

import java.awt.*;
import javax.swing.*;
public class DesBoutons extends JPanel {
	public DesBoutons(DessinFormes df, JFrame j)  {
		setBackground(Color.lightGray); 
		// Les boutons
		
		JButton aGaucheScene = new JButton ("A gauche / scene");
		aGaucheScene.addActionListener(new GestionAction(1, df, j));
		this.add(aGaucheScene);
		
        JButton aGaucheForme = new JButton ("A gauche / formes");
        aGaucheForme.addActionListener(new GestionAction(2, df, j));
        this.add(aGaucheForme);
 	}
}
