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
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;
import ues.fmoocc.ingenieria.tpi2018.Sessions.RolFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("rol")
//@Produces({MediaType.APPLICATION_JSON})
public class RolRest implements Serializable {
  
    @EJB
    private RolFacadeLocal ejbRol;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Rol> findall() {
        List salida = null;
        try {
            if (ejbRol != null) {
                return ejbRol.findAll();
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
            if (ejbRol != null) {
                return ejbRol.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (ejbRol.eliminar(ejbRol.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Rol entity) {
        if (ejbRol.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Rol entity) {
        if (ejbRol.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
