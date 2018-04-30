/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Estado_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadodetalle.findAll", query = "SELECT e FROM Estadodetalle e")
    , @NamedQuery(name = "Estadodetalle.findByPersonalpkidPersonal", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.personalpkidPersonal = :personalpkidPersonal")
    , @NamedQuery(name = "Estadodetalle.findByDescripcion", query = "SELECT e FROM Estadodetalle e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Estadodetalle.findByEstadopkidEstado", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.estadopkidEstado = :estadopkidEstado")
    , @NamedQuery(name = "Estadodetalle.findByEstadoEstadopkidEstado", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.estadoEstadopkidEstado = :estadoEstadopkidEstado")
    , @NamedQuery(name = "Estadodetalle.findByEstadoProcedimientosTipoprocedimientopkidTipoprocedimiento", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento = :estadoProcedimientosTipoprocedimientopkidTipoprocedimiento")
    , @NamedQuery(name = "Estadodetalle.findByEstadoProcedimientosPasospkidPaso", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.estadoProcedimientosPasospkidPaso = :estadoProcedimientosPasospkidPaso")
    , @NamedQuery(name = "Estadodetalle.findByEstadoProcedimientosDiagnosticopartepkidDianosticoparte", query = "SELECT e FROM Estadodetalle e WHERE e.estadodetallePK.estadoProcedimientosDiagnosticopartepkidDianosticoparte = :estadoProcedimientosDiagnosticopartepkidDianosticoparte")})
public class Estadodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadodetallePK estadodetallePK;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumns({
        @JoinColumn(name = "Estado_pk_idEstado", referencedColumnName = "pk_idEstado", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", referencedColumnName = "Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Pasos_pk_idPaso", referencedColumnName = "Procedimientos_Pasos_pk_idPaso", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Diagnostico_parte_pk_idDianostico_parte", referencedColumnName = "Procedimientos_Diagnostico_parte_pk_idDianostico_parte", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Estado estado;
    @JoinColumn(name = "Personal_pk_idPersonal", referencedColumnName = "pk_idPersonal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;

    public Estadodetalle() {
    }

    public Estadodetalle(EstadodetallePK estadodetallePK) {
        this.estadodetallePK = estadodetallePK;
    }

    public Estadodetalle(int personalpkidPersonal, int estadopkidEstado, int estadoEstadopkidEstado, int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, int estadoProcedimientosPasospkidPaso, int estadoProcedimientosDiagnosticopartepkidDianosticoparte) {
        this.estadodetallePK = new EstadodetallePK(personalpkidPersonal, estadopkidEstado, estadoEstadopkidEstado, estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, estadoProcedimientosPasospkidPaso, estadoProcedimientosDiagnosticopartepkidDianosticoparte);
    }

    public EstadodetallePK getEstadodetallePK() {
        return estadodetallePK;
    }

    public void setEstadodetallePK(EstadodetallePK estadodetallePK) {
        this.estadodetallePK = estadodetallePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadodetallePK != null ? estadodetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadodetalle)) {
            return false;
        }
        Estadodetalle other = (Estadodetalle) object;
        if ((this.estadodetallePK == null && other.estadodetallePK != null) || (this.estadodetallePK != null && !this.estadodetallePK.equals(other.estadodetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.Estadodetalle[ estadodetallePK=" + estadodetallePK + " ]";
    }
    
}
