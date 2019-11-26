package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.BolsasDeTiempo;
import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.BolsasDeTiempoFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import groovyjarjarasm.asm.tree.TryCatchBlockNode;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author bxs42
 */
@Named(value = "compraBolsasession")
@SessionScoped
public class Bolsasession implements Serializable {

    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    @EJB
    BolsasDeTiempoFacadeLocal bolsasDeTiempoFacadeLocal;
    @Inject
    SesionUsuario sesionUsuario;

    public Bolsasession() {
    }

    private int cantHoras;
    private List<BolsasDeTiempo> bolsas;
    private int recarga;

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public List<BolsasDeTiempo> getBolsas() {
        return bolsas;
    }

    public void setBolsas(List<BolsasDeTiempo> bolsas) {
        this.bolsas = bolsas;
    }
     public int getRecarga() {
        return recarga;
    }

    public void setRecarga(int recarga) {
        this.recarga = recarga;
    }
    

    public String registrarBolsa() {
        try {

            boolean insertBolsa = bolsasDeTiempoFacadeLocal.generarBolsa(cantHoras);

            if (insertBolsa == true) {
                PrimeFaces.current().executeScript("estadoOk('Su solicitud de cotización se ha registrado con exito')");

            } else {
                PrimeFaces.current().executeScript("estadoBad('No se ha podido registrar su solicitud, intentelo nuevamente')");
            }

        } catch (Exception e) {
            PrimeFaces.current().executeScript("registroFallido('Algo ha salido mal... intentalo nuevamente')");
            return "";
        }
        return null;
    }
//    

    public List<BolsasDeTiempo> consultarBolsa() {
        try {
            Usuarios cliente = sesionUsuario.getUsuLog();
            int idCliente = cliente.getIdUsuarios();
            this.bolsas = bolsasDeTiempoFacadeLocal.consultarBolsas(idCliente);
            return bolsas;
        } catch (Exception e) {
            return null;
        }
    }

    public void recargarBolsa() {
        try{
        BolsasDeTiempo bolsa = bolsas.get(0);
        Usuarios cliente = sesionUsuario.getUsuLog();
        int idCliente = cliente.getIdUsuarios();
        int horasRestantes = bolsa.getHorasRestantes();
        int horasActuales = 0;
        horasActuales = recarga + horasRestantes;
        bolsasDeTiempoFacadeLocal.recargarBolsa(idCliente, horasActuales);
        
         } catch (Exception e) {
            return;
        }
    }
    
}
