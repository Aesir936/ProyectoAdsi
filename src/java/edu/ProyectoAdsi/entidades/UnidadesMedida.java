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
@Table(name = "unidades_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadesMedida.findAll", query = "SELECT u FROM UnidadesMedida u")})
public class UnidadesMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUnidad_medida")
    private Integer idUnidadmedida;
    @Size(max = 45)
    @Column(name = "nombre_unidad_medida")
    private String nombreUnidadMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadesmedidaidUnidadmedida", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;

    public UnidadesMedida() {
    }

    public UnidadesMedida(Integer idUnidadmedida) {
        this.idUnidadmedida = idUnidadmedida;
    }

    public Integer getIdUnidadmedida() {
        return idUnidadmedida;
    }

    public void setIdUnidadmedida(Integer idUnidadmedida) {
        this.idUnidadmedida = idUnidadmedida;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadmedida != null ? idUnidadmedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedida)) {
            return false;
        }
        UnidadesMedida other = (UnidadesMedida) object;
        if ((this.idUnidadmedida == null && other.idUnidadmedida != null) || (this.idUnidadmedida != null && !this.idUnidadmedida.equals(other.idUnidadmedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.UnidadesMedida[ idUnidadmedida=" + idUnidadmedida + " ]";
    }
    
}
