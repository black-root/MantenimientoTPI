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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "Equipo_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipodetalle.findAll", query = "SELECT e FROM Equipodetalle e")
    , @NamedQuery(name = "Equipodetalle.findByPkidEquipoDetalle", query = "SELECT e FROM Equipodetalle e WHERE e.pkidEquipoDetalle = :pkidEquipoDetalle")
    , @NamedQuery(name = "Equipodetalle.findByNoSerie", query = "SELECT e FROM Equipodetalle e WHERE e.noSerie = :noSerie")
    , @NamedQuery(name = "Equipodetalle.findByNoInventario", query = "SELECT e FROM Equipodetalle e WHERE e.noInventario = :noInventario")
    , @NamedQuery(name = "Equipodetalle.findByPartNumber", query = "SELECT e FROM Equipodetalle e WHERE e.partNumber = :partNumber")
    , @NamedQuery(name = "Equipodetalle.findByModelo", query = "SELECT e FROM Equipodetalle e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Equipodetalle.findByHardwareSofware", query = "SELECT e FROM Equipodetalle e WHERE e.hardwareSofware = :hardwareSofware")
    , @NamedQuery(name = "Equipodetalle.findBySofware", query = "SELECT e FROM Equipodetalle e WHERE e.sofware = :sofware")
    , @NamedQuery(name = "Equipodetalle.findByVersion", query = "SELECT e FROM Equipodetalle e WHERE e.version = :version")
    , @NamedQuery(name = "Equipodetalle.findByArquitectura3264", query = "SELECT e FROM Equipodetalle e WHERE e.arquitectura3264 = :arquitectura3264")
    , @NamedQuery(name = "Equipodetalle.findByLicencia", query = "SELECT e FROM Equipodetalle e WHERE e.licencia = :licencia")})
public class Equipodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idEquipoDetalle")
    private Integer pkidEquipoDetalle;
    @Column(name = "noSerie")
    private String noSerie;
    @Column(name = "noInventario")
    private String noInventario;
    @Column(name = "partNumber")
    private String partNumber;
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "hardware_sofware")
    private boolean hardwareSofware;
    @Column(name = "sofware")
    private String sofware;
    @Column(name = "version")
    private String version;
    @Column(name = "arquitectura3264")
    private Boolean arquitectura3264;
    @Column(name = "licencia")
    private Boolean licencia;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkidEquipoDetalle")
    private Collection<Equipodetalle> equipodetalleCollection;
    @JoinColumn(name = "Equipo_detalle_pk_idEquipoDetalle", referencedColumnName = "pk_idEquipoDetalle")
    @ManyToOne(optional = false)
    private Equipodetalle equipodetallepkidEquipoDetalle;
    @JoinColumn(name = "fabricantes_idFabricante", referencedColumnName = "idFabricante")
    @ManyToOne(optional = false)
    private Fabricantes fabricantesidFabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkidEquipoDetalle")
    private Collection<Mantenimientodetalle> mantenimientodetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkidEquipoDetalle")
    private Collection<Diagnosticoparte> diagnosticoparteCollection;

    public Equipodetalle() {
    }

    public Equipodetalle(Integer pkidEquipoDetalle) {
        this.pkidEquipoDetalle = pkidEquipoDetalle;
    }

    public Equipodetalle(Integer pkidEquipoDetalle, boolean hardwareSofware) {
        this.pkidEquipoDetalle = pkidEquipoDetalle;
        this.hardwareSofware = hardwareSofware;
    }

    public Integer getPkidEquipoDetalle() {
        return pkidEquipoDetalle;
    }

    public void setPkidEquipoDetalle(Integer pkidEquipoDetalle) {
        this.pkidEquipoDetalle = pkidEquipoDetalle;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean getHardwareSofware() {
        return hardwareSofware;
    }

    public void setHardwareSofware(boolean hardwareSofware) {
        this.hardwareSofware = hardwareSofware;
    }

    public String getSofware() {
        return sofware;
    }

    public void setSofware(String sofware) {
        this.sofware = sofware;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getArquitectura3264() {
        return arquitectura3264;
    }

    public void setArquitectura3264(Boolean arquitectura3264) {
        this.arquitectura3264 = arquitectura3264;
    }

    public Boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(Boolean licencia) {
        this.licencia = licencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Equipodetalle> getEquipodetalleCollection() {
        return equipodetalleCollection;
    }

    public void setEquipodetalleCollection(Collection<Equipodetalle> equipodetalleCollection) {
        this.equipodetalleCollection = equipodetalleCollection;
    }

    public Equipodetalle getEquipodetallepkidEquipoDetalle() {
        return equipodetallepkidEquipoDetalle;
    }

    public void setEquipodetallepkidEquipoDetalle(Equipodetalle equipodetallepkidEquipoDetalle) {
        this.equipodetallepkidEquipoDetalle = equipodetallepkidEquipoDetalle;
    }

    public Fabricantes getFabricantesidFabricante() {
        return fabricantesidFabricante;
    }

    public void setFabricantesidFabricante(Fabricantes fabricantesidFabricante) {
        this.fabricantesidFabricante = fabricantesidFabricante;
    }

    @XmlTransient
    public Collection<Mantenimientodetalle> getMantenimientodetalleCollection() {
        return mantenimientodetalleCollection;
    }

    public void setMantenimientodetalleCollection(Collection<Mantenimientodetalle> mantenimientodetalleCollection) {
        this.mantenimientodetalleCollection = mantenimientodetalleCollection;
    }

    @XmlTransient
    public Collection<Diagnosticoparte> getDiagnosticoparteCollection() {
        return diagnosticoparteCollection;
    }

    public void setDiagnosticoparteCollection(Collection<Diagnosticoparte> diagnosticoparteCollection) {
        this.diagnosticoparteCollection = diagnosticoparteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidEquipoDetalle != null ? pkidEquipoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipodetalle)) {
            return false;
        }
        Equipodetalle other = (Equipodetalle) object;
        if ((this.pkidEquipoDetalle == null && other.pkidEquipoDetalle != null) || (this.pkidEquipoDetalle != null && !this.pkidEquipoDetalle.equals(other.pkidEquipoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.Equipodetalle[ pkidEquipoDetalle=" + pkidEquipoDetalle + " ]";
    }
    
}
