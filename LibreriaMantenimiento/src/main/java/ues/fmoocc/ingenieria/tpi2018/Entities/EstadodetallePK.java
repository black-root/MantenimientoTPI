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
public class EstadodetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Personal_pk_idPersonal")
    private int personalpkidPersonal;
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
    @Column(name = "Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte")
    private int estadoProcedimientosDianosticopartepkidDianosticoparte;

    public EstadodetallePK() {
    }

    public EstadodetallePK(int personalpkidPersonal, int estadopkidEstado, int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, int estadoProcedimientosPasospkidPaso, int estadoProcedimientosDianosticopartepkidDianosticoparte) {
        this.personalpkidPersonal = personalpkidPersonal;
        this.estadopkidEstado = estadopkidEstado;
        this.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento = estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
        this.estadoProcedimientosPasospkidPaso = estadoProcedimientosPasospkidPaso;
        this.estadoProcedimientosDianosticopartepkidDianosticoparte = estadoProcedimientosDianosticopartepkidDianosticoparte;
    }

    public int getPersonalpkidPersonal() {
        return personalpkidPersonal;
    }

    public void setPersonalpkidPersonal(int personalpkidPersonal) {
        this.personalpkidPersonal = personalpkidPersonal;
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

    public int getEstadoProcedimientosDianosticopartepkidDianosticoparte() {
        return estadoProcedimientosDianosticopartepkidDianosticoparte;
    }

    public void setEstadoProcedimientosDianosticopartepkidDianosticoparte(int estadoProcedimientosDianosticopartepkidDianosticoparte) {
        this.estadoProcedimientosDianosticopartepkidDianosticoparte = estadoProcedimientosDianosticopartepkidDianosticoparte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personalpkidPersonal;
        hash += (int) estadopkidEstado;
        hash += (int) estadoProcedimientosTipoprocedimientopkidTipoprocedimiento;
        hash += (int) estadoProcedimientosPasospkidPaso;
        hash += (int) estadoProcedimientosDianosticopartepkidDianosticoparte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadodetallePK)) {
            return false;
        }
        EstadodetallePK other = (EstadodetallePK) object;
        if (this.personalpkidPersonal != other.personalpkidPersonal) {
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
        if (this.estadoProcedimientosDianosticopartepkidDianosticoparte != other.estadoProcedimientosDianosticopartepkidDianosticoparte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.EstadodetallePK[ personalpkidPersonal=" + personalpkidPersonal + ", estadopkidEstado=" + estadopkidEstado + ", estadoProcedimientosTipoprocedimientopkidTipoprocedimiento=" + estadoProcedimientosTipoprocedimientopkidTipoprocedimiento + ", estadoProcedimientosPasospkidPaso=" + estadoProcedimientosPasospkidPaso + ", estadoProcedimientosDianosticopartepkidDianosticoparte=" + estadoProcedimientosDianosticopartepkidDianosticoparte + " ]";
    }
    
}