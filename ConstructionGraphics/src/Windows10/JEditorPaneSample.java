package Windows10;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JEditorPaneSample extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel contentPane = new JPanel();
	
	public JEditorPaneSample() throws IOException {
		super("JEditorPane sample");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// --------- On creer le composant d'affichage JEditorPane --------
		  JEditorPane helpePane = new JEditorPane();
		  helpePane.setEditable(false);
		  helpePane.setPage("file:///C:/Users/MOUANWIYA%20Ali%20Soule/eclipse-workspace/ConstructionGraphics/web/index.html");
		  JScrollPane scrollPane = new JScrollPane(helpePane);
		  
	   // -------- On recupere le contantPane et on y ajoute notre compasant -------
		  contentPane = (JPanel) getContentPane();
		  contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void lientCliquer() {
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JEditorPaneSample editorpane = new JEditorPaneSample();
		editorpane.setVisible(true);
	}
}
