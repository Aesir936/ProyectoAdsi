/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "procesos_internos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosInternos.findAll", query = "SELECT p FROM ProcesosInternos p")})
public class ProcesosInternos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesosInternosPK procesosInternosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiempo_ejecucion")
    private String tiempoEjecucion;
    @JoinColumn(name = "procesos_id_procesos", referencedColumnName = "id_procesos", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos procesos;

    public ProcesosInternos() {
    }

    public ProcesosInternos(ProcesosInternosPK procesosInternosPK) {
        this.procesosInternosPK = procesosInternosPK;
    }

    public ProcesosInternos(ProcesosInternosPK procesosInternosPK, String tiempoEjecucion) {
        this.procesosInternosPK = procesosInternosPK;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public ProcesosInternos(int idTiposProcesos, int procesosIdProcesos) {
        this.procesosInternosPK = new ProcesosInternosPK(idTiposProcesos, procesosIdProcesos);
    }

    public ProcesosInternosPK getProcesosInternosPK() {
        return procesosInternosPK;
    }

    public void setProcesosInternosPK(ProcesosInternosPK procesosInternosPK) {
        this.procesosInternosPK = procesosInternosPK;
    }

    public String getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(String tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Procesos getProcesos() {
        return procesos;
    }

    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesosInternosPK != null ? procesosInternosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosInternos)) {
            return false;
        }
        ProcesosInternos other = (ProcesosInternos) object;
        if ((this.procesosInternosPK == null && other.procesosInternosPK != null) || (this.procesosInternosPK != null && !this.procesosInternosPK.equals(other.procesosInternosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosInternos[ procesosInternosPK=" + procesosInternosPK + " ]";
    }
    
}
