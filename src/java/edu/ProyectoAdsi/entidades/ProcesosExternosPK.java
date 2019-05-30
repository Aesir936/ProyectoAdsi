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
public class ProcesosExternosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesos_externos")
    private int idProcesosExternos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procesos_id_procesos")
    private int procesosIdProcesos;

    public ProcesosExternosPK() {
    }

    public ProcesosExternosPK(int idProcesosExternos, int procesosIdProcesos) {
        this.idProcesosExternos = idProcesosExternos;
        this.procesosIdProcesos = procesosIdProcesos;
    }

    public int getIdProcesosExternos() {
        return idProcesosExternos;
    }

    public void setIdProcesosExternos(int idProcesosExternos) {
        this.idProcesosExternos = idProcesosExternos;
    }

    public int getProcesosIdProcesos() {
        return procesosIdProcesos;
    }

    public void setProcesosIdProcesos(int procesosIdProcesos) {
        this.procesosIdProcesos = procesosIdProcesos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProcesosExternos;
        hash += (int) procesosIdProcesos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosExternosPK)) {
            return false;
        }
        ProcesosExternosPK other = (ProcesosExternosPK) object;
        if (this.idProcesosExternos != other.idProcesosExternos) {
            return false;
        }
        if (this.procesosIdProcesos != other.procesosIdProcesos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosExternosPK[ idProcesosExternos=" + idProcesosExternos + ", procesosIdProcesos=" + procesosIdProcesos + " ]";
    }
    
}
