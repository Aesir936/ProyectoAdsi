
package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

@Named(value = "sesionUsuario")
@SessionScoped
public class SesionUsuario implements Serializable {
    
     @EJB
     UsuariosFacadeLocal usuariosfacadelocal; 
    
    private int tipoDocumento;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String SegundoApellido;
    private String nombreEmpresa;
    private String nit;
    private String correo;
    private String telefono;
    private String contraseña;
    private int direccion;    
   
    public SesionUsuario() {
    }

    public SesionUsuario(int tipoDocumento, String documento, String primerNombre, String segundoNombre, String primerApellido, String SegundoApellido, String nombreEmpresa, String nit, String correo, String telefono, String contraseña, int direccion) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.SegundoApellido = SegundoApellido;
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.direccion = direccion;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    public String registrarUsuario() {
        try {
            Usuarios nuevoUsu = new Usuarios();
            nuevoUsu.setTipoDocumento(tipoDocumento);
            nuevoUsu.setDocumento(documento);
            nuevoUsu.setPrimerNombre(primerNombre);
            nuevoUsu.setSegundoNombre(segundoNombre);
            nuevoUsu.setPrimerApellido(primerApellido);
            nuevoUsu.setSegundoApellido(SegundoApellido);
            nuevoUsu.setNombreEmpresa(nombreEmpresa);
            nuevoUsu.setNit(nit);
            nuevoUsu.setCorreo(correo);
            nuevoUsu.setTelefono(telefono);
            nuevoUsu.setContrasena(contraseña);
            
            
            
            boolean insertUsu = usuariosfacadelocal.insertUsuario(nuevoUsu);
            if (insertUsu) {
                int posicion=usuariosfacadelocal.consultarId(documento);
                boolean resultado=usuariosfacadelocal.asignarRol(posicion,3);
                        resultado=usuariosfacadelocal.asignarRol(posicion,1);
                
                
            PrimeFaces.current().executeScript("estadoOk('" + primerNombre + " " + primerApellido + "')");           
            }else{
            PrimeFaces.current().executeScript("estadoBad('Usuario ya registrado')");
            }  

            this.tipoDocumento = 0;
            this.documento = "";
            this.primerNombre = "";
            this.segundoNombre = "";
            this.primerApellido = "";
            this.SegundoApellido = "";
            this.nombreEmpresa = "";
            this.nit = "";
            this.correo = "";
            this.telefono = "";
            this.contraseña = "";
            this.direccion = 0;

        } catch (Exception e) {
            PrimeFaces.current().executeScript("estadoBad('" + primerNombre + " " + primerApellido + "')");
        }
        return "";
    }

}

