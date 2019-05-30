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

/**
 *
 * @author Aesir936
 */
@Embeddable
public class OrdenesDeTrabajoHasProcesosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ordenes_de_trabajo")
    private int idOrdenesDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesos")
    private int idProcesos;

    public OrdenesDeTrabajoHasProcesosPK() {
    }

    public OrdenesDeTrabajoHasProcesosPK(int idOrdenesDeTrabajo, int idProcesos) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
        this.idProcesos = idProcesos;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenesDeTrabajo;
        hash += (int) idProcesos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasProcesosPK)) {
            return false;
        }
        OrdenesDeTrabajoHasProcesosPK other = (OrdenesDeTrabajoHasProcesosPK) object;
        if (this.idOrdenesDeTrabajo != other.idOrdenesDeTrabajo) {
            return false;
        }
        if (this.idProcesos != other.idProcesos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesosPK[ idOrdenesDeTrabajo=" + idOrdenesDeTrabajo + ", idProcesos=" + idProcesos + " ]";
    }
    
}
