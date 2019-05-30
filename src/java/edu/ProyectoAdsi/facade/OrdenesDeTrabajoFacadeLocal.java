/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface OrdenesDeTrabajoFacadeLocal {

    void create(OrdenesDeTrabajo ordenesDeTrabajo);

    void edit(OrdenesDeTrabajo ordenesDeTrabajo);

    void remove(OrdenesDeTrabajo ordenesDeTrabajo);

    OrdenesDeTrabajo find(Object id);

    List<OrdenesDeTrabajo> findAll();

    List<OrdenesDeTrabajo> findRange(int[] range);

    int count();
    
}
