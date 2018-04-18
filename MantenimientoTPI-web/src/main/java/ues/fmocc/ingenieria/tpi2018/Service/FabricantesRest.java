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
import ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes;
import ues.fmoocc.ingenieria.tpi2018.Sessions.FabricantesFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Path("fabricantes")
public class FabricantesRest implements Serializable{
    
    @EJB
    private FabricantesFacadeLocal ejbFabricante;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Fabricantes> findall() {
        List salida = null;
        try {
            if (ejbFabricante!= null) {
                return ejbFabricante.findAll();
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
            if (ejbFabricante != null) {
                return ejbFabricante.count();
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
    public Fabricantes findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbFabricante != null) {
                return ejbFabricante.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Fabricantes();
    }
    
    @GET
    @Path("/{nombre}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Fabricantes> findByNombre(@PathParam("nombre") String nombre){
        try {
            if (ejbFabricante != null) {
                return ejbFabricante.findWithNombre("Fabricantes.findByNombre", nombre);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }
    
    
    @DELETE
    @Path("/{id:\\d+}")
    public Response remove(@PathParam("id") int id) {
        if (ejbFabricante.eliminar(ejbFabricante.find(id))) {
            return Response.status(Response.Status.OK).header("objeto eliminado", this).build();
        }
        
        return Response.status(Response.Status.NOT_FOUND).header("no se pudo borrar", this).build();
    }

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Fabricantes entity) {
        if (ejbFabricante.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("objeto no creado", this).build();
    }

    @PUT
    @Path("/{id:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") int id, Fabricantes entity) {
        if (ejbFabricante.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no se pudo editar", this).build();
    }
}
