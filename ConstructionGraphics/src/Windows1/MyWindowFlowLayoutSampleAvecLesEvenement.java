package Windows1;

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

public class MyWindowFlowLayoutSampleAvecLesEvenement extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	
	
	
	private JButton btnLeft = new JButton("Gauche ");
	
	private JButton btnCenter = new JButton("Centre ");
	
	private JButton btnRight = new JButton("Droid ");
	
	private JPanel pnlMain = null;
	
	public MyWindowFlowLayoutSampleAvecLesEvenement() {
		super("My first Swing application !");
		
		// definition le mode de fermeture de la page
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//**********************************************creation de la componant mere*************************************************** 
			pnlMain = (JPanel) this.getContentPane();
			pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER));


		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			this.btnLeft.addActionListener(this);
			pnlMain.add(this.btnLeft);			
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			this.btnCenter.addActionListener(this);
			pnlMain.add(this.btnCenter);
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			this.btnRight.addActionListener(this);
			pnlMain.add(this.btnRight);
			
		
		/*************************************************definition de la taille de la fenetre******************************************/
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnLeft) {
			this.pnlMain.setLayout(new FlowLayout(FlowLayout.LEFT));
		}else if(event.getSource() == btnRight) {
			this.pnlMain.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}else if(event.getSource() == btnCenter) {
			this.pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER));
		}
		
		this.pnlMain.revalidate();
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowFlowLayoutSampleAvecLesEvenement myWindow = new MyWindowFlowLayoutSampleAvecLesEvenement();
		myWindow.setVisible(true);
	}

	
}
