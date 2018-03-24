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
import javax.validation.constraints.NotNull;

/**
 *
 * @author yisusdebian
 */
@Embeddable
public class ProcedimientosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo_procedimiento_pk_idTipo_procedimiento")
    private int tipoprocedimientopkidTipoprocedimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pasos_pk_idPaso")
    private int pasospkidPaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dianostico_parte_pk_idDianostico_parte")
    private int dianosticopartepkidDianosticoparte;

    public ProcedimientosPK() {
    }

    public ProcedimientosPK(int tipoprocedimientopkidTipoprocedimiento, int pasospkidPaso, int dianosticopartepkidDianosticoparte) {
        this.tipoprocedimientopkidTipoprocedimiento = tipoprocedimientopkidTipoprocedimiento;
        this.pasospkidPaso = pasospkidPaso;
        this.dianosticopartepkidDianosticoparte = dianosticopartepkidDianosticoparte;
    }

    public int getTipoprocedimientopkidTipoprocedimiento() {
        return tipoprocedimientopkidTipoprocedimiento;
    }

    public void setTipoprocedimientopkidTipoprocedimiento(int tipoprocedimientopkidTipoprocedimiento) {
        this.tipoprocedimientopkidTipoprocedimiento = tipoprocedimientopkidTipoprocedimiento;
    }

    public int getPasospkidPaso() {
        return pasospkidPaso;
    }

    public void setPasospkidPaso(int pasospkidPaso) {
        this.pasospkidPaso = pasospkidPaso;
    }

    public int getDianosticopartepkidDianosticoparte() {
        return dianosticopartepkidDianosticoparte;
    }

    public void setDianosticopartepkidDianosticoparte(int dianosticopartepkidDianosticoparte) {
        this.dianosticopartepkidDianosticoparte = dianosticopartepkidDianosticoparte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipoprocedimientopkidTipoprocedimiento;
        hash += (int) pasospkidPaso;
        hash += (int) dianosticopartepkidDianosticoparte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientosPK)) {
            return false;
        }
        ProcedimientosPK other = (ProcedimientosPK) object;
        if (this.tipoprocedimientopkidTipoprocedimiento != other.tipoprocedimientopkidTipoprocedimiento) {
            return false;
        }
        if (this.pasospkidPaso != other.pasospkidPaso) {
            return false;
        }
        if (this.dianosticopartepkidDianosticoparte != other.dianosticopartepkidDianosticoparte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.ProcedimientosPK[ tipoprocedimientopkidTipoprocedimiento=" + tipoprocedimientopkidTipoprocedimiento + ", pasospkidPaso=" + pasospkidPaso + ", dianosticopartepkidDianosticoparte=" + dianosticopartepkidDianosticoparte + " ]";
    }
    
}
