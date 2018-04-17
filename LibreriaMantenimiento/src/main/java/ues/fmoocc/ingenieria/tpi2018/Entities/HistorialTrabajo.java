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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "HistorialTrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialTrabajo.findAll", query = "SELECT h FROM HistorialTrabajo h")
    , @NamedQuery(name = "HistorialTrabajo.findByPkidHistorialTrabajo", query = "SELECT h FROM HistorialTrabajo h WHERE h.pkidHistorialTrabajo = :pkidHistorialTrabajo")
    , @NamedQuery(name = "HistorialTrabajo.findByFechaInicio", query = "SELECT h FROM HistorialTrabajo h WHERE h.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "HistorialTrabajo.findByFechaFin", query = "SELECT h FROM HistorialTrabajo h WHERE h.fechaFin = :fechaFin")})
public class HistorialTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idHistorialTrabajo")
    private Integer pkidHistorialTrabajo;
    @Basic(optional = false)
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "Personal_pk_idPersonal", referencedColumnName = "pk_idPersonal")
    @ManyToOne(optional = false)
    private Personal personalpkidPersonal;
    @JoinColumn(name = "Rol_pk_idRol", referencedColumnName = "pk_idRol")
    @ManyToOne(optional = false)
    private Rol rolpkidRol;

    public HistorialTrabajo() {
    }

    public HistorialTrabajo(Integer pkidHistorialTrabajo) {
        this.pkidHistorialTrabajo = pkidHistorialTrabajo;
    }

    public HistorialTrabajo(Integer pkidHistorialTrabajo, Date fechaInicio) {
        this.pkidHistorialTrabajo = pkidHistorialTrabajo;
        this.fechaInicio = fechaInicio;
    }

    public Integer getPkidHistorialTrabajo() {
        return pkidHistorialTrabajo;
    }

    public void setPkidHistorialTrabajo(Integer pkidHistorialTrabajo) {
        this.pkidHistorialTrabajo = pkidHistorialTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Personal getPersonalpkidPersonal() {
        return personalpkidPersonal;
    }

    public void setPersonalpkidPersonal(Personal personalpkidPersonal) {
        this.personalpkidPersonal = personalpkidPersonal;
    }

    public Rol getRolpkidRol() {
        return rolpkidRol;
    }

    public void setRolpkidRol(Rol rolpkidRol) {
        this.rolpkidRol = rolpkidRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidHistorialTrabajo != null ? pkidHistorialTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialTrabajo)) {
            return false;
        }
        HistorialTrabajo other = (HistorialTrabajo) object;
        if ((this.pkidHistorialTrabajo == null && other.pkidHistorialTrabajo != null) || (this.pkidHistorialTrabajo != null && !this.pkidHistorialTrabajo.equals(other.pkidHistorialTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.HistorialTrabajo[ pkidHistorialTrabajo=" + pkidHistorialTrabajo + " ]";
    }
    
}
