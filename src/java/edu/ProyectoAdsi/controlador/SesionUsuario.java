package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Ciudades;
import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.entidades.UsuariosHasTblRoles;
import edu.ProyectoAdsi.facade.CiudadesFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosHasTblRolesFacadeLocal;
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
     @EJB
     CiudadesFacadeLocal ciudadesFacadeLocal; 
     @EJB
     UsuariosHasTblRolesFacadeLocal usuariosHasTblRolesFacadeLocal; 
    
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
    private String direccion;
    private String estado;
    private int ciudad;
    
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuarios usuLog) {
        this.usuLog = usuLog;
    }
       
        
    public String registrarUsuario() {
        try {
            if (contraseña.equals(confirmarContraseña)) {
                
               Ciudades objCiudad = ciudadesFacadeLocal.find(ciudad);
                
                Usuarios nuevoUsu = new Usuarios();
                nuevoUsu.setFkCiudad(objCiudad);
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
                nuevoUsu.setDireccion(direccion);
                
                
                boolean insertUsu = usuariosfacadelocal.insertUsuario(nuevoUsu);
                
                if (insertUsu) {
                                            
                int posicion=usuariosfacadelocal.consultarId(documento);
                
                usuariosfacadelocal.asignarRol(posicion,1);
                
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
                this.direccion = "";

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
   
                return "/"+ruta+"/index.xhtml?faces-redirect=true";
                        
            } else {
            PrimeFaces.current().executeScript("loginFallido('Usuario no registrado')");
            return ""; 
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("loginFallido('Usuario no registrado')");
            return "";           
        }              
    }
        
     //        Método para leer todos los usuarios registrados en la base de datos
            public List<Usuarios> usuarioRegistrados() {

        return usuariosfacadelocal.filtrarUsuarios(documento,nit);
    }
            
//            Método para modificar info de usuario            
             public void actualizarUsuario(){
    
        try {
            usuariosfacadelocal.edit(usuLog);
            PrimeFaces.current().executeScript("estadoOk('" + usuLog.getPrimerNombre() + " " + usuLog.getPrimerApellido()+ "  Datos Actualizados ')");
        } catch (Exception e) {          
           PrimeFaces.current().executeScript("estadoBad('Usuario no actualizado')");
        }
    
    }
             
    //            Método para eliminar usuario     
             
        public void eliminarUsuario(int idUsuario) {

        try {

            usuariosHasTblRolesFacadeLocal.eliminarPermisos(idUsuario);

            usuariosfacadelocal.removerUsuario(idUsuario);

        } 
        catch (Exception e) {
        }

    }
        
         public void cambiarEstado(int id) {

        try {

            Usuarios usuCambiarEStado = usuariosfacadelocal.find(id);

            if (usuCambiarEStado.getEstado().equals("Activo")) {
                usuariosfacadelocal.cambiarEstado(id, "Inactivo");
            } else {
               usuariosfacadelocal.cambiarEstado(id, "Activo");
            }

        } catch (Exception e) {
        }

    }

   
}

