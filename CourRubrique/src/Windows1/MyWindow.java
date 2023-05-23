package Windows1;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public MyWindow() {
		super("My first Swing application !");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
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
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);
	}
}
