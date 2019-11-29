/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.ArchivosAdjuntos;
import edu.ProyectoAdsi.entidades.Cotizaciones;
import java.util.ArrayList;
import java.util.List;
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
    public boolean insertarAdjunto(ArchivosAdjuntos nuevoArchivo) {
        try {
            Query insertAdj = em.createNativeQuery("insert into tbl_archivos_adjuntos (ruta,id_cotizaciones) values (?,?)");

            insertAdj.setParameter(1, nuevoArchivo.getRuta());
            insertAdj.setParameter(2, nuevoArchivo.getIdCotizaciones().getIdCotizaciones());

            insertAdj.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean actualizarAdjunto(ArchivosAdjuntos archivo) {
        try {
            Query updateAdj = em.createNativeQuery("UPDATE tbl_archivos_adjuntos SET id_orden_trabajo = ?1 WHERE id_cotizaciones = ?2");
            updateAdj.setParameter(1, archivo.getIdOrdenTrabajo().getIdOrdenesDeTrabajo());
            updateAdj.setParameter(2, archivo.getIdCotizaciones().getIdCotizaciones());

            updateAdj.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<ArchivosAdjuntos> buscarAdjunto(int idCot) {
        try {
            Query cAdjunto = em.createNativeQuery("select *  from tbl_archivos_adjuntos where id_cotizaciones  = ?1");
            cAdjunto.setParameter(1, idCot);

            List<Object[]> listaResultados = cAdjunto.getResultList();
            List<ArchivosAdjuntos> listaAdjuntos = new ArrayList<>();

            for (Object[] adjuntos : listaResultados) {
                ArchivosAdjuntos adjunto = new ArchivosAdjuntos();
                adjunto.setIdArchivosAdjuntos((Integer) adjuntos[0]);
                adjunto.setRuta((String) adjuntos[1]);
                int idCoti = (int)adjuntos[2];
                Cotizaciones cot = new Cotizaciones();
                cot.setIdCotizaciones(idCoti);
                adjunto.setIdCotizaciones((Cotizaciones) cot);
                adjunto.setIdOrdenTrabajo(null);

                listaAdjuntos.add(adjunto);
            }
            ArchivosAdjuntos adjunto1= listaAdjuntos.get(0);
            return listaAdjuntos;
        } catch (Exception e) {
            return null;
        }

    }

}
