package Windows2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowListener extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private JButton btnLeft = new JButton("Gauche ");
	
	private JButton btnCenter = new JButton("Centre ");
	
	private JButton btnRight = new JButton("Droid ");
	
	private JPanel pnlMain = null;
	
	public MyWindowListener() {
		super("My first Swing application !");
		
		//**********************************************creation de la componant mere*************************************************** 
			pnlMain = (JPanel) this.getContentPane();
			pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------

			// methode 1
				/*btnLeft.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnPushListener(e);
					}
				});*/
			
			// oubien
				btnLeft.addActionListener((event) -> btnPushListener(event));
			
			// ici on ajoute le bouton à gauche de la fenetre
				pnlMain.add(this.btnLeft);			
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			btnCenter.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			pnlMain.add(this.btnCenter);
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			btnRight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			pnlMain.add(this.btnRight);
			
			
			
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
	}
	
	
	private void btnPushListener(ActionEvent e) {
		btnLeft.setText("appuille reuçit !");
		System.out.println("\n bien");
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowListener myWindow = new MyWindowListener();
		myWindow.setVisible(true);
	}

}
