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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_fotos_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotosPerfil.findAll", query = "SELECT f FROM FotosPerfil f")})
public class FotosPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto")
    private Integer idFoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fkIdUsuario;

    public FotosPerfil() {
    }

    public FotosPerfil(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public FotosPerfil(Integer idFoto, String ruta) {
        this.idFoto = idFoto;
        this.ruta = ruta;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
        hash += (idFoto != null ? idFoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotosPerfil)) {
            return false;
        }
        FotosPerfil other = (FotosPerfil) object;
        if ((this.idFoto == null && other.idFoto != null) || (this.idFoto != null && !this.idFoto.equals(other.idFoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.FotosPerfil[ idFoto=" + idFoto + " ]";
    }
    
}
