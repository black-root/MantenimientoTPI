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
 * @author sergio
 */
@Entity
@Table(name = "Dianostico_parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dianosticoparte.findAll", query = "SELECT d FROM Dianosticoparte d")
    , @NamedQuery(name = "Dianosticoparte.findByPkidDianosticoparte", query = "SELECT d FROM Dianosticoparte d WHERE d.pkidDianosticoparte = :pkidDianosticoparte")
    , @NamedQuery(name = "Dianosticoparte.findByDescripcion", query = "SELECT d FROM Dianosticoparte d WHERE d.descripcion = :descripcion")})
public class Dianosticoparte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idDianostico_parte")
    private Integer pkidDianosticoparte;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumns({
        @JoinColumn(name = "Diagnostico_pK_idDiagnostico", referencedColumnName = "pK_idDiagnostico")
        , @JoinColumn(name = "Diagnostico_OrdenTrabajo_pk_idOrdenTrabajo", referencedColumnName = "OrdenTrabajo_pk_idOrdenTrabajo")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Diagnostico diagnostico;
    @JoinColumn(name = "Equipo_detalle_pk_EDnoSerie", referencedColumnName = "pk_EDnoSerie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipodetalle equipodetallepkEDnoSerie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dianosticoparte", fetch = FetchType.LAZY)
    private List<Procedimientos> procedimientosList;

    public Dianosticoparte() {
    }

    public Dianosticoparte(Integer pkidDianosticoparte) {
        this.pkidDianosticoparte = pkidDianosticoparte;
    }

    public Dianosticoparte(Integer pkidDianosticoparte, String descripcion) {
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

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Equipodetalle getEquipodetallepkEDnoSerie() {
        return equipodetallepkEDnoSerie;
    }

    public void setEquipodetallepkEDnoSerie(Equipodetalle equipodetallepkEDnoSerie) {
        this.equipodetallepkEDnoSerie = equipodetallepkEDnoSerie;
    }

    @XmlTransient
    @JsonIgnore
    public List<Procedimientos> getProcedimientosList() {
        return procedimientosList;
    }

    public void setProcedimientosList(List<Procedimientos> procedimientosList) {
        this.procedimientosList = procedimientosList;
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
        if (!(object instanceof Dianosticoparte)) {
            return false;
        }
        Dianosticoparte other = (Dianosticoparte) object;
        if ((this.pkidDianosticoparte == null && other.pkidDianosticoparte != null) || (this.pkidDianosticoparte != null && !this.pkidDianosticoparte.equals(other.pkidDianosticoparte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Dianosticoparte[ pkidDianosticoparte=" + pkidDianosticoparte + " ]";
    }
    
}
