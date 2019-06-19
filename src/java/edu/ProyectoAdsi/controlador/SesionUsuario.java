package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.entidades.UsuariosHasTblRoles;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private String confirmarContraseña;
    private int direccion;
    private Usuarios usuLog;    
    
    List<Usuarios> lstUsuIn = new ArrayList<>();

    public List<Usuarios> getLstUsuIn() {
        return lstUsuIn;
    }

    public void setLstUsuIn(List<Usuarios> lstUsuIn) {
        this.lstUsuIn = lstUsuIn;
    }
    
    public SesionUsuario() {
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
    
    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    public String registrarUsuario() {
        try {
            if (contraseña.equals(confirmarContraseña)) {
                      
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
                
                usuariosfacadelocal.asignarRol(posicion,3);
                
                PrimeFaces.current().executeScript("registroExitoso('Se ha registrado con exito')");
                           
                }else{
                PrimeFaces.current().executeScript("registroFallido('Usuario ya registrado')");
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
                this.confirmarContraseña = "";
                this.direccion = 0;

            } else {
                PrimeFaces.current().executeScript("registroFallido('Las contraseñas no coinciden')");
            }            
        } catch (Exception e) {
        }
        return "";
    }
        public String inicioSesion( ){
        try {
            this.usuLog = usuariosfacadelocal.iniciarSesion(contraseña, documento);
            String ruta="#";
            if (usuLog !=null) {
                for (UsuariosHasTblRoles objRol : usuLog.getUsuariosHasTblRolesCollection()) {
                    ruta=objRol.getTblRolesIdTblRol().getNombreRol();
                    break;
                }
   
                return "../"+ruta+"/index.xhtml?faces-redirect=true";
                        
            } else {
            PrimeFaces.current().executeScript("loginFallido('Usuario no registrado')");
            return ""; 
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("loginFallido('Usuario no registrado')");
            return "";           
        }
    }
    
//    public void registroUsuario() {
//        Usuarios nuevoUsuario = new Usuarios(direccion, tipoDocumento, documento, primerNombre, segundoNombre, primerApellido, SegundoApellido, nombreEmpresa, nit, correo, telefono, contraseña);
//        this.lstUsuIn.add(nuevoUsuario);
//        this.primerNombre = "";
//        this.contraseña = "";
//        
//        FacesMessage messageRegistro = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha registrado","con éxito"); 
//    } 
   
}

