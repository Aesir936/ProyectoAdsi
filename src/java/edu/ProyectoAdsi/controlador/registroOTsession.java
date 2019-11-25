package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Cotizaciones;
import edu.ProyectoAdsi.entidades.OrdenesDeTrabajo;
import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.CotizacionesFacadeLocal;
import edu.ProyectoAdsi.facade.OrdenesDeTrabajoFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author bxs42
 */
@Named(value = "registroOTsession")
@SessionScoped
public class registroOTsession implements Serializable {

    /**
     * Creates a new instance of pruebasession
     */
    public registroOTsession() {
    }

    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    @EJB
    OrdenesDeTrabajoFacadeLocal ordenesDeTrabajoFacadeLocal;
    @EJB
    CotizacionesFacadeLocal cotizacionesFacadeLocal;

    private String documentoCliente;
    private Date fechaVencimiento;
    private String tiempoFabricacion;
    private String detalle;
    private int estadoOT;

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    public void setTiempoFabricacion(String tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstadoOT() {
        return estadoOT;
    }

    public void setEstadoOT(int estadoOT) {
        this.estadoOT = estadoOT;
    }

    public boolean registrarOT() {
        try {
            int idCliente = usuariosFacadeLocal.consultarId(documentoCliente);

            Usuarios usu = new Usuarios();
            usu = usuariosFacadeLocal.find(idCliente);

            OrdenesDeTrabajo nuevoOT = new OrdenesDeTrabajo();
            nuevoOT.setFechaEntrega(fechaVencimiento);
            nuevoOT.setFkIdCliente(usu);
            int tiempo = Integer.parseInt(tiempoFabricacion);
            nuevoOT.setTiempoTotalFabricacion(tiempo);
            nuevoOT.setDetalle(detalle);

            boolean insertOT = ordenesDeTrabajoFacadeLocal.insertOT(nuevoOT);

            if (insertOT) {

                PrimeFaces.current().executeScript("estadoOk('Se ha registrado la orden de trabajo')");
                return true;
            } else {
                PrimeFaces.current().executeScript("estadoBad('Orden de trabajo no registrada')");
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<OrdenesDeTrabajo> filtrarOT() {
        int idCliente = usuariosFacadeLocal.consultarId(documentoCliente);
        return ordenesDeTrabajoFacadeLocal.filtrarOT(idCliente, estadoOT);
    }

    
    public boolean registrarOTAutomat(int idCot) {
        try {
            Cotizaciones cot = cotizacionesFacadeLocal.find(idCot);
            Usuarios cliente=usuariosFacadeLocal.find(cot.getFkIdCliente());
            OrdenesDeTrabajo nuevoOT = new OrdenesDeTrabajo();
            nuevoOT.setFechaEntrega(cot.getFechaEntrega());
            nuevoOT.setDetalle(cot.getDetalle());
            nuevoOT.setCantidadPiezas(cot.getCantidadPiezas());
            nuevoOT.setFkIdCliente(cliente);
            int tiempo = Integer.parseInt(tiempoFabricacion);
            nuevoOT.setTiempoTotalFabricacion(tiempo);
            nuevoOT.setDetalle(detalle);

            boolean insertOT = ordenesDeTrabajoFacadeLocal.insertOT(nuevoOT);

            if (insertOT) {

                PrimeFaces.current().executeScript("estadoOk('Se ha registrado la orden de trabajo')");
                return true;
            } else {
                PrimeFaces.current().executeScript("estadoBad('Orden de trabajo no registrada')");
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
