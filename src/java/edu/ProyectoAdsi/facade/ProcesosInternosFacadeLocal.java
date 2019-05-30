/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.ProcesosInternos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface ProcesosInternosFacadeLocal {

    void create(ProcesosInternos procesosInternos);

    void edit(ProcesosInternos procesosInternos);

    void remove(ProcesosInternos procesosInternos);

    ProcesosInternos find(Object id);

    List<ProcesosInternos> findAll();

    List<ProcesosInternos> findRange(int[] range);

    int count();
    
}
