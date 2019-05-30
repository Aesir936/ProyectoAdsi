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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "procesos_externos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosExternos.findAll", query = "SELECT p FROM ProcesosExternos p")})
public class ProcesosExternos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesosExternosPK procesosExternosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_proceso")
    private int costoProceso;
    @JoinColumn(name = "procesos_id_procesos", referencedColumnName = "id_procesos", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos procesos;

    public ProcesosExternos() {
    }

    public ProcesosExternos(ProcesosExternosPK procesosExternosPK) {
        this.procesosExternosPK = procesosExternosPK;
    }

    public ProcesosExternos(ProcesosExternosPK procesosExternosPK, int costoProceso) {
        this.procesosExternosPK = procesosExternosPK;
        this.costoProceso = costoProceso;
    }

    public ProcesosExternos(int idProcesosExternos, int procesosIdProcesos) {
        this.procesosExternosPK = new ProcesosExternosPK(idProcesosExternos, procesosIdProcesos);
    }

    public ProcesosExternosPK getProcesosExternosPK() {
        return procesosExternosPK;
    }

    public void setProcesosExternosPK(ProcesosExternosPK procesosExternosPK) {
        this.procesosExternosPK = procesosExternosPK;
    }

    public int getCostoProceso() {
        return costoProceso;
    }

    public void setCostoProceso(int costoProceso) {
        this.costoProceso = costoProceso;
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
        hash += (procesosExternosPK != null ? procesosExternosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosExternos)) {
            return false;
        }
        ProcesosExternos other = (ProcesosExternos) object;
        if ((this.procesosExternosPK == null && other.procesosExternosPK != null) || (this.procesosExternosPK != null && !this.procesosExternosPK.equals(other.procesosExternosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosExternos[ procesosExternosPK=" + procesosExternosPK + " ]";
    }
    
}
