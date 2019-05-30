/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.ArchivosAdjuntos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface ArchivosAdjuntosFacadeLocal {

    void create(ArchivosAdjuntos archivosAdjuntos);

    void edit(ArchivosAdjuntos archivosAdjuntos);

    void remove(ArchivosAdjuntos archivosAdjuntos);

    ArchivosAdjuntos find(Object id);

    List<ArchivosAdjuntos> findAll();

    List<ArchivosAdjuntos> findRange(int[] range);

    int count();
    
}
