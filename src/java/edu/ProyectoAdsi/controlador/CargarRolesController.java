package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Roles;
import edu.ProyectoAdsi.facade.RolesFacadeLocal;
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


@Named(value = "cargarRolesController")
@RequestScoped
public class CargarRolesController {

    public CargarRolesController() {
    }
    
    @EJB
    RolesFacadeLocal rolesFacadeLocal;

    private Part archiCarga;
    private List<String> listaRoles = new ArrayList<>();
    
     public Part getArchiCarga() {
        return archiCarga;
    }

    public void setArchiCarga(Part archiCarga) throws IOException {
        this.archiCarga = archiCarga;
        try {
            InputStreamReader reader = new InputStreamReader(archiCarga.getInputStream());
            java.io.BufferedReader br = new java.io.BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                listaRoles.add(line);

                String[] datosRoles = line.split(",");
                Roles usuRoles = new Roles();
                usuRoles.setNombreRol(datosRoles[0]);
                usuRoles.setDescripcionRol(datosRoles[1]);
                
                rolesFacadeLocal.create(usuRoles);
            }
        } catch (Exception e) {

        }

    }

    public List<Roles> listaRoles() {
        try {
            return rolesFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void validarArchivo(FacesContext fct, UIComponent Componente, Object Archivo) {
        List<FacesMessage> listaMensajes = new ArrayList<>();
        Part Archi = (Part) Archivo;

        if (Archi.getSize() > 1024) {

            listaMensajes.add(new FacesMessage("El archivo es demasiado grande"));
        }
        if (!"text/plain".equals(Archi.getContentType())) {
            listaMensajes.add(new FacesMessage("El documento no es .txt"));
        }

        if (!listaMensajes.isEmpty()) {
            throw new ValidatorException((FacesMessage) listaMensajes);
        }
    }

    public List<String> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<String> listaRoles) {
        this.listaRoles = listaRoles;
    }

}
