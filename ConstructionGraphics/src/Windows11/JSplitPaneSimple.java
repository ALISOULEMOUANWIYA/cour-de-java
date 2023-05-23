package Windows11;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JSplitPaneSimple extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTree projectExplorateurTree = new JTree();
	private JTree outilineTree = new JTree();
	private JTextArea TextArea = new JTextArea();
	private JTable propertyPane = new JTable();
	
	private JScrollPane projectScrolPane = null;
	private JScrollPane EditoreScrolPane = null;
	private JScrollPane propertyScrolPane = null;
	private JScrollPane outilineScrolPane = null;
	
	private JSplitPane documentSplitPane = null;
	private JSplitPane RigthtSplitPane = null;
	private JSplitPane mainSplitPane = null;
	

	public JSplitPaneSimple() {
		super("JSplitPane ");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//------- On recuper la contantPane ------------------------------
			JPanel contentPane = (JPanel) getContentPane();
		
		//------ L'explorateur de projet et seq Scrllbar -----------------
			projectScrolPane = new JScrollPane(projectExplorateurTree);
			projectScrolPane.setPreferredSize(new Dimension(200, 0));
			
	    // ----- L'editeur principal et ses Scrollbare -------------------
			EditoreScrolPane = new JScrollPane(TextArea);
			
	    // ------ Le panneau de propeau et ses Scrollbar -----------------
			propertyScrolPane = new JScrollPane(propertyPane);
			
	    // ------ La vue outline et ses scrollBar ------------------------
			outilineScrolPane = new JScrollPane(outilineTree);
			
	    // ------ maintenant on assamble le tout avec de JSplitPane -------
			documentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, EditoreScrolPane, outilineScrolPane);
				documentSplitPane.setResizeWeight(0.8);
				
			RigthtSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, documentSplitPane, propertyScrolPane);
				RigthtSplitPane.setResizeWeight(0.8);
				
			mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, projectScrolPane, RigthtSplitPane);
			
			
		// ------ injection des componante -------------------------------
			contentPane.add(mainSplitPane/*, BorderLayout.CENTER*/);
			
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JSplitPaneSimple instancePermit = new JSplitPaneSimple();
		instancePermit.setVisible(true);
	}

}
