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
 * @author sergio
 */
@Embeddable
public class MantenimientodetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pk_idMantenimiento_detallecol")
    private int pkidMantenimientodetallecol;
    @Basic(optional = false)
    @Column(name = "OrdenTrabajo_pk_idOrdenTrabajo")
    private int ordenTrabajopkidOrdenTrabajo;
    @Basic(optional = false)
    @Column(name = "Estado_pk_idEstado")
    private int estadopkidEstado;
    @Basic(optional = false)
    @Column(name = "Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento")
    private int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
    @Basic(optional = false)
    @Column(name = "Estado_Procedimientos_Pasos_pk_idPaso")
    private int estadoProcedimientosPasospkidPaso;
    @Basic(optional = false)
    @Column(name = "Estado_Procedimientos_Diagnostico_parte_pk_idDianostico_parte")
    private int estadoProcedimientosDiagnosticopartepkidDianosticoparte;

    public MantenimientodetallePK() {
    }

    public MantenimientodetallePK(int pkidMantenimientodetallecol, int ordenTrabajopkidOrdenTrabajo, int estadopkidEstado, int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, int estadoProcedimientosPasospkidPaso, int estadoProcedimientosDiagnosticopartepkidDianosticoparte) {
        this.pkidMantenimientodetallecol = pkidMantenimientodetallecol;
        this.ordenTrabajopkidOrdenTrabajo = ordenTrabajopkidOrdenTrabajo;
        this.estadopkidEstado = estadopkidEstado;
        this.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento = estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
        this.estadoProcedimientosPasospkidPaso = estadoProcedimientosPasospkidPaso;
        this.estadoProcedimientosDiagnosticopartepkidDianosticoparte = estadoProcedimientosDiagnosticopartepkidDianosticoparte;
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

    public int getEstadopkidEstado() {
        return estadopkidEstado;
    }

    public void setEstadopkidEstado(int estadopkidEstado) {
        this.estadopkidEstado = estadopkidEstado;
    }

    public int getEstadoProcedimientosTipoprocedimientopkidTipoprocedimiento() {
        return estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
    }

    public void setEstadoProcedimientosTipoprocedimientopkidTipoprocedimiento(int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento) {
        this.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento = estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
    }

    public int getEstadoProcedimientosPasospkidPaso() {
        return estadoProcedimientosPasospkidPaso;
    }

    public void setEstadoProcedimientosPasospkidPaso(int estadoProcedimientosPasospkidPaso) {
        this.estadoProcedimientosPasospkidPaso = estadoProcedimientosPasospkidPaso;
    }

    public int getEstadoProcedimientosDiagnosticopartepkidDianosticoparte() {
        return estadoProcedimientosDiagnosticopartepkidDianosticoparte;
    }

    public void setEstadoProcedimientosDiagnosticopartepkidDianosticoparte(int estadoProcedimientosDiagnosticopartepkidDianosticoparte) {
        this.estadoProcedimientosDiagnosticopartepkidDianosticoparte = estadoProcedimientosDiagnosticopartepkidDianosticoparte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pkidMantenimientodetallecol;
        hash += (int) ordenTrabajopkidOrdenTrabajo;
        hash += (int) estadopkidEstado;
        hash += (int) estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
        hash += (int) estadoProcedimientosPasospkidPaso;
        hash += (int) estadoProcedimientosDiagnosticopartepkidDianosticoparte;
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
        if (this.estadopkidEstado != other.estadopkidEstado) {
            return false;
        }
        if (this.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento != other.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento) {
            return false;
        }
        if (this.estadoProcedimientosPasospkidPaso != other.estadoProcedimientosPasospkidPaso) {
            return false;
        }
        if (this.estadoProcedimientosDiagnosticopartepkidDianosticoparte != other.estadoProcedimientosDiagnosticopartepkidDianosticoparte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.MantenimientodetallePK[ pkidMantenimientodetallecol=" + pkidMantenimientodetallecol + ", ordenTrabajopkidOrdenTrabajo=" + ordenTrabajopkidOrdenTrabajo + ", estadopkidEstado=" + estadopkidEstado + ", estadoProcedimientosTipoprocedimientopkidTipoprocedimiento=" + estadoProcedimientosTipoprocedimientopkidTipoprocedimiento + ", estadoProcedimientosPasospkidPaso=" + estadoProcedimientosPasospkidPaso + ", estadoProcedimientosDiagnosticopartepkidDianosticoparte=" + estadoProcedimientosDiagnosticopartepkidDianosticoparte + " ]";
    }
    
}
