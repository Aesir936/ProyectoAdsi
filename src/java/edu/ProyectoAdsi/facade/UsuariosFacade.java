package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
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
    public boolean insertUsuario(Usuarios newUser) {
        try {
            Query insertUsu = em.createNativeQuery("insert into tbl_usuarios (tipo_documento,documento, primer_nombre, segundo_nombre,primer_apellido, \n"
                    + "segundo_apellido,nombre_empresa,nit,correo, telefono, contrasena,direccion,estado,fk_ciudad) values (?,?,?,?,?,?,?,?,?,?,?,?,'Activo',?)");

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
            insertUsu.setParameter(12, newUser.getDireccion());
            insertUsu.setParameter(13, newUser.getFkCiudad().getIdCiudad());

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

    @Override
    public boolean asignarRol(int usuarioId, int rolId) {
        try {
            Query usuRol = em.createNativeQuery("insert into tbl_usuarios_has_tbl_roles (tbl_usuarios_id_usuarios,tbl_roles_id_tbl_rol)  values (?,?);");
            usuRol.setParameter(1, usuarioId);
            usuRol.setParameter(2, rolId);
            usuRol.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuarios iniciarSesion(String contrasena, String documento) {

        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query inicioUsu = em.createQuery("SELECT f FROM Usuarios f WHERE f.contrasena = :usuContrasena AND f.documento = :usuDocumento AND f.estado = 'Activo'");
            inicioUsu.setParameter("usuContrasena", contrasena);
            inicioUsu.setParameter("usuDocumento", documento);
            List<Usuarios> listaResultados = inicioUsu.getResultList();
            if (listaResultados.isEmpty()) {
                return null;
            } else {
                return listaResultados.get(0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> filtrarUsuarios(String documento, String nit) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            String consultar;
            if (documento.trim().equals("") && nit.trim().equals("")) {
                consultar = "select * from tbl_usuarios";
            } else {
                consultar = "select * from tbl_usuarios where documento like '" + documento + "%' and nit like '" + nit + "%' order by documento desc";
            }
            Query filtrarU = em.createNativeQuery(consultar, Usuarios.class);
            List<Usuarios> resultadoC = filtrarU.getResultList();
            return resultadoC;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean removerUsuario(int idUsuario) {

        try {

            Query removerUSu = em.createNativeQuery("DELETE from tbl_usuarios where id_usuarios = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean cambiarEstado(int idUsuario) {

        try {

            Query removerUSu = em.createNativeQuery("DELETE from tbl_usuarios where id_usuarios = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean cambiarEstado(int idUsuario, String estado) {

        try {

            Query removerUSu = em.createNativeQuery("UPDATE tbl_usuarios SET estado = ? where id_usuarios = ?");
            removerUSu.setParameter(1, estado);
            removerUSu.setParameter(2, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Usuarios recuperarContrasena(String documento) {

        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query inicioUsu = em.createQuery("SELECT f FROM Usuarios f WHERE f.documento = :usuDocumento");
            inicioUsu.setParameter("usuDocumento", documento);
            List<Usuarios> listaResultados = inicioUsu.getResultList();
            if (listaResultados.isEmpty()) {
                return null;
            } else {
                return listaResultados.get(0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Método para consultar la lista de usuarios a los que se enviará un correo
     * masivo según el id del rol elegido para su envío.
     *
     * @param idRol
     * @return
     */
    @Override
    public List<Usuarios> listadoDestinatarios(int idRol) {
        try {
            List<Usuarios> lstusuarios = new ArrayList<>();

            em.getEntityManagerFactory().getCache().evictAll();
            Query ConsDest = em.createNativeQuery("SELECT primer_nombre,correo,contrasena FROM tbl_usuarios INNER JOIN tbl_usuarios_has_tbl_roles ON tbl_usuarios.id_usuarios = tbl_usuarios_has_tbl_roles.tbl_usuarios_id_usuarios WHERE tbl_roles_id_tbl_rol = ?");
            ConsDest.setParameter(1, idRol);
            List<Object[]> listaResultados = ConsDest.getResultList();

            for (Object[] usuario : listaResultados) {
                Usuarios usu = new Usuarios();
                usu.setPrimerNombre((String) usuario[0]);
                usu.setCorreo((String) usuario[1]);
                usu.setContrasena((String) usuario[2]);

                lstusuarios.add(usu);
            }

            if (lstusuarios.isEmpty()) {
                return null;
            } else {
                return lstusuarios;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Usuarios> consultarClientes() {
        try {
            Query Clientes = em.createNativeQuery("SELECT * FROM tbl_usuarios INNER JOIN tbl_usuarios_has_tbl_roles ON tbl_usuarios.id_usuarios = tbl_usuarios_has_tbl_roles.tbl_usuarios_id_usuarios WHERE tbl_roles_id_tbl_rol = 4");
             List<Usuarios> lstclientes = new ArrayList<>();
             List<Object[]> listaResult = Clientes.getResultList();
             
             for (Object[] usuario : listaResult) {
                 
                Usuarios usu = new Usuarios();
                
                usu.setPrimerNombre((String) usuario[0]);
//                usu.setOrdenesDeTrabajoCollection(ordenesDeTrabajoCollection);
                
                lstclientes.add(usu);
            }

            if (lstclientes.isEmpty()) {
                return null;
            } else {
                return lstclientes;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public boolean insertOperario(Usuarios newOper) {
        try {
            Query insertOpe = em.createNativeQuery("insert into tbl_usuarios (tipo_documento,documento, primer_nombre, segundo_nombre,primer_apellido, \n"
                    + "segundo_apellido,correo, telefono, contrasena,direccion,estado) values (?,?,?,?,?,?,?,?,?,?,'Activo')");

            insertOpe.setParameter(1, newOper.getTipoDocumento());
            insertOpe.setParameter(2, newOper.getDocumento());
            insertOpe.setParameter(3, newOper.getPrimerNombre());
            insertOpe.setParameter(4, newOper.getSegundoNombre());
            insertOpe.setParameter(5, newOper.getPrimerApellido());
            insertOpe.setParameter(6, newOper.getSegundoApellido());
            insertOpe.setParameter(7, newOper.getCorreo());
            insertOpe.setParameter(8, newOper.getTelefono());
            insertOpe.setParameter(9, newOper.getContrasena());
            insertOpe.setParameter(10, newOper.getDireccion());
            
            insertOpe.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
