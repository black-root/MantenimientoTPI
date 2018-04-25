package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import ues.fmoocc.ingenieria.tpi2018.Entities.Estado;
import ues.fmoocc.ingenieria.tpi2018.Sessions.EstadoFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("estado")
public class EstadoRest implements Serializable {

    @EJB
    private EstadoFacadeLocal estadoFacade;

    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;

    //Obtener lista de estados en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estado> findAll() {
        List salida = null;
        try {
            if (estadoFacade != null) {
                return estadoFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un estado por id: ej. localhost:8080/ManteniemientoTPI/webresources/estado/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estado findById(@PathParam("id") int id) {
        Estado salida = new Estado();
        try {
            if (estadoFacade != null) {
                return estadoFacade.find(id);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    @GET
    @Path("/{nombre}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Estado> findByNombre(@PathParam("nombre") String nombre) {
        try {
            if (estadoFacade != null) {
                return estadoFacade.findWithNombre(nombre);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }

    @DELETE
    @Path("eliminar/{id:\\d+}")
    public Response remove(@PathParam("id") int id) {
        if (estadoFacade.eliminar(estadoFacade.find(id))) {
            return Response.status(Response.Status.OK).header("objeto eliminado", this).build();
        }

        return Response.status(Response.Status.NOT_FOUND).header("no se pudo borrar", this).build();
    }

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Estado entity) {
        if (estadoFacade.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("objeto no creado", this).build();
    }

    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Estado entity) {
        if (estadoFacade.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no se pudo editar", this).build();
    }

}
