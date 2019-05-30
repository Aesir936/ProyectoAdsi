/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Procesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface ProcesosFacadeLocal {

    void create(Procesos procesos);

    void edit(Procesos procesos);

    void remove(Procesos procesos);

    Procesos find(Object id);

    List<Procesos> findAll();

    List<Procesos> findRange(int[] range);

    int count();
    
}
