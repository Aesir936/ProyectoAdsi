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
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_archivos_adjuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosAdjuntos.findAll", query = "SELECT a FROM ArchivosAdjuntos a")})
public class ArchivosAdjuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_archivos_adjuntos")
    private Integer idArchivosAdjuntos;
    @JoinColumn(name = "cotizaciones_id_cotizaciones", referencedColumnName = "id_cotizaciones")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizaciones cotizacionesIdCotizaciones;

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

    public Cotizaciones getCotizacionesIdCotizaciones() {
        return cotizacionesIdCotizaciones;
    }

    public void setCotizacionesIdCotizaciones(Cotizaciones cotizacionesIdCotizaciones) {
        this.cotizacionesIdCotizaciones = cotizacionesIdCotizaciones;
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
