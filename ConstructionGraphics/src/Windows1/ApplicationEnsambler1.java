package Windows1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ApplicationEnsambler1 extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public ApplicationEnsambler1() {
		super("My first Swing application !");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		//contentPane.setLayout(new BorderLayout(2, 2, 20, 20));
		
		
		// ajouter une barre de menu au nord de la page
		   contentPane.add( createToolBar(), BorderLayout.NORTH);
			
		// ajouter un Liste à l'EST (Gauche) de la page
			JScrollPane westComponent = new JScrollPane(new JTree());
			westComponent.setPreferredSize(new Dimension(150, 0));
			contentPane.add(westComponent, BorderLayout.WEST);
			
		// le la zonne de texte sera placer par defaut par rapport au anplacement des autres composant au centre 
			JTextArea textEditeMe = new JTextArea("the text editore ");
			JScrollPane scrContent = new JScrollPane(textEditeMe);
			contentPane.add(scrContent);
			
		// ajouter un grid layout à Droit (OUEST)
			contentPane.add( GriderRigthPanel(), BorderLayout.EAST);
		
		
			
		//ajouter une barre de satut au Sud de la page
			contentPane.add(Barstatut(), BorderLayout.SOUTH);
	}
	
	// barre de statut au Sud de la page
	   private JPanel Barstatut() {
		   JPanel statutBAr = new JPanel(new FlowLayout());
		   
		   JLabel Inform = new JLabel("Message1 ");
		   Inform.setPreferredSize(new Dimension(100, 30));
		   statutBAr.add(Inform);
			
		   JLabel Inform1 = new JLabel("Message2 ");
		   Inform1.setPreferredSize(new Dimension(100, 30));
		   statutBAr.add(Inform1);
		   
		   JLabel Inform2 = new JLabel("Message3 ");
		   Inform2.setPreferredSize(new Dimension(100, 30));
		   statutBAr.add(Inform2);
		   
		   JLabel Inform3 = new JLabel("Message4");
		   Inform3.setPreferredSize(new Dimension(100, 30));
		   statutBAr.add(Inform3);
		   
			return statutBAr;
	   }
	   
	   
	// barre de statut au Sud de la page
	   private JPanel GriderRigthPanel() {
		   JPanel statutBAr = new JPanel(new GridLayout(4, 1));
		   
		   statutBAr.add(new JButton("Bouton1"));
			
		   statutBAr.add(new JButton("Bouton2"));
		   
		   statutBAr.add(new JButton("Bouton3"));
		   
		   statutBAr.add(new JButton("Bouton4"));
		   
			return statutBAr;
	   }
	
	// menu barre au nord de la page
		private JToolBar createToolBar() {
			JToolBar tolbar = new JToolBar();
			
			
			JLabel Inform = new JLabel("Fait votre choix ");
			tolbar.add(Inform);
			
			JCheckBox btnCheck = new JCheckBox();
			tolbar.add(btnCheck);
			
			JCheckBox btnCheck1 = new JCheckBox();
			tolbar.add(btnCheck1);
			
			JCheckBox btnCheck2 = new JCheckBox();
			tolbar.add(btnCheck2);
			
			JCheckBox btnCheck3 = new JCheckBox();
			tolbar.add(btnCheck3);
			
			JTextField textEditeMe = new JTextField("Edit me !!!!! ");
			tolbar.add(textEditeMe);
			
			return tolbar;
			
		}
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		ApplicationEnsambler1 myWindow = new ApplicationEnsambler1();
		myWindow.setVisible(true);
	}
}
