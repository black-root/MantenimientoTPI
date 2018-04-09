/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByPkidRol", query = "SELECT r FROM Rol r WHERE r.pkidRol = :pkidRol")
    , @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idRol")
    private Integer pkidRol;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolpkidRol", fetch = FetchType.LAZY)
    private List<HistorialTrabajo> historialTrabajoList;

    public Rol() {
    }

    public Rol(Integer pkidRol) {
        this.pkidRol = pkidRol;
    }

    public Rol(Integer pkidRol, String descripcion) {
        this.pkidRol = pkidRol;
        this.descripcion = descripcion;
    }

    public Integer getPkidRol() {
        return pkidRol;
    }

    public void setPkidRol(Integer pkidRol) {
        this.pkidRol = pkidRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<HistorialTrabajo> getHistorialTrabajoList() {
        return historialTrabajoList;
    }

    public void setHistorialTrabajoList(List<HistorialTrabajo> historialTrabajoList) {
        this.historialTrabajoList = historialTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidRol != null ? pkidRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.pkidRol == null && other.pkidRol != null) || (this.pkidRol != null && !this.pkidRol.equals(other.pkidRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Rol[ pkidRol=" + pkidRol + " ]";
    }
    
}
