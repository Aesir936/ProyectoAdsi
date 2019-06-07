/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoHasTblProcesosHasTblTrabajadoresFacadeLocal {

    void create(OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores ordenesDeTrabajoHasTblProcesosHasTblTrabajadores);

    void edit(OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores ordenesDeTrabajoHasTblProcesosHasTblTrabajadores);

    void remove(OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores ordenesDeTrabajoHasTblProcesosHasTblTrabajadores);

    OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores find(Object id);

    List<OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores> findAll();

    List<OrdenesDeTrabajoHasTblProcesosHasTblTrabajadores> findRange(int[] range);

    int count();
    
}
