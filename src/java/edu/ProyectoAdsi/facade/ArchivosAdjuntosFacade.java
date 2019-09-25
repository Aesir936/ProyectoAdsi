/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.ArchivosAdjuntos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aesir936
 */
@Stateless
public class ArchivosAdjuntosFacade extends AbstractFacade<ArchivosAdjuntos> implements ArchivosAdjuntosFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchivosAdjuntosFacade() {
        super(ArchivosAdjuntos.class);
    }
    
    
     @Override
    public boolean insertarAdjunto(ArchivosAdjuntos nuevoArchivo){
        try {
            Query insertAdj=em.createNativeQuery("insert into tbl_archivos_adjuntos (ruta,id_cotizacion) values (?,?)");
            
            insertAdj.setParameter(1, nuevoArchivo.getRuta());
            insertAdj.setParameter(2, nuevoArchivo.getIdCotizacion().getIdCotizaciones());
                 
            insertAdj.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }   
    
}
