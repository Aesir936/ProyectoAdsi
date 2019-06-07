
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    @Override
    public boolean insertUsuario(Usuarios newUser){
        try {
            Query insertUsu=em.createNativeQuery("insert into tbl_usuarios (tipo_documento,documento, primer_nombre, segundo_nombre,primer_apellido, \n" +
            "segundo_apellido,nombre_empresa,nit,correo, telefono, contrasena,id_tbl_direccion)values (?,?,?,?,?,?,?,?,?,?,?,1)");
            
            insertUsu.setParameter(1, newUser.getTipoDocumento());
            insertUsu.setParameter(2, newUser.getDocumento());
            insertUsu.setParameter(3, newUser.getPrimerNombre());
            insertUsu.setParameter(4, newUser.getSegundoNombre());
            insertUsu.setParameter(5, newUser.getPrimerApellido());
            insertUsu.setParameter(6, newUser.getSegundoApellido());
            insertUsu.setParameter(7, newUser.getNombreEmpresa());
            insertUsu.setParameter(8, newUser.getNit());
            insertUsu.setParameter(9, newUser.getCorreo());
            insertUsu.setParameter(10, newUser.getTelefono());
            insertUsu.setParameter(11, newUser.getContrasena());
            
            
            insertUsu.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
       @Override
    public int consultarId(String numeroDoc) {
        try {
            Query cUsuario = em.createNativeQuery("select id_usuarios from tbl_usuarios where documento  = ?");
            cUsuario.setParameter(1, numeroDoc);
            int posicion = (int) cUsuario.getSingleResult();
            return posicion;
        } catch (Exception e) {
            return 0;
        }
    }
}
