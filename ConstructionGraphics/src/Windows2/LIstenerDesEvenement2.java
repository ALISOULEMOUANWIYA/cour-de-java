package Windows2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LIstenerDesEvenement2 implements ActionListener
{
	
	public LIstenerDesEvenement2() {
		Frame fr = new Frame("Ma fenetre");
		Button btn = new Button("Clique moi ");
		
		//ajoutons l'evenement au bouton cliquer moi
		  btn.addActionListener(this);
		
		fr.add(btn);// ajouter le bouton dans la fenetre
		fr.pack();
		fr.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Button "+ev.getSource()+"Cliquer");
	}
	
	
	public static void main(String [] args) {
		new LIstenerDesEvenement2();
	}
}
