/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoHasTblProcesosFacadeLocal {

    void create(OrdenesDeTrabajoHasTblProcesos ordenesDeTrabajoHasTblProcesos);

    void edit(OrdenesDeTrabajoHasTblProcesos ordenesDeTrabajoHasTblProcesos);

    void remove(OrdenesDeTrabajoHasTblProcesos ordenesDeTrabajoHasTblProcesos);

    OrdenesDeTrabajoHasTblProcesos find(Object id);

    List<OrdenesDeTrabajoHasTblProcesos> findAll();

    List<OrdenesDeTrabajoHasTblProcesos> findRange(int[] range);

    int count();
    
}
