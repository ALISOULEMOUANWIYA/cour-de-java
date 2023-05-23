package DessinSapin4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GestionAction implements ActionListener{
	
	private  int n;
	private Dessin d;
	private JFrame j;
	
	private static int modele = 0;
	
	public GestionAction(int nmb, Dessin des, JFrame joi) {
		this.n = nmb;
		this.d = des;
		this.j = joi;
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
				GestionModele();
			break;
		}
		
	}
	
	private void GestionModele() {
		String landf ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		try {
		    switch(modele) {
				case 0:
					landf ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				break;
				case 1:
					landf ="javx.swing.plaf.metal.MetalLookAndFeel";
				break;
				case 2:
					landf ="javax.swing.plaf.mac.MacLookAndFeel";
				break;
				case 3:
					landf ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				break;
			}
		    UIManager.setLookAndFeel(landf);
			SwingUtilities.updateComponentTreeUI(j);
		}
		catch(UnsupportedLookAndFeelException ex) {
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
			modele++;
			modele = modele % 4;
		}
	}

