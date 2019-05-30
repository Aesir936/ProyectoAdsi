/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.UnidadesMedida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface UnidadesMedidaFacadeLocal {

    void create(UnidadesMedida unidadesMedida);

    void edit(UnidadesMedida unidadesMedida);

    void remove(UnidadesMedida unidadesMedida);

    UnidadesMedida find(Object id);

    List<UnidadesMedida> findAll();

    List<UnidadesMedida> findRange(int[] range);

    int count();
    
}
