/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Equipodetalle;

/**
 *
 * @author yisusdebian
 */
@Local
public interface EquipodetalleFacadeLocal {

    void create(Equipodetalle equipodetalle);

    void edit(Equipodetalle equipodetalle);

    void remove(Equipodetalle equipodetalle);

    Equipodetalle find(Object id);

    List<Equipodetalle> findAll();

    List<Equipodetalle> findRange(int[] range);

    int count();
    
}
