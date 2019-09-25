
package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Ciudades;
import edu.ProyectoAdsi.facade.CiudadesFacadeLocal;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "cargarCiudadesController")
@RequestScoped
public class CargarCiudadesController {

    public CargarCiudadesController() {
    }
    
    @EJB
    CiudadesFacadeLocal ciudadesFacadeLocal;

    private Part archiCarga;
    private List<String> listaCiudades = new ArrayList<>();
    
     public Part getArchiCarga() {
        return archiCarga;
    }
     
    public List<String> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<String> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public void setArchiCarga(Part archiCarga) throws IOException {
        this.archiCarga = archiCarga;
        try {
            InputStreamReader reader = new InputStreamReader(archiCarga.getInputStream());
            java.io.BufferedReader br = new java.io.BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                listaCiudades.add(line);

                String[] datosCiudades = line.split(",");
                Ciudades objCiudad = new Ciudades();
                int idCiudad = Integer.parseInt(datosCiudades[0]);
                objCiudad.setIdCiudad(idCiudad);
                objCiudad.setNombreCiudad(datosCiudades[1]);
                
                
                ciudadesFacadeLocal.create(objCiudad);
            }
        } catch (Exception e) {

        }

    }

    public List<Ciudades> listaCiudades() {
        try {
            return ciudadesFacadeLocal.findAll();
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

}
