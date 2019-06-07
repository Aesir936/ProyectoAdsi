/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.UsuariosHasTblRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aesir936
 */
@Stateless
public class UsuariosHasTblRolesFacade extends AbstractFacade<UsuariosHasTblRoles> implements UsuariosHasTblRolesFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosHasTblRolesFacade() {
        super(UsuariosHasTblRoles.class);
    }
    
}
