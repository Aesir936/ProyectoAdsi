
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tbl_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tbl_rol")
    private Integer idTblRol;
    @Size(max = 45)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @Size(max = 45)
    @Column(name = "descripcion_rol")
    private String descripcionRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblRolesIdTblRol", fetch = FetchType.LAZY)
    private Collection<UsuariosHasTblRoles> usuariosHasTblRolesCollection;

    public Roles() {
    }

    public Roles(Integer idTblRol) {
        this.idTblRol = idTblRol;
    }

    public Integer getIdTblRol() {
        return idTblRol;
    }

    public void setIdTblRol(Integer idTblRol) {
        this.idTblRol = idTblRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    @XmlTransient
    public Collection<UsuariosHasTblRoles> getUsuariosHasTblRolesCollection() {
        return usuariosHasTblRolesCollection;
    }

    public void setUsuariosHasTblRolesCollection(Collection<UsuariosHasTblRoles> usuariosHasTblRolesCollection) {
        this.usuariosHasTblRolesCollection = usuariosHasTblRolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblRol != null ? idTblRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idTblRol == null && other.idTblRol != null) || (this.idTblRol != null && !this.idTblRol.equals(other.idTblRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Roles[ idTblRol=" + idTblRol + " ]";
    }
    
}
