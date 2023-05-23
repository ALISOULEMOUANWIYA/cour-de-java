package Windows2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LIstenerDesEvenement4
{
	
	public LIstenerDesEvenement4() {
		Frame fr = new Frame("Ma fenetre");
		Button btn = new Button("Clique moi ");
		
		//ajoutons l'evenement au bouton cliquer moi
		  btn.addActionListener(new Handler());
		
		fr.add(btn);// ajouter le bouton dans la fenetre
		fr.pack();
		fr.setVisible(true);
		
	}

	public static void main(String [] args) {
		new LIstenerDesEvenement4();
	}
	
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			System.out.println("Button "+ev.getSource()+"Cliquer");
		}
	}
}


