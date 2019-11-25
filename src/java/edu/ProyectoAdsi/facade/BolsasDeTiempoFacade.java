
package edu.ProyectoAdsi.facade;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import edu.ProyectoAdsi.entidades.BolsasDeTiempo;
import java.util.ArrayList;
import java.util.Date;
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
public class BolsasDeTiempoFacade extends AbstractFacade<BolsasDeTiempo> implements BolsasDeTiempoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BolsasDeTiempoFacade() {
        super(BolsasDeTiempo.class);
    }
    
    
    @Override
    public boolean generarBolsa(int idCliente) {
        try {
            Query updateBol = em.createNativeQuery("insert into tbl_bolsas_de_tiempo (horas_restantes,fk_id_usuario) VALUES (0,?1)");
                
            updateBol.setParameter(1,idCliente);
            
            updateBol.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<BolsasDeTiempo> consultarBolsas (int idCliente){
    
    Query consultaBol = em.createNativeQuery("SELECT fecha_activacion,ultima_compra,horas_restantes  FROM tbl_bolsas_de_tiempo  where fk_id_usuario = ?");
    consultaBol.setParameter(1,idCliente);
    List<Object[]> listaResultados = consultaBol.getResultList();
    List<BolsasDeTiempo> lstBolsas = new ArrayList<>();
    
    for (Object[] bolsas : listaResultados) {
                BolsasDeTiempo bolsa = new BolsasDeTiempo();
                bolsa.setFechaActivacion((Date)bolsas[0]);
                bolsa.setUltimaCompra((Integer) bolsas[1]);
                bolsa.setHorasRestantes((Integer) bolsas[2]);                         
                
                lstBolsas.add(bolsa);    
        }
    return lstBolsas;
    }
    
    
    @Override
    public boolean recargarBolsa(int idCliente, int horasRestantes) {
        
        try {           
            
            Query updateBol = em.createNativeQuery("UPDATE tbl_bolsas_de_tiempo SET horas_restantes = ?1 WHERE fk_id_usuario = ?2");
            updateBol.setParameter(1,horasRestantes);
            updateBol.setParameter(2,idCliente);
            updateBol.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
} 

