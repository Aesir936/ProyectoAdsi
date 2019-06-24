
package edu.ProyectoAdsi.facade;

import edu.ProyectoAdsi.entidades.Usuarios;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UsuariosFacadeLocal {
    

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();

    public int consultarId(String numeroDoc);

    public boolean asignarRol(int usuarioId, int rolId);

    public Usuarios iniciarSesion(String contrasena, String documento);

    public boolean insertUsuario(Usuarios newUser);

    public List<Usuarios> filtrarUsuarios(String documento, String nit);

    
}
