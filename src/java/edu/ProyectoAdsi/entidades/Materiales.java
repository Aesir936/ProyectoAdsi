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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materiales")
    private Integer idMateriales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_materiales")
    private String nombreMateriales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_existente")
    private int cantidadExistente;
    @Size(max = 45)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblMaterialesIdMateriales", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    @JoinColumn(name = "unidades_medida_idUnidad_medida", referencedColumnName = "idUnidad_medida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadesMedida unidadesmedidaidUnidadmedida;

    public Materiales() {
    }

    public Materiales(Integer idMateriales) {
        this.idMateriales = idMateriales;
    }

    public Materiales(Integer idMateriales, String nombreMateriales, int cantidadExistente) {
        this.idMateriales = idMateriales;
        this.nombreMateriales = nombreMateriales;
        this.cantidadExistente = cantidadExistente;
    }

    public Integer getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(Integer idMateriales) {
        this.idMateriales = idMateriales;
    }

    public String getNombreMateriales() {
        return nombreMateriales;
    }

    public void setNombreMateriales(String nombreMateriales) {
        this.nombreMateriales = nombreMateriales;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> getOrdenesDeTrabajoHasTblProcesosHasTblMaterialesCollection() {
        return ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    }

    public void setOrdenesDeTrabajoHasTblProcesosHasTblMaterialesCollection(Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection) {
        this.ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection = ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    }

    public UnidadesMedida getUnidadesmedidaidUnidadmedida() {
        return unidadesmedidaidUnidadmedida;
    }

    public void setUnidadesmedidaidUnidadmedida(UnidadesMedida unidadesmedidaidUnidadmedida) {
        this.unidadesmedidaidUnidadmedida = unidadesmedidaidUnidadmedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriales != null ? idMateriales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idMateriales == null && other.idMateriales != null) || (this.idMateriales != null && !this.idMateriales.equals(other.idMateriales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Materiales[ idMateriales=" + idMateriales + " ]";
    }
    
}
