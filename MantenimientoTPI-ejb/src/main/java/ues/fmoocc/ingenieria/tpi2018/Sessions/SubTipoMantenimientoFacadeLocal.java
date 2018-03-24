/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;

/**
 *
 * @author yisusdebian
 */
@Local
public interface SubTipoMantenimientoFacadeLocal {

    void create(SubTipoMantenimiento subTipoMantenimiento);

    void edit(SubTipoMantenimiento subTipoMantenimiento);

    void remove(SubTipoMantenimiento subTipoMantenimiento);

    SubTipoMantenimiento find(Object id);

    List<SubTipoMantenimiento> findAll();

    List<SubTipoMantenimiento> findRange(int[] range);

    int count();
    
}
