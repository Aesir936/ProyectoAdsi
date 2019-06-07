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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_clientes")
    private Integer codigoClientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblClientesCodigoClientes", fetch = FetchType.LAZY)
    private Collection<BolsasDeTiempo> bolsasDeTiempoCollection;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosIdusuarios;

    public Clientes() {
    }

    public Clientes(Integer codigoClientes) {
        this.codigoClientes = codigoClientes;
    }

    public Integer getCodigoClientes() {
        return codigoClientes;
    }

    public void setCodigoClientes(Integer codigoClientes) {
        this.codigoClientes = codigoClientes;
    }

    @XmlTransient
    public Collection<BolsasDeTiempo> getBolsasDeTiempoCollection() {
        return bolsasDeTiempoCollection;
    }

    public void setBolsasDeTiempoCollection(Collection<BolsasDeTiempo> bolsasDeTiempoCollection) {
        this.bolsasDeTiempoCollection = bolsasDeTiempoCollection;
    }

    public Usuarios getUsuariosIdusuarios() {
        return usuariosIdusuarios;
    }

    public void setUsuariosIdusuarios(Usuarios usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoClientes != null ? codigoClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codigoClientes == null && other.codigoClientes != null) || (this.codigoClientes != null && !this.codigoClientes.equals(other.codigoClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Clientes[ codigoClientes=" + codigoClientes + " ]";
    }
    
}
