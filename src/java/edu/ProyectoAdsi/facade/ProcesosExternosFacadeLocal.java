/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.ProcesosExternos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface ProcesosExternosFacadeLocal {

    void create(ProcesosExternos procesosExternos);

    void edit(ProcesosExternos procesosExternos);

    void remove(ProcesosExternos procesosExternos);

    ProcesosExternos find(Object id);

    List<ProcesosExternos> findAll();

    List<ProcesosExternos> findRange(int[] range);

    int count();
    
}
