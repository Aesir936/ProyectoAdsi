/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bxs42
 */
@Entity
@Table(name = "tbl_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesos.findAll", query = "SELECT p FROM Procesos p")})
public class Procesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesos")
    private Integer idProcesos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_procesos")
    private String nombreProcesos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesosIdProcesos", fetch = FetchType.LAZY)
    private Collection<ProcesosExternos> procesosExternosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesosIdProcesos", fetch = FetchType.LAZY)
    private Collection<ProcesosInternos> procesosInternosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesos", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasTblProcesos> ordenesDeTrabajoHasTblProcesosCollection;

    public Procesos() {
    }

    public Procesos(Integer idProcesos) {
        this.idProcesos = idProcesos;
    }

    public Procesos(Integer idProcesos, String nombreProcesos) {
        this.idProcesos = idProcesos;
        this.nombreProcesos = nombreProcesos;
    }

    public Integer getIdProcesos() {
        return idProcesos;
    }

    public void setIdProcesos(Integer idProcesos) {
        this.idProcesos = idProcesos;
    }

    public String getNombreProcesos() {
        return nombreProcesos;
    }

    public void setNombreProcesos(String nombreProcesos) {
        this.nombreProcesos = nombreProcesos;
    }

    @XmlTransient
    public Collection<ProcesosExternos> getProcesosExternosCollection() {
        return procesosExternosCollection;
    }

    public void setProcesosExternosCollection(Collection<ProcesosExternos> procesosExternosCollection) {
        this.procesosExternosCollection = procesosExternosCollection;
    }

    @XmlTransient
    public Collection<ProcesosInternos> getProcesosInternosCollection() {
        return procesosInternosCollection;
    }

    public void setProcesosInternosCollection(Collection<ProcesosInternos> procesosInternosCollection) {
        this.procesosInternosCollection = procesosInternosCollection;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasTblProcesos> getOrdenesDeTrabajoHasTblProcesosCollection() {
        return ordenesDeTrabajoHasTblProcesosCollection;
    }

    public void setOrdenesDeTrabajoHasTblProcesosCollection(Collection<OrdenesDeTrabajoHasTblProcesos> ordenesDeTrabajoHasTblProcesosCollection) {
        this.ordenesDeTrabajoHasTblProcesosCollection = ordenesDeTrabajoHasTblProcesosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesos != null ? idProcesos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesos)) {
            return false;
        }
        Procesos other = (Procesos) object;
        if ((this.idProcesos == null && other.idProcesos != null) || (this.idProcesos != null && !this.idProcesos.equals(other.idProcesos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Procesos[ idProcesos=" + idProcesos + " ]";
    }
    
}
