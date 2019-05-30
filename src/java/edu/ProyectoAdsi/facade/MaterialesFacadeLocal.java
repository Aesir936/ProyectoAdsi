/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Materiales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface MaterialesFacadeLocal {

    void create(Materiales materiales);

    void edit(Materiales materiales);

    void remove(Materiales materiales);

    Materiales find(Object id);

    List<Materiales> findAll();

    List<Materiales> findRange(int[] range);

    int count();
    
}
