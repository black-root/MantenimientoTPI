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

import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;
import ues.fmoocc.ingenieria.tpi2018.Sessions.TipoprocedimientoFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Path("tipo-procedimiento")
public class TipoProcedimientoRest implements Serializable{
    
    @EJB
    private TipoprocedimientoFacadeLocal ejbTipoProcedimiento;
    
    
    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tipoprocedimiento> findall() {
        List salida = null;
        try {
            if (ejbTipoProcedimiento != null) {
                return ejbTipoProcedimiento.findAll();
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
            if (ejbTipoProcedimiento != null) {
                return ejbTipoProcedimiento.count();
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
    public Tipoprocedimiento findById(
            @PathParam("id") int id
    ) {
        try {
            if (ejbTipoProcedimiento != null) {
                return ejbTipoProcedimiento.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Tipoprocedimiento();
    }
    
    @GET
    @Path("/{descripcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Tipoprocedimiento> findByDescripcion(@PathParam("descripcion") String descripcion){
        try {
            if (ejbTipoProcedimiento != null) {
                return ejbTipoProcedimiento.findWithDescripcion("TipoProcedimiento.findByDescripcion", descripcion);
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
            if (id != null && this.ejbTipoProcedimiento != null) {
                ejbTipoProcedimiento.remove(ejbTipoProcedimiento.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Tipoprocedimiento entity) {

        try {
            if (this.ejbTipoProcedimiento != null) {
                ejbTipoProcedimiento.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Tipoprocedimiento entity) {

        try {
            if (this.ejbTipoProcedimiento != null) {
                ejbTipoProcedimiento.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
