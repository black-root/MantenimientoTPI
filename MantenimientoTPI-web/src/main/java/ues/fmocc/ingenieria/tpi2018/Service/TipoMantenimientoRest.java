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
import ues.fmoocc.ingenieria.tpi2018.Entities.TipoMantenimiento;
import ues.fmoocc.ingenieria.tpi2018.Sessions.TipoMantenimientoFacadeLocal;

/**
 *
 * @author yisusdebian
 */
@Path("tipomantenimiento")
public class TipoMantenimientoRest implements Serializable{
    
    @EJB
    private TipoMantenimientoFacadeLocal ejbTipoMantenimiento;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoMantenimiento> findall() {
        List salida = null;
        try {
            if (ejbTipoMantenimiento != null) {
                return ejbTipoMantenimiento.findAll();
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
            if (ejbTipoMantenimiento != null) {
                return ejbTipoMantenimiento.count();
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
    public TipoMantenimiento findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbTipoMantenimiento != null) {
                return ejbTipoMantenimiento.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new TipoMantenimiento();
    }
    
    @GET
    @Path("/{descripcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoMantenimiento> findByDescripcion(@PathParam("descripcion") String descripcion){
        try {
            if (ejbTipoMantenimiento != null) {
                return ejbTipoMantenimiento.findWithDescripcion("TipoMantenimiento.findByDescripcion", descripcion);
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
            if (id != null && this.ejbTipoMantenimiento != null) {
                ejbTipoMantenimiento.remove(ejbTipoMantenimiento.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(TipoMantenimiento entity) {

        try {
            if (this.ejbTipoMantenimiento != null) {
                ejbTipoMantenimiento.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, TipoMantenimiento entity) {

        try {
            if (this.ejbTipoMantenimiento != null) {
                ejbTipoMantenimiento.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
