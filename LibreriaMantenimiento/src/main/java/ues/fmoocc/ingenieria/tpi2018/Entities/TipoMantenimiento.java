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
import javax.persistence.JoinColumn;
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
@Table(name = "TipoMantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t")
    , @NamedQuery(name = "TipoMantenimiento.findByPkidTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.pkidTipoMantenimiento = :pkidTipoMantenimiento")
    , @NamedQuery(name = "TipoMantenimiento.findByDescripcion", query = "SELECT t FROM TipoMantenimiento t WHERE t.descripcion = :descripcion")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idTipoMantenimiento")
    private Integer pkidTipoMantenimiento;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMantenimientopkidTipoMantenimiento", fetch = FetchType.LAZY)
    private List<OrdenTrabajo> ordenTrabajoList;
    @JoinColumn(name = "Sub_TipoMantenimiento_pk_idSub_TipoMantenimiento", referencedColumnName = "pk_idSub_TipoMantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubTipoMantenimiento subTipoMantenimientopkidSubTipoMantenimiento;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer pkidTipoMantenimiento) {
        this.pkidTipoMantenimiento = pkidTipoMantenimiento;
    }

    public TipoMantenimiento(Integer pkidTipoMantenimiento, String descripcion) {
        this.pkidTipoMantenimiento = pkidTipoMantenimiento;
        this.descripcion = descripcion;
    }

    public Integer getPkidTipoMantenimiento() {
        return pkidTipoMantenimiento;
    }

    public void setPkidTipoMantenimiento(Integer pkidTipoMantenimiento) {
        this.pkidTipoMantenimiento = pkidTipoMantenimiento;
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

    public SubTipoMantenimiento getSubTipoMantenimientopkidSubTipoMantenimiento() {
        return subTipoMantenimientopkidSubTipoMantenimiento;
    }

    public void setSubTipoMantenimientopkidSubTipoMantenimiento(SubTipoMantenimiento subTipoMantenimientopkidSubTipoMantenimiento) {
        this.subTipoMantenimientopkidSubTipoMantenimiento = subTipoMantenimientopkidSubTipoMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidTipoMantenimiento != null ? pkidTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.pkidTipoMantenimiento == null && other.pkidTipoMantenimiento != null) || (this.pkidTipoMantenimiento != null && !this.pkidTipoMantenimiento.equals(other.pkidTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.TipoMantenimiento[ pkidTipoMantenimiento=" + pkidTipoMantenimiento + " ]";
    }
    
}
