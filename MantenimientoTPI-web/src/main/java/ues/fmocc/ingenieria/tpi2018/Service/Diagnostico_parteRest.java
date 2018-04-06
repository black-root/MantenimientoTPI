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
import ues.fmoocc.ingenieria.tpi2018.Entities.Dianosticoparte;
import ues.fmoocc.ingenieria.tpi2018.Sessions.DianosticoparteFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("diagnostico-parte")
public class Diagnostico_parteRest implements Serializable{
    
    @EJB
    private DianosticoparteFacadeLocal dpFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de Diagnostico_parte en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Dianosticoparte> findAll() {
        List salida = null;
        try {
            if (dpFacade != null) {
                return dpFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un Diagnostico_parte por id: ej. localhost:8080/ManteniemientoTPI/webresources/diagnostico-parte/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dianosticoparte findById(@PathParam("id") int id){
        Dianosticoparte salida = new Dianosticoparte();
        try{
           if(dpFacade!=null){
               return dpFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un Diagnostico_parte de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarDiagnosticoparte(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && dpFacade!=null){
               dpFacade.remove(dpFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    
    
    //Guardar un Diagnostico_parte en la base de datos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarDiagnosticoparte(Dianosticoparte dp){
        try{
            if(this.dpFacade!=null){
             dpFacade.create(dp);
        return Response.status(Response.Status.CREATED).entity(dp).build();  
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
    public Response editarDiagnosticoparte(@PathParam("id") Integer id, Dianosticoparte dp) {
        try {
            if (this.dpFacade != null) {
                dpFacade.edit(dp);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    
}
