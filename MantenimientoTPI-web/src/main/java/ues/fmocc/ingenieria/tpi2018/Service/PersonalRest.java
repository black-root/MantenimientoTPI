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
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbPersonal != null) {
                ejbPersonal.remove(ejbPersonal.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Personal entity) {

        try {
            if (this.ejbPersonal != null) {
                ejbPersonal.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Personal entity) {

        try {
            if (this.ejbPersonal != null) {
                ejbPersonal.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
