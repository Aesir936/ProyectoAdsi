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
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_estados_ordenes_de_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosOrdenesDeTrabajo.findAll", query = "SELECT e FROM EstadosOrdenesDeTrabajo e")})
public class EstadosOrdenesDeTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estados_ordenes_de_trabajo")
    private Integer idEstadosOrdenesDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_estado_orden_de_trabajo")
    private String nombreEstadoOrdenDeTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadosOrdenesDeTrabajo", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajo> ordenesDeTrabajoCollection;

    public EstadosOrdenesDeTrabajo() {
    }

    public EstadosOrdenesDeTrabajo(Integer idEstadosOrdenesDeTrabajo) {
        this.idEstadosOrdenesDeTrabajo = idEstadosOrdenesDeTrabajo;
    }

    public EstadosOrdenesDeTrabajo(Integer idEstadosOrdenesDeTrabajo, String nombreEstadoOrdenDeTrabajo) {
        this.idEstadosOrdenesDeTrabajo = idEstadosOrdenesDeTrabajo;
        this.nombreEstadoOrdenDeTrabajo = nombreEstadoOrdenDeTrabajo;
    }

    public Integer getIdEstadosOrdenesDeTrabajo() {
        return idEstadosOrdenesDeTrabajo;
    }

    public void setIdEstadosOrdenesDeTrabajo(Integer idEstadosOrdenesDeTrabajo) {
        this.idEstadosOrdenesDeTrabajo = idEstadosOrdenesDeTrabajo;
    }

    public String getNombreEstadoOrdenDeTrabajo() {
        return nombreEstadoOrdenDeTrabajo;
    }

    public void setNombreEstadoOrdenDeTrabajo(String nombreEstadoOrdenDeTrabajo) {
        this.nombreEstadoOrdenDeTrabajo = nombreEstadoOrdenDeTrabajo;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajo> getOrdenesDeTrabajoCollection() {
        return ordenesDeTrabajoCollection;
    }

    public void setOrdenesDeTrabajoCollection(Collection<OrdenesDeTrabajo> ordenesDeTrabajoCollection) {
        this.ordenesDeTrabajoCollection = ordenesDeTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosOrdenesDeTrabajo != null ? idEstadosOrdenesDeTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosOrdenesDeTrabajo)) {
            return false;
        }
        EstadosOrdenesDeTrabajo other = (EstadosOrdenesDeTrabajo) object;
        if ((this.idEstadosOrdenesDeTrabajo == null && other.idEstadosOrdenesDeTrabajo != null) || (this.idEstadosOrdenesDeTrabajo != null && !this.idEstadosOrdenesDeTrabajo.equals(other.idEstadosOrdenesDeTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.EstadosOrdenesDeTrabajo[ idEstadosOrdenesDeTrabajo=" + idEstadosOrdenesDeTrabajo + " ]";
    }
    
}
