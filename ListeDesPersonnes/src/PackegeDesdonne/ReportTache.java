package PackegeDesdonne;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class ReportTache {

	private static JasperReport jreport;
	private static JasperViewer jviewer;
	private static JasperPrint jprint;
	
	public static void createReport(Connection connect, Map<String, Object> map, InputStream by){
		try {
			//JasperReport jr = JasperCompileManager.compileReport(by);
			jreport = (JasperReport)JRLoader.loadObject(by);
			jprint = JasperFillManager.fillReport(jreport, map, connect);
			
		}catch(JRException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showReport() {
		jviewer = new JasperViewer(jprint, false); // false to avoid closing the main application and will only close the print preview
		jviewer.setVisible(true);
	}
	
	
}
