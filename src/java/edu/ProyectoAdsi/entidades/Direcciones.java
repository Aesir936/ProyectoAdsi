
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "tbl_direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tbl_direccion")
    private Integer idTblDireccion;
    @Size(max = 45)
    @Column(name = "descripcion_direccion")
    private String descripcionDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTblDireccion", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "id_tbl_ciudades", referencedColumnName = "id_tbl_ciudades")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudades idTblCiudades;

    public Direcciones() {
    }

    public Direcciones(Integer idTblDireccion) {
        this.idTblDireccion = idTblDireccion;
    }

    public Integer getIdTblDireccion() {
        return idTblDireccion;
    }

    public void setIdTblDireccion(Integer idTblDireccion) {
        this.idTblDireccion = idTblDireccion;
    }

    public String getDescripcionDireccion() {
        return descripcionDireccion;
    }

    public void setDescripcionDireccion(String descripcionDireccion) {
        this.descripcionDireccion = descripcionDireccion;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Ciudades getIdTblCiudades() {
        return idTblCiudades;
    }

    public void setIdTblCiudades(Ciudades idTblCiudades) {
        this.idTblCiudades = idTblCiudades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblDireccion != null ? idTblDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.idTblDireccion == null && other.idTblDireccion != null) || (this.idTblDireccion != null && !this.idTblDireccion.equals(other.idTblDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Direcciones[ idTblDireccion=" + idTblDireccion + " ]";
    }
    
}
