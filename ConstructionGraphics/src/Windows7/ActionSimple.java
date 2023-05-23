package Windows7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class ActionSimple extends JFrame{

	private static final long serialVersionUID = 1L;
	
//
	
// les url des images icons
	private String utlIcon1 = "icons/undo.png ";
	private String utlIcon2 = "icons/redo.png";
	private String utlIcon3 = "icons/copy.png";
	private String utlIcon4 = "icons/cut.png";
	private String utlIcon5 = "icons/paste.png";
	
	private String utlIcon6 = "icons/new.png";
	private String utlIcon7 = "icons/open.png";
	private String utlIcon8 = "icons/save.png";
	private String utlIcon9 = "icons/save_as.png";
	private String utlIcon10 = "icons/exit.png";

// les component de la barre de menu et d'outille
	
	
	private JMenu menuFile = new JMenu("File");
	private JMenu menuEdite = new JMenu("Edite");
	private JMenu menuHelpe = new JMenu("Helpe");
	
	private JScrollPane leftScrollPane = null;
	private JScrollPane rightScrollPane =  null;
	private JSplitPane splitPane = null;
	private JTree tree = new JTree();
	private JTextArea textarea = new JTextArea();
	private JToolBar toolbar = new JToolBar();
	private JPopupMenu popupMenu = new JPopupMenu();
	
// menu du clique droit
	@SuppressWarnings("unused")
	private JMenuItem mnuSelection = new JMenuItem( "Selectionner" );
	
// le component d'injection generale
	JPanel contentPane = null;
	
	public ActionSimple() {
		super("Swing Action Sample");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = (JPanel) getContentPane();
		
		// constuction et injection de la barre de menu
			this.setJMenuBar(this.creatmenuBar());
			
		// Construction 
			leftScrollPane = new JScrollPane(tree);
			leftScrollPane.setPreferredSize(new Dimension(200, 0));
			
			rightScrollPane = new JScrollPane(textarea);
			
			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
			
		//construction et injection 
		    
		    contentPane.add(this.creatToolBar(), BorderLayout.NORTH);
		    contentPane.add(splitPane);
		    
		//creation de l'evement de la mousse Gauche
		    JPopupMenu popupMenu = this.CreateMenuPupop();
		    textarea.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mousePressed(MouseEvent event) {
		    		if(event.getButton() == 3) {
		    			popupMenu.show(event.getComponent(), event.getX(), event.getY());
		    		}
		    	}
			});
	}

	/* Methode de construction de la barre de menu */
		private JMenuBar creatmenuBar() {
		// la barre de menu à proprement parler
			JMenuBar menuBar = new JMenuBar();
		
		//definition du menu deroulant "File" et de son contenu
			menuFile.setMnemonic('F');
			
			/* Les Itmes  de 'File' */
				menuFile.add(actNew);
					menuFile.addSeparator();
				menuFile.add(actOpen);
					menuFile.addSeparator(); 
				menuFile.add(actSave);
				menuFile.add(actSaveAs);
					menuFile.addSeparator();
				menuFile.add(actExte);
				
				menuBar.add(menuFile);
			
		//definition du menu deroulant "Edite" et de son contenu
				menuEdite.setMnemonic('E');
				
			/* Les Itmes  de 'File' */
				menuEdite.add(actUndo);
				menuEdite.add(actRedo);
					menuEdite.addSeparator(); 
				menuEdite.add(actCopy);
				menuEdite.add(actCut);
					menuEdite.addSeparator();
				menuEdite.add(actPaste);
					
				menuBar.add(menuEdite);
				
		//definition du menu deroulant "Helpe" et de son contenu
				menuHelpe.setMnemonic('E');
				
				menuBar.add(menuHelpe);
		return menuBar;
	}
	
	/* Methode de construction de la barre d'outils */
		private JToolBar creatToolBar() {
			
			toolbar.add(actNew).setHideActionText(true);
				toolbar.addSeparator();
			toolbar.add(actOpen).setHideActionText(true);
				toolbar.addSeparator();
			toolbar.add(actSave).setHideActionText(true);
			toolbar.add(actSaveAs).setHideActionText(true);
				toolbar.addSeparator();
			toolbar.add(actExte).setHideActionText(true);
			
			return toolbar;
		}

	/* Methode de construction du menu Contextuel*/
	    private JPopupMenu CreateMenuPupop() {
	    	popupMenu.add(actUndo);
	    	popupMenu.add(actRedo);
	    		popupMenu.addSeparator();
	    	popupMenu.add(actCopy);
	    	popupMenu.add(actCut);
	    		popupMenu.addSeparator();
	    	popupMenu.add(actPaste);
	    	
	    	return popupMenu;
	    }
	    
	/* Nos divers action*/
	    private AbstractAction actNew = new  AbstractAction(){

			private static final long serialVersionUID = 1L;
			{	
		    	putValue(Action.NAME, "New File...");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon6));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		    	putValue(Action.SHORT_DESCRIPTION, "New File (CRT+N)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("new");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actOpen = new  AbstractAction(){

	    	{	
		    	putValue(Action.NAME, "Open File...");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon7));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
		    	putValue(Action.SHORT_DESCRIPTION, "Open File (CRT+O)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Open");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actSave = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Save File...");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon8));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_V);
		    	putValue(Action.SHORT_DESCRIPTION, "Save File (CRT+V)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Save");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actSaveAs = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Save As File...");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon9));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
		    	putValue(Action.SHORT_DESCRIPTION, "savve As (CRT+V)");
		    }
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Save As");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actExte = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Exit");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon10));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
		    	putValue(Action.SHORT_DESCRIPTION, "Exit File (CRT+F4)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Exite");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actUndo = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Undo");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon1));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
		    	putValue(Action.SHORT_DESCRIPTION, "Undo File (CRT+U)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Undo");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actRedo = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Redo");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon2));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
		    	putValue(Action.SHORT_DESCRIPTION, "Redo File (CRT+U)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Redo");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actCopy = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Copy");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon3));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		    	putValue(Action.SHORT_DESCRIPTION, "Copy  (CRT+C)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Cut");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actCut = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Cut");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon4));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_T);
		    	putValue(Action.SHORT_DESCRIPTION, "Cut (CRT+X)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Cut");
			}
	    	
	    };
	    
	    @SuppressWarnings("serial")
		private AbstractAction actPaste = new  AbstractAction(){
	    	{	
		    	putValue(Action.NAME, "Paste");
		    	putValue(Action.SMALL_ICON, new ImageIcon(utlIcon5));
		    	putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
		    	putValue(Action.SHORT_DESCRIPTION, "Paste (CRT+V)");
		    	putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.ALT_DOWN_MASK));
	    	}
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
				System.out.println("Paste");
			}
	    	
	    };
	    
	    public static void main(String [] args)throws Exception{
	    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
	    	ActionSimple action = new ActionSimple();
	    	action.setVisible(true);
	    }
	
}
