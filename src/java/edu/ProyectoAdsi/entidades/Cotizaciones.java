/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_cotizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizaciones.findAll", query = "SELECT c FROM Cotizaciones c")})
public class Cotizaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotizaciones")
    private Integer idCotizaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cotizaciones")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCotizaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plano")
    private short plano;
    @JoinColumn(name = "id_estado_cotizacion", referencedColumnName = "id_estado_cotizacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosCotizaciones idEstadoCotizacion;
    @JoinColumn(name = "id_ordenes_de_trabajo", referencedColumnName = "id_ordenes_de_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajo idOrdenesDeTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacionesIdCotizaciones", fetch = FetchType.LAZY)
    private Collection<ArchivosAdjuntos> archivosAdjuntosCollection;

    public Cotizaciones() {
    }

    public Cotizaciones(Integer idCotizaciones) {
        this.idCotizaciones = idCotizaciones;
    }

    public Cotizaciones(Integer idCotizaciones, Date fechaCotizaciones, String detalle, short plano) {
        this.idCotizaciones = idCotizaciones;
        this.fechaCotizaciones = fechaCotizaciones;
        this.detalle = detalle;
        this.plano = plano;
    }

    public Integer getIdCotizaciones() {
        return idCotizaciones;
    }

    public void setIdCotizaciones(Integer idCotizaciones) {
        this.idCotizaciones = idCotizaciones;
    }

    public Date getFechaCotizaciones() {
        return fechaCotizaciones;
    }

    public void setFechaCotizaciones(Date fechaCotizaciones) {
        this.fechaCotizaciones = fechaCotizaciones;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public short getPlano() {
        return plano;
    }

    public void setPlano(short plano) {
        this.plano = plano;
    }

    public EstadosCotizaciones getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(EstadosCotizaciones idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public OrdenesDeTrabajo getIdOrdenesDeTrabajo() {
        return idOrdenesDeTrabajo;
    }

    public void setIdOrdenesDeTrabajo(OrdenesDeTrabajo idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    @XmlTransient
    public Collection<ArchivosAdjuntos> getArchivosAdjuntosCollection() {
        return archivosAdjuntosCollection;
    }

    public void setArchivosAdjuntosCollection(Collection<ArchivosAdjuntos> archivosAdjuntosCollection) {
        this.archivosAdjuntosCollection = archivosAdjuntosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizaciones != null ? idCotizaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizaciones)) {
            return false;
        }
        Cotizaciones other = (Cotizaciones) object;
        if ((this.idCotizaciones == null && other.idCotizaciones != null) || (this.idCotizaciones != null && !this.idCotizaciones.equals(other.idCotizaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Cotizaciones[ idCotizaciones=" + idCotizaciones + " ]";
    }
    
}
