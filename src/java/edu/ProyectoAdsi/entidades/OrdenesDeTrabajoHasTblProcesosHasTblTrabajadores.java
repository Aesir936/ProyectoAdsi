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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_ordenes_de_trabajo_has_tbl_procesos_has_tbl_trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores.findAll", query = "SELECT o FROM OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores o")})
public class OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_tbl_ordenes_de_trabajo_has_tbl_procesos_has_tbl_trabajadores")
    private Integer pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores;
    @JoinColumn(name = "tbl_ordenes_de_trabajo_has_tbl_procesoscol", referencedColumnName = "pk_tbl_ordenes_de_trabajo_has_tbl_procesoscol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenesDeTrabajoHasTblProcesos tblOrdenesDeTrabajoHasTblProcesoscol;
    @JoinColumn(name = "tbl_trabajadores_usuarios_idusuarios", referencedColumnName = "usuarios_idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trabajadores tblTrabajadoresUsuariosIdusuarios;

    public OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores() {
    }

    public OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores(Integer pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores) {
        this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores = pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores;
    }

    public Integer getPkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores() {
        return pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores;
    }

    public void setPkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores(Integer pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores) {
        this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores = pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores;
    }

    public OrdenesDeTrabajoHasTblProcesos getTblOrdenesDeTrabajoHasTblProcesoscol() {
        return tblOrdenesDeTrabajoHasTblProcesoscol;
    }

    public void setTblOrdenesDeTrabajoHasTblProcesoscol(OrdenesDeTrabajoHasTblProcesos tblOrdenesDeTrabajoHasTblProcesoscol) {
        this.tblOrdenesDeTrabajoHasTblProcesoscol = tblOrdenesDeTrabajoHasTblProcesoscol;
    }

    public Trabajadores getTblTrabajadoresUsuariosIdusuarios() {
        return tblTrabajadoresUsuariosIdusuarios;
    }

    public void setTblTrabajadoresUsuariosIdusuarios(Trabajadores tblTrabajadoresUsuariosIdusuarios) {
        this.tblTrabajadoresUsuariosIdusuarios = tblTrabajadoresUsuariosIdusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores != null ? pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores)) {
            return false;
        }
        OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores other = (OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores) object;
        if ((this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores == null && other.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores != null) || (this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores != null && !this.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores.equals(other.pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores[ pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores=" + pkTblOrdenesDeTrabajoHasTblProcesosHasTblTrabajadores + " ]";
    }
    
}
