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
import javax.persistence.Entity;
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
@Table(name = "Pasos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasos.findAll", query = "SELECT p FROM Pasos p")
    , @NamedQuery(name = "Pasos.findByPkidPaso", query = "SELECT p FROM Pasos p WHERE p.pkidPaso = :pkidPaso")
    , @NamedQuery(name = "Pasos.findByDescripcion", query = "SELECT p FROM Pasos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pasos.findByDuracionPaso", query = "SELECT p FROM Pasos p WHERE p.duracionPaso = :duracionPaso")})
public class Pasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPaso")
    private Integer pkidPaso;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "duracion_Paso")
    private String duracionPaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasos")
    private Collection<Procedimientos> procedimientosCollection;

    public Pasos() {
    }

    public Pasos(Integer pkidPaso) {
        this.pkidPaso = pkidPaso;
    }

    public Pasos(Integer pkidPaso, String descripcion) {
        this.pkidPaso = pkidPaso;
        this.descripcion = descripcion;
    }

    public Integer getPkidPaso() {
        return pkidPaso;
    }

    public void setPkidPaso(Integer pkidPaso) {
        this.pkidPaso = pkidPaso;
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

    public String getDuracionPaso() {
        return duracionPaso;
    }

    public void setDuracionPaso(String duracionPaso) {
        this.duracionPaso = duracionPaso;
    }

    @XmlTransient
    public Collection<Procedimientos> getProcedimientosCollection() {
        return procedimientosCollection;
    }

    public void setProcedimientosCollection(Collection<Procedimientos> procedimientosCollection) {
        this.procedimientosCollection = procedimientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPaso != null ? pkidPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasos)) {
            return false;
        }
        Pasos other = (Pasos) object;
        if ((this.pkidPaso == null && other.pkidPaso != null) || (this.pkidPaso != null && !this.pkidPaso.equals(other.pkidPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Pasos[ pkidPaso=" + pkidPaso + " ]";
    }
    
}
