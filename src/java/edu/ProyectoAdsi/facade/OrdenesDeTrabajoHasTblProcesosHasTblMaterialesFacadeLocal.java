/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajoHasTblProcesosHasTblMateriales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoHasTblProcesosHasTblMaterialesFacadeLocal {

    void create(OrdenesDeTrabajoHasTblProcesosHasTblMateriales ordenesDeTrabajoHasTblProcesosHasTblMateriales);

    void edit(OrdenesDeTrabajoHasTblProcesosHasTblMateriales ordenesDeTrabajoHasTblProcesosHasTblMateriales);

    void remove(OrdenesDeTrabajoHasTblProcesosHasTblMateriales ordenesDeTrabajoHasTblProcesosHasTblMateriales);

    OrdenesDeTrabajoHasTblProcesosHasTblMateriales find(Object id);

    List<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> findAll();

    List<OrdenesDeTrabajoHasTblProcesosHasTblMateriales> findRange(int[] range);

    int count();
    
}
