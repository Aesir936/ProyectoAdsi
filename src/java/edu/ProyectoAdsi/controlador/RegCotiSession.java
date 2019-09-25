
package edu.ProyectoAdsi.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Aesir936
 */
@Named(value = "regCotiSession")
@SessionScoped
public class RegCotiSession implements Serializable {

    /**
     * Creates a new instance of RegCotiSession
     */
    public RegCotiSession() {
    }
    
}
