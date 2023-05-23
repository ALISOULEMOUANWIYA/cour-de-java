package Windows12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JTabbedPanelSimple extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabs = new JTabbedPane();
	private JTree listeTrer = new JTree();
	private JTextArea editore = new JTextArea();
	private JTextArea editorTexte = new JTextArea();
	private JEditorPane helpePane = new JEditorPane();
	private ImageIcon iconsImage =  null;
	private ImageIcon ImageIconne =  null;
	
	
	// les variable de classe icons
		private String urlIcons = "icons/tableau.png";
		private String urlIcons2 = "icons/delete.png";
	
	/*------------------------------------*/
	
		private JSplitPane Spliter = null;
	
	/*------------------------------------*/
	
	
	private JScrollPane scrollEditor = null;
	
	/*********** Construction de l'interface graphics ***********/
	public JTabbedPanelSimple() throws Exception{
		super("JTabbedPanel Sample");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ImageIconne = new ImageIcon(urlIcons);
		iconsImage = new ImageIcon(urlIcons2);
		
		setIconImage(ImageIconne.getImage());
		Image modifier = iconsImage.getImage();
		Image moficationFinale = modifier.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		iconsImage = new ImageIcon(moficationFinale);
		
		
		//************** Recuperation de la compenent ContentPane
			JPanel  contentPane = (JPanel) getContentPane();
		
		//************** On cree le constructeur d'onglets (partie gauche)
			tabs.setPreferredSize(new Dimension(260, 0));
			tabs.setTabPlacement(JTabbedPane.TOP);
			
			// ----------- Premier onglet et son Composant associé -----------------------------------------------------------------
				tabs.addTab("Exploratorer ", iconsImage, new JScrollPane(listeTrer));
			
		    // ---------- Second ongle et son Composant associé --------------------------------------------------------------------
				helpePane.setEditable(false);
				helpePane.setPage("file:///C:/Users/MOUANWIYA%20Ali%20Soule/eclipse-workspace/ConstructionGraphics/web/index.html");
				tabs.addTab("Helpe ", iconsImage, new JScrollPane(helpePane)); 
			
		    // ---------- Troisime onglet et son composant -------------------------------------------------------------------------	
				tabs.addTab("Editeur ",  iconsImage, new JScrollPane(editorTexte));
				
	    //************** On cree le constructeur d'onglets (partie Droit)
			scrollEditor = new JScrollPane(editore);
			
			// --------- On ensemble la partie gauche et la partie droite dans un splitter ------------------------------------------
				Spliter =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabs, scrollEditor);
			
		    // --------- ajoutons le split dans le componant ContentPane ------------------------------------------------------------
				contentPane.add(Spliter, BorderLayout.CENTER);
	}
	
	public static void main(String[] args)throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JTabbedPanelSimple instanceREquit = new JTabbedPanelSimple();
		instanceREquit.setVisible(true);
	}
}
