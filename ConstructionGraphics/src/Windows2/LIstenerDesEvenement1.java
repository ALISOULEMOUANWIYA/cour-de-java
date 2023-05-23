package Windows2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LIstenerDesEvenement1 implements ActionListener
{
	
	public LIstenerDesEvenement1() {
		Frame fr = new Frame("Ma fenetre");
		Button btn = new Button("Clique moi ");
		
		fr.add(btn);// ajouter le bouton dans la fenetre
		fr.pack();
		fr.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Button "+ev.getSource()+"Cliquer");
	}
	
	
	public static void main(String [] args) {
		new LIstenerDesEvenement1();
	}
}
