package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Cotizaciones;
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
public class CotizacionesFacade extends AbstractFacade<Cotizaciones> implements CotizacionesFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionesFacade() {
        super(Cotizaciones.class);
    }

    @Override
    public boolean crearCotizacion(Cotizaciones newCot) {
        try {
            Query insertCot = em.createNativeQuery("insert into tbl_cotizaciones (detalle, fecha_entrega, cantidad_piezas, id_estado_cotizacion, fk_id_cliente) values (?1,?2,?3,1,?5)");

            insertCot.setParameter(1, newCot.getDetalle());
            insertCot.setParameter(2, newCot.getFechaEntrega());
            insertCot.setParameter(3, newCot.getCantidadPiezas());
            insertCot.setParameter(5, newCot.getFkIdCliente().getIdUsuarios());

            insertCot.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Cotizaciones> filtrarCotizaciones(int idCliente, int estadoCot) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            String consultar;
            if (idCliente == 0 && estadoCot == 0) {
                consultar = "select * from tbl_cotizaciones";
            } else if (idCliente == 0 && estadoCot != 0) {
                consultar = "select * from tbl_cotizaciones where tbl_cotizaciones.id_estado_cotizacion= '" + estadoCot + "%'";
            } else if (idCliente != 0 && estadoCot != 0) {
                consultar = "select * from tbl_cotizaciones where tbl_cotizaciones.id_estado_cotizacion= '" + estadoCot + "%' and tbl_cotizaciones.fk_id_cliente='" + idCliente + "%' ";
            } else {
                consultar = "SELECT * FROM db_siim.tbl_cotizaciones where tbl_cotizaciones.fk_id_cliente= '" + idCliente + "%'";
            }
            Query filtrarCot = em.createNativeQuery(consultar, Cotizaciones.class);
            List<Cotizaciones> resultadoCot = filtrarCot.getResultList();
            return resultadoCot;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean generarCotizacion(Cotizaciones cotGenerada) {
        try {
            Query updateCot = em.createNativeQuery("UPDATE tbl_cotizaciones SET valor_unitario = ?1, valor_total = ?2, comentarios = ?3,horas_fabricacion = ?4, id_estado_cotizacion = 2 WHERE id_cotizaciones  =?5");

            updateCot.setParameter(1, cotGenerada.getValorUnitario());
            updateCot.setParameter(2, cotGenerada.getValorTotal());
            updateCot.setParameter(3, cotGenerada.getComentarios());
            updateCot.setParameter(4, cotGenerada.getHorasFabricacion());
            updateCot.setParameter(5, cotGenerada.getIdCotizaciones());

            updateCot.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean rechazarCot(int idCot, String comentario) {
        try {
            Query rCot = em.createNativeQuery("UPDATE tbl_cotizaciones SET comentarios = ?1, id_estado_cotizacion = 4 WHERE id_cotizaciones = ?2");
            rCot.setParameter(1, comentario);
            rCot.setParameter(2, idCot);

            rCot.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean aprobarCotCliente(int idCot) {
        try {
            Query actualizarCot = em.createNativeQuery("UPDATE tbl_cotizaciones SET id_estado_cotizacion = 3 WHERE id_cotizaciones = ?1");
            actualizarCot.setParameter(1, idCot);

            actualizarCot.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

//    Método para registrar una cotización rechazada por el cliente y el comentario dejado por él
    @Override
    public boolean rechazarCotCliente(String comentario, int idCot) {
        try {
            Query actualizarCot = em.createNativeQuery("UPDATE tbl_cotizaciones SET id_estado_cotizacion = 5, comentario_cliente = ?1 WHERE id_cotizaciones  = ?2");
            actualizarCot.setParameter(1, comentario);
            actualizarCot.setParameter(2, idCot);

            actualizarCot.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
