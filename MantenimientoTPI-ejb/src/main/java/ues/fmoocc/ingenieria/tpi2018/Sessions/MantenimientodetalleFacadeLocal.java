/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Mantenimientodetalle;

/**
 *
 * @author yisusdebian
 */
@Local
public interface MantenimientodetalleFacadeLocal {

    void create(Mantenimientodetalle mantenimientodetalle);

    void edit(Mantenimientodetalle mantenimientodetalle);

    void remove(Mantenimientodetalle mantenimientodetalle);

    Mantenimientodetalle find(Object id);

    List<Mantenimientodetalle> findAll();

    List<Mantenimientodetalle> findRange(int[] range);

    int count();
    
}
