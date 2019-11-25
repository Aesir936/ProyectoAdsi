/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_ordenes_de_trabajo")
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
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Size(max = 500)
    @Column(name = "detalle")
    private String detalle;
    @Size(max = 10)
    @Column(name = "cantidad_piezas")
    private String cantidadPiezas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_total_fabricacion")
    private int tiempoTotalFabricacion;
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id_estados_ordenes_de_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosOrdenesDeTrabajo fkIdEstado;
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fkIdCliente;

    public OrdenesDeTrabajo() {
    }

    public OrdenesDeTrabajo(Integer idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public OrdenesDeTrabajo(Integer idOrdenesDeTrabajo, Date fechaGeneracion, Date fechaEntrega, int tiempoTotalFabricacion) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaEntrega = fechaEntrega;
        this.tiempoTotalFabricacion = tiempoTotalFabricacion;
    }

    public Integer getIdOrdenesDeTrabajo() {
        return idOrdenesDeTrabajo;
    }

    public void setIdOrdenesDeTrabajo(Integer idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(String cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    public int getTiempoTotalFabricacion() {
        return tiempoTotalFabricacion;
    }

    public void setTiempoTotalFabricacion(int tiempoTotalFabricacion) {
        this.tiempoTotalFabricacion = tiempoTotalFabricacion;
    }

    public EstadosOrdenesDeTrabajo getFkIdEstado() {
        return fkIdEstado;
    }

    public void setFkIdEstado(EstadosOrdenesDeTrabajo fkIdEstado) {
        this.fkIdEstado = fkIdEstado;
    }

    public Usuarios getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(Usuarios fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
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
