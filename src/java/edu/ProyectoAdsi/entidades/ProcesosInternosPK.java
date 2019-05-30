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
public class ProcesosInternosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipos_procesos")
    private int idTiposProcesos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procesos_id_procesos")
    private int procesosIdProcesos;

    public ProcesosInternosPK() {
    }

    public ProcesosInternosPK(int idTiposProcesos, int procesosIdProcesos) {
        this.idTiposProcesos = idTiposProcesos;
        this.procesosIdProcesos = procesosIdProcesos;
    }

    public int getIdTiposProcesos() {
        return idTiposProcesos;
    }

    public void setIdTiposProcesos(int idTiposProcesos) {
        this.idTiposProcesos = idTiposProcesos;
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
        hash += (int) idTiposProcesos;
        hash += (int) procesosIdProcesos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosInternosPK)) {
            return false;
        }
        ProcesosInternosPK other = (ProcesosInternosPK) object;
        if (this.idTiposProcesos != other.idTiposProcesos) {
            return false;
        }
        if (this.procesosIdProcesos != other.procesosIdProcesos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosInternosPK[ idTiposProcesos=" + idTiposProcesos + ", procesosIdProcesos=" + procesosIdProcesos + " ]";
    }
    
}
