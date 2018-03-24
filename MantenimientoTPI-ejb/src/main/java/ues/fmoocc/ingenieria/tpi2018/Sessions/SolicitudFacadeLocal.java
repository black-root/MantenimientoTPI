/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;

/**
 *
 * @author yisusdebian
 */
@Local
public interface SolicitudFacadeLocal {

    void create(Solicitud solicitud);

    void edit(Solicitud solicitud);

    void remove(Solicitud solicitud);

    Solicitud find(Object id);

    List<Solicitud> findAll();

    List<Solicitud> findRange(int[] range);

    int count();
    
}
