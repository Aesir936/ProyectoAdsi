package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.facade.EstadosCotizacionesFacadeLocal;
import edu.ProyectoAdsi.facade.EstadosOrdenesDeTrabajoFacadeLocal;
import edu.ProyectoAdsi.facade.RolesFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "graficasRequest")
@RequestScoped
public class GraficasRequest {

    @EJB
    RolesFacadeLocal rolesFacadeLocal;
    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    @EJB
    EstadosCotizacionesFacadeLocal estadosCotizacionesFacadeLocal;
    @EJB
    EstadosOrdenesDeTrabajoFacadeLocal estadosOrdenesDeTrabajoFacadeLocal;

    private String grafRol = "";
    private String grafCliente = "";
    private String grafEstCot = "";
    private String grafEstOT = "";
    private String grafEstadoUsu = "";

//    método constructor
    public GraficasRequest() {
    }

//    Métodos accesores
    public String getGrafRol() {
        return grafRol;
    }

    public void setGrafRol(String grafRol) {
        this.grafRol = grafRol;
    }

    public String getGrafCliente() {
        return grafCliente;
    }

    public void setGrafCliente(String grafCliente) {
        this.grafCliente = grafCliente;
    }

    public String getGrafEstCot() {
        return grafEstCot;
    }

    public void setGrafEstCot(String grafEstCot) {
        this.grafEstCot = grafEstCot;
    }

    public String getGrafEstOT() {
        return grafEstOT;
    }

    public void setGrafEstOT(String grafEstOT) {
        this.grafEstOT = grafEstOT;
    }

    public String getGrafEstadoUsu() {
        return grafEstadoUsu;
    }

    public void setGrafEstadoUsu(String grafEstadoUsu) {
        this.grafEstadoUsu = grafEstadoUsu;
    }

//    Métodos de clase
    public void cargarGraficas() {
        rolesFacadeLocal.findAll().forEach((rol) -> {
            grafRol += "{y:" + rol.getUsuariosHasTblRolesCollection().size() + ",label:'" + rol.getNombreRol() + "'},";
        });

        usuariosFacadeLocal.findAll().forEach((cliente) -> {
            grafCliente += "{y:" + cliente.getOrdenesDeTrabajoCollection().size() + ",label:'" + cliente.getPrimerNombre() + "'},";
        });

        estadosCotizacionesFacadeLocal.findAll().forEach((estadoCot) -> {
            grafEstCot += "{y:" + estadoCot.getCotizacionesCollection().size() + ",name:'" + estadoCot.getNombreEstadoCotizacion() + "'},";
        });

        estadosOrdenesDeTrabajoFacadeLocal.findAll().forEach((estado) -> {
            grafEstOT += "{y:" + estado.getOrdenesDeTrabajoCollection().size() + ",nombre:'" + estado.getNombreEstadoOrdenDeTrabajo() + "'},";
        });
//        
//        usuariosFacadeLocal.findAll().forEach((usuario) -> {
//            grafEstadoUsu += "{y:" + usuario.getOrdenesDeTrabajoCollection().size()+ ",nombre:'" + estado.getNombreEstadoOrdenDeTrabajo() + "'},";
//        });

    }

}
