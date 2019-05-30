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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "gerentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerentes.findAll", query = "SELECT g FROM Gerentes g")})
public class Gerentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_gerente")
    private int codigoGerente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuarios_idusuarios")
    private String usuariosIdusuarios;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "id_usuarios", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuarios;

    public Gerentes() {
    }

    public Gerentes(String usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    public Gerentes(String usuariosIdusuarios, int codigoGerente) {
        this.usuariosIdusuarios = usuariosIdusuarios;
        this.codigoGerente = codigoGerente;
    }

    public int getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(int codigoGerente) {
        this.codigoGerente = codigoGerente;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosIdusuarios != null ? usuariosIdusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerentes)) {
            return false;
        }
        Gerentes other = (Gerentes) object;
        if ((this.usuariosIdusuarios == null && other.usuariosIdusuarios != null) || (this.usuariosIdusuarios != null && !this.usuariosIdusuarios.equals(other.usuariosIdusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Gerentes[ usuariosIdusuarios=" + usuariosIdusuarios + " ]";
    }
    
}
