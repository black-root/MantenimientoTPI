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
import ues.fmoocc.ingenieria.tpi2018.Entities.Personal;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PersonalFacadeLocal;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("personal")
public class PersonalRest implements Serializable {

    @EJB
    private PersonalFacadeLocal ejbPersonal;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal> findall() {
        List salida = null;
        try {
            if (ejbPersonal != null) {
                return ejbPersonal.findAll();
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
            if (ejbPersonal != null) {
                return ejbPersonal.count();
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
    public Personal findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbPersonal != null) {
                return ejbPersonal.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Personal();
    }

    @GET
    @Path("/{nombre}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Personal> findByNombre(@PathParam("nombre") String nombre) {
        try {
            if (ejbPersonal != null) {
                return ejbPersonal.findWithNombre(nombre);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }

    
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (ejbPersonal.eliminar(ejbPersonal.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Personal entity) {
        if (ejbPersonal.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Personal entity) {
        if (ejbPersonal.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 

}
