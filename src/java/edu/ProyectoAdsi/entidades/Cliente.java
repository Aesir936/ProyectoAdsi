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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_clientes")
    private int codigoClientes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuarios_idusuarios")
    private String usuariosIdusuarios;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "id_usuarios", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesUsuariosIdusuarios", fetch = FetchType.LAZY)
    private Collection<BolsasDeTiempo> bolsasDeTiempoCollection;

    public Cliente() {
    }

    public Cliente(String usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    public Cliente(String usuariosIdusuarios, int codigoClientes) {
        this.usuariosIdusuarios = usuariosIdusuarios;
        this.codigoClientes = codigoClientes;
    }

    public int getCodigoClientes() {
        return codigoClientes;
    }

    public void setCodigoClientes(int codigoClientes) {
        this.codigoClientes = codigoClientes;
    }

    public String getUsuariosIdusuarios() {
        return usuariosIdusuarios;
    }

    public void setUsuariosIdusuarios(String usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public Collection<BolsasDeTiempo> getBolsasDeTiempoCollection() {
        return bolsasDeTiempoCollection;
    }

    public void setBolsasDeTiempoCollection(Collection<BolsasDeTiempo> bolsasDeTiempoCollection) {
        this.bolsasDeTiempoCollection = bolsasDeTiempoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosIdusuarios != null ? usuariosIdusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.usuariosIdusuarios == null && other.usuariosIdusuarios != null) || (this.usuariosIdusuarios != null && !this.usuariosIdusuarios.equals(other.usuariosIdusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Cliente[ usuariosIdusuarios=" + usuariosIdusuarios + " ]";
    }
    
}
