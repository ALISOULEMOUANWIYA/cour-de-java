package DessinSapin5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GestionAction implements ActionListener{
	
	private int n;
	private Dessin d;
	private static int model = 0;
	private JFrame j;
	
	public GestionAction(int n, Dessin d, JFrame j) {
		this.n = n;
		this.d = d;
		this.j = j;
	}

	
	public void actionPerformed(ActionEvent e) {
		switch(n) {
			case 1:
				d.nouveau();
			break;
			case 2:
				System.exit(0);
				break;
			case 3:
				GestionModel();
			break;
		}
	}
	
	private void GestionModel() {
		String LAndf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		try {
		  switch(model) {
			case 0:
				LAndf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel"; 
				System.out.println(" Model Motife");
			break;
			case 1:
				LAndf = "javax.swing.plaf.metal.MetalLookAndFeel";
				System.out.println(" Model metal ");
			break;
			case 2:
				LAndf = "javax.swing.plaf.mac.MacLookAndFeel";
				System.out.println(" Model mac ");
			break;
			case 3:
				LAndf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				System.out.println(" Model windows ");
			break;
		 }
		UIManager.setLookAndFeel(LAndf);
		SwingUtilities.updateComponentTreeUI(j);
	  }catch(UnsupportedLookAndFeelException ex) {
		  System.out.println("Exeception : Modele non disponible ");
	  }
	  catch(IllegalAccessException ex) {
		  System.out.println("Exeception : Modele non accessible ");
	  }
	  catch(ClassNotFoundException ex) {
		  System.out.println("Exeception : Modele non trouver ");
	  }
	  catch(InstantiationException ex) {
		  System.out.println("Exeception : Modele non instabciable ");
	  }
	  catch(Exception ex) {
		 System.out.println("Exeception : Erreur d'execution");
	  }
	
	model++;
	model = model % 4;
		
  }


}
