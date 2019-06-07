/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.UsuariosHasTblRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface UsuariosHasTblRolesFacadeLocal {

    void create(UsuariosHasTblRoles usuariosHasTblRoles);

    void edit(UsuariosHasTblRoles usuariosHasTblRoles);

    void remove(UsuariosHasTblRoles usuariosHasTblRoles);

    UsuariosHasTblRoles find(Object id);

    List<UsuariosHasTblRoles> findAll();

    List<UsuariosHasTblRoles> findRange(int[] range);

    int count();
    
}
