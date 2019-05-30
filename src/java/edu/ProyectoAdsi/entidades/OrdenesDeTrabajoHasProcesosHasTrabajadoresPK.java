/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aesir936
 */
@Embeddable
public class OrdenesDeTrabajoHasProcesosHasTrabajadoresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ordenes_de_trabajo")
    private int idOrdenesDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesos")
    private int idProcesos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trabajadores")
    private int idTrabajadores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id_usuarios")
    private String idUsuarios;

    public OrdenesDeTrabajoHasProcesosHasTrabajadoresPK() {
    }

    public OrdenesDeTrabajoHasProcesosHasTrabajadoresPK(int idOrdenesDeTrabajo, int idProcesos, int idTrabajadores, String idUsuarios) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
        this.idProcesos = idProcesos;
        this.idTrabajadores = idTrabajadores;
        this.idUsuarios = idUsuarios;
    }

    public int getIdOrdenesDeTrabajo() {
        return idOrdenesDeTrabajo;
    }

    public void setIdOrdenesDeTrabajo(int idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public int getIdProcesos() {
        return idProcesos;
    }

    public void setIdProcesos(int idProcesos) {
        this.idProcesos = idProcesos;
    }

    public int getIdTrabajadores() {
        return idTrabajadores;
    }

    public void setIdTrabajadores(int idTrabajadores) {
        this.idTrabajadores = idTrabajadores;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenesDeTrabajo;
        hash += (int) idProcesos;
        hash += (int) idTrabajadores;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasProcesosHasTrabajadoresPK)) {
            return false;
        }
        OrdenesDeTrabajoHasProcesosHasTrabajadoresPK other = (OrdenesDeTrabajoHasProcesosHasTrabajadoresPK) object;
        if (this.idOrdenesDeTrabajo != other.idOrdenesDeTrabajo) {
            return false;
        }
        if (this.idProcesos != other.idProcesos) {
            return false;
        }
        if (this.idTrabajadores != other.idTrabajadores) {
            return false;
        }
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesosHasTrabajadoresPK[ idOrdenesDeTrabajo=" + idOrdenesDeTrabajo + ", idProcesos=" + idProcesos + ", idTrabajadores=" + idTrabajadores + ", idUsuarios=" + idUsuarios + " ]";
    }
    
}
