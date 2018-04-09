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
public class EstadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pk_idEstado")
    private int pkidEstado;
    @Basic(optional = false)
    @Column(name = "Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento")
    private int procedimientosTipoprocedimientopkidTipoprocedimiento;
    @Basic(optional = false)
    @Column(name = "Procedimientos_Pasos_pk_idPaso")
    private int procedimientosPasospkidPaso;
    @Basic(optional = false)
    @Column(name = "Procedimientos_Dianostico_parte_pk_idDianostico_parte")
    private int procedimientosDianosticopartepkidDianosticoparte;

    public EstadoPK() {
    }

    public EstadoPK(int pkidEstado, int procedimientosTipoprocedimientopkidTipoprocedimiento, int procedimientosPasospkidPaso, int procedimientosDianosticopartepkidDianosticoparte) {
        this.pkidEstado = pkidEstado;
        this.procedimientosTipoprocedimientopkidTipoprocedimiento = procedimientosTipoprocedimientopkidTipoprocedimiento;
        this.procedimientosPasospkidPaso = procedimientosPasospkidPaso;
        this.procedimientosDianosticopartepkidDianosticoparte = procedimientosDianosticopartepkidDianosticoparte;
    }

    public int getPkidEstado() {
        return pkidEstado;
    }

    public void setPkidEstado(int pkidEstado) {
        this.pkidEstado = pkidEstado;
    }

    public int getProcedimientosTipoprocedimientopkidTipoprocedimiento() {
        return procedimientosTipoprocedimientopkidTipoprocedimiento;
    }

    public void setProcedimientosTipoprocedimientopkidTipoprocedimiento(int procedimientosTipoprocedimientopkidTipoprocedimiento) {
        this.procedimientosTipoprocedimientopkidTipoprocedimiento = procedimientosTipoprocedimientopkidTipoprocedimiento;
    }

    public int getProcedimientosPasospkidPaso() {
        return procedimientosPasospkidPaso;
    }

    public void setProcedimientosPasospkidPaso(int procedimientosPasospkidPaso) {
        this.procedimientosPasospkidPaso = procedimientosPasospkidPaso;
    }

    public int getProcedimientosDianosticopartepkidDianosticoparte() {
        return procedimientosDianosticopartepkidDianosticoparte;
    }

    public void setProcedimientosDianosticopartepkidDianosticoparte(int procedimientosDianosticopartepkidDianosticoparte) {
        this.procedimientosDianosticopartepkidDianosticoparte = procedimientosDianosticopartepkidDianosticoparte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pkidEstado;
        hash += (int) procedimientosTipoprocedimientopkidTipoprocedimiento;
        hash += (int) procedimientosPasospkidPaso;
        hash += (int) procedimientosDianosticopartepkidDianosticoparte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPK)) {
            return false;
        }
        EstadoPK other = (EstadoPK) object;
        if (this.pkidEstado != other.pkidEstado) {
            return false;
        }
        if (this.procedimientosTipoprocedimientopkidTipoprocedimiento != other.procedimientosTipoprocedimientopkidTipoprocedimiento) {
            return false;
        }
        if (this.procedimientosPasospkidPaso != other.procedimientosPasospkidPaso) {
            return false;
        }
        if (this.procedimientosDianosticopartepkidDianosticoparte != other.procedimientosDianosticopartepkidDianosticoparte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.EstadoPK[ pkidEstado=" + pkidEstado + ", procedimientosTipoprocedimientopkidTipoprocedimiento=" + procedimientosTipoprocedimientopkidTipoprocedimiento + ", procedimientosPasospkidPaso=" + procedimientosPasospkidPaso + ", procedimientosDianosticopartepkidDianosticoparte=" + procedimientosDianosticopartepkidDianosticoparte + " ]";
    }
    
}
