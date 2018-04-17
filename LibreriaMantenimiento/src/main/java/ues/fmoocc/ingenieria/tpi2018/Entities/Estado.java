/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByPkidEstado", query = "SELECT e FROM Estado e WHERE e.estadoPK.pkidEstado = :pkidEstado")
    , @NamedQuery(name = "Estado.findByNombre", query = "SELECT e FROM Estado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estado.findByProcedimientosTipoprocedimientopkidTipoprocedimiento", query = "SELECT e FROM Estado e WHERE e.estadoPK.procedimientosTipoprocedimientopkidTipoprocedimiento = :procedimientosTipoprocedimientopkidTipoprocedimiento")
    , @NamedQuery(name = "Estado.findByProcedimientosPasospkidPaso", query = "SELECT e FROM Estado e WHERE e.estadoPK.procedimientosPasospkidPaso = :procedimientosPasospkidPaso")
    , @NamedQuery(name = "Estado.findByProcedimientosDiagnosticopartepkidDianosticoparte", query = "SELECT e FROM Estado e WHERE e.estadoPK.procedimientosDiagnosticopartepkidDianosticoparte = :procedimientosDiagnosticopartepkidDianosticoparte")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoPK estadoPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Mantenimientodetalle> mantenimientodetalleCollection;
    @JoinColumns({
        @JoinColumn(name = "Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento", referencedColumnName = "Tipo_procedimiento_pk_idTipo_procedimiento", insertable = false, updatable = false)
        , @JoinColumn(name = "Procedimientos_Pasos_pk_idPaso", referencedColumnName = "Pasos_pk_idPaso", insertable = false, updatable = false)
        , @JoinColumn(name = "Procedimientos_Diagnostico_parte_pk_idDianostico_parte", referencedColumnName = "Diagnostico_parte_pk_idDianostico_parte", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Procedimientos procedimientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Estadodetalle> estadodetalleCollection;

    public Estado() {
    }

    public Estado(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public Estado(EstadoPK estadoPK, String nombre) {
        this.estadoPK = estadoPK;
        this.nombre = nombre;
    }

    public Estado(int pkidEstado, int procedimientosTipoprocedimientopkidTipoprocedimiento, int procedimientosPasospkidPaso, int procedimientosDiagnosticopartepkidDianosticoparte) {
        this.estadoPK = new EstadoPK(pkidEstado, procedimientosTipoprocedimientopkidTipoprocedimiento, procedimientosPasospkidPaso, procedimientosDiagnosticopartepkidDianosticoparte);
    }

    public EstadoPK getEstadoPK() {
        return estadoPK;
    }

    public void setEstadoPK(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Mantenimientodetalle> getMantenimientodetalleCollection() {
        return mantenimientodetalleCollection;
    }

    public void setMantenimientodetalleCollection(Collection<Mantenimientodetalle> mantenimientodetalleCollection) {
        this.mantenimientodetalleCollection = mantenimientodetalleCollection;
    }

    public Procedimientos getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(Procedimientos procedimientos) {
        this.procedimientos = procedimientos;
    }

    @XmlTransient
    public Collection<Estadodetalle> getEstadodetalleCollection() {
        return estadodetalleCollection;
    }

    public void setEstadodetalleCollection(Collection<Estadodetalle> estadodetalleCollection) {
        this.estadodetalleCollection = estadodetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoPK != null ? estadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoPK == null && other.estadoPK != null) || (this.estadoPK != null && !this.estadoPK.equals(other.estadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Estado[ estadoPK=" + estadoPK + " ]";
    }
    
}
