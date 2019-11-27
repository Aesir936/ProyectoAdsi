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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_bolsas_de_tiempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BolsasDeTiempo.findAll", query = "SELECT b FROM BolsasDeTiempo b")})
public class BolsasDeTiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bolsas_de_tiempo")
    private Integer idBolsasDeTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_activacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    @Column(name = "ultima_compra")
    private Integer ultimaCompra;
    @Column(name = "horas_restantes")
    private Integer horasRestantes;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuarios")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios fkIdUsuario;

    public BolsasDeTiempo() {
    }

    public BolsasDeTiempo(Integer idBolsasDeTiempo) {
        this.idBolsasDeTiempo = idBolsasDeTiempo;
    }

    public BolsasDeTiempo(Integer idBolsasDeTiempo, Date fechaActivacion) {
        this.idBolsasDeTiempo = idBolsasDeTiempo;
        this.fechaActivacion = fechaActivacion;
    }

    public Integer getIdBolsasDeTiempo() {
        return idBolsasDeTiempo;
    }

    public void setIdBolsasDeTiempo(Integer idBolsasDeTiempo) {
        this.idBolsasDeTiempo = idBolsasDeTiempo;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Integer getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(Integer ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }

    public Integer getHorasRestantes() {
        return horasRestantes;
    }

    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }

    public Usuarios getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuarios fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBolsasDeTiempo != null ? idBolsasDeTiempo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsasDeTiempo)) {
            return false;
        }
        BolsasDeTiempo other = (BolsasDeTiempo) object;
        if ((this.idBolsasDeTiempo == null && other.idBolsasDeTiempo != null) || (this.idBolsasDeTiempo != null && !this.idBolsasDeTiempo.equals(other.idBolsasDeTiempo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.BolsasDeTiempo[ idBolsasDeTiempo=" + idBolsasDeTiempo + " ]";
    }
    
}
