/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.OrdenesDeTrabajo;
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
public class OrdenesDeTrabajoFacade extends AbstractFacade<OrdenesDeTrabajo> implements OrdenesDeTrabajoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesDeTrabajoFacade() {
        super(OrdenesDeTrabajo.class);
    }

    @Override
    public boolean insertOT(OrdenesDeTrabajo nuevoOT) {
        try {
            Query insertOT = em.createNativeQuery("insert into tbl_ordenes_de_trabajo (fecha_entrega,tiempo_total_fabricacion,detalle,cantidad_piezas,fk_id_estado,fk_id_cliente) values (?1,?2,?3,?4,1,?5)");

            insertOT.setParameter(1, nuevoOT.getFechaEntrega());
            insertOT.setParameter(2, nuevoOT.getTiempoTotalFabricacion());
            insertOT.setParameter(3, nuevoOT.getDetalle());
            insertOT.setParameter(4, nuevoOT.getCantidadPiezas());
            insertOT.setParameter(5, nuevoOT.getFkIdCliente().getIdUsuarios());

            insertOT.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
        
        
        

    @Override
    public List<OrdenesDeTrabajo> filtrarOT(int idCliente, int estadoOT){
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            String consultar;
            if (idCliente == 0 && estadoOT == 0) {
                consultar = "select * from tbl_ordenes_de_trabajo";
            } else if (idCliente == 0 && estadoOT != 0) {
                consultar = "select * from tbl_ordenes_de_trabajo where tbl_ordenes_de_trabajo.fk_id_estado= '" + estadoOT + "%'";
            } else if (idCliente != 0 && estadoOT != 0) {
                consultar = "select * from tbl_ordenes_de_trabajo where tbl_ordenes_de_trabajo.fk_id_estado= '" + estadoOT + "%' and tbl_ordenes_de_trabajo.fk_id_cliente='" + idCliente + "%' ";
            } else {
                consultar = "SELECT * from tbl_ordenes_de_trabajo where tbl_ordenes_de_trabajo.fk_id_cliente='" + idCliente + "%'";
            }
            Query filtrarOT = em.createNativeQuery(consultar, OrdenesDeTrabajo.class);
            List<OrdenesDeTrabajo> resultadoOT = filtrarOT.getResultList();
            return resultadoOT;
        } catch (Exception e) {
            return null;
        }
    }

}
