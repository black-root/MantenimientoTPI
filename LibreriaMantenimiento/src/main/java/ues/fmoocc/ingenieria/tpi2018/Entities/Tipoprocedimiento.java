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
import javax.persistence.Lob;
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
@Table(name = "Tipo_procedimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoprocedimiento.findAll", query = "SELECT t FROM Tipoprocedimiento t")
    , @NamedQuery(name = "Tipoprocedimiento.findByPkidTipoprocedimiento", query = "SELECT t FROM Tipoprocedimiento t WHERE t.pkidTipoprocedimiento = :pkidTipoprocedimiento")
    , @NamedQuery(name = "Tipoprocedimiento.findByDescripcion", query = "SELECT t FROM Tipoprocedimiento t WHERE t.descripcion = :descripcion")})
public class Tipoprocedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idTipo_procedimiento")
    private Integer pkidTipoprocedimiento;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoprocedimiento", fetch = FetchType.LAZY)
    private List<Procedimientos> procedimientosList;

    public Tipoprocedimiento() {
    }

    public Tipoprocedimiento(Integer pkidTipoprocedimiento) {
        this.pkidTipoprocedimiento = pkidTipoprocedimiento;
    }

    public Tipoprocedimiento(Integer pkidTipoprocedimiento, String descripcion) {
        this.pkidTipoprocedimiento = pkidTipoprocedimiento;
        this.descripcion = descripcion;
    }

    public Integer getPkidTipoprocedimiento() {
        return pkidTipoprocedimiento;
    }

    public void setPkidTipoprocedimiento(Integer pkidTipoprocedimiento) {
        this.pkidTipoprocedimiento = pkidTipoprocedimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Procedimientos> getProcedimientosList() {
        return procedimientosList;
    }

    public void setProcedimientosList(List<Procedimientos> procedimientosList) {
        this.procedimientosList = procedimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidTipoprocedimiento != null ? pkidTipoprocedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoprocedimiento)) {
            return false;
        }
        Tipoprocedimiento other = (Tipoprocedimiento) object;
        if ((this.pkidTipoprocedimiento == null && other.pkidTipoprocedimiento != null) || (this.pkidTipoprocedimiento != null && !this.pkidTipoprocedimiento.equals(other.pkidTipoprocedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento[ pkidTipoprocedimiento=" + pkidTipoprocedimiento + " ]";
    }
    
}
