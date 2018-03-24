/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad;

/**
 *
 * @author yisusdebian
 */
@Local
public interface PrioridadFacadeLocal {

    void create(Prioridad prioridad);

    void edit(Prioridad prioridad);

    void remove(Prioridad prioridad);

    Prioridad find(Object id);

    List<Prioridad> findAll();

    List<Prioridad> findRange(int[] range);

    int count();
    
}
