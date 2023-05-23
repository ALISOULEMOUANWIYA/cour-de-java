package Windows2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class LIstenerDesEvenement6
{
	
	public LIstenerDesEvenement6() {
		Frame fr = new Frame("Ma fenetre");
		Button btn = new Button("Clique moi ");
		
		//ajoutons l'evenement au bouton cliquer moi
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Button "+ev.getSource()+"Cliquer");
			}
		});
		
		fr.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
		
		
		fr.add(btn);// ajouter le bouton dans la fenetre
		fr.pack();
		fr.setVisible(true);
		
	}

	public static void main(String [] args) {
		new LIstenerDesEvenement6();
	}
	
}


