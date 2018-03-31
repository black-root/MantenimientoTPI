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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByPkidPrioridad", query = "SELECT p FROM Prioridad p WHERE p.pkidPrioridad = :pkidPrioridad")
    , @NamedQuery(name = "Prioridad.findByPrioridadNivel", query = "SELECT p FROM Prioridad p WHERE p.prioridadNivel = :prioridadNivel")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPrioridad")
    private Integer pkidPrioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PrioridadNivel")
    private String prioridadNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prioridadpkidPrioridad", fetch = FetchType.LAZY)
    private List<OrdenTrabajo> ordenTrabajoList;

    public Prioridad() {
    }

    public Prioridad(Integer pkidPrioridad) {
        this.pkidPrioridad = pkidPrioridad;
    }

    public Prioridad(Integer pkidPrioridad, String prioridadNivel) {
        this.pkidPrioridad = pkidPrioridad;
        this.prioridadNivel = prioridadNivel;
    }

    public Integer getPkidPrioridad() {
        return pkidPrioridad;
    }

    public void setPkidPrioridad(Integer pkidPrioridad) {
        this.pkidPrioridad = pkidPrioridad;
    }

    public String getPrioridadNivel() {
        return prioridadNivel;
    }

    public void setPrioridadNivel(String prioridadNivel) {
        this.prioridadNivel = prioridadNivel;
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
        hash += (pkidPrioridad != null ? pkidPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.pkidPrioridad == null && other.pkidPrioridad != null) || (this.pkidPrioridad != null && !this.pkidPrioridad.equals(other.pkidPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad[ pkidPrioridad=" + pkidPrioridad + " ]";
    }
    
}
