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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tbl_ciudades")
    private Integer idTblCiudades;
    @Size(max = 45)
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTblCiudades", fetch = FetchType.LAZY)
    private Collection<Direcciones> direccionesCollection;

    public Ciudades() {
    }

    public Ciudades(Integer idTblCiudades) {
        this.idTblCiudades = idTblCiudades;
    }

    public Integer getIdTblCiudades() {
        return idTblCiudades;
    }

    public void setIdTblCiudades(Integer idTblCiudades) {
        this.idTblCiudades = idTblCiudades;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public Collection<Direcciones> getDireccionesCollection() {
        return direccionesCollection;
    }

    public void setDireccionesCollection(Collection<Direcciones> direccionesCollection) {
        this.direccionesCollection = direccionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblCiudades != null ? idTblCiudades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.idTblCiudades == null && other.idTblCiudades != null) || (this.idTblCiudades != null && !this.idTblCiudades.equals(other.idTblCiudades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Ciudades[ idTblCiudades=" + idTblCiudades + " ]";
    }
    
}
