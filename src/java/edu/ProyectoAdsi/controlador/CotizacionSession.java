package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.ArchivosAdjuntos;
import edu.ProyectoAdsi.entidades.Cotizaciones;
import edu.ProyectoAdsi.facade.ArchivosAdjuntosFacadeLocal;
import edu.ProyectoAdsi.facade.CotizacionesFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Comparator.comparing;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Aesir936
 */


@Named(value = "cotizacionSession")
@SessionScoped
public class CotizacionSession implements Serializable {

    @EJB
    CotizacionesFacadeLocal cotizacionesFacadeLocal;
    @EJB
    ArchivosAdjuntosFacadeLocal archivosAdjuntosFacadeLocal;
    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    @Inject
    SesionUsuario sesionUsuario;

    public CotizacionSession() {
    }

    private String fechaEntrega;
    private String cantPiezas;
    private String descripcion;
    private Part adjunto;
    private Cotizaciones idCot;
    private final String folder = "C:\\Users\\Aesir936\\Documents\\NetBeansProjects\\ProyectoAdsi\\web\\ArchivosCotizacion";
    private String docCliente;
    private int estadoCot;
    private int preciounitario;
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCantPiezas() {
        return cantPiezas;
    }

    public void setCantPiezas(String cantPiezas) {
        this.cantPiezas = cantPiezas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Part getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(Part adjunto) {
        this.adjunto = adjunto;
    }

    public Cotizaciones getIdCot() {
        return idCot;
    }

    public void setIdCot(Cotizaciones idCot) {
        this.idCot = idCot;
    }
    
    public String getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
    }

    public int getEstadoCot() {
        return estadoCot;
    }

    public void setEstadoCot(int estadoCot) {
        this.estadoCot = estadoCot;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }


//    Método para guardar los archivos adjuntos ed las cotizaciones
    public boolean guardarArchivo() {
        try (InputStream input = adjunto.getInputStream()) {
            String fileName = adjunto.getSubmittedFileName();
            Calendar hoy = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName = formatter.format(hoy.getTime()) + fileName;
            Files.copy(input, new File(folder, fileName).toPath());

            ArchivosAdjuntos objAdjunto = new ArchivosAdjuntos();

            objAdjunto.setRuta("archivosCotizacion/" + fileName);
            objAdjunto.setIdCotizacion(idCot);

            archivosAdjuntosFacadeLocal.insertarAdjunto(objAdjunto);

            return true;
        } catch (IOException e) {

        }
        this.adjunto = null;

        return false;
    }
     public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

//    Método para registrar las cotizaciones
    public String registrarCotizacion() {
        try {
            Cotizaciones nuevaCot = new Cotizaciones();
            nuevaCot.setCantidadPiezas(cantPiezas);
            nuevaCot.setDetalle(descripcion);
            Date fecha = ParseFecha(fechaEntrega);
            nuevaCot.setFechaEntrega(fecha);
            nuevaCot.setFkIdCliente(sesionUsuario.getUsuLog());
            boolean insertCoti = cotizacionesFacadeLocal.crearCotizacion(nuevaCot);

            if (insertCoti == true) {
                List<Cotizaciones> listaCoti = cotizacionesFacadeLocal.findAll();
                this.idCot = listaCoti.stream().max(comparing(Cotizaciones::getIdCotizaciones)).get();
                PrimeFaces.current().executeScript("estadoOk('Su solicitud de cotización se ha registrado con exito')");

            } else {
                PrimeFaces.current().executeScript("estadoBad('No se ha podido registrar su solicitud, intentelo nuevamente')");
            }

            this.fechaEntrega = "";
            this.cantPiezas = "";
            this.descripcion = "";
            this.adjunto = null;

        } catch (Exception e) {
            PrimeFaces.current().executeScript("registroFallido('Algo ha salido mal... intentalo nuevamente')");
            return "";
        }
        return null;
    }
    
    
    public List<Cotizaciones> filtrarCotizaciones() {
        int idCliente = usuariosFacadeLocal.consultarId(docCliente);
        return cotizacionesFacadeLocal.filtrarCotizaciones(idCliente,estadoCot);
    }
}
