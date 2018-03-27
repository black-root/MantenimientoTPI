package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;

/**
 *
 * @author yisusdebian
 */
//Ronald Ibanez
@Path("solicitud")
public class SolicitudRest implements Serializable {

    @EJB
    private SolicitudFacadeLocal ejbSolicitud;
    private Solicitud solicitud = new Solicitud();

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public void nuevo() {
        this.solicitud = new Solicitud();

    }

    public void obtener(Solicitud sol) {
        this.solicitud = sol;
    }
    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findall() {
        List salida = null;
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return salida;
    }

    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    //busca uno en particular
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud findById(
            @PathParam("id") Integer id
    ) {
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Solicitud();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public void eliminarMantenimiento() {
        try {
            if (this.solicitud != null && this.ejbSolicitud != null) {
                ejbSolicitud.remove(this.solicitud);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    //crea
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void crearMantenimiento() {

        if (this.solicitud.getSolicitante().isEmpty() != true && this.solicitud.getDescripcion().isEmpty() != true
                && this.solicitud.getSolicitante() != null && this.solicitud.getDescripcion() != null) {

            try {
                if (this.solicitud != null && this.ejbSolicitud != null) {
                    ejbSolicitud.create(this.solicitud);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Creado con Exito! (Created it)", null));
                    nuevo();
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void actualizarMantenimiento() {

        if (this.solicitud.getSolicitante().isEmpty() != true && this.solicitud.getDescripcion().isEmpty() != true
                && this.solicitud.getSolicitante() != null && this.solicitud.getDescripcion() != null) {

            try {
                if (this.solicitud != null && this.ejbSolicitud != null) {
                    //aqui se actuliza o edita xd
                    ejbSolicitud.edit(this.solicitud);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo! (It's updated)", null));

                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }

        }
    }

    public void validar(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (texto.isEmpty() || texto.startsWith(" ") || texto == null) {

            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo Obligatorio"));

        }

    }

}
