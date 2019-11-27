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
 * @author cristian
 */
@Entity
@Table(name = "tbl_estados_cotizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCotizaciones.findAll", query = "SELECT e FROM EstadosCotizaciones e")})
public class EstadosCotizaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_cotizacion")
    private Integer idEstadoCotizacion;
    @Size(max = 45)
    @Column(name = "nombre_estado_cotizacion")
    private String nombreEstadoCotizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCotizacion", fetch = FetchType.LAZY)
    private Collection<Cotizaciones> cotizacionesCollection;

    public EstadosCotizaciones() {
    }

    public EstadosCotizaciones(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public Integer getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public String getNombreEstadoCotizacion() {
        return nombreEstadoCotizacion;
    }

    public void setNombreEstadoCotizacion(String nombreEstadoCotizacion) {
        this.nombreEstadoCotizacion = nombreEstadoCotizacion;
    }

    @XmlTransient
    public Collection<Cotizaciones> getCotizacionesCollection() {
        return cotizacionesCollection;
    }

    public void setCotizacionesCollection(Collection<Cotizaciones> cotizacionesCollection) {
        this.cotizacionesCollection = cotizacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCotizacion != null ? idEstadoCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCotizaciones)) {
            return false;
        }
        EstadosCotizaciones other = (EstadosCotizaciones) object;
        if ((this.idEstadoCotizacion == null && other.idEstadoCotizacion != null) || (this.idEstadoCotizacion != null && !this.idEstadoCotizacion.equals(other.idEstadoCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.EstadosCotizaciones[ idEstadoCotizacion=" + idEstadoCotizacion + " ]";
    }
    
}
