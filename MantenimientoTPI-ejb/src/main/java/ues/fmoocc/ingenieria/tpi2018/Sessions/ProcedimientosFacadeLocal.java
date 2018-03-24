/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Procedimientos;

/**
 *
 * @author yisusdebian
 */
@Local
public interface ProcedimientosFacadeLocal {

    void create(Procedimientos procedimientos);

    void edit(Procedimientos procedimientos);

    void remove(Procedimientos procedimientos);

    Procedimientos find(Object id);

    List<Procedimientos> findAll();

    List<Procedimientos> findRange(int[] range);

    int count();
    
}
