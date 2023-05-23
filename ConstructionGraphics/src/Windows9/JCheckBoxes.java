package Windows9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JCheckBoxes extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JLabel lbmassage = new JLabel("Choose Your Color");
	
	JPanel contentPane = new JPanel();
	JPanel pnlPreview = new JPanel();
	JPanel pnlLeft = null;
	
	ButtonGroup buttonGroup = new ButtonGroup();
	JCheckBox chkRed = new JCheckBox("red");
	JCheckBox chkGreen = new JCheckBox("Grenn");
	JCheckBox chkBlue = new JCheckBox("Blue");
	
	JButton btnqutter = new JButton("Quiiter");

	public JCheckBoxes() {
		super("Exemple de l'utulisation de la calsse JRadioButton ");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = (JPanel) getContentPane();
		contentPane.add(lbmassage, BorderLayout.NORTH);
		
		pnlLeft = new JPanel(new GridLayout(3, 1));
		// On cherche a imposer la largeur
		pnlLeft.setPreferredSize(new Dimension(100, 0));
		
		chkRed.setSelected(true);
		pnlLeft.add(chkRed);
		buttonGroup.add(chkRed);
		chkRed.addItemListener(this::checkButton_itemStateChanged);
		
		pnlLeft.add(chkGreen);
		buttonGroup.add(chkGreen);
		chkGreen.addItemListener(this::checkButton_itemStateChanged);
		
		pnlLeft.add(chkBlue);
		buttonGroup.add(chkBlue);
		chkBlue.addItemListener(this::checkButton_itemStateChanged);
		
		contentPane.add(pnlLeft, BorderLayout.WEST);
		
		pnlPreview.setBackground(Color.red);
		contentPane.add(pnlPreview, BorderLayout.CENTER);
		
		btnqutter.addActionListener((e) -> dispose());
		contentPane.add(btnqutter, BorderLayout.SOUTH);
	}
	
	private void checkButton_itemStateChanged(ItemEvent event) {
		int red = chkRed.isSelected() ? 250 : 0;
		int green = chkGreen.isSelected() ? 250 : 0;
		int blue = chkBlue.isSelected() ? 250 : 0;
		this.pnlPreview.setBackground(new Color(red, green, blue));
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JCheckBoxes checkbox = new JCheckBoxes();
		checkbox.setVisible(true);
	}

}
