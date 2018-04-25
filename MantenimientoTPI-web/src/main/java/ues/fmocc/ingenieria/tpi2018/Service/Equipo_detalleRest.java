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
import ues.fmoocc.ingenieria.tpi2018.Entities.Equipodetalle;
import ues.fmoocc.ingenieria.tpi2018.Sessions.EquipodetalleFacadeLocal;

/**
 *
 * @author Daniel Murillo
 */
@Stateless
@Path("equipo-detalle")
public class Equipo_detalleRest implements Serializable{
    
    @EJB
    private EquipodetalleFacadeLocal edFacade;
    
       
    @PersistenceContext(unitName = "ues.fmoocc.ingenieria.tpi2018_MantenimientoTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em = null;
    
    //Obtener lista de esquipodetalle en formato Json
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Equipodetalle> findAll() {
        List salida = null;
        try {
            if (edFacade != null) {
                return edFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    //Obtener un equipodetalle por id: ej. localhost:8080/ManteniemientoTPI/webresources/equipodetalle/1
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Equipodetalle findById(@PathParam("id") int id){
        Equipodetalle salida = new Equipodetalle();
        try{
           if(edFacade!=null){
               return edFacade.find(id);
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
    
    
    //Elimina un equipodetalle de la base de datos
    @DELETE
    @Path("/{id}")
    public Response borrarEquipodetalle(@PathParam("id") Integer id){
        Response salida = Response.status(Response.Status.NOT_FOUND).build();
       try{
           if(id!=null && edFacade!=null){
               edFacade.remove(edFacade.find(id));
               salida = Response.status(Response.Status.OK).build();
           }
        }    catch(Exception e){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        //findAll();
        return salida;
    }
    @DELETE
    @Path("eliminar/{id:\\d+}")
    public Response remove(@PathParam("id") int id) {
        if (edFacade.eliminar(edFacade.find(id))) {
            return Response.status(Response.Status.OK).header("objeto eliminado", this).build();
        }

        return Response.status(Response.Status.NOT_FOUND).header("no se pudo borrar", this).build();
    }

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Equipodetalle entity) {
        if (edFacade.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("objeto no creado", this).build();
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Equipodetalle entity) {
        if (edFacade.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("no se pudo editar", this).build();
    }
}
