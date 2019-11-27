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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_usuarios_has_tbl_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosHasTblRoles.findAll", query = "SELECT u FROM UsuariosHasTblRoles u")})
public class UsuariosHasTblRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tbl_usuarios_has_tbl_roles")
    private Integer pkTblUsuariosHasTblRoles;
    @JoinColumn(name = "tbl_roles_id_tbl_rol", referencedColumnName = "id_tbl_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles tblRolesIdTblRol;
    @JoinColumn(name = "tbl_usuarios_id_usuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios tblUsuariosIdUsuarios;

    public UsuariosHasTblRoles() {
    }

    public UsuariosHasTblRoles(Integer pkTblUsuariosHasTblRoles) {
        this.pkTblUsuariosHasTblRoles = pkTblUsuariosHasTblRoles;
    }

    public Integer getPkTblUsuariosHasTblRoles() {
        return pkTblUsuariosHasTblRoles;
    }

    public void setPkTblUsuariosHasTblRoles(Integer pkTblUsuariosHasTblRoles) {
        this.pkTblUsuariosHasTblRoles = pkTblUsuariosHasTblRoles;
    }

    public Roles getTblRolesIdTblRol() {
        return tblRolesIdTblRol;
    }

    public void setTblRolesIdTblRol(Roles tblRolesIdTblRol) {
        this.tblRolesIdTblRol = tblRolesIdTblRol;
    }

    public Usuarios getTblUsuariosIdUsuarios() {
        return tblUsuariosIdUsuarios;
    }

    public void setTblUsuariosIdUsuarios(Usuarios tblUsuariosIdUsuarios) {
        this.tblUsuariosIdUsuarios = tblUsuariosIdUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTblUsuariosHasTblRoles != null ? pkTblUsuariosHasTblRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosHasTblRoles)) {
            return false;
        }
        UsuariosHasTblRoles other = (UsuariosHasTblRoles) object;
        if ((this.pkTblUsuariosHasTblRoles == null && other.pkTblUsuariosHasTblRoles != null) || (this.pkTblUsuariosHasTblRoles != null && !this.pkTblUsuariosHasTblRoles.equals(other.pkTblUsuariosHasTblRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.UsuariosHasTblRoles[ pkTblUsuariosHasTblRoles=" + pkTblUsuariosHasTblRoles + " ]";
    }
    
}
