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
import javax.ws.rs.core.Response;
import ues.fmoocc.ingenieria.tpi2018.Entities.Unidad;
import ues.fmoocc.ingenieria.tpi2018.Sessions.UnidadFacadeLocal;

/**
 *
 * @author yisusdebian
 */
//Ronald Ibanez
@Path("unidad")
public class UnidadRest implements Serializable {

    @EJB
    private UnidadFacadeLocal ejbUnidad;

    //private static final List salida = null;
   /* public List<Unidad> findall() {
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

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUnidad() {

        return Response.ok(findall()).build();
    }
*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Unidad> findallUnidadRest() {
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
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad findById(
            @PathParam("id") Integer id
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
}
