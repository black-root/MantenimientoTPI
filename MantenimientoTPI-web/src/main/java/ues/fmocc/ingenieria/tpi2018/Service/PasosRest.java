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
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PasosFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Path("pasos")
public class PasosRest implements Serializable{
    
    @EJB
    private PasosFacadeLocal ejbPasos;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pasos> findall() {
        List salida = null;
        try {
            if (ejbPasos != null) {
                return ejbPasos.findAll();
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
            if (ejbPasos != null) {
                return ejbPasos.count();
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
    public Pasos findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbPasos != null) {
                return ejbPasos.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Pasos();
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbPasos != null) {
                ejbPasos.remove(ejbPasos.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Pasos entity) {

        try {
            if (this.ejbPasos != null) {
                ejbPasos.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Pasos entity) {

        try {
            if (this.ejbPasos != null) {
                ejbPasos.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
