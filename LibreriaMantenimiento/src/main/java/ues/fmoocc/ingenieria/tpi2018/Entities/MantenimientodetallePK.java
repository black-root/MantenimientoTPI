/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author yisusdebian
 */
@Embeddable
public class MantenimientodetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pk_idMantenimiento_detallecol")
    private int pkidMantenimientodetallecol;
    @Basic(optional = false)
    @Column(name = "OrdenTrabajo_pk_idOrdenTrabajo")
    private int ordenTrabajopkidOrdenTrabajo;

    public MantenimientodetallePK() {
    }

    public MantenimientodetallePK(int pkidMantenimientodetallecol, int ordenTrabajopkidOrdenTrabajo) {
        this.pkidMantenimientodetallecol = pkidMantenimientodetallecol;
        this.ordenTrabajopkidOrdenTrabajo = ordenTrabajopkidOrdenTrabajo;
    }

    public int getPkidMantenimientodetallecol() {
        return pkidMantenimientodetallecol;
    }

    public void setPkidMantenimientodetallecol(int pkidMantenimientodetallecol) {
        this.pkidMantenimientodetallecol = pkidMantenimientodetallecol;
    }

    public int getOrdenTrabajopkidOrdenTrabajo() {
        return ordenTrabajopkidOrdenTrabajo;
    }

    public void setOrdenTrabajopkidOrdenTrabajo(int ordenTrabajopkidOrdenTrabajo) {
        this.ordenTrabajopkidOrdenTrabajo = ordenTrabajopkidOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pkidMantenimientodetallecol;
        hash += (int) ordenTrabajopkidOrdenTrabajo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientodetallePK)) {
            return false;
        }
        MantenimientodetallePK other = (MantenimientodetallePK) object;
        if (this.pkidMantenimientodetallecol != other.pkidMantenimientodetallecol) {
            return false;
        }
        if (this.ordenTrabajopkidOrdenTrabajo != other.ordenTrabajopkidOrdenTrabajo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.MantenimientodetallePK[ pkidMantenimientodetallecol=" + pkidMantenimientodetallecol + ", ordenTrabajopkidOrdenTrabajo=" + ordenTrabajopkidOrdenTrabajo + " ]";
    }
    
}
