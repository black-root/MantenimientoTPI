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
import ues.fmoocc.ingenieria.tpi2018.Entities.Procedimientos;
import ues.fmoocc.ingenieria.tpi2018.Sessions.ProcedimientosFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("procedimientos")
public class ProcedimientosRest implements Serializable{
    
    @EJB
    private ProcedimientosFacadeLocal procFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de procedimientos en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Procedimientos> findAll() {
        List salida = null;
        try {
            if (procFacade != null) {
                return procFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un procedimiento por id: ej. localhost:8080/ManteniemientoTPI/webresources/procedimientos/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimientos findById(@PathParam("id") int id){
        Procedimientos salida = new Procedimientos();
        try{
           if(procFacade!=null){
               return procFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (procFacade.eliminar(procFacade.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Procedimientos entity) {
        if (procFacade.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Procedimientos entity) {
        if (procFacade.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
