/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.fmoocc.ingenieria.tpi2018.Entities.HistorialTrabajo;

/**
 *
 * @author yisusdebian
 */
@Stateless
public class HistorialTrabajoFacade extends AbstractFacade<HistorialTrabajo> implements HistorialTrabajoFacadeLocal {

    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialTrabajoFacade() {
        super(HistorialTrabajo.class);
    }
    
}
