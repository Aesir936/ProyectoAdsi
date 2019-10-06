
package edu.ProyectoAdsi.controlador;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author joseluissartaalvarez
 */
@Named(value = "reportesRequest")
@RequestScoped
public class ReportesRequest {

    
    public ReportesRequest() {
    }
    
    private String documento;
    
     public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
    public  void  imprimirPdf() throws ClassNotFoundException, SQLException{
    
    try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/Cotizaciones.jasper"));
             Map<String, Object> params = new HashMap<>();
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_siim", "root", "123456");
               JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Reporte General de Cotizaciones.pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
   
    
    }
    
    public  void  imprimirParametro() throws ClassNotFoundException, SQLException{
    
    try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/ReporteOT.jasper"));
             Map<String, Object> params = new HashMap<>();
            params.put("documento", documento);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_siim", "root", "123456");
               JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Reporte individual de ordenes de trabajo "+documento+".pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }      
}
