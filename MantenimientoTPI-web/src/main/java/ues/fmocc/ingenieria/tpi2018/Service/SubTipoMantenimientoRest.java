/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SubTipoMantenimientoFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("subtipomantenimiento")
public class SubTipoMantenimientoRest implements Serializable  {
     @EJB
    private SubTipoMantenimientoFacadeLocal ejbSubTipoMantenimiento;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<SubTipoMantenimiento> findall() {
        List salida = null;
        try {
            if (ejbSubTipoMantenimiento != null) {
                return ejbSubTipoMantenimiento.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return salida;
    }

    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbSubTipoMantenimiento != null) {
                return ejbSubTipoMantenimiento.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    //busca uno en particular
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento findById(
            @PathParam("id") Integer id
    ) {
        try {
            if (ejbSubTipoMantenimiento != null) {
                return ejbSubTipoMantenimiento.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new SubTipoMantenimiento();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbSubTipoMantenimiento!= null) {
                ejbSubTipoMantenimiento.remove(ejbSubTipoMantenimiento.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(SubTipoMantenimiento entity) {

        try {
            if (this.ejbSubTipoMantenimiento != null) {
                ejbSubTipoMantenimiento.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, SubTipoMantenimiento entity) {

        try {
            if (this.ejbSubTipoMantenimiento != null) {
                ejbSubTipoMantenimiento.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
