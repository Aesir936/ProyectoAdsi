package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Cotizaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface CotizacionesFacadeLocal {

    void create(Cotizaciones cotizaciones);

    void edit(Cotizaciones cotizaciones);

    void remove(Cotizaciones cotizaciones);

    Cotizaciones find(Object id);

    List<Cotizaciones> findAll();

    List<Cotizaciones> findRange(int[] range);

    int count();

    public boolean crearCotizacion(Cotizaciones newCot);

    public List<Cotizaciones> filtrarCotizaciones(int idCliente, int estadoCot);

    public boolean generarCotizacion(Cotizaciones cotGenerada);

    public boolean rechazarCot(int idCot, String comentario);

    public boolean aprobarCotCliente(int idCot);

    public boolean rechazarCotCliente(String comentario, int idCot);
    
    
}
