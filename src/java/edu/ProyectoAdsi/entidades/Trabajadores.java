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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aesir936
 */
@Entity
@Table(name = "tbl_trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_tbl_trabajadorescol")
    private Integer pkTblTrabajadorescol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblTrabajadoresUsuariosIdusuarios", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores> ordenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosIdusuarios;

    public Trabajadores() {
    }

    public Trabajadores(Integer pkTblTrabajadorescol) {
        this.pkTblTrabajadorescol = pkTblTrabajadorescol;
    }

    public Integer getPkTblTrabajadorescol() {
        return pkTblTrabajadorescol;
    }

    public void setPkTblTrabajadorescol(Integer pkTblTrabajadorescol) {
        this.pkTblTrabajadorescol = pkTblTrabajadorescol;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores> getOrdenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection() {
        return ordenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection;
    }

    public void setOrdenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection(Collection<OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores> ordenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection) {
        this.ordenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection = ordenesDeTrabajoHasTblProcesosHasTblTrabajadoresCollection;
    }

    public Usuarios getUsuariosIdusuarios() {
        return usuariosIdusuarios;
    }

    public void setUsuariosIdusuarios(Usuarios usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTblTrabajadorescol != null ? pkTblTrabajadorescol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.pkTblTrabajadorescol == null && other.pkTblTrabajadorescol != null) || (this.pkTblTrabajadorescol != null && !this.pkTblTrabajadorescol.equals(other.pkTblTrabajadorescol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Trabajadores[ pkTblTrabajadorescol=" + pkTblTrabajadorescol + " ]";
    }
    
}
