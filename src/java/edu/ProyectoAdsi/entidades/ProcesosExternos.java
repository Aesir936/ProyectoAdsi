/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bxs42
 */
@Entity
@Table(name = "tbl_procesos_externos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosExternos.findAll", query = "SELECT p FROM ProcesosExternos p")})
public class ProcesosExternos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesos_externos")
    private Integer idProcesosExternos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_proceso")
    private int costoProceso;
    @JoinColumn(name = "procesos_id_procesos", referencedColumnName = "id_procesos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos procesosIdProcesos;

    public ProcesosExternos() {
    }

    public ProcesosExternos(Integer idProcesosExternos) {
        this.idProcesosExternos = idProcesosExternos;
    }

    public ProcesosExternos(Integer idProcesosExternos, int costoProceso) {
        this.idProcesosExternos = idProcesosExternos;
        this.costoProceso = costoProceso;
    }

    public Integer getIdProcesosExternos() {
        return idProcesosExternos;
    }

    public void setIdProcesosExternos(Integer idProcesosExternos) {
        this.idProcesosExternos = idProcesosExternos;
    }

    public int getCostoProceso() {
        return costoProceso;
    }

    public void setCostoProceso(int costoProceso) {
        this.costoProceso = costoProceso;
    }

    public Procesos getProcesosIdProcesos() {
        return procesosIdProcesos;
    }

    public void setProcesosIdProcesos(Procesos procesosIdProcesos) {
        this.procesosIdProcesos = procesosIdProcesos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesosExternos != null ? idProcesosExternos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosExternos)) {
            return false;
        }
        ProcesosExternos other = (ProcesosExternos) object;
        if ((this.idProcesosExternos == null && other.idProcesosExternos != null) || (this.idProcesosExternos != null && !this.idProcesosExternos.equals(other.idProcesosExternos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosExternos[ idProcesosExternos=" + idProcesosExternos + " ]";
    }
    
}
