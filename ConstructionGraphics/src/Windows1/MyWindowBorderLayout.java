package Windows1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowBorderLayout extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public MyWindowBorderLayout() {
		super("My first Swing application !");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		//contentPane.setLayout(new BorderLayout(2, 2, 20, 20));
		
		JButton btnPushMe = new JButton("Push me ! ");
		contentPane.add(btnPushMe, BorderLayout.NORTH);
		
		JButton btnClickMe = new JButton("Click me !!!!! ");
		contentPane.add(btnClickMe, BorderLayout.WEST);
		
		JCheckBox btnCheck = new JCheckBox("Check me ! ");
		contentPane.add(btnCheck, BorderLayout.SOUTH);
		
		JTextArea textEditeMe = new JTextArea("Edit me !!!!! ");
		contentPane.add(textEditeMe);
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowBorderLayout myWindow = new MyWindowBorderLayout();
		myWindow.setVisible(true);
	}
}
