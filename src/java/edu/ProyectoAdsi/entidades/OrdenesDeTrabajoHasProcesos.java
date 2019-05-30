/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "ordenes_de_trabajo_has_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajoHasProcesos.findAll", query = "SELECT o FROM OrdenesDeTrabajoHasProcesos o")})
public class OrdenesDeTrabajoHasProcesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesDeTrabajoHasProcesosPK ordenesDeTrabajoHasProcesosPK;
    @ManyToMany(mappedBy = "ordenesDeTrabajoHasProcesosCollection", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
    @JoinColumn(name = "id_ordenes_de_trabajo", referencedColumnName = "id_ordenes_de_trabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajo ordenesDeTrabajo;
    @JoinColumn(name = "id_procesos", referencedColumnName = "id_procesos", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procesos procesos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesDeTrabajoHasProcesos", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasProcesosHasTrabajadores> ordenesDeTrabajoHasProcesosHasTrabajadoresCollection;

    public OrdenesDeTrabajoHasProcesos() {
    }

    public OrdenesDeTrabajoHasProcesos(OrdenesDeTrabajoHasProcesosPK ordenesDeTrabajoHasProcesosPK) {
        this.ordenesDeTrabajoHasProcesosPK = ordenesDeTrabajoHasProcesosPK;
    }

    public OrdenesDeTrabajoHasProcesos(int idOrdenesDeTrabajo, int idProcesos) {
        this.ordenesDeTrabajoHasProcesosPK = new OrdenesDeTrabajoHasProcesosPK(idOrdenesDeTrabajo, idProcesos);
    }

    public OrdenesDeTrabajoHasProcesosPK getOrdenesDeTrabajoHasProcesosPK() {
        return ordenesDeTrabajoHasProcesosPK;
    }

    public void setOrdenesDeTrabajoHasProcesosPK(OrdenesDeTrabajoHasProcesosPK ordenesDeTrabajoHasProcesosPK) {
        this.ordenesDeTrabajoHasProcesosPK = ordenesDeTrabajoHasProcesosPK;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

    public OrdenesDeTrabajo getOrdenesDeTrabajo() {
        return ordenesDeTrabajo;
    }

    public void setOrdenesDeTrabajo(OrdenesDeTrabajo ordenesDeTrabajo) {
        this.ordenesDeTrabajo = ordenesDeTrabajo;
    }

    public Procesos getProcesos() {
        return procesos;
    }

    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasProcesosHasTrabajadores> getOrdenesDeTrabajoHasProcesosHasTrabajadoresCollection() {
        return ordenesDeTrabajoHasProcesosHasTrabajadoresCollection;
    }

    public void setOrdenesDeTrabajoHasProcesosHasTrabajadoresCollection(Collection<OrdenesDeTrabajoHasProcesosHasTrabajadores> ordenesDeTrabajoHasProcesosHasTrabajadoresCollection) {
        this.ordenesDeTrabajoHasProcesosHasTrabajadoresCollection = ordenesDeTrabajoHasProcesosHasTrabajadoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenesDeTrabajoHasProcesosPK != null ? ordenesDeTrabajoHasProcesosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasProcesos)) {
            return false;
        }
        OrdenesDeTrabajoHasProcesos other = (OrdenesDeTrabajoHasProcesos) object;
        if ((this.ordenesDeTrabajoHasProcesosPK == null && other.ordenesDeTrabajoHasProcesosPK != null) || (this.ordenesDeTrabajoHasProcesosPK != null && !this.ordenesDeTrabajoHasProcesosPK.equals(other.ordenesDeTrabajoHasProcesosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesos[ ordenesDeTrabajoHasProcesosPK=" + ordenesDeTrabajoHasProcesosPK + " ]";
    }
    
}
