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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_procesos_internos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosInternos.findAll", query = "SELECT p FROM ProcesosInternos p")})
public class ProcesosInternos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipos_procesos")
    private Integer idTiposProcesos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiempo_ejecucion")
    private String tiempoEjecucion;
    @JoinColumn(name = "procesos_id_procesos", referencedColumnName = "id_procesos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos procesosIdProcesos;

    public ProcesosInternos() {
    }

    public ProcesosInternos(Integer idTiposProcesos) {
        this.idTiposProcesos = idTiposProcesos;
    }

    public ProcesosInternos(Integer idTiposProcesos, String tiempoEjecucion) {
        this.idTiposProcesos = idTiposProcesos;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Integer getIdTiposProcesos() {
        return idTiposProcesos;
    }

    public void setIdTiposProcesos(Integer idTiposProcesos) {
        this.idTiposProcesos = idTiposProcesos;
    }

    public String getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(String tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
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
        hash += (idTiposProcesos != null ? idTiposProcesos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesosInternos)) {
            return false;
        }
        ProcesosInternos other = (ProcesosInternos) object;
        if ((this.idTiposProcesos == null && other.idTiposProcesos != null) || (this.idTiposProcesos != null && !this.idTiposProcesos.equals(other.idTiposProcesos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ProcesosInternos[ idTiposProcesos=" + idTiposProcesos + " ]";
    }
    
}
