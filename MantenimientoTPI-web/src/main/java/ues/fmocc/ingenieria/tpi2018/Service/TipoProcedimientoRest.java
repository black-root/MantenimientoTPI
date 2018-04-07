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
import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;
import ues.fmoocc.ingenieria.tpi2018.Sessions.TipoprocedimientoFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("tipo-procedimiento")
public class TipoProcedimientoRest implements Serializable{
    
    @EJB
    private TipoprocedimientoFacadeLocal tipoProcedimientoFacade;
    
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de tipoProcedimientos en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tipoprocedimiento> findAll() {
        List salida = null;
        try {
            if (tipoProcedimientoFacade != null) {
                return tipoProcedimientoFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un tipoProcedimiento por id: ej. localhost:8080/ManteniemientoTPI/webresources/tipo-procedimiento/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tipoprocedimiento findById(@PathParam("id") int id){
        Tipoprocedimiento salida = new Tipoprocedimiento();
        try{
           if(tipoProcedimientoFacade!=null){
               return tipoProcedimientoFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un paso de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarTipoProcedimiento(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && tipoProcedimientoFacade!=null){
               tipoProcedimientoFacade.remove(tipoProcedimientoFacade.find(id));
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
    public Response guardarTipoProcedimiento(Tipoprocedimiento tipoP){
        try{
            if(this.tipoProcedimientoFacade!=null){
             tipoProcedimientoFacade.create(tipoP);
        return Response.status(Response.Status.CREATED).entity(tipoP).build();  
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
    public Response editarFabricante(@PathParam("id") Integer id, Tipoprocedimiento tipoP) {
        try {
            if (this.tipoProcedimientoFacade != null) {
                tipoProcedimientoFacade.edit(tipoP);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
}
