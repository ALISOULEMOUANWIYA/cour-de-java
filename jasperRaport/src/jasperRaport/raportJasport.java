package jasperRaport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class raportJasport {

	public static void main(String[] args) {
		// database connection
		Connection connection = null;
		 
		String jasperFile = "../report/report1.jasper";
		String pdfFile = "../report/personList.pdf";
		 
		// params used for passing the parameter.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p_id", 30);
		try {
		// get database connection.
		 
		    Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "admin");
		  
		     
		     
		 //   connection = DBConnector.getConnection();
		 
		JasperPrint print = JasperFillManager.fillReport(jasperFile, params,
		connection);
		JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
		pdfFile);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.exportReport();
		System.out.println("Created file:" + pdfFile);
		 
		} catch (JRException e) {
		e.printStackTrace();
		System.exit(1);
		} catch (Exception e) {
		e.printStackTrace();
		System.exit(1);
		}
	}

}
