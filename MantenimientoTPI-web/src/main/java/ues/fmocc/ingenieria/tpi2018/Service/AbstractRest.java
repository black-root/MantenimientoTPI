/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.omnifaces.cdi.Param;
import ues.fmoocc.ingenieria.tpi2018.Sessions.AbstractFacade;

/**
 *
 * @author sergio
 */
public abstract class AbstractRest<P,T extends AbstractFacade> {

    private Class<P> entity;

    
    private transient AbstractFacade ejb;
    public AbstractRest(Class<P> entity) {
        this.entity = entity;
        this.ejb = ejb;
    }

    public Class<P> getEntity() {
        return entity;
    }
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll() {
        if (ejb != null) {
            return ejb.findAll();
        }
        return null;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public int count() {
        if (ejb != null) {
            return ejb.count();
        }
        return 0;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id :\\+d}")
    public Object findById(@PathParam("id") int id) {
        if (ejb != null) {
            return ejb.find(id);
        }
        return null;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public List<T> findByName(@PathParam("nombre") String nombre) {
        if (ejb != null) {
            return ejb.findWithNombre(nombre);
        }
        return null;
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(T entity) {
        if (ejb.modificar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).header("no editado", this).build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminar(T entity) {
        if (ejb.eliminar(entity)) {
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).header("no eliminado", this).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("crear")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(T entity) {
        if (ejb.crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).header("no creado", this).build();
    }

}
