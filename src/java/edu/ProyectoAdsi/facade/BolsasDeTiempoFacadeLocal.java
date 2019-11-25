/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.BolsasDeTiempo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aesir936
 */
@Local
public interface BolsasDeTiempoFacadeLocal {

    void create(BolsasDeTiempo bolsasDeTiempo);

    void edit(BolsasDeTiempo bolsasDeTiempo);

    void remove(BolsasDeTiempo bolsasDeTiempo);

    BolsasDeTiempo find(Object id);

    List<BolsasDeTiempo> findAll();

    List<BolsasDeTiempo> findRange(int[] range);

    int count();

    public boolean generarBolsa(int idCliente);

    public List<BolsasDeTiempo> consultarBolsas(int idCliente);

    public boolean recargarBolsa(int idCliente, int horasRestantes);
    
}
