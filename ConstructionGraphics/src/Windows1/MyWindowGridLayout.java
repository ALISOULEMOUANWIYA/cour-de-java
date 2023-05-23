package Windows1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowGridLayout extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public MyWindowGridLayout() {
		super("My first Swing application !");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new GridLayout(2, 2, 20, 20));
		
		JButton btnPushMe = new JButton("Push me ! ");
		contentPane.add(btnPushMe);
		
		JButton btnClickMe = new JButton("Click me !!!!! ");
		contentPane.add(btnClickMe);
		
		JButton btnCheck = new JButton("Check me ! ");
		contentPane.add(btnCheck);
		
		JTextField textEditeMe = new JTextField("Edit me !!!!! ");
		contentPane.add(textEditeMe);
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowGridLayout myWindow = new MyWindowGridLayout();
		myWindow.setVisible(true);
	}
}
