package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PrioridadFacadeLocal;


/**
 *
 * @author yisusdebian
 */
@Path("prioridad")
public class PrioridadRest implements Serializable{
    @EJB
    private PrioridadFacadeLocal ejbPrioridad;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prioridad> findall() {
        List salida = null;
        try {
            if (ejbPrioridad != null) {
                return ejbPrioridad.findAll();
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
            if (ejbPrioridad != null) {
                return ejbPrioridad.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Prioridad findById(
            @PathParam("id") Integer id
    ) {
        try {
            if (ejbPrioridad != null) {
                return ejbPrioridad.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Prioridad();
    }

}
