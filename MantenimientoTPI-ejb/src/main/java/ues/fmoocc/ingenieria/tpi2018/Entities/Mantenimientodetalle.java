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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Mantenimiento_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientodetalle.findAll", query = "SELECT m FROM Mantenimientodetalle m")
    , @NamedQuery(name = "Mantenimientodetalle.findByPkidMantenimientodetallecol", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.pkidMantenimientodetallecol = :pkidMantenimientodetallecol")
    , @NamedQuery(name = "Mantenimientodetalle.findByFecha", query = "SELECT m FROM Mantenimientodetalle m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimientodetalle.findByOrdenTrabajopkidOrdenTrabajo", query = "SELECT m FROM Mantenimientodetalle m WHERE m.mantenimientodetallePK.ordenTrabajopkidOrdenTrabajo = :ordenTrabajopkidOrdenTrabajo")})
public class Mantenimientodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MantenimientodetallePK mantenimientodetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "Equipo_detalle_pk_EDnoSerie", referencedColumnName = "pk_EDnoSerie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipodetalle equipodetallepkEDnoSerie;
    @JoinColumns({
        @JoinColumn(name = "Estado_pk_idEstado", referencedColumnName = "pk_idEstado")
        , @JoinColumn(name = "Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", referencedColumnName = "Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento")
        , @JoinColumn(name = "Estado_Procedimientos_Pasos_pk_idPaso", referencedColumnName = "Procedimientos_Pasos_pk_idPaso")
        , @JoinColumn(name = "Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte", referencedColumnName = "Procedimientos_Dianostico_parte_pk_idDianostico_parte")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estado estado;
    @JoinColumn(name = "OrdenTrabajo_pk_idOrdenTrabajo", referencedColumnName = "pk_idOrdenTrabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    public Mantenimientodetalle(int pkidMantenimientodetallecol, int ordenTrabajopkidOrdenTrabajo) {
        this.mantenimientodetallePK = new MantenimientodetallePK(pkidMantenimientodetallecol, ordenTrabajopkidOrdenTrabajo);
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

    public Equipodetalle getEquipodetallepkEDnoSerie() {
        return equipodetallepkEDnoSerie;
    }

    public void setEquipodetallepkEDnoSerie(Equipodetalle equipodetallepkEDnoSerie) {
        this.equipodetallepkEDnoSerie = equipodetallepkEDnoSerie;
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
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Mantenimientodetalle[ mantenimientodetallePK=" + mantenimientodetallePK + " ]";
    }
    
}
