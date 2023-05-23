package Windows4;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MenuBArreSimple extends JFrame{


		private static final long serialVersionUID = 1L;
	
	
		/*------Constructeur de l'interface graphique-------*/
		public MenuBArreSimple() {
			super("JMenuBar simple");
			this.setSize(600, 400);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
			
			// construction et injection de la barre de menu
			   this.setJMenuBar(this.createMenuBar());
		}
		
		
		/*------- La methode de construction de la barre de menu------*/
		public JMenuBar createMenuBar() {
			// La barre de menu à proprement parler
			  JMenuBar menuBar = new JMenuBar();
			  
		   //*******************Definition du menu deroulant 'File' et ces contenu
			  JMenu menuFile = new JMenu("File");
			  
			  //mettre un tirre indicatiffe du nom au premier letre du nom 
			  	menuFile.setMnemonic('F');
		   
		  // creation de la liste de l'Item 'File'
			 JMenuItem menuNewFile = new JMenuItem("New File...");// definition du nom de Item 'File'
			 
			 menuNewFile.setIcon(new ImageIcon("icons/new.png"));
			 menuNewFile.setMnemonic('N');
			 menuNewFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.ALT_DOWN_MASK));
			 menuFile.addActionListener(this::menuNewListenere);
			 menuFile.add(menuNewFile);
			 
			 menuFile.addSeparator();// ajouter un separatore
			 
			 JMenuItem menuOpenFile = new JMenuItem("Open File...");
			 menuOpenFile.setIcon(new ImageIcon("icons/open.png"));
			 menuOpenFile.setMnemonic('O');
			 menuOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.ALT_DOWN_MASK));
			 menuFile.addActionListener(this::menuOpenListenere);
			 menuFile.add(menuOpenFile);
			 
			 menuFile.addSeparator();// ajouter un separatore
			 
			 JMenuItem menuSaveFile = new JMenuItem("Save File");
			 menuSaveFile.setIcon(new ImageIcon("icons/save.png"));
			 menuSaveFile.setMnemonic('S');
			 menuSaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.ALT_DOWN_MASK));
			 menuFile.add(menuSaveFile);
			 
			 JMenuItem menuSaveAsFile = new JMenuItem("Save As...");
			 menuSaveAsFile.setIcon(new ImageIcon("icons/save_as.png"));
			 menuSaveAsFile.setMnemonic('a');
			 menuFile.add(menuSaveAsFile);
			 
			 menuFile.addSeparator();// ajouter un separatore
			 
			 JMenuItem menuExit = new JMenuItem("Exite");
			 menuExit.setIcon(new ImageIcon("icons/exit.png"));
			 menuExit.setMnemonic('X');
			 menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_DOWN_MASK));
			 menuFile.add(menuExit);
			 
			 menuBar.add(menuFile);
			 
		//*******************Definition du menu deroulant 'Edite' et ces contenu
			  JMenu menuEdite = new JMenu("Edite");
			  
			  //mettre un tirre indicatiffe du nom au premier letre du nom 
			  menuEdite.setMnemonic('E');
		   
		  // creation de la liste de l'Item 'Edite'
			 JMenuItem menuUndoEdite = new JMenuItem("Undo");// definition du nom de Item 'Edite'
			 menuUndoEdite.setIcon(new ImageIcon("icons/undo.png"));
			 menuUndoEdite.setMnemonic('N');
			 menuUndoEdite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.ALT_DOWN_MASK));
			 menuEdite.addActionListener(this::menuNewListenere);
			 menuEdite.add(menuUndoEdite);
			 
			 JMenuItem menuRedoEdite = new JMenuItem("Redo");
			 menuRedoEdite.setIcon(new ImageIcon("icons/redo.png"));
			 menuRedoEdite.setMnemonic('R');
			 menuRedoEdite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.ALT_DOWN_MASK));
			 menuEdite.add(menuRedoEdite);
			 
			 menuEdite.addSeparator();// ajouter un separatore
			 
			 JMenuItem menuEditeCopy = new JMenuItem("Copy");
			 menuEditeCopy.setIcon(new ImageIcon("icons/copy.png"));
			 menuEditeCopy.setMnemonic('C');
			 menuEditeCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.ALT_DOWN_MASK));
			 menuEdite.add(menuEditeCopy);
			 
			 JMenuItem menuEditcut = new JMenuItem("Cut");
			 menuEditcut.setIcon(new ImageIcon("icons/cut.png"));
			 menuEditcut.setMnemonic('t');
			 menuEditcut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.ALT_DOWN_MASK));
			 menuEdite.add(menuEditcut);
			 
			 JMenuItem menuPast = new JMenuItem("Paste ");
			 menuPast.setIcon(new ImageIcon("icons/paste.png"));
			 menuPast.setMnemonic('P');
			 menuPast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.ALT_DOWN_MASK));
			 menuEdite.add(menuPast);
			 
			 menuBar.add(menuEdite);
			 
	 //*******************Definition du menu deroulant 'Edite' et ces contenu
			  JMenu menuHelp = new JMenu("Help");
			  
			  //mettre un tirre indicatiffe du nom au premier letre du nom 
			  menuHelp.setMnemonic('H');
			  menuBar.add(menuHelp);
			 
			  return menuBar;
		}
		
		public void menuOpenListenere(ActionEvent ev) {
			JOptionPane.showInternalConfirmDialog(MenuBArreSimple.this, "pour le moment etandez l'execution du programme ");
		}
		
		public void menuNewListenere(ActionEvent ev) {
			JOptionPane.showInternalConfirmDialog(MenuBArreSimple.this, "pour le moment etandez l'execution du programme ");
		}
		
		public static void main(String [] args) throws Exception{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			MenuBArreSimple menu = new MenuBArreSimple();
			menu.setVisible(true);
		}
		
		
}
