
package edu.ProyectoAdsi.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "idiomaController")
@SessionScoped
public class idiomaController implements Serializable {

    private String idioma="espaniol";

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
   
    public idiomaController() {
    }
    
    public String cambiarIdioma(){
        try{
            if(idioma.equals("espaniol")){
                this.idioma="ingles";
            }
            else{
                this.idioma="espaniol";
            }
            return this.idioma;
        }
        catch (Exception e){
            return "espaniol";
        }
    }
    
    
}
