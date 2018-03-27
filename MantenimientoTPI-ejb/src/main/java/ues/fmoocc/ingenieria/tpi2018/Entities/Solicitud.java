/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByPkidSolicitud", query = "SELECT s FROM Solicitud s WHERE s.pkidSolicitud = :pkidSolicitud")
    , @NamedQuery(name = "Solicitud.findBySolicitante", query = "SELECT s FROM Solicitud s WHERE s.solicitante = :solicitante")
    , @NamedQuery(name = "Solicitud.findByCorreo", query = "SELECT s FROM Solicitud s WHERE s.correo = :correo")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idSolicitud")
    private Integer pkidSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "solicitante")
    private String solicitante;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 150)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudpkidSolicitud", fetch = FetchType.LAZY)
    private List<OrdenTrabajo> ordenTrabajoList;

    public Solicitud() {
    }

    public Solicitud(Integer pkidSolicitud) {
        this.pkidSolicitud = pkidSolicitud;
    }

    public Solicitud(Integer pkidSolicitud, String solicitante) {
        this.pkidSolicitud = pkidSolicitud;
        this.solicitante = solicitante;
    }

    public Integer getPkidSolicitud() {
        return pkidSolicitud;
    }

    public void setPkidSolicitud(Integer pkidSolicitud) {
        this.pkidSolicitud = pkidSolicitud;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    @JsonIgnore
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidSolicitud != null ? pkidSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.pkidSolicitud == null && other.pkidSolicitud != null) || (this.pkidSolicitud != null && !this.pkidSolicitud.equals(other.pkidSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud[ pkidSolicitud=" + pkidSolicitud + " ]";
    }
    
}
