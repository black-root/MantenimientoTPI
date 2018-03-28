package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    
    public SolicitudFacadeLocal getEjbSolicitud() {
        return ejbSolicitud;
    }

    public void setEjbSolicitud(SolicitudFacadeLocal ejbSolicitud) {
        this.ejbSolicitud = ejbSolicitud;
    }
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
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud findById(
            @PathParam("id") Integer id
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

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbSolicitud.remove(ejbSolicitud.find(id));
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Solicitud entity) {
        ejbSolicitud.create(entity);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Solicitud entity) {
        ejbSolicitud.edit(entity);
    }

}
