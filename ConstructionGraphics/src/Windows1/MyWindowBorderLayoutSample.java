package Windows1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowBorderLayoutSample extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public MyWindowBorderLayoutSample() {
		super("My first Swing application !");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// bar de menu
			JToolBar tolbare = new JToolBar();
			tolbare.add( new JButton("Push me ! "));
			tolbare.add( new JButton("click me ! "));
			tolbare.add( new JButton("regarder moi ! "));
		
		contentPane.add(tolbare, BorderLayout.NORTH);
		contentPane.add(new JTree(), BorderLayout.WEST);
		contentPane.add(new JTextArea(), BorderLayout.CENTER);
		contentPane.add(new JTree(), BorderLayout.EAST);
		contentPane.add(new JLabel("ok je suis la"), BorderLayout.SOUTH);
		
		JTextArea textEditeMe = new JTextArea("Edit me !!!!! ");
		contentPane.add(textEditeMe);
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
		MyWindowBorderLayoutSample myWindow = new MyWindowBorderLayoutSample();
		myWindow.setVisible(true);
	}
}
