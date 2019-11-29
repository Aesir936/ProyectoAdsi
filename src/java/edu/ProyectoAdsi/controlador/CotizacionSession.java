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
    @Inject
    ReportesRequest reportesRequest;
    @Inject
    registroOTsession oTsession;

    public CotizacionSession() {
    }

    private String fechaEntrega;
    private String cantPiezas;
    private String descripcion;
    private Part adjunto;
    private Cotizaciones idCot;
    private final String folder = "/home/cristian/NetBeansProjects/ProyectoAdsi/web/ArchivosCotizacion";
    private String docCliente;
    private int estadoCot;
    private int precioUnitario;
    private int precioTotal;
    private String comentarios;
    private String comentarioCliente;
    private int horasFabricacion;

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

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getComentarioCliente() {
        return comentarioCliente;
    }

    public void setComentarioCliente(String comentarioCliente) {
        this.comentarioCliente = comentarioCliente;
    }

    public int getHorasFabricacion() {
        return horasFabricacion;
    }

    public void setHorasFabricacion(int horasFabricacion) {
        this.horasFabricacion = horasFabricacion;
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

            objAdjunto.setRuta("ArchivosCotizacion/" + fileName);
            objAdjunto.setIdCotizaciones(idCot);

            archivosAdjuntosFacadeLocal.insertarAdjunto(objAdjunto);

            return true;
        } catch (IOException e) {

        }
        this.adjunto = null;

        return false;
    }

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
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

            List<Cotizaciones> listaCoti = cotizacionesFacadeLocal.findAll();
            this.idCot = listaCoti.stream().max(comparing(Cotizaciones::getIdCotizaciones)).get();

            if (insertCoti == true) {
                if (adjunto != null) {
                    guardarArchivo();
                }

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
        return cotizacionesFacadeLocal.filtrarCotizaciones(idCliente, estadoCot);
    }

    public List<Cotizaciones> listarCotizaciones() {
        int idCliente = sesionUsuario.getUsuLog().getIdUsuarios();
        return cotizacionesFacadeLocal.filtrarCotizaciones(idCliente, estadoCot);

    }

    public String generarCotizacion(int idCotizacion) {

        try {
            Cotizaciones cotGenerada = new Cotizaciones();
            cotGenerada.setValorUnitario(precioUnitario);
            cotGenerada.setValorTotal(precioTotal);
            cotGenerada.setComentarios(comentarios);
            cotGenerada.setIdCotizaciones(idCotizacion);
            cotGenerada.setHorasFabricacion(horasFabricacion);
            boolean updateCoti = cotizacionesFacadeLocal.generarCotizacion(cotGenerada);

            if (updateCoti == true) {
                PrimeFaces.current().executeScript("estadoOk('La cotización se ha generado con exito')");
            } else {
                PrimeFaces.current().executeScript("estadoOk('La cotización no ha sido generada')");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('Algo ha salido mal... intentalo nuevamente')");
            return "";
        }
        return null;
    }

    public void rechazarCot(int idCot) {
        try {
            boolean rCot = cotizacionesFacadeLocal.rechazarCot(idCot, comentarios);
            if (rCot == true) {
                PrimeFaces.current().executeScript("estadoOk('La soliciud se ha rechazado')");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('La soliciud no se pudo procesar')");
        }

    }

//    Método para que un cliente aprueb una cotización generada porla empresa
    public void aprobarCotCliente(int idCot) {

        boolean crearOt = oTsession.registrarOTAutomat(idCot);

        if (crearOt == true) {
            boolean update = cotizacionesFacadeLocal.aprobarCotCliente(idCot);
            if (crearOt == true) {
                PrimeFaces.current().executeScript("estadoOk('Cotización APROBADA')");
            }
        } else {
            PrimeFaces.current().executeScript("estadoBad('No pudo procesarse tu solicitud, intentalo de nuevo o comunicate con nosotros.')");
        }
    }

    public void rechazarCotCliente(int idCot) {
        boolean update = cotizacionesFacadeLocal.rechazarCotCliente(comentarioCliente, idCot);

        if (update == true) {
            PrimeFaces.current().executeScript("estadoOk('Cotización RECHAZADA')");
        } else {
            PrimeFaces.current().executeScript("estadoBad('No pudo procesarse tu solicitud, intentalo de nuevo o comunicate con nosotros.')");
        }
        comentarioCliente = "";
    }

}
