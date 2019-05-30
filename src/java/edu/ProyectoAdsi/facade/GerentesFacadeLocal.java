/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Gerentes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface GerentesFacadeLocal {

    void create(Gerentes gerentes);

    void edit(Gerentes gerentes);

    void remove(Gerentes gerentes);

    Gerentes find(Object id);

    List<Gerentes> findAll();

    List<Gerentes> findRange(int[] range);

    int count();
    
}
