/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoHasProcesosFacadeLocal {

    void create(OrdenesDeTrabajoHasProcesos ordenesDeTrabajoHasProcesos);

    void edit(OrdenesDeTrabajoHasProcesos ordenesDeTrabajoHasProcesos);

    void remove(OrdenesDeTrabajoHasProcesos ordenesDeTrabajoHasProcesos);

    OrdenesDeTrabajoHasProcesos find(Object id);

    List<OrdenesDeTrabajoHasProcesos> findAll();

    List<OrdenesDeTrabajoHasProcesos> findRange(int[] range);

    int count();
    
}
