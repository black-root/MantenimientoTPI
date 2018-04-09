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
@Table(name = "Sub_TipoMantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubTipoMantenimiento.findAll", query = "SELECT s FROM SubTipoMantenimiento s")
    , @NamedQuery(name = "SubTipoMantenimiento.findByPkidSubTipoMantenimiento", query = "SELECT s FROM SubTipoMantenimiento s WHERE s.pkidSubTipoMantenimiento = :pkidSubTipoMantenimiento")
    , @NamedQuery(name = "SubTipoMantenimiento.findByDescripcion", query = "SELECT s FROM SubTipoMantenimiento s WHERE s.descripcion = :descripcion")})
public class SubTipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idSub_TipoMantenimiento")
    private Integer pkidSubTipoMantenimiento;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subTipoMantenimientopkidSubTipoMantenimiento", fetch = FetchType.LAZY)
    private List<TipoMantenimiento> tipoMantenimientoList;

    public SubTipoMantenimiento() {
    }

    public SubTipoMantenimiento(Integer pkidSubTipoMantenimiento) {
        this.pkidSubTipoMantenimiento = pkidSubTipoMantenimiento;
    }

    public SubTipoMantenimiento(Integer pkidSubTipoMantenimiento, String descripcion) {
        this.pkidSubTipoMantenimiento = pkidSubTipoMantenimiento;
        this.descripcion = descripcion;
    }

    public Integer getPkidSubTipoMantenimiento() {
        return pkidSubTipoMantenimiento;
    }

    public void setPkidSubTipoMantenimiento(Integer pkidSubTipoMantenimiento) {
        this.pkidSubTipoMantenimiento = pkidSubTipoMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoMantenimiento> getTipoMantenimientoList() {
        return tipoMantenimientoList;
    }

    public void setTipoMantenimientoList(List<TipoMantenimiento> tipoMantenimientoList) {
        this.tipoMantenimientoList = tipoMantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidSubTipoMantenimiento != null ? pkidSubTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubTipoMantenimiento)) {
            return false;
        }
        SubTipoMantenimiento other = (SubTipoMantenimiento) object;
        if ((this.pkidSubTipoMantenimiento == null && other.pkidSubTipoMantenimiento != null) || (this.pkidSubTipoMantenimiento != null && !this.pkidSubTipoMantenimiento.equals(other.pkidSubTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento[ pkidSubTipoMantenimiento=" + pkidSubTipoMantenimiento + " ]";
    }
    
}
