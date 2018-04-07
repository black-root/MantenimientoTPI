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
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PasosFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("pasos")
public class PasosRest implements Serializable{
    
    @EJB
    private PasosFacadeLocal pasosFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de pasos en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pasos> findAll() {
        List salida = null;
        try {
            if (pasosFacade != null) {
                return pasosFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un paso por id: ej. localhost:8080/ManteniemientoTPI/webresources/pasos/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pasos findById(@PathParam("id") int id){
        Pasos salida = new Pasos();
        try{
           if(pasosFacade!=null){
               return pasosFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un paso de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarPaso(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && pasosFacade!=null){
               pasosFacade.remove(pasosFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    
    
    //Guardar un paso en la base de datos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarPaso(Pasos paso){
       try{
            if(this.pasosFacade!=null){
             pasosFacade.create(paso);
        return Response.status(Response.Status.CREATED).entity(paso).build();  
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
    public Response editarPaso(@PathParam("id") Integer id, Pasos paso) {
        try {
            if (this.pasosFacade != null) {
                pasosFacade.edit(paso);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    
}
