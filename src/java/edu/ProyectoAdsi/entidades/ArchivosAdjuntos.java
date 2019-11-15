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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bxs42
 */
@Entity
@Table(name = "tbl_archivos_adjuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosAdjuntos.findAll", query = "SELECT a FROM ArchivosAdjuntos a")})
public class ArchivosAdjuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivos_adjuntos")
    private Integer idArchivosAdjuntos;
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "id_cotizaciones", referencedColumnName = "id_cotizaciones")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizaciones idCotizaciones;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_ordenes_de_trabajo")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenesDeTrabajo idOrdenTrabajo;

    public ArchivosAdjuntos() {
    }

    public ArchivosAdjuntos(Integer idArchivosAdjuntos) {
        this.idArchivosAdjuntos = idArchivosAdjuntos;
    }

    public Integer getIdArchivosAdjuntos() {
        return idArchivosAdjuntos;
    }

    public void setIdArchivosAdjuntos(Integer idArchivosAdjuntos) {
        this.idArchivosAdjuntos = idArchivosAdjuntos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Cotizaciones getIdCotizaciones() {
        return idCotizaciones;
    }

    public void setIdCotizaciones(Cotizaciones idCotizaciones) {
        this.idCotizaciones = idCotizaciones;
    }

    public OrdenesDeTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenesDeTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivosAdjuntos != null ? idArchivosAdjuntos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivosAdjuntos)) {
            return false;
        }
        ArchivosAdjuntos other = (ArchivosAdjuntos) object;
        if ((this.idArchivosAdjuntos == null && other.idArchivosAdjuntos != null) || (this.idArchivosAdjuntos != null && !this.idArchivosAdjuntos.equals(other.idArchivosAdjuntos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.ArchivosAdjuntos[ idArchivosAdjuntos=" + idArchivosAdjuntos + " ]";
    }
    
}
