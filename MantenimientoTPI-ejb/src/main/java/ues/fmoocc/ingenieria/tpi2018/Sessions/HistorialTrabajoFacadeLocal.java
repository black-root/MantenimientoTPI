/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.HistorialTrabajo;

/**
 *
 * @author yisusdebian
 */
@Local
public interface HistorialTrabajoFacadeLocal {

    void create(HistorialTrabajo historialTrabajo);

    void edit(HistorialTrabajo historialTrabajo);

    void remove(HistorialTrabajo historialTrabajo);

    HistorialTrabajo find(Object id);

    List<HistorialTrabajo> findAll();

    List<HistorialTrabajo> findRange(int[] range);

    int count();
    
}
