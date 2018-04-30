/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Mantenimiento_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientodetalle.findAll", query = "SELECT m FROM Mantenimientodetalle m")
    , @NamedQuery(name = "Mantenimientodetalle.findByPkidMantenimientodetallecol", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.pkidMantenimientodetallecol = :pkidMantenimientodetallecol")
    , @NamedQuery(name = "Mantenimientodetalle.findByFecha", query = "SELECT m FROM Mantenimientodetalle m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimientodetalle.findByOrdenTrabajopkidOrdenTrabajo", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.ordenTrabajopkidOrdenTrabajo = :ordenTrabajopkidOrdenTrabajo")
    , @NamedQuery(name = "Mantenimientodetalle.findByEstadopkidEstado", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.estadopkidEstado = :estadopkidEstado")
    , @NamedQuery(name = "Mantenimientodetalle.findByEstadoProcedimientosTipoprocedimientopkidTipoprocedimiento", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.estadoProcedimientosTipoprocedimientopkidTipoprocedimiento = :estadoProcedimientosTipoprocedimientopkidTipoprocedimiento")
    , @NamedQuery(name = "Mantenimientodetalle.findByEstadoProcedimientosPasospkidPaso", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.estadoProcedimientosPasospkidPaso = :estadoProcedimientosPasospkidPaso")
    , @NamedQuery(name = "Mantenimientodetalle.findByEstadoProcedimientosDiagnosticopartepkidDianosticoparte", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.estadoProcedimientosDiagnosticopartepkidDianosticoparte = :estadoProcedimientosDiagnosticopartepkidDianosticoparte")})
public class Mantenimientodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MantenimientodetallePK mantenimientodetallePK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "Equipo_detalle_pk_idEquipoDetalle", referencedColumnName = "pk_idEquipoDetalle")
    @ManyToOne(optional = false)
    private Equipodetalle equipodetallepkidEquipoDetalle;
    @JoinColumns({
        @JoinColumn(name = "Estado_pk_idEstado", referencedColumnName = "pk_idEstado", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", referencedColumnName = "Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Pasos_pk_idPaso", referencedColumnName = "Procedimientos_Pasos_pk_idPaso", insertable = false, updatable = false)
        , @JoinColumn(name = "Estado_Procedimientos_Diagnostico_parte_pk_idDianostico_parte", referencedColumnName = "Procedimientos_Diagnostico_parte_pk_idDianostico_parte", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Estado estado;
    @JoinColumn(name = "OrdenTrabajo_pk_idOrdenTrabajo", referencedColumnName = "pk_idOrdenTrabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajo;

    public Mantenimientodetalle() {
    }

    public Mantenimientodetalle(MantenimientodetallePK mantenimientodetallePK) {
        this.mantenimientodetallePK = mantenimientodetallePK;
    }

    public Mantenimientodetalle(MantenimientodetallePK mantenimientodetallePK, Date fecha) {
        this.mantenimientodetallePK = mantenimientodetallePK;
        this.fecha = fecha;
    }

    public Mantenimientodetalle(int pkidMantenimientodetallecol, int ordenTrabajopkidOrdenTrabajo, int estadopkidEstado, int estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, int estadoProcedimientosPasospkidPaso, int estadoProcedimientosDiagnosticopartepkidDianosticoparte) {
        this.mantenimientodetallePK = new MantenimientodetallePK(pkidMantenimientodetallecol, ordenTrabajopkidOrdenTrabajo, estadopkidEstado, estadoProcedimientosTipoprocedimientopkidTipoprocedimiento, estadoProcedimientosPasospkidPaso, estadoProcedimientosDiagnosticopartepkidDianosticoparte);
    }

    public MantenimientodetallePK getMantenimientodetallePK() {
        return mantenimientodetallePK;
    }

    public void setMantenimientodetallePK(MantenimientodetallePK mantenimientodetallePK) {
        this.mantenimientodetallePK = mantenimientodetallePK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Equipodetalle getEquipodetallepkidEquipoDetalle() {
        return equipodetallepkidEquipoDetalle;
    }

    public void setEquipodetallepkidEquipoDetalle(Equipodetalle equipodetallepkidEquipoDetalle) {
        this.equipodetallepkidEquipoDetalle = equipodetallepkidEquipoDetalle;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mantenimientodetallePK != null ? mantenimientodetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientodetalle)) {
            return false;
        }
        Mantenimientodetalle other = (Mantenimientodetalle) object;
        if ((this.mantenimientodetallePK == null && other.mantenimientodetallePK != null) || (this.mantenimientodetallePK != null && !this.mantenimientodetallePK.equals(other.mantenimientodetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.Mantenimientodetalle[ mantenimientodetallePK=" + mantenimientodetallePK + " ]";
    }
    
}
