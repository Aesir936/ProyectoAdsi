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
@Table(name = "tbl_gerentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerentes.findAll", query = "SELECT g FROM Gerentes g")})
public class Gerentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_gerente")
    private Integer codigoGerente;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosIdusuarios;

    public Gerentes() {
    }

    public Gerentes(Integer codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    public Integer getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(Integer codigoGerente) {
        this.codigoGerente = codigoGerente;
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
        hash += (codigoGerente != null ? codigoGerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerentes)) {
            return false;
        }
        Gerentes other = (Gerentes) object;
        if ((this.codigoGerente == null && other.codigoGerente != null) || (this.codigoGerente != null && !this.codigoGerente.equals(other.codigoGerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Gerentes[ codigoGerente=" + codigoGerente + " ]";
    }
    
}
