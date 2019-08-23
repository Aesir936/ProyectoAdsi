package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Ciudades;
import edu.ProyectoAdsi.entidades.Roles;
import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.entidades.UsuariosHasTblRoles;
import edu.ProyectoAdsi.facade.RolesFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import edu.ProyectoAdsi.facade.UsuariosHasTblRolesFacadeLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@Named(value = "cargarUsuariosRequest")
@RequestScoped
public class CargarUsuariosRequest {

    public CargarUsuariosRequest() {
    }

    @EJB
    UsuariosFacadeLocal usuariosfacadelocal;
    @EJB
    RolesFacadeLocal rolesFacadeLocal;
    @EJB
    UsuariosHasTblRolesFacadeLocal usuariosHasTblRolesFacadeLocal;

    private Part archiCarga;
    private List<String> listaCategoria = new ArrayList<>();
    private Usuarios usuLog;

    private String contrasena;
    private String correo;

    public Part getArchiCarga() {
        return archiCarga;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuarios getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuarios usuLog) {
        this.usuLog = usuLog;
    }

    public List<String> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<String> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public void setArchiCarga(Part archiCarga) throws IOException {
        this.archiCarga = archiCarga;
        try {
            InputStreamReader reader = new InputStreamReader(archiCarga.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                listaCategoria.add(line);

                String[] datosUsu = line.split(",");
                Usuarios Usu = new Usuarios();
                int tipoDoc = Integer.parseInt(datosUsu[0]);
                Usu.setTipoDocumento(tipoDoc);
                Usu.setDocumento(datosUsu[1]);
                Usu.setPrimerNombre(datosUsu[2]);
                Usu.setSegundoNombre(datosUsu[3]);
                Usu.setPrimerApellido(datosUsu[4]);
                Usu.setSegundoApellido(datosUsu[5]);
                Usu.setNombreEmpresa(datosUsu[6]);
                Usu.setNit(datosUsu[7]);
                Usu.setCorreo(datosUsu[8]);
                Usu.setTelefono(datosUsu[9]);
                Usu.setContrasena(datosUsu[10]);
                Usu.setDireccion(datosUsu[11]);
                Usu.setEstado(datosUsu[12]);
                int idCiudad = Integer.parseInt(datosUsu[13]);
                Ciudades Ciudad = new Ciudades();
                Ciudad.setIdCiudad(idCiudad);
                Usu.setFkCiudad(Ciudad);
                usuariosfacadelocal.create(Usu);
                
                int idRol = Integer.parseInt(datosUsu[14]);
                Roles rol=rolesFacadeLocal.find(idRol); 

                UsuariosHasTblRoles usurol = new UsuariosHasTblRoles();
                usurol.setTblUsuariosIdUsuarios(Usu);
                usurol.setTblRolesIdTblRol(rol);
                usuariosHasTblRolesFacadeLocal.create(usurol);

            }
        } catch (Exception e) {
        }
    }

    public void validarArchivo(FacesContext fct, UIComponent Componente, Object Archivo) {
        List<FacesMessage> listaMensajes = new ArrayList<>();
        Part Archi = (Part) Archivo;

        if (Archi.getSize() > 1048576) {

            listaMensajes.add(new FacesMessage("El archivo es demasiado grande"));
        }
        if (!"text/plain".equals(Archi.getContentType())) {
            listaMensajes.add(new FacesMessage("El archivo debe poseer la extensión '.txt'"));
        }

        if (!listaMensajes.isEmpty()) {
            throw new ValidatorException((FacesMessage) listaMensajes);
        }
    }

    public List<Usuarios> listaUsuarios() {
        try {
            return usuariosfacadelocal.findAll();
        } catch (Exception e) {
            return null;
        }

    }
}
