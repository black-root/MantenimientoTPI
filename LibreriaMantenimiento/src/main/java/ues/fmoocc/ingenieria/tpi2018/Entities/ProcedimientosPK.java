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
public class ProcedimientosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Tipo_procedimiento_pk_idTipo_procedimiento")
    private int tipoprocedimientopkidTipoprocedimiento;
    @Basic(optional = false)
    @Column(name = "Pasos_pk_idPaso")
    private int pasospkidPaso;
    @Basic(optional = false)
    @Column(name = "Diagnostico_parte_pk_idDianostico_parte")
    private int diagnosticopartepkidDianosticoparte;

    public ProcedimientosPK() {
    }

    public ProcedimientosPK(int tipoprocedimientopkidTipoprocedimiento, int pasospkidPaso, int diagnosticopartepkidDianosticoparte) {
        this.tipoprocedimientopkidTipoprocedimiento = tipoprocedimientopkidTipoprocedimiento;
        this.pasospkidPaso = pasospkidPaso;
        this.diagnosticopartepkidDianosticoparte = diagnosticopartepkidDianosticoparte;
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

    public int getDiagnosticopartepkidDianosticoparte() {
        return diagnosticopartepkidDianosticoparte;
    }

    public void setDiagnosticopartepkidDianosticoparte(int diagnosticopartepkidDianosticoparte) {
        this.diagnosticopartepkidDianosticoparte = diagnosticopartepkidDianosticoparte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipoprocedimientopkidTipoprocedimiento;
        hash += (int) pasospkidPaso;
        hash += (int) diagnosticopartepkidDianosticoparte;
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
        if (this.diagnosticopartepkidDianosticoparte != other.diagnosticopartepkidDianosticoparte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.ProcedimientosPK[ tipoprocedimientopkidTipoprocedimiento=" + tipoprocedimientopkidTipoprocedimiento + ", pasospkidPaso=" + pasospkidPaso + ", diagnosticopartepkidDianosticoparte=" + diagnosticopartepkidDianosticoparte + " ]";
    }
    
}
