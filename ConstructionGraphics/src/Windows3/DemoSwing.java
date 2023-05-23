package Windows3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class DemoSwing extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBox = new JComboBox<>(new String [] {"First","Second","Third"});
	private JScrollPane tree = new JScrollPane(new JTree());
	private JScrollPane textArea = new JScrollPane(new JTextArea("Contenet to edit "));
	private JButton button = new JButton("Clique moi ");
	//private JButton button = new JButton("Clique moi ");
	
	private JPanel contentPane;
	
	
	private Component currentInjectedComponent = null;
	
	
	public DemoSwing() {
		super("Demo N°1 : changement contenu");
		
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		contentPane = (JPanel) getContentPane();
		contentPane.add(comboBox, BorderLayout.NORTH);
		
	  // utilisation de reference sur methode pour la gestion des evenement (require un java SE 8)
	    comboBox.addItemListener(this::ComboxBoxItemStateChange);	
	    this.setVisible(true);
	}
	
	
	public void ComboxBoxItemStateChange(ItemEvent ev) {
		// si une de la liste des themes proposer est choisir verifie ouvrire
			if(ev.getStateChange() == ItemEvent.SELECTED) {
				// si il y'a une page en cours d'affichage suprimer le et met celui en cours de choix qui suit
					if(currentInjectedComponent != null) {
						contentPane.remove(currentInjectedComponent);
					}
				// le choix de l'utilisateur
					switch((String) ev.getItem()) {
						case "First":
							currentInjectedComponent = tree;
							contentPane.add(tree, BorderLayout.CENTER);
						break;
						case "Second":
							currentInjectedComponent = textArea;
							contentPane.add(textArea , BorderLayout.CENTER);
						break;
						default:
							currentInjectedComponent = button;
							contentPane.add(button, BorderLayout.CENTER);
						break;
					}
				contentPane.revalidate();
				currentInjectedComponent.repaint();
			}else {
				this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				this.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent ev) {
						int clickedButton = JOptionPane.showConfirmDialog(DemoSwing.this, "Est-vous sur de vouloir Quitter la fenetre ?", "Title", JOptionPane.YES_NO_OPTION);
						if(clickedButton == JOptionPane.YES_OPTION) {
							// MyWindowListener2.this.dispose();
							dispose();
						}
					}
				});
			}
	}
	
	
	
	public static void main(String [] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new DemoSwing();
	}

}
