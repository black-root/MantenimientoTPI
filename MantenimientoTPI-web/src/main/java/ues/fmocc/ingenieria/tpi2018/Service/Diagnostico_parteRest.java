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
import ues.fmoocc.ingenieria.tpi2018.Entities.Diagnosticoparte;
import ues.fmoocc.ingenieria.tpi2018.Sessions.DiagnosticoparteFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("diagnostico-parte")
public class Diagnostico_parteRest implements Serializable{
    
    @EJB
    private DiagnosticoparteFacadeLocal dpFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de Diagnostico_parte en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Diagnosticoparte> findAll() {
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
    public Diagnosticoparte findById(@PathParam("id") int id){
        Diagnosticoparte salida = new Diagnosticoparte();
        try{
           if(dpFacade!=null){
               return dpFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    @DELETE
    @Path("/eliminar/{id:\\+d}")
    public Response remove(@PathParam("id") Integer id) {
        if (dpFacade.eliminar(dpFacade.find(id))) {
            Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("crea")
    public Response create(Diagnosticoparte entity) {
        if (dpFacade.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Diagnosticoparte entity) {
        if (dpFacade.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
       return Response.status(Response.Status.NOT_FOUND).header("no se edito", null).build();
    } 
}
