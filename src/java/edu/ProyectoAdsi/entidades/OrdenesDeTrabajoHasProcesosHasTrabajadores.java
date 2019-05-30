/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "ordenes_de_trabajo_has_procesos_has_trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajoHasProcesosHasTrabajadores.findAll", query = "SELECT o FROM OrdenesDeTrabajoHasProcesosHasTrabajadores o")})
public class OrdenesDeTrabajoHasProcesosHasTrabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesDeTrabajoHasProcesosHasTrabajadoresPK ordenesDeTrabajoHasProcesosHasTrabajadoresPK;
    @JoinColumns({
        @JoinColumn(name = "id_ordenes_de_trabajo", referencedColumnName = "id_ordenes_de_trabajo", insertable = false, updatable = false)
        , @JoinColumn(name = "id_procesos", referencedColumnName = "id_procesos", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajoHasProcesos ordenesDeTrabajoHasProcesos;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "usuarios_idusuarios", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trabajadores trabajadores;

    public OrdenesDeTrabajoHasProcesosHasTrabajadores() {
    }

    public OrdenesDeTrabajoHasProcesosHasTrabajadores(OrdenesDeTrabajoHasProcesosHasTrabajadoresPK ordenesDeTrabajoHasProcesosHasTrabajadoresPK) {
        this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK = ordenesDeTrabajoHasProcesosHasTrabajadoresPK;
    }

    public OrdenesDeTrabajoHasProcesosHasTrabajadores(int idOrdenesDeTrabajo, int idProcesos, int idTrabajadores, String idUsuarios) {
        this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK = new OrdenesDeTrabajoHasProcesosHasTrabajadoresPK(idOrdenesDeTrabajo, idProcesos, idTrabajadores, idUsuarios);
    }

    public OrdenesDeTrabajoHasProcesosHasTrabajadoresPK getOrdenesDeTrabajoHasProcesosHasTrabajadoresPK() {
        return ordenesDeTrabajoHasProcesosHasTrabajadoresPK;
    }

    public void setOrdenesDeTrabajoHasProcesosHasTrabajadoresPK(OrdenesDeTrabajoHasProcesosHasTrabajadoresPK ordenesDeTrabajoHasProcesosHasTrabajadoresPK) {
        this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK = ordenesDeTrabajoHasProcesosHasTrabajadoresPK;
    }

    public OrdenesDeTrabajoHasProcesos getOrdenesDeTrabajoHasProcesos() {
        return ordenesDeTrabajoHasProcesos;
    }

    public void setOrdenesDeTrabajoHasProcesos(OrdenesDeTrabajoHasProcesos ordenesDeTrabajoHasProcesos) {
        this.ordenesDeTrabajoHasProcesos = ordenesDeTrabajoHasProcesos;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenesDeTrabajoHasProcesosHasTrabajadoresPK != null ? ordenesDeTrabajoHasProcesosHasTrabajadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasProcesosHasTrabajadores)) {
            return false;
        }
        OrdenesDeTrabajoHasProcesosHasTrabajadores other = (OrdenesDeTrabajoHasProcesosHasTrabajadores) object;
        if ((this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK == null && other.ordenesDeTrabajoHasProcesosHasTrabajadoresPK != null) || (this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK != null && !this.ordenesDeTrabajoHasProcesosHasTrabajadoresPK.equals(other.ordenesDeTrabajoHasProcesosHasTrabajadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesosHasTrabajadores[ ordenesDeTrabajoHasProcesosHasTrabajadoresPK=" + ordenesDeTrabajoHasProcesosHasTrabajadoresPK + " ]";
    }
    
}
