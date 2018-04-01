/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "OrdenTrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByPkidOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.pkidOrdenTrabajo = :pkidOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajo.findBySolicitudFecha", query = "SELECT o FROM OrdenTrabajo o WHERE o.solicitudFecha = :solicitudFecha")
    , @NamedQuery(name = "OrdenTrabajo.findByClienteNombre", query = "SELECT o FROM OrdenTrabajo o WHERE o.clienteNombre = :clienteNombre")
    , @NamedQuery(name = "OrdenTrabajo.findByClienteEmail", query = "SELECT o FROM OrdenTrabajo o WHERE o.clienteEmail = :clienteEmail")
    , @NamedQuery(name = "OrdenTrabajo.findByClienteTelefono", query = "SELECT o FROM OrdenTrabajo o WHERE o.clienteTelefono = :clienteTelefono")
    , @NamedQuery(name = "OrdenTrabajo.findByClienteDomicilio", query = "SELECT o FROM OrdenTrabajo o WHERE o.clienteDomicilio = :clienteDomicilio")
    , @NamedQuery(name = "OrdenTrabajo.findByEstado", query = "SELECT o FROM OrdenTrabajo o WHERE o.estado = :estado")
    , @NamedQuery(name = "OrdenTrabajo.findByOrdenTrabajoAprobadaFecha", query = "SELECT o FROM OrdenTrabajo o WHERE o.ordenTrabajoAprobadaFecha = :ordenTrabajoAprobadaFecha")
    , @NamedQuery(name = "OrdenTrabajo.findByPosibleFechaEntrega", query = "SELECT o FROM OrdenTrabajo o WHERE o.posibleFechaEntrega = :posibleFechaEntrega")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idOrdenTrabajo")
    private Integer pkidOrdenTrabajo;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitudDescripcion")
    private String solicitudDescripcion;
    @Column(name = "solicitudFecha")
    @Temporal(TemporalType.DATE)
    private Date solicitudFecha;
    @Size(max = 45)
    @Column(name = "clienteNombre")
    private String clienteNombre;
    @Size(max = 45)
    @Column(name = "clienteEmail")
    private String clienteEmail;
    @Size(max = 15)
    @Column(name = "clienteTelefono")
    private String clienteTelefono;
    @Size(max = 45)
    @Column(name = "clienteDomicilio")
    private String clienteDomicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @Column(name = "ordenTrabajoAprobadaFecha")
    @Temporal(TemporalType.DATE)
    private Date ordenTrabajoAprobadaFecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "tecnicoDiagnostico")
    private String tecnicoDiagnostico;
    @Column(name = "posibleFechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date posibleFechaEntrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo", fetch = FetchType.LAZY)
    private List<Mantenimientodetalle> mantenimientodetalleList;
    @JoinColumn(name = "Prioridad_pk_idPrioridad", referencedColumnName = "pk_idPrioridad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Prioridad prioridadpkidPrioridad;
    @JoinColumn(name = "Solicitud_pk_idSolicitud", referencedColumnName = "pk_idSolicitud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitud solicitudpkidSolicitud;
    @JoinColumn(name = "TipoMantenimiento_pk_idTipoMantenimiento", referencedColumnName = "pk_idTipoMantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMantenimiento tipoMantenimientopkidTipoMantenimiento;
    @JoinColumn(name = "Unidad_pk_idUnidad", referencedColumnName = "pk_idUnidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unidad unidadpkidUnidad;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer pkidOrdenTrabajo) {
        this.pkidOrdenTrabajo = pkidOrdenTrabajo;
    }

    public OrdenTrabajo(Integer pkidOrdenTrabajo, boolean estado) {
        this.pkidOrdenTrabajo = pkidOrdenTrabajo;
        this.estado = estado;
    }

    public Integer getPkidOrdenTrabajo() {
        return pkidOrdenTrabajo;
    }

    public void setPkidOrdenTrabajo(Integer pkidOrdenTrabajo) {
        this.pkidOrdenTrabajo = pkidOrdenTrabajo;
    }

    public String getSolicitudDescripcion() {
        return solicitudDescripcion;
    }

    public void setSolicitudDescripcion(String solicitudDescripcion) {
        this.solicitudDescripcion = solicitudDescripcion;
    }

    public Date getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Date solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(String clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public String getClienteDomicilio() {
        return clienteDomicilio;
    }

    public void setClienteDomicilio(String clienteDomicilio) {
        this.clienteDomicilio = clienteDomicilio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getOrdenTrabajoAprobadaFecha() {
        return ordenTrabajoAprobadaFecha;
    }

    public void setOrdenTrabajoAprobadaFecha(Date ordenTrabajoAprobadaFecha) {
        this.ordenTrabajoAprobadaFecha = ordenTrabajoAprobadaFecha;
    }

    public String getTecnicoDiagnostico() {
        return tecnicoDiagnostico;
    }

    public void setTecnicoDiagnostico(String tecnicoDiagnostico) {
        this.tecnicoDiagnostico = tecnicoDiagnostico;
    }

    public Date getPosibleFechaEntrega() {
        return posibleFechaEntrega;
    }

    public void setPosibleFechaEntrega(Date posibleFechaEntrega) {
        this.posibleFechaEntrega = posibleFechaEntrega;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mantenimientodetalle> getMantenimientodetalleList() {
        return mantenimientodetalleList;
    }

    public void setMantenimientodetalleList(List<Mantenimientodetalle> mantenimientodetalleList) {
        this.mantenimientodetalleList = mantenimientodetalleList;
    }

    public Prioridad getPrioridadpkidPrioridad() {
        return prioridadpkidPrioridad;
    }

    public void setPrioridadpkidPrioridad(Prioridad prioridadpkidPrioridad) {
        this.prioridadpkidPrioridad = prioridadpkidPrioridad;
    }

    public Solicitud getSolicitudpkidSolicitud() {
        return solicitudpkidSolicitud;
    }

    public void setSolicitudpkidSolicitud(Solicitud solicitudpkidSolicitud) {
        this.solicitudpkidSolicitud = solicitudpkidSolicitud;
    }

    public TipoMantenimiento getTipoMantenimientopkidTipoMantenimiento() {
        return tipoMantenimientopkidTipoMantenimiento;
    }

    public void setTipoMantenimientopkidTipoMantenimiento(TipoMantenimiento tipoMantenimientopkidTipoMantenimiento) {
        this.tipoMantenimientopkidTipoMantenimiento = tipoMantenimientopkidTipoMantenimiento;
    }

    public Unidad getUnidadpkidUnidad() {
        return unidadpkidUnidad;
    }

    public void setUnidadpkidUnidad(Unidad unidadpkidUnidad) {
        this.unidadpkidUnidad = unidadpkidUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidOrdenTrabajo != null ? pkidOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.pkidOrdenTrabajo == null && other.pkidOrdenTrabajo != null) || (this.pkidOrdenTrabajo != null && !this.pkidOrdenTrabajo.equals(other.pkidOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo[ pkidOrdenTrabajo=" + pkidOrdenTrabajo + " ]";
    }
    
}
