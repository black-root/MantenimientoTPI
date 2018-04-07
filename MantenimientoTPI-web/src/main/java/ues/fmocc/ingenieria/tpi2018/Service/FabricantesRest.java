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
import ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes;
import ues.fmoocc.ingenieria.tpi2018.Sessions.FabricantesFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("fabricantes")
public class FabricantesRest implements Serializable{
    
    @EJB
    private FabricantesFacadeLocal fabricanteFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de fabricantes en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Fabricantes> findAll() {
        List salida = null;
        try {
            if (fabricanteFacade != null) {
                return fabricanteFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un fabricante por id: ej. localhost:8080/ManteniemientoTPI/webresources/fabricantes/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fabricantes findById(@PathParam("id") int id){
        Fabricantes salida = new Fabricantes();
        try{
           if(fabricanteFacade!=null){
               return fabricanteFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un fabricante de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarFabricante(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && fabricanteFacade!=null){
               fabricanteFacade.remove(fabricanteFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    
    
    //Guardar un fabricante en la base de datos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarFabricante(Fabricantes fabricante){
        try{
            if(this.fabricanteFacade!=null){
             fabricanteFacade.create(fabricante);
        return Response.status(Response.Status.CREATED).entity(fabricante).build();  
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
    public Response editarFabricante(@PathParam("id") Integer id, Fabricantes fabricante) {
        try {
            if (this.fabricanteFacade != null) {
                fabricanteFacade.edit(fabricante);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    
    
}
