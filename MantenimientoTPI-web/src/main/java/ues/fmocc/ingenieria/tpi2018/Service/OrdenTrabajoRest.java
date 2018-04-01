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
import ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo;
import ues.fmoocc.ingenieria.tpi2018.Sessions.OrdenTrabajoFacadeLocal;


/**
 *
 * @author yisusdebian
 */
@Path("ordentrabajo")
public class OrdenTrabajoRest implements Serializable {
    @EJB
    private OrdenTrabajoFacadeLocal ejbOrdenTrabajo;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<OrdenTrabajo> findall() {
        List salida = null;
        try {
            if (ejbOrdenTrabajo != null) {
                return ejbOrdenTrabajo.findAll();
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
            if (ejbOrdenTrabajo != null) {
                return ejbOrdenTrabajo.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajo findById(
            @PathParam("id") Integer id
    ) {
        try {
            if (ejbOrdenTrabajo != null) {
                return ejbOrdenTrabajo.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new OrdenTrabajo();
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbOrdenTrabajo != null) {
                ejbOrdenTrabajo.remove(ejbOrdenTrabajo.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrdenTrabajo entity) {

        try {
            if (this.ejbOrdenTrabajo != null) {
                ejbOrdenTrabajo.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, OrdenTrabajo entity) {

        try {
            if (this.ejbOrdenTrabajo != null) {
                ejbOrdenTrabajo.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
