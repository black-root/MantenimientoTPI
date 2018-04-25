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
import javax.ws.rs.core.Response;
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SubTipoMantenimientoFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("subtipomantenimiento")
public class SubTipoMantenimientoRest implements Serializable {

    @EJB
    private SubTipoMantenimientoFacadeLocal ejbSubTipoMantenimiento;

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
    @Path("/{id:\\d+}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento findById(
            @PathParam("id") int id
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
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (ejbSubTipoMantenimiento.eliminar(ejbSubTipoMantenimiento.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(SubTipoMantenimiento entity) {
        if (ejbSubTipoMantenimiento.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(SubTipoMantenimiento entity) {
        if (ejbSubTipoMantenimiento.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
