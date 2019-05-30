/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.EstadosCotizaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface EstadosCotizacionesFacadeLocal {

    void create(EstadosCotizaciones estadosCotizaciones);

    void edit(EstadosCotizaciones estadosCotizaciones);

    void remove(EstadosCotizaciones estadosCotizaciones);

    EstadosCotizaciones find(Object id);

    List<EstadosCotizaciones> findAll();

    List<EstadosCotizaciones> findRange(int[] range);

    int count();
    
}
