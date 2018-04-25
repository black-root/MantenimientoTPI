package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;

/**
 *
 * @author yisusdebian
 */
//Ronald Ibanez
@Path("solicitud")
public class SolicitudRest implements Serializable {

    @EJB
    private SolicitudFacadeLocal ejbSolicitud;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findall() {
        List salida = null;
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.findAll();
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
            if (ejbSolicitud != null) {
                return ejbSolicitud.count();
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
    public Solicitud findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Solicitud();
    }
    
    @GET
    @Path("/{nombre}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Solicitud> findBySolicitud(@PathParam("nombre") String nombre){
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.findWithNombre(nombre);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }
   
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (ejbSolicitud.eliminar(ejbSolicitud.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Solicitud entity) {
        if (ejbSolicitud.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Solicitud entity) {
        if (ejbSolicitud.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
