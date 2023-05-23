package Windows5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ToolBarSimple extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btnNew = new JButton(new ImageIcon("icons/new.png"));
	private JButton btnOpenFile = new JButton(new ImageIcon("icons/open.png"));
	private JButton btnSaveFile = new JButton(new ImageIcon("icons/save.png"));
	private JButton btnSaveAsFile = new JButton(new ImageIcon("icons/save_as.png"));
	private JButton btnUndoEdite = new JButton(new ImageIcon("icons/undo.png"));
	private JButton btnReedoEdite = new JButton(new ImageIcon("icons/redo.png"));
	private JButton btnCutEdite = new JButton(new ImageIcon("icons/cut.png"));
	private JButton btnPasteEdite = new JButton(new ImageIcon("icons/past.png"));
	private JButton btnExite = new JButton(new ImageIcon("icons/exit.png"));
	
	private JPanel panel = null;
	private JTable tableau = null;
	
	private JCheckBox mousser = new JCheckBox("couleur", false);
	
	
	private JPanel contentPane = null;
	
	/*----------------- Le constructeur d'interface graphics */
	  public ToolBarSimple() {
		  super("JToolBar Simple");
		  this.setSize(600, 400);
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  
		  
		  // construre et injection de la barre d'outils
		     contentPane = (JPanel) getContentPane();
		     contentPane.setBackground(Color.white);
		     contentPane.add(this.creatToolBar(), BorderLayout.NORTH);
	  }

	  
	  /*-------------- Mthode de construction de la barre d'outils */
	  public JToolBar creatToolBar() {
		 // la barre d'outile à proprement parler
		   JToolBar tolbar = new JToolBar(); 
		   
		   
		   btnNew.setToolTipText("New File (CTRL+N)");
		   btnNew.addActionListener(this::btnNewListener);
		   tolbar.add(btnNew);
		   
		   tolbar.addSeparator();
		   
		   btnOpenFile.setToolTipText("Open File (CTRL+O)");
		   tolbar.add(btnOpenFile);
		   
		   tolbar.addSeparator();
		   
		   btnSaveFile.setToolTipText("Save File (CTRL+S)");
		   tolbar.add(btnSaveFile);
		   
		   btnSaveAsFile.setToolTipText("Save as File (CTRL+a)");
		   tolbar.add(btnSaveAsFile);
		   
		   tolbar.addSeparator();
		   
		   btnUndoEdite.setToolTipText("Undo Edite (CTRL+U)");
		   tolbar.add(btnUndoEdite);
		   
		   btnReedoEdite.setToolTipText("Redo Edite (CTRL+U)");
		   tolbar.add(btnReedoEdite);
		   
		   tolbar.addSeparator();
		   
		   btnCutEdite.setToolTipText("Cut (CTRL+X)");
		   tolbar.add(btnCutEdite);
		   
		   btnPasteEdite.setToolTipText("Cut (CTRL+V)");
		   tolbar.add(btnPasteEdite);
		   
		   tolbar.addSeparator();
		   
		   tolbar.add(new JButton(new ImageIcon("icons/about.png")));
		   
		   tolbar.addSeparator();
		   //-------------------------------------------------------------------
		       this.mousser.addActionListener(this::btncheCouleurListener);
		       mousser.setToolTipText("change la couleur de fond");
			   tolbar.add(mousser);
		   //-------------------------------------------------------------------
		   tolbar.addSeparator();	   
			   
		   tolbar.add(new JTextField("editez moi"));
		   
		   tolbar.addSeparator();
		   
		   
		   btnExite.setToolTipText("Exit (CTRL+E)");
		   tolbar.add(btnExite);
		   
		   
		   
		   return tolbar;
	  }
	  private void btnNewListener(ActionEvent event) {
		  JOptionPane.showMessageDialog(this, "button cliquer");
	  }
	  private void btncheCouleurListener(ActionEvent event) {
		  if(mousser.getSelectedObjects() != null) {
			 contentPane.setBackground(Color.darkGray );
			 mousser.setForeground(Color.white);
		  }else {
			  contentPane.setBackground(Color.white);
			  mousser.setForeground(Color.black);
		  }
	  }
	
	
	public static void main(String [] args)throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		ToolBarSimple menuToolBar = new ToolBarSimple();
		menuToolBar.setVisible(true);
	}
	
	public JPanel getJPanel() {
		return contentPane;
	}
}
