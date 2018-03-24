package ues.fmocc.ingenieria.tpi2018.ManageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import ues.fmoocc.ingenieria.tpi2018.Sessions.SolicitudFacadeLocal;

/**
 *
 * @author yisusdebian
 */

//Ronald Ibanez
@Named(value = "frmSolicitudBean")
@ViewScoped
public class FrmSolicitudBean implements Serializable {

    @EJB
    private SolicitudFacadeLocal ejbSolicitud;
    private Solicitud solicitud = new Solicitud();

    public FrmSolicitudBean() {
    }

    public Solicitud getSolicitud() {
        return solicitud;

    }
    public boolean command() {
        return true;
    }

    public void setSolicitud (Solicitud solicitud) {
        this.solicitud = solicitud;

    }

    //obtenemos todos los datos sobre la solicitud
    public List<Solicitud> getAllSolicitud() {
        List<Solicitud> output = new ArrayList();
        try {
            if (ejbSolicitud != null) {
                output = ejbSolicitud.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return output;

    }

    public void validar(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (texto.isEmpty() || texto.startsWith(" ") || texto == null) {

            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo Obligatorio"));

        }

    }
    
    public void nuevo() {
        this.solicitud = new Solicitud();

    }

    public void obtener(Solicitud sol) {
        this.solicitud = sol;
    }
    public void eliminar() {
        try {
            if (this.solicitud != null && this.ejbSolicitud != null) {
                ejbSolicitud.remove(this.solicitud);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    // tengo dudas si validar todos los campos
    public void actualizar() {

        if (this.solicitud.getSolicitante().isEmpty() != true && this.solicitud.getDescripcion().isEmpty() != true 
                && this.solicitud.getSolicitante() != null && this.solicitud.getDescripcion() != null) {

            try {
                if (this.solicitud!= null && this.ejbSolicitud != null) {
                    //aqui se actuliza o edita xd
                    ejbSolicitud.edit(this.solicitud);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo! (It's updated)", null));

                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }

        }
    }

    public void crear() {

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
    
}
