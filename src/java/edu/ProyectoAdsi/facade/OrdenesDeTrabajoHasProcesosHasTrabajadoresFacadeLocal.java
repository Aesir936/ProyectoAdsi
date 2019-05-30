/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasProcesosHasTrabajadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoHasProcesosHasTrabajadoresFacadeLocal {

    void create(OrdenesDeTrabajoHasProcesosHasTrabajadores ordenesDeTrabajoHasProcesosHasTrabajadores);

    void edit(OrdenesDeTrabajoHasProcesosHasTrabajadores ordenesDeTrabajoHasProcesosHasTrabajadores);

    void remove(OrdenesDeTrabajoHasProcesosHasTrabajadores ordenesDeTrabajoHasProcesosHasTrabajadores);

    OrdenesDeTrabajoHasProcesosHasTrabajadores find(Object id);

    List<OrdenesDeTrabajoHasProcesosHasTrabajadores> findAll();

    List<OrdenesDeTrabajoHasProcesosHasTrabajadores> findRange(int[] range);

    int count();
    
}
