/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.EstadosOrdenesDeTrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aesir936
 */
@Stateless
public class EstadosOrdenesDeTrabajoFacade extends AbstractFacade<EstadosOrdenesDeTrabajo> implements EstadosOrdenesDeTrabajoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosOrdenesDeTrabajoFacade() {
        super(EstadosOrdenesDeTrabajo.class);
    }
    
}
