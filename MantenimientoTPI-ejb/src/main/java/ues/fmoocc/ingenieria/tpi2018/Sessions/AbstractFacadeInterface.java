package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;

/**
 *
 * @author yisusdebian
 */
public interface AbstractFacadeInterface <T> {

    T create(T entity);

    T edit(T entity);

    T remove(T entity);

    boolean crear(T entity);

    boolean modificar(T entity);

    boolean eliminar(T entity);

    T find(Object id);

    List <T> findAll();

    List <T> findRange(int lower, int higher);

    int count();

    List <T> findWithDescripcion(String namedQueryName, String name);

    List <T> findWithNombre(String namedQueryName, String name);  
}