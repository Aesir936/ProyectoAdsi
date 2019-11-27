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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuarios")
    private Integer idUsuarios;
    @Size(max = 20)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 45)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 20)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "fkIdUsuario", fetch = FetchType.LAZY)
    private Collection<BolsasDeTiempo> bolsasDeTiempoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCliente", fetch = FetchType.LAZY)
    private Collection<Cotizaciones> cotizacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUsuariosIdUsuarios", fetch = FetchType.LAZY)
    private Collection<UsuariosHasTblRoles> usuariosHasTblRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCliente", fetch = FetchType.LAZY)
    private Collection<OrdenesDeTrabajo> ordenesDeTrabajoCollection;
    @JoinColumn(name = "fk_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDocumento fkTipoDocumento;
    @JoinColumn(name = "fk_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ciudades fkCiudad;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuarios(Integer idUsuarios, String primerNombre, String primerApellido, String correo, String telefono, String contrasena, String direccion) {
        this.idUsuarios = idUsuarios;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<BolsasDeTiempo> getBolsasDeTiempoCollection() {
        return bolsasDeTiempoCollection;
    }

    public void setBolsasDeTiempoCollection(Collection<BolsasDeTiempo> bolsasDeTiempoCollection) {
        this.bolsasDeTiempoCollection = bolsasDeTiempoCollection;
    }

    @XmlTransient
    public Collection<Cotizaciones> getCotizacionesCollection() {
        return cotizacionesCollection;
    }

    public void setCotizacionesCollection(Collection<Cotizaciones> cotizacionesCollection) {
        this.cotizacionesCollection = cotizacionesCollection;
    }

    @XmlTransient
    public Collection<UsuariosHasTblRoles> getUsuariosHasTblRolesCollection() {
        return usuariosHasTblRolesCollection;
    }

    public void setUsuariosHasTblRolesCollection(Collection<UsuariosHasTblRoles> usuariosHasTblRolesCollection) {
        this.usuariosHasTblRolesCollection = usuariosHasTblRolesCollection;
    }

    @XmlTransient
    public Collection<OrdenesDeTrabajo> getOrdenesDeTrabajoCollection() {
        return ordenesDeTrabajoCollection;
    }

    public void setOrdenesDeTrabajoCollection(Collection<OrdenesDeTrabajo> ordenesDeTrabajoCollection) {
        this.ordenesDeTrabajoCollection = ordenesDeTrabajoCollection;
    }

    public TiposDocumento getFkTipoDocumento() {
        return fkTipoDocumento;
    }

    public void setFkTipoDocumento(TiposDocumento fkTipoDocumento) {
        this.fkTipoDocumento = fkTipoDocumento;
    }

    public Ciudades getFkCiudad() {
        return fkCiudad;
    }

    public void setFkCiudad(Ciudades fkCiudad) {
        this.fkCiudad = fkCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ProyectoAdsi.entidades.Usuarios[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
