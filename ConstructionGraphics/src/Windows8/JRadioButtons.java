package Windows8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JRadioButtons extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JLabel lbmassage = new JLabel("Choose Your Color");
	
	JPanel contentPane = new JPanel();
	JPanel pnlPreview = new JPanel();
	JPanel pnlLeft = null;
	
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdoRed = new JRadioButton("red");
	JRadioButton rdoGreen = new JRadioButton("Grenn");
	JRadioButton rdoBlue = new JRadioButton("Blue");
	
	JButton btnqutter = new JButton("Quiiter");

	public JRadioButtons() {
		super("Exemple de l'utulisation de la calsse JRadioButton ");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = (JPanel) getContentPane();
		contentPane.add(lbmassage, BorderLayout.NORTH);
		
		pnlLeft = new JPanel(new GridLayout(3, 1));
		// On cherche a imposer la largeur
		pnlLeft.setPreferredSize(new Dimension(100, 0));
		
		rdoRed.setSelected(true);
		pnlLeft.add(rdoRed);
		buttonGroup.add(rdoRed);
		rdoRed.addItemListener(this::radioButton_itemStateChanged);
		
		pnlLeft.add(rdoGreen);
		buttonGroup.add(rdoGreen);
		rdoGreen.addItemListener(this::radioButton_itemStateChanged);
		
		pnlLeft.add(rdoBlue);
		buttonGroup.add(rdoBlue);
		rdoBlue.addItemListener(this::radioButton_itemStateChanged);
		
		contentPane.add(pnlLeft, BorderLayout.WEST);
		
		pnlPreview.setBackground(Color.red);
		contentPane.add(pnlPreview, BorderLayout.CENTER);
		
		btnqutter.addActionListener((e) -> dispose());
		contentPane.add(btnqutter, BorderLayout.SOUTH);
	}
	
	private void radioButton_itemStateChanged(ItemEvent event) {
		Object source = event.getSource();
		if(source == rdoRed) {
			pnlPreview.setBackground(Color.red);
		}else if(source == rdoGreen) {
			pnlPreview.setBackground(Color.green);
		}else {
			if(source == rdoBlue) {
				pnlPreview.setBackground(Color.blue);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JRadioButtons radioBouton = new JRadioButtons();
		radioBouton.setVisible(true);
	}

}
