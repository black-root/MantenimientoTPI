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
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;
import ues.fmoocc.ingenieria.tpi2018.Sessions.RolFacade;
import ues.fmoocc.ingenieria.tpi2018.Sessions.RolFacadeLocal;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("rol")
@Produces({MediaType.APPLICATION_JSON})
public class RolRest implements Serializable {
  
    @EJB
    private RolFacadeLocal ejbRol;

    //devuelve todo
    @GET
//    @Produces({MediaType.APPLICATION_JSON})
    public List<Rol> findall() {
        List salida = null;
        try {
            if (ejbRol != null) {
                return ejbRol.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return salida;
    }

    @Path("count")
    @GET
//    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbRol != null) {
                return ejbRol.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    //busca uno en particular
    @GET
    @Path("/{id:\\d+}")
//    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Rol findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbRol != null) {
                return ejbRol.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Rol();
    }
    
    @GET
    @Path("/{descripcion}")
    public List<Rol> findByDescripcion(@PathParam("descripcion") String descripcion){
        try {
            if (ejbRol != null) {
                return ejbRol.findWithDescripcion("Rol.findByDescripcion", descripcion);
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
            if (id != null && this.ejbRol != null) {
                ejbRol.remove(ejbRol.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Rol entity) {

        try {
            if (this.ejbRol != null) {
                ejbRol.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Rol entity) {

        try {
            if (this.ejbRol != null) {
                ejbRol.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
