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
import ues.fmoocc.ingenieria.tpi2018.Entities.Unidad;
import ues.fmoocc.ingenieria.tpi2018.Sessions.UnidadFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("unidad")
public class UnidadRest implements Serializable {

    @EJB
    private UnidadFacadeLocal ejbUnidad;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Unidad> findall() {
        List salida = null;
        try {
            if (ejbUnidad != null) {
                return ejbUnidad.findAll();
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
            if (ejbUnidad != null) {
                return ejbUnidad.count();
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
    public Unidad findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbUnidad != null) {
                return ejbUnidad.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Unidad();
    }

    @GET
    @Path("/{nombre}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Unidad> findByNombre(@PathParam("nombre") String nombre) {
        try {
            if (ejbUnidad != null) {
                return ejbUnidad.findWithNombre(nombre);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }

    
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (ejbUnidad.eliminar(ejbUnidad.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Unidad entity) {
        if (ejbUnidad.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Unidad entity) {
        if (ejbUnidad.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
