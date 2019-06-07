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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_ordenes_de_trabajo_has_tbl_procesos_has_tbl_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajoHasTblProcesosHasTblMateriales.findAll", query = "SELECT o FROM OrdenesDeTrabajoHasTblProcesosHasTblMateriales o")})
public class OrdenesDeTrabajoHasTblProcesosHasTblMateriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pk_tbl_ordenes_de_trabajo_has_tbl_procesos_has_tbl_materialescol")
    private String pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol;
    @JoinColumn(name = "tbl_ordenes_de_trabajo_has_tbl_procesos", referencedColumnName = "pk_tbl_ordenes_de_trabajo_has_tbl_procesoscol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajoHasTblProcesos tblOrdenesDeTrabajoHasTblProcesos;
    @JoinColumn(name = "tbl_materiales_id_materiales", referencedColumnName = "id_materiales")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Materiales tblMaterialesIdMateriales;

    public OrdenesDeTrabajoHasTblProcesosHasTblMateriales() {
    }

    public OrdenesDeTrabajoHasTblProcesosHasTblMateriales(String pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol) {
        this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol = pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol;
    }

    public String getPkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol() {
        return pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol;
    }

    public void setPkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol(String pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol) {
        this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol = pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol;
    }

    public OrdenesDeTrabajoHasTblProcesos getTblOrdenesDeTrabajoHasTblProcesos() {
        return tblOrdenesDeTrabajoHasTblProcesos;
    }

    public void setTblOrdenesDeTrabajoHasTblProcesos(OrdenesDeTrabajoHasTblProcesos tblOrdenesDeTrabajoHasTblProcesos) {
        this.tblOrdenesDeTrabajoHasTblProcesos = tblOrdenesDeTrabajoHasTblProcesos;
    }

    public Materiales getTblMaterialesIdMateriales() {
        return tblMaterialesIdMateriales;
    }

    public void setTblMaterialesIdMateriales(Materiales tblMaterialesIdMateriales) {
        this.tblMaterialesIdMateriales = tblMaterialesIdMateriales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol != null ? pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasTblProcesosHasTblMateriales)) {
            return false;
        }
        OrdenesDeTrabajoHasTblProcesosHasTblMateriales other = (OrdenesDeTrabajoHasTblProcesosHasTblMateriales) object;
        if ((this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol == null && other.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol != null) || (this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol != null && !this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol.equals(other.pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesosHasTblMateriales[ pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol=" + pkTblOrdenesDeTrabajoHasTblProcesosHasTblMaterialescol + " ]";
    }
    
}
