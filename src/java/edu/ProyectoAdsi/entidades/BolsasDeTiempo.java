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
 * @author Aesir936
 */
@Entity
@Table(name = "bolsas_de_tiempo")
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_hora")
    private int valorHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_horas")
    private int cantidadHoras;
    @JoinColumn(name = "clientes_usuarios_idusuarios", referencedColumnName = "usuarios_idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientesUsuariosIdusuarios;

    public BolsasDeTiempo() {
    }

    public BolsasDeTiempo(Integer idBolsasDeTiempo) {
        this.idBolsasDeTiempo = idBolsasDeTiempo;
    }

    public BolsasDeTiempo(Integer idBolsasDeTiempo, Date fechaActivacion, int valorHora, int cantidadHoras) {
        this.idBolsasDeTiempo = idBolsasDeTiempo;
        this.fechaActivacion = fechaActivacion;
        this.valorHora = valorHora;
        this.cantidadHoras = cantidadHoras;
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

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Cliente getClientesUsuariosIdusuarios() {
        return clientesUsuariosIdusuarios;
    }

    public void setClientesUsuariosIdusuarios(Cliente clientesUsuariosIdusuarios) {
        this.clientesUsuariosIdusuarios = clientesUsuariosIdusuarios;
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
