package Windows2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowListener2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private JButton btnLeft = new JButton("Gauche ");
	
	private JButton btnCenter = new JButton("Centre ");
	
	private JButton btnRight = new JButton("Droid ");
	
	private JPanel pnlMain = null;
	
	public MyWindowListener2() {
		super("les Listener !");
		
		//**********************************************creation de la componant mere*************************************************** 
			pnlMain = (JPanel) this.getContentPane();
			pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			// ça
				//btnLeft.addActionListener((event) -> btnPushListener(event));
			// ou bien ça
				btnLeft.addActionListener(this::btnPushListener);
				
			// ici on ajoute le bouton à gauche de la fenetre
				pnlMain.add(this.btnLeft);			
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			btnCenter.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			pnlMain.add(this.btnCenter);
			
		//------------------------------ajouter des componente dans la component mere--------------------------------------------------
			btnRight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("droite");
				}
			});
			btnRight.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseExited(MouseEvent e) {
					btnRight.setForeground(Color.darkGray);
					btnRight.setText("Droid");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRight.setForeground(Color.BLUE);
					btnRight.setText("changer");;
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			pnlMain.add(this.btnRight);
			
			
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent ev) {
				int clickedButton = JOptionPane.showConfirmDialog(MyWindowListener2.this, "Est-vous sur de vouloir Quitter ?", "Title", JOptionPane.YES_NO_OPTION);
				if(clickedButton == JOptionPane.YES_OPTION) {
					// MyWindowListener2.this.dispose();
					dispose();
				}
			}
		});
		
		
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
	}
	
	
	private void btnPushListener(ActionEvent e) {
		btnLeft.setText("appuille reuçit !");
		btnRight.setForeground(Color.red);
		System.out.println("\n bien bien");
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowListener2 myWindow = new MyWindowListener2();
		myWindow.setVisible(true);
	}

}
