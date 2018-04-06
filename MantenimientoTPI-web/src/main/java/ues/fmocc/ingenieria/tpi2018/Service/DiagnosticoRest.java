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
import ues.fmoocc.ingenieria.tpi2018.Entities.Diagnostico;
import ues.fmoocc.ingenieria.tpi2018.Sessions.DiagnosticoFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("diagnostico")
public class DiagnosticoRest implements Serializable{
    
    @EJB
    private DiagnosticoFacadeLocal diagnosticoFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de diagnostico en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Diagnostico> findAll() {
        List salida = null;
        try {
            if (diagnosticoFacade != null) {
                return diagnosticoFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un diagnostico por id: ej. localhost:8080/ManteniemientoTPI/webresources/diagnostico/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Diagnostico findById(@PathParam("id") int id){
        Diagnostico salida = new Diagnostico();
        try{
           if(diagnosticoFacade!=null){
               return diagnosticoFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un diagnostico de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarDiagnostico(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && diagnosticoFacade!=null){
               diagnosticoFacade.remove(diagnosticoFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    
    
    //Guardar un diagnostico en la base de datos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarDiagnostico(Diagnostico diagnostico){
        try{
            if(this.diagnosticoFacade!=null){
             diagnosticoFacade.create(diagnostico);
        return Response.status(Response.Status.CREATED).entity(diagnostico).build();  
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
    public Response editarDiagnostico(@PathParam("id") Integer id, Diagnostico diagnostico) {
        try {
            if (this.diagnosticoFacade != null) {
                diagnosticoFacade.edit(diagnostico);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    
}
