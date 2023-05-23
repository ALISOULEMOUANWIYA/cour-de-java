package Windows1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


@SuppressWarnings("deprecation")
public class Layout1 extends Applet{

	private static final long serialVersionUID = 1L;
	
	Image straImage = null;
	Frame f = null;
	
	
	public Layout1() {
		init();
	}
	
	public void init() {
		try {
			MediaTracker mt = new MediaTracker(this);
			straImage = this.getImage(this.getCodeBase(), "");
			mt.addImage(straImage, 0);
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("ok1");
					//showWindow();
				}
			});
			
			mt.waitForAll();
		}catch(Exception ex) {
			
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(straImage, 0, 0, null);
	}
	
	public void showWindow() {
		f = new Frame("Ma fenetre");
		f.setLayout(new BorderLayout());
		
		Panel panel1 = new Panel();
		panel1.setLayout(new FlowLayout());
		
		for(int i = 0; i < 5; i++) {
			panel1.add(new Button("Button H"+i));
		}
		
		Panel panel2 = new Panel();
		panel2.setLayout(new FlowLayout());
		
		for(int i = 0; i < 5; i++) {
			panel2.add(new Button("Button V"+i));
		}
		
		f.add(panel1, BorderLayout.NORTH);
		f.add(panel2, BorderLayout.EAST);
		f.add(new Button("Un boutton "), BorderLayout.CENTER);
		
		f.pack();
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				f.setVisible(false);
			}
		});
		System.out.println("appliquer");
	}
	
	public static void main(String [] args) throws Exception{
		// appliquer une vue 
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// star la fenetre
			Layout1 myWindow = new Layout1();
			myWindow.setVisible(true);
	}
}
