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
@Table(name = "ordenes_de_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajo.findAll", query = "SELECT o FROM OrdenesDeTrabajo o")})
public class OrdenesDeTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordenes_de_trabajo")
    private Integer idOrdenesDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_Vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiempo_total_fabricacion")
    private String tiempoTotalFabricacion;
    @JoinColumn(name = "estados_ordenes_de_trabajo_id_estados_ordenes_de_trabajo", referencedColumnName = "id_estados_ordenes_de_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosOrdenesDeTrabajo estadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesDeTrabajo", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasProcesos> ordenesDeTrabajoHasProcesosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenesDeTrabajo", fetch = FetchType.LAZY)
    private Collection<Cotizaciones> cotizacionesCollection;

    public OrdenesDeTrabajo() {
    }

    public OrdenesDeTrabajo(Integer idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public OrdenesDeTrabajo(Integer idOrdenesDeTrabajo, Date fechaVencimiento, Date fechaGeneracion, String tiempoTotalFabricacion) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaGeneracion = fechaGeneracion;
        this.tiempoTotalFabricacion = tiempoTotalFabricacion;
    }

    public Integer getIdOrdenesDeTrabajo() {
        return idOrdenesDeTrabajo;
    }

    public void setIdOrdenesDeTrabajo(Integer idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTiempoTotalFabricacion() {
        return tiempoTotalFabricacion;
    }

    public void setTiempoTotalFabricacion(String tiempoTotalFabricacion) {
        this.tiempoTotalFabricacion = tiempoTotalFabricacion;
    }

    public EstadosOrdenesDeTrabajo getEstadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo() {
        return estadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo;
    }

    public void setEstadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo(EstadosOrdenesDeTrabajo estadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo) {
        this.estadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo = estadosOrdenesDeTrabajoIdEstadosOrdenesDeTrabajo;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasProcesos> getOrdenesDeTrabajoHasProcesosCollection() {
        return ordenesDeTrabajoHasProcesosCollection;
    }

    public void setOrdenesDeTrabajoHasProcesosCollection(Collection<OrdenesDeTrabajoHasProcesos> ordenesDeTrabajoHasProcesosCollection) {
        this.ordenesDeTrabajoHasProcesosCollection = ordenesDeTrabajoHasProcesosCollection;
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
        hash += (idOrdenesDeTrabajo != null ? idOrdenesDeTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajo)) {
            return false;
        }
        OrdenesDeTrabajo other = (OrdenesDeTrabajo) object;
        if ((this.idOrdenesDeTrabajo == null && other.idOrdenesDeTrabajo != null) || (this.idOrdenesDeTrabajo != null && !this.idOrdenesDeTrabajo.equals(other.idOrdenesDeTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajo[ idOrdenesDeTrabajo=" + idOrdenesDeTrabajo + " ]";
    }
    
}
