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
import javax.persistence.Query;

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
    
    @Override
    public boolean eliminarPermisos(int idUsuario) {

        try {

            Query removerUSu = em.createNativeQuery("DELETE from tbl_usuarios_has_tbl_roles where tbl_usuarios_id_usuarios = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
