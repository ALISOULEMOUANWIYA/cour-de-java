package SapinNoel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GestionAction implements ActionListener{
	
	private int n;
	private Dessin d;
	private JFrame j;
	private static int modele = 0;
	
	public GestionAction(int n, Dessin d, JFrame j) {
		this.n = n;
		this.d = d;
		this.j = j;
	}
	
	public void actionPerformed(ActionEvent ev) {
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
					System.out.println("Modele motif");
				break;
				case 1:
					landf ="javax.swing.plaf.metal.MetalLookAndFeel";
					System.out.println("Modele metal");
				break;
				case 2:
					landf ="javax.swing.plaf.mac.MacLookAndFeel";
					System.out.println("Modele mac");
				break;
				case 3:
					landf ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					System.out.println("Modele Windows");
				break;
			}
			UIManager.setLookAndFeel(landf);
			SwingUtilities.updateComponentTreeUI(j);
		}catch(UnsupportedLookAndFeelException ex) {
			System.out.println("Exeception : modele non disponible ");
		}catch(IllegalAccessException ex) {
			System.out.println("Exeception : modele non accessible ");
		}catch(ClassNotFoundException ex) {
			System.out.println("Exeception : modele non trouver");
		}catch(InstantiationException ex) {
			System.out.println("Exeception : modele non instanciable");
		}catch(Exception ex) {
			System.out.println("Exeception : erreur d'execution");
		}
		
		modele ++;
		modele = modele % 4;
	}
	
}
