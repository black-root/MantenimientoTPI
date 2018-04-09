/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(catalog = "mantenimientoPC", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByPkidTelefono", query = "SELECT t FROM Telefono t WHERE t.pkidTelefono = :pkidTelefono")
    , @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idTelefono", nullable = false)
    private Integer pkidTelefono;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String telefono;
    @JoinColumn(name = "Personal_pk_idPersonal", referencedColumnName = "pk_idPersonal", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personal personalpkidPersonal;

    public Telefono() {
    }

    public Telefono(Integer pkidTelefono) {
        this.pkidTelefono = pkidTelefono;
    }

    public Telefono(Integer pkidTelefono, String telefono) {
        this.pkidTelefono = pkidTelefono;
        this.telefono = telefono;
    }

    public Integer getPkidTelefono() {
        return pkidTelefono;
    }

    public void setPkidTelefono(Integer pkidTelefono) {
        this.pkidTelefono = pkidTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Personal getPersonalpkidPersonal() {
        return personalpkidPersonal;
    }

    public void setPersonalpkidPersonal(Personal personalpkidPersonal) {
        this.personalpkidPersonal = personalpkidPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidTelefono != null ? pkidTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.pkidTelefono == null && other.pkidTelefono != null) || (this.pkidTelefono != null && !this.pkidTelefono.equals(other.pkidTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Telefono[ pkidTelefono=" + pkidTelefono + " ]";
    }
    
}
