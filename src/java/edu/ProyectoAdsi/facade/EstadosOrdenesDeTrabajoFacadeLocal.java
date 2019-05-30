/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.EstadosOrdenesDeTrabajo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface EstadosOrdenesDeTrabajoFacadeLocal {

    void create(EstadosOrdenesDeTrabajo estadosOrdenesDeTrabajo);

    void edit(EstadosOrdenesDeTrabajo estadosOrdenesDeTrabajo);

    void remove(EstadosOrdenesDeTrabajo estadosOrdenesDeTrabajo);

    EstadosOrdenesDeTrabajo find(Object id);

    List<EstadosOrdenesDeTrabajo> findAll();

    List<EstadosOrdenesDeTrabajo> findRange(int[] range);

    int count();
    
}
