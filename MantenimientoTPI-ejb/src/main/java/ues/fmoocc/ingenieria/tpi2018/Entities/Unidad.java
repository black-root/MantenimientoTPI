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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u")
    , @NamedQuery(name = "Unidad.findByPkidUnidad", query = "SELECT u FROM Unidad u WHERE u.pkidUnidad = :pkidUnidad")
    , @NamedQuery(name = "Unidad.findByUnidadNombre", query = "SELECT u FROM Unidad u WHERE u.unidadNombre = :unidadNombre")
    , @NamedQuery(name = "Unidad.findByDescripcion", query = "SELECT u FROM Unidad u WHERE u.descripcion = :descripcion")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idUnidad")
    private Integer pkidUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "UnidadNombre")
    private String unidadNombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadpkidUnidad", fetch = FetchType.LAZY)
    private List<OrdenTrabajo> ordenTrabajoList;

    public Unidad() {
    }

    public Unidad(Integer pkidUnidad) {
        this.pkidUnidad = pkidUnidad;
    }

    public Unidad(Integer pkidUnidad, String unidadNombre) {
        this.pkidUnidad = pkidUnidad;
        this.unidadNombre = unidadNombre;
    }

    public Integer getPkidUnidad() {
        return pkidUnidad;
    }

    public void setPkidUnidad(Integer pkidUnidad) {
        this.pkidUnidad = pkidUnidad;
    }

    public String getUnidadNombre() {
        return unidadNombre;
    }

    public void setUnidadNombre(String unidadNombre) {
        this.unidadNombre = unidadNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidUnidad != null ? pkidUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.pkidUnidad == null && other.pkidUnidad != null) || (this.pkidUnidad != null && !this.pkidUnidad.equals(other.pkidUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Unidad[ pkidUnidad=" + pkidUnidad + " ]";
    }
    
}
