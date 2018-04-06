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
import ues.fmoocc.ingenieria.tpi2018.Entities.Estado;
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;
import ues.fmoocc.ingenieria.tpi2018.Sessions.EstadoFacadeLocal;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PasosFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("estado")
public class EstadoRest implements Serializable{
    
    @EJB
    private EstadoFacadeLocal estadoFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de estados en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estado> findAll() {
        List salida = null;
        try {
            if (estadoFacade != null) {
                return estadoFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un estado por id: ej. localhost:8080/ManteniemientoTPI/webresources/estado/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estado findById(@PathParam("id") int id){
        Estado salida = new Estado();
        try{
           if(estadoFacade!=null){
               return estadoFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un estado de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarEstado(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && estadoFacade!=null){
               estadoFacade.remove(estadoFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    
    
    //Guardar un estado en la base de datos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarEstado(Estado estado){
       try{
            if(this.estadoFacade!=null){
             estadoFacade.create(estado);
        return Response.status(Response.Status.CREATED).entity(estado).build();  
        }
        }catch(Exception e){
             Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarEstado(@PathParam("id") Integer id, Estado estado) {
        try {
            if (this.estadoFacade != null) {
                estadoFacade.edit(estado);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    
}
