package edu.ProyectoAdsi.controlador;

import static edu.ProyectoAdsi.controlador.CotizacionSession.ParseFecha;
import edu.ProyectoAdsi.entidades.ArchivosAdjuntos;
import edu.ProyectoAdsi.entidades.Cotizaciones;
import edu.ProyectoAdsi.entidades.OrdenesDeTrabajo;
import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.ArchivosAdjuntosFacadeLocal;
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

    public registroOTsession() {
    }

    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    @EJB
    OrdenesDeTrabajoFacadeLocal ordenesDeTrabajoFacadeLocal;
    @EJB
    CotizacionesFacadeLocal cotizacionesFacadeLocal;
    @EJB
    ArchivosAdjuntosFacadeLocal archivosAdjuntosFacadeLocal;

    private String documentoCliente;
    private Date fechaVencimiento;
    private String tiempoFabricacion;
    private String detalle;
    private int estadoOT;
    private int cantidadPiezas;
    private String nvaFechaVencimiento;

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

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    public String getNvaFechaVencimiento() {
        return nvaFechaVencimiento;
    }

    public void setNvaFechaVencimiento(String nvaFechaVencimiento) {
        this.nvaFechaVencimiento = nvaFechaVencimiento;
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
//            int piezas = Integer.parseInt(cantidadPiezas);
            nuevoOT.setCantidadPiezas(cantidadPiezas);
            nuevoOT.setDetalle(detalle);

            boolean insertOT = ordenesDeTrabajoFacadeLocal.insertOT(nuevoOT);

            if (insertOT) {
                PrimeFaces.current().executeScript("estadoOk('Se ha registrado la orden de trabajo')");
                this.documentoCliente = "";
                this.fechaVencimiento = null;
                this.tiempoFabricacion = "";
                this.detalle = "";
                this.estadoOT = 0;
                this.cantidadPiezas = 0;

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
            int idCliente = cot.getFkIdCliente().getIdUsuarios();
            Usuarios cliente = new Usuarios();
            cliente = usuariosFacadeLocal.find(idCliente);

            OrdenesDeTrabajo nuevoOT = new OrdenesDeTrabajo();

            nuevoOT.setFechaEntrega(cot.getFechaEntrega());
            nuevoOT.setTiempoTotalFabricacion(cot.getHorasFabricacion());
            nuevoOT.setDetalle(cot.getDetalle());
            int piezas = Integer.parseInt(cot.getCantidadPiezas());
            nuevoOT.setCantidadPiezas(piezas);
            nuevoOT.setFkIdCliente(cliente);

            boolean insertOT = ordenesDeTrabajoFacadeLocal.insertOT(nuevoOT);

            if (insertOT) {

                ArchivosAdjuntos adjunto;
                int idOt = ordenesDeTrabajoFacadeLocal.idUltimaOT();
                OrdenesDeTrabajo UltOT = ordenesDeTrabajoFacadeLocal.find(idOt);
                List<ArchivosAdjuntos> lstAdjuntos = archivosAdjuntosFacadeLocal.buscarAdjunto(idCot);
                adjunto = (ArchivosAdjuntos) lstAdjuntos.get(0);
                adjunto.setIdOrdenTrabajo(UltOT);
                boolean updateAdj = archivosAdjuntosFacadeLocal.actualizarAdjunto(adjunto);
                if (updateAdj) {
                    PrimeFaces.current().executeScript("estadoOk('Se ha registrado la orden de trabajo')");
                }
                return true;
            } else {
                PrimeFaces.current().executeScript("estadoBad('Orden de trabajo no registrada')");
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void cancelarOT(int idOt) {
        try {
            boolean cOT = ordenesDeTrabajoFacadeLocal.rechazarCot(idOt);
            if (cOT == true) {
                PrimeFaces.current().executeScript("estadoOk('La Orden de Trabajo se ha cancelado')");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('La soliciud no se pudo procesar')");
        }

    }

    public void modificarOT(int idOT) {
        try {
            OrdenesDeTrabajo objOT = new OrdenesDeTrabajo();
            objOT = ordenesDeTrabajoFacadeLocal.find(idOT);
            
            objOT.setCantidadPiezas(cantidadPiezas);
            Date fecha = ParseFecha(nvaFechaVencimiento);
            objOT.setFechaEntrega(fecha);
            int tiempo = Integer.parseInt(tiempoFabricacion);
            objOT.setTiempoTotalFabricacion(tiempo);
            objOT.setDetalle(detalle);
            
            ordenesDeTrabajoFacadeLocal.edit(objOT);
            
            PrimeFaces.current().executeScript("estadoOk('Datos Actualizados ')");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('Orden de trabajo no actualizada')");
        }

    }

}
