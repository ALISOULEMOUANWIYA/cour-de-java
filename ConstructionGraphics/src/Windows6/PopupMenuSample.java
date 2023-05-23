package Windows6;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class PopupMenuSample extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	// les url des images icons
		private String utlIcon1 = "icons/undo.png ";
		private String utlIcon2 = "icons/redo.png";
		private String utlIcon3 = "icons/copy.png";
		private String utlIcon4 = "icons/cut.png";
		private String utlIcon5 = "icons/paste.png";
	
	// les component
		private JPopupMenu popupMenu = new JPopupMenu();
		private JMenuItem mnuUndo = new JMenuItem( "Undo" );
		private JMenuItem mnuRedo = new JMenuItem( "Redo" );
		private JMenuItem mnuCopy = new JMenuItem( "Copy" );
		private JMenuItem mnuCut = new JMenuItem( "Cut" );
		private JMenuItem mnuPaste = new JMenuItem( "Paste" );
		private JMenuItem mnuSelection = new JMenuItem( "Selectionner" );
	
	public PopupMenuSample() {
		super( "JPopupMenu sample" );
        this.setSize(600,400);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        JPanel contentPane = (JPanel) getContentPane();
        
        // The content of the window
        JScrollPane leftScrollPane = new JScrollPane( new JTree() );
        leftScrollPane.setPreferredSize( new Dimension( 200, 0 ) );
        
        JTextArea textArea = new JTextArea();
        JScrollPane rightScrollPane = new JScrollPane( textArea );
        
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane );
        contentPane.add( splitPane /*, BorderLayout.CENTER */ );        

        // Association d'un popup menu sur la zone d'édition de texte
        
     // Attention avant Java SE 8.0, il faut un final au début de la déclaration !!!
       final JPopupMenu popupMenu = this.createPopupMenu();      
        textArea.addMouseListener( new MouseAdapter() {
            @Override public void mousePressed( MouseEvent event ) {
                if ( event.getButton() == 3) {
                    System.out.println( "Show popup" );
                    popupMenu.show( event.getComponent(), event.getX(), event.getY() );
                }
            }
        } );
	}
	private JPopupMenu createPopupMenu() {
		
	    
	    
	    mnuUndo.setIcon( new ImageIcon(utlIcon1) );
	    mnuUndo.setMnemonic( 'U' );
	    mnuUndo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK) );
	    mnuUndo.addActionListener( this::mnuUndoListener );
	    popupMenu.add(mnuUndo);
	    
	    mnuRedo.setIcon( new ImageIcon(utlIcon2) );
	    mnuRedo.setMnemonic( 'R' );
	    mnuRedo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK) );
	    popupMenu.add(mnuRedo);
	    
	    popupMenu.addSeparator();
	    
	    
	    mnuCopy.setIcon( new ImageIcon(utlIcon3) );
	    mnuCopy.setMnemonic( 'C' );
	    mnuCopy.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK) );
	    popupMenu.add(mnuCopy);
	    
	    
	    mnuCut.setIcon( new ImageIcon(utlIcon4) );
	    mnuCut.setMnemonic( 't' );
	    mnuCut.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK) );
	    popupMenu.add(mnuCut);
	    
	    
	    mnuPaste.setIcon( new ImageIcon(utlIcon5) );
	    mnuPaste.setMnemonic( 'P' );
	    mnuPaste.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK) );
	    popupMenu.add(mnuPaste);
	    
	    
	    mnuSelection.setMnemonic( 'S' );
	    mnuSelection.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK) );
	    popupMenu.add(mnuSelection);


    return popupMenu;
}

public void mnuUndoListener( ActionEvent event ) {
    JOptionPane.showMessageDialog( this, "Undo!" );
}

public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel( new NimbusLookAndFeel() );
    PopupMenuSample frame = new PopupMenuSample();
    frame.setVisible(true);
}
}
