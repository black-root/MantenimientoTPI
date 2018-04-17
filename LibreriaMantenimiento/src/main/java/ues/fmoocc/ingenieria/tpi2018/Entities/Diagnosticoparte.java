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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "Diagnostico_parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosticoparte.findAll", query = "SELECT d FROM Diagnosticoparte d")
    , @NamedQuery(name = "Diagnosticoparte.findByPkidDianosticoparte", query = "SELECT d FROM Diagnosticoparte d WHERE d.pkidDianosticoparte = :pkidDianosticoparte")
    , @NamedQuery(name = "Diagnosticoparte.findByDescripcion", query = "SELECT d FROM Diagnosticoparte d WHERE d.descripcion = :descripcion")})
public class Diagnosticoparte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idDianostico_parte")
    private Integer pkidDianosticoparte;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Equipo_detalle_pk_idEquipoDetalle", referencedColumnName = "pk_idEquipoDetalle")
    @ManyToOne(optional = false)
    private Equipodetalle equipodetallepkidEquipoDetalle;
    @JoinColumns({
        @JoinColumn(name = "Diagnostico_pK_idDiagnostico", referencedColumnName = "pK_idDiagnostico")
        , @JoinColumn(name = "Diagnostico_OrdenTrabajo_pk_idOrdenTrabajo", referencedColumnName = "OrdenTrabajo_pk_idOrdenTrabajo")})
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnosticoparte")
    private Collection<Procedimientos> procedimientosCollection;

    public Diagnosticoparte() {
    }

    public Diagnosticoparte(Integer pkidDianosticoparte) {
        this.pkidDianosticoparte = pkidDianosticoparte;
    }

    public Diagnosticoparte(Integer pkidDianosticoparte, String descripcion) {
        this.pkidDianosticoparte = pkidDianosticoparte;
        this.descripcion = descripcion;
    }

    public Integer getPkidDianosticoparte() {
        return pkidDianosticoparte;
    }

    public void setPkidDianosticoparte(Integer pkidDianosticoparte) {
        this.pkidDianosticoparte = pkidDianosticoparte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipodetalle getEquipodetallepkidEquipoDetalle() {
        return equipodetallepkidEquipoDetalle;
    }

    public void setEquipodetallepkidEquipoDetalle(Equipodetalle equipodetallepkidEquipoDetalle) {
        this.equipodetallepkidEquipoDetalle = equipodetallepkidEquipoDetalle;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
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
        hash += (pkidDianosticoparte != null ? pkidDianosticoparte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosticoparte)) {
            return false;
        }
        Diagnosticoparte other = (Diagnosticoparte) object;
        if ((this.pkidDianosticoparte == null && other.pkidDianosticoparte != null) || (this.pkidDianosticoparte != null && !this.pkidDianosticoparte.equals(other.pkidDianosticoparte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Diagnosticoparte[ pkidDianosticoparte=" + pkidDianosticoparte + " ]";
    }
    
}
