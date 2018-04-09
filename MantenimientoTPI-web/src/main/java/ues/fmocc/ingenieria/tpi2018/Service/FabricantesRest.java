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
    @Path("/{descripcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Fabricantes> findByDescripcion(@PathParam("descripcion") String descripcion){
        try {
            if (ejbFabricante != null) {
                return ejbFabricante.findWithDescripcion("Fabricantes.findByDescripcion", descripcion);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return null;
    }
    
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbFabricante != null) {
                ejbFabricante.remove(ejbFabricante.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Fabricantes entity) {

        try {
            if (this.ejbFabricante != null) {
                ejbFabricante.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Fabricantes entity) {

        try {
            if (this.ejbFabricante != null) {
                ejbFabricante.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
