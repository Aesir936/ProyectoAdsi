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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_ordenes_de_trabajo_has_tbl_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajoHasTblProcesos.findAll", query = "SELECT o FROM OrdenesDeTrabajoHasTblProcesos o")})
public class OrdenesDeTrabajoHasTblProcesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tbl_ordenes_de_trabajo_has_tbl_procesoscol")
    private Integer pkTblOrdenesDeTrabajoHasTblProcesoscol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrdenesDeTrabajoHasTblProcesos", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    @JoinColumn(name = "id_ordenes_de_trabajo", referencedColumnName = "id_ordenes_de_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajo idOrdenesDeTrabajo;
    @JoinColumn(name = "id_procesos", referencedColumnName = "id_procesos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos idProcesos;

    public OrdenesDeTrabajoHasTblProcesos() {
    }

    public OrdenesDeTrabajoHasTblProcesos(Integer pkTblOrdenesDeTrabajoHasTblProcesoscol) {
        this.pkTblOrdenesDeTrabajoHasTblProcesoscol = pkTblOrdenesDeTrabajoHasTblProcesoscol;
    }

    public Integer getPkTblOrdenesDeTrabajoHasTblProcesoscol() {
        return pkTblOrdenesDeTrabajoHasTblProcesoscol;
    }

    public void setPkTblOrdenesDeTrabajoHasTblProcesoscol(Integer pkTblOrdenesDeTrabajoHasTblProcesoscol) {
        this.pkTblOrdenesDeTrabajoHasTblProcesoscol = pkTblOrdenesDeTrabajoHasTblProcesoscol;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> getOrdenesDeTrabajoHasTblProcesosHasTblMaterialesCollection() {
        return ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    }

    public void setOrdenesDeTrabajoHasTblProcesosHasTblMaterialesCollection(Collection<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection) {
        this.ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection = ordenesDeTrabajoHasTblProcesosHasTblMaterialesCollection;
    }

    public OrdenesDeTrabajo getIdOrdenesDeTrabajo() {
        return idOrdenesDeTrabajo;
    }

    public void setIdOrdenesDeTrabajo(OrdenesDeTrabajo idOrdenesDeTrabajo) {
        this.idOrdenesDeTrabajo = idOrdenesDeTrabajo;
    }

    public Procesos getIdProcesos() {
        return idProcesos;
    }

    public void setIdProcesos(Procesos idProcesos) {
        this.idProcesos = idProcesos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTblOrdenesDeTrabajoHasTblProcesoscol != null ? pkTblOrdenesDeTrabajoHasTblProcesoscol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasTblProcesos)) {
            return false;
        }
        OrdenesDeTrabajoHasTblProcesos other = (OrdenesDeTrabajoHasTblProcesos) object;
        if ((this.pkTblOrdenesDeTrabajoHasTblProcesoscol == null && other.pkTblOrdenesDeTrabajoHasTblProcesoscol != null) || (this.pkTblOrdenesDeTrabajoHasTblProcesoscol != null && !this.pkTblOrdenesDeTrabajoHasTblProcesoscol.equals(other.pkTblOrdenesDeTrabajoHasTblProcesoscol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesos[ pkTblOrdenesDeTrabajoHasTblProcesoscol=" + pkTblOrdenesDeTrabajoHasTblProcesoscol + " ]";
    }
    
}
